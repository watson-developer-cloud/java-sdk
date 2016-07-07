/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.speech_to_text.v1.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ws.WebSocket;
import okhttp3.ws.WebSocketCall;
import okhttp3.ws.WebSocketListener;
import okio.Buffer;

/**
 * Manages Speech to text recognition over WebSockets.<br>
 * This class is in charge of opening a {@link WebSocket} connection, stream audio to the API and
 * close the connection once the audio was transmitted.
 */
public class WebSocketManager {
  private final String url;
  private final OkHttpClient client;
  private String token;

  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private static final Logger LOG = Logger.getLogger(WebSocketManager.class.getName());


  /**
   * The listener interface for receiving {@link WebSocket} events. <br>
   * The class that is interested in processing a event implements this interface. When the event
   * occurs, that object's appropriate method is invoked.
   *
   * @see SpeechToText
   */
  private class SpeechToTextWebSocketListener implements WebSocketListener {

    private static final String STATE = "state";
    private static final String MODEL = "model";
    private static final String START = "start";
    private static final String STOP = "stop";
    private static final String ACTION = "action";
    private static final int FOUR_KB = 4096;
    private static final String ERROR = "error";
    private static final String RESULTS = "results";
    private static final String TIMEOUT_PREFIX = "No speech detected for";

    private final InputStream stream;
    private final RecognizeOptions options;
    private final RecognizeCallback callback;
    private WebSocket socket;
    private boolean socketOpen = true;
    private Thread audioThread = null;
    private int CLOSE_NORMAL = 1000;

    /**
     * Instantiates a new speech to text web socket listener.
     *
     * @param stream the {@link InputStream} where the audio to recognize is
     * @param options the recognize options
     * @param callback the callback
     */
    public SpeechToTextWebSocketListener(final InputStream stream, final RecognizeOptions options,
        final RecognizeCallback callback) {
      this.stream = stream;
      this.options = options;
      this.callback = callback;
    }

    /*
     * (non-Javadoc)
     * 
     * @see okhttp3.ws.WebSocketListener#onClose(int, java.lang.String)
     */
    @Override
    public void onClose(int code, String reason) {
      socketOpen = false;
      callback.onDisconnected();
    }

    /*
     * (non-Javadoc)
     * 
     * @see okhttp3.ws.WebSocketListener#onFailure(java.io.IOException, okhttp3.Response)
     */
    @Override
    public void onFailure(IOException e, Response response) {
      socketOpen = false;
      callback.onError(e);
    }

    /*
     * (non-Javadoc)
     * 
     * @see okhttp3.ws.WebSocketListener#onMessage(okhttp3.ResponseBody)
     */
    @Override
    public void onMessage(ResponseBody response) throws IOException {
      String message = response.string();

      JsonObject json = new JsonParser().parse(message).getAsJsonObject();
      if (json.has(ERROR)) {
        String error = json.get(ERROR).getAsString();

        // Only call onError() if a real error occured. The STT service sends
        // {"error" : "No speech detected for 5s"} for valid timeouts, configured by
        // RecognizeOptions.Builder.inactivityTimeout()
        if(!error.startsWith(TIMEOUT_PREFIX)) {
          callback.onError(new RuntimeException(error));
        }
      } else if (json.has(RESULTS)) {
        callback.onTranscription(GSON.fromJson(message, SpeechResults.class));
      } else if (json.has(STATE)) {
        if (audioThread == null) {
          // Send the InputStream on a different Thread. Elsewise, interim results cannot be received,
          // because the Thread that called SpeechToText.recognizeUsingWebSocket is blocked.
          audioThread = new Thread() {
            @Override
            public void run() {
              sendInputSteam(stream);

              // Do not send the stop message, if the socket has been closed already, for example because of
              // the inactivity timeout.
              if(socketOpen) {
                // If the socket is still open after the sending finishes, for example because the user closed
                // the microphone AudioInputStream, send a stop message.
                try {
                  socket.sendMessage(RequestBody.create(WebSocket.TEXT, buildStopMessage()));
                } catch (IOException e) {
                  LOG.log(Level.SEVERE, e.getMessage(), e);
                }
              }
            }
          };

          audioThread.start();
        } else {
          socket.close(CLOSE_NORMAL, "Transcription completed");
        }
      }
    }

    /*
     * (non-Javadoc)
     * 
     * @see okhttp3.ws.WebSocketListener#onOpen(okhttp3.ws.WebSocket, okhttp3.Response)
     */
    @Override
    public void onOpen(WebSocket socket, Response response) {
      callback.onConnected();
      this.socket = socket;
      try {
        socket.sendMessage(RequestBody.create(WebSocket.TEXT, buildStartMessage(options)));
      } catch (IOException e) {
        callback.onError(e);
      }
    }

    /*
     * (non-Javadoc)
     * 
     * @see okhttp3.ws.WebSocketListener#onPong(okio.Buffer)
     */
    @Override
    public void onPong(Buffer buffer) {}

    /**
     * Send input steam.
     *
     * @param inputStream the input stream
     */
    private void sendInputSteam(InputStream inputStream) {
      byte[] buffer = new byte[FOUR_KB];
      int read;
      try {
        // This method uses a blocking while loop to receive all contents of the underlying input stream.
        // AudioInputStreams, typically used for streaming microphone inputs return 0 only when the stream has been
        // closed. Elsewise AudioInputStream.read() blocks until enough audio frames are read.
        while ((read = inputStream.read(buffer)) > 0 && socketOpen) {
          if (read == FOUR_KB)
            socket.sendMessage(RequestBody.create(WebSocket.BINARY, buffer));
          else
            socket.sendMessage(RequestBody.create(WebSocket.BINARY, Arrays.copyOfRange(buffer, 0, read)));
        }
      } catch (IOException e) {
        LOG.log(Level.SEVERE, e.getMessage(), e);
      } finally {
        try {
          inputStream.close();
        } catch (IOException e) {
          // do nothing - the InputStream may have already been closed externally.
        }
      }
    }

    /**
     * Builds the start message.
     *
     * @param options the options
     * @return the request
     */
    private String buildStartMessage(RecognizeOptions options) {
      JsonObject startMessage = new JsonParser().parse(new Gson().toJson(options)).getAsJsonObject();
      startMessage.remove(MODEL);
      startMessage.addProperty(ACTION, START);
      return startMessage.toString();
    }

    /**
     * Builds the stop message.
     *
     * @return the string
     */
    private String buildStopMessage() {
      JsonObject stopMessage = new JsonObject();
      stopMessage.addProperty(ACTION, STOP);
      return stopMessage.toString();
    }
  }

  /**
   * Instantiates a new web socket manager.
   *
   * @param url the url
   * @param client the client
   * @param token the token
   */
  public WebSocketManager(String url, OkHttpClient client, String token) {
    this.url = url;
    this.client = client;
    this.token = token;
  }

  /**
   * Creates a connection.
   *
   * @param options the recognize options
   * @return the web socket call
   */
  private WebSocketCall createConnection(RecognizeOptions options) {
    String speechModel = options.model() == null ? "" : "?model=" + options.model();
    Request connectionRequest = new Request.Builder()
      .url(url + speechModel)
      .addHeader(HttpHeaders.X_WATSON_AUTHORIZATION_TOKEN, token)
      .build();

    return WebSocketCall.create(client, connectionRequest);
  }

  /**
   * Recognize.
   *
   * @param stream the stream
   * @param options the options
   * @param delegate the delegate
   */
  public void recognize(final InputStream stream, final RecognizeOptions options, RecognizeCallback delegate) {
    createConnection(options).enqueue(new SpeechToTextWebSocketListener(stream, options, delegate));
  }

}

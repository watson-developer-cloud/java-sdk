/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
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
import com.ibm.watson.developer_cloud.util.RequestUtils;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Manages Speech to text recognition over WebSockets.<br>
 * This class is in charge of opening a {@link WebSocket} connection, stream audio to the API and close the connection
 * once the audio was transmitted.
 */
public class WebSocketManager {
  private final String url;
  private final OkHttpClient client;
  private String token;
  private Headers defaultHeaders;

  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private static final Logger LOG = Logger.getLogger(WebSocketManager.class.getName());


  /**
   * The listener interface for receiving {@link WebSocket} events. <br>
   * The class that is interested in processing a event implements this interface. When the event occurs, that object's
   * appropriate method is invoked.
   *
   * @see SpeechToText
   */
  private class SpeechToTextWebSocketListener extends WebSocketListener {

    private static final String STATE = "state";
    private static final String MODEL = "model";
    private static final String START = "start";
    private static final String STOP = "stop";
    private static final String ACTION = "action";
    private static final int FOUR_KB = 4096;
    private static final String ERROR = "error";
    private static final String RESULTS = "results";
    private static final String SPEAKER_LABELS = "speaker_labels";
    private static final String CUSTOMIZATION_ID = "customization_id";

    private static final String TIMEOUT_PREFIX = "No speech detected for";

    private final InputStream stream;
    private final RecognizeOptions options;
    private final RecognizeCallback callback;
    private WebSocket socket;
    private boolean socketOpen = true;
    private Thread audioThread = null;
    private static final int CLOSE_NORMAL = 1000;

    /**
     * Instantiates a new speech to text web socket listener.
     *
     * @param stream the {@link InputStream} where the audio to recognize is
     * @param options the recognize options
     * @param callback the callback
     */
    SpeechToTextWebSocketListener(final InputStream stream, final RecognizeOptions options,
        final RecognizeCallback callback) {
      this.stream = stream;
      this.options = options;
      this.callback = callback;
    }

    /*
     * (non-Javadoc)
     *
     * @see okhttp3.WebSocketListener#onClosing(okhttp3.WebSocket, int, java.lang.String)
     */
    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
      socketOpen = false;
      callback.onDisconnected();
    }

    /*
     * (non-Javadoc)
     *
     * @see okhttp3.WebSocketListener#onFailure(okhttp3.WebSocket, java.lang.Throwable, okhttp3.Response)
     */
    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
      socketOpen = false;
      if (t instanceof Exception) {
        callback.onError((Exception) t);
      } else {
        callback.onError(new Exception(t));
      }
    }

    /*
     * (non-Javadoc)
     *
     * @see okhttp3.WebSocketListener#onMessage(okhttp3.WebSocket, java.lang.String)
     */
    @Override
    public void onMessage(WebSocket webSocket, String message) {
      JsonObject json = new JsonParser().parse(message).getAsJsonObject();
      if (json.has(ERROR)) {
        String error = json.get(ERROR).getAsString();

        // Only call onError() if a real error occurred. The STT service sends
        // {"error" : "No speech detected for 5s"} for valid timeouts, configured by
        // RecognizeOptions.Builder.inactivityTimeout()
        if (!error.startsWith(TIMEOUT_PREFIX)) {
          callback.onError(new RuntimeException(error));
        } else {
          // notify that the service timeouts because of inactivity
          callback.onInactivityTimeout(new RuntimeException(error));
        }
      } else if (json.has(RESULTS) || json.has(SPEAKER_LABELS)) {
        callback.onTranscription(GSON.fromJson(message, SpeechResults.class));
      } else if (json.has(STATE)) {
        // notify that the service is ready to receive audio
        callback.onListening();
      }
    }

    /*
     * (non-Javadoc)
     *
     * @see okhttp3.WebSocketListener#onOpen(okhttp3.WebSocket, okhttp3.Response)
     */
    @Override
    public void onOpen(final WebSocket socket, Response response) {
      callback.onConnected();
      this.socket = socket;
      if (!socket.send(buildStartMessage(options))) {
        callback.onError(new IOException("WebSocket unavailable"));
      } else {
        if (audioThread == null) {
          // Send the InputStream on a different Thread. Elsewise, interim results cannot be
          // received,
          // because the Thread that called SpeechToText.recognizeUsingWebSocket is blocked.
          audioThread = new Thread() {
            @Override
            public void run() {
              sendInputStream(stream);

              // Do not send the stop message, if the socket has been closed already, for example
              // because of
              // the inactivity timeout.
              if (socketOpen) {
                // If the socket is still open after the sending finishes, for example because the
                // user closed
                // the microphone AudioInputStream, send a stop message.
                if (!socket.send(buildStopMessage())) {
                  LOG.log(Level.SEVERE, "Stop message discarded because WebSocket is unavailable");
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

    /**
     * Send input stream.
     *
     * @param inputStream the input stream
     */
    private void sendInputStream(InputStream inputStream) {
      byte[] buffer = new byte[FOUR_KB];
      int read;
      try {
        // This method uses a blocking while loop to receive all contents of the underlying input
        // stream.
        // AudioInputStreams, typically used for streaming microphone inputs return 0 only when the
        // stream has been
        // closed. Elsewise AudioInputStream.read() blocks until enough audio frames are read.
        while (((read = inputStream.read(buffer)) > 0) && socketOpen) {
          if (read == FOUR_KB) {
            socket.send(ByteString.of(buffer));
          } else {
            socket.send(ByteString.of(Arrays.copyOfRange(buffer, 0, read)));
          }
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
      startMessage.remove(CUSTOMIZATION_ID);
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
   * @param defaultHeaders the default headers
   * @param token the token
   */
  public WebSocketManager(String url, OkHttpClient client, Headers defaultHeaders, String token) {
    this.url = url;
    this.client = client;
    this.defaultHeaders = defaultHeaders;
    this.token = token;
  }

  /**
   * Prepares the WebSocket request (URL, headers).
   *
   * @param options the recognize options
   * @return the configured request
   */
  private Request prepareRequest(RecognizeOptions options) {
    String speechModel = options.model() == null ? "" : "?model=" + options.model();
    if (options.customizationId() != null && !options.customizationId().isEmpty()) {
      speechModel += "&customization_id=" + options.customizationId();
    }
    Builder builder = new Request.Builder().url(url + speechModel);

    if (token != null) {
      builder.addHeader(HttpHeaders.X_WATSON_AUTHORIZATION_TOKEN, token);
    }

    if (defaultHeaders != null) {
      for (String key : defaultHeaders.names()) {
        builder.header(key, defaultHeaders.get(key));
      }
      if (defaultHeaders.get(HttpHeaders.USER_AGENT) != null) {
        String userAgent = RequestUtils.getUserAgent();
        userAgent += " " + defaultHeaders.get(HttpHeaders.USER_AGENT);
        builder.header(HttpHeaders.USER_AGENT, userAgent);
      }
    }

    return builder.build();
  }

  /**
   * Recognize.
   *
   * @param stream the stream
   * @param options the options
   * @param delegate the delegate
   */
  public void recognize(final InputStream stream, final RecognizeOptions options, RecognizeCallback delegate) {
    client.newWebSocket(prepareRequest(options), new SpeechToTextWebSocketListener(stream, options, delegate));
  }

}

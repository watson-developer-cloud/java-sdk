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

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The listener interface for receiving {@link WebSocket} events. <br>
 * The class that is interested in processing a event implements this interface. When the event occurs, that object's
 * appropriate method is invoked.
 *
 * @see SpeechToText
 */
public final class SpeechToTextWebSocketListener extends WebSocketListener {

  private static final String AUDIO_TO_WEB_SOCKET = "AudioToWebSocketThread";
  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private static final Logger LOG = Logger.getLogger(SpeechToTextWebSocketListener.class.getName());

  private static final String STATE = "state";
  private static final String MODEL = "model";
  private static final String START = "start";
  private static final String STOP = "stop";
  private static final String ACTION = "action";
  private static final int ONE_KB = 1024;
  private static final String ERROR = "error";
  private static final String RESULTS = "results";
  private static final String SPEAKER_LABELS = "speaker_labels";
  private static final String CUSTOMIZATION_ID = "customization_id";
  private static final String LANGUAGE_CUSTOMIZATION_ID = "language_customization_id";
  private static final String ACOUSTIC_CUSTOMIZATION_ID = "acoustic_customization_id";
  private static final String VERSION = "base_model_version";
  private static final String TIMEOUT_PREFIX = "No speech detected for";

  // 8 MB, half of the maximum OkHttp WebSocket queue size
  // (https://github.com/square/okhttp/blob/master/okhttp/src/main/java/okhttp3/internal/ws/RealWebSocket.java#L63)
  private static final long QUEUE_SIZE_LIMIT = 16 * 1024 * 512;
  private static final long QUEUE_WAIT_MILLIS = 500;

  private final InputStream stream;
  private final RecognizeOptions options;
  private final RecognizeCallback callback;
  private WebSocket socket;
  private boolean socketOpen = true;
  private Thread audioThread = null;
  private boolean isListening = false;
  private static final int CLOSE_NORMAL = 1000;

  /**
   * Instantiates a new speech to text web socket listener.
   *
   * @param options the recognize options
   * @param callback the callback
   */
  public SpeechToTextWebSocketListener(final RecognizeOptions options, final RecognizeCallback callback) {
    this.stream = options.audio();
    this.options = options;
    this.callback = callback;
  }

  /*
   * (non-Javadoc)
   * @see okhttp3.WebSocketListener#onClosing(okhttp3.WebSocket, int, java.lang.String)
   */
  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    socketOpen = false;
    callback.onDisconnected();
  }

  /*
   * (non-Javadoc)
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
   * @see okhttp3.WebSocketListener#onMessage(okhttp3.WebSocket, java.lang.String)
   */
  @Override
  public void onMessage(WebSocket webSocket, String message) {
    JsonObject json = new JsonParser().parse(message).getAsJsonObject();
    if (json.has(ERROR)) {
      String error = json.get(ERROR).getAsString();

      // Only call onError() if a real error occurred. The STT service sends
      // {"error" : "No speech detected for 5s"} for valid timeouts, configured by
      // RecognizeUsingWebSocketOptions.Builder.inactivityTimeout()
      if (!error.startsWith(TIMEOUT_PREFIX)) {
        callback.onError(new RuntimeException(error));
      } else {
        // notify that the service timeouts because of inactivity
        callback.onInactivityTimeout(new RuntimeException(error));
      }
    } else if (json.has(RESULTS) || json.has(SPEAKER_LABELS)) {
      callback.onTranscription(GSON.fromJson(message, SpeechRecognitionResults.class));

    } else if (json.has(STATE)) {
      // A listen state after everything has been sent over indicates everything has been processed
      if (!isListening) {
        isListening = true;
      } else {
        callback.onTranscriptionComplete();
        socket.close(CLOSE_NORMAL, "Transcription completed");
        return;
      }

      // notify that the service is ready to receive audio
      callback.onListening();
    }
  }

  /*
   * (non-Javadoc)
   * @see okhttp3.WebSocketListener#onOpen(okhttp3.WebSocket, okhttp3.Response)
   */
  @Override
  public void onOpen(final WebSocket socket, Response response) {
    callback.onConnected();
    this.socket = socket;
    if (!socket.send(buildStartMessage(options))) {
      callback.onError(new IOException("WebSocket unavailable"));
    } else {
      // Send the InputStream on a different Thread. Elsewise, interim results cannot be
      // received,
      // because the Thread that called SpeechToText.recognizeUsingWebSocket is blocked.
      audioThread = new Thread(AUDIO_TO_WEB_SOCKET) {
        @Override
        public void run() {
          sendInputStream(stream);
          // Do not send the stop message if the socket has been closed already, for example because of the
          // inactivity timeout.
          // If the socket is still open after the sending finishes, for example because the user closed the
          // microphone AudioInputStream, send a stop message.
          if (socketOpen && !socket.send(buildStopMessage())) {
            LOG.log(Level.SEVERE, "Stop message discarded because WebSocket is unavailable");
          }
        }
      };

      audioThread.start();
    }
  }

  /**
   * Send input stream.
   *
   * @param inputStream the input stream
   */
  private void sendInputStream(InputStream inputStream) {
    byte[] buffer = new byte[ONE_KB];
    int read;
    try {
      // This method uses a blocking while loop to receive all contents of the underlying input stream.
      // AudioInputStreams, typically used for streaming microphone inputs return 0 only when the stream has been
      // closed. Elsewise AudioInputStream.read() blocks until enough audio frames are read.
      while (((read = inputStream.read(buffer)) > 0) && socketOpen) {

        // If OkHttp's WebSocket queue gets overwhelmed, it'll abruptly close the connection
        // (see: https://github.com/square/okhttp/issues/3317). This will ensure we wait until the coast is clear.
        while (socket.queueSize() > QUEUE_SIZE_LIMIT) {
          Thread.sleep(QUEUE_WAIT_MILLIS);
        }

        if (read == ONE_KB) {
          socket.send(ByteString.of(buffer));
        } else {
          socket.send(ByteString.of(Arrays.copyOfRange(buffer, 0, read)));
        }
      }
    } catch (IOException | InterruptedException e) {
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
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();
    JsonObject startMessage = new JsonParser().parse(gson.toJson(options)).getAsJsonObject();
    startMessage.remove(MODEL);
    startMessage.remove(CUSTOMIZATION_ID);
    startMessage.remove(LANGUAGE_CUSTOMIZATION_ID);
    startMessage.remove(ACOUSTIC_CUSTOMIZATION_ID);
    startMessage.remove(VERSION);
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

package com.ibm.watson.text_to_speech.v1.websocket;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.watson.text_to_speech.v1.model.Marks;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Timings;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class TextToSpeechWebSocketListener extends WebSocketListener {
  private static final String TEXT_TO_WEB_SOCKET = "TextToWebSocketThread";
  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private static final Logger LOG = Logger.getLogger(TextToSpeechWebSocketListener.class.getName());

  private static final String VOICE = "voice";
  private static final String CUSTOMIZATION_ID = "customization_id";
  private static final String ACTION = "action";
  private static final String START = "start";
  private static final String STOP = "stop";
  private static final String ERROR = "error";
  private static final String WARNINGS = "warnings";
  private static final String BINARY_STREAMS = "binary_streams";
  private static final String CONTENT_TYPE = "content_type";
  private static final String WORDS = "words";
  private static final String MARKS = "marks";

  private final SynthesizeOptions options;
  private final SynthesizeCallback callback;
  private WebSocket socket;
  private boolean socketOpen = true;

  public TextToSpeechWebSocketListener(
      final SynthesizeOptions options, final SynthesizeCallback callback) {
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
      callback.onError(new RuntimeException(error));

    } else if (json.has(WARNINGS)) {
      String warning = json.get(WARNINGS).getAsString();
      callback.onWarning(new RuntimeException(warning));
    } else if (json.has(BINARY_STREAMS)) {
      String contentType =
          json.get(BINARY_STREAMS)
              .getAsJsonArray()
              .get(0)
              .getAsJsonObject()
              .get(CONTENT_TYPE)
              .getAsString();
      callback.onContentType(contentType);
    } else if (json.has(WORDS)) {
      callback.onTimings(GSON.fromJson(message, Timings.class));
    } else if (json.has(MARKS)) {
      callback.onMarks(GSON.fromJson(message, Marks.class));
    }
  }

  /*
   * (non-Javadoc)
   * @see okhttp3.WebSocketListener#onMessage(okhttp3.WebSocket, okio.ByteString)
   */
  @Override
  public void onMessage(WebSocket webSocket, ByteString bytes) {
    callback.onAudioStream(bytes.toByteArray());
  }

  /*
   * (non-Javadoc)
   * @see okhttp3.WebSocketListener#onOpen(okhttp3.WebSocket, okhttp3.Response)
   */
  @Override
  public void onOpen(final WebSocket webSocket, Response response) {
    callback.onConnected();
    this.socket = webSocket;
    if (!this.socket.send(buildStartMessage(this.options))) {
      callback.onError(new IOException("WebSocket unavailable"));
    } else {
      new Thread(TEXT_TO_WEB_SOCKET) {
        @Override
        public void run() {
          sendText();
          if (socketOpen && !socket.send(buildStopMessage())) {
            LOG.log(Level.SEVERE, "Stop message discarded because WebSocket is unavailable");
          }
        }
      };
    }
  }

  private void sendText() {
    try {
      while (socketOpen) {
        socket.send(this.options.text());
      }
    } catch (Exception e) {
      LOG.log(Level.SEVERE, e.getMessage(), e);
    }
  }

  /**
   * Builds the start message.
   *
   * @param options the options
   * @return the request
   */
  private String buildStartMessage(SynthesizeOptions options) {
    Gson gson =
        new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    JsonObject startMessage = new JsonParser().parse(gson.toJson(options)).getAsJsonObject();

    // remove options that are already in query string
    startMessage.remove(VOICE);
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

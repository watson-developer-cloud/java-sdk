package com.ibm.watson.developer_cloud.speech_to_text.v1.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketExtension;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;


/**
 * WebSocket client used by the {@link SpeechToText} to recognize audio
 */
public class WebSocketSpeechToTextClient {
  private static final String MODEL = "model";
  private static final String START = "start";
  private static final String STOP = "stop";
  private static final String ACTION = "action";
  private static final String RESULTS = "results";
  private static final String ERROR = "error";

  private static final int TEN_SECONDS = 10000; // milliseconds

  /**
   * Listener that call the {@link RecognizeDelegate} when a message from the WebSocket connection
   * arrives
   */
  public class WebSocketListener extends WebSocketAdapter {
    private RecognizeDelegate delegate;
    private boolean audioSent = false;
    /**
     * Instantiates a new WebSocket listener.
     * 
     * @param delegate the delegate to notify events
     */
    public WebSocketListener(RecognizeDelegate delegate) {
      super();
      this.delegate = delegate;
      audioSent = false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.neovisionaries.ws.client.WebSocketAdapter#onTextMessage(com.neovisionaries.ws.client.
     * WebSocket, java.lang.String)
     */
    public void onTextMessage(WebSocket websocket, String message) {
      try {
        JsonObject json = new JsonParser().parse(message).getAsJsonObject();

        if (json.has(ERROR)) {
          delegate.onError(new RuntimeException(json.get(ERROR).getAsString()));
        } else if (json.has(RESULTS)) {
          SpeechResults transcript = GsonSingleton.getGson().fromJson(message, SpeechResults.class);
          delegate.onMessage(transcript);
        } else if (audioSent) {
          websocket.sendClose();
        }
      } catch (JsonParseException e) {
        new RuntimeException("Error parsing the incoming message: " + message);
      }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.neovisionaries.ws.client.WebSocketAdapter#onConnected(com.neovisionaries.ws.client.WebSocket
     * , java.util.Map)
     */
    @Override
    public void onConnected(WebSocket websocket, Map<String, List<String>> headers)
        throws Exception {
      delegate.onConnected();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.neovisionaries.ws.client.WebSocketAdapter#onDisconnected(com.neovisionaries.ws.client
     * .WebSocket, com.neovisionaries.ws.client.WebSocketFrame,
     * com.neovisionaries.ws.client.WebSocketFrame, boolean)
     */
    @Override
    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame,
        WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {
      delegate.onDisconnected();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.neovisionaries.ws.client.WebSocketAdapter#onError(com.neovisionaries.ws.client.WebSocket,
     * com.neovisionaries.ws.client.WebSocketException)
     */
    @Override
    public void onError(WebSocket websocket, WebSocketException cause) throws Exception {
      delegate.onError(cause);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.neovisionaries.ws.client.WebSocketAdapter#handleCallbackError(com.neovisionaries.ws.client
     * .WebSocket, java.lang.Throwable)
     */
    @Override
    public void handleCallbackError(WebSocket websocket, Throwable cause) throws Exception {
      cause.printStackTrace();
    }

  }

  private static final int FOUR_KB = 4096;
  private String token;
  private String webSocketUrl;

  /**
   * Instantiates a new web socket speech to text client.
   * 
   * @param webSocketUrl the web socket url.
   * 
   *        <pre>
   * wss://stream.watsonplatform.net/speech-to-text/api/v1/api/recognize
   * </pre>
   * @param token the authorization token
   */
  public WebSocketSpeechToTextClient(String webSocketUrl, String token) {
    this.token = token;
    this.webSocketUrl = webSocketUrl;
  }

  /**
   * Creates a WebSocket connection to the Speech To Text service and sends the audio bytes from the
   * input stream for recognition
   * 
   * @param stream the stream
   * @param options the options
   * @param delegate the delegate
   */
  public void recognize(InputStream stream, RecognizeOptions options, RecognizeDelegate delegate) {
    WebSocketListener listener = new WebSocketListener(delegate);

    try {
      // 1. Connect to the WebSocket
      WebSocket ws = connect(options);

      // 2. Add a listener to messages coming from the WebSocket
      ws.addListener(listener);

      // 3. Send start message
      ws.sendText(buildStartMessage(options));

      // 4. Send the input stream as binary data
      sendInputStream(ws, stream);
      
      // 5. Tell the listener that we sent the audio
      listener.audioSent = true;
      
      // 5. Send stop message
      ws.sendText(buildStopMessage());

    } catch (WebSocketException e) {
      delegate.onError(e);
    } catch (IOException e) {
      delegate.onError(e);
    } catch (InterruptedException e) {
      delegate.onError(e);
    }
  }

  /**
   * Builds the stop message.<br>
   * <br>
   * <code>
   * { "action": "stop" }
   * </code>
   * 
   * @return the string
   */
  private String buildStopMessage() {
    JsonObject stopMessage = new JsonObject();
    stopMessage.addProperty(ACTION, STOP);
    return stopMessage.toString();
  }

  /**
   * Sends 4k byte arrays to the WebSocket as binary data
   * 
   * @param ws the WebSocket
   * @param stream the stream
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException if any thread has interrupted the current thread. The interrupted
   *         status of the current thread is cleared when this exception is thrown.
   */
  private void sendInputStream(WebSocket ws, InputStream stream) throws IOException,
      InterruptedException {
    byte[] buffer = new byte[FOUR_KB];
    int read;
    while ((read = stream.read(buffer)) > 0) {
      if (read == FOUR_KB)
        ws.sendBinary(buffer);
      else
        ws.sendBinary(Arrays.copyOfRange(buffer, 0, read));

      Thread.sleep(20);
    }
    stream.close();
  }

  /**
   * Builds the start message using the {@link RecognizeOptions}. <br>
   * <br>
   * <code>
   * { 
   * "action": "start",
   * "content-type": "audio/wav"
   * }
   * </code>
   * 
   * @param options the recognize options
   * @return the string
   */
  private String buildStartMessage(RecognizeOptions options) {
    JsonObject startMessage = new JsonParser().parse(new Gson().toJson(options)).getAsJsonObject();
    startMessage.remove(MODEL);
    startMessage.addProperty(ACTION, START);
    return startMessage.toString();
  }

  /**
   * Creates a connects to the Speech to Text service
   * 
   * @param options
   * 
   * @return the WebSocket
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws WebSocketException the WebSocket exception
   */
  private WebSocket connect(RecognizeOptions options) throws IOException, WebSocketException {
    String speechModel = options.getModel() != null ? "?model=" + options.getModel() : "";

    WebSocketFactory factory = new WebSocketFactory().setConnectionTimeout(TEN_SECONDS);
    WebSocket ws = factory.createSocket(webSocketUrl + speechModel);
    ws.addHeader(HttpHeaders.X_WATSON_AUTHORIZATION_TOKEN, token);
    ws.addExtension(WebSocketExtension.PERMESSAGE_DEFLATE).connect();
    return ws;
  }
}

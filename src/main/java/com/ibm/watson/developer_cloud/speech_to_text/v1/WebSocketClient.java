package com.ibm.watson.developer_cloud.speech_to_text.v1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.java_websocket.util.Base64;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class WebSocketClient {
  private static final String START = "start";
  private static final String STOP = "stop";
  private static final String ACTION = "action";
  private static final String SERVER =
      "wss://stream.watsonplatform.net/speech-to-text/api/v1/recognize";
  private static final String RESULT_INDEX = "result_index";
  private static final String ERROR = "error";
  private static final int TEN_SECONDS = 10000;

  /**
   * The WebSocket listener
   */
  public class WebSocketListener extends WebSocketAdapter {

    private RecognizeDelegate delegate;

    /**
     * Instantiates a new web socket client.
     * 
     * @param delegate the delegate
     */
    public WebSocketListener(RecognizeDelegate delegate) {
      super();
      this.delegate = delegate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.neovisionaries.ws.client.WebSocketAdapter#onTextMessage(com.neovisionaries.ws.client.
     * WebSocket, java.lang.String)
     */
    // A text message arrived from the server.
    public void onTextMessage(WebSocket websocket, String message) {
      JsonObject json = new JsonParser().parse(message).getAsJsonObject();
      if (json.has(ERROR)) {
        delegate.onError(new RuntimeException("Error parsing the message: " + message));
      } else if (json.has(RESULT_INDEX)) {
        SpeechResults transcript = GsonSingleton.getGson().fromJson(message, SpeechResults.class);
        boolean fin =
            transcript.getResults() != null && !transcript.getResults().isEmpty()
                && transcript.getResults().get(transcript.getResultIndex()).isFinal();

        delegate.onMessage(transcript, fin);

        // if final is true
        if (fin)
          websocket.disconnect();
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

  private static final String AUTHORIZATION_ENDPOINT =
      "https://stream.watsonplatform.net/authorization/api";
  private static final String HTTP_ENDPOINT =
      "https://stream.watsonplatform.net/speech-to-text/api";
  private static final String USERNAME = "USERNAME";
  private static final String PASSWORD = "PASSWORD";
  private static final int FOUR_KB = 4096;

  /**
   * Gets the token using the Authorization Service
   * 
   * @return the token
   * @throws RuntimeException if the token can't be created
   */
  private static String getToken() {
    String url = AUTHORIZATION_ENDPOINT + "/v1/token?url=" + HTTP_ENDPOINT;
    String auth = USERNAME + ":" + PASSWORD;
    String apiKey = new String(Base64.encodeBytes(auth.getBytes()));

    Request request =
        new Request.Builder().header(HttpHeaders.AUTHORIZATION, "Basic " + apiKey).url(url).build();

    OkHttpClient client = new OkHttpClient();
    Response response;
    try {
      response = client.newCall(request).execute();

      if (!response.isSuccessful())
        throw new RuntimeException("Error getting the token: " + response.code() + " "
            + response.message());

      return response.body().string();
    } catch (IOException e) {
      throw new RuntimeException("Error getting the token", e);
    }
  }

  public void recognize(InputStream stream, RecognizeOptions options, RecognizeDelegate delegate) {
    WebSocketListener listener = new WebSocketListener(delegate);

    try {

      // 1. Connect to the web socket
      WebSocket ws = new WebSocketFactory().setConnectionTimeout(TEN_SECONDS).createSocket(SERVER);
      ws.addHeader(HttpHeaders.X_WATSON_AUTHORIZATION_TOKEN, getToken());
      ws.addListener(listener).connect();

      // 2. Send start message
      JsonObject startMessage =
          new JsonParser().parse(GsonSingleton.getGson().toJson(options)).getAsJsonObject();
      startMessage.addProperty(ACTION, START);
      System.out.println("sending:" + startMessage);
      ws.sendText(startMessage.toString());

      // 3. Send binary data
      byte[] buffer = new byte[FOUR_KB];
      int read;
      while ((read = stream.read(buffer)) > 0) {
        if (read == FOUR_KB)
          ws.sendBinary(buffer);
        else
          ws.sendBinary(Arrays.copyOfRange(buffer, 0, read));

        Thread.sleep(5);
      }

      // 4. Send stop message
      JsonObject stopMessage = new JsonObject();
      stopMessage.addProperty(ACTION, STOP);
      ws.sendText(stopMessage.toString());

    } catch (WebSocketException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

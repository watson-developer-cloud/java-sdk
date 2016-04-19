package com.ibm.watson.developer_cloud.speech_to_text.v1.websocket;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import okhttp3.*;
import okhttp3.ws.WebSocket;
import okhttp3.ws.WebSocketCall;
import okhttp3.ws.WebSocketListener;
import okio.Buffer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by harrisonsaylor on 4/14/16.
 */
public class WebSocketManager implements WebSocketListener {

    private static final String MODEL = "model";
    private static final String START = "start";
    private static final String STOP = "stop";
    private static final String ACTION = "action";

    private String url;
    private OkHttpClient client;
    private ResponseListener listener;

    private volatile boolean connecting;
    private volatile boolean connected;

    private static final int FOUR_KB = 4096;

    public WebSocket socket;

    private String token;

    public WebSocketManager(String url, OkHttpClient client, String token, ResponseListener listener) {
      this.url = url;
      this.client = client;
      this.token = token;
      this.listener = listener;
    }

    public void connect(RecognizeOptions options) {
      if(connecting != true) {
        connecting = true;

        String speechModel = options.getModel() != null ? "?model=" + options.getModel() : "";
        Request connectionRequest = new Request.Builder()
              .url(url + speechModel)
              .addHeader(HttpHeaders.X_WATSON_AUTHORIZATION_TOKEN, token)
              .build();
        WebSocketCall.create(client, connectionRequest).enqueue(this);
      }
    }

    public void forceClose() throws IOException {
        socket.close(1000, "User forced socket close");
    }

    public void sendInputSteam(InputStream inputStream) {
        if (!connected || socket == null)
            throw new IllegalStateException("WebSocket not connected; call connect()");

        try {
            byte[] buffer = new byte[FOUR_KB];
            int read;
            while ((read = inputStream.read(buffer)) > 0) {
                if (read == FOUR_KB)
                    socket.sendMessage(RequestBody.create(WebSocket.BINARY, buffer));
                else
                    socket.sendMessage(RequestBody.create(WebSocket.BINARY, Arrays.copyOfRange(buffer, 0, read)));

                Thread.sleep(20);
            }
            inputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void recognize(InputStream stream, RecognizeOptions options) {
      if (connected != true)
        connect(options);

      try {
        socket.sendMessage(RequestBody.create(WebSocket.TEXT, buildStartMessage(options).body().toString()));
        sendInputSteam(stream);
        socket.sendMessage(RequestBody.create(WebSocket.TEXT, buildStopMessage().body().toString()));
      } catch (IOException e) {
        e.printStackTrace();
      }


    }

    public Request buildStartMessage(RecognizeOptions options) {
      JsonObject startMessage = new JsonParser().parse(new Gson().toJson(options)).getAsJsonObject();
      startMessage.remove(MODEL);
      startMessage.addProperty(ACTION, START);
      return new Request.Builder().post(RequestBody.create(WebSocket.TEXT, startMessage.toString())).build();
    }

    private Request buildStopMessage() {
      JsonObject stopMessage = new JsonObject();
      stopMessage.addProperty(ACTION, STOP);
      return new Request.Builder().post(RequestBody.create(WebSocket.TEXT, stopMessage.toString())).build();
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
      socket = webSocket;
      connecting = false;
      connected = true;
    }

    @Override
    public void onFailure(IOException e, Response response) {
      connecting = false;
      connected = false;

    }

    @Override
    public void onMessage(ResponseBody responseBody) throws IOException {
      listener.onResponse(responseBody.string());
    }

    @Override
    public void onPong(Buffer buffer) {

    }

    @Override
    public void onClose(int i, String s) {
      connecting = false;
      connected = false;
    }

}

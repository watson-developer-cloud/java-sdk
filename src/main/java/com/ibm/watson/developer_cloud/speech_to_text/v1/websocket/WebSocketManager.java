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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;

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
 * WebSocket manager
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

    /** The socket. */
    public WebSocket socket;

    private String token;

    /**
     * Instantiates a new web socket manager.
     *
     * @param url the url
     * @param client the client
     * @param token the token
     * @param listener the listener
     */
    public WebSocketManager(String url, OkHttpClient client, String token, ResponseListener listener) {
      this.url = url;
      this.client = client;
      this.token = token;
      this.listener = listener;
    }

    /**
     * Connect.
     *
     * @param options the options
     */
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

    /**
     * Force close.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void forceClose() throws IOException {
        socket.close(1000, "User forced socket close");
    }

    /**
     * Send input steam.
     *
     * @param inputStream the input stream
     */
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

    /**
     * Recognize.
     *
     * @param stream the stream
     * @param options the options
     */
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

    /**
     * Builds the start message.
     *
     * @param options the options
     * @return the request
     */
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

    /* (non-Javadoc)
     * @see okhttp3.ws.WebSocketListener#onOpen(okhttp3.ws.WebSocket, okhttp3.Response)
     */
    @Override
    public void onOpen(WebSocket webSocket, Response response) {
      socket = webSocket;
      connecting = false;
      connected = true;
    }

    /* (non-Javadoc)
     * @see okhttp3.ws.WebSocketListener#onFailure(java.io.IOException, okhttp3.Response)
     */
    @Override
    public void onFailure(IOException e, Response response) {
      connecting = false;
      connected = false;

    }

    /* (non-Javadoc)
     * @see okhttp3.ws.WebSocketListener#onMessage(okhttp3.ResponseBody)
     */
    @Override
    public void onMessage(ResponseBody responseBody) throws IOException {
      listener.onResponse(responseBody.string());
    }

    /* (non-Javadoc)
     * @see okhttp3.ws.WebSocketListener#onPong(okio.Buffer)
     */
    @Override
    public void onPong(Buffer buffer) {

    }

    /* (non-Javadoc)
     * @see okhttp3.ws.WebSocketListener#onClose(int, java.lang.String)
     */
    @Override
    public void onClose(int i, String s) {
      connecting = false;
      connected = false;
    }

}

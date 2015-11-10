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
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.java_websocket.client.DefaultSSLWebSocketClientFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Example of how to trascribe a wav file using the REST API or WebSockets
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class TrascribeWithHttpAndWebSockets {

  private static final String AUDIO_FILE_PATH = "src/test/resources/sample1.wav";
  private static final String AUDIO_FORMAT = HttpMediaType.AUDIO_WAV;

  private static final String AUTHORIZATION_ENDPOINT =
      "https://stream.watsonplatform.net/authorization/api";
  private static final String HTTP_ENDPOINT =
      "https://stream.watsonplatform.net/speech-to-text/api";
  private static final String PASSWORD = "XXX";

  // replace this with your service credentials
  private static final String USERNAME = "XXX";
  private static final String WSS_ENDPOINT =
      "wss://stream.watsonplatform.net/speech-to-text/api/v1/recognize";

  /**
   * Creates the SSL context to be use by the {@link DefaultSSLWebSocketClientFactory}.
   * 
   * @return the SSL context
   * @throws RuntimeException if the context cannot be initialized
   */
  private static SSLContext createSSLContext() {
    SSLContext sslContext = null;
    try {
      sslContext = SSLContext.getInstance("TLS");
      sslContext.init(null, null, null);
    } catch (final Exception e) {
      throw new RuntimeException("Unable to enable SSL", e);
    }
    return sslContext;
  }

  public static void main(String[] args) throws FileNotFoundException {
    final TrascribeWithHttpAndWebSockets s2t = new TrascribeWithHttpAndWebSockets();

    final File audio = new File(AUDIO_FILE_PATH);

    // use http
    s2t.transcriptUsingHTTP(audio, AUDIO_FORMAT);

    // use webSockets
    // s2t.transcriptUsingWebSockets(audio, AUDIO_FORMAT);
  }

  /**
   * Gets the token using the Authorization Service
   * 
   * @return the token
   * @throws RuntimeException if the token cannot be created HTTP response status != 200
   */
  private String getToken() {
    final String url = AUTHORIZATION_ENDPOINT + "/v1/token?url=" + HTTP_ENDPOINT;
    final Request request =
        new Request.Builder().url(url)
            .header(HttpHeaders.AUTHORIZATION, Credentials.basic(USERNAME, PASSWORD)).build();

    final OkHttpClient client = new OkHttpClient();

    try {
      final Response response = client.newCall(request).execute();
      if (response.isSuccessful())
        return response.body().string();
      else
        throw new RuntimeException("Error getting the token");
    } catch (final Exception e) {
      throw new RuntimeException("Error getting the token");
    }
  }

  /**
   * Transcript an audio file using the REST API calls.
   * 
   * @param audioFile the audio file
   * @param contentType the content type: audio/wav or audio/ogg.<br>
   *        See {@link HttpMediaType}
   */
  public void transcriptUsingHTTP(File audioFile, String contentType) {
    System.out.println("Transcript using HTTP");

    // create the service and set the username and password
    final SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword(USERNAME, PASSWORD);
    service.setEndPoint(HTTP_ENDPOINT);

    // 1 create the session
    final SpeechSession session = service.createSession(SpeechModel.EN_BROADBAND16K);
    System.out.println("session: " + session.toString());

    // 2 call recognize
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(SpeechToText.AUDIO, audioFile);
    params.put(SpeechToText.CONTENT_TYPE, contentType);
    params.put(SpeechToText.CONTINUOUS, true);
    params.put(SpeechToText.SESSION_ID, session.getSessionId());

    final SpeechResults transcript = service.recognize(params);

    // 4 print the transcript
    System.out.println("transcript: " + transcript.toString());

    // 5 delete the created session
    service.deleteSession(session);

  }

  /**
   * Transcript using web sockets.
   * 
   * @param audioFile the audio file
   * @param contentType the content type
   */
  public void transcriptUsingWebSockets(File audioFile, String contentType) {

    System.out.println("Transcript using WebSockets");
    try {
      final String token = getToken();
      final URI uri = new URI(WSS_ENDPOINT + "?watson-token=" + token);


      final WebSocketClient client = new WebSocketClient(uri) {

        @Override
        public void onClose(int code, String reason, boolean remote) {
          System.out.println("closed connection");
        }

        @Override
        public void onError(Exception ex) {
          ex.printStackTrace();
        }

        @Override
        public void onMessage(String message) {
          final SpeechResults result =
              GsonSingleton.getGson().fromJson(message, SpeechResults.class);
          System.out.println(result);
        }

        @Override
        public void onOpen(ServerHandshake handshake) {
          System.out.println("opened connection");
        }

      };

      client.setWebSocketFactory(new DefaultSSLWebSocketClientFactory(createSSLContext()));

      System.out.println("CONNECTED: " + client.connectBlocking());
      System.out.println("HERE: " + client.getConnection().isOpen());

      final JsonObject startMessage = new JsonObject();
      startMessage.addProperty("action", "start");
      startMessage.addProperty("content-type", contentType);


      client.send(startMessage.toString());
    } catch (final Exception e) {
      e.printStackTrace();
    }
    System.out.println("Done");
  }
}

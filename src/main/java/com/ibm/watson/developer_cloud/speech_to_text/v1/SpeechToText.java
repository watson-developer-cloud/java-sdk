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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpStatus;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SessionStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModelSet;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * The Speech to Text service uses IBM's speech recognition capabilities to convert English speech
 * into text. The transcription of incoming audio is continuously sent back to the client with
 * minimal delay, and it is corrected as more speech is heard.
 * 
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/speech-to-text.html">
 *      Speech to Text</a>
 */
public class SpeechToText extends WatsonService {

  /** The Constant AUDIO. */
  public static final String AUDIO = "audio";

  /** The Constant CONTENT_TYPE. */
  public static final String CONTENT_TYPE = "content_type";

  /** The Constant CONTINUOUS. */
  public static final String CONTINUOUS = "continuous";

  /** The Constant INACTIVITY_TIMEOUT. */
  public static final String INACTIVITY_TIMEOUT = "inactivity_timeout";

  /** The Constant MAX_ALTERNATIVES. */
  public static final String MAX_ALTERNATIVES = "max_alternatives";

  /** The Constant MODEL. */
  public static final String MODEL = "model";

  /** The Constant SESSION_ID. */
  public static final String SESSION_ID = "session_id";

  /** The Constant TIMESTAMPS. */
  public static final String TIMESTAMPS = "timestamps";

  /** The url. */
  private final static String URL = "https://stream.watsonplatform.net/speech-to-text/api";

  /** The Constant WORD_CONFIDENCE. */
  public static final String WORD_CONFIDENCE = "word_confidence";

  /**
   * Instantiates a new speech to text.
   */
  public SpeechToText() {
    super("speech_to_text");
    setEndPoint(URL);
  }

  /**
   * Create a session to lock an engine to the session. You can use the session for multiple
   * recognition requests, so that each request is processed with the same speech-to-text engine.
   * Use the cookie that is returned from this operation in the Set-Cookie header for each request
   * that uses this session. The session expires after 15 minutes of inactivity.
   * 
   * @return the {@link SpeechSession}
   */
  public SpeechSession createSession() {
    final String model = null;
    return createSession(model);
  }

  /**
   * Create a session to lock an engine to the session. You can use the session for multiple
   * recognition requests, so that each request is processed with the same speech-to-text engine.
   * Use the cookie that is returned from this operation in the Set-Cookie header for each request
   * that uses this session. The session expires after 15 minutes of inactivity.
   * 
   * @param model the {@link SpeechModel}
   * @return the {@link SpeechSession}
   */
  public SpeechSession createSession(final SpeechModel model) {
    Validate.notNull(model, "model cannot be null");
    return createSession(model.getName());
  }

  /**
   * Create a session to lock an engine to the session. You can use the session for multiple
   * recognition requests, so that each request is processed with the same speech-to-text engine.
   * Use the cookie that is returned from this operation in the Set-Cookie header for each request
   * that uses this session. The session expires after 15 minutes of inactivity.
   * 
   * @param model the model
   * @return the {@link SpeechSession}
   */
  public SpeechSession createSession(final String model) {
    String path = "/v1/sessions";

    if (model != null && !model.isEmpty())
      path += "?model=" + model;

    final Request request = RequestBuilder.post(path).build();
    final Response response = execute(request);
    final SpeechSession speechSession = ResponseUtil.getObject(response, SpeechSession.class);
    speechSession.setCookieSession(response.header(HttpHeaders.SET_COOKIE));
    return speechSession;
  }

  /**
   * Delete a session.
   * 
   * @param session the speech session
   */
  public void deleteSession(final SpeechSession session) {
    if (session == null)
      throw new IllegalArgumentException("session was not specified");

    final Request request =
        RequestBuilder.delete("/v1/sessions/" + session.getSessionId())
            .withHeader(HttpHeaders.COOKIE, session.getCookieSession()).build();
    final Response response = execute(request);

    ResponseUtil.getString(response);
    if (response.code() != HttpStatus.NO_CONTENT)
      throw new RuntimeException("Cound't delete session");
  }

  /**
   * Gets the model.
   * 
   * @param watsonModel the watson model
   * @return the model
   */
  public SpeechModel getModel(final SpeechModel watsonModel) {
    return getModel(watsonModel.getName());
  }

  /**
   * Gets the speech model.
   * 
   * @param name the name
   * @return the model
   */
  public SpeechModel getModel(final String name) {
    if (name == null)
      throw new IllegalArgumentException("name was not specified");

    final Request request = RequestBuilder.get("/v1/models/" + name).build();
    return executeRequest(request, SpeechModel.class);
  }

  /**
   * Gets the models.
   * 
   * @return the models
   */
  public List<SpeechModel> getModels() {
    final Request request = RequestBuilder.get("/v1/models").build();
    return executeRequest(request, SpeechModelSet.class).getModels();
  }

  /**
   * Gets the session status. Concurrent recognition tasks during the same session are not allowed.
   * This method offers a way to check whether the session can accept another recognition task. The
   * returned state must be "initialized" to call {@link #recognize(File, String)}.
   * 
   * @param session the speech session
   * @return the model
   */
  public SessionStatus getRecognizeStatus(final SpeechSession session) {
    if (session == null)
      throw new IllegalArgumentException("session was not specified");

    final Request request =
        RequestBuilder.get("/v1/sessions/" + session.getSessionId() + "/recognize")
            .withHeader("Cookie", session.getCookieSession()).build();
    return executeRequest(request, SessionStatus.class);
  }

  /**
   * Recognize.
   * 
   * @param audio the audio file
   * @param contentType the content type
   * @return the speech results
   */
  public SpeechResults recognize(final File audio, final String contentType) {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AUDIO, audio);
    params.put(CONTENT_TYPE, contentType);
    return recognize(params);
  }

  /**
   * Recognize.
   * 
   * @param params the parameters to use for the recognition. for example: "word_confidence",
   *        "continuous", "max_alternatives", "timestamps", "inactivity_timeout", "model",
   *        "session_id", content_type
   * @return the speech results
   */
  public SpeechResults recognize(Map<String, Object> params) {
    final File audio = (File) params.get(AUDIO);
    if (audio == null || !audio.exists() || !audio.isFile())
      throw new IllegalArgumentException("audio is not a valid audio file");

    final String contentType = (String) params.get(CONTENT_TYPE);
    if (contentType == null)
      throw new IllegalArgumentException("contentType was not specified");

    // Build the recognize url
    final StringBuilder urlBuider = new StringBuilder();
    urlBuider.append("/v1");
    urlBuider.append(params.containsKey(SESSION_ID) ? "/sessions/" + params.get(SESSION_ID) : "");
    urlBuider.append("/recognize");

    final RequestBuilder requestBuilder = RequestBuilder.post(urlBuider.toString());
    requestBuilder.withHeader(HttpHeaders.CONTENT_TYPE, contentType);

    final String[] queryParameters =
        new String[] {WORD_CONFIDENCE, CONTINUOUS, MAX_ALTERNATIVES, TIMESTAMPS,
            INACTIVITY_TIMEOUT, MODEL};

    for (final String param : queryParameters) {
      if (params.containsKey(param))
        requestBuilder.withQuery(param, params.get(param));
    }

    final RequestBody body = RequestBody.create(MediaType.parse(contentType), audio);
    requestBuilder.withBody(body);
    return executeRequest(requestBuilder.build(), SpeechResults.class);
  }
}

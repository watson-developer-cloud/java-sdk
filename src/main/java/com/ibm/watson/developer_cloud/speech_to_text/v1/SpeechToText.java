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
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionCallback;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJob;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJobOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSessionStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.MediaTypeUtils;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.WebSocketManager;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ws.WebSocket;

/**
 * The Speech to Text service uses IBM's speech recognition capabilities to convert English speech
 * into text. The transcription of incoming audio is continuously sent back to the client with
 * minimal delay, and it is corrected as more speech is heard.
 * 
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/speech-to-text.html"> Speech to Text</a>
 */
public class SpeechToText extends WatsonService {

  private static final String CALLBACK_URL = "callback_url";
  private static final String CONTINUOUS = "continuous";
  private static final String EVENTS = "events";
  private static final String INACTIVITY_TIMEOUT = "inactivity_timeout";
  private static final String KEYWORDS = "keywords";
  private static final String KEYWORDS_THRESHOLD = "keywords_threshold";
  private static final String MAX_ALTERNATIVES = "max_alternatives";
  private static final String MODEL = "model";
  private static final String PATH_MODEL = "/v1/models/%s";
  private static final String PATH_MODELS = "/v1/models";
  private static final String PATH_RECOGNITION = "/v1/recognitions/%s";
  private static final String PATH_RECOGNITIONS = "/v1/recognitions";
  private static final String PATH_RECOGNIZE = "/v1/recognize";
  private static final String PATH_REGISTER_CALLBACK = "/v1/register_callback";
  private static final String PATH_SESSION = "/v1/sessions/%s";
  private static final String PATH_SESSION_RECOGNIZE = "/v1/sessions/%s/recognize";
  private static final String PATH_SESSIONS = "/v1/sessions";
  private static final String PROFANITY_FILTER = "profanity_filter";
  private static final String RESULTS_TTL = "results_ttl";
  private static final String SERVICE_NAME = "speech_to_text";
  private static final String SMART_FORMATTING = "smart_formatting";
  private static final String TIMESTAMPS = "timestamps";
  private static final String SECRET = "secret";
  private static final String USER_TOKEN = "user_token";
  private static final String WORD_ALTERNATIVES_THRESHOLD = "word_alternatives_threshold";
  private static final String WORD_CONFIDENCE = "word_confidence";
  private static final String URL = "https://stream.watsonplatform.net/speech-to-text/api";
  
  private static final Type TYPE_LIST_MODELS = new TypeToken<List<SpeechModel>>() {}.getType();
  private static final Type TYPE_LIST_RECOGNITIONS = new TypeToken<List<RecognitionJob>>() {}.getType();
  private static final Type TYPE_SESSION_STATUS = new TypeToken<SpeechSessionStatus>() {}.getType();

  /**
   * Instantiates a new Speech to Text service.
   */
  public SpeechToText() {
    super(SERVICE_NAME);
    if (getEndPoint() == null || getEndPoint().isEmpty())
      setEndPoint(URL);
  }

  /**
   * Instantiates a new Speech to Text service by username and password.
   * 
   * @param username the username
   * @param password the password
   */
  public SpeechToText(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Builds the recognition job request using the {@link RecognitionJobOptions}.
   * 
   * @param requestBuilder the request builder
   * @param jobOptions the recognition job options
   */
  private void buildRecognitionJobRequest(RequestBuilder requestBuilder, RecognitionJobOptions jobOptions) {
    if (jobOptions == null) {
      return;
    } 

    if (jobOptions.userToken() != null)
      requestBuilder.query(USER_TOKEN, jobOptions.userToken());
    
    if (jobOptions.resultsTtl() != null)
      requestBuilder.query(RESULTS_TTL, jobOptions.resultsTtl());
    
    if (jobOptions.callbackUrl() != null)
      requestBuilder.query(CALLBACK_URL, jobOptions.callbackUrl());
    
    if (jobOptions.events() != null)
      requestBuilder.query(EVENTS, String.join(",", jobOptions.events()));
  }

  /**
   * Builds the recognize request using the {@link RecognizeOptions}.
   * 
   * @param requestBuilder the request builder
   * @param options the recognize options
   */
  private void buildRecognizeRequest(RequestBuilder requestBuilder, RecognizeOptions options) {
    if (options == null)
      return;

    if (options.wordConfidence() != null)
      requestBuilder.query(WORD_CONFIDENCE, options.wordConfidence());

    if (options.continuous() != null)
      requestBuilder.query(CONTINUOUS, options.continuous());

    if (options.smartFormatting() != null)
      requestBuilder.query(SMART_FORMATTING, options.smartFormatting());

    if (options.profanityFilter() != null)
      requestBuilder.query(PROFANITY_FILTER, options.profanityFilter());

    if (options.maxAlternatives() != null)
      requestBuilder.query(MAX_ALTERNATIVES, options.maxAlternatives());

    if (options.timestamps() != null)
      requestBuilder.query(TIMESTAMPS, options.timestamps());

    if (options.inactivityTimeout() != null)
      requestBuilder.query(INACTIVITY_TIMEOUT, options.inactivityTimeout());

    if (options.model() != null)
      requestBuilder.query(MODEL, options.model());

    if (options.keywordsThreshold() != null)
      requestBuilder.query(KEYWORDS_THRESHOLD, options.keywordsThreshold());

    if (options.keywords() != null && options.keywords().length > 0) {
      final String keywords = RequestUtils.join(Arrays.asList(options.keywords()), ",");
      requestBuilder.query(KEYWORDS, RequestUtils.encode(keywords));
    }

    if (options.wordAlternativesThreshold() != null)
      requestBuilder.query(WORD_ALTERNATIVES_THRESHOLD, options.wordAlternativesThreshold());
  }

  /**
   * Creates an asynchronous recognition request.
   *
   * @param audio the audio
   * @param recognizeOptions the recognize options
   * @param recognitionJobOptions the recognition job options
   * @return the service call
   */
  public ServiceCall<RecognitionJob> createRecognitionJob(final File audio, final RecognizeOptions recognizeOptions, final RecognitionJobOptions recognitionJobOptions) {
    Validator.isTrue(audio != null && audio.exists(), "audio file is null or does not exist");

    final double fileSize = audio.length() / Math.pow(1024, 2);
    Validator.isTrue(fileSize < 100.0, "The audio file is greater than 100MB.");

    String contentType = MediaTypeUtils.getMediaTypeFromFile(audio);
    if (recognizeOptions != null && recognizeOptions.contentType() != null)
      contentType = recognizeOptions.contentType();
    Validator.notNull(contentType, "The audio format cannot be recognized");

    final RequestBuilder requestBuilder = RequestBuilder.post(PATH_RECOGNITIONS);
    buildRecognizeRequest(requestBuilder, recognizeOptions);
    buildRecognitionJobRequest(requestBuilder, recognitionJobOptions);
    
    requestBuilder.body(RequestBody.create(MediaType.parse(contentType), audio));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(RecognitionJob.class));
  }

  /**
   * Creates a session to lock an engine to the session. You can use the session for multiple
   * recognition requests, so that each request is processed with the same speech-to-text engine.
   * Use the cookie that is returned from this operation in the Set-Cookie header for each request
   * that uses this session. The session expires after 15 minutes of inactivity.
   * 
   * @return the {@link SpeechSession}
   */
  public ServiceCall<SpeechSession> createSession() {
    final String model = null;
    return createSession(model);
  }

  /**
   * Creates a session to lock an engine to the session. You can use the session for multiple
   * recognition requests, so that each request is processed with the same speech-to-text engine.
   * Use the cookie that is returned from this operation in the Set-Cookie header for each request
   * that uses this session. The session expires after 15 minutes of inactivity.
   * 
   * @param model the model
   * @return the {@link SpeechSession}
   */
  public ServiceCall<SpeechSession> createSession(SpeechModel model) {
    Validator.notNull(model, "Model cannot be null");
    return createSession(model.getName());
  }

  /**
   * Creates a session to lock an engine to the session. You can use the session for multiple
   * recognition requests, so that each request is processed with the same speech-to-text engine.
   * Use the cookie that is returned from this operation in the Set-Cookie header for each request
   * that uses this session. The session expires after 15 minutes of inactivity.
   * 
   * @param model the model
   * @return the {@link SpeechSession}
   */
  public ServiceCall<SpeechSession> createSession(final String model) {
    final RequestBuilder request = RequestBuilder.post(PATH_SESSIONS);

    if (model != null)
      request.query(MODEL, model);

    return createServiceCall(request.build(), ResponseConverterUtils.getObject(SpeechSession.class));
  }

  /**
   * Delete recognition.
   *
   * @param id the id
   * @return the service call
   */
  public ServiceCall<Void> deleteRecognitionJob(String id) {
    Validator.notNull(id, "id cannot be null");

    Request request = RequestBuilder.delete(String.format(PATH_RECOGNITION, id)).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes a {@link SpeechSession}.
   *
   * @param session the speech session to delete
   * @return the service call
   */
  public ServiceCall<Void> deleteSession(final SpeechSession session) {
    Validator.notNull(session, "session cannot be null");

    Request request = RequestBuilder.delete(String.format(PATH_SESSION, session.getSessionId())).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Gets the speech model based on a given name.
   * 
   * @param modelName the model name
   * @return the {@link SpeechModel}
   */
  public ServiceCall<SpeechModel> getModel(final String modelName) {
    Validator.notNull(modelName, "name cannot be null");

    Request request = RequestBuilder.get(String.format(PATH_MODEL, modelName)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(SpeechModel.class));
  }

  /**
   * Gets the models.
   * 
   * @return the {@link SpeechModel}s
   */
  public ServiceCall<List<SpeechModel>> getModels() {
    Request request = RequestBuilder.get(PATH_MODELS).build();
    ResponseConverter<List<SpeechModel>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_LIST_MODELS, "models");
    return createServiceCall(request, converter);
  }

  /**
   * Gets the recognition.
   *
   * @param id the id
   * @return the recognition
   */
  public ServiceCall<RecognitionJob> getRecognitionJob(String id) {
    Validator.notNull(id, "id cannot be null");

    Request request = RequestBuilder.get(String.format(PATH_RECOGNITION, id)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(RecognitionJob.class));
  }


  /**
   * Returns the status and id of all outstanding jobs. If a job was created with a callback URL and
   * a user token, the method also returns the user token for the job.
   *
   * @return the recognitions
   */
  public ServiceCall<List<RecognitionJob>> getRecognitionJobs() {
    Request request = RequestBuilder.get(PATH_RECOGNITIONS).build();

    ResponseConverter<List<RecognitionJob>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_LIST_RECOGNITIONS, "recognitions");
    return createServiceCall(request, converter);
  }

  /**
   * Gets the session status. Concurrent recognition tasks during the same session are not allowed.
   * This method offers a way to check whether the session can accept another recognition task. The
   * returned state must be "initialized" to call {@link #recognize(File, RecognizeOptions)} .
   * 
   * @param session the speech session
   * @return the model
   */
  public ServiceCall<SpeechSessionStatus> getRecognizeStatus(final SpeechSession session) {
    Validator.notNull(session, "session cannot be null");
    Validator.notNull(session.getSessionId(), "session.sessionId cannot be null");

    Request request = RequestBuilder.get(String.format(PATH_SESSION_RECOGNIZE, session.getSessionId())).build();
    ResponseConverter<SpeechSessionStatus> converter =
        ResponseConverterUtils.getGenericObject(TYPE_SESSION_STATUS, "session");
    return createServiceCall(request, converter);
  }

  /**
   * Recognizes an audio file and returns {@link SpeechResults}. It will try to recognize the audio
   * format based on the file extension.<br>
   * Here is an example of how to recognize an audio file:
   * 
   * <pre>
   * SpeechToText service = new SpeechToText();
   * service.setUsernameAndPassword(&quot;USERNAME&quot;, &quot;PASSWORD&quot;);
   * service.setEndPoint(&quot;SERVICE_URL&quot;);
   * 
   * SpeechResults results = service.recognize(new File(&quot;sample1.wav&quot;)).execute();
   * System.out.println(results);
   * </pre>
   * 
   * @param audio the audio file
   * @return the {@link SpeechResults}
   * @throws IllegalArgumentException if the file extension doesn't match a valid audio type
   */
  public ServiceCall<SpeechResults> recognize(File audio) {
    return recognize(audio, (RecognizeOptions) null);
  }

  /**
   * Recognizes an audio file and returns {@link SpeechResults}.<br>
   * <br>
   * Here is an example of how to recognize an audio file:
   * 
   * <pre>
   * SpeechToText service = new SpeechToText();
   * service.setUsernameAndPassword(&quot;USERNAME&quot;, &quot;PASSWORD&quot;);
   * service.setEndPoint(&quot;SERVICE_URL&quot;);
   * 
   * RecognizeOptions options = new RecognizeOptions().maxAlternatives(3).continuous(true);
   * 
   * File audio = new File(&quot;sample1.wav&quot;);
   * 
   * SpeechResults results = service.recognize(audio, options).execute();
   * System.out.println(results);
   * </pre>
   * 
   * @param audio the audio file
   * @param options the recognize options
   * @return the {@link SpeechResults}
   */

  public ServiceCall<SpeechResults> recognize(File audio, RecognizeOptions options) {
    Validator.isTrue(audio != null && audio.exists(), "audio file is null or does not exist");

    final double fileSize = audio.length() / Math.pow(1024, 2);
    Validator.isTrue(fileSize < 100.0, "The audio file is greater than 100MB.");

    String contentType = MediaTypeUtils.getMediaTypeFromFile(audio);
    if (options != null && options.contentType() != null)
      contentType = options.contentType();
    Validator.notNull(contentType, "The audio format cannot be recognized");

    String path = PATH_RECOGNIZE;
    if (options != null && options.sessionId() != null && !options.sessionId().isEmpty())
      path = String.format(PATH_SESSION_RECOGNIZE, options.sessionId());

    final RequestBuilder requestBuilder = RequestBuilder.post(path);
    buildRecognizeRequest(requestBuilder, options);
    requestBuilder.body(RequestBody.create(MediaType.parse(contentType), audio));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(SpeechResults.class));
  }

  /**
   * Recognizes an audio {@link InputStream} using a {@link WebSocket}.<br>
   * The {@link RecognizeCallback} instance will be called every time the service sends
   * {@link SpeechResults}.<br>
   * <br>
   * 
   * Here is an example of how to recognize an audio file using WebSockets and get interim results:
   * 
   * <pre>
   * SpeechToText service = new SpeechToText();
   * service.setUsernameAndPassword(&quot;USERNAME&quot;, &quot;PASSWORD&quot;);
   * service.setEndPoint(&quot;SERVICE_URL&quot;);
   * 
   * RecognizeOptions options = new RecognizeOptions().maxAlternatives(2).continuous(true);
   * 
   * FileInputStream audio = new FileInputStream(&quot;sample1.wav&quot;);
   * 
   * service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
   *   &#064;Override
   *   public void onTranscript(SpeechResults speechResults) {
   *     System.out.println(speechResults);
   *   }
   * });
   * </pre>
   * 
   * @param audio the audio input stream
   * @param options the recognize options
   * @param callback the callback
   */
  public void recognizeUsingWebSocket(final InputStream audio, final RecognizeOptions options,
      final RecognizeCallback callback) {
    Validator.notNull(audio, "audio cannot be null");
    Validator.notNull(options, "options cannot be null");
    Validator.notNull(options.contentType(), "options.contentType cannot be null");
    Validator.notNull(callback, "callback cannot be null");


    getToken().enqueue(new ServiceCallback<String>() {
      @Override
      public void onFailure(Exception e) {
        callback.onError(e);
      }

      @Override
      public void onResponse(String token) {
        String url = getEndPoint().replaceFirst("(https|http)", "wss");
        WebSocketManager wsManager = new WebSocketManager(url + PATH_RECOGNIZE, configureHttpClient(), token);
        wsManager.recognize(audio, options, callback);
      }
    });
  }

  /**
   * Registers a callback URL with the service for use with subsequent asynchronous recognition
   * requests. The service attempts to register, or white-list, the callback URL. To be registered
   * successfully, the callback URL must respond to a <code>GET</code> request from the service,
   * after which the service responds with response code 201 to the original registration request.
   * <br/>
   * If you specify a <code>secret</code> with the request, the service uses it as a key to
   * calculate an <code>HMAC-SHA1</code> signature of a random challenge string in its response to
   * the request. The signature provides authentication and data integrity for HTTP communications.
   *
   * @param callbackUrl the callback url
   * @param secret the secret
   * @return the service call
   */
  public ServiceCall<RecognitionCallback> registerCallback(String callbackUrl, String secret) {
    Validator.notNull(callbackUrl, "callbackUrl cannot be null");

    RequestBuilder requestBuilder = RequestBuilder.post(PATH_REGISTER_CALLBACK);
    requestBuilder.query(CALLBACK_URL, callbackUrl);
    
    if (secret != null) {
      requestBuilder.query(SECRET, secret);
    }
    
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(RecognitionCallback.class));
  }
}

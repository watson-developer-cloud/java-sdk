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
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Customization;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Customization.WordTypeToAdd;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionCallback;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJob;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJobOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSessionStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Word;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.WordData;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.MediaTypeUtils;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.SpeechToTextWebSocketListener;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.WebSocket;

/**
 * The Speech to Text service uses IBM's speech recognition capabilities to convert English speech into text. The
 * transcription of incoming audio is continuously sent back to the client with minimal delay, and it is corrected as
 * more speech is heard.
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/speech-to-text.html"> Speech to Text</a>
 */
public class SpeechToText extends WatsonService {

  private static final String ALLOW_OVERWRITE = "allow_overwrite";
  private static final String CALLBACK_URL = "callback_url";
  private static final String CONTINUOUS = "continuous";
  private static final String CUSTOMIZATION_ID = "customization_id";
  private static final String CUSTOMIZATION_WEIGHT = "customization_weight";
  private static final String EVENTS = "events";
  private static final String INACTIVITY_TIMEOUT = "inactivity_timeout";
  private static final String KEYWORDS = "keywords";
  private static final String KEYWORDS_THRESHOLD = "keywords_threshold";
  private static final String LANGUAGE = "language";
  private static final String MAX_ALTERNATIVES = "max_alternatives";
  private static final String MODEL = "model";
  private static final String PROFANITY_FILTER = "profanity_filter";
  private static final String RESULTS_TTL = "results_ttl";
  private static final String SECRET = "secret";
  private static final String SERVICE_NAME = "speech_to_text";
  private static final String SMART_FORMATTING = "smart_formatting";
  private static final String SPEAKER_LABELS = "speaker_labels";
  private static final String TIMESTAMPS = "timestamps";
  private static final String USER_TOKEN = "user_token";
  private static final String WORD_ALTERNATIVES_THRESHOLD = "word_alternatives_threshold";
  private static final String WORD_CONFIDENCE = "word_confidence";
  private static final String WORD_TYPE = "word_type";
  private static final String WORD_SORT = "sort";
  private static final String WORD_TYPE_TO_ADD = "word_type_to_add";
  private static final String WORDS = "words";

  private static final String PATH_CORPORA = "/v1/customizations/%s/corpora";
  private static final String PATH_CORPUS = "/v1/customizations/%s/corpora/%s";
  private static final String PATH_CUSTOMIZATION = "/v1/customizations/%s";
  private static final String PATH_CUSTOMIZATIONS = "/v1/customizations";
  private static final String PATH_MODEL = "/v1/models/%s";
  private static final String PATH_MODELS = "/v1/models";
  private static final String PATH_RECOGNITION = "/v1/recognitions/%s";
  private static final String PATH_RECOGNITIONS = "/v1/recognitions";
  private static final String PATH_RECOGNIZE = "/v1/recognize";
  private static final String PATH_REGISTER_CALLBACK = "/v1/register_callback";
  private static final String PATH_RESET = "/v1/customizations/%s/reset";
  private static final String PATH_SESSION = "/v1/sessions/%s";
  private static final String PATH_SESSION_RECOGNIZE = "/v1/sessions/%s/recognize";
  private static final String PATH_SESSIONS = "/v1/sessions";
  private static final String PATH_TRAIN = "/v1/customizations/%s/train";
  private static final String PATH_UPGRADE = "/v1/customizations/%s/upgrade";
  private static final String PATH_WORD = "/v1/customizations/%s/words/%s";
  private static final String PATH_WORDS = "/v1/customizations/%s/words";

  private static final Type TYPE_CORPORA = new TypeToken<List<Corpus>>() { }.getType();
  private static final Type TYPE_LIST_CUSTOMIZATION = new TypeToken<List<Customization>>() { }.getType();
  private static final Type TYPE_LIST_MODELS = new TypeToken<List<SpeechModel>>() { }.getType();
  private static final Type TYPE_LIST_RECOGNITIONS = new TypeToken<List<RecognitionJob>>() { }.getType();
  private static final Type TYPE_SESSION_STATUS = new TypeToken<SpeechSessionStatus>() { }.getType();
  private static final Type TYPE_WORDS = new TypeToken<List<WordData>>() { }.getType();

  private static final String URL = "https://stream.watsonplatform.net/speech-to-text/api";
  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();

  /**
   * Instantiates a new Speech to Text service.
   */
  public SpeechToText() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
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

    if (jobOptions.userToken() != null) {
      requestBuilder.query(USER_TOKEN, jobOptions.userToken());
    }

    if (jobOptions.resultsTtl() != null) {
      requestBuilder.query(RESULTS_TTL, jobOptions.resultsTtl());
    }

    if (jobOptions.callbackUrl() != null) {
      requestBuilder.query(CALLBACK_URL, jobOptions.callbackUrl());
    }

    if (jobOptions.events() != null) {
      requestBuilder.query(EVENTS, RequestUtils.join(jobOptions.events(), ","));
    }
  }

  /**
   * Builds the recognize request using the {@link RecognizeOptions}.
   *
   * @param requestBuilder the request builder
   * @param options the recognize options
   */
  private void buildRecognizeRequest(RequestBuilder requestBuilder, RecognizeOptions options) {
    if (options == null) {
      return;
    }

    if (options.wordConfidence() != null) {
      requestBuilder.query(WORD_CONFIDENCE, options.wordConfidence());
    }

    if (options.continuous() != null) {
      requestBuilder.query(CONTINUOUS, options.continuous());
    }

    if (options.smartFormatting() != null) {
      requestBuilder.query(SMART_FORMATTING, options.smartFormatting());
    }

    if (options.speakerLabels() != null) {
      requestBuilder.query(SPEAKER_LABELS, options.speakerLabels());
    }

    if (options.profanityFilter() != null) {
      requestBuilder.query(PROFANITY_FILTER, options.profanityFilter());
    }

    if (options.maxAlternatives() != null) {
      requestBuilder.query(MAX_ALTERNATIVES, options.maxAlternatives());
    }

    if (options.timestamps() != null) {
      requestBuilder.query(TIMESTAMPS, options.timestamps());
    }

    if (options.inactivityTimeout() != null) {
      requestBuilder.query(INACTIVITY_TIMEOUT, options.inactivityTimeout());
    }

    if (options.model() != null) {
      requestBuilder.query(MODEL, options.model());
    }

    if (options.keywordsThreshold() != null) {
      requestBuilder.query(KEYWORDS_THRESHOLD, options.keywordsThreshold());
    }

    if ((options.keywords() != null) && (options.keywords().length > 0)) {
      final String keywords = RequestUtils.join(options.keywords(), ",");
      requestBuilder.query(KEYWORDS, RequestUtils.encode(keywords));
    }

    if (options.wordAlternativesThreshold() != null) {
      requestBuilder.query(WORD_ALTERNATIVES_THRESHOLD, options.wordAlternativesThreshold());
    }

    if (options.customizationId() != null) {
      requestBuilder.query(CUSTOMIZATION_ID, options.customizationId());
    }

    if (options.customizationWeight() != null) {
      requestBuilder.query(CUSTOMIZATION_WEIGHT, options.customizationWeight());
    }
  }

  /**
   * Upgrades a custom language model to the latest release level of the Speech to Text service. The method bases the
   * upgrade on the latest trained data stored for the custom model. <strong>Note: This method is not currently
   * implemented. It will be added for a future release of the API. </strong>
   *
   * @param customizationId the customization id
   * @return the service call
   */
  @SuppressWarnings("unused")
  private ServiceCall<Void> upgradeCustomization(String customizationId) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.post(String.format(PATH_UPGRADE, customizationId));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Adds a single corpus text file of new training data to the custom language model. Use multiple requests to submit
   * multiple corpus text files. Only the owner of a custom model can use this method to add a corpus to the model.
   * Submit a plain text file that contains sample sentences from the domain of interest to enable the service to
   * extract words in context. The more sentences you add that represent the context in which speakers use words from
   * the domain, the better the service's recognition accuracy. Adding a corpus does not affect the custom model until
   * you train the model for the new data by using the POST /v1/customizations/{customization_id}/train method.
   *
   * @param customizationId The GUID of the custom language model to which a corpus is to be added. You must make the
   *        request with the service credentials of the model's owner.
   * @param corpusName The name of the corpus that is to be added. The name cannot contain spaces and cannot be the
   *        string user, which is reserved by the service to denote custom words added or modified by the user.
   * @param corpusFile A plain text file that contains the training data for the corpus. Encode the file in UTF-8 if it
   *        contains non-ASCII characters; the service assumes UTF-8 encoding if it encounters non-ASCII characters.
   * @param allowOverwrite Indicates whether the specified corpus is to overwrite an existing corpus with the same name.
   *        If a corpus with the same name already exists, the request fails unless allow_overwrite is set to true; by
   *        default, the parameter is false. The parameter has no effect if a corpus with the same name does not already
   *        exist.
   * @return the service call
   */
  public ServiceCall<Void> addCorpus(String customizationId, String corpusName, File corpusFile,
      Boolean allowOverwrite) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    Validator.notNull(corpusName, "corpusName cannot be null");
    Validator.isTrue((corpusFile != null) && corpusFile.exists(), "corpusFile is null or does not exist");
    RequestBuilder requestBuilder = RequestBuilder.post(String.format(PATH_CORPUS, customizationId, corpusName));
    if (allowOverwrite != null) {
      requestBuilder.query(ALLOW_OVERWRITE, allowOverwrite);
    }

    requestBuilder.body(RequestBody.create(HttpMediaType.TEXT, corpusFile));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Add/Updates a custom word to a custom language model. The service automatically populates the words resource for a
   * custom model with out-of-vocabulary (OOV) words found in each corpus added to the model. You can use this method to
   * add additional words or to modify existing words in the words resource. Adding or modifying a custom word does not
   * affect the custom model until you train the model for the new data.
   *
   * @param customizationId The GUID of the custom language model to which a word is to be added. You must make the
   *        request with the service credentials of the model's owner.
   * @param word the word to add/update
   * @return the service call
   */
  public ServiceCall<Void> addWord(String customizationId, Word word) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    Validator.notNull(word, "word cannot be null");
    Validator.notNull(word.getWord(), "word.word cannot be null");

    RequestBuilder requestBuilder = RequestBuilder.put(String.format(PATH_WORD, customizationId, word.getWord()));
    requestBuilder.bodyContent(GSON.toJson(word), HttpMediaType.APPLICATION_JSON);

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());

  }

  /**
   * Adds one or more custom words to a custom language model. The service automatically populates the words resource
   * for a custom model with out-of-vocabulary (OOV) words found in each corpus added to the model. You can use this
   * method to add additional words or to modify existing words in the words resource. Adding or modifying custom words
   * does not affect the custom model until you train the model for the new data.
   *
   * @param customizationId The GUID of the custom language model to which words are to be added. You must make the
   *        request with the service credentials of the model's owner.
   * @param words the list of words to be added.
   * @return the service call
   */
  public ServiceCall<Void> addWords(String customizationId, Word... words) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    Validator.notNull(words, "words cannot be null");
    Validator.isTrue(words.length > 0, "words cannot be empty");

    RequestBuilder requestBuilder = RequestBuilder.post(String.format(PATH_WORDS, customizationId));

    Map<String, Object> wordsAsMap = new HashMap<String, Object>();
    wordsAsMap.put(WORDS, words);

    requestBuilder.bodyContent(GSON.toJson(wordsAsMap), HttpMediaType.APPLICATION_JSON);

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Creates the customization.
   *
   * @param name The customization name
   * @param baseModel The name of the language model that is to be customized by the new model. e.g:
   *        'en-US_BroadbandModel'.
   * @param description the customization description
   * @param dialect the language dialect
   * @return the service call with the GUID which identifies the created custom model.
   */
  public ServiceCall<Customization> createCustomization(String name, SpeechModel baseModel, String description,
      String dialect) {
    Validator.notNull(name, "name cannot be null");
    Validator.notNull(baseModel, "baseModel cannot be null");

    RequestBuilder requestBuilder = RequestBuilder.post(PATH_CUSTOMIZATIONS);

    Customization newCustomization = new Customization();
    newCustomization.setBaseModelName(baseModel.getName());
    newCustomization.setDescription(description);
    newCustomization.setName(name);
    if (dialect != null)
      newCustomization.setDialect(dialect);
    requestBuilder.bodyContent(GSON.toJson(newCustomization), HttpMediaType.APPLICATION_JSON);
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Customization.class));
  }

  /**
   * Creates the customization.
   *
   * @param name The customization name
   * @param baseModel The name of the language model that is to be customized by the new model. e.g:
   *        'en-US_BroadbandModel'.
   * @param description the customization description
   * @return the service call with the GUID which identifies the created custom model.
   */
  public ServiceCall<Customization> createCustomization(String name, SpeechModel baseModel, String description) {
    return createCustomization(name, baseModel, description, null);
  }

  /**
   * Creates an asynchronous recognition request.
   *
   * @param audio the audio
   * @param recognizeOptions the recognize options
   * @param recognitionJobOptions the recognition job options
   * @return the service call
   */
  public ServiceCall<RecognitionJob> createRecognitionJob(final File audio, final RecognizeOptions recognizeOptions,
      final RecognitionJobOptions recognitionJobOptions) {
    Validator.isTrue((audio != null) && audio.exists(), "audio file is null or does not exist");

    final double fileSize = audio.length() / Math.pow(1024, 2);
    Validator.isTrue(fileSize < 100.0, "The audio file is greater than 100MB.");

    String contentType = MediaTypeUtils.getMediaTypeFromFile(audio);
    if ((recognizeOptions != null) && (recognizeOptions.contentType() != null)) {
      contentType = recognizeOptions.contentType();
    }
    Validator.notNull(contentType, "The audio format cannot be recognized");

    final RequestBuilder requestBuilder = RequestBuilder.post(PATH_RECOGNITIONS);
    buildRecognizeRequest(requestBuilder, recognizeOptions);
    buildRecognitionJobRequest(requestBuilder, recognitionJobOptions);

    requestBuilder.body(RequestBody.create(MediaType.parse(contentType), audio));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(RecognitionJob.class));
  }

  /**
   * Creates a session to lock an engine to the session. You can use the session for multiple recognition requests, so
   * that each request is processed with the same speech-to-text engine. The session expires after 30 seconds of
   * inactivity.
   *
   * @return the {@link SpeechSession}
   */
  public ServiceCall<SpeechSession> createSession() {
    final String model = null;
    return createSession(model);
  }

  /**
   * Creates a session to lock an engine to the session. You can use the session for multiple recognition requests, so
   * that each request is processed with the same speech-to-text engine. The session expires after 30 seconds of
   * inactivity.
   *
   * @param model the model
   * @return the {@link SpeechSession}
   */
  public ServiceCall<SpeechSession> createSession(SpeechModel model) {
    Validator.notNull(model, "Model cannot be null");
    return createSession(model.getName());
  }

  /**
   * Creates a session to lock an engine to the session. You can use the session for multiple recognition requests, so
   * that each request is processed with the same speech-to-text engine. The session expires after 30 seconds of
   * inactivity.
   *
   * @param model the model
   * @return the {@link SpeechSession}
   */
  public ServiceCall<SpeechSession> createSession(final String model) {
    final RequestBuilder request = RequestBuilder.post(PATH_SESSIONS);

    if (model != null) {
      request.query(MODEL, model);
    }

    return createServiceCall(request.build(), ResponseConverterUtils.getObject(SpeechSession.class));
  }

  /**
   * Delete customization corpus.
   *
   * @param customizationId The GUID of the custom language model from which the corpus is to be deleted. You must make
   *        the request with the service credentials of the model's owner.
   * @param corpusName the corpus name
   * @return the service call
   */
  public ServiceCall<Void> deleteCorpus(String customizationId, String corpusName) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    Validator.notNull(corpusName, "corpusName cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.delete(String.format(PATH_CORPUS, customizationId, corpusName));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Delete customization.
   *
   * @param customizationId The GUID of the custom language model being deleted. You must make the request with the
   *        service credentials of the model's owner.
   * @return the service call
   */
  public ServiceCall<Void> deleteCustomization(String customizationId) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.delete(String.format(PATH_CUSTOMIZATION, customizationId));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
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
   * Deletes a custom word from a custom language model. You can remove any word that you added to the custom model's
   * words resource via any means. However, if the word also exists in the service's base vocabulary, the service
   * removes only the custom pronunciation for the word; the word remains in the base vocabulary.
   *
   * @param customizationId The GUID of the custom language model from which the word is being deleted. You must make
   *        the request with the service credentials of the model's owner.
   * @param wordName the word name
   * @return the service call
   */
  public ServiceCall<Void> deleteWord(String customizationId, String wordName) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    Validator.notNull(wordName, "words cannot be null");

    RequestBuilder requestBuilder = RequestBuilder.delete(String.format(PATH_WORD, customizationId, wordName));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Gets the customization corpus list.
   *
   * @param customizationId The GUID of the custom language model whose corpora is being queried. You must make the
   *        request with the service credentials of the model's owner.
   * @return the list of customization corpora
   */
  public ServiceCall<List<Corpus>> getCorpora(String customizationId) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_CORPORA, customizationId));
    ResponseConverter<List<Corpus>> converter = ResponseConverterUtils.getGenericObject(TYPE_CORPORA, "corpora");

    return createServiceCall(requestBuilder.build(), converter);
  }

  /**
   * Gets the specified corpus for the customization.
   *
   * @param customizationId The GUID of the custom language model whose corpus is to be returned. You must make the
   *        request with the service credentials of the model's owner.
   * @param corpusName The name of the corpus that is to be returned.
   * @return The customization corpus.
   */

  public ServiceCall<Corpus> getCorpus(String customizationId, String corpusName) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    Validator.notNull(corpusName, "corpusName cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_CORPUS, customizationId, corpusName));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Corpus.class));
  }

  /**
   * Gets the customization information.
   *
   * @param customizationId The GUID of the custom language model being queried. You must make the request with the
   *        service credentials of the model's owner.
   * @return the customization
   */
  public ServiceCall<Customization> getCustomization(String customizationId) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_CUSTOMIZATION, customizationId));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Customization.class));
  }

  /**
   * Gets all the customizations belonging to the user.
   *
   * @param language The language for which custom models are to be returned.
   * @return the customizations
   */
  public ServiceCall<List<Customization>> getCustomizations(String language) {
    RequestBuilder requestBuilder = RequestBuilder.get(PATH_CUSTOMIZATIONS);

    if (language != null) {
      requestBuilder.query(LANGUAGE, language);
    }
    ResponseConverter<List<Customization>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_LIST_CUSTOMIZATION, "customizations");

    return createServiceCall(requestBuilder.build(), converter);
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
   * Returns the status and id of all outstanding jobs. If a job was created with a callback URL and a user token, the
   * method also returns the user token for the job.
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
   * Gets the session status. Concurrent recognition tasks during the same session are not allowed. This method offers a
   * way to check whether the session can accept another recognition task. The returned state must be "initialized" to
   * call {@link #recognize(File, RecognizeOptions)} .
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
   * Gets information about a word from a custom language model.
   *
   * @param customizationId The GUID of the custom language model containing the word being queried. You must make the
   *        request with the service credentials of the model's owner.
   * @param wordName the word name
   * @return the words
   */
  public ServiceCall<WordData> getWord(String customizationId, String wordName) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    Validator.notNull(wordName, "wordName cannot be null");

    RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_WORD, customizationId, wordName));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(WordData.class));
  }

  /**
   * Gets information about all the words from a custom language model.
   *
   * @param customizationId The GUID of the custom language model to which a corpus is to be added. You must make the
   *        request with the service credentials of the model's owner.
   * @param type the word type. Possible values are: ALL, USER or CORPORA.
   * @return the words
   */
  public ServiceCall<List<WordData>> getWords(String customizationId, Word.Type type) {
    return getWords(customizationId, type, null);
  }

  /**
   * Gets information about all the words from a custom language model.
   *
   * @param customizationId The GUID of the custom language model to which a corpus is to be added. You must make the
   *        request with the service credentials of the model's owner.
   * @param type the word type. Possible values are: ALL, USER or CORPORA. The default is ALL.
   * @param sort the sort order of the results. Possible values are: ALPHA, PLUS_ALPHA, MINUS_ALPHA, COUNT, PLUS_COUNT,
   *        and MINUS_COUNT. The default is ALPHA/PLUS_ALPHA.
   * @return the words
   */
  public ServiceCall<List<WordData>> getWords(String customizationId, Word.Type type, Word.Sort sort) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_WORDS, customizationId));

    if (type != null) {
      requestBuilder.query(WORD_TYPE, type.toString().toLowerCase());
    }
    if (sort != null) {
      requestBuilder.query(WORD_SORT, sort.getSort());
    }

    ResponseConverter<List<WordData>> converter = ResponseConverterUtils.getGenericObject(TYPE_WORDS, WORDS);
    return createServiceCall(requestBuilder.build(), converter);
  }

  /**
   * Recognizes an audio file and returns {@link SpeechResults}. It will try to recognize the audio format based on the
   * file extension.<br>
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
    Validator.isTrue((audio != null) && audio.exists(), "audio file is null or does not exist");

    final double fileSize = audio.length() / Math.pow(1024, 2);
    Validator.isTrue(fileSize < 100.0, "The audio file is greater than 100MB.");

    String contentType = MediaTypeUtils.getMediaTypeFromFile(audio);
    if ((options != null) && (options.contentType() != null)) {
      contentType = options.contentType();
    }
    Validator.notNull(contentType, "The audio format cannot be recognized");

    String path = PATH_RECOGNIZE;
    if ((options != null) && (options.sessionId() != null) && !options.sessionId().isEmpty()) {
      path = String.format(PATH_SESSION_RECOGNIZE, options.sessionId());
    }

    final RequestBuilder requestBuilder = RequestBuilder.post(path);
    buildRecognizeRequest(requestBuilder, options);
    requestBuilder.body(RequestBody.create(MediaType.parse(contentType), audio));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(SpeechResults.class));
  }

  /**
   * Recognizes an audio {@link InputStream} using a {@link WebSocket}.<br>
   * The {@link RecognizeCallback} instance will be called every time the service sends {@link SpeechResults}.<br>
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
   * @param audio the audio {@link InputStream}
   * @param options the {@link RecognizeOptions}
   * @param callback the {@link RecognizeCallback} instance where results will be send
   * @return the {@link WebSocket}
   */
  public WebSocket recognizeUsingWebSocket(final InputStream audio, final RecognizeOptions options,
      final RecognizeCallback callback) {
    Validator.notNull(audio, "audio cannot be null");
    Validator.notNull(options, "options cannot be null");
    Validator.notNull(options.contentType(), "options.contentType cannot be null");
    Validator.notNull(callback, "callback cannot be null");

    HttpUrl.Builder urlBuilder = HttpUrl.parse(getEndPoint() + PATH_RECOGNIZE).newBuilder();

    if (options.model() != null && !options.model().isEmpty()) {
      urlBuilder.addQueryParameter(MODEL, options.model());
    }

    if (options.customizationId() != null && !options.customizationId().isEmpty()) {
      urlBuilder.addQueryParameter(CUSTOMIZATION_ID, options.customizationId());
    }

    if (options.customizationWeight() != null) {
      urlBuilder.addQueryParameter(CUSTOMIZATION_WEIGHT, String.valueOf(options.customizationWeight()));
    }

    String url = urlBuilder.toString().replace("https://", "wss://");
    Builder builder = new Request.Builder().url(url);

    setAuthentication(builder);
    setDefaultHeaders(builder);

    OkHttpClient client = configureHttpClient();
    return client.newWebSocket(builder.build(), new SpeechToTextWebSocketListener(audio, options, callback));
  }

  /**
   * Registers a callback URL with the service for use with subsequent asynchronous recognition requests. The service
   * attempts to register, or white-list, the callback URL. To be registered successfully, the callback URL must respond
   * to a <code>GET</code> request from the service, after which the service responds with response code 201 to the
   * original registration request. <br>
   * If you specify a <code>secret</code> with the request, the service uses it as a key to calculate an
   * <code>HMAC-SHA1</code> signature of a random challenge string in its response to the request. The signature
   * provides authentication and data integrity for HTTP communications.
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

  /**
   * Resets a custom language model by removing all corpora and words from the model. Resetting a custom model
   * initializes the model to its state when it was first created. Metadata such as the name and language of the model
   * are preserved.
   *
   * @param customizationId The GUID of the custom language model being reset. You must make the request with the
   *        service credentials of the model's owner.
   * @return the service call
   */
  public ServiceCall<Void> resetCustomization(String customizationId) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.post(String.format(PATH_RESET, customizationId));
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Initiates the training of a custom language model with new corpora, words, or both. After adding training data to
   * the custom model with the corpora or words methods, use this method to begin the actual training of the model on
   * the new data. You can specify whether the custom model is to be trained with all words from its words resources or
   * only with words that were added or modified by the user.<br>
   * <br>
   * This method is asynchronous and can take on the order of minutes to complete depending on the amount of data on
   * which the service is being trained and the current load on the service. You can monitor the status of the training
   * by using the {@link SpeechToText#getCustomization(String)} method to poll the model's status.<br>
   * <br>
   * Training can fail to start for the following reasons:
   * <ul>
   * <li>No training data (corpora or words) have been added to the custom model.</li>
   * <li>Pre-processing of corpora to generate a list of out-of-vocabulary (OOV) words is not complete.</li>
   * <li>Pre-processing of words to validate or auto-generate sounds-like pronunciations is not complete.</li>
   * <li>One or more words that were added to the custom model have invalid sounds-like pronunciations that you must
   * fix.</li>
   * </ul>
   *
   * @param customizationId The GUID of the custom language model being trained. You must make the request with the
   *        service credentials of the model's owner.
   * @param wordTypeToAdd the word type to add
   * @return the service call
   */
  public ServiceCall<Void> trainCustomization(String customizationId, WordTypeToAdd wordTypeToAdd) {
    Validator.notNull(customizationId, "customizationId cannot be null");
    RequestBuilder requestBuilder = RequestBuilder.post(String.format(PATH_TRAIN, customizationId));
    if (wordTypeToAdd != null) {
      requestBuilder.query(WORD_TYPE_TO_ADD, wordTypeToAdd.toString().toLowerCase());
    }
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }
}

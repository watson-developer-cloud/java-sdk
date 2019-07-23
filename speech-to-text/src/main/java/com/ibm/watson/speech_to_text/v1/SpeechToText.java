/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.speech_to_text.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.AuthenticatorConfig;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.speech_to_text.v1.model.AcousticModel;
import com.ibm.watson.speech_to_text.v1.model.AcousticModels;
import com.ibm.watson.speech_to_text.v1.model.AddAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.AddCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.AddGrammarOptions;
import com.ibm.watson.speech_to_text.v1.model.AddWordOptions;
import com.ibm.watson.speech_to_text.v1.model.AddWordsOptions;
import com.ibm.watson.speech_to_text.v1.model.AudioListing;
import com.ibm.watson.speech_to_text.v1.model.AudioResources;
import com.ibm.watson.speech_to_text.v1.model.CheckJobOptions;
import com.ibm.watson.speech_to_text.v1.model.CheckJobsOptions;
import com.ibm.watson.speech_to_text.v1.model.Corpora;
import com.ibm.watson.speech_to_text.v1.model.Corpus;
import com.ibm.watson.speech_to_text.v1.model.CreateAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.CreateJobOptions;
import com.ibm.watson.speech_to_text.v1.model.CreateLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteGrammarOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteJobOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteUserDataOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteWordOptions;
import com.ibm.watson.speech_to_text.v1.model.GetAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.GetAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.GetCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.GetGrammarOptions;
import com.ibm.watson.speech_to_text.v1.model.GetLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.GetModelOptions;
import com.ibm.watson.speech_to_text.v1.model.GetWordOptions;
import com.ibm.watson.speech_to_text.v1.model.Grammar;
import com.ibm.watson.speech_to_text.v1.model.Grammars;
import com.ibm.watson.speech_to_text.v1.model.LanguageModel;
import com.ibm.watson.speech_to_text.v1.model.LanguageModels;
import com.ibm.watson.speech_to_text.v1.model.ListAcousticModelsOptions;
import com.ibm.watson.speech_to_text.v1.model.ListAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.ListCorporaOptions;
import com.ibm.watson.speech_to_text.v1.model.ListGrammarsOptions;
import com.ibm.watson.speech_to_text.v1.model.ListLanguageModelsOptions;
import com.ibm.watson.speech_to_text.v1.model.ListModelsOptions;
import com.ibm.watson.speech_to_text.v1.model.ListWordsOptions;
import com.ibm.watson.speech_to_text.v1.model.RecognitionJob;
import com.ibm.watson.speech_to_text.v1.model.RecognitionJobs;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.RegisterCallbackOptions;
import com.ibm.watson.speech_to_text.v1.model.RegisterStatus;
import com.ibm.watson.speech_to_text.v1.model.ResetAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.ResetLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.speech_to_text.v1.model.SpeechModels;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.speech_to_text.v1.model.TrainAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.TrainLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.TrainingResponse;
import com.ibm.watson.speech_to_text.v1.model.UnregisterCallbackOptions;
import com.ibm.watson.speech_to_text.v1.model.UpgradeAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.UpgradeLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.Word;
import com.ibm.watson.speech_to_text.v1.model.Words;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * The IBM&reg; Speech to Text service provides APIs that use IBM's speech-recognition capabilities to produce
 * transcripts of spoken audio. The service can transcribe speech from various languages and audio formats. In addition
 * to basic transcription, the service can produce detailed information about many different aspects of the audio. For
 * most languages, the service supports two sampling rates, broadband and narrowband. It returns all JSON response
 * content in the UTF-8 character set.
 *
 * For speech recognition, the service supports synchronous and asynchronous HTTP Representational State Transfer (REST)
 * interfaces. It also supports a WebSocket interface that provides a full-duplex, low-latency communication channel:
 * Clients send requests and audio to the service and receive results over a single connection asynchronously.
 *
 * The service also offers two customization interfaces. Use language model customization to expand the vocabulary of a
 * base model with domain-specific terminology. Use acoustic model customization to adapt a base model for the acoustic
 * characteristics of your audio. For language model customization, the service also supports grammars. A grammar is a
 * formal language specification that lets you restrict the phrases that the service can recognize.
 *
 * Language model customization is generally available for production use with most supported languages. Acoustic model
 * customization is beta functionality that is available for all supported languages.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/speech-to-text.html">Speech to Text</a>
 */
public class SpeechToText extends BaseService {

  private static final String SERVICE_NAME = "speech_to_text";
  private static final String URL = "https://stream.watsonplatform.net/speech-to-text/api";

  /**
   * Instantiates a new `SpeechToText`.
   *
   * @deprecated Use SpeechToText(AuthenticatorConfig authenticatorConfig) instead
   */
  @Deprecated
  public SpeechToText() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new `SpeechToText` with username and password.
   *
   * @param username the username
   * @param password the password
   * @deprecated Use SpeechToText(AuthenticatorConfig authenticatorConfig) instead
   */
  @Deprecated
  public SpeechToText(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Instantiates a new `SpeechToText` with the specified authentication configuration.
   *
   * @param authenticatorConfig the authentication configuration for this service
   */
  public SpeechToText(AuthenticatorConfig authenticatorConfig) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
    setAuthenticator(authenticatorConfig);
  }

  /**
   * List models.
   *
   * Lists all language models that are available for use with the service. The information includes the name of the
   * model and its minimum sampling rate in Hertz, among other things.
   *
   * **See also:** [Languages and
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-models#models).
   *
   * @param listModelsOptions the {@link ListModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SpeechModels}
   */
  public ServiceCall<SpeechModels> listModels(ListModelsOptions listModelsOptions) {
    String[] pathSegments = { "v1/models" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "listModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listModelsOptions != null) {
    }
    ResponseConverter<SpeechModels> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<SpeechModels>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List models.
   *
   * Lists all language models that are available for use with the service. The information includes the name of the
   * model and its minimum sampling rate in Hertz, among other things.
   *
   * **See also:** [Languages and
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-models#models).
   *
   * @return a {@link ServiceCall} with a response type of {@link SpeechModels}
   */
  public ServiceCall<SpeechModels> listModels() {
    return listModels(null);
  }

  /**
   * Get a model.
   *
   * Gets information for a single specified language model that is available for use with the service. The information
   * includes the name of the model and its minimum sampling rate in Hertz, among other things.
   *
   * **See also:** [Languages and
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-models#models).
   *
   * @param getModelOptions the {@link GetModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SpeechModel}
   */
  public ServiceCall<SpeechModel> getModel(GetModelOptions getModelOptions) {
    Validator.notNull(getModelOptions, "getModelOptions cannot be null");
    String[] pathSegments = { "v1/models" };
    String[] pathParameters = { getModelOptions.modelId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "getModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SpeechModel> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<SpeechModel>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Recognize audio.
   *
   * Sends audio and returns transcription results for a recognition request. You can pass a maximum of 100 MB and a
   * minimum of 100 bytes of audio with a request. The service automatically detects the endianness of the incoming
   * audio and, for audio that includes multiple channels, downmixes the audio to one-channel mono during transcoding.
   * The method returns only final results; to enable interim results, use the WebSocket API. (With the `curl` command,
   * use the `--data-binary` option to upload the file for the request.)
   *
   * **See also:** [Making a basic HTTP
   * request](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-http#HTTP-basic).
   *
   * ### Streaming mode
   *
   * For requests to transcribe live audio as it becomes available, you must set the `Transfer-Encoding` header to
   * `chunked` to use streaming mode. In streaming mode, the service closes the connection (status code 408) if it does
   * not receive at least 15 seconds of audio (including silence) in any 30-second period. The service also closes the
   * connection (status code 400) if it detects no speech for `inactivity_timeout` seconds of streaming audio; use the
   * `inactivity_timeout` parameter to change the default of 30 seconds.
   *
   * **See also:**
   * * [Audio transmission](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#transmission)
   * * [Timeouts](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#timeouts)
   *
   * ### Audio formats (content types)
   *
   * The service accepts audio in the following formats (MIME types).
   * * For formats that are labeled **Required**, you must use the `Content-Type` header with the request to specify the
   * format of the audio.
   * * For all other formats, you can omit the `Content-Type` header or specify `application/octet-stream` with the
   * header to have the service automatically detect the format of the audio. (With the `curl` command, you can specify
   * either `\"Content-Type:\"` or `\"Content-Type: application/octet-stream\"`.)
   *
   * Where indicated, the format that you specify must include the sampling rate and can optionally include the number
   * of channels and the endianness of the audio.
   * * `audio/alaw` (**Required.** Specify the sampling rate (`rate`) of the audio.)
   * * `audio/basic` (**Required.** Use only with narrowband models.)
   * * `audio/flac`
   * * `audio/g729` (Use only with narrowband models.)
   * * `audio/l16` (**Required.** Specify the sampling rate (`rate`) and optionally the number of channels (`channels`)
   * and endianness (`endianness`) of the audio.)
   * * `audio/mp3`
   * * `audio/mpeg`
   * * `audio/mulaw` (**Required.** Specify the sampling rate (`rate`) of the audio.)
   * * `audio/ogg` (The service automatically detects the codec of the input audio.)
   * * `audio/ogg;codecs=opus`
   * * `audio/ogg;codecs=vorbis`
   * * `audio/wav` (Provide audio with a maximum of nine channels.)
   * * `audio/webm` (The service automatically detects the codec of the input audio.)
   * * `audio/webm;codecs=opus`
   * * `audio/webm;codecs=vorbis`
   *
   * The sampling rate of the audio must match the sampling rate of the model for the recognition request: for broadband
   * models, at least 16 kHz; for narrowband models, at least 8 kHz. If the sampling rate of the audio is higher than
   * the minimum required rate, the service down-samples the audio to the appropriate rate. If the sampling rate of the
   * audio is lower than the minimum required rate, the request fails.
   *
   * **See also:** [Audio
   * formats](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-audio-formats#audio-formats).
   *
   * ### Multipart speech recognition
   *
   * **Note:** The Watson SDKs do not support multipart speech recognition.
   *
   * The HTTP `POST` method of the service also supports multipart speech recognition. With multipart requests, you pass
   * all audio data as multipart form data. You specify some parameters as request headers and query parameters, but you
   * pass JSON metadata as form data to control most aspects of the transcription. You can use multipart recognition to
   * pass multiple audio files with a single request.
   *
   * Use the multipart approach with browsers for which JavaScript is disabled or when the parameters used with the
   * request are greater than the 8 KB limit imposed by most HTTP servers and proxies. You can encounter this limit, for
   * example, if you want to spot a very large number of keywords.
   *
   * **See also:** [Making a multipart HTTP
   * request](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-http#HTTP-multi).
   *
   * @param recognizeOptions the {@link RecognizeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SpeechRecognitionResults}
   */
  public ServiceCall<SpeechRecognitionResults> recognize(RecognizeOptions recognizeOptions) {
    Validator.notNull(recognizeOptions, "recognizeOptions cannot be null");
    String[] pathSegments = { "v1/recognize" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "recognize");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (recognizeOptions.contentType() != null) {
      builder.header("Content-Type", recognizeOptions.contentType());
    }
    if (recognizeOptions.model() != null) {
      builder.query("model", recognizeOptions.model());
    }
    if (recognizeOptions.languageCustomizationId() != null) {
      builder.query("language_customization_id", recognizeOptions.languageCustomizationId());
    }
    if (recognizeOptions.acousticCustomizationId() != null) {
      builder.query("acoustic_customization_id", recognizeOptions.acousticCustomizationId());
    }
    if (recognizeOptions.baseModelVersion() != null) {
      builder.query("base_model_version", recognizeOptions.baseModelVersion());
    }
    if (recognizeOptions.customizationWeight() != null) {
      builder.query("customization_weight", String.valueOf(recognizeOptions.customizationWeight()));
    }
    if (recognizeOptions.inactivityTimeout() != null) {
      builder.query("inactivity_timeout", String.valueOf(recognizeOptions.inactivityTimeout()));
    }
    if (recognizeOptions.keywords() != null) {
      builder.query("keywords", RequestUtils.join(recognizeOptions.keywords(), ","));
    }
    if (recognizeOptions.keywordsThreshold() != null) {
      builder.query("keywords_threshold", String.valueOf(recognizeOptions.keywordsThreshold()));
    }
    if (recognizeOptions.maxAlternatives() != null) {
      builder.query("max_alternatives", String.valueOf(recognizeOptions.maxAlternatives()));
    }
    if (recognizeOptions.wordAlternativesThreshold() != null) {
      builder.query("word_alternatives_threshold", String.valueOf(recognizeOptions.wordAlternativesThreshold()));
    }
    if (recognizeOptions.wordConfidence() != null) {
      builder.query("word_confidence", String.valueOf(recognizeOptions.wordConfidence()));
    }
    if (recognizeOptions.timestamps() != null) {
      builder.query("timestamps", String.valueOf(recognizeOptions.timestamps()));
    }
    if (recognizeOptions.profanityFilter() != null) {
      builder.query("profanity_filter", String.valueOf(recognizeOptions.profanityFilter()));
    }
    if (recognizeOptions.smartFormatting() != null) {
      builder.query("smart_formatting", String.valueOf(recognizeOptions.smartFormatting()));
    }
    if (recognizeOptions.speakerLabels() != null) {
      builder.query("speaker_labels", String.valueOf(recognizeOptions.speakerLabels()));
    }
    if (recognizeOptions.customizationId() != null) {
      builder.query("customization_id", recognizeOptions.customizationId());
    }
    if (recognizeOptions.grammarName() != null) {
      builder.query("grammar_name", recognizeOptions.grammarName());
    }
    if (recognizeOptions.redaction() != null) {
      builder.query("redaction", String.valueOf(recognizeOptions.redaction()));
    }
    if (recognizeOptions.audioMetrics() != null) {
      builder.query("audio_metrics", String.valueOf(recognizeOptions.audioMetrics()));
    }
    builder.bodyContent(recognizeOptions.contentType(), null, null, recognizeOptions.audio());
    ResponseConverter<SpeechRecognitionResults> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<SpeechRecognitionResults>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Register a callback.
   *
   * Registers a callback URL with the service for use with subsequent asynchronous recognition requests. The service
   * attempts to register, or white-list, the callback URL if it is not already registered by sending a `GET` request to
   * the callback URL. The service passes a random alphanumeric challenge string via the `challenge_string` parameter of
   * the request. The request includes an `Accept` header that specifies `text/plain` as the required response type.
   *
   * To be registered successfully, the callback URL must respond to the `GET` request from the service. The response
   * must send status code 200 and must include the challenge string in its body. Set the `Content-Type` response header
   * to `text/plain`. Upon receiving this response, the service responds to the original registration request with
   * response code 201.
   *
   * The service sends only a single `GET` request to the callback URL. If the service does not receive a reply with a
   * response code of 200 and a body that echoes the challenge string sent by the service within five seconds, it does
   * not white-list the URL; it instead sends status code 400 in response to the **Register a callback** request. If the
   * requested callback URL is already white-listed, the service responds to the initial registration request with
   * response code 200.
   *
   * If you specify a user secret with the request, the service uses it as a key to calculate an HMAC-SHA1 signature of
   * the challenge string in its response to the `POST` request. It sends this signature in the `X-Callback-Signature`
   * header of its `GET` request to the URL during registration. It also uses the secret to calculate a signature over
   * the payload of every callback notification that uses the URL. The signature provides authentication and data
   * integrity for HTTP communications.
   *
   * After you successfully register a callback URL, you can use it with an indefinite number of recognition requests.
   * You can register a maximum of 20 callback URLS in a one-hour span of time.
   *
   * **See also:** [Registering a callback
   * URL](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-async#register).
   *
   * @param registerCallbackOptions the {@link RegisterCallbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link RegisterStatus}
   */
  public ServiceCall<RegisterStatus> registerCallback(RegisterCallbackOptions registerCallbackOptions) {
    Validator.notNull(registerCallbackOptions, "registerCallbackOptions cannot be null");
    String[] pathSegments = { "v1/register_callback" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "registerCallback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("callback_url", registerCallbackOptions.callbackUrl());
    if (registerCallbackOptions.userSecret() != null) {
      builder.query("user_secret", registerCallbackOptions.userSecret());
    }
    ResponseConverter<RegisterStatus> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<RegisterStatus>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Unregister a callback.
   *
   * Unregisters a callback URL that was previously white-listed with a **Register a callback** request for use with the
   * asynchronous interface. Once unregistered, the URL can no longer be used with asynchronous recognition requests.
   *
   * **See also:** [Unregistering a callback
   * URL](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-async#unregister).
   *
   * @param unregisterCallbackOptions the {@link UnregisterCallbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> unregisterCallback(UnregisterCallbackOptions unregisterCallbackOptions) {
    Validator.notNull(unregisterCallbackOptions, "unregisterCallbackOptions cannot be null");
    String[] pathSegments = { "v1/unregister_callback" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "unregisterCallback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("callback_url", unregisterCallbackOptions.callbackUrl());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a job.
   *
   * Creates a job for a new asynchronous recognition request. The job is owned by the instance of the service whose
   * credentials are used to create it. How you learn the status and results of a job depends on the parameters you
   * include with the job creation request:
   * * By callback notification: Include the `callback_url` parameter to specify a URL to which the service is to send
   * callback notifications when the status of the job changes. Optionally, you can also include the `events` and
   * `user_token` parameters to subscribe to specific events and to specify a string that is to be included with each
   * notification for the job.
   * * By polling the service: Omit the `callback_url`, `events`, and `user_token` parameters. You must then use the
   * **Check jobs** or **Check a job** methods to check the status of the job, using the latter to retrieve the results
   * when the job is complete.
   *
   * The two approaches are not mutually exclusive. You can poll the service for job status or obtain results from the
   * service manually even if you include a callback URL. In both cases, you can include the `results_ttl` parameter to
   * specify how long the results are to remain available after the job is complete. Using the HTTPS **Check a job**
   * method to retrieve results is more secure than receiving them via callback notification over HTTP because it
   * provides confidentiality in addition to authentication and data integrity.
   *
   * The method supports the same basic parameters as other HTTP and WebSocket recognition requests. It also supports
   * the following parameters specific to the asynchronous interface:
   * * `callback_url`
   * * `events`
   * * `user_token`
   * * `results_ttl`
   *
   * You can pass a maximum of 1 GB and a minimum of 100 bytes of audio with a request. The service automatically
   * detects the endianness of the incoming audio and, for audio that includes multiple channels, downmixes the audio to
   * one-channel mono during transcoding. The method returns only final results; to enable interim results, use the
   * WebSocket API. (With the `curl` command, use the `--data-binary` option to upload the file for the request.)
   *
   * **See also:** [Creating a
   * job](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-async#create).
   *
   * ### Streaming mode
   *
   * For requests to transcribe live audio as it becomes available, you must set the `Transfer-Encoding` header to
   * `chunked` to use streaming mode. In streaming mode, the service closes the connection (status code 408) if it does
   * not receive at least 15 seconds of audio (including silence) in any 30-second period. The service also closes the
   * connection (status code 400) if it detects no speech for `inactivity_timeout` seconds of streaming audio; use the
   * `inactivity_timeout` parameter to change the default of 30 seconds.
   *
   * **See also:**
   * * [Audio transmission](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#transmission)
   * * [Timeouts](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#timeouts)
   *
   * ### Audio formats (content types)
   *
   * The service accepts audio in the following formats (MIME types).
   * * For formats that are labeled **Required**, you must use the `Content-Type` header with the request to specify the
   * format of the audio.
   * * For all other formats, you can omit the `Content-Type` header or specify `application/octet-stream` with the
   * header to have the service automatically detect the format of the audio. (With the `curl` command, you can specify
   * either `\"Content-Type:\"` or `\"Content-Type: application/octet-stream\"`.)
   *
   * Where indicated, the format that you specify must include the sampling rate and can optionally include the number
   * of channels and the endianness of the audio.
   * * `audio/alaw` (**Required.** Specify the sampling rate (`rate`) of the audio.)
   * * `audio/basic` (**Required.** Use only with narrowband models.)
   * * `audio/flac`
   * * `audio/g729` (Use only with narrowband models.)
   * * `audio/l16` (**Required.** Specify the sampling rate (`rate`) and optionally the number of channels (`channels`)
   * and endianness (`endianness`) of the audio.)
   * * `audio/mp3`
   * * `audio/mpeg`
   * * `audio/mulaw` (**Required.** Specify the sampling rate (`rate`) of the audio.)
   * * `audio/ogg` (The service automatically detects the codec of the input audio.)
   * * `audio/ogg;codecs=opus`
   * * `audio/ogg;codecs=vorbis`
   * * `audio/wav` (Provide audio with a maximum of nine channels.)
   * * `audio/webm` (The service automatically detects the codec of the input audio.)
   * * `audio/webm;codecs=opus`
   * * `audio/webm;codecs=vorbis`
   *
   * The sampling rate of the audio must match the sampling rate of the model for the recognition request: for broadband
   * models, at least 16 kHz; for narrowband models, at least 8 kHz. If the sampling rate of the audio is higher than
   * the minimum required rate, the service down-samples the audio to the appropriate rate. If the sampling rate of the
   * audio is lower than the minimum required rate, the request fails.
   *
   * **See also:** [Audio
   * formats](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-audio-formats#audio-formats).
   *
   * @param createJobOptions the {@link CreateJobOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link RecognitionJob}
   */
  public ServiceCall<RecognitionJob> createJob(CreateJobOptions createJobOptions) {
    Validator.notNull(createJobOptions, "createJobOptions cannot be null");
    String[] pathSegments = { "v1/recognitions" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "createJob");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createJobOptions.contentType() != null) {
      builder.header("Content-Type", createJobOptions.contentType());
    }
    if (createJobOptions.model() != null) {
      builder.query("model", createJobOptions.model());
    }
    if (createJobOptions.callbackUrl() != null) {
      builder.query("callback_url", createJobOptions.callbackUrl());
    }
    if (createJobOptions.events() != null) {
      builder.query("events", createJobOptions.events());
    }
    if (createJobOptions.userToken() != null) {
      builder.query("user_token", createJobOptions.userToken());
    }
    if (createJobOptions.resultsTtl() != null) {
      builder.query("results_ttl", String.valueOf(createJobOptions.resultsTtl()));
    }
    if (createJobOptions.languageCustomizationId() != null) {
      builder.query("language_customization_id", createJobOptions.languageCustomizationId());
    }
    if (createJobOptions.acousticCustomizationId() != null) {
      builder.query("acoustic_customization_id", createJobOptions.acousticCustomizationId());
    }
    if (createJobOptions.baseModelVersion() != null) {
      builder.query("base_model_version", createJobOptions.baseModelVersion());
    }
    if (createJobOptions.customizationWeight() != null) {
      builder.query("customization_weight", String.valueOf(createJobOptions.customizationWeight()));
    }
    if (createJobOptions.inactivityTimeout() != null) {
      builder.query("inactivity_timeout", String.valueOf(createJobOptions.inactivityTimeout()));
    }
    if (createJobOptions.keywords() != null) {
      builder.query("keywords", RequestUtils.join(createJobOptions.keywords(), ","));
    }
    if (createJobOptions.keywordsThreshold() != null) {
      builder.query("keywords_threshold", String.valueOf(createJobOptions.keywordsThreshold()));
    }
    if (createJobOptions.maxAlternatives() != null) {
      builder.query("max_alternatives", String.valueOf(createJobOptions.maxAlternatives()));
    }
    if (createJobOptions.wordAlternativesThreshold() != null) {
      builder.query("word_alternatives_threshold", String.valueOf(createJobOptions.wordAlternativesThreshold()));
    }
    if (createJobOptions.wordConfidence() != null) {
      builder.query("word_confidence", String.valueOf(createJobOptions.wordConfidence()));
    }
    if (createJobOptions.timestamps() != null) {
      builder.query("timestamps", String.valueOf(createJobOptions.timestamps()));
    }
    if (createJobOptions.profanityFilter() != null) {
      builder.query("profanity_filter", String.valueOf(createJobOptions.profanityFilter()));
    }
    if (createJobOptions.smartFormatting() != null) {
      builder.query("smart_formatting", String.valueOf(createJobOptions.smartFormatting()));
    }
    if (createJobOptions.speakerLabels() != null) {
      builder.query("speaker_labels", String.valueOf(createJobOptions.speakerLabels()));
    }
    if (createJobOptions.customizationId() != null) {
      builder.query("customization_id", createJobOptions.customizationId());
    }
    if (createJobOptions.grammarName() != null) {
      builder.query("grammar_name", createJobOptions.grammarName());
    }
    if (createJobOptions.redaction() != null) {
      builder.query("redaction", String.valueOf(createJobOptions.redaction()));
    }
    if (createJobOptions.processingMetrics() != null) {
      builder.query("processing_metrics", String.valueOf(createJobOptions.processingMetrics()));
    }
    if (createJobOptions.processingMetricsInterval() != null) {
      builder.query("processing_metrics_interval", String.valueOf(createJobOptions.processingMetricsInterval()));
    }
    if (createJobOptions.audioMetrics() != null) {
      builder.query("audio_metrics", String.valueOf(createJobOptions.audioMetrics()));
    }
    builder.bodyContent(createJobOptions.contentType(), null, null, createJobOptions.audio());
    ResponseConverter<RecognitionJob> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<RecognitionJob>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Check jobs.
   *
   * Returns the ID and status of the latest 100 outstanding jobs associated with the credentials with which it is
   * called. The method also returns the creation and update times of each job, and, if a job was created with a
   * callback URL and a user token, the user token for the job. To obtain the results for a job whose status is
   * `completed` or not one of the latest 100 outstanding jobs, use the **Check a job** method. A job and its results
   * remain available until you delete them with the **Delete a job** method or until the job's time to live expires,
   * whichever comes first.
   *
   * **See also:** [Checking the status of the latest
   * jobs](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-async#jobs).
   *
   * @param checkJobsOptions the {@link CheckJobsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link RecognitionJobs}
   */
  public ServiceCall<RecognitionJobs> checkJobs(CheckJobsOptions checkJobsOptions) {
    String[] pathSegments = { "v1/recognitions" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "checkJobs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (checkJobsOptions != null) {
    }
    ResponseConverter<RecognitionJobs> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<RecognitionJobs>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Check jobs.
   *
   * Returns the ID and status of the latest 100 outstanding jobs associated with the credentials with which it is
   * called. The method also returns the creation and update times of each job, and, if a job was created with a
   * callback URL and a user token, the user token for the job. To obtain the results for a job whose status is
   * `completed` or not one of the latest 100 outstanding jobs, use the **Check a job** method. A job and its results
   * remain available until you delete them with the **Delete a job** method or until the job's time to live expires,
   * whichever comes first.
   *
   * **See also:** [Checking the status of the latest
   * jobs](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-async#jobs).
   *
   * @return a {@link ServiceCall} with a response type of {@link RecognitionJobs}
   */
  public ServiceCall<RecognitionJobs> checkJobs() {
    return checkJobs(null);
  }

  /**
   * Check a job.
   *
   * Returns information about the specified job. The response always includes the status of the job and its creation
   * and update times. If the status is `completed`, the response includes the results of the recognition request. You
   * must use credentials for the instance of the service that owns a job to list information about it.
   *
   * You can use the method to retrieve the results of any job, regardless of whether it was submitted with a callback
   * URL and the `recognitions.completed_with_results` event, and you can retrieve the results multiple times for as
   * long as they remain available. Use the **Check jobs** method to request information about the most recent jobs
   * associated with the calling credentials.
   *
   * **See also:** [Checking the status and retrieving the results of a
   * job](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-async#job).
   *
   * @param checkJobOptions the {@link CheckJobOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link RecognitionJob}
   */
  public ServiceCall<RecognitionJob> checkJob(CheckJobOptions checkJobOptions) {
    Validator.notNull(checkJobOptions, "checkJobOptions cannot be null");
    String[] pathSegments = { "v1/recognitions" };
    String[] pathParameters = { checkJobOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "checkJob");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<RecognitionJob> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<RecognitionJob>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a job.
   *
   * Deletes the specified job. You cannot delete a job that the service is actively processing. Once you delete a job,
   * its results are no longer available. The service automatically deletes a job and its results when the time to live
   * for the results expires. You must use credentials for the instance of the service that owns a job to delete it.
   *
   * **See also:** [Deleting a
   * job](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-async#delete-async).
   *
   * @param deleteJobOptions the {@link DeleteJobOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteJob(DeleteJobOptions deleteJobOptions) {
    Validator.notNull(deleteJobOptions, "deleteJobOptions cannot be null");
    String[] pathSegments = { "v1/recognitions" };
    String[] pathParameters = { deleteJobOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "deleteJob");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom language model.
   *
   * Creates a new custom language model for a specified base model. The custom language model can be used only with the
   * base model for which it is created. The model is owned by the instance of the service whose credentials are used to
   * create it.
   *
   * **See also:** [Create a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-languageCreate#createModel-language).
   *
   * @param createLanguageModelOptions the {@link CreateLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link LanguageModel}
   */
  public ServiceCall<LanguageModel> createLanguageModel(CreateLanguageModelOptions createLanguageModelOptions) {
    Validator.notNull(createLanguageModelOptions, "createLanguageModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "createLanguageModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createLanguageModelOptions.name());
    contentJson.addProperty("base_model_name", createLanguageModelOptions.baseModelName());
    if (createLanguageModelOptions.dialect() != null) {
      contentJson.addProperty("dialect", createLanguageModelOptions.dialect());
    }
    if (createLanguageModelOptions.description() != null) {
      contentJson.addProperty("description", createLanguageModelOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<LanguageModel> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<LanguageModel>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom language models.
   *
   * Lists information about all custom language models that are owned by an instance of the service. Use the `language`
   * parameter to see all custom language models for the specified language. Omit the parameter to see all custom
   * language models for all languages. You must use credentials for the instance of the service that owns a model to
   * list information about it.
   *
   * **See also:** [Listing custom language
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageLanguageModels#listModels-language).
   *
   * @param listLanguageModelsOptions the {@link ListLanguageModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link LanguageModels}
   */
  public ServiceCall<LanguageModels> listLanguageModels(ListLanguageModelsOptions listLanguageModelsOptions) {
    String[] pathSegments = { "v1/customizations" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "listLanguageModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listLanguageModelsOptions != null) {
      if (listLanguageModelsOptions.language() != null) {
        builder.query("language", listLanguageModelsOptions.language());
      }
    }
    ResponseConverter<LanguageModels> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<LanguageModels>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom language models.
   *
   * Lists information about all custom language models that are owned by an instance of the service. Use the `language`
   * parameter to see all custom language models for the specified language. Omit the parameter to see all custom
   * language models for all languages. You must use credentials for the instance of the service that owns a model to
   * list information about it.
   *
   * **See also:** [Listing custom language
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageLanguageModels#listModels-language).
   *
   * @return a {@link ServiceCall} with a response type of {@link LanguageModels}
   */
  public ServiceCall<LanguageModels> listLanguageModels() {
    return listLanguageModels(null);
  }

  /**
   * Get a custom language model.
   *
   * Gets information about a specified custom language model. You must use credentials for the instance of the service
   * that owns a model to list information about it.
   *
   * **See also:** [Listing custom language
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageLanguageModels#listModels-language).
   *
   * @param getLanguageModelOptions the {@link GetLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link LanguageModel}
   */
  public ServiceCall<LanguageModel> getLanguageModel(GetLanguageModelOptions getLanguageModelOptions) {
    Validator.notNull(getLanguageModelOptions, "getLanguageModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations" };
    String[] pathParameters = { getLanguageModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "getLanguageModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<LanguageModel> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<LanguageModel>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom language model.
   *
   * Deletes an existing custom language model. The custom model cannot be deleted if another request, such as adding a
   * corpus or grammar to the model, is currently being processed. You must use credentials for the instance of the
   * service that owns a model to delete it.
   *
   * **See also:** [Deleting a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageLanguageModels#deleteModel-language).
   *
   * @param deleteLanguageModelOptions the {@link DeleteLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteLanguageModel(DeleteLanguageModelOptions deleteLanguageModelOptions) {
    Validator.notNull(deleteLanguageModelOptions, "deleteLanguageModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations" };
    String[] pathParameters = { deleteLanguageModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "deleteLanguageModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Train a custom language model.
   *
   * Initiates the training of a custom language model with new resources such as corpora, grammars, and custom words.
   * After adding, modifying, or deleting resources for a custom language model, use this method to begin the actual
   * training of the model on the latest data. You can specify whether the custom language model is to be trained with
   * all words from its words resource or only with words that were added or modified by the user directly. You must use
   * credentials for the instance of the service that owns a model to train it.
   *
   * The training method is asynchronous. It can take on the order of minutes to complete depending on the amount of
   * data on which the service is being trained and the current load on the service. The method returns an HTTP 200
   * response code to indicate that the training process has begun.
   *
   * You can monitor the status of the training by using the **Get a custom language model** method to poll the model's
   * status. Use a loop to check the status every 10 seconds. The method returns a `LanguageModel` object that includes
   * `status` and `progress` fields. A status of `available` means that the custom model is trained and ready to use.
   * The service cannot accept subsequent training requests or requests to add new resources until the existing request
   * completes.
   *
   * **See also:** [Train the custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-languageCreate#trainModel-language).
   *
   *
   * ### Training failures
   *
   * Training can fail to start for the following reasons:
   * * The service is currently handling another request for the custom model, such as another training request or a
   * request to add a corpus or grammar to the model.
   * * No training data have been added to the custom model.
   * * The custom model contains one or more invalid corpora, grammars, or words (for example, a custom word has an
   * invalid sounds-like pronunciation). You can correct the invalid resources or set the `strict` parameter to `false`
   * to exclude the invalid resources from the training. The model must contain at least one valid resource for training
   * to succeed.
   *
   * @param trainLanguageModelOptions the {@link TrainLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingResponse}
   */
  public ServiceCall<TrainingResponse> trainLanguageModel(TrainLanguageModelOptions trainLanguageModelOptions) {
    Validator.notNull(trainLanguageModelOptions, "trainLanguageModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "train" };
    String[] pathParameters = { trainLanguageModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "trainLanguageModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (trainLanguageModelOptions.wordTypeToAdd() != null) {
      builder.query("word_type_to_add", trainLanguageModelOptions.wordTypeToAdd());
    }
    if (trainLanguageModelOptions.customizationWeight() != null) {
      builder.query("customization_weight", String.valueOf(trainLanguageModelOptions.customizationWeight()));
    }
    ResponseConverter<TrainingResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<TrainingResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Reset a custom language model.
   *
   * Resets a custom language model by removing all corpora, grammars, and words from the model. Resetting a custom
   * language model initializes the model to its state when it was first created. Metadata such as the name and language
   * of the model are preserved, but the model's words resource is removed and must be re-created. You must use
   * credentials for the instance of the service that owns a model to reset it.
   *
   * **See also:** [Resetting a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageLanguageModels#resetModel-language).
   *
   * @param resetLanguageModelOptions the {@link ResetLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> resetLanguageModel(ResetLanguageModelOptions resetLanguageModelOptions) {
    Validator.notNull(resetLanguageModelOptions, "resetLanguageModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "reset" };
    String[] pathParameters = { resetLanguageModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "resetLanguageModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Upgrade a custom language model.
   *
   * Initiates the upgrade of a custom language model to the latest version of its base language model. The upgrade
   * method is asynchronous. It can take on the order of minutes to complete depending on the amount of data in the
   * custom model and the current load on the service. A custom model must be in the `ready` or `available` state to be
   * upgraded. You must use credentials for the instance of the service that owns a model to upgrade it.
   *
   * The method returns an HTTP 200 response code to indicate that the upgrade process has begun successfully. You can
   * monitor the status of the upgrade by using the **Get a custom language model** method to poll the model's status.
   * The method returns a `LanguageModel` object that includes `status` and `progress` fields. Use a loop to check the
   * status every 10 seconds. While it is being upgraded, the custom model has the status `upgrading`. When the upgrade
   * is complete, the model resumes the status that it had prior to upgrade. The service cannot accept subsequent
   * requests for the model until the upgrade completes.
   *
   * **See also:** [Upgrading a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-customUpgrade#upgradeLanguage).
   *
   * @param upgradeLanguageModelOptions the {@link UpgradeLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> upgradeLanguageModel(UpgradeLanguageModelOptions upgradeLanguageModelOptions) {
    Validator.notNull(upgradeLanguageModelOptions, "upgradeLanguageModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "upgrade_model" };
    String[] pathParameters = { upgradeLanguageModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "upgradeLanguageModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List corpora.
   *
   * Lists information about all corpora from a custom language model. The information includes the total number of
   * words and out-of-vocabulary (OOV) words, name, and status of each corpus. You must use credentials for the instance
   * of the service that owns a model to list its corpora.
   *
   * **See also:** [Listing corpora for a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageCorpora#listCorpora).
   *
   * @param listCorporaOptions the {@link ListCorporaOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Corpora}
   */
  public ServiceCall<Corpora> listCorpora(ListCorporaOptions listCorporaOptions) {
    Validator.notNull(listCorporaOptions, "listCorporaOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "corpora" };
    String[] pathParameters = { listCorporaOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "listCorpora");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Corpora> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Corpora>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a corpus.
   *
   * Adds a single corpus text file of new training data to a custom language model. Use multiple requests to submit
   * multiple corpus text files. You must use credentials for the instance of the service that owns a model to add a
   * corpus to it. Adding a corpus does not affect the custom language model until you train the model for the new data
   * by using the **Train a custom language model** method.
   *
   * Submit a plain text file that contains sample sentences from the domain of interest to enable the service to
   * extract words in context. The more sentences you add that represent the context in which speakers use words from
   * the domain, the better the service's recognition accuracy.
   *
   * The call returns an HTTP 201 response code if the corpus is valid. The service then asynchronously processes the
   * contents of the corpus and automatically extracts new words that it finds. This can take on the order of a minute
   * or two to complete depending on the total number of words and the number of new words in the corpus, as well as the
   * current load on the service. You cannot submit requests to add additional resources to the custom model or to train
   * the model until the service's analysis of the corpus for the current request completes. Use the **List a corpus**
   * method to check the status of the analysis.
   *
   * The service auto-populates the model's words resource with words from the corpus that are not found in its base
   * vocabulary. These are referred to as out-of-vocabulary (OOV) words. You can use the **List custom words** method to
   * examine the words resource. You can use other words method to eliminate typos and modify how words are pronounced
   * as needed.
   *
   * To add a corpus file that has the same name as an existing corpus, set the `allow_overwrite` parameter to `true`;
   * otherwise, the request fails. Overwriting an existing corpus causes the service to process the corpus text file and
   * extract OOV words anew. Before doing so, it removes any OOV words associated with the existing corpus from the
   * model's words resource unless they were also added by another corpus or grammar, or they have been modified in some
   * way with the **Add custom words** or **Add a custom word** method.
   *
   * The service limits the overall amount of data that you can add to a custom model to a maximum of 10 million total
   * words from all sources combined. Also, you can add no more than 90 thousand custom (OOV) words to a model. This
   * includes words that the service extracts from corpora and grammars, and words that you add directly.
   *
   * **See also:**
   * * [Working with
   * corpora](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-corporaWords#workingCorpora)
   * * [Add a corpus to the custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-languageCreate#addCorpus).
   *
   * @param addCorpusOptions the {@link AddCorpusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addCorpus(AddCorpusOptions addCorpusOptions) {
    Validator.notNull(addCorpusOptions, "addCorpusOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "corpora" };
    String[] pathParameters = { addCorpusOptions.customizationId(), addCorpusOptions.corpusName() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "addCorpus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addCorpusOptions.allowOverwrite() != null) {
      builder.query("allow_overwrite", String.valueOf(addCorpusOptions.allowOverwrite()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody corpusFileBody = RequestUtils.inputStreamBody(addCorpusOptions.corpusFile(), "text/plain");
    multipartBuilder.addFormDataPart("corpus_file", "filename", corpusFileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a corpus.
   *
   * Gets information about a corpus from a custom language model. The information includes the total number of words
   * and out-of-vocabulary (OOV) words, name, and status of the corpus. You must use credentials for the instance of the
   * service that owns a model to list its corpora.
   *
   * **See also:** [Listing corpora for a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageCorpora#listCorpora).
   *
   * @param getCorpusOptions the {@link GetCorpusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Corpus}
   */
  public ServiceCall<Corpus> getCorpus(GetCorpusOptions getCorpusOptions) {
    Validator.notNull(getCorpusOptions, "getCorpusOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "corpora" };
    String[] pathParameters = { getCorpusOptions.customizationId(), getCorpusOptions.corpusName() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "getCorpus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Corpus> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Corpus>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a corpus.
   *
   * Deletes an existing corpus from a custom language model. The service removes any out-of-vocabulary (OOV) words that
   * are associated with the corpus from the custom model's words resource unless they were also added by another corpus
   * or grammar, or they were modified in some way with the **Add custom words** or **Add a custom word** method.
   * Removing a corpus does not affect the custom model until you train the model with the **Train a custom language
   * model** method. You must use credentials for the instance of the service that owns a model to delete its corpora.
   *
   * **See also:** [Deleting a corpus from a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageCorpora#deleteCorpus).
   *
   * @param deleteCorpusOptions the {@link DeleteCorpusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteCorpus(DeleteCorpusOptions deleteCorpusOptions) {
    Validator.notNull(deleteCorpusOptions, "deleteCorpusOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "corpora" };
    String[] pathParameters = { deleteCorpusOptions.customizationId(), deleteCorpusOptions.corpusName() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "deleteCorpus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom words.
   *
   * Lists information about custom words from a custom language model. You can list all words from the custom model's
   * words resource, only custom words that were added or modified by the user, or only out-of-vocabulary (OOV) words
   * that were extracted from corpora or are recognized by grammars. You can also indicate the order in which the
   * service is to return words; by default, the service lists words in ascending alphabetical order. You must use
   * credentials for the instance of the service that owns a model to list information about its words.
   *
   * **See also:** [Listing words from a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageWords#listWords).
   *
   * @param listWordsOptions the {@link ListWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Words}
   */
  public ServiceCall<Words> listWords(ListWordsOptions listWordsOptions) {
    Validator.notNull(listWordsOptions, "listWordsOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "words" };
    String[] pathParameters = { listWordsOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "listWords");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listWordsOptions.wordType() != null) {
      builder.query("word_type", listWordsOptions.wordType());
    }
    if (listWordsOptions.sort() != null) {
      builder.query("sort", listWordsOptions.sort());
    }
    ResponseConverter<Words> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Words>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add custom words.
   *
   * Adds one or more custom words to a custom language model. The service populates the words resource for a custom
   * model with out-of-vocabulary (OOV) words from each corpus or grammar that is added to the model. You can use this
   * method to add additional words or to modify existing words in the words resource. The words resource for a model
   * can contain a maximum of 90 thousand custom (OOV) words. This includes words that the service extracts from corpora
   * and grammars and words that you add directly.
   *
   * You must use credentials for the instance of the service that owns a model to add or modify custom words for the
   * model. Adding or modifying custom words does not affect the custom model until you train the model for the new data
   * by using the **Train a custom language model** method.
   *
   * You add custom words by providing a `CustomWords` object, which is an array of `CustomWord` objects, one per word.
   * You must use the object's `word` parameter to identify the word that is to be added. You can also provide one or
   * both of the optional `sounds_like` and `display_as` fields for each word.
   * * The `sounds_like` field provides an array of one or more pronunciations for the word. Use the parameter to
   * specify how the word can be pronounced by users. Use the parameter for words that are difficult to pronounce,
   * foreign words, acronyms, and so on. For example, you might specify that the word `IEEE` can sound like `i triple
   * e`. You can specify a maximum of five sounds-like pronunciations for a word.
   * * The `display_as` field provides a different way of spelling the word in a transcript. Use the parameter when you
   * want the word to appear different from its usual representation or from its spelling in training data. For example,
   * you might indicate that the word `IBM(trademark)` is to be displayed as `IBM&trade;`.
   *
   * If you add a custom word that already exists in the words resource for the custom model, the new definition
   * overwrites the existing data for the word. If the service encounters an error with the input data, it returns a
   * failure code and does not add any of the words to the words resource.
   *
   * The call returns an HTTP 201 response code if the input data is valid. It then asynchronously processes the words
   * to add them to the model's words resource. The time that it takes for the analysis to complete depends on the
   * number of new words that you add but is generally faster than adding a corpus or grammar.
   *
   * You can monitor the status of the request by using the **List a custom language model** method to poll the model's
   * status. Use a loop to check the status every 10 seconds. The method returns a `Customization` object that includes
   * a `status` field. A status of `ready` means that the words have been added to the custom model. The service cannot
   * accept requests to add new data or to train the model until the existing request completes.
   *
   * You can use the **List custom words** or **List a custom word** method to review the words that you add. Words with
   * an invalid `sounds_like` field include an `error` field that describes the problem. You can use other words-related
   * methods to correct errors, eliminate typos, and modify how words are pronounced as needed.
   *
   * **See also:**
   * * [Working with custom
   * words](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-corporaWords#workingWords)
   * * [Add words to the custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-languageCreate#addWords).
   *
   * @param addWordsOptions the {@link AddWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWords(AddWordsOptions addWordsOptions) {
    Validator.notNull(addWordsOptions, "addWordsOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "words" };
    String[] pathParameters = { addWordsOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "addWords");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("words", GsonSingleton.getGson().toJsonTree(addWordsOptions.words()));
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a custom word.
   *
   * Adds a custom word to a custom language model. The service populates the words resource for a custom model with
   * out-of-vocabulary (OOV) words from each corpus or grammar that is added to the model. You can use this method to
   * add a word or to modify an existing word in the words resource. The words resource for a model can contain a
   * maximum of 90 thousand custom (OOV) words. This includes words that the service extracts from corpora and grammars
   * and words that you add directly.
   *
   * You must use credentials for the instance of the service that owns a model to add or modify a custom word for the
   * model. Adding or modifying a custom word does not affect the custom model until you train the model for the new
   * data by using the **Train a custom language model** method.
   *
   * Use the `word_name` parameter to specify the custom word that is to be added or modified. Use the `CustomWord`
   * object to provide one or both of the optional `sounds_like` and `display_as` fields for the word.
   * * The `sounds_like` field provides an array of one or more pronunciations for the word. Use the parameter to
   * specify how the word can be pronounced by users. Use the parameter for words that are difficult to pronounce,
   * foreign words, acronyms, and so on. For example, you might specify that the word `IEEE` can sound like `i triple
   * e`. You can specify a maximum of five sounds-like pronunciations for a word.
   * * The `display_as` field provides a different way of spelling the word in a transcript. Use the parameter when you
   * want the word to appear different from its usual representation or from its spelling in training data. For example,
   * you might indicate that the word `IBM(trademark)` is to be displayed as `IBM&trade;`.
   *
   * If you add a custom word that already exists in the words resource for the custom model, the new definition
   * overwrites the existing data for the word. If the service encounters an error, it does not add the word to the
   * words resource. Use the **List a custom word** method to review the word that you add.
   *
   * **See also:**
   * * [Working with custom
   * words](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-corporaWords#workingWords)
   * * [Add words to the custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-languageCreate#addWords).
   *
   * @param addWordOptions the {@link AddWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWord(AddWordOptions addWordOptions) {
    Validator.notNull(addWordOptions, "addWordOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "words" };
    String[] pathParameters = { addWordOptions.customizationId(), addWordOptions.wordName() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "addWord");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (addWordOptions.word() != null) {
      contentJson.addProperty("word", addWordOptions.word());
    }
    if (addWordOptions.soundsLike() != null) {
      contentJson.add("sounds_like", GsonSingleton.getGson().toJsonTree(addWordOptions.soundsLike()));
    }
    if (addWordOptions.displayAs() != null) {
      contentJson.addProperty("display_as", addWordOptions.displayAs());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a custom word.
   *
   * Gets information about a custom word from a custom language model. You must use credentials for the instance of the
   * service that owns a model to list information about its words.
   *
   * **See also:** [Listing words from a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageWords#listWords).
   *
   * @param getWordOptions the {@link GetWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Word}
   */
  public ServiceCall<Word> getWord(GetWordOptions getWordOptions) {
    Validator.notNull(getWordOptions, "getWordOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "words" };
    String[] pathParameters = { getWordOptions.customizationId(), getWordOptions.wordName() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "getWord");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Word> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Word>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom word.
   *
   * Deletes a custom word from a custom language model. You can remove any word that you added to the custom model's
   * words resource via any means. However, if the word also exists in the service's base vocabulary, the service
   * removes only the custom pronunciation for the word; the word remains in the base vocabulary. Removing a custom word
   * does not affect the custom model until you train the model with the **Train a custom language model** method. You
   * must use credentials for the instance of the service that owns a model to delete its words.
   *
   * **See also:** [Deleting a word from a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageWords#deleteWord).
   *
   * @param deleteWordOptions the {@link DeleteWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteWord(DeleteWordOptions deleteWordOptions) {
    Validator.notNull(deleteWordOptions, "deleteWordOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "words" };
    String[] pathParameters = { deleteWordOptions.customizationId(), deleteWordOptions.wordName() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "deleteWord");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List grammars.
   *
   * Lists information about all grammars from a custom language model. The information includes the total number of
   * out-of-vocabulary (OOV) words, name, and status of each grammar. You must use credentials for the instance of the
   * service that owns a model to list its grammars.
   *
   * **See also:** [Listing grammars from a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageGrammars#listGrammars).
   *
   * @param listGrammarsOptions the {@link ListGrammarsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Grammars}
   */
  public ServiceCall<Grammars> listGrammars(ListGrammarsOptions listGrammarsOptions) {
    Validator.notNull(listGrammarsOptions, "listGrammarsOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "grammars" };
    String[] pathParameters = { listGrammarsOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "listGrammars");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Grammars> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Grammars>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a grammar.
   *
   * Adds a single grammar file to a custom language model. Submit a plain text file in UTF-8 format that defines the
   * grammar. Use multiple requests to submit multiple grammar files. You must use credentials for the instance of the
   * service that owns a model to add a grammar to it. Adding a grammar does not affect the custom language model until
   * you train the model for the new data by using the **Train a custom language model** method.
   *
   * The call returns an HTTP 201 response code if the grammar is valid. The service then asynchronously processes the
   * contents of the grammar and automatically extracts new words that it finds. This can take a few seconds to complete
   * depending on the size and complexity of the grammar, as well as the current load on the service. You cannot submit
   * requests to add additional resources to the custom model or to train the model until the service's analysis of the
   * grammar for the current request completes. Use the **Get a grammar** method to check the status of the analysis.
   *
   * The service populates the model's words resource with any word that is recognized by the grammar that is not found
   * in the model's base vocabulary. These are referred to as out-of-vocabulary (OOV) words. You can use the **List
   * custom words** method to examine the words resource and use other words-related methods to eliminate typos and
   * modify how words are pronounced as needed.
   *
   * To add a grammar that has the same name as an existing grammar, set the `allow_overwrite` parameter to `true`;
   * otherwise, the request fails. Overwriting an existing grammar causes the service to process the grammar file and
   * extract OOV words anew. Before doing so, it removes any OOV words associated with the existing grammar from the
   * model's words resource unless they were also added by another resource or they have been modified in some way with
   * the **Add custom words** or **Add a custom word** method.
   *
   * The service limits the overall amount of data that you can add to a custom model to a maximum of 10 million total
   * words from all sources combined. Also, you can add no more than 90 thousand OOV words to a model. This includes
   * words that the service extracts from corpora and grammars and words that you add directly.
   *
   * **See also:**
   * * [Understanding
   * grammars](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-grammarUnderstand#grammarUnderstand)
   * * [Add a grammar to the custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-grammarAdd#addGrammar).
   *
   * @param addGrammarOptions the {@link AddGrammarOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addGrammar(AddGrammarOptions addGrammarOptions) {
    Validator.notNull(addGrammarOptions, "addGrammarOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "grammars" };
    String[] pathParameters = { addGrammarOptions.customizationId(), addGrammarOptions.grammarName() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "addGrammar");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Content-Type", addGrammarOptions.contentType());
    if (addGrammarOptions.allowOverwrite() != null) {
      builder.query("allow_overwrite", String.valueOf(addGrammarOptions.allowOverwrite()));
    }
    builder.bodyContent(addGrammarOptions.contentType(), null, null, addGrammarOptions.grammarFile());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a grammar.
   *
   * Gets information about a grammar from a custom language model. The information includes the total number of
   * out-of-vocabulary (OOV) words, name, and status of the grammar. You must use credentials for the instance of the
   * service that owns a model to list its grammars.
   *
   * **See also:** [Listing grammars from a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageGrammars#listGrammars).
   *
   * @param getGrammarOptions the {@link GetGrammarOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Grammar}
   */
  public ServiceCall<Grammar> getGrammar(GetGrammarOptions getGrammarOptions) {
    Validator.notNull(getGrammarOptions, "getGrammarOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "grammars" };
    String[] pathParameters = { getGrammarOptions.customizationId(), getGrammarOptions.grammarName() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "getGrammar");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Grammar> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Grammar>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a grammar.
   *
   * Deletes an existing grammar from a custom language model. The service removes any out-of-vocabulary (OOV) words
   * associated with the grammar from the custom model's words resource unless they were also added by another resource
   * or they were modified in some way with the **Add custom words** or **Add a custom word** method. Removing a grammar
   * does not affect the custom model until you train the model with the **Train a custom language model** method. You
   * must use credentials for the instance of the service that owns a model to delete its grammar.
   *
   * **See also:** [Deleting a grammar from a custom language
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageGrammars#deleteGrammar).
   *
   * @param deleteGrammarOptions the {@link DeleteGrammarOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteGrammar(DeleteGrammarOptions deleteGrammarOptions) {
    Validator.notNull(deleteGrammarOptions, "deleteGrammarOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "grammars" };
    String[] pathParameters = { deleteGrammarOptions.customizationId(), deleteGrammarOptions.grammarName() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "deleteGrammar");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom acoustic model.
   *
   * Creates a new custom acoustic model for a specified base model. The custom acoustic model can be used only with the
   * base model for which it is created. The model is owned by the instance of the service whose credentials are used to
   * create it.
   *
   * **See also:** [Create a custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-acoustic#createModel-acoustic).
   *
   * @param createAcousticModelOptions the {@link CreateAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AcousticModel}
   */
  public ServiceCall<AcousticModel> createAcousticModel(CreateAcousticModelOptions createAcousticModelOptions) {
    Validator.notNull(createAcousticModelOptions, "createAcousticModelOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "createAcousticModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createAcousticModelOptions.name());
    contentJson.addProperty("base_model_name", createAcousticModelOptions.baseModelName());
    if (createAcousticModelOptions.description() != null) {
      contentJson.addProperty("description", createAcousticModelOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AcousticModel> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<AcousticModel>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom acoustic models.
   *
   * Lists information about all custom acoustic models that are owned by an instance of the service. Use the `language`
   * parameter to see all custom acoustic models for the specified language. Omit the parameter to see all custom
   * acoustic models for all languages. You must use credentials for the instance of the service that owns a model to
   * list information about it.
   *
   * **See also:** [Listing custom acoustic
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageAcousticModels#listModels-acoustic).
   *
   * @param listAcousticModelsOptions the {@link ListAcousticModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AcousticModels}
   */
  public ServiceCall<AcousticModels> listAcousticModels(ListAcousticModelsOptions listAcousticModelsOptions) {
    String[] pathSegments = { "v1/acoustic_customizations" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "listAcousticModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAcousticModelsOptions != null) {
      if (listAcousticModelsOptions.language() != null) {
        builder.query("language", listAcousticModelsOptions.language());
      }
    }
    ResponseConverter<AcousticModels> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<AcousticModels>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom acoustic models.
   *
   * Lists information about all custom acoustic models that are owned by an instance of the service. Use the `language`
   * parameter to see all custom acoustic models for the specified language. Omit the parameter to see all custom
   * acoustic models for all languages. You must use credentials for the instance of the service that owns a model to
   * list information about it.
   *
   * **See also:** [Listing custom acoustic
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageAcousticModels#listModels-acoustic).
   *
   * @return a {@link ServiceCall} with a response type of {@link AcousticModels}
   */
  public ServiceCall<AcousticModels> listAcousticModels() {
    return listAcousticModels(null);
  }

  /**
   * Get a custom acoustic model.
   *
   * Gets information about a specified custom acoustic model. You must use credentials for the instance of the service
   * that owns a model to list information about it.
   *
   * **See also:** [Listing custom acoustic
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageAcousticModels#listModels-acoustic).
   *
   * @param getAcousticModelOptions the {@link GetAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AcousticModel}
   */
  public ServiceCall<AcousticModel> getAcousticModel(GetAcousticModelOptions getAcousticModelOptions) {
    Validator.notNull(getAcousticModelOptions, "getAcousticModelOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations" };
    String[] pathParameters = { getAcousticModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "getAcousticModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AcousticModel> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<AcousticModel>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom acoustic model.
   *
   * Deletes an existing custom acoustic model. The custom model cannot be deleted if another request, such as adding an
   * audio resource to the model, is currently being processed. You must use credentials for the instance of the service
   * that owns a model to delete it.
   *
   * **See also:** [Deleting a custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageAcousticModels#deleteModel-acoustic).
   *
   * @param deleteAcousticModelOptions the {@link DeleteAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteAcousticModel(DeleteAcousticModelOptions deleteAcousticModelOptions) {
    Validator.notNull(deleteAcousticModelOptions, "deleteAcousticModelOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations" };
    String[] pathParameters = { deleteAcousticModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "deleteAcousticModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Train a custom acoustic model.
   *
   * Initiates the training of a custom acoustic model with new or changed audio resources. After adding or deleting
   * audio resources for a custom acoustic model, use this method to begin the actual training of the model on the
   * latest audio data. The custom acoustic model does not reflect its changed data until you train it. You must use
   * credentials for the instance of the service that owns a model to train it.
   *
   * The training method is asynchronous. It can take on the order of minutes or hours to complete depending on the
   * total amount of audio data on which the custom acoustic model is being trained and the current load on the service.
   * Typically, training a custom acoustic model takes approximately two to four times the length of its audio data. The
   * range of time depends on the model being trained and the nature of the audio, such as whether the audio is clean or
   * noisy. The method returns an HTTP 200 response code to indicate that the training process has begun.
   *
   * You can monitor the status of the training by using the **Get a custom acoustic model** method to poll the model's
   * status. Use a loop to check the status once a minute. The method returns an `AcousticModel` object that includes
   * `status` and `progress` fields. A status of `available` indicates that the custom model is trained and ready to
   * use. The service cannot train a model while it is handling another request for the model. The service cannot accept
   * subsequent training requests, or requests to add new audio resources, until the existing training request
   * completes.
   *
   * You can use the optional `custom_language_model_id` parameter to specify the GUID of a separately created custom
   * language model that is to be used during training. Train with a custom language model if you have verbatim
   * transcriptions of the audio files that you have added to the custom model or you have either corpora (text files)
   * or a list of words that are relevant to the contents of the audio files. Both of the custom models must be based on
   * the same version of the same base model for training to succeed.
   *
   * **See also:**
   * * [Train the custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-acoustic#trainModel-acoustic)
   * * [Using custom acoustic and custom language models
   * together](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-useBoth#useBoth)
   *
   * ### Training failures
   *
   * Training can fail to start for the following reasons:
   * * The service is currently handling another request for the custom model, such as another training request or a
   * request to add audio resources to the model.
   * * The custom model contains less than 10 minutes or more than 200 hours of audio data.
   * * You passed an incompatible custom language model with the `custom_language_model_id` query parameter. Both custom
   * models must be based on the same version of the same base model.
   * * The custom model contains one or more invalid audio resources. You can correct the invalid audio resources or set
   * the `strict` parameter to `false` to exclude the invalid resources from the training. The model must contain at
   * least one valid resource for training to succeed.
   *
   * @param trainAcousticModelOptions the {@link TrainAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingResponse}
   */
  public ServiceCall<TrainingResponse> trainAcousticModel(TrainAcousticModelOptions trainAcousticModelOptions) {
    Validator.notNull(trainAcousticModelOptions, "trainAcousticModelOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations", "train" };
    String[] pathParameters = { trainAcousticModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "trainAcousticModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (trainAcousticModelOptions.customLanguageModelId() != null) {
      builder.query("custom_language_model_id", trainAcousticModelOptions.customLanguageModelId());
    }
    ResponseConverter<TrainingResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<TrainingResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Reset a custom acoustic model.
   *
   * Resets a custom acoustic model by removing all audio resources from the model. Resetting a custom acoustic model
   * initializes the model to its state when it was first created. Metadata such as the name and language of the model
   * are preserved, but the model's audio resources are removed and must be re-created. The service cannot reset a model
   * while it is handling another request for the model. The service cannot accept subsequent requests for the model
   * until the existing reset request completes. You must use credentials for the instance of the service that owns a
   * model to reset it.
   *
   * **See also:** [Resetting a custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageAcousticModels#resetModel-acoustic).
   *
   * @param resetAcousticModelOptions the {@link ResetAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> resetAcousticModel(ResetAcousticModelOptions resetAcousticModelOptions) {
    Validator.notNull(resetAcousticModelOptions, "resetAcousticModelOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations", "reset" };
    String[] pathParameters = { resetAcousticModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "resetAcousticModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Upgrade a custom acoustic model.
   *
   * Initiates the upgrade of a custom acoustic model to the latest version of its base language model. The upgrade
   * method is asynchronous. It can take on the order of minutes or hours to complete depending on the amount of data in
   * the custom model and the current load on the service; typically, upgrade takes approximately twice the length of
   * the total audio contained in the custom model. A custom model must be in the `ready` or `available` state to be
   * upgraded. You must use credentials for the instance of the service that owns a model to upgrade it.
   *
   * The method returns an HTTP 200 response code to indicate that the upgrade process has begun successfully. You can
   * monitor the status of the upgrade by using the **Get a custom acoustic model** method to poll the model's status.
   * The method returns an `AcousticModel` object that includes `status` and `progress` fields. Use a loop to check the
   * status once a minute. While it is being upgraded, the custom model has the status `upgrading`. When the upgrade is
   * complete, the model resumes the status that it had prior to upgrade. The service cannot upgrade a model while it is
   * handling another request for the model. The service cannot accept subsequent requests for the model until the
   * existing upgrade request completes.
   *
   * If the custom acoustic model was trained with a separately created custom language model, you must use the
   * `custom_language_model_id` parameter to specify the GUID of that custom language model. The custom language model
   * must be upgraded before the custom acoustic model can be upgraded. Omit the parameter if the custom acoustic model
   * was not trained with a custom language model.
   *
   * **See also:** [Upgrading a custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-customUpgrade#upgradeAcoustic).
   *
   * @param upgradeAcousticModelOptions the {@link UpgradeAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> upgradeAcousticModel(UpgradeAcousticModelOptions upgradeAcousticModelOptions) {
    Validator.notNull(upgradeAcousticModelOptions, "upgradeAcousticModelOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations", "upgrade_model" };
    String[] pathParameters = { upgradeAcousticModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "upgradeAcousticModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (upgradeAcousticModelOptions.customLanguageModelId() != null) {
      builder.query("custom_language_model_id", upgradeAcousticModelOptions.customLanguageModelId());
    }
    if (upgradeAcousticModelOptions.force() != null) {
      builder.query("force", String.valueOf(upgradeAcousticModelOptions.force()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List audio resources.
   *
   * Lists information about all audio resources from a custom acoustic model. The information includes the name of the
   * resource and information about its audio data, such as its duration. It also includes the status of the audio
   * resource, which is important for checking the service's analysis of the resource in response to a request to add it
   * to the custom acoustic model. You must use credentials for the instance of the service that owns a model to list
   * its audio resources.
   *
   * **See also:** [Listing audio resources for a custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageAudio#listAudio).
   *
   * @param listAudioOptions the {@link ListAudioOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AudioResources}
   */
  public ServiceCall<AudioResources> listAudio(ListAudioOptions listAudioOptions) {
    Validator.notNull(listAudioOptions, "listAudioOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations", "audio" };
    String[] pathParameters = { listAudioOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "listAudio");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AudioResources> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<AudioResources>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add an audio resource.
   *
   * Adds an audio resource to a custom acoustic model. Add audio content that reflects the acoustic characteristics of
   * the audio that you plan to transcribe. You must use credentials for the instance of the service that owns a model
   * to add an audio resource to it. Adding audio data does not affect the custom acoustic model until you train the
   * model for the new data by using the **Train a custom acoustic model** method.
   *
   * You can add individual audio files or an archive file that contains multiple audio files. Adding multiple audio
   * files via a single archive file is significantly more efficient than adding each file individually. You can add
   * audio resources in any format that the service supports for speech recognition.
   *
   * You can use this method to add any number of audio resources to a custom model by calling the method once for each
   * audio or archive file. You can add multiple different audio resources at the same time. You must add a minimum of
   * 10 minutes and a maximum of 200 hours of audio that includes speech, not just silence, to a custom acoustic model
   * before you can train it. No audio resource, audio- or archive-type, can be larger than 100 MB. To add an audio
   * resource that has the same name as an existing audio resource, set the `allow_overwrite` parameter to `true`;
   * otherwise, the request fails.
   *
   * The method is asynchronous. It can take several seconds to complete depending on the duration of the audio and, in
   * the case of an archive file, the total number of audio files being processed. The service returns a 201 response
   * code if the audio is valid. It then asynchronously analyzes the contents of the audio file or files and
   * automatically extracts information about the audio such as its length, sampling rate, and encoding. You cannot
   * submit requests to train or upgrade the model until the service's analysis of all audio resources for current
   * requests completes.
   *
   * To determine the status of the service's analysis of the audio, use the **Get an audio resource** method to poll
   * the status of the audio. The method accepts the customization ID of the custom model and the name of the audio
   * resource, and it returns the status of the resource. Use a loop to check the status of the audio every few seconds
   * until it becomes `ok`.
   *
   * **See also:** [Add audio to the custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-acoustic#addAudio).
   *
   * ### Content types for audio-type resources
   *
   * You can add an individual audio file in any format that the service supports for speech recognition. For an
   * audio-type resource, use the `Content-Type` parameter to specify the audio format (MIME type) of the audio file,
   * including specifying the sampling rate, channels, and endianness where indicated.
   * * `audio/alaw` (Specify the sampling rate (`rate`) of the audio.)
   * * `audio/basic` (Use only with narrowband models.)
   * * `audio/flac`
   * * `audio/g729` (Use only with narrowband models.)
   * * `audio/l16` (Specify the sampling rate (`rate`) and optionally the number of channels (`channels`) and endianness
   * (`endianness`) of the audio.)
   * * `audio/mp3`
   * * `audio/mpeg`
   * * `audio/mulaw` (Specify the sampling rate (`rate`) of the audio.)
   * * `audio/ogg` (The service automatically detects the codec of the input audio.)
   * * `audio/ogg;codecs=opus`
   * * `audio/ogg;codecs=vorbis`
   * * `audio/wav` (Provide audio with a maximum of nine channels.)
   * * `audio/webm` (The service automatically detects the codec of the input audio.)
   * * `audio/webm;codecs=opus`
   * * `audio/webm;codecs=vorbis`
   *
   * The sampling rate of an audio file must match the sampling rate of the base model for the custom model: for
   * broadband models, at least 16 kHz; for narrowband models, at least 8 kHz. If the sampling rate of the audio is
   * higher than the minimum required rate, the service down-samples the audio to the appropriate rate. If the sampling
   * rate of the audio is lower than the minimum required rate, the service labels the audio file as `invalid`.
   *
   * **See also:** [Audio
   * formats](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-audio-formats#audio-formats).
   *
   * ### Content types for archive-type resources
   *
   * You can add an archive file (**.zip** or **.tar.gz** file) that contains audio files in any format that the
   * service supports for speech recognition. For an archive-type resource, use the `Content-Type` parameter to specify
   * the media type of the archive file:
   * * `application/zip` for a **.zip** file
   * * `application/gzip` for a **.tar.gz** file.
   *
   * When you add an archive-type resource, the `Contained-Content-Type` header is optional depending on the format of
   * the files that you are adding:
   * * For audio files of type `audio/alaw`, `audio/basic`, `audio/l16`, or `audio/mulaw`, you must use the
   * `Contained-Content-Type` header to specify the format of the contained audio files. Include the `rate`, `channels`,
   * and `endianness` parameters where necessary. In this case, all audio files contained in the archive file must have
   * the same audio format.
   * * For audio files of all other types, you can omit the `Contained-Content-Type` header. In this case, the audio
   * files contained in the archive file can have any of the formats not listed in the previous bullet. The audio files
   * do not need to have the same format.
   *
   * Do not use the `Contained-Content-Type` header when adding an audio-type resource.
   *
   * ### Naming restrictions for embedded audio files
   *
   * The name of an audio file that is contained in an archive-type resource can include a maximum of 128 characters.
   * This includes the file extension and all elements of the name (for example, slashes).
   *
   * @param addAudioOptions the {@link AddAudioOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addAudio(AddAudioOptions addAudioOptions) {
    Validator.notNull(addAudioOptions, "addAudioOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations", "audio" };
    String[] pathParameters = { addAudioOptions.customizationId(), addAudioOptions.audioName() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "addAudio");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addAudioOptions.containedContentType() != null) {
      builder.header("Contained-Content-Type", addAudioOptions.containedContentType());
    }
    if (addAudioOptions.contentType() != null) {
      builder.header("Content-Type", addAudioOptions.contentType());
    }
    if (addAudioOptions.allowOverwrite() != null) {
      builder.query("allow_overwrite", String.valueOf(addAudioOptions.allowOverwrite()));
    }
    builder.bodyContent(addAudioOptions.contentType(), null, null, addAudioOptions.audioResource());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get an audio resource.
   *
   * Gets information about an audio resource from a custom acoustic model. The method returns an `AudioListing` object
   * whose fields depend on the type of audio resource that you specify with the method's `audio_name` parameter:
   * * **For an audio-type resource,** the object's fields match those of an `AudioResource` object: `duration`, `name`,
   * `details`, and `status`.
   * * **For an archive-type resource,** the object includes a `container` field whose fields match those of an
   * `AudioResource` object. It also includes an `audio` field, which contains an array of `AudioResource` objects that
   * provides information about the audio files that are contained in the archive.
   *
   * The information includes the status of the specified audio resource. The status is important for checking the
   * service's analysis of a resource that you add to the custom model.
   * * For an audio-type resource, the `status` field is located in the `AudioListing` object.
   * * For an archive-type resource, the `status` field is located in the `AudioResource` object that is returned in the
   * `container` field.
   *
   * You must use credentials for the instance of the service that owns a model to list its audio resources.
   *
   * **See also:** [Listing audio resources for a custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageAudio#listAudio).
   *
   * @param getAudioOptions the {@link GetAudioOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AudioListing}
   */
  public ServiceCall<AudioListing> getAudio(GetAudioOptions getAudioOptions) {
    Validator.notNull(getAudioOptions, "getAudioOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations", "audio" };
    String[] pathParameters = { getAudioOptions.customizationId(), getAudioOptions.audioName() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "getAudio");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AudioListing> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<AudioListing>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an audio resource.
   *
   * Deletes an existing audio resource from a custom acoustic model. Deleting an archive-type audio resource removes
   * the entire archive of files. The service does not allow deletion of individual files from an archive resource.
   *
   * Removing an audio resource does not affect the custom model until you train the model on its updated data by using
   * the **Train a custom acoustic model** method. You can delete an existing audio resource from a model while a
   * different resource is being added to the model. You must use credentials for the instance of the service that owns
   * a model to delete its audio resources.
   *
   * **See also:** [Deleting an audio resource from a custom acoustic
   * model](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-manageAudio#deleteAudio).
   *
   * @param deleteAudioOptions the {@link DeleteAudioOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteAudio(DeleteAudioOptions deleteAudioOptions) {
    Validator.notNull(deleteAudioOptions, "deleteAudioOptions cannot be null");
    String[] pathSegments = { "v1/acoustic_customizations", "audio" };
    String[] pathParameters = { deleteAudioOptions.customizationId(), deleteAudioOptions.audioName() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "deleteAudio");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete labeled data.
   *
   * Deletes all data that is associated with a specified customer ID. The method deletes all data for the customer ID,
   * regardless of the method by which the information was added. The method has no effect if no data is associated with
   * the customer ID. You must issue the request with credentials for the same instance of the service that was used to
   * associate the customer ID with the data.
   *
   * You associate a customer ID with data by passing the `X-Watson-Metadata` header with a request that passes the
   * data.
   *
   * **See also:** [Information
   * security](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-information-security#information-security).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    Validator.notNull(deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    String[] pathSegments = { "v1/user_data" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("speech_to_text", "v1", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("customer_id", deleteUserDataOptions.customerId());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}

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
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AcousticModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AcousticModels;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AddAudioOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AddCorpusOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AddWordOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AddWordsOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AudioListing;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AudioResources;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CheckJobOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CheckJobsOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpora;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CreateAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CreateJobOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CreateLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CreateSessionOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteAudioOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteCorpusOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteJobOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteSessionOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteWordOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetAudioOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetCorpusOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetSessionStatusOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetWordOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.LanguageModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.LanguageModels;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListAcousticModelsOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListAudioOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListCorporaOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListLanguageModelsOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListModelsOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListWordsOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJob;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJobs;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeUsingWebSocketOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RegisterCallbackOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RegisterStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ResetAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ResetLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SessionStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModels;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.TrainAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.TrainLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.UnregisterCallbackOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.UpgradeAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.UpgradeLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Word;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Words;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.SpeechToTextWebSocketListener;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.WebSocket;

import java.io.InputStream;

/**
 * ### Service Overview
 * The IBM Speech to Text service provides a Representational State Transfer (REST) Application Programming Interface
 * (API) that enables you to add IBM's speech transcription capabilities to your applications. The service also supports
 * an asynchronous HTTP interface for transcribing audio via non-blocking calls. And it supports a customization
 * interface that lets you expand the vocabulary of a base model with domain-specific terminology or adapt a base model
 * for the acoustic characteristics of your audio.
 *
 * The service transcribes speech from various languages and audio formats to text with low latency. The service
 * supports transcription of the following languages: Brazilian Portuguese, French, Japanese, Mandarin Chinese, Modern
 * Standard Arabic, Spanish, UK English, and US English. For most languages, the service supports two sampling rates,
 * broadband and narrowband.
 * ### API Overview
 * The Speech to Text service provides the following endpoints:
 * * `/v1/models` returns information about the language models that are available for speech recognition.
 * * `/v1/recognize` (sessionless) includes a single method that provides a simple means of transcribing audio without
 * the overhead of establishing and maintaining a session, but it lacks some of the capabilities available with
 * sessions.
 * * `/v1/sessions` provides a collection of methods that provide a mechanism for a client to maintain a long,
 * multi-turn exchange, or session, with the service or to establish multiple parallel conversations with a particular
 * instance of the service.
 * * `/v1/recognitions` (asynchronous) provides a set of non-blocking methods for submitting, querying, and deleting
 * jobs for recognition requests with the asynchronous HTTP interface. The interface includes calls to register
 * (white-list) and unregister a callback URL.
 * * `/v1/customizations` provides methods for creating and managing custom language models. Custom language models let
 * you expand the vocabulary of a base model with domain-specific terminology.
 * * `/v1/customizations/{customization_id}/corpora` provides methods for managing the corpora associated with a custom
 * language model. You add corpora to extract out-of-vocabulary (OOV) words from the corpora into the custom language
 * model's vocabulary. You can add, list, and delete corpora from a custom language model.
 * * `/v1/customizations/{customization_id}/words` includes methods for managing individual words in a custom language
 * model. You can add, modify, list, and delete words from a custom language model.
 * * `/v1/acoustic_customizations` provides methods for creating and managing custom acoustic models. The interface lets
 * you adapt a base model for the audio characteristics of your environment and speakers.
 * * `/v1/acoustic_customizations/{customization_id}/audio` provides methods for managing the audio resources associated
 * with a custom acoustic model. You add audio resources that closely match the acoustic characteristics of the audio
 * that you want to transcribe. You can add, list, and delete audio resources from a custom acoustic model.
 *
 *
 * **Note about the Try It Out feature:** The `Try it out!` button lets you experiment with the methods of the API by
 * making actual cURL calls to the service. The feature is **not** supported for use with the session-based `POST
 * /v1/sessions/{session_id}/recognize` and sessionless `POST /v1/recognize` methods. For examples of calls to these
 * methods, see the [Speech to Text API reference](http://www.ibm.com/watson/developercloud/speech-to-text/api/v1/).
 * ### API Usage
 * The following information provides details about using the service to transcribe audio:
 * * **HTTP REST interfaces:** You can use methods of the session-based, sessionless, or asynchronous HTTP interfaces to
 * pass audio data to the service. All interfaces let you send the data via the body of the request; the session-based
 * and sessionless methods also let you pass data as multipart form data. With the former approach, you control the
 * transcription via a collection of request headers and query parameters. With the latter, you control the
 * transcription primarily via JSON metadata sent as form data.
 * * **WebSocket interface:** The service also offers a WebSocket interface as an alternative to its HTTP interfaces.
 * The WebSocket interface supports efficient implementation, lower latency, and higher throughput. The interface
 * establishes a persistent connection with the service, eliminating the need for session-based calls from the HTTP
 * interface. See [The WebSocket interface](https://console.bluemix.net/docs/services/speech-to-text/websockets.html).
 * * **Audio formats:** The service supports a variety of popular audio formats. For more information, including links
 * to a number of Internet sites that provide technical and usage details about the different formats, see [Audio
 * formats](https://console.bluemix.net/docs/services/speech-to-text/audio-formats.html).
 * * **Audio transmission:** You can pass the audio to be transcribed as a one-shot delivery or in streaming mode. With
 * one-shot delivery, you pass all of the audio data to the service at one time. With streaming mode, you send audio
 * data to the service in chunks over a persistent connection. To use streaming, you must pass the `Transfer-Encoding`
 * request header with a value of `chunked`. Both forms of data transmission impose a limit of 100 MB of total data for
 * transcription. See [Audio
 * transmission](https://console.bluemix.net/docs/services/speech-to-text/input.html#transmission).
 * * **Authentication:** You authenticate to the service by using your service credentials. You can use your credentials
 * to authenticate via a proxy server that resides in IBM Cloud, or you can use your credentials to obtain a token and
 * contact the service directly. See [Service credentials for Watson
 * services](https://console.bluemix.net/docs/services/watson/getting-started-credentials.html) and [Tokens for
 * authentication](https://console.bluemix.net/docs/services/watson/getting-started-tokens.html).
 * * **Request Logging:** By default, all Watson services log requests and their results. Data is collected only to
 * improve the Watson services. If you do not want to share your data, set the header parameter
 * `X-Watson-Learning-Opt-Out` to `true` for each request. Data is collected for any request that omits this header. See
 * [Controlling request logging for Watson
 * services](https://console.bluemix.net/docs/services/watson/getting-started-logging.html).
 *
 * For more information about the service and its various interfaces, see [About Speech to
 * Text](https://console.bluemix.net/docs/services/speech-to-text/index.html).
 * ### Customization API Usage
 * The following information pertains to methods of the customization interface:
 * * Language model customization and acoustic model customization are available only for a limited set of languages.
 * They are generally available for production use for some languages but are beta offerings for other languages. For a
 * complete list of supported languages and the status of their availability, see [Language support for
 * customization](https://console.bluemix.net/docs/services/speech-to-text/custom.html#languageSupport).
 * * In all cases, you must use service credentials created for the instance of the service that owns a custom model to
 * use the methods described in this documentation with that model. For more information, see [Ownership of custom
 * language models](https://console.bluemix.net/docs/services/speech-to-text/custom.html#customOwner).
 * * How the service handles request logging for the customization interface depends on the request. The service does
 * not log data that are used to build custom models. But it does log data when a custom model is used with a
 * recognition request. For more information, see [Request logging and data
 * privacy](https://console.bluemix.net/docs/services/speech-to-text/custom.html#customLogging).
 * * Each custom model is identified by a customization ID, which is a Globally Unique Identifier (GUID). A GUID is a
 * hexadecimal string that has the same format as Watson service credentials: `xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx`.
 * You specify a custom model's GUID with the appropriate customization parameter of methods that support customization.
 *
 *
 * For more information about using the service's customization interface, see [The customization
 * interface](https://console.bluemix.net/docs/services/speech-to-text/custom.html).
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/speech-to-text.html">Speech to Text</a>
 */
public class SpeechToText extends WatsonService {

  private static final String SERVICE_NAME = "speech_to_text";
  private static final String URL = "https://stream.watsonplatform.net/speech-to-text/api";

  /**
   * Instantiates a new `SpeechToText`.
   *
   */
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
   */
  public SpeechToText(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Retrieves information about the model.
   *
   * Returns information about a single specified language model that is available for use with the service. The
   * information includes the name of the model and its minimum sampling rate in Hertz, among other things.
   *
   * @param getModelOptions the {@link GetModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SpeechModel}
   */
  public ServiceCall<SpeechModel> getModel(GetModelOptions getModelOptions) {
    Validator.notNull(getModelOptions, "getModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/models/%s", getModelOptions.modelId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SpeechModel.class));
  }

  /**
   * Retrieves the models available for the service.
   *
   * Returns a list of all language models that are available for use with the service. The information includes the
   * name of the model and its minimum sampling rate in Hertz, among other things.
   *
   * @param listModelsOptions the {@link ListModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SpeechModels}
   */
  public ServiceCall<SpeechModels> listModels(ListModelsOptions listModelsOptions) {
    RequestBuilder builder = RequestBuilder.get("/v1/models");
    if (listModelsOptions != null) {
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SpeechModels.class));
  }

  /**
   * Retrieves the models available for the service.
   *
   * Returns a list of all language models that are available for use with the service. The information includes the
   * name of the model and its minimum sampling rate in Hertz, among other things.
   *
   * @return a {@link ServiceCall} with a response type of {@link SpeechModels}
   */
  public ServiceCall<SpeechModels> listModels() {
    return listModels(null);
  }

  /**
   * Sends audio and returns transcription results for a recognition request. This request can be session-based or
   * sessionless, using a multipart or non-multipart request. Returns only the final results; to enable interim
   * results, use the WebSocket API. The service imposes a data size limit of 100 MB. It automatically detects the
   * endianness of the incoming audio and, for audio that includes multiple channels, downmixes the audio to
   * one-channel mono during transcoding. (For the `audio/l16` format, you can specify the endianness.)
   *
   * ###Streaming mode
   * For requests to transcribe live audio as it becomes available or to transcribe multiple audio files with
   * multipart requests, you must set the `Transfer-Encoding` header to `chunked` to use streaming mode. In streaming
   * mode, the server closes the connection (status code 408) if the service receives no data chunk for 30 seconds
   * and the service has no audio to transcribe for 30 seconds. The server also closes the connection (status code
   * 400) if no speech is detected for `inactivity_timeout` seconds of audio (not processing time); use the
   * `inactivity_timeout` parameter to change the default of 30 seconds.
   *
   * ###Non-multipart requests
   * For non-multipart requests, you specify all parameters of the request as a collection of request headers and
   * query parameters, and you provide the audio as the body of the request. This is the recommended means of
   * submitting a recognition request. Use the following parameters:
   * * **Required:** `Content-Type` and `audio`
   * * **Optional:** `Transfer-Encoding`, `model`, `customization_id`, `acoustic_customization_id`,
   * `customization_weight`, `version`, `inactivity_timeout`, `keywords`, `keywords_threshold`, `max_alternatives`,
   * `word_alternatives_threshold`, `word_confidence`, `timestamps`, `profanity_filter`, `smart_formatting`, and
   * `speaker_labels`
   *
   * ###Multipart requests
   * For multipart requests, you specify a few parameters of the request as request headers and query parameters, but
   * you specify most parameters as multipart form data in the form of JSON metadata, in which only
   * `part_content_type` is required. You then specify the audio files for the request as subsequent parts of the
   * form data. Use this approach with browsers that do not support JavaScript or when the parameters of the request
   * are greater than the 8 KB limit imposed by most HTTP servers and proxies. Use the following parameters:
   * * **Required:** `Content-Type`, `metadata`, and `upload`
   * * **Optional:** `Transfer-Encoding`, `model`, `customization_id`, `acoustic_customization_id`,
   * `customization_weight`, and `version`
   *
   * An example of the multipart metadata for a pair of FLAC files follows. This first part of the request is sent as
   * JSON; the remaining parts are the audio files for the request.
   *
   * `metadata=\"{
   * \\\"part_content_type\\\":\\\"audio/flac\\\",\\\"data_parts_count\\\":2,\\\"inactivity_timeout\\\"=-1
   * }\"`
   *
   * **Note about the Try It Out feature:** The `Try it out!` button is **not** supported for use with the the `POST
   * /v1/recognize` method. For examples of calls to the method, see the [Speech to Text API reference](http://www
   * .ibm.com/watson/developercloud/speech-to-text/api/v1/).
   *
   * @param recognizeOptions the recognize options
   * @return a {@link ServiceCall} with a response type of {@link SpeechRecognitionResults}
   */
  public ServiceCall<SpeechRecognitionResults> recognize(RecognizeOptions recognizeOptions) {
    Validator.notNull(recognizeOptions, "recognizeOptions cannot be null");
    Validator.isTrue(((recognizeOptions.audio() != null
            && recognizeOptions.upload() == null)
            || (recognizeOptions.audio() == null
            && recognizeOptions.upload() != null)),
        "Exactly one of audio or upload must be supplied.");
    RequestBuilder builder = RequestBuilder.post("/v1/recognize");
    builder.header("Content-Type", recognizeOptions.contentType());
    if (recognizeOptions.transferEncoding() != null) {
      builder.header("Transfer-Encoding", recognizeOptions.transferEncoding());
    }
    if (recognizeOptions.model() != null) {
      builder.query("model", recognizeOptions.model());
    }
    if (recognizeOptions.customizationId() != null) {
      builder.query("customization_id", recognizeOptions.customizationId());
    }
    if (recognizeOptions.acousticCustomizationId() != null) {
      builder.query("acoustic_customization_id", recognizeOptions.acousticCustomizationId());
    }
    if (recognizeOptions.customizationWeight() != null) {
      builder.query("customization_weight", recognizeOptions.customizationWeight());
    }
    if (recognizeOptions.version() != null) {
      builder.query("version", recognizeOptions.version());
    }
    if (recognizeOptions.inactivityTimeout() != null) {
      builder.query("inactivity_timeout", recognizeOptions.inactivityTimeout());
    }
    if (recognizeOptions.keywords() != null) {
      builder.query("keywords", RequestUtils.join(recognizeOptions.keywords(), ","));
    }
    if (recognizeOptions.keywordsThreshold() != null) {
      builder.query("keywords_threshold", recognizeOptions.keywordsThreshold());
    }
    if (recognizeOptions.maxAlternatives() != null) {
      builder.query("max_alternatives", recognizeOptions.maxAlternatives());
    }
    if (recognizeOptions.wordAlternativesThreshold() != null) {
      builder.query("word_alternatives_threshold", recognizeOptions.wordAlternativesThreshold());
    }
    if (recognizeOptions.wordConfidence() != null) {
      builder.query("word_confidence", recognizeOptions.wordConfidence());
    }
    if (recognizeOptions.timestamps() != null) {
      builder.query("timestamps", recognizeOptions.timestamps());
    }
    if (recognizeOptions.profanityFilter() != null) {
      builder.query("profanity_filter", recognizeOptions.profanityFilter());
    }
    if (recognizeOptions.smartFormatting() != null) {
      builder.query("smart_formatting", recognizeOptions.smartFormatting());
    }
    if (recognizeOptions.speakerLabels() != null) {
      builder.query("speaker_labels", recognizeOptions.speakerLabels());
    }
    if (recognizeOptions.audio() != null) {
      builder.body(RequestBody.create(MediaType.parse(recognizeOptions.contentType()), recognizeOptions.audio()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (recognizeOptions.upload() != null) {
      RequestBody fileBody = RequestUtils.inputStreamBody(recognizeOptions.upload(), recognizeOptions
          .contentType());
      multipartBuilder.addFormDataPart("upload", recognizeOptions.uploadFilename(), fileBody);
      if (recognizeOptions.metadata() != null) {
        multipartBuilder.addFormDataPart("metadata", GsonSingleton.getGson().toJson(recognizeOptions.metadata()));
      }
      builder.body(multipartBuilder.build());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SpeechRecognitionResults.class));
  }

  /**
   * Sends audio and returns transcription results for recognition requests over a WebSocket connection. Requests and
   * responses are enabled over a single TCP connection that abstracts much of the complexity of the request to offer
   * efficient implementation, low latency, high throughput, and an asynchronous response. By default, only final
   * results are returned for any request; to enable interim results, set the interimResults parameter to true.
   *
   * The service imposes a data size limit of 100 MB per utterance (per recognition request). You can send multiple
   * utterances over a single WebSocket connection. The service automatically detects the endianness of the incoming
   * audio and, for audio that includes multiple channels, downmixes the audio to one-channel mono during transcoding.
   * (For the audio/l16 format, you can specify the endianness.)
   *
   * @param audio the audio file
   * @param recognizeUsingWebSocketOptions the recognize options
   * @param callback the {@link RecognizeCallback} instance where results will be sent
   * @return the {@link WebSocket}
   */
  public WebSocket recognizeUsingWebSocket(InputStream audio,
                                           RecognizeUsingWebSocketOptions recognizeUsingWebSocketOptions,
                                           RecognizeCallback callback) {
    Validator.notNull(recognizeUsingWebSocketOptions, "recognizeUsingWebSocketOptions cannot be null");
    Validator.notNull(audio, "audio cannot be null");
    Validator.notNull(callback, "callback cannot be null");

    HttpUrl.Builder urlBuilder = HttpUrl.parse(getEndPoint() + "/v1/recognize").newBuilder();

    if (recognizeUsingWebSocketOptions.model() != null) {
      urlBuilder.addQueryParameter("model", recognizeUsingWebSocketOptions.model());
    }
    if (recognizeUsingWebSocketOptions.customizationId() != null) {
      urlBuilder.addQueryParameter("customization_id", recognizeUsingWebSocketOptions.customizationId());
    }
    if (recognizeUsingWebSocketOptions.acousticCustomizationId() != null) {
      urlBuilder.addQueryParameter(
          "acoustic_customization_id",
          recognizeUsingWebSocketOptions.acousticCustomizationId()
      );
    }
    if (recognizeUsingWebSocketOptions.version() != null) {
      urlBuilder.addQueryParameter("version", recognizeUsingWebSocketOptions.version());
    }
    if (recognizeUsingWebSocketOptions.customizationWeight() != null) {
      urlBuilder.addQueryParameter("customization_weight",
          String.valueOf(recognizeUsingWebSocketOptions.customizationWeight()));
    }

    String url = urlBuilder.toString().replace("https://", "wss://");
    Request.Builder builder = new Request.Builder().url(url);

    setAuthentication(builder);
    setDefaultHeaders(builder);

    OkHttpClient client = configureHttpClient();
    return client.newWebSocket(builder.build(),
        new SpeechToTextWebSocketListener(audio, recognizeUsingWebSocketOptions, callback));
  }

  /**
   * Creates a session.
   *
   * Creates a session and locks recognition requests to that engine. You can use the session for multiple recognition
   * requests so that each request is processed with the same Speech to Text engine. The session expires after 30
   * seconds of inactivity. For information about avoiding session timeouts, see
   * [Timeouts](https://console.bluemix.net/docs/services/speech-to-text/input.html#timeouts). The method returns a
   * cookie in the `Set-Cookie` response header. You must pass this cookie with each request that uses the session. For
   * more information, see [Using cookies with
   * sessions](https://console.bluemix.net/docs/services/speech-to-text/http.html#cookies).
   *
   * @param createSessionOptions the {@link CreateSessionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SpeechSession}
   */
  public ServiceCall<SpeechSession> createSession(CreateSessionOptions createSessionOptions) {
    RequestBuilder builder = RequestBuilder.post("/v1/sessions");
    if (createSessionOptions != null) {
      if (createSessionOptions.model() != null) {
        builder.query("model", createSessionOptions.model());
      }
      if (createSessionOptions.customizationId() != null) {
        builder.query("customization_id", createSessionOptions.customizationId());
      }
      if (createSessionOptions.acousticCustomizationId() != null) {
        builder.query("acoustic_customization_id", createSessionOptions.acousticCustomizationId());
      }
      if (createSessionOptions.customizationWeight() != null) {
        builder.query("customization_weight", String.valueOf(createSessionOptions.customizationWeight()));
      }
      if (createSessionOptions.version() != null) {
        builder.query("version", createSessionOptions.version());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SpeechSession.class));
  }

  /**
   * Creates a session.
   *
   * Creates a session and locks recognition requests to that engine. You can use the session for multiple recognition
   * requests so that each request is processed with the same Speech to Text engine. The session expires after 30
   * seconds of inactivity. For information about avoiding session timeouts, see
   * [Timeouts](https://console.bluemix.net/docs/services/speech-to-text/input.html#timeouts). The method returns a
   * cookie in the `Set-Cookie` response header. You must pass this cookie with each request that uses the session. For
   * more information, see [Using cookies with
   * sessions](https://console.bluemix.net/docs/services/speech-to-text/http.html#cookies).
   *
   * @return a {@link ServiceCall} with a response type of {@link SpeechSession}
   */
  public ServiceCall<SpeechSession> createSession() {
    return createSession(null);
  }

  /**
   * Deletes the specified session.
   *
   * Deletes an existing session and its engine. The request must pass the cookie that was returned by the `POST
   * /v1/sessions` method. You cannot send requests to a session after it is deleted. By default, a session expires
   * after 30 seconds of inactivity if you do not delete it first.
   *
   * @param deleteSessionOptions the {@link DeleteSessionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteSession(DeleteSessionOptions deleteSessionOptions) {
    Validator.notNull(deleteSessionOptions, "deleteSessionOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/sessions/%s", deleteSessionOptions.sessionId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Checks whether a session is ready to accept a new recognition task.
   *
   * Checks whether a specified session can accept another recognition request. Concurrent recognition tasks during the
   * same session are not allowed. The method blocks until the session is in the `initialized` state to indicate that
   * you can send another recognition request. The request must pass the cookie that was returned by the `POST
   * /v1/sessions` method.
   *
   * @param getSessionStatusOptions the {@link GetSessionStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SessionStatus}
   */
  public ServiceCall<SessionStatus> getSessionStatus(GetSessionStatusOptions getSessionStatusOptions) {
    Validator.notNull(getSessionStatusOptions, "getSessionStatusOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/sessions/%s/recognize", getSessionStatusOptions
        .sessionId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SessionStatus.class));
  }

  /**
   * Checks the status of the specified asynchronous job.
   *
   * Returns information about the specified job. The response always includes the status of the job and its creation
   * and update times. If the status is `completed`, the response includes the results of the recognition request. You
   * must submit the request with the service credentials of the user who created the job. You can use the method to
   * retrieve the results of any job, regardless of whether it was submitted with a callback URL and the
   * `recognitions.completed_with_results` event, and you can retrieve the results multiple times for as long as they
   * remain available.
   *
   * @param checkJobOptions the {@link CheckJobOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link RecognitionJob}
   */
  public ServiceCall<RecognitionJob> checkJob(CheckJobOptions checkJobOptions) {
    Validator.notNull(checkJobOptions, "checkJobOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/recognitions/%s", checkJobOptions.id()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(RecognitionJob.class));
  }

  /**
   * Checks the status of all asynchronous jobs.
   *
   * Returns the ID and status of all outstanding jobs associated with the service credentials with which it is called.
   * The method also returns the creation and update times of each job, and, if a job was created with a callback URL
   * and a user token, the user token for the job. To obtain the results for a job whose status is `completed`, use the
   * `GET /v1/recognitions/{id}` method. A job and its results remain available until you delete them with the `DELETE
   * /v1/recognitions/{id}` method or until the job's time to live expires, whichever comes first.
   *
   * @param checkJobsOptions the {@link CheckJobsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link RecognitionJobs}
   */
  public ServiceCall<RecognitionJobs> checkJobs(CheckJobsOptions checkJobsOptions) {
    RequestBuilder builder = RequestBuilder.get("/v1/recognitions");
    if (checkJobsOptions != null) {
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(RecognitionJobs.class));
  }

  /**
   * Checks the status of all asynchronous jobs.
   *
   * Returns the ID and status of all outstanding jobs associated with the service credentials with which it is called.
   * The method also returns the creation and update times of each job, and, if a job was created with a callback URL
   * and a user token, the user token for the job. To obtain the results for a job whose status is `completed`, use the
   * `GET /v1/recognitions/{id}` method. A job and its results remain available until you delete them with the `DELETE
   * /v1/recognitions/{id}` method or until the job's time to live expires, whichever comes first.
   *
   * @return a {@link ServiceCall} with a response type of {@link RecognitionJobs}
   */
  public ServiceCall<RecognitionJobs> checkJobs() {
    return checkJobs(null);
  }

  /**
   * Creates a job for an asynchronous recognition request.
   *
   * Creates a job for a new asynchronous recognition request. The job is owned by the user whose service credentials
   * are used to create it. How you learn the status and results of a job depends on the parameters you include with the
   * job creation request: * By callback notification: Include the `callback_url` query parameter to specify a URL to
   * which the service is to send callback notifications when the status of the job changes. Optionally, you can also
   * include the `events` and `user_token` query parameters to subscribe to specific events and to specify a string that
   * is to be included with each notification for the job. * By polling the service: Omit the `callback_url`, `events`,
   * and `user_token` query parameters. You must then use the `GET /v1/recognitions` or `GET /v1/recognitions/{id}`
   * methods to check the status of the job, using the latter to retrieve the results when the job is complete. The two
   * approaches are not mutually exclusive. You can poll the service for job status or obtain results from the service
   * manually even if you include a callback URL. In both cases, you can include the `results_ttl` parameter to specify
   * how long the results are to remain available after the job is complete. Note that using the HTTPS `GET
   * /v1/recognitions/{id}` method to retrieve results is more secure than receiving them via callback notification over
   * HTTP because it provides confidentiality in addition to authentication and data integrity. The method supports the
   * same basic parameters as other HTTP and WebSocket recognition requests. The service imposes a data size limit of
   * 100 MB. It automatically detects the endianness of the incoming audio and, for audio that includes multiple
   * channels, downmixes the audio to one-channel mono during transcoding. (For the `audio/l16` format, you can specify
   * the endianness.).
   *
   * @param createJobOptions the {@link CreateJobOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link RecognitionJob}
   */
  public ServiceCall<RecognitionJob> createJob(CreateJobOptions createJobOptions) {
    Validator.notNull(createJobOptions, "createJobOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/recognitions");
    if (createJobOptions.transferEncoding() != null) {
      builder.header("Transfer-Encoding", createJobOptions.transferEncoding());
    }
    builder.header("Content-Type", createJobOptions.contentType());
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
    if (createJobOptions.model() != null) {
      builder.query("model", createJobOptions.model());
    }
    if (createJobOptions.customizationId() != null) {
      builder.query("customization_id", createJobOptions.customizationId());
    }
    if (createJobOptions.acousticCustomizationId() != null) {
      builder.query("acoustic_customization_id", createJobOptions.acousticCustomizationId());
    }
    if (createJobOptions.customizationWeight() != null) {
      builder.query("customization_weight", String.valueOf(createJobOptions.customizationWeight()));
    }
    if (createJobOptions.version() != null) {
      builder.query("version", createJobOptions.version());
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
    builder.body(RequestBody.create(MediaType.parse(createJobOptions.contentType()), createJobOptions.audio()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(RecognitionJob.class));
  }

  /**
   * Deletes the specified asynchronous job.
   *
   * Deletes the specified job. You cannot delete a job that the service is actively processing. Once you delete a job,
   * its results are no longer available. The service automatically deletes a job and its results when the time to live
   * for the results expires. You must submit the request with the service credentials of the user who created the job.
   *
   * @param deleteJobOptions the {@link DeleteJobOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteJob(DeleteJobOptions deleteJobOptions) {
    Validator.notNull(deleteJobOptions, "deleteJobOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/recognitions/%s", deleteJobOptions.id()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Registers a callback URL for use with the asynchronous interface.
   *
   * Registers a callback URL with the service for use with subsequent asynchronous recognition requests. The service
   * attempts to register, or white-list, the callback URL if it is not already registered by sending a `GET` request to
   * the callback URL. The service passes a random alphanumeric challenge string via the `challenge_string` query
   * parameter of the request. The request includes an `Accept` header that specifies `text/plain` as the required
   * response type. To be registered successfully, the callback URL must respond to the `GET` request from the service.
   * The response must send status code 200 and must include the challenge string in its body. Set the `Content-Type`
   * response header to `text/plain`. Upon receiving this response, the service responds to the original `POST`
   * registration request with response code 201. The service sends only a single `GET` request to the callback URL. If
   * the service does not receive a reply with a response code of 200 and a body that echoes the challenge string sent
   * by the service within five seconds, it does not white-list the URL; it instead sends status code 400 in response to
   * the `POST` registration request. If the requested callback URL is already white-listed, the service responds to the
   * initial registration request with response code 200. If you specify a user secret with the request, the service
   * uses it as a key to calculate an HMAC-SHA1 signature of the challenge string in its response to the `POST` request.
   * It sends this signature in the `X-Callback-Signature` header of its `GET` request to the URL during registration.
   * It also uses the secret to calculate a signature over the payload of every callback notification that uses the URL.
   * The signature provides authentication and data integrity for HTTP communications. Once you successfully register a
   * callback URL, you can use it with an indefinite number of recognition requests. You can register a maximum of 20
   * callback URLS in a one-hour span of time. For more information, see [Registering a callback
   * URL](https://console.bluemix.net/docs/services/speech-to-text/async.html#register).
   *
   * @param registerCallbackOptions the {@link RegisterCallbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link RegisterStatus}
   */
  public ServiceCall<RegisterStatus> registerCallback(RegisterCallbackOptions registerCallbackOptions) {
    Validator.notNull(registerCallbackOptions, "registerCallbackOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/register_callback");
    builder.query("callback_url", registerCallbackOptions.callbackUrl());
    if (registerCallbackOptions.userSecret() != null) {
      builder.query("user_secret", registerCallbackOptions.userSecret());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(RegisterStatus.class));
  }

  /**
   * Removes the registration for an asynchronous callback URL.
   *
   * Unregisters a callback URL that was previously white-listed with a `POST register_callback` request for use with
   * the asynchronous interface. Once unregistered, the URL can no longer be used with asynchronous recognition
   * requests.
   *
   * @param unregisterCallbackOptions the {@link UnregisterCallbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> unregisterCallback(UnregisterCallbackOptions unregisterCallbackOptions) {
    Validator.notNull(unregisterCallbackOptions, "unregisterCallbackOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/unregister_callback");
    builder.query("callback_url", unregisterCallbackOptions.callbackUrl());
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Creates a custom language model.
   *
   * Creates a new custom language model for a specified base model. The custom language model can be used only with the
   * base model for which it is created. The model is owned by the instance of the service whose credentials are used to
   * create it.
   *
   * @param createLanguageModelOptions the {@link CreateLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link LanguageModel}
   */
  public ServiceCall<LanguageModel> createLanguageModel(CreateLanguageModelOptions createLanguageModelOptions) {
    Validator.notNull(createLanguageModelOptions, "createLanguageModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/customizations");
    builder.header("Content-Type", createLanguageModelOptions.contentType());
    if (createLanguageModelOptions.contentType().equalsIgnoreCase(
        CreateLanguageModelOptions.ContentType.APPLICATION_JSON)) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(createLanguageModelOptions.createLanguageModel())
          .getAsJsonObject());
    } else {
      builder.bodyContent(createLanguageModelOptions.body(), createLanguageModelOptions.contentType());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(LanguageModel.class));
  }

  /**
   * Deletes a custom language model.
   *
   * Deletes an existing custom language model. The custom model cannot be deleted if another request, such as adding a
   * corpus to the model, is currently being processed. You must use credentials for the instance of the service that
   * owns a model to delete it.
   *
   * @param deleteLanguageModelOptions the {@link DeleteLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteLanguageModel(DeleteLanguageModelOptions deleteLanguageModelOptions) {
    Validator.notNull(deleteLanguageModelOptions, "deleteLanguageModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/customizations/%s", deleteLanguageModelOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Lists information about a custom language model.
   *
   * Lists information about a specified custom language model. You must use credentials for the instance of the service
   * that owns a model to list information about it.
   *
   * @param getLanguageModelOptions the {@link GetLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link LanguageModel}
   */
  public ServiceCall<LanguageModel> getLanguageModel(GetLanguageModelOptions getLanguageModelOptions) {
    Validator.notNull(getLanguageModelOptions, "getLanguageModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/customizations/%s", getLanguageModelOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(LanguageModel.class));
  }

  /**
   * Lists information about all custom language models.
   *
   * Lists information about all custom language models that are owned by an instance of the service. Use the `language`
   * parameter to see all custom language models for the specified language; omit the parameter to see all custom
   * language models for all languages. You must use credentials for the instance of the service that owns a model to
   * list information about it.
   *
   * @param listLanguageModelsOptions the {@link ListLanguageModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link LanguageModels}
   */
  public ServiceCall<LanguageModels> listLanguageModels(ListLanguageModelsOptions listLanguageModelsOptions) {
    RequestBuilder builder = RequestBuilder.get("/v1/customizations");
    if (listLanguageModelsOptions != null) {
      if (listLanguageModelsOptions.language() != null) {
        builder.query("language", listLanguageModelsOptions.language());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(LanguageModels.class));
  }

  /**
   * Lists information about all custom language models.
   *
   * Lists information about all custom language models that are owned by an instance of the service. Use the `language`
   * parameter to see all custom language models for the specified language; omit the parameter to see all custom
   * language models for all languages. You must use credentials for the instance of the service that owns a model to
   * list information about it.
   *
   * @return a {@link ServiceCall} with a response type of {@link LanguageModels}
   */
  public ServiceCall<LanguageModels> listLanguageModels() {
    return listLanguageModels(null);
  }

  /**
   * Resets a custom language model.
   *
   * Resets a custom language model by removing all corpora and words from the model. Resetting a custom language model
   * initializes the model to its state when it was first created. Metadata such as the name and language of the model
   * are preserved, but the model's words resource is removed and must be re-created. You must use credentials for the
   * instance of the service that owns a model to reset it.
   *
   * @param resetLanguageModelOptions the {@link ResetLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> resetLanguageModel(ResetLanguageModelOptions resetLanguageModelOptions) {
    Validator.notNull(resetLanguageModelOptions, "resetLanguageModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/customizations/%s/reset", resetLanguageModelOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Trains a custom language model.
   *
   * Initiates the training of a custom language model with new corpora, custom words, or both. After adding, modifying,
   * or deleting corpora or words for a custom language model, use this method to begin the actual training of the model
   * on the latest data. You can specify whether the custom language model is to be trained with all words from its
   * words resource or only with words that were added or modified by the user. You must use credentials for the
   * instance of the service that owns a model to train it. The training method is asynchronous. It can take on the
   * order of minutes to complete depending on the amount of data on which the service is being trained and the current
   * load on the service. The method returns an HTTP 200 response code to indicate that the training process has begun.
   * You can monitor the status of the training by using the `GET /v1/customizations/{customization_id}` method to poll
   * the model's status. Use a loop to check the status every 10 seconds. The method returns a `Customization` object
   * that includes `status` and `progress` fields. A status of `available` means that the custom model is trained and
   * ready to use. The service cannot accept subsequent training requests, or requests to add new corpora or words,
   * until the existing request completes. Training can fail to start for the following reasons: * The service is
   * currently handling another request for the custom model, such as another training request or a request to add a
   * corpus or words to the model. * No training data (corpora or words) have been added to the custom model. * One or
   * more words that were added to the custom model have invalid sounds-like pronunciations that you must fix.
   *
   * @param trainLanguageModelOptions the {@link TrainLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> trainLanguageModel(TrainLanguageModelOptions trainLanguageModelOptions) {
    Validator.notNull(trainLanguageModelOptions, "trainLanguageModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/customizations/%s/train", trainLanguageModelOptions
        .customizationId()));
    if (trainLanguageModelOptions.wordTypeToAdd() != null) {
      builder.query("word_type_to_add", trainLanguageModelOptions.wordTypeToAdd());
    }
    if (trainLanguageModelOptions.customizationWeight() != null) {
      builder.query("customization_weight", String.valueOf(trainLanguageModelOptions.customizationWeight()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Upgrades a custom language model.
   *
   * Initiates the upgrade of a custom language model to the latest version of its base language model. The upgrade
   * method is asynchronous. It can take on the order of minutes to complete depending on the amount of data in the
   * custom model and the current load on the service. A custom model must be in the `ready` or `available` state to be
   * upgraded. You must use credentials for the instance of the service that owns a model to upgrade it. The method
   * returns an HTTP 200 response code to indicate that the upgrade process has begun successfully. You can monitor the
   * status of the upgrade by using the `GET /v1/customizations/{customization_id}` method to poll the model's status.
   * Use a loop to check the status every 10 seconds. While it is being upgraded, the custom model has the status
   * `upgrading`. When the upgrade is complete, the model resumes the status that it had prior to upgrade. The service
   * cannot accept subsequent requests for the model until the upgrade completes. For more information, see [Upgrading
   * custom models](https://console.bluemix.net/docs/services/speech-to-text/custom-upgrade.html).
   *
   * @param upgradeLanguageModelOptions the {@link UpgradeLanguageModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> upgradeLanguageModel(UpgradeLanguageModelOptions upgradeLanguageModelOptions) {
    Validator.notNull(upgradeLanguageModelOptions, "upgradeLanguageModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/customizations/%s/upgrade_model",
        upgradeLanguageModelOptions.customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Adds a corpus text file to a custom language model.
   *
   * Adds a single corpus text file of new training data to a custom language model. Use multiple requests to submit
   * multiple corpus text files. You must use credentials for the instance of the service that owns a model to add a
   * corpus to it. Note that adding a corpus does not affect the custom language model until you train the model for the
   * new data by using the `POST /v1/customizations/{customization_id}/train` method. Submit a plain text file that
   * contains sample sentences from the domain of interest to enable the service to extract words in context. The more
   * sentences you add that represent the context in which speakers use words from the domain, the better the service's
   * recognition accuracy. For guidelines about adding a corpus text file and for information about how the service
   * parses a corpus file, see [Preparing a corpus text
   * file](https://console.bluemix.net/docs/services/speech-to-text/language-resource.html#prepareCorpus). The call
   * returns an HTTP 201 response code if the corpus is valid. The service then asynchronously processes the contents of
   * the corpus and automatically extracts new words that it finds. This can take on the order of a minute or two to
   * complete depending on the total number of words and the number of new words in the corpus, as well as the current
   * load on the service. You cannot submit requests to add additional corpora or words to the custom model, or to train
   * the model, until the service's analysis of the corpus for the current request completes. Use the `GET
   * /v1/customizations/{customization_id}/corpora/{corpus_name}` method to check the status of the analysis. The
   * service auto-populates the model's words resource with any word that is not found in its base vocabulary; these are
   * referred to as out-of-vocabulary (OOV) words. You can use the `GET /v1/customizations/{customization_id}/words`
   * method to examine the words resource, using other words method to eliminate typos and modify how words are
   * pronounced as needed. To add a corpus file that has the same name as an existing corpus, set the allow_overwrite
   * query parameter to true; otherwise, the request fails. Overwriting an existing corpus causes the service to process
   * the corpus text file and extract OOV words anew. Before doing so, it removes any OOV words associated with the
   * existing corpus from the model's words resource unless they were also added by another corpus or they have been
   * modified in some way with the `POST /v1/customizations/{customization_id}/words` or `PUT
   * /v1/customizations/{customization_id}/words/{word_name}` method. The service limits the overall amount of data that
   * you can add to a custom model to a maximum of 10 million total words from all corpora combined. Also, you can add
   * no more than 30 thousand new custom words to a model; this includes words that the service extracts from corpora
   * and words that you add directly.
   *
   * @param addCorpusOptions the {@link AddCorpusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addCorpus(AddCorpusOptions addCorpusOptions) {
    Validator.notNull(addCorpusOptions, "addCorpusOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/customizations/%s/corpora/%s", addCorpusOptions
        .customizationId(), addCorpusOptions.corpusName()));
    if (addCorpusOptions.allowOverwrite() != null) {
      builder.query("allow_overwrite", String.valueOf(addCorpusOptions.allowOverwrite()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody corpusFileBody = RequestUtils.inputStreamBody(addCorpusOptions.corpusFile(), addCorpusOptions
        .corpusFileContentType());
    multipartBuilder.addFormDataPart("corpus_file", addCorpusOptions.corpusFilename(), corpusFileBody);
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes a corpus from a custom language model.
   *
   * Deletes an existing corpus from a custom language model. The service removes any out-of-vocabulary (OOV) words
   * associated with the corpus from the custom model's words resource unless they were also added by another corpus or
   * they have been modified in some way with the `POST /v1/customizations/{customization_id}/words` or `PUT
   * /v1/customizations/{customization_id}/words/{word_name}` method. Removing a corpus does not affect the custom model
   * until you train the model with the `POST /v1/customizations/{customization_id}/train` method. You must use
   * credentials for the instance of the service that owns a model to delete its corpora.
   *
   * @param deleteCorpusOptions the {@link DeleteCorpusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteCorpus(DeleteCorpusOptions deleteCorpusOptions) {
    Validator.notNull(deleteCorpusOptions, "deleteCorpusOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/customizations/%s/corpora/%s", deleteCorpusOptions
        .customizationId(), deleteCorpusOptions.corpusName()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Lists information about a corpus for a custom language model.
   *
   * Lists information about a corpus from a custom language model. The information includes the total number of words
   * and out-of-vocabulary (OOV) words, name, and status of the corpus. You must use credentials for the instance of the
   * service that owns a model to list its corpora.
   *
   * @param getCorpusOptions the {@link GetCorpusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Corpus}
   */
  public ServiceCall<Corpus> getCorpus(GetCorpusOptions getCorpusOptions) {
    Validator.notNull(getCorpusOptions, "getCorpusOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/customizations/%s/corpora/%s", getCorpusOptions
        .customizationId(), getCorpusOptions.corpusName()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Corpus.class));
  }

  /**
   * Lists information about all corpora for a custom language model.
   *
   * Lists information about all corpora from a custom language model. The information includes the total number of
   * words and out-of-vocabulary (OOV) words, name, and status of each corpus. You must use credentials for the instance
   * of the service that owns a model to list its corpora.
   *
   * @param listCorporaOptions the {@link ListCorporaOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Corpora}
   */
  public ServiceCall<Corpora> listCorpora(ListCorporaOptions listCorporaOptions) {
    Validator.notNull(listCorporaOptions, "listCorporaOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/customizations/%s/corpora", listCorporaOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Corpora.class));
  }

  /**
   * Adds a custom word to a custom language model.
   *
   * Adds a custom word to a custom language model. The service populates the words resource for a custom model with
   * out-of-vocabulary (OOV) words found in each corpus added to the model. You can use this method to add additional
   * words or to modify existing words in the words resource. You must use credentials for the instance of the service
   * that owns a model to add or modify a custom word for the model. Adding or modifying a custom word does not affect
   * the custom model until you train the model for the new data by using the `POST
   * /v1/customizations/{customization_id}/train` method. Use the `word_name` path parameter to specify the custom word
   * that is to be added or modified. Use the `CustomWord` object to provide one or both of the optional `sounds_like`
   * and `display_as` fields for the word. * The `sounds_like` field provides an array of one or more pronunciations for
   * the word. Use the parameter to specify how the word can be pronounced by users. Use the parameter for words that
   * are difficult to pronounce, foreign words, acronyms, and so on. For example, you might specify that the word `IEEE`
   * can sound like `i triple e`. You can specify a maximum of five sounds-like pronunciations for a word. For
   * information about pronunciation rules, see [Using the sounds_like
   * field](https://console.bluemix.net/docs/services/speech-to-text/language-resource.html#soundsLike). * The
   * `display_as` field provides a different way of spelling the word in a transcript. Use the parameter when you want
   * the word to appear different from its usual representation or from its spelling in corpora training data. For
   * example, you might indicate that the word `IBM(trademark)` is to be displayed as `IBM`. For more information, see
   * [Using the display_as
   * field](https://console.bluemix.net/docs/services/speech-to-text/language-resource.html#displayAs). If you add a
   * custom word that already exists in the words resource for the custom model, the new definition overwrites the
   * existing data for the word. If the service encounters an error, it does not add the word to the words resource. Use
   * the `GET /v1/customizations/{customization_id}/words/{word_name}` method to review the word that you add.
   *
   * @param addWordOptions the {@link AddWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWord(AddWordOptions addWordOptions) {
    Validator.notNull(addWordOptions, "addWordOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/customizations/%s/words/%s", addWordOptions
        .customizationId(), addWordOptions.wordName()));
    builder.header("Content-Type", addWordOptions.contentType());
    if (addWordOptions.contentType().equalsIgnoreCase(AddWordOptions.ContentType.APPLICATION_JSON)) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(addWordOptions.customWord()).getAsJsonObject());
    } else {
      builder.bodyContent(addWordOptions.body(), addWordOptions.contentType());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Adds one or more custom words to a custom language model.
   *
   * Adds one or more custom words to a custom language model. The service populates the words resource for a custom
   * model with out-of-vocabulary (OOV) words found in each corpus added to the model. You can use this method to add
   * additional words or to modify existing words in the words resource. You must use credentials for the instance of
   * the service that owns a model to add or modify custom words for the model. Adding or modifying custom words does
   * not affect the custom model until you train the model for the new data by using the `POST
   * /v1/customizations/{customization_id}/train` method. You add custom words by providing a `Words` object, which is
   * an array of `Word` objects, one per word. You must use the object's word parameter to identify the word that is to
   * be added. You can also provide one or both of the optional `sounds_like` and `display_as` fields for each word. *
   * The `sounds_like` field provides an array of one or more pronunciations for the word. Use the parameter to specify
   * how the word can be pronounced by users. Use the parameter for words that are difficult to pronounce, foreign
   * words, acronyms, and so on. For example, you might specify that the word `IEEE` can sound like `i triple e`. You
   * can specify a maximum of five sounds-like pronunciations for a word. For information about pronunciation rules, see
   * [Using the sounds_like
   * field](https://console.bluemix.net/docs/services/speech-to-text/language-resource.html#soundsLike). * The
   * `display_as` field provides a different way of spelling the word in a transcript. Use the parameter when you want
   * the word to appear different from its usual representation or from its spelling in corpora training data. For
   * example, you might indicate that the word `IBM(trademark)` is to be displayed as `IBM`. For more information, see
   * [Using the display_as
   * field](https://console.bluemix.net/docs/services/speech-to-text/language-resource.html#displayAs). If you add a
   * custom word that already exists in the words resource for the custom model, the new definition overwrites the
   * existing data for the word. If the service encounters an error with the input data, it returns a failure code and
   * does not add any of the words to the words resource. The call returns an HTTP 201 response code if the input data
   * is valid. It then asynchronously processes the words to add them to the model's words resource. The time that it
   * takes for the analysis to complete depends on the number of new words that you add but is generally faster than
   * adding a corpus or training a model. You can monitor the status of the request by using the `GET
   * /v1/customizations/{customization_id}` method to poll the model's status. Use a loop to check the status every 10
   * seconds. The method returns a `Customization` object that includes a `status` field. A status of `ready` means that
   * the words have been added to the custom model. The service cannot accept requests to add new corpora or words or to
   * train the model until the existing request completes. You can use the `GET
   * /v1/customizations/{customization_id}/words` or `GET /v1/customizations/{customization_id}/words/{word_name}`
   * method to review the words that you add. Words with an invalid `sounds_like` field include an `error` field that
   * describes the problem. You can use other words methods to correct errors, eliminate typos, and modify how words are
   * pronounced as needed.
   *
   * @param addWordsOptions the {@link AddWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWords(AddWordsOptions addWordsOptions) {
    Validator.notNull(addWordsOptions, "addWordsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/customizations/%s/words", addWordsOptions
        .customizationId()));
    builder.header("Content-Type", addWordsOptions.contentType());
    if (addWordsOptions.contentType().equalsIgnoreCase(AddWordsOptions.ContentType.APPLICATION_JSON)) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(addWordsOptions.customWords()).getAsJsonObject());
    } else {
      builder.bodyContent(addWordsOptions.body(), addWordsOptions.contentType());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes a custom word from a custom language model.
   *
   * Deletes a custom word from a custom language model. You can remove any word that you added to the custom model's
   * words resource via any means. However, if the word also exists in the service's base vocabulary, the service
   * removes only the custom pronunciation for the word; the word remains in the base vocabulary. Removing a custom word
   * does not affect the custom model until you train the model with the `POST
   * /v1/customizations/{customization_id}/train` method. You must use credentials for the instance of the service that
   * owns a model to delete its words.
   *
   * @param deleteWordOptions the {@link DeleteWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteWord(DeleteWordOptions deleteWordOptions) {
    Validator.notNull(deleteWordOptions, "deleteWordOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/customizations/%s/words/%s", deleteWordOptions
        .customizationId(), deleteWordOptions.wordName()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Lists a custom word from a custom language model.
   *
   * Lists information about a custom word from a custom language model. You must use credentials for the instance of
   * the service that owns a model to query information about its words.
   *
   * @param getWordOptions the {@link GetWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Word}
   */
  public ServiceCall<Word> getWord(GetWordOptions getWordOptions) {
    Validator.notNull(getWordOptions, "getWordOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/customizations/%s/words/%s", getWordOptions
        .customizationId(), getWordOptions.wordName()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Word.class));
  }

  /**
   * Lists all custom words from a custom language model.
   *
   * Lists information about custom words from a custom language model. You can list all words from the custom model's
   * words resource, only custom words that were added or modified by the user, or only out-of-vocabulary (OOV) words
   * that were extracted from corpora. You can also indicate the order in which the service is to return words; by
   * default, words are listed in ascending alphabetical order. You must use credentials for the instance of the service
   * that owns a model to query information about its words.
   *
   * @param listWordsOptions the {@link ListWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Words}
   */
  public ServiceCall<Words> listWords(ListWordsOptions listWordsOptions) {
    Validator.notNull(listWordsOptions, "listWordsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/customizations/%s/words", listWordsOptions
        .customizationId()));
    if (listWordsOptions.wordType() != null) {
      builder.query("word_type", listWordsOptions.wordType());
    }
    if (listWordsOptions.sort() != null) {
      builder.query("sort", listWordsOptions.sort());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Words.class));
  }

  /**
   * Creates a custom acoustic model.
   *
   * Creates a new custom acoustic model for a specified base model. The custom acoustic model can be used only with the
   * base model for which it is created. The model is owned by the instance of the service whose credentials are used to
   * create it.
   *
   * @param createAcousticModelOptions the {@link CreateAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AcousticModel}
   */
  public ServiceCall<AcousticModel> createAcousticModel(CreateAcousticModelOptions createAcousticModelOptions) {
    Validator.notNull(createAcousticModelOptions, "createAcousticModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/acoustic_customizations");
    builder.header("Content-Type", createAcousticModelOptions.contentType());
    if (createAcousticModelOptions.contentType().equalsIgnoreCase(
        CreateAcousticModelOptions.ContentType.APPLICATION_JSON)) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(createAcousticModelOptions.createAcousticModel())
          .getAsJsonObject());
    } else {
      builder.bodyContent(createAcousticModelOptions.body(), createAcousticModelOptions.contentType());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AcousticModel.class));
  }

  /**
   * Deletes a custom acoustic model.
   *
   * Deletes an existing custom acoustic model. The custom model cannot be deleted if another request, such as adding an
   * audio resource to the model, is currently being processed. You must use credentials for the instance of the service
   * that owns a model to delete it.
   *
   * @param deleteAcousticModelOptions the {@link DeleteAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteAcousticModel(DeleteAcousticModelOptions deleteAcousticModelOptions) {
    Validator.notNull(deleteAcousticModelOptions, "deleteAcousticModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/acoustic_customizations/%s",
        deleteAcousticModelOptions.customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Lists information about a custom acoustic model.
   *
   * Lists information about a specified custom acoustic model. You must use credentials for the instance of the service
   * that owns a model to list information about it.
   *
   * @param getAcousticModelOptions the {@link GetAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AcousticModel}
   */
  public ServiceCall<AcousticModel> getAcousticModel(GetAcousticModelOptions getAcousticModelOptions) {
    Validator.notNull(getAcousticModelOptions, "getAcousticModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/acoustic_customizations/%s", getAcousticModelOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AcousticModel.class));
  }

  /**
   * Lists information about all custom acoustic models.
   *
   * Lists information about all custom acoustic models that are owned by an instance of the service. Use the `language`
   * parameter to see all custom acoustic models for the specified language; omit the parameter to see all custom
   * acoustic models for all languages. You must use credentials for the instance of the service that owns a model to
   * list information about it.
   *
   * @param listAcousticModelsOptions the {@link ListAcousticModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AcousticModels}
   */
  public ServiceCall<AcousticModels> listAcousticModels(ListAcousticModelsOptions listAcousticModelsOptions) {
    RequestBuilder builder = RequestBuilder.get("/v1/acoustic_customizations");
    if (listAcousticModelsOptions != null) {
      if (listAcousticModelsOptions.language() != null) {
        builder.query("language", listAcousticModelsOptions.language());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AcousticModels.class));
  }

  /**
   * Lists information about all custom acoustic models.
   *
   * Lists information about all custom acoustic models that are owned by an instance of the service. Use the `language`
   * parameter to see all custom acoustic models for the specified language; omit the parameter to see all custom
   * acoustic models for all languages. You must use credentials for the instance of the service that owns a model to
   * list information about it.
   *
   * @return a {@link ServiceCall} with a response type of {@link AcousticModels}
   */
  public ServiceCall<AcousticModels> listAcousticModels() {
    return listAcousticModels(null);
  }

  /**
   * Resets a custom acoustic model.
   *
   * Resets a custom acoustic model by removing all audio resources from the model. Resetting a custom acoustic model
   * initializes the model to its state when it was first created. Metadata such as the name and language of the model
   * are preserved, but the model's audio resources are removed and must be re-created. You must use credentials for the
   * instance of the service that owns a model to reset it.
   *
   * @param resetAcousticModelOptions the {@link ResetAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> resetAcousticModel(ResetAcousticModelOptions resetAcousticModelOptions) {
    Validator.notNull(resetAcousticModelOptions, "resetAcousticModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/acoustic_customizations/%s/reset",
        resetAcousticModelOptions.customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Trains a custom acoustic model.
   *
   * Initiates the training of a custom acoustic model with new or changed audio resources. After adding or deleting
   * audio resources for a custom acoustic model, use this method to begin the actual training of the model on the
   * latest audio data. The custom acoustic model does not reflect its changed data until you train it. You must use
   * credentials for the instance of the service that owns a model to train it. The training method is asynchronous. It
   * can take on the order of minutes or hours to complete depending on the total amount of audio data on which the
   * model is being trained and the current load on the service. Typically, training takes approximately twice the
   * length of the total audio contained in the custom model. The method returns an HTTP 200 response code to indicate
   * that the training process has begun. You can monitor the status of the training by using the `GET
   * /v1/acoustic_customizations/{customization_id}` method to poll the model's status. Use a loop to check the status
   * once a minute. The method returns an `Customization` object that includes `status` and `progress` fields. A status
   * of `available` indicates that the custom model is trained and ready to use. The service cannot accept subsequent
   * training requests, or requests to add new audio resources, until the existing request completes. You can use the
   * optional `custom_language_model_id` query parameter to specify the GUID of a separately created custom language
   * model that is to be used during training. Specify a custom language model if you have verbatim transcriptions of
   * the audio files that you have added to the custom model or you have either corpora (text files) or a list of words
   * that are relevant to the contents of the audio files. For information about creating a separate custom language
   * model, see [Creating a custom language
   * model](https://console.bluemix.net/docs/services/speech-to-text/language-create.html). Training can fail to start
   * for the following reasons: * The service is currently handling another request for the custom model, such as
   * another training request or a request to add audio resources to the model. * The custom model contains less than 10
   * minutes or more than 50 hours of audio data. * One or more of the custom model's audio resources is invalid.
   *
   * @param trainAcousticModelOptions the {@link TrainAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> trainAcousticModel(TrainAcousticModelOptions trainAcousticModelOptions) {
    Validator.notNull(trainAcousticModelOptions, "trainAcousticModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/acoustic_customizations/%s/train",
        trainAcousticModelOptions.customizationId()));
    if (trainAcousticModelOptions.customLanguageModelId() != null) {
      builder.query("custom_language_model_id", trainAcousticModelOptions.customLanguageModelId());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Upgrades a custom acoustic model.
   *
   * Initiates the upgrade of a custom acoustic model to the latest version of its base language model. The upgrade
   * method is asynchronous. It can take on the order of minutes or hours to complete depending on the amount of data in
   * the custom model and the current load on the service; typically, upgrade takes approximately twice the length of
   * the total audio contained in the custom model. A custom model must be in the `ready` or `available` state to be
   * upgraded. You must use credentials for the instance of the service that owns a model to upgrade it. The method
   * returns an HTTP 200 response code to indicate that the upgrade process has begun successfully. You can monitor the
   * status of the upgrade by using the `GET /v1/acoustic_customizations/{customization_id}` method to poll the model's
   * status. Use a loop to check the status once a minute. While it is being upgraded, the custom model has the status
   * `upgrading`. When the upgrade is complete, the model resumes the status that it had prior to upgrade. The service
   * cannot accept subsequent requests for the model until the upgrade completes. If the custom acoustic model was
   * trained with a separately created custom language model, you must use the `custom_language_model_id` query
   * parameter to specify the GUID of that custom language model. The custom language model must be upgraded before the
   * custom acoustic model can be upgraded. Omit the parameter if the custom acoustic model was not trained with a
   * custom language model. For more information, see [Upgrading custom
   * models](https://console.bluemix.net/docs/services/speech-to-text/custom-upgrade.html).
   *
   * @param upgradeAcousticModelOptions the {@link UpgradeAcousticModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> upgradeAcousticModel(UpgradeAcousticModelOptions upgradeAcousticModelOptions) {
    Validator.notNull(upgradeAcousticModelOptions, "upgradeAcousticModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/acoustic_customizations/%s/upgrade_model",
        upgradeAcousticModelOptions.customizationId()));
    if (upgradeAcousticModelOptions.customLanguageModelId() != null) {
      builder.query("custom_language_model_id", upgradeAcousticModelOptions.customLanguageModelId());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Adds an audio resource to a custom acoustic model.
   *
   * Adds an audio resource to a custom acoustic model. Add audio content that reflects the acoustic characteristics of
   * the audio that you plan to transcribe. You must use credentials for the instance of the service that owns a model
   * to add an audio resource to it. Adding audio data does not affect the custom acoustic model until you train the
   * model for the new data by using the `POST /v1/acoustic_customizations/{customization_id}/train` method. You can add
   * individual audio files or an archive file that contains multiple audio files. Adding multiple audio files via a
   * single archive file is significantly more efficient than adding each file individually. * You can add an individual
   * audio file in any format that the service supports for speech recognition. Use the `Content-Type` header to specify
   * the format of the audio file. * You can add an archive file (**.zip** or **.tar.gz** file) that contains audio
   * files in any format that the service supports for speech recognition. All audio files added with the same archive
   * file must have the same audio format. Use the `Content-Type` header to specify the archive type, `application/zip`
   * or `application/gzip`. Use the `Contained-Content-Type` header to specify the format of the contained audio files;
   * the default format is `audio/wav`. You can use this method to add any number of audio resources to a custom model
   * by calling the method once for each audio or archive file. But the addition of one audio resource must be fully
   * complete before you can add another. You must add a minimum of 10 minutes and a maximum of 50 hours of audio that
   * includes speech, not just silence, to a custom acoustic model before you can train it. No audio resource, audio- or
   * archive-type, can be larger than 100 MB. The method is asynchronous. It can take several seconds to complete
   * depending on the duration of the audio and, in the case of an archive file, the total number of audio files being
   * processed. The service returns a 201 response code if the audio is valid. It then asynchronously analyzes the
   * contents of the audio file or files and automatically extracts information about the audio such as its length,
   * sampling rate, and encoding. You cannot submit requests to add additional audio resources to a custom acoustic
   * model, or to train the model, until the service's analysis of all audio files for the current request completes. To
   * determine the status of the service's analysis of the audio, use the `GET
   * /v1/acoustic_customizations/{customization_id}/audio/{audio_name}` method to poll the status of the audio. The
   * method accepts the GUID of the custom model and the name of the audio resource, and it returns the status of the
   * resource. Use a loop to check the status of the audio every few seconds until it becomes `ok`. **Note:** The
   * sampling rate of an audio file must match the sampling rate of the base model for the custom model: for broadband
   * models, at least 16 kHz; for narrowband models, at least 8 kHz. If the sampling rate of the audio is higher than
   * the minimum required rate, the service down-samples the audio to the appropriate rate. If the sampling rate of the
   * audio is lower than the minimum required rate, the service labels the audio file as `invalid`.
   *
   * @param addAudioOptions the {@link AddAudioOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addAudio(AddAudioOptions addAudioOptions) {
    Validator.notNull(addAudioOptions, "addAudioOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/acoustic_customizations/%s/audio/%s",
        addAudioOptions.customizationId(), addAudioOptions.audioName()));
    if (addAudioOptions.containedContentType() != null) {
      builder.header("Contained-Content-Type", addAudioOptions.containedContentType());
    }
    builder.header("Content-Type", addAudioOptions.contentType());
    if (addAudioOptions.allowOverwrite() != null) {
      builder.query("allow_overwrite", String.valueOf(addAudioOptions.allowOverwrite()));
    }
    builder.body(RequestBody.create(MediaType.parse(addAudioOptions.contentType()), addAudioOptions.audioResource()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes an audio resource from a custom acoustic model.
   *
   * Deletes an existing audio resource from a custom acoustic model. Deleting an archive-type audio resource removes
   * the entire archive of files; the current interface does not allow deletion of individual files from an archive
   * resource. Removing an audio resource does not affect the custom model until you train the model on its updated data
   * by using the `POST /v1/acoustic_customizations/{customization_id}/train` method. You must use credentials for the
   * instance of the service that owns a model to delete its audio resources.
   *
   * @param deleteAudioOptions the {@link DeleteAudioOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteAudio(DeleteAudioOptions deleteAudioOptions) {
    Validator.notNull(deleteAudioOptions, "deleteAudioOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/acoustic_customizations/%s/audio/%s",
        deleteAudioOptions.customizationId(), deleteAudioOptions.audioName()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Lists information about an audio resource for a custom acoustic model.
   *
   * Lists information about an audio resource from a custom acoustic model. The method returns an `AudioListing` object
   * whose fields depend on the type of audio resource you specify with the method's `audio_name` parameter: * **For an
   * audio-type resource,** the object's fields match those of an `AudioResource` object: `duration`, `name`, `details`,
   * and `status`. * **For an archive-type resource,** the object includes a `container` field whose fields match those
   * of an `AudioResource` object. It also includes an `audio` field, which contains an array of `AudioResource` objects
   * that provides information about the audio files that are contained in the archive. The information includes the
   * status of the specified audio resource, which is important for checking the service's analysis of the resource in
   * response to a request to add it to the custom model. You must use credentials for the instance of the service that
   * owns a model to list its audio resources.
   *
   * @param getAudioOptions the {@link GetAudioOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AudioListing}
   */
  public ServiceCall<AudioListing> getAudio(GetAudioOptions getAudioOptions) {
    Validator.notNull(getAudioOptions, "getAudioOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/acoustic_customizations/%s/audio/%s", getAudioOptions
        .customizationId(), getAudioOptions.audioName()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AudioListing.class));
  }

  /**
   * Lists information about all audio resources for a custom acoustic model.
   *
   * Lists information about all audio resources from a custom acoustic model. The information includes the name of the
   * resource and information about its audio data, such as its duration. It also includes the status of the audio
   * resource, which is important for checking the service's analysis of the resource in response to a request to add it
   * to the custom acoustic model. You must use credentials for the instance of the service that owns a model to list
   * its audio resources.
   *
   * @param listAudioOptions the {@link ListAudioOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AudioResources}
   */
  public ServiceCall<AudioResources> listAudio(ListAudioOptions listAudioOptions) {
    Validator.notNull(listAudioOptions, "listAudioOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/acoustic_customizations/%s/audio", listAudioOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AudioResources.class));
  }

}

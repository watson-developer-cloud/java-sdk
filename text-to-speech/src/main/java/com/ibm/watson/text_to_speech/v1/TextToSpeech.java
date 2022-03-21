/*
 * (C) Copyright IBM Corp. 2019, 2022.
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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.46.0-a4e29da0-20220224-210428
 */

package com.ibm.watson.text_to_speech.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.text_to_speech.v1.model.AddCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.CustomModel;
import com.ibm.watson.text_to_speech.v1.model.CustomModels;
import com.ibm.watson.text_to_speech.v1.model.DeleteCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteUserDataOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.text_to_speech.v1.model.GetCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.GetCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.GetPronunciationOptions;
import com.ibm.watson.text_to_speech.v1.model.GetSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.text_to_speech.v1.model.ListCustomModelsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListCustomPromptsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListSpeakerModelsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListVoicesOptions;
import com.ibm.watson.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.Prompt;
import com.ibm.watson.text_to_speech.v1.model.Prompts;
import com.ibm.watson.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.text_to_speech.v1.model.SpeakerCustomModels;
import com.ibm.watson.text_to_speech.v1.model.SpeakerModel;
import com.ibm.watson.text_to_speech.v1.model.Speakers;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Translation;
import com.ibm.watson.text_to_speech.v1.model.UpdateCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.model.Voices;
import com.ibm.watson.text_to_speech.v1.model.Words;
import com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback;
import com.ibm.watson.text_to_speech.v1.websocket.TextToSpeechWebSocketListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/**
 * The IBM Watson&amp;trade; Text to Speech service provides APIs that use IBM's speech-synthesis
 * capabilities to synthesize text into natural-sounding speech in a variety of languages, dialects,
 * and voices. The service supports at least one male or female voice, sometimes both, for each
 * language. The audio is streamed back to the client with minimal delay.
 *
 * <p>For speech synthesis, the service supports a synchronous HTTP Representational State Transfer
 * (REST) interface and a WebSocket interface. Both interfaces support plain text and SSML input.
 * SSML is an XML-based markup language that provides text annotation for speech-synthesis
 * applications. The WebSocket interface also supports the SSML
 * &lt;code&gt;&amp;lt;mark&amp;gt;&lt;/code&gt; element and word timings.
 *
 * <p>The service offers a customization interface that you can use to define sounds-like or
 * phonetic translations for words. A sounds-like translation consists of one or more words that,
 * when combined, sound like the word. A phonetic translation is based on the SSML phoneme format
 * for representing a word. You can specify a phonetic translation in standard International
 * Phonetic Alphabet (IPA) representation or in the proprietary IBM Symbolic Phonetic Representation
 * (SPR). For phonetic translation, the Arabic, Chinese, Dutch, Australian English, Korean, and
 * Swedish voices support only IPA, not SPR.
 *
 * <p>The service also offers a Tune by Example feature that lets you define custom prompts. You can
 * also define speaker models to improve the quality of your custom prompts. The service support
 * custom prompts only for US English custom models and voices.
 *
 * <p>API Version: 1.0.0 See: https://cloud.ibm.com/docs/text-to-speech
 */
public class TextToSpeech extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "text_to_speech";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.text-to-speech.watson.cloud.ibm.com";

  /**
   * Constructs an instance of the `TextToSpeech` client. The default service name is used to
   * configure the client instance.
   */
  public TextToSpeech() {
    this(
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `TextToSpeech` client. The default service name and specified
   * authenticator are used to configure the client instance.
   *
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public TextToSpeech(Authenticator authenticator) {
    this(DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `TextToSpeech` client. The specified service name is used to
   * configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   */
  public TextToSpeech(String serviceName) {
    this(serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `TextToSpeech` client. The specified service name and
   * authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public TextToSpeech(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    this.configureService(serviceName);
  }

  /**
   * List voices.
   *
   * <p>Lists all voices available for use with the service. The information includes the name,
   * language, gender, and other details about the voice. The ordering of the list of voices can
   * change from call to call; do not rely on an alphabetized or static list of voices. To see
   * information about a specific voice, use the [Get a voice](#getvoice).
   *
   * <p>**See also:** [Listing all available
   * voices](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices#listVoices).
   *
   * @param listVoicesOptions the {@link ListVoicesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Voices}
   */
  public ServiceCall<Voices> listVoices(ListVoicesOptions listVoicesOptions) {
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/voices"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "listVoices");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Voices> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Voices>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List voices.
   *
   * <p>Lists all voices available for use with the service. The information includes the name,
   * language, gender, and other details about the voice. The ordering of the list of voices can
   * change from call to call; do not rely on an alphabetized or static list of voices. To see
   * information about a specific voice, use the [Get a voice](#getvoice).
   *
   * <p>**See also:** [Listing all available
   * voices](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices#listVoices).
   *
   * @return a {@link ServiceCall} with a result of type {@link Voices}
   */
  public ServiceCall<Voices> listVoices() {
    return listVoices(null);
  }

  /**
   * Get a voice.
   *
   * <p>Gets information about the specified voice. The information includes the name, language,
   * gender, and other details about the voice. Specify a customization ID to obtain information for
   * a custom model that is defined for the language of the specified voice. To list information
   * about all available voices, use the [List voices](#listvoices) method.
   *
   * <p>**See also:** [Listing a specific
   * voice](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices#listVoice).
   *
   * <p>**Note:** The Arabic, Chinese, Czech, Dutch (Belgian and Netherlands), Australian English,
   * Korean, and Swedish languages and voices are supported only for IBM Cloud; they are deprecated
   * for IBM Cloud Pak for Data. Also, the `ar-AR_OmarVoice` voice is deprecated; use the
   * `ar-MS_OmarVoice` voice instead.
   *
   * @param getVoiceOptions the {@link GetVoiceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Voice}
   */
  public ServiceCall<Voice> getVoice(GetVoiceOptions getVoiceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getVoiceOptions, "getVoiceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("voice", getVoiceOptions.voice());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/voices/{voice}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "getVoice");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getVoiceOptions.customizationId() != null) {
      builder.query("customization_id", String.valueOf(getVoiceOptions.customizationId()));
    }
    ResponseConverter<Voice> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Voice>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Synthesize audio.
   *
   * <p>Synthesizes text to audio that is spoken in the specified voice. The service bases its
   * understanding of the language for the input text on the specified voice. Use a voice that
   * matches the language of the input text.
   *
   * <p>The method accepts a maximum of 5 KB of input text in the body of the request, and 8 KB for
   * the URL and headers. The 5 KB limit includes any SSML tags that you specify. The service
   * returns the synthesized audio stream as an array of bytes.
   *
   * <p>**See also:** [The HTTP
   * interface](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-usingHTTP#usingHTTP).
   *
   * <p>**Note:** The Arabic, Chinese, Czech, Dutch (Belgian and Netherlands), Australian English,
   * Korean, and Swedish languages and voices are supported only for IBM Cloud; they are deprecated
   * for IBM Cloud Pak for Data. Also, the `ar-AR_OmarVoice` voice is deprecated; use the
   * `ar-MS_OmarVoice` voice instead.
   *
   * <p>### Audio formats (accept types)
   *
   * <p>The service can return audio in the following formats (MIME types). * Where indicated, you
   * can optionally specify the sampling rate (`rate`) of the audio. You must specify a sampling
   * rate for the `audio/l16` and `audio/mulaw` formats. A specified sampling rate must lie in the
   * range of 8 kHz to 192 kHz. Some formats restrict the sampling rate to certain values, as noted.
   * * For the `audio/l16` format, you can optionally specify the endianness (`endianness`) of the
   * audio: `endianness=big-endian` or `endianness=little-endian`.
   *
   * <p>Use the `Accept` header or the `accept` parameter to specify the requested format of the
   * response audio. If you omit an audio format altogether, the service returns the audio in Ogg
   * format with the Opus codec (`audio/ogg;codecs=opus`). The service always returns single-channel
   * audio. * `audio/basic` - The service returns audio with a sampling rate of 8000 Hz. *
   * `audio/flac` - You can optionally specify the `rate` of the audio. The default sampling rate is
   * 22,050 Hz. * `audio/l16` - You must specify the `rate` of the audio. You can optionally specify
   * the `endianness` of the audio. The default endianness is `little-endian`. * `audio/mp3` - You
   * can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz. *
   * `audio/mpeg` - You can optionally specify the `rate` of the audio. The default sampling rate is
   * 22,050 Hz. * `audio/mulaw` - You must specify the `rate` of the audio. * `audio/ogg` - The
   * service returns the audio in the `vorbis` codec. You can optionally specify the `rate` of the
   * audio. The default sampling rate is 22,050 Hz. * `audio/ogg;codecs=opus` - You can optionally
   * specify the `rate` of the audio. Only the following values are valid sampling rates: `48000`,
   * `24000`, `16000`, `12000`, or `8000`. If you specify a value other than one of these, the
   * service returns an error. The default sampling rate is 48,000 Hz. * `audio/ogg;codecs=vorbis` -
   * You can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz. *
   * `audio/wav` - You can optionally specify the `rate` of the audio. The default sampling rate is
   * 22,050 Hz. * `audio/webm` - The service returns the audio in the `opus` codec. The service
   * returns audio with a sampling rate of 48,000 Hz. * `audio/webm;codecs=opus` - The service
   * returns audio with a sampling rate of 48,000 Hz. * `audio/webm;codecs=vorbis` - You can
   * optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz.
   *
   * <p>For more information about specifying an audio format, including additional details about
   * some of the formats, see [Using audio
   * formats](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-audio-formats).
   *
   * <p>### Warning messages
   *
   * <p>If a request includes invalid query parameters, the service returns a `Warnings` response
   * header that provides messages about the invalid parameters. The warning includes a descriptive
   * message and a list of invalid argument strings. For example, a message such as `"Unknown
   * arguments:"` or `"Unknown url query arguments:"` followed by a list of the form
   * `"{invalid_arg_1}, {invalid_arg_2}."` The request succeeds despite the warnings.
   *
   * @param synthesizeOptions the {@link SynthesizeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> synthesize(SynthesizeOptions synthesizeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        synthesizeOptions, "synthesizeOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/synthesize"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "synthesize");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (synthesizeOptions.accept() != null) {
      builder.header("Accept", synthesizeOptions.accept());
    }
    if (synthesizeOptions.voice() != null) {
      builder.query("voice", String.valueOf(synthesizeOptions.voice()));
    }
    if (synthesizeOptions.customizationId() != null) {
      builder.query("customization_id", String.valueOf(synthesizeOptions.customizationId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", synthesizeOptions.text());
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Synthesize audio.
   *
   * <p>Synthesizes text to audio that is spoken in the specified voice. The service bases its
   * understanding of the language for the input text on the specified voice. Use a voice that
   * matches the language of the input text.
   *
   * <p>The method accepts a maximum of 5 KB of input text in the body of the request, and 8 KB for
   * the URL and headers. The 5 KB limit includes any SSML tags that you specify. The service
   * returns the synthesized audio stream as an array of bytes.
   *
   * <p>### Audio formats (accept types)
   *
   * <p>For more information about specifying an audio format, including additional details about
   * some of the formats, see [Audio
   * formats](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-audioFormats#audioFormats).
   *
   * @param synthesizeOptions the {@link SynthesizeOptions} containing the options for the call
   * @param callback the {@link SynthesizeCallback} callback
   * @return a {@link WebSocket} instance
   */
  public WebSocket synthesizeUsingWebSocket(
      SynthesizeOptions synthesizeOptions, SynthesizeCallback callback) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        synthesizeOptions, "synthesizeOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(callback, "callback cannot be null");

    HttpUrl.Builder urlBuilder = HttpUrl.parse(getServiceUrl() + "/v1/synthesize").newBuilder();

    if (synthesizeOptions.voice() != null) {
      urlBuilder.addQueryParameter("voice", synthesizeOptions.voice());
    }
    if (synthesizeOptions.customizationId() != null) {
      urlBuilder.addQueryParameter("customization_id", synthesizeOptions.customizationId());
    }

    String url = urlBuilder.toString().replace("https://", "wss://");
    Request.Builder builder = new Request.Builder().url(url);

    setAuthentication(builder);
    setDefaultHeaders(builder);

    OkHttpClient client = configureHttpClient();
    return client.newWebSocket(
        builder.build(), new TextToSpeechWebSocketListener(synthesizeOptions, callback));
  }

  /**
   * Get pronunciation.
   *
   * <p>Gets the phonetic pronunciation for the specified word. You can request the pronunciation
   * for a specific format. You can also request the pronunciation for a specific voice to see the
   * default translation for the language of that voice or for a specific custom model to see the
   * translation for that model.
   *
   * <p>**See also:** [Querying a word from a
   * language](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordsQueryLanguage).
   *
   * <p>**Note:** The Arabic, Chinese, Czech, Dutch (Belgian and Netherlands), Australian English,
   * Korean, and Swedish languages and voices are supported only for IBM Cloud; they are deprecated
   * for IBM Cloud Pak for Data. Also, the `ar-AR_OmarVoice` voice is deprecated; use the
   * `ar-MS_OmarVoice` voice instead.
   *
   * @param getPronunciationOptions the {@link GetPronunciationOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Pronunciation}
   */
  public ServiceCall<Pronunciation> getPronunciation(
      GetPronunciationOptions getPronunciationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getPronunciationOptions, "getPronunciationOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/pronunciation"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "getPronunciation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("text", String.valueOf(getPronunciationOptions.text()));
    if (getPronunciationOptions.voice() != null) {
      builder.query("voice", String.valueOf(getPronunciationOptions.voice()));
    }
    if (getPronunciationOptions.format() != null) {
      builder.query("format", String.valueOf(getPronunciationOptions.format()));
    }
    if (getPronunciationOptions.customizationId() != null) {
      builder.query("customization_id", String.valueOf(getPronunciationOptions.customizationId()));
    }
    ResponseConverter<Pronunciation> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Pronunciation>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom model.
   *
   * <p>Creates a new empty custom model. You must specify a name for the new custom model. You can
   * optionally specify the language and a description for the new model. The model is owned by the
   * instance of the service whose credentials are used to create it.
   *
   * <p>**See also:** [Creating a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsCreate).
   *
   * <p>**Note:** The Arabic, Chinese, Czech, Dutch (Belgian and Netherlands), Australian English,
   * Korean, and Swedish languages and voices are supported only for IBM Cloud; they are deprecated
   * for IBM Cloud Pak for Data. Also, the `ar-AR` language identifier cannot be used to create a
   * custom model; use the `ar-MS` identifier instead.
   *
   * @param createCustomModelOptions the {@link CreateCustomModelOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link CustomModel}
   */
  public ServiceCall<CustomModel> createCustomModel(
      CreateCustomModelOptions createCustomModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createCustomModelOptions, "createCustomModelOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/customizations"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "createCustomModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createCustomModelOptions.name());
    if (createCustomModelOptions.language() != null) {
      contentJson.addProperty("language", createCustomModelOptions.language());
    }
    if (createCustomModelOptions.description() != null) {
      contentJson.addProperty("description", createCustomModelOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CustomModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CustomModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom models.
   *
   * <p>Lists metadata such as the name and description for all custom models that are owned by an
   * instance of the service. Specify a language to list the custom models for that language only.
   * To see the words and prompts in addition to the metadata for a specific custom model, use the
   * [Get a custom model](#getcustommodel) method. You must use credentials for the instance of the
   * service that owns a model to list information about it.
   *
   * <p>**See also:** [Querying all custom
   * models](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsQueryAll).
   *
   * @param listCustomModelsOptions the {@link ListCustomModelsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link CustomModels}
   */
  public ServiceCall<CustomModels> listCustomModels(
      ListCustomModelsOptions listCustomModelsOptions) {
    if (listCustomModelsOptions == null) {
      listCustomModelsOptions = new ListCustomModelsOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/customizations"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "listCustomModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listCustomModelsOptions.language() != null) {
      builder.query("language", String.valueOf(listCustomModelsOptions.language()));
    }
    ResponseConverter<CustomModels> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CustomModels>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom models.
   *
   * <p>Lists metadata such as the name and description for all custom models that are owned by an
   * instance of the service. Specify a language to list the custom models for that language only.
   * To see the words and prompts in addition to the metadata for a specific custom model, use the
   * [Get a custom model](#getcustommodel) method. You must use credentials for the instance of the
   * service that owns a model to list information about it.
   *
   * <p>**See also:** [Querying all custom
   * models](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsQueryAll).
   *
   * @return a {@link ServiceCall} with a result of type {@link CustomModels}
   */
  public ServiceCall<CustomModels> listCustomModels() {
    return listCustomModels(null);
  }

  /**
   * Update a custom model.
   *
   * <p>Updates information for the specified custom model. You can update metadata such as the name
   * and description of the model. You can also update the words in the model and their
   * translations. Adding a new translation for a word that already exists in a custom model
   * overwrites the word's existing translation. A custom model can contain no more than 20,000
   * entries. You must use credentials for the instance of the service that owns a model to update
   * it.
   *
   * <p>You can define sounds-like or phonetic translations for words. A sounds-like translation
   * consists of one or more words that, when combined, sound like the word. Phonetic translations
   * are based on the SSML phoneme format for representing a word. You can specify them in standard
   * International Phonetic Alphabet (IPA) representation
   *
   * <p>&lt;code&gt;&amp;lt;phoneme alphabet="ipa"
   * ph="t&amp;#601;m&amp;#712;&amp;#593;to"&amp;gt;&amp;lt;/phoneme&amp;gt;&lt;/code&gt;
   *
   * <p>or in the proprietary IBM Symbolic Phonetic Representation (SPR)
   *
   * <p>&lt;code&gt;&amp;lt;phoneme alphabet="ibm"
   * ph="1gAstroEntxrYFXs"&amp;gt;&amp;lt;/phoneme&amp;gt;&lt;/code&gt;
   *
   * <p>**See also:** * [Updating a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsUpdate)
   * * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customIntro#customIntro).
   *
   * @param updateCustomModelOptions the {@link UpdateCustomModelOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateCustomModel(UpdateCustomModelOptions updateCustomModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateCustomModelOptions, "updateCustomModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", updateCustomModelOptions.customizationId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/customizations/{customization_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "updateCustomModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateCustomModelOptions.name() != null) {
      contentJson.addProperty("name", updateCustomModelOptions.name());
    }
    if (updateCustomModelOptions.description() != null) {
      contentJson.addProperty("description", updateCustomModelOptions.description());
    }
    if (updateCustomModelOptions.words() != null) {
      contentJson.add(
          "words",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateCustomModelOptions.words()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a custom model.
   *
   * <p>Gets all information about a specified custom model. In addition to metadata such as the
   * name and description of the custom model, the output includes the words and their translations
   * that are defined for the model, as well as any prompts that are defined for the model. To see
   * just the metadata for a model, use the [List custom models](#listcustommodels) method.
   *
   * <p>**See also:** [Querying a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsQuery).
   *
   * @param getCustomModelOptions the {@link GetCustomModelOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link CustomModel}
   */
  public ServiceCall<CustomModel> getCustomModel(GetCustomModelOptions getCustomModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCustomModelOptions, "getCustomModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", getCustomModelOptions.customizationId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/customizations/{customization_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "getCustomModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CustomModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CustomModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom model.
   *
   * <p>Deletes the specified custom model. You must use credentials for the instance of the service
   * that owns a model to delete it.
   *
   * <p>**See also:** [Deleting a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsDelete).
   *
   * @param deleteCustomModelOptions the {@link DeleteCustomModelOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteCustomModel(DeleteCustomModelOptions deleteCustomModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCustomModelOptions, "deleteCustomModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", deleteCustomModelOptions.customizationId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/customizations/{customization_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteCustomModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add custom words.
   *
   * <p>Adds one or more words and their translations to the specified custom model. Adding a new
   * translation for a word that already exists in a custom model overwrites the word's existing
   * translation. A custom model can contain no more than 20,000 entries. You must use credentials
   * for the instance of the service that owns a model to add words to it.
   *
   * <p>You can define sounds-like or phonetic translations for words. A sounds-like translation
   * consists of one or more words that, when combined, sound like the word. Phonetic translations
   * are based on the SSML phoneme format for representing a word. You can specify them in standard
   * International Phonetic Alphabet (IPA) representation
   *
   * <p>&lt;code&gt;&amp;lt;phoneme alphabet="ipa"
   * ph="t&amp;#601;m&amp;#712;&amp;#593;to"&amp;gt;&amp;lt;/phoneme&amp;gt;&lt;/code&gt;
   *
   * <p>or in the proprietary IBM Symbolic Phonetic Representation (SPR)
   *
   * <p>&lt;code&gt;&amp;lt;phoneme alphabet="ibm"
   * ph="1gAstroEntxrYFXs"&amp;gt;&amp;lt;/phoneme&amp;gt;&lt;/code&gt;
   *
   * <p>**See also:** * [Adding multiple words to a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordsAdd) *
   * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customIntro#customIntro).
   *
   * @param addWordsOptions the {@link AddWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> addWords(AddWordsOptions addWordsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addWordsOptions, "addWordsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", addWordsOptions.customizationId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/customizations/{customization_id}/words", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "addWords");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add(
        "words",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addWordsOptions.words()));
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom words.
   *
   * <p>Lists all of the words and their translations for the specified custom model. The output
   * shows the translations as they are defined in the model. You must use credentials for the
   * instance of the service that owns a model to list its words.
   *
   * <p>**See also:** [Querying all words from a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordsQueryModel).
   *
   * @param listWordsOptions the {@link ListWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Words}
   */
  public ServiceCall<Words> listWords(ListWordsOptions listWordsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listWordsOptions, "listWordsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", listWordsOptions.customizationId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/customizations/{customization_id}/words", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "listWords");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Words> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Words>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a custom word.
   *
   * <p>Adds a single word and its translation to the specified custom model. Adding a new
   * translation for a word that already exists in a custom model overwrites the word's existing
   * translation. A custom model can contain no more than 20,000 entries. You must use credentials
   * for the instance of the service that owns a model to add a word to it.
   *
   * <p>You can define sounds-like or phonetic translations for words. A sounds-like translation
   * consists of one or more words that, when combined, sound like the word. Phonetic translations
   * are based on the SSML phoneme format for representing a word. You can specify them in standard
   * International Phonetic Alphabet (IPA) representation
   *
   * <p>&lt;code&gt;&amp;lt;phoneme alphabet="ipa"
   * ph="t&amp;#601;m&amp;#712;&amp;#593;to"&amp;gt;&amp;lt;/phoneme&amp;gt;&lt;/code&gt;
   *
   * <p>or in the proprietary IBM Symbolic Phonetic Representation (SPR)
   *
   * <p>&lt;code&gt;&amp;lt;phoneme alphabet="ibm"
   * ph="1gAstroEntxrYFXs"&amp;gt;&amp;lt;/phoneme&amp;gt;&lt;/code&gt;
   *
   * <p>**See also:** * [Adding a single word to a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordAdd) *
   * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customIntro#customIntro).
   *
   * @param addWordOptions the {@link AddWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> addWord(AddWordOptions addWordOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addWordOptions, "addWordOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", addWordOptions.customizationId());
    pathParamsMap.put("word", addWordOptions.word());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/customizations/{customization_id}/words/{word}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "addWord");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("translation", addWordOptions.translation());
    if (addWordOptions.partOfSpeech() != null) {
      contentJson.addProperty("part_of_speech", addWordOptions.partOfSpeech());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a custom word.
   *
   * <p>Gets the translation for a single word from the specified custom model. The output shows the
   * translation as it is defined in the model. You must use credentials for the instance of the
   * service that owns a model to list its words.
   *
   * <p>**See also:** [Querying a single word from a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordQueryModel).
   *
   * @param getWordOptions the {@link GetWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Translation}
   */
  public ServiceCall<Translation> getWord(GetWordOptions getWordOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getWordOptions, "getWordOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", getWordOptions.customizationId());
    pathParamsMap.put("word", getWordOptions.word());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/customizations/{customization_id}/words/{word}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "getWord");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Translation> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Translation>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom word.
   *
   * <p>Deletes a single word from the specified custom model. You must use credentials for the
   * instance of the service that owns a model to delete its words.
   *
   * <p>**See also:** [Deleting a word from a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordDelete).
   *
   * @param deleteWordOptions the {@link DeleteWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteWord(DeleteWordOptions deleteWordOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteWordOptions, "deleteWordOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", deleteWordOptions.customizationId());
    pathParamsMap.put("word", deleteWordOptions.word());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/customizations/{customization_id}/words/{word}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteWord");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom prompts.
   *
   * <p>Lists information about all custom prompts that are defined for a custom model. The
   * information includes the prompt ID, prompt text, status, and optional speaker ID for each
   * prompt of the custom model. You must use credentials for the instance of the service that owns
   * the custom model. The same information about all of the prompts for a custom model is also
   * provided by the [Get a custom model](#getcustommodel) method. That method provides complete
   * details about a specified custom model, including its language, owner, custom words, and more.
   * Custom prompts are supported only for use with US English custom models and voices.
   *
   * <p>**See also:** [Listing custom
   * prompts](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-custom-prompts#tbe-custom-prompts-list).
   *
   * @param listCustomPromptsOptions the {@link ListCustomPromptsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Prompts}
   */
  public ServiceCall<Prompts> listCustomPrompts(ListCustomPromptsOptions listCustomPromptsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listCustomPromptsOptions, "listCustomPromptsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", listCustomPromptsOptions.customizationId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/customizations/{customization_id}/prompts", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "listCustomPrompts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Prompts> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Prompts>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a custom prompt.
   *
   * <p>Adds a custom prompt to a custom model. A prompt is defined by the text that is to be
   * spoken, the audio for that text, a unique user-specified ID for the prompt, and an optional
   * speaker ID. The information is used to generate prosodic data that is not visible to the user.
   * This data is used by the service to produce the synthesized audio upon request. You must use
   * credentials for the instance of the service that owns a custom model to add a prompt to it. You
   * can add a maximum of 1000 custom prompts to a single custom model.
   *
   * <p>You are recommended to assign meaningful values for prompt IDs. For example, use `goodbye`
   * to identify a prompt that speaks a farewell message. Prompt IDs must be unique within a given
   * custom model. You cannot define two prompts with the same name for the same custom model. If
   * you provide the ID of an existing prompt, the previously uploaded prompt is replaced by the new
   * information. The existing prompt is reprocessed by using the new text and audio and, if
   * provided, new speaker model, and the prosody data associated with the prompt is updated.
   *
   * <p>The quality of a prompt is undefined if the language of a prompt does not match the language
   * of its custom model. This is consistent with any text or SSML that is specified for a speech
   * synthesis request. The service makes a best-effort attempt to render the specified text for the
   * prompt; it does not validate that the language of the text matches the language of the model.
   *
   * <p>Adding a prompt is an asynchronous operation. Although it accepts less audio than speaker
   * enrollment, the service must align the audio with the provided text. The time that it takes to
   * process a prompt depends on the prompt itself. The processing time for a reasonably sized
   * prompt generally matches the length of the audio (for example, it takes 20 seconds to process a
   * 20-second prompt).
   *
   * <p>For shorter prompts, you can wait for a reasonable amount of time and then check the status
   * of the prompt with the [Get a custom prompt](#getcustomprompt) method. For longer prompts,
   * consider using that method to poll the service every few seconds to determine when the prompt
   * becomes available. No prompt can be used for speech synthesis if it is in the `processing` or
   * `failed` state. Only prompts that are in the `available` state can be used for speech
   * synthesis.
   *
   * <p>When it processes a request, the service attempts to align the text and the audio that are
   * provided for the prompt. The text that is passed with a prompt must match the spoken audio as
   * closely as possible. Optimally, the text and audio match exactly. The service does its best to
   * align the specified text with the audio, and it can often compensate for mismatches between the
   * two. But if the service cannot effectively align the text and the audio, possibly because the
   * magnitude of mismatches between the two is too great, processing of the prompt fails.
   *
   * <p>### Evaluating a prompt
   *
   * <p>Always listen to and evaluate a prompt to determine its quality before using it in
   * production. To evaluate a prompt, include only the single prompt in a speech synthesis request
   * by using the following SSML extension, in this case for a prompt whose ID is `goodbye`:
   *
   * <p>`&lt;ibm:prompt id="goodbye"/&gt;`
   *
   * <p>In some cases, you might need to rerecord and resubmit a prompt as many as five times to
   * address the following possible problems: * The service might fail to detect a mismatch between
   * the prompt’s text and audio. The longer the prompt, the greater the chance for misalignment
   * between its text and audio. Therefore, multiple shorter prompts are preferable to a single long
   * prompt. * The text of a prompt might include a word that the service does not recognize. In
   * this case, you can create a custom word and pronunciation pair to tell the service how to
   * pronounce the word. You must then re-create the prompt. * The quality of the input audio might
   * be insufficient or the service’s processing of the audio might fail to detect the intended
   * prosody. Submitting new audio for the prompt can correct these issues.
   *
   * <p>If a prompt that is created without a speaker ID does not adequately reflect the intended
   * prosody, enrolling the speaker and providing a speaker ID for the prompt is one recommended
   * means of potentially improving the quality of the prompt. This is especially important for
   * shorter prompts such as "good-bye" or "thank you," where less audio data makes it more
   * difficult to match the prosody of the speaker. Custom prompts are supported only for use with
   * US English custom models and voices.
   *
   * <p>**See also:** * [Add a custom
   * prompt](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-create#tbe-create-add-prompt)
   * * [Evaluate a custom
   * prompt](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-create#tbe-create-evaluate-prompt)
   * * [Rules for creating custom
   * prompts](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-rules#tbe-rules-prompts).
   *
   * @param addCustomPromptOptions the {@link AddCustomPromptOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Prompt}
   */
  public ServiceCall<Prompt> addCustomPrompt(AddCustomPromptOptions addCustomPromptOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addCustomPromptOptions, "addCustomPromptOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", addCustomPromptOptions.customizationId());
    pathParamsMap.put("prompt_id", addCustomPromptOptions.promptId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/customizations/{customization_id}/prompts/{prompt_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "addCustomPrompt");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("metadata", addCustomPromptOptions.metadata().toString());
    okhttp3.RequestBody fileBody =
        RequestUtils.inputStreamBody(addCustomPromptOptions.file(), "audio/wav");
    multipartBuilder.addFormDataPart("file", "filename", fileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<Prompt> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Prompt>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a custom prompt.
   *
   * <p>Gets information about a specified custom prompt for a specified custom model. The
   * information includes the prompt ID, prompt text, status, and optional speaker ID for each
   * prompt of the custom model. You must use credentials for the instance of the service that owns
   * the custom model. Custom prompts are supported only for use with US English custom models and
   * voices.
   *
   * <p>**See also:** [Listing custom
   * prompts](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-custom-prompts#tbe-custom-prompts-list).
   *
   * @param getCustomPromptOptions the {@link GetCustomPromptOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Prompt}
   */
  public ServiceCall<Prompt> getCustomPrompt(GetCustomPromptOptions getCustomPromptOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCustomPromptOptions, "getCustomPromptOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", getCustomPromptOptions.customizationId());
    pathParamsMap.put("prompt_id", getCustomPromptOptions.promptId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/customizations/{customization_id}/prompts/{prompt_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "getCustomPrompt");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Prompt> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Prompt>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom prompt.
   *
   * <p>Deletes an existing custom prompt from a custom model. The service deletes the prompt with
   * the specified ID. You must use credentials for the instance of the service that owns the custom
   * model from which the prompt is to be deleted.
   *
   * <p>**Caution:** Deleting a custom prompt elicits a 400 response code from synthesis requests
   * that attempt to use the prompt. Make sure that you do not attempt to use a deleted prompt in a
   * production application. Custom prompts are supported only for use with US English custom models
   * and voices.
   *
   * <p>**See also:** [Deleting a custom
   * prompt](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-custom-prompts#tbe-custom-prompts-delete).
   *
   * @param deleteCustomPromptOptions the {@link DeleteCustomPromptOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteCustomPrompt(DeleteCustomPromptOptions deleteCustomPromptOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCustomPromptOptions, "deleteCustomPromptOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("customization_id", deleteCustomPromptOptions.customizationId());
    pathParamsMap.put("prompt_id", deleteCustomPromptOptions.promptId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/customizations/{customization_id}/prompts/{prompt_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteCustomPrompt");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List speaker models.
   *
   * <p>Lists information about all speaker models that are defined for a service instance. The
   * information includes the speaker ID and speaker name of each defined speaker. You must use
   * credentials for the instance of a service to list its speakers. Speaker models and the custom
   * prompts with which they are used are supported only for use with US English custom models and
   * voices.
   *
   * <p>**See also:** [Listing speaker
   * models](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-speaker-models#tbe-speaker-models-list).
   *
   * @param listSpeakerModelsOptions the {@link ListSpeakerModelsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Speakers}
   */
  public ServiceCall<Speakers> listSpeakerModels(
      ListSpeakerModelsOptions listSpeakerModelsOptions) {
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/speakers"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "listSpeakerModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Speakers> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Speakers>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List speaker models.
   *
   * <p>Lists information about all speaker models that are defined for a service instance. The
   * information includes the speaker ID and speaker name of each defined speaker. You must use
   * credentials for the instance of a service to list its speakers. Speaker models and the custom
   * prompts with which they are used are supported only for use with US English custom models and
   * voices.
   *
   * <p>**See also:** [Listing speaker
   * models](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-speaker-models#tbe-speaker-models-list).
   *
   * @return a {@link ServiceCall} with a result of type {@link Speakers}
   */
  public ServiceCall<Speakers> listSpeakerModels() {
    return listSpeakerModels(null);
  }

  /**
   * Create a speaker model.
   *
   * <p>Creates a new speaker model, which is an optional enrollment token for users who are to add
   * prompts to custom models. A speaker model contains information about a user's voice. The
   * service extracts this information from a WAV audio sample that you pass as the body of the
   * request. Associating a speaker model with a prompt is optional, but the information that is
   * extracted from the speaker model helps the service learn about the speaker's voice.
   *
   * <p>A speaker model can make an appreciable difference in the quality of prompts, especially
   * short prompts with relatively little audio, that are associated with that speaker. A speaker
   * model can help the service produce a prompt with more confidence; the lack of a speaker model
   * can potentially compromise the quality of a prompt.
   *
   * <p>The gender of the speaker who creates a speaker model does not need to match the gender of a
   * voice that is used with prompts that are associated with that speaker model. For example, a
   * speaker model that is created by a male speaker can be associated with prompts that are spoken
   * by female voices.
   *
   * <p>You create a speaker model for a given instance of the service. The new speaker model is
   * owned by the service instance whose credentials are used to create it. That same speaker can
   * then be used to create prompts for all custom models within that service instance. No language
   * is associated with a speaker model, but each custom model has a single specified language. You
   * can add prompts only to US English models.
   *
   * <p>You specify a name for the speaker when you create it. The name must be unique among all
   * speaker names for the owning service instance. To re-create a speaker model for an existing
   * speaker name, you must first delete the existing speaker model that has that name.
   *
   * <p>Speaker enrollment is a synchronous operation. Although it accepts more audio data than a
   * prompt, the process of adding a speaker is very fast. The service simply extracts information
   * about the speaker’s voice from the audio. Unlike prompts, speaker models neither need nor
   * accept a transcription of the audio. When the call returns, the audio is fully processed and
   * the speaker enrollment is complete.
   *
   * <p>The service returns a speaker ID with the request. A speaker ID is globally unique
   * identifier (GUID) that you use to identify the speaker in subsequent requests to the service.
   * Speaker models and the custom prompts with which they are used are supported only for use with
   * US English custom models and voices.
   *
   * <p>**See also:** * [Create a speaker
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-create#tbe-create-speaker-model)
   * * [Rules for creating speaker
   * models](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-rules#tbe-rules-speakers).
   *
   * @param createSpeakerModelOptions the {@link CreateSpeakerModelOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link SpeakerModel}
   */
  public ServiceCall<SpeakerModel> createSpeakerModel(
      CreateSpeakerModelOptions createSpeakerModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createSpeakerModelOptions, "createSpeakerModelOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/speakers"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "createSpeakerModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("speaker_name", String.valueOf(createSpeakerModelOptions.speakerName()));
    builder.bodyContent(createSpeakerModelOptions.audio(), "audio/wav");
    ResponseConverter<SpeakerModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SpeakerModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a speaker model.
   *
   * <p>Gets information about all prompts that are defined by a specified speaker for all custom
   * models that are owned by a service instance. The information is grouped by the customization
   * IDs of the custom models. For each custom model, the information lists information about each
   * prompt that is defined for that custom model by the speaker. You must use credentials for the
   * instance of the service that owns a speaker model to list its prompts. Speaker models and the
   * custom prompts with which they are used are supported only for use with US English custom
   * models and voices.
   *
   * <p>**See also:** [Listing the custom prompts for a speaker
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-speaker-models#tbe-speaker-models-list-prompts).
   *
   * @param getSpeakerModelOptions the {@link GetSpeakerModelOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link SpeakerCustomModels}
   */
  public ServiceCall<SpeakerCustomModels> getSpeakerModel(
      GetSpeakerModelOptions getSpeakerModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getSpeakerModelOptions, "getSpeakerModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("speaker_id", getSpeakerModelOptions.speakerId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/speakers/{speaker_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "getSpeakerModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SpeakerCustomModels> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SpeakerCustomModels>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a speaker model.
   *
   * <p>Deletes an existing speaker model from the service instance. The service deletes the
   * enrolled speaker with the specified speaker ID. You must use credentials for the instance of
   * the service that owns a speaker model to delete the speaker.
   *
   * <p>Any prompts that are associated with the deleted speaker are not affected by the speaker's
   * deletion. The prosodic data that defines the quality of a prompt is established when the prompt
   * is created. A prompt is static and remains unaffected by deletion of its associated speaker.
   * However, the prompt cannot be resubmitted or updated with its original speaker once that
   * speaker is deleted. Speaker models and the custom prompts with which they are used are
   * supported only for use with US English custom models and voices.
   *
   * <p>**See also:** [Deleting a speaker
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-tbe-speaker-models#tbe-speaker-models-delete).
   *
   * @param deleteSpeakerModelOptions the {@link DeleteSpeakerModelOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteSpeakerModel(DeleteSpeakerModelOptions deleteSpeakerModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteSpeakerModelOptions, "deleteSpeakerModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("speaker_id", deleteSpeakerModelOptions.speakerId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/speakers/{speaker_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteSpeakerModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete labeled data.
   *
   * <p>Deletes all data that is associated with a specified customer ID. The method deletes all
   * data for the customer ID, regardless of the method by which the information was added. The
   * method has no effect if no data is associated with the customer ID. You must issue the request
   * with credentials for the same instance of the service that was used to associate the customer
   * ID with the data. You associate a customer ID with data by passing the `X-Watson-Metadata`
   * header with a request that passes the data.
   *
   * <p>**Note:** If you delete an instance of the service from the service console, all data
   * associated with that service instance is automatically deleted. This includes all custom models
   * and word/translation pairs, and all data related to speech synthesis requests.
   *
   * <p>**See also:** [Information
   * security](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-information-security#information-security).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/user_data"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("customer_id", String.valueOf(deleteUserDataOptions.customerId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }
}

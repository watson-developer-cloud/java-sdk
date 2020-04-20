/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.text_to_speech.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteUserDataOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.text_to_speech.v1.model.GetPronunciationOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.text_to_speech.v1.model.ListVoiceModelsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListVoicesOptions;
import com.ibm.watson.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Translation;
import com.ibm.watson.text_to_speech.v1.model.UpdateVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.model.VoiceModel;
import com.ibm.watson.text_to_speech.v1.model.VoiceModels;
import com.ibm.watson.text_to_speech.v1.model.Voices;
import com.ibm.watson.text_to_speech.v1.model.Words;
import com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback;
import com.ibm.watson.text_to_speech.v1.websocket.TextToSpeechWebSocketListener;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/**
 * The IBM&reg; Text to Speech service provides APIs that use IBM's speech-synthesis capabilities to
 * synthesize text into natural-sounding speech in a variety of languages, dialects, and voices. The
 * service supports at least one male or female voice, sometimes both, for each language. The audio
 * is streamed back to the client with minimal delay.
 *
 * <p>For speech synthesis, the service supports a synchronous HTTP Representational State Transfer
 * (REST) interface. It also supports a WebSocket interface that provides both plain text and SSML
 * input, including the SSML &lt;mark&gt; element and word timings. SSML is an XML-based markup
 * language that provides text annotation for speech-synthesis applications.
 *
 * <p>The service also offers a customization interface. You can use the interface to define
 * sounds-like or phonetic translations for words. A sounds-like translation consists of one or more
 * words that, when combined, sound like the word. A phonetic translation is based on the SSML
 * phoneme format for representing a word. You can specify a phonetic translation in standard
 * International Phonetic Alphabet (IPA) representation or in the proprietary IBM Symbolic Phonetic
 * Representation (SPR). The Arabic, Chinese, Dutch, and Korean languages support only IPA.
 *
 * @version v1
 * @see <a href="https://cloud.ibm.com/docs/text-to-speech/">Text to Speech</a>
 */
public class TextToSpeech extends BaseService {

  private static final String DEFAULT_SERVICE_NAME = "text_to_speech";

  private static final String DEFAULT_SERVICE_URL =
      "https://stream.watsonplatform.net/text-to-speech/api";

  /** Constructs a new `TextToSpeech` client using the DEFAULT_SERVICE_NAME. */
  public TextToSpeech() {
    this(
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs a new `TextToSpeech` client with the DEFAULT_SERVICE_NAME and the specified
   * Authenticator.
   *
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public TextToSpeech(Authenticator authenticator) {
    this(DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs a new `TextToSpeech` client with the specified serviceName.
   *
   * @param serviceName The name of the service to configure.
   */
  public TextToSpeech(String serviceName) {
    this(serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs a new `TextToSpeech` client with the specified Authenticator and serviceName.
   *
   * @param serviceName The name of the service to configure.
   * @param authenticator the Authenticator instance to be configured for this service
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
   * language, gender, and other details about the voice. To see information about a specific voice,
   * use the **Get a voice** method.
   *
   * <p>**See also:** [Listing all available
   * voices](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices#listVoices).
   *
   * @param listVoicesOptions the {@link ListVoicesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Voices}
   */
  public ServiceCall<Voices> listVoices(ListVoicesOptions listVoicesOptions) {
    String[] pathSegments = {"v1/voices"};
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "listVoices");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listVoicesOptions != null) {}

    ResponseConverter<Voices> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Voices>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List voices.
   *
   * <p>Lists all voices available for use with the service. The information includes the name,
   * language, gender, and other details about the voice. To see information about a specific voice,
   * use the **Get a voice** method.
   *
   * <p>**See also:** [Listing all available
   * voices](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices#listVoices).
   *
   * @return a {@link ServiceCall} with a response type of {@link Voices}
   */
  public ServiceCall<Voices> listVoices() {
    return listVoices(null);
  }

  /**
   * Get a voice.
   *
   * <p>Gets information about the specified voice. The information includes the name, language,
   * gender, and other details about the voice. Specify a customization ID to obtain information for
   * a custom voice model that is defined for the language of the specified voice. To list
   * information about all available voices, use the **List voices** method.
   *
   * <p>**See also:** [Listing a specific
   * voice](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices#listVoice).
   *
   * @param getVoiceOptions the {@link GetVoiceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Voice}
   */
  public ServiceCall<Voice> getVoice(GetVoiceOptions getVoiceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getVoiceOptions, "getVoiceOptions cannot be null");
    String[] pathSegments = {"v1/voices"};
    String[] pathParameters = {getVoiceOptions.voice()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "getVoice");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getVoiceOptions.customizationId() != null) {
      builder.query("customization_id", getVoiceOptions.customizationId());
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
   * some of the formats, see [Audio
   * formats](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-audioFormats#audioFormats).
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
   * @return a {@link ServiceCall} with a response type of {@link InputStream}
   */
  public ServiceCall<InputStream> synthesize(SynthesizeOptions synthesizeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        synthesizeOptions, "synthesizeOptions cannot be null");
    String[] pathSegments = {"v1/synthesize"};
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "synthesize");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (synthesizeOptions.accept() != null) {
      builder.header("Accept", synthesizeOptions.accept());
    }
    if (synthesizeOptions.voice() != null) {
      builder.query("voice", synthesizeOptions.voice());
    }
    if (synthesizeOptions.customizationId() != null) {
      builder.query("customization_id", synthesizeOptions.customizationId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", synthesizeOptions.text());
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

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
   * default translation for the language of that voice or for a specific custom voice model to see
   * the translation for that voice model.
   *
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Querying a word from a
   * language](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordsQueryLanguage).
   *
   * @param getPronunciationOptions the {@link GetPronunciationOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a response type of {@link Pronunciation}
   */
  public ServiceCall<Pronunciation> getPronunciation(
      GetPronunciationOptions getPronunciationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getPronunciationOptions, "getPronunciationOptions cannot be null");
    String[] pathSegments = {"v1/pronunciation"};
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "getPronunciation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("text", getPronunciationOptions.text());
    if (getPronunciationOptions.voice() != null) {
      builder.query("voice", getPronunciationOptions.voice());
    }
    if (getPronunciationOptions.format() != null) {
      builder.query("format", getPronunciationOptions.format());
    }
    if (getPronunciationOptions.customizationId() != null) {
      builder.query("customization_id", getPronunciationOptions.customizationId());
    }
    ResponseConverter<Pronunciation> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Pronunciation>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom model.
   *
   * <p>Creates a new empty custom voice model. You must specify a name for the new custom model.
   * You can optionally specify the language and a description for the new model. The model is owned
   * by the instance of the service whose credentials are used to create it.
   *
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Creating a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsCreate).
   *
   * @param createVoiceModelOptions the {@link CreateVoiceModelOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModel}
   */
  public ServiceCall<VoiceModel> createVoiceModel(CreateVoiceModelOptions createVoiceModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createVoiceModelOptions, "createVoiceModelOptions cannot be null");
    String[] pathSegments = {"v1/customizations"};
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "createVoiceModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createVoiceModelOptions.name());
    if (createVoiceModelOptions.language() != null) {
      contentJson.addProperty("language", createVoiceModelOptions.language());
    }
    if (createVoiceModelOptions.description() != null) {
      contentJson.addProperty("description", createVoiceModelOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<VoiceModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<VoiceModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom models.
   *
   * <p>Lists metadata such as the name and description for all custom voice models that are owned
   * by an instance of the service. Specify a language to list the voice models for that language
   * only. To see the words in addition to the metadata for a specific voice model, use the **List a
   * custom model** method. You must use credentials for the instance of the service that owns a
   * model to list information about it.
   *
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Querying all custom
   * models](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsQueryAll).
   *
   * @param listVoiceModelsOptions the {@link ListVoiceModelsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModels}
   */
  public ServiceCall<VoiceModels> listVoiceModels(ListVoiceModelsOptions listVoiceModelsOptions) {
    String[] pathSegments = {"v1/customizations"};
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "listVoiceModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listVoiceModelsOptions != null) {
      if (listVoiceModelsOptions.language() != null) {
        builder.query("language", listVoiceModelsOptions.language());
      }
    }
    ResponseConverter<VoiceModels> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<VoiceModels>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom models.
   *
   * <p>Lists metadata such as the name and description for all custom voice models that are owned
   * by an instance of the service. Specify a language to list the voice models for that language
   * only. To see the words in addition to the metadata for a specific voice model, use the **List a
   * custom model** method. You must use credentials for the instance of the service that owns a
   * model to list information about it.
   *
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Querying all custom
   * models](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsQueryAll).
   *
   * @return a {@link ServiceCall} with a response type of {@link VoiceModels}
   */
  public ServiceCall<VoiceModels> listVoiceModels() {
    return listVoiceModels(null);
  }

  /**
   * Update a custom model.
   *
   * <p>Updates information for the specified custom voice model. You can update metadata such as
   * the name and description of the voice model. You can also update the words in the model and
   * their translations. Adding a new translation for a word that already exists in a custom model
   * overwrites the word's existing translation. A custom model can contain no more than 20,000
   * entries. You must use credentials for the instance of the service that owns a model to update
   * it.
   *
   * <p>You can define sounds-like or phonetic translations for words. A sounds-like translation
   * consists of one or more words that, when combined, sound like the word. Phonetic translations
   * are based on the SSML phoneme format for representing a word. You can specify them in standard
   * International Phonetic Alphabet (IPA) representation <code>
   * &lt;phoneme alphabet="ipa" ph="t&#601;m&#712;&#593;to"&gt;&lt;/phoneme&gt;</code> or in the
   * proprietary IBM Symbolic Phonetic Representation (SPR) <code>
   * &lt;phoneme alphabet="ibm" ph="1gAstroEntxrYFXs"&gt;&lt;/phoneme&gt;</code> **Note:** This
   * method is currently a beta release.
   *
   * <p>**See also:** * [Updating a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsUpdate)
   * * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customIntro#customIntro).
   *
   * @param updateVoiceModelOptions the {@link UpdateVoiceModelOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> updateVoiceModel(UpdateVoiceModelOptions updateVoiceModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateVoiceModelOptions, "updateVoiceModelOptions cannot be null");
    String[] pathSegments = {"v1/customizations"};
    String[] pathParameters = {updateVoiceModelOptions.customizationId()};
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "updateVoiceModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateVoiceModelOptions.name() != null) {
      contentJson.addProperty("name", updateVoiceModelOptions.name());
    }
    if (updateVoiceModelOptions.description() != null) {
      contentJson.addProperty("description", updateVoiceModelOptions.description());
    }
    if (updateVoiceModelOptions.words() != null) {
      contentJson.add(
          "words",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateVoiceModelOptions.words()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a custom model.
   *
   * <p>Gets all information about a specified custom voice model. In addition to metadata such as
   * the name and description of the voice model, the output includes the words and their
   * translations as defined in the model. To see just the metadata for a voice model, use the
   * **List custom models** method.
   *
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Querying a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsQuery).
   *
   * @param getVoiceModelOptions the {@link GetVoiceModelOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModel}
   */
  public ServiceCall<VoiceModel> getVoiceModel(GetVoiceModelOptions getVoiceModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getVoiceModelOptions, "getVoiceModelOptions cannot be null");
    String[] pathSegments = {"v1/customizations"};
    String[] pathParameters = {getVoiceModelOptions.customizationId()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "getVoiceModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<VoiceModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<VoiceModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom model.
   *
   * <p>Deletes the specified custom voice model. You must use credentials for the instance of the
   * service that owns a model to delete it.
   *
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Deleting a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customModels#cuModelsDelete).
   *
   * @param deleteVoiceModelOptions the {@link DeleteVoiceModelOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteVoiceModel(DeleteVoiceModelOptions deleteVoiceModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteVoiceModelOptions, "deleteVoiceModelOptions cannot be null");
    String[] pathSegments = {"v1/customizations"};
    String[] pathParameters = {deleteVoiceModelOptions.customizationId()};
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteVoiceModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add custom words.
   *
   * <p>Adds one or more words and their translations to the specified custom voice model. Adding a
   * new translation for a word that already exists in a custom model overwrites the word's existing
   * translation. A custom model can contain no more than 20,000 entries. You must use credentials
   * for the instance of the service that owns a model to add words to it.
   *
   * <p>You can define sounds-like or phonetic translations for words. A sounds-like translation
   * consists of one or more words that, when combined, sound like the word. Phonetic translations
   * are based on the SSML phoneme format for representing a word. You can specify them in standard
   * International Phonetic Alphabet (IPA) representation <code>
   * &lt;phoneme alphabet="ipa" ph="t&#601;m&#712;&#593;to"&gt;&lt;/phoneme&gt;</code> or in the
   * proprietary IBM Symbolic Phonetic Representation (SPR) <code>
   * &lt;phoneme alphabet="ibm" ph="1gAstroEntxrYFXs"&gt;&lt;/phoneme&gt;</code> **Note:** This
   * method is currently a beta release.
   *
   * <p>**See also:** * [Adding multiple words to a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordsAdd) *
   * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customIntro#customIntro).
   *
   * @param addWordsOptions the {@link AddWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWords(AddWordsOptions addWordsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addWordsOptions, "addWordsOptions cannot be null");
    String[] pathSegments = {"v1/customizations", "words"};
    String[] pathParameters = {addWordsOptions.customizationId()};
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * <p>Lists all of the words and their translations for the specified custom voice model. The
   * output shows the translations as they are defined in the model. You must use credentials for
   * the instance of the service that owns a model to list its words.
   *
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Querying all words from a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordsQueryModel).
   *
   * @param listWordsOptions the {@link ListWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Words}
   */
  public ServiceCall<Words> listWords(ListWordsOptions listWordsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listWordsOptions, "listWordsOptions cannot be null");
    String[] pathSegments = {"v1/customizations", "words"};
    String[] pathParameters = {listWordsOptions.customizationId()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * <p>Adds a single word and its translation to the specified custom voice model. Adding a new
   * translation for a word that already exists in a custom model overwrites the word's existing
   * translation. A custom model can contain no more than 20,000 entries. You must use credentials
   * for the instance of the service that owns a model to add a word to it.
   *
   * <p>You can define sounds-like or phonetic translations for words. A sounds-like translation
   * consists of one or more words that, when combined, sound like the word. Phonetic translations
   * are based on the SSML phoneme format for representing a word. You can specify them in standard
   * International Phonetic Alphabet (IPA) representation <code>
   * &lt;phoneme alphabet="ipa" ph="t&#601;m&#712;&#593;to"&gt;&lt;/phoneme&gt;</code> or in the
   * proprietary IBM Symbolic Phonetic Representation (SPR) <code>
   * &lt;phoneme alphabet="ibm" ph="1gAstroEntxrYFXs"&gt;&lt;/phoneme&gt;</code> **Note:** This
   * method is currently a beta release.
   *
   * <p>**See also:** * [Adding a single word to a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordAdd) *
   * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customIntro#customIntro).
   *
   * @param addWordOptions the {@link AddWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWord(AddWordOptions addWordOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addWordOptions, "addWordOptions cannot be null");
    String[] pathSegments = {"v1/customizations", "words"};
    String[] pathParameters = {addWordOptions.customizationId(), addWordOptions.word()};
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Querying a single word from a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordQueryModel).
   *
   * @param getWordOptions the {@link GetWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Translation}
   */
  public ServiceCall<Translation> getWord(GetWordOptions getWordOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getWordOptions, "getWordOptions cannot be null");
    String[] pathSegments = {"v1/customizations", "words"};
    String[] pathParameters = {getWordOptions.customizationId(), getWordOptions.word()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * <p>Deletes a single word from the specified custom voice model. You must use credentials for
   * the instance of the service that owns a model to delete its words.
   *
   * <p>**Note:** This method is currently a beta release.
   *
   * <p>**See also:** [Deleting a word from a custom
   * model](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-customWords#cuWordDelete).
   *
   * @param deleteWordOptions the {@link DeleteWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteWord(DeleteWordOptions deleteWordOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteWordOptions, "deleteWordOptions cannot be null");
    String[] pathSegments = {"v1/customizations", "words"};
    String[] pathParameters = {deleteWordOptions.customizationId(), deleteWordOptions.word()};
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteWord");
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
   * ID with the data.
   *
   * <p>You associate a customer ID with data by passing the `X-Watson-Metadata` header with a
   * request that passes the data.
   *
   * <p>**See also:** [Information
   * security](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-information-security#information-security).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    String[] pathSegments = {"v1/user_data"};
    RequestBuilder builder =
        RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("customer_id", deleteUserDataOptions.customerId());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }
}

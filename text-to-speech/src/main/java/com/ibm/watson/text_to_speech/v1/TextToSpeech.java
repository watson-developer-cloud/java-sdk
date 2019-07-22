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
package com.ibm.watson.text_to_speech.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.AuthenticatorConfig;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
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
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The IBM&reg; Text to Speech service provides APIs that use IBM's speech-synthesis capabilities to synthesize text
 * into natural-sounding speech in a variety of languages, dialects, and voices. The service supports at least one male
 * or female voice, sometimes both, for each language. The audio is streamed back to the client with minimal delay.
 *
 * For speech synthesis, the service supports a synchronous HTTP Representational State Transfer (REST) interface. It
 * also supports a WebSocket interface that provides both plain text and SSML input, including the SSML &lt;mark&gt;
 * element and word timings. SSML is an XML-based markup language that provides text annotation for speech-synthesis
 * applications.
 *
 * The service also offers a customization interface. You can use the interface to define sounds-like or phonetic
 * translations for words. A sounds-like translation consists of one or more words that, when combined, sound like the
 * word. A phonetic translation is based on the SSML phoneme format for representing a word. You can specify a phonetic
 * translation in standard International Phonetic Alphabet (IPA) representation or in the proprietary IBM Symbolic
 * Phonetic Representation (SPR).
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/text-to-speech.html">Text to Speech</a>
 */
public class TextToSpeech extends BaseService {

  private static final String SERVICE_NAME = "text_to_speech";
  private static final String URL = "https://stream.watsonplatform.net/text-to-speech/api";

  /**
   * Instantiates a new `TextToSpeech`.
   *
   * @deprecated Use TextToSpeech(AuthenticatorConfig authenticatorConfig) instead
   */
  @Deprecated
  public TextToSpeech() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new `TextToSpeech` with username and password.
   *
   * @param username the username
   * @param password the password
   * @deprecated Use TextToSpeech(AuthenticatorConfig authenticatorConfig) instead
   */
  @Deprecated
  public TextToSpeech(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Instantiates a new `TextToSpeech` with the specified authentication configuration.
   *
   * @param authenticatorConfig the authentication configuration for this service
   */
  public TextToSpeech(AuthenticatorConfig authenticatorConfig) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
    setAuthenticator(authenticatorConfig);
  }

  /**
   * List voices.
   *
   * Lists all voices available for use with the service. The information includes the name, language, gender, and other
   * details about the voice. To see information about a specific voice, use the **Get a voice** method.
   *
   * **See also:** [Listing all available
   * voices](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-voices#listVoices).
   *
   * @param listVoicesOptions the {@link ListVoicesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Voices}
   */
  public ServiceCall<Voices> listVoices(ListVoicesOptions listVoicesOptions) {
    String[] pathSegments = { "v1/voices" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "listVoices");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listVoicesOptions != null) {
    }
    ResponseConverter<Voices> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Voices>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List voices.
   *
   * Lists all voices available for use with the service. The information includes the name, language, gender, and other
   * details about the voice. To see information about a specific voice, use the **Get a voice** method.
   *
   * **See also:** [Listing all available
   * voices](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-voices#listVoices).
   *
   * @return a {@link ServiceCall} with a response type of {@link Voices}
   */
  public ServiceCall<Voices> listVoices() {
    return listVoices(null);
  }

  /**
   * Get a voice.
   *
   * Gets information about the specified voice. The information includes the name, language, gender, and other details
   * about the voice. Specify a customization ID to obtain information for a custom voice model that is defined for the
   * language of the specified voice. To list information about all available voices, use the **List voices** method.
   *
   * **See also:** [Listing a specific
   * voice](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-voices#listVoice).
   *
   * @param getVoiceOptions the {@link GetVoiceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Voice}
   */
  public ServiceCall<Voice> getVoice(GetVoiceOptions getVoiceOptions) {
    Validator.notNull(getVoiceOptions, "getVoiceOptions cannot be null");
    String[] pathSegments = { "v1/voices" };
    String[] pathParameters = { getVoiceOptions.voice() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "getVoice");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getVoiceOptions.customizationId() != null) {
      builder.query("customization_id", getVoiceOptions.customizationId());
    }
    ResponseConverter<Voice> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Voice>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Synthesize audio.
   *
   * Synthesizes text to audio that is spoken in the specified voice. The service bases its understanding of the
   * language for the input text on the specified voice. Use a voice that matches the language of the input text.
   *
   * The method accepts a maximum of 5 KB of input text in the body of the request, and 8 KB for the URL and headers.
   * The 5 KB limit includes any SSML tags that you specify. The service returns the synthesized audio stream as an
   * array of bytes.
   *
   * **See also:** [The HTTP
   * interface](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-usingHTTP#usingHTTP).
   *
   * ### Audio formats (accept types)
   *
   * The service can return audio in the following formats (MIME types).
   * * Where indicated, you can optionally specify the sampling rate (`rate`) of the audio. You must specify a sampling
   * rate for the `audio/l16` and `audio/mulaw` formats. A specified sampling rate must lie in the range of 8 kHz to 192
   * kHz.
   * * For the `audio/l16` format, you can optionally specify the endianness (`endianness`) of the audio:
   * `endianness=big-endian` or `endianness=little-endian`.
   *
   * Use the `Accept` header or the `accept` parameter to specify the requested format of the response audio. If you
   * omit an audio format altogether, the service returns the audio in Ogg format with the Opus codec
   * (`audio/ogg;codecs=opus`). The service always returns single-channel audio.
   * * `audio/basic`
   *
   * The service returns audio with a sampling rate of 8000 Hz.
   * * `audio/flac`
   *
   * You can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz.
   * * `audio/l16`
   *
   * You must specify the `rate` of the audio. You can optionally specify the `endianness` of the audio. The default
   * endianness is `little-endian`.
   * * `audio/mp3`
   *
   * You can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz.
   * * `audio/mpeg`
   *
   * You can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz.
   * * `audio/mulaw`
   *
   * You must specify the `rate` of the audio.
   * * `audio/ogg`
   *
   * The service returns the audio in the `vorbis` codec. You can optionally specify the `rate` of the audio. The
   * default sampling rate is 22,050 Hz.
   * * `audio/ogg;codecs=opus`
   *
   * You can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz.
   * * `audio/ogg;codecs=vorbis`
   *
   * You can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz.
   * * `audio/wav`
   *
   * You can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz.
   * * `audio/webm`
   *
   * The service returns the audio in the `opus` codec. The service returns audio with a sampling rate of 48,000 Hz.
   * * `audio/webm;codecs=opus`
   *
   * The service returns audio with a sampling rate of 48,000 Hz.
   * * `audio/webm;codecs=vorbis`
   *
   * You can optionally specify the `rate` of the audio. The default sampling rate is 22,050 Hz.
   *
   * For more information about specifying an audio format, including additional details about some of the formats, see
   * [Audio formats](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-audioFormats#audioFormats).
   *
   *
   * ### Warning messages
   *
   * If a request includes invalid query parameters, the service returns a `Warnings` response header that provides
   * messages about the invalid parameters. The warning includes a descriptive message and a list of invalid argument
   * strings. For example, a message such as `\"Unknown arguments:\"` or `\"Unknown url query arguments:\"` followed by
   * a list of the form `\"{invalid_arg_1}, {invalid_arg_2}.\"` The request succeeds despite the warnings.
   *
   * @param synthesizeOptions the {@link SynthesizeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link InputStream}
   */
  public ServiceCall<InputStream> synthesize(SynthesizeOptions synthesizeOptions) {
    Validator.notNull(synthesizeOptions, "synthesizeOptions cannot be null");
    String[] pathSegments = { "v1/synthesize" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
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

  /**
   * Get pronunciation.
   *
   * Gets the phonetic pronunciation for the specified word. You can request the pronunciation for a specific format.
   * You can also request the pronunciation for a specific voice to see the default translation for the language of that
   * voice or for a specific custom voice model to see the translation for that voice model.
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Querying a word from a
   * language](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuWordsQueryLanguage).
   *
   * @param getPronunciationOptions the {@link GetPronunciationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Pronunciation}
   */
  public ServiceCall<Pronunciation> getPronunciation(GetPronunciationOptions getPronunciationOptions) {
    Validator.notNull(getPronunciationOptions, "getPronunciationOptions cannot be null");
    String[] pathSegments = { "v1/pronunciation" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "getPronunciation");
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
    ResponseConverter<Pronunciation> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Pronunciation>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom model.
   *
   * Creates a new empty custom voice model. You must specify a name for the new custom model. You can optionally
   * specify the language and a description for the new model. The model is owned by the instance of the service whose
   * credentials are used to create it.
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Creating a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customModels#cuModelsCreate).
   *
   * @param createVoiceModelOptions the {@link CreateVoiceModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModel}
   */
  public ServiceCall<VoiceModel> createVoiceModel(CreateVoiceModelOptions createVoiceModelOptions) {
    Validator.notNull(createVoiceModelOptions, "createVoiceModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "createVoiceModel");
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
    ResponseConverter<VoiceModel> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<VoiceModel>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom models.
   *
   * Lists metadata such as the name and description for all custom voice models that are owned by an instance of the
   * service. Specify a language to list the voice models for that language only. To see the words in addition to the
   * metadata for a specific voice model, use the **List a custom model** method. You must use credentials for the
   * instance of the service that owns a model to list information about it.
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Querying all custom
   * models](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customModels#cuModelsQueryAll).
   *
   * @param listVoiceModelsOptions the {@link ListVoiceModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModels}
   */
  public ServiceCall<VoiceModels> listVoiceModels(ListVoiceModelsOptions listVoiceModelsOptions) {
    String[] pathSegments = { "v1/customizations" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "listVoiceModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listVoiceModelsOptions != null) {
      if (listVoiceModelsOptions.language() != null) {
        builder.query("language", listVoiceModelsOptions.language());
      }
    }
    ResponseConverter<VoiceModels> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<VoiceModels>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List custom models.
   *
   * Lists metadata such as the name and description for all custom voice models that are owned by an instance of the
   * service. Specify a language to list the voice models for that language only. To see the words in addition to the
   * metadata for a specific voice model, use the **List a custom model** method. You must use credentials for the
   * instance of the service that owns a model to list information about it.
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Querying all custom
   * models](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customModels#cuModelsQueryAll).
   *
   * @return a {@link ServiceCall} with a response type of {@link VoiceModels}
   */
  public ServiceCall<VoiceModels> listVoiceModels() {
    return listVoiceModels(null);
  }

  /**
   * Update a custom model.
   *
   * Updates information for the specified custom voice model. You can update metadata such as the name and description
   * of the voice model. You can also update the words in the model and their translations. Adding a new translation for
   * a word that already exists in a custom model overwrites the word's existing translation. A custom model can contain
   * no more than 20,000 entries. You must use credentials for the instance of the service that owns a model to update
   * it.
   *
   * You can define sounds-like or phonetic translations for words. A sounds-like translation consists of one or more
   * words that, when combined, sound like the word. Phonetic translations are based on the SSML phoneme format for
   * representing a word. You can specify them in standard International Phonetic Alphabet (IPA) representation
   *
   * <code>&lt;phoneme alphabet=\"ipa\" ph=\"t&#601;m&#712;&#593;to\"&gt;&lt;/phoneme&gt;</code>
   *
   * or in the proprietary IBM Symbolic Phonetic Representation (SPR)
   *
   * <code>&lt;phoneme alphabet=\"ibm\" ph=\"1gAstroEntxrYFXs\"&gt;&lt;/phoneme&gt;</code>
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:**
   * * [Updating a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customModels#cuModelsUpdate)
   * * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customIntro#customIntro).
   *
   * @param updateVoiceModelOptions the {@link UpdateVoiceModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> updateVoiceModel(UpdateVoiceModelOptions updateVoiceModelOptions) {
    Validator.notNull(updateVoiceModelOptions, "updateVoiceModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations" };
    String[] pathParameters = { updateVoiceModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "updateVoiceModel");
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
      contentJson.add("words", GsonSingleton.getGson().toJsonTree(updateVoiceModelOptions.words()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a custom model.
   *
   * Gets all information about a specified custom voice model. In addition to metadata such as the name and description
   * of the voice model, the output includes the words and their translations as defined in the model. To see just the
   * metadata for a voice model, use the **List custom models** method.
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Querying a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customModels#cuModelsQuery).
   *
   * @param getVoiceModelOptions the {@link GetVoiceModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModel}
   */
  public ServiceCall<VoiceModel> getVoiceModel(GetVoiceModelOptions getVoiceModelOptions) {
    Validator.notNull(getVoiceModelOptions, "getVoiceModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations" };
    String[] pathParameters = { getVoiceModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "getVoiceModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<VoiceModel> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<VoiceModel>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom model.
   *
   * Deletes the specified custom voice model. You must use credentials for the instance of the service that owns a
   * model to delete it.
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Deleting a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customModels#cuModelsDelete).
   *
   * @param deleteVoiceModelOptions the {@link DeleteVoiceModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteVoiceModel(DeleteVoiceModelOptions deleteVoiceModelOptions) {
    Validator.notNull(deleteVoiceModelOptions, "deleteVoiceModelOptions cannot be null");
    String[] pathSegments = { "v1/customizations" };
    String[] pathParameters = { deleteVoiceModelOptions.customizationId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteVoiceModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add custom words.
   *
   * Adds one or more words and their translations to the specified custom voice model. Adding a new translation for a
   * word that already exists in a custom model overwrites the word's existing translation. A custom model can contain
   * no more than 20,000 entries. You must use credentials for the instance of the service that owns a model to add
   * words to it.
   *
   * You can define sounds-like or phonetic translations for words. A sounds-like translation consists of one or more
   * words that, when combined, sound like the word. Phonetic translations are based on the SSML phoneme format for
   * representing a word. You can specify them in standard International Phonetic Alphabet (IPA) representation
   *
   * <code>&lt;phoneme alphabet=\"ipa\" ph=\"t&#601;m&#712;&#593;to\"&gt;&lt;/phoneme&gt;</code>
   *
   * or in the proprietary IBM Symbolic Phonetic Representation (SPR)
   *
   * <code>&lt;phoneme alphabet=\"ibm\" ph=\"1gAstroEntxrYFXs\"&gt;&lt;/phoneme&gt;</code>
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:**
   * * [Adding multiple words to a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuWordsAdd)
   * * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customIntro#customIntro).
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
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "addWords");
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
   * List custom words.
   *
   * Lists all of the words and their translations for the specified custom voice model. The output shows the
   * translations as they are defined in the model. You must use credentials for the instance of the service that owns a
   * model to list its words.
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Querying all words from a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuWordsQueryModel).
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
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "listWords");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Words> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Words>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a custom word.
   *
   * Adds a single word and its translation to the specified custom voice model. Adding a new translation for a word
   * that already exists in a custom model overwrites the word's existing translation. A custom model can contain no
   * more than 20,000 entries. You must use credentials for the instance of the service that owns a model to add a word
   * to it.
   *
   * You can define sounds-like or phonetic translations for words. A sounds-like translation consists of one or more
   * words that, when combined, sound like the word. Phonetic translations are based on the SSML phoneme format for
   * representing a word. You can specify them in standard International Phonetic Alphabet (IPA) representation
   *
   * <code>&lt;phoneme alphabet=\"ipa\" ph=\"t&#601;m&#712;&#593;to\"&gt;&lt;/phoneme&gt;</code>
   *
   * or in the proprietary IBM Symbolic Phonetic Representation (SPR)
   *
   * <code>&lt;phoneme alphabet=\"ibm\" ph=\"1gAstroEntxrYFXs\"&gt;&lt;/phoneme&gt;</code>
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:**
   * * [Adding a single word to a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuWordAdd)
   * * [Adding words to a Japanese custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuJapaneseAdd)
   * * [Understanding
   * customization](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customIntro#customIntro).
   *
   * @param addWordOptions the {@link AddWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWord(AddWordOptions addWordOptions) {
    Validator.notNull(addWordOptions, "addWordOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "words" };
    String[] pathParameters = { addWordOptions.customizationId(), addWordOptions.word() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
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
   * Gets the translation for a single word from the specified custom model. The output shows the translation as it is
   * defined in the model. You must use credentials for the instance of the service that owns a model to list its words.
   *
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Querying a single word from a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuWordQueryModel).
   *
   * @param getWordOptions the {@link GetWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Translation}
   */
  public ServiceCall<Translation> getWord(GetWordOptions getWordOptions) {
    Validator.notNull(getWordOptions, "getWordOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "words" };
    String[] pathParameters = { getWordOptions.customizationId(), getWordOptions.word() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "getWord");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Translation> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Translation>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom word.
   *
   * Deletes a single word from the specified custom voice model. You must use credentials for the instance of the
   * service that owns a model to delete its words.
   *
   * **Note:** This method is currently a beta release.
   *
   * **See also:** [Deleting a word from a custom
   * model](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-customWords#cuWordDelete).
   *
   * @param deleteWordOptions the {@link DeleteWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteWord(DeleteWordOptions deleteWordOptions) {
    Validator.notNull(deleteWordOptions, "deleteWordOptions cannot be null");
    String[] pathSegments = { "v1/customizations", "words" };
    String[] pathParameters = { deleteWordOptions.customizationId(), deleteWordOptions.word() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
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
   * Deletes all data that is associated with a specified customer ID. The method deletes all data for the customer ID,
   * regardless of the method by which the information was added. The method has no effect if no data is associated with
   * the customer ID. You must issue the request with credentials for the same instance of the service that was used to
   * associate the customer ID with the data.
   *
   * You associate a customer ID with data by passing the `X-Watson-Metadata` header with a request that passes the
   * data.
   *
   * **See also:** [Information
   * security](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-information-security#information-security).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    Validator.notNull(deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    String[] pathSegments = { "v1/user_data" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("text_to_speech", "v1", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("customer_id", deleteUserDataOptions.customerId());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}

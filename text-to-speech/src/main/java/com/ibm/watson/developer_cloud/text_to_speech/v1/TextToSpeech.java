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
package com.ibm.watson.developer_cloud.text_to_speech.v1;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CreateVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.DeleteVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetPronunciationOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.ListVoiceModelsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.ListVoicesOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Translation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.UpdateVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.VoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.VoiceModels;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voices;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Words;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import java.io.InputStream;

/**
 * ### Service Overview
 * The IBM Text to Speech service provides a Representational State Transfer (REST) Application Programming Interface
 * (API) that uses IBM's speech-synthesis capabilities to synthesize text into natural-sounding speech in a variety of
 * languages, dialects, and voices. The service currently synthesizes text from US English, UK English, French, German,
 * Italian, Japanese, Spanish, or Brazilian Portuguese into audio spoken in a male or female voice (the service supports
 * only a single gender for some languages). The audio is streamed back to the client with minimal delay.
 * ### API Overview
 * The Text to Speech service consists of the following related endpoints:
 * * `/v1/voices` provides information about the voices available for synthesized speech.
 * * `/v1/synthesize` synthesizes written text to audio speech.
 * * `/v1/pronunciation` returns the pronunciation for a specified word. The `/v1/pronunciation` method is currently
 * beta functionality.
 * * `/v1/customizations` and `/v1/customizations/{customization_id}` lets users create custom voice models, which are
 * dictionaries of words and their translations for use in speech synthesis. All `/v1/customizations` methods are
 * currently beta functionality.
 * * `/v1/customizations/{customization_id}/words` and `/v1/customizations/{customization_id}/words/{word}` lets users
 * manage the words in a custom voice model.
 *
 *
 * **Note about the Try It Out feature:** The `Try it out!` button lets you experiment with the methods of the API by
 * making actual cURL calls to the service. The feature is **not** supported for use with the `POST /v1/synthesize`
 * method. For examples of calls to this method, see the [Text to Speech API
 * reference](http://www.ibm.com/watson/developercloud/text-to-speech/api/v1/).
 * ### API Usage
 * The following information provides details about using the service to synthesize audio:
 * * **Audio formats:** The service supports a number of audio formats (MIME types). For more information about audio
 * formats and sampling rates, including links to a number of Internet sites that provide technical and usage details
 * about the different formats, see [Specifying an audio
 * format](https://console.bluemix.net/docs/services/text-to-speech/http.html#format).
 * * **SSML:** Many methods refer to the Speech Synthesis Markup Language (SSML), an XML-based markup language that
 * provides annotations of text for speech-synthesis applications; for example, many methods accept or produce
 * translations that use an SSML-based phoneme format. See [Using
 * SSML](https://console.bluemix.net/docs/services/text-to-speech/SSML.html) and [Using IBM
 * SPR](https://console.bluemix.net/docs/services/text-to-speech/SPRs.html).
 * * **Word translations:** Many customization methods accept or return sounds-like or phonetic translations for words.
 * A phonetic translation is based on the SSML format for representing the phonetic string of a word. Phonetic
 * translations can use standard International Phonetic Alphabet (IPA) representation:
 *
 * &lt;phoneme alphabet="ipa" ph="t&#601;m&#712;&#593;to"&gt;&lt;/phoneme&gt;
 *
 * or the proprietary IBM Symbolic Phonetic Representation (SPR):
 *
 * &lt;phoneme alphabet="ibm" ph="1gAstroEntxrYFXs"&gt;&lt;/phoneme&gt;
 *
 * For more information about customization and about sounds-like and phonetic translations, see [Understanding
 * customization](https://console.bluemix.net/docs/services/text-to-speech/custom-intro.html).
 * * **GUIDs:** The pronunciation and customization methods accept or return a Globally Unique Identifier (GUID). For
 * example, customization IDs (specified with the `customization_id` parameter) and service credentials are GUIDs. GUIDs
 * are hexadecimal strings that have the format `xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx`.
 * * **WebSocket interface:** The service also offers a WebSocket interface as an alternative to its HTTP REST interface
 * for speech synthesis. The WebSocket interface supports both plain text and SSML input, including the SSML
 * &lt;mark&gt; element and word timings. See [The WebSocket
 * interface](https://console.bluemix.net/docs/services/text-to-speech/websockets.html).
 * * **Authentication:** You authenticate to the service by using your service credentials. You can use your credentials
 * to authenticate via a proxy server that resides in IBM Cloud, or you can use your credentials to obtain a token and
 * contact the service directly. See [Service credentials for Watson
 * services](https://console.bluemix.net/docs/services/watson/getting-started-credentials.html) and [Tokens for
 * authentication](https://console.bluemix.net/docs/services/watson/getting-started-tokens.html).
 * * **Custom voice model ownership:** In all cases, you must use service credentials created for the instance of the
 * service that owns a custom voice model to use the methods described in this documentation with that model. For more
 * information, see [Ownership of custom voice
 * models](https://console.bluemix.net/docs/services/text-to-speech/custom-models.html#customOwner).
 * * **Request Logging:** By default, all Watson services log requests and their results. Data is collected only to
 * improve the Watson services. If you do not want to share your data, set the header parameter
 * `X-Watson-Learning-Opt-Out` to `true` for each request. Data is collected for any request that omits this header. See
 * [Controlling request logging for Watson
 * services](https://console.bluemix.net/docs/services/watson/getting-started-logging.html).
 *
 * The service does not log data (words and translations) that are used to build custom language models; your training
 * data is never used to improve the service's base models. The service does log data when a custom model is used with a
 * synthesize request; you must set the `X-Watson-Learning-Opt-Out` request header to prevent logging for recognition
 * requests. For more information, see [Request logging and data
 * privacy](https://console.bluemix.net/docs/services/text-to-speech/custom-models.html#customLogging).
 *
 * For more information about the service and its various interfaces, see [About Text to
 * Speech](https://console.bluemix.net/docs/services/text-to-speech/index.html).
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/text-to-speech.html">Text to Speech</a>
 */
public class TextToSpeech extends WatsonService {

  private static final String SERVICE_NAME = "text_to_speech";
  private static final String URL = "https://stream.watsonplatform.net/text-to-speech/api";

  /**
   * Instantiates a new `TextToSpeech`.
   *
   */
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
   */
  public TextToSpeech(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Retrieves a specific voice available for speech synthesis.
   *
   * Lists information about the voice specified with the `voice` path parameter. Specify the `customization_id` query
   * parameter to obtain information for that custom voice model of the specified voice. Use the `GET /v1/voices` method
   * to see a list of all available voices.
   *
   * @param getVoiceOptions the {@link GetVoiceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Voice}
   */
  public ServiceCall<Voice> getVoice(GetVoiceOptions getVoiceOptions) {
    Validator.notNull(getVoiceOptions, "getVoiceOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/voices/%s", getVoiceOptions.voice()));
    if (getVoiceOptions.customizationId() != null) {
      builder.query("customization_id", getVoiceOptions.customizationId());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Voice.class));
  }

  /**
   * Retrieves all voices available for speech synthesis.
   *
   * Lists information about all available voices. To see information about a specific voice, use the `GET
   * /v1/voices/{voice}` method.
   *
   * @param listVoicesOptions the {@link ListVoicesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Voices}
   */
  public ServiceCall<Voices> listVoices(ListVoicesOptions listVoicesOptions) {
    RequestBuilder builder = RequestBuilder.get("/v1/voices");
    if (listVoicesOptions != null) {
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Voices.class));
  }

  /**
   * Retrieves all voices available for speech synthesis.
   *
   * Lists information about all available voices. To see information about a specific voice, use the `GET
   * /v1/voices/{voice}` method.
   *
   * @return a {@link ServiceCall} with a response type of {@link Voices}
   */
  public ServiceCall<Voices> listVoices() {
    return listVoices(null);
  }

  /**
   * Streaming speech synthesis of the text in the body parameter.
   *
   * Synthesizes text to spoken audio, returning the synthesized audio stream as an array of bytes. Identical to the
   * `GET` method but passes longer text in the body of the request, not with the URL. Text size is limited to 5 KB.
   * (For the `audio/l16` format, you can optionally specify `endianness=big-endian` or `endianness=little-endian`; the
   * default is little endian.) If a request includes invalid query parameters, the service returns a `Warnings`
   * response header that provides messages about the invalid parameters. The warning includes a descriptive message and
   * a list of invalid argument strings. For example, a message such as `\"Unknown arguments:\"` or `\"Unknown url query
   * arguments:\"` followed by a list of the form `\"invalid_arg_1, invalid_arg_2.\"` The request succeeds despite the
   * warnings. **Note about the Try It Out feature:** The `Try it out!` button is **not** supported for use with the the
   * `POST /v1/synthesize` method. For examples of calls to the method, see the [Text to Speech API
   * reference](http://www.ibm.com/watson/developercloud/text-to-speech/api/v1/).
   *
   * @param synthesizeOptions the {@link SynthesizeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link InputStream}
   */
  public ServiceCall<InputStream> synthesize(SynthesizeOptions synthesizeOptions) {
    Validator.notNull(synthesizeOptions, "synthesizeOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/synthesize");
    builder.header("Accept", synthesizeOptions.accept());
    if (synthesizeOptions.voice() != null) {
      builder.query("voice", synthesizeOptions.voice());
    }
    if (synthesizeOptions.customizationId() != null) {
      builder.query("customization_id", synthesizeOptions.customizationId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", synthesizeOptions.text());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getInputStream());
  }

  /**
   * Gets the pronunciation for a word.
   *
   * Returns the phonetic pronunciation for the word specified by the `text` parameter. You can request the
   * pronunciation for a specific format. You can also request the pronunciation for a specific voice to see the default
   * translation for the language of that voice or for a specific custom voice model to see the translation for that
   * voice model. **Note:** This method is currently a beta release.
   *
   * @param getPronunciationOptions the {@link GetPronunciationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Pronunciation}
   */
  public ServiceCall<Pronunciation> getPronunciation(GetPronunciationOptions getPronunciationOptions) {
    Validator.notNull(getPronunciationOptions, "getPronunciationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get("/v1/pronunciation");
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
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Pronunciation.class));
  }

  /**
   * Creates a new custom voice model.
   *
   * Creates a new empty custom voice model. The model is owned by the instance of the service whose credentials are
   * used to create it. **Note:** This method is currently a beta release.
   *
   * @param createVoiceModelOptions the {@link CreateVoiceModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModel}
   */
  public ServiceCall<VoiceModel> createVoiceModel(CreateVoiceModelOptions createVoiceModelOptions) {
    Validator.notNull(createVoiceModelOptions, "createVoiceModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/customizations");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createVoiceModelOptions.name());
    if (createVoiceModelOptions.language() != null) {
      contentJson.addProperty("language", createVoiceModelOptions.language());
    }
    if (createVoiceModelOptions.description() != null) {
      contentJson.addProperty("description", createVoiceModelOptions.description());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(VoiceModel.class));
  }

  /**
   * Deletes a custom voice model.
   *
   * Deletes the custom voice model with the specified `customization_id`. You must use credentials for the instance of
   * the service that owns a model to delete it. **Note:** This method is currently a beta release.
   *
   * @param deleteVoiceModelOptions the {@link DeleteVoiceModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteVoiceModel(DeleteVoiceModelOptions deleteVoiceModelOptions) {
    Validator.notNull(deleteVoiceModelOptions, "deleteVoiceModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/customizations/%s", deleteVoiceModelOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Queries the contents of a custom voice model.
   *
   * Lists all information about the custom voice model with the specified `customization_id`. In addition to metadata
   * such as the name and description of the voice model, the output includes the words in the model and their
   * translations as defined in the model. To see just the metadata for a voice model, use the `GET /v1/customizations`
   * method. You must use credentials for the instance of the service that owns a model to list information about it.
   * **Note:** This method is currently a beta release.
   *
   * @param getVoiceModelOptions the {@link GetVoiceModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModel}
   */
  public ServiceCall<VoiceModel> getVoiceModel(GetVoiceModelOptions getVoiceModelOptions) {
    Validator.notNull(getVoiceModelOptions, "getVoiceModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/customizations/%s", getVoiceModelOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(VoiceModel.class));
  }

  /**
   * Lists all available custom voice models for a language or for all languages.
   *
   * Lists metadata such as the name and description for the custom voice models that you own. Use the `language` query
   * parameter to list the voice models that you own for the specified language only. Omit the parameter to see all
   * voice models that you own for all languages. To see the words in addition to the metadata for a specific voice
   * model, use the `GET /v1/customizations/{customization_id}` method. You must use credentials for the instance of the
   * service that owns a model to list information about it. **Note:** This method is currently a beta release.
   *
   * @param listVoiceModelsOptions the {@link ListVoiceModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link VoiceModels}
   */
  public ServiceCall<VoiceModels> listVoiceModels(ListVoiceModelsOptions listVoiceModelsOptions) {
    RequestBuilder builder = RequestBuilder.get("/v1/customizations");
    if (listVoiceModelsOptions != null) {
      if (listVoiceModelsOptions.language() != null) {
        builder.query("language", listVoiceModelsOptions.language());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(VoiceModels.class));
  }

  /**
   * Lists all available custom voice models for a language or for all languages.
   *
   * Lists metadata such as the name and description for the custom voice models that you own. Use the `language` query
   * parameter to list the voice models that you own for the specified language only. Omit the parameter to see all
   * voice models that you own for all languages. To see the words in addition to the metadata for a specific voice
   * model, use the `GET /v1/customizations/{customization_id}` method. You must use credentials for the instance of the
   * service that owns a model to list information about it. **Note:** This method is currently a beta release.
   *
   * @return a {@link ServiceCall} with a response type of {@link VoiceModels}
   */
  public ServiceCall<VoiceModels> listVoiceModels() {
    return listVoiceModels(null);
  }

  /**
   * Updates information and words for a custom voice model.
   *
   * Updates information for the custom voice model with the specified `customization_id`. You can update the metadata
   * such as the name and description of the voice model. You can also update the words in the model and their
   * translations. Adding a new translation for a word that already exists in a custom model overwrites the word's
   * existing translation. A custom model can contain no more than 20,000 entries. You must use credentials for the
   * instance of the service that owns a model to update it. **Note:** This method is currently a beta release.
   *
   * @param updateVoiceModelOptions the {@link UpdateVoiceModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> updateVoiceModel(UpdateVoiceModelOptions updateVoiceModelOptions) {
    Validator.notNull(updateVoiceModelOptions, "updateVoiceModelOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/customizations/%s", updateVoiceModelOptions
        .customizationId()));
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
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Adds a word to a custom voice model.
   *
   * Adds a single word and its translation to the custom voice model with the specified `customization_id`. Adding a
   * new translation for a word that already exists in a custom model overwrites the word's existing translation. A
   * custom model can contain no more than 20,000 entries. You must use credentials for the instance of the service that
   * owns a model to add a word to it. **Note:** This method is currently a beta release.
   *
   * @param addWordOptions the {@link AddWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWord(AddWordOptions addWordOptions) {
    Validator.notNull(addWordOptions, "addWordOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/customizations/%s/words/%s", addWordOptions
        .customizationId(), addWordOptions.word()));
    final JsonObject contentJson = new JsonObject();
    if (addWordOptions.translation() != null) {
      contentJson.addProperty("translation", addWordOptions.translation());
    }
    if (addWordOptions.partOfSpeech() != null) {
      contentJson.addProperty("part_of_speech", addWordOptions.partOfSpeech());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Adds one or more words to a custom voice model.
   *
   * Adds one or more words and their translations to the custom voice model with the specified `customization_id`.
   * Adding a new translation for a word that already exists in a custom model overwrites the word's existing
   * translation. A custom model can contain no more than 20,000 entries. You must use credentials for the instance of
   * the service that owns a model to add words to it. **Note:** This method is currently a beta release.
   *
   * @param addWordsOptions the {@link AddWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addWords(AddWordsOptions addWordsOptions) {
    Validator.notNull(addWordsOptions, "addWordsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/customizations/%s/words", addWordsOptions
        .customizationId()));
    final JsonObject contentJson = new JsonObject();
    if (addWordsOptions.words() != null) {
      contentJson.add("words", GsonSingleton.getGson().toJsonTree(addWordsOptions.words()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes a word from a custom voice model.
   *
   * Deletes a single word from the custom voice model with the specified `customization_id`. You must use credentials
   * for the instance of the service that owns a model to delete it. **Note:** This method is currently a beta release.
   *
   * @param deleteWordOptions the {@link DeleteWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteWord(DeleteWordOptions deleteWordOptions) {
    Validator.notNull(deleteWordOptions, "deleteWordOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/customizations/%s/words/%s", deleteWordOptions
        .customizationId(), deleteWordOptions.word()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Queries details about a word in a custom voice model.
   *
   * Returns the translation for a single word from the custom model with the specified `customization_id`. The output
   * shows the translation as it is defined in the model. You must use credentials for the instance of the service that
   * owns a model to query information about its words. **Note:** This method is currently a beta release.
   *
   * @param getWordOptions the {@link GetWordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Translation}
   */
  public ServiceCall<Translation> getWord(GetWordOptions getWordOptions) {
    Validator.notNull(getWordOptions, "getWordOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/customizations/%s/words/%s", getWordOptions
        .customizationId(), getWordOptions.word()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Translation.class));
  }

  /**
   * Queries details about the words in a custom voice model.
   *
   * Lists all of the words and their translations for the custom voice model with the specified `customization_id`. The
   * output shows the translations as they are defined in the model. You must use credentials for the instance of the
   * service that owns a model to query information about its words. **Note:** This method is currently a beta release.
   *
   * @param listWordsOptions the {@link ListWordsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Words}
   */
  public ServiceCall<Words> listWords(ListWordsOptions listWordsOptions) {
    Validator.notNull(listWordsOptions, "listWordsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/customizations/%s/words", listWordsOptions
        .customizationId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Words.class));
  }

}

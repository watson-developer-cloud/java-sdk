/**
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
package com.ibm.watson.developer_cloud.text_to_speech.v1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Phoneme;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * The Text to Speech service uses IBM's speech synthesis capabilities to convert text to an audio signal. The audio is
 * streamed back to the client in a {@link InputStream}
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/text-to-speech.html"> Text to Speech</a>
 */
public class TextToSpeech extends WatsonService {

  private static final String URL = "https://stream.watsonplatform.net/text-to-speech/api";
  private static final String PATH_VOICES = "/v1/voices";
  private static final String PATH_VOICE = "/v1/voices/%s";
  private static final String PATH_SYNTHESIZE = "/v1/synthesize";
  private static final String PATH_GET_PRONUNCIATION = "/v1/pronunciation";
  private static final String PATH_CUSTOMIZATIONS = "/v1/customizations";
  private static final String PATH_CUSTOMIZATION = PATH_CUSTOMIZATIONS + "/%s";
  private static final String PATH_WORDS = PATH_CUSTOMIZATION + "/words";
  private static final String PATH_WORD = PATH_WORDS + "/%s";

  private static final String SERVICE_NAME = "text_to_speech";
  private static final String ACCEPT = "accept";
  private static final String TEXT = "text";
  private static final String VOICE = "voice";
  private static final String VOICES = "voices";
  private static final String FORMAT = "format";
  private static final String CUSTOMIZATION_ID = "customization_id";
  private static final String CUSTOMIZATIONS = "customizations";
  private static final String LANGUAGE = "language";
  private static final String WORDS = "words";

  private static final Type TYPE_GET_VOICES = new TypeToken<List<Voice>>() { }.getType();
  private static final Type TYPE_VOICE_MODELS = new TypeToken<List<CustomVoiceModel>>() { }.getType();
  private static final Type TYPE_CUSTOM_TRANSLATIONS = new TypeToken<List<CustomTranslation>>() { }.getType();
  private static final Gson GSON = GsonSingleton.getGson();

  /**
   * Instantiates a new text to speech.
   */
  public TextToSpeech() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new text to speech service by username and password.
   *
   * @param username the username
   * @param password the password
   */
  public TextToSpeech(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Lists information about all available voices. To see information about a specific voice, use the
   * {@link TextToSpeech#getVoice(String,String)} method.
   *
   * @return the list of {@link Voice}
   */
  public ServiceCall<List<Voice>> getVoices() {
    final Request request = RequestBuilder.get(PATH_VOICES).build();
    ResponseConverter<List<Voice>> converter = ResponseConverterUtils.getGenericObject(TYPE_GET_VOICES, VOICES);
    return createServiceCall(request, converter);
  }

  /**
   * Lists information about the voice specified with the voice path parameter.
   *
   * @param voiceName the voice name
   * @return the {@link Voice}
   */
  public ServiceCall<Voice> getVoice(final String voiceName) {
    return getVoice(voiceName, null);
  }

  /**
   * Lists information about the voice specified with the voice path parameter.
   * Specify the <code>customizationId</code> parameter to obtain information
   * for that custom voice model of the specified voice.
   *
   * @param voiceName the voice name
   * @param customizationId the customization id
   * @return the {@link Voice}
   */
  public ServiceCall<Voice> getVoice(final String voiceName, final String customizationId) {
    Validator.notNull(voiceName, "name cannot be null");

    RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_VOICE, voiceName));

    if (customizationId != null) {
      requestBuilder.query(CUSTOMIZATION_ID, customizationId);
    }

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Voice.class));
  }

  /**
   * Returns the phonetic pronunciation for the <code>word</code> specified.
   *
   * @param word The word for which the pronunciation is requested.
   * @param voice the voice to obtain the pronunciation for the specified word in the language of that voice.
   * @param phoneme the phoneme set in which to return the pronunciation
   * @return the word pronunciation
   * @see Pronunciation
   */
  public ServiceCall<Pronunciation> getPronunciation(final String word, final Voice voice, final Phoneme phoneme) {
    return getPronunciation(word, voice, phoneme, null);
  }

  /**
   * Returns the phonetic pronunciation for the <code>word</code> specified.
   *
   * @param word The word for which the pronunciation is requested.
   * @param voice the voice to obtain the pronunciation for the specified word in the language of that voice.
   * @param phoneme the phoneme set in which to return the pronunciation
   * @param customizationId the customization id
   * @return the word pronunciation
   * @see Pronunciation
   */
  public ServiceCall<Pronunciation> getPronunciation(final String word, final Voice voice, final Phoneme phoneme,
      final String customizationId) {
    final RequestBuilder requestBuilder = RequestBuilder.get(PATH_GET_PRONUNCIATION).query(TEXT, word);
    if (voice != null) {
      requestBuilder.query(VOICE, voice.getName());
    }

    if (phoneme != null) {
      requestBuilder.query(FORMAT, phoneme);
    }

    if (customizationId != null) {
      requestBuilder.query(CUSTOMIZATION_ID, customizationId);
    }

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Pronunciation.class));
  }

  /**
   * Synthesize text using a voice.
   *
   * @param text the text to synthesize
   * @param voice the voice
   * @return the input stream
   */
  public ServiceCall<InputStream> synthesize(final String text, final Voice voice) {
    return synthesize(text, voice, null);
  }

  /**
   * Synthesize text using a {@link Voice} and {@link AudioFormat}.
   *
   * @param text the text
   * @param voice the voice
   * @param audioFormat the {@link AudioFormat}
   * @return the input stream
   */
  public ServiceCall<InputStream> synthesize(final String text, final Voice voice, final AudioFormat audioFormat) {
    return synthesize(text, voice, audioFormat, null);
  }

  /**
   * Synthesize text using a {@link Voice} and {@link AudioFormat}.
   *
   * @param text the text
   * @param voice the voice
   * @param audioFormat the {@link AudioFormat}
   * @param customizationId the customization ID
   * @return the input stream
   */
  public ServiceCall<InputStream> synthesize(final String text, final Voice voice, final AudioFormat audioFormat,
      String customizationId) {
    Validator.isTrue((text != null) && !text.isEmpty(), "text cannot be null or empty");
    Validator.isTrue(voice != null, "voice cannot be null or empty");

    final RequestBuilder request = RequestBuilder.post(PATH_SYNTHESIZE);

    JsonObject jsonText = new JsonObject();
    jsonText.addProperty(TEXT, text);
    request.bodyJson(jsonText);

    request.query(VOICE, voice.getName());
    request.query(ACCEPT, audioFormat != null ? audioFormat : AudioFormat.WAV);

    if (customizationId != null) {
      request.query(CUSTOMIZATION_ID, customizationId);
    }

    return createServiceCall(request.build(), ResponseConverterUtils.getInputStream());
  }

  /**
   * Gets all meta data of the CustomVoiceModels that you own.
   *
   * @param language the language (e.g. "en-us")
   * @return the VoiceModels
   */
  public ServiceCall<List<CustomVoiceModel>> getCustomVoiceModels(final String language) {

    final Request request;
    if (language != null) {
        request = RequestBuilder.get(PATH_CUSTOMIZATIONS).query(LANGUAGE, language).build();
    } else {
        request = RequestBuilder.get(PATH_CUSTOMIZATIONS).build();
    }

    ResponseConverter<List<CustomVoiceModel>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_VOICE_MODELS, CUSTOMIZATIONS);
    return createServiceCall(request, converter);
  }

  /**
   * Gets the metadata for a CustomVoiceModel specified by object.
   *
   * @param model the custom voice model object to be queried
   * @return the CustomVoiceModel with full metadata
   */
  public ServiceCall<CustomVoiceModel> getCustomVoiceModel(final CustomVoiceModel model) {
    Validator.notNull(model, "model cannot be null");
    Validator.notEmpty(model.getId(), "model id must not be empty");

    return getCustomVoiceModel(model.getId());
  }

  /**
   * Gets the metadata for a CustomVoiceModel specified by customization id.
   *
   * @param customizationId the id of the custom voice model to be queried
   * @return the CustomVoiceModel with full metadata
   */
  public ServiceCall<CustomVoiceModel> getCustomVoiceModel(final String customizationId) {
    Validator.notNull(customizationId, "customization id cannot be null");

    final Request request = RequestBuilder.get(String.format(PATH_CUSTOMIZATION, customizationId)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(CustomVoiceModel.class));
  }

  /**
   * Creates a new CustomVoiceModel with the specified name, description, and language.
   *
   * @param name the name of the new model
   * @param language the language of the new model (the default is "en-US")
   * @param description a description of the new model (the default is no description)
   * @return a CustomVoiceModel that contains the id of the new model
   */
  public ServiceCall<CustomVoiceModel> createCustomVoiceModel(final String name, final String language,
      final String description) {
    Validator.notNull(name, "name cannot be null");

    CustomVoiceModel model = new CustomVoiceModel();
    model.setName(name);
    if (language != null) {
        model.setLanguage(language);
    }
    if (description != null) {
        model.setDescription(description);
    }

    final RequestBody body = RequestBody.create(HttpMediaType.JSON, model.toString());
    final Request request = RequestBuilder.post(PATH_CUSTOMIZATIONS).body(body).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(CustomVoiceModel.class));
  }

  /**
   * Updates an existing CustomVoiceModel with new name, new description, and new custom word translations. If no
   * translation with a given word exists, a new translation is created. Otherwise, the existing translation is updated.
   *
   * @param model the custom voice model object to be updated with new name, description, and words
   * @return the service call
   */
  public ServiceCall<Void> updateCustomVoiceModel(final CustomVoiceModel model) {
    Validator.notNull(model, "model cannot be null");
    Validator.notEmpty(model.getId(), "model id must not be empty");

    final String path = String.format(PATH_CUSTOMIZATION, model.getId());
    final RequestBody body = RequestBody.create(HttpMediaType.JSON, model.toString());
    final Request request = RequestBuilder.post(path).body(body).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes the given CustomVoiceModel.
   *
   * @param model the custom voice model object to be deleted
   * @return the service call
   */
  public ServiceCall<Void> deleteCustomVoiceModel(final CustomVoiceModel model) {
    Validator.notNull(model, "model cannot be null");
    Validator.notEmpty(model.getId(), "model id must not be empty");

    final Request request = RequestBuilder.delete(String.format(PATH_CUSTOMIZATION, model.getId())).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Gets all custom word translation for the given CustomVoiceModel.
   *
   * @param model the custom voice model object from which words are to be listed
   * @return a list of all CustomTranslations for the model
   */
  public ServiceCall<List<CustomTranslation>> getWords(final CustomVoiceModel model) {
    Validator.notNull(model.getId(), "model id cannot be null");

    final Request request = RequestBuilder.get(String.format(PATH_WORDS, model.getId())).build();
    final ResponseConverter<List<CustomTranslation>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_CUSTOM_TRANSLATIONS, WORDS);
    return createServiceCall(request, converter);
  }

  /**
   * Gets a custom word translation for the given CustomVoiceModel.
   *
   * @param model the custom voice model object from which a word is to be listed
   * @param word a word from the CustomVoiceModel
   * @return the translation of the word
   */
    public ServiceCall<CustomTranslation> getWord(final CustomVoiceModel model, final String word) {
    Validator.notNull(model, "model cannot be null");
    Validator.notEmpty(model.getId(), "model id must not be empty");
    Validator.notNull(word, "word cannot be null");

    final Request request = RequestBuilder.get(String.format(PATH_WORD, model.getId(), word)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(CustomTranslation.class));
  }

  /**
   * Adds or updates one or more custom word translations for a CustomVoiceModel. If no translation with a given word
   * exists, a new translation is created. Otherwise, the existing translation is updated.
   *
   * @param model the custom voice model object for which words are to be added or updated
   * @param translations the custom translations to be added or updated
   * @return the service call
   */
  public ServiceCall<Void> addWords(final CustomVoiceModel model, final CustomTranslation... translations) {
    Validator.notNull(model, "model cannot be null");
    Validator.notEmpty(model.getId(), "model id must not be empty");
    Validator.notNull(translations, "translations cannot be null");

    final String json = GSON.toJson(Collections.singletonMap("words", translations));
    final String path = String.format(PATH_WORDS, model.getId());
    final RequestBody body = RequestBody.create(HttpMediaType.JSON, json);
    final Request request = RequestBuilder.post(path).body(body).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Adds or updates a single custom word translation for a CustomVoiceModel. If no translation with the given word
   * exists, a new translation is created. Otherwise, the existing translation is updated.
   *
   * @param model the custom voice model object for which a word is to be added or updated
   * @param translation the translation to be added or updated
   * @return the service call
   */
  public ServiceCall<Void> addWord(final CustomVoiceModel model, final CustomTranslation translation) {
    Validator.notNull(model, "model cannot be null");
    Validator.notEmpty(model.getId(), "model id must not be empty");
    Validator.notNull(translation, "translation cannot be null");
    Validator.notEmpty(translation.getWord(), "translation word cannot be empty");

    final String path = String.format(PATH_WORD, model.getId(), translation.getWord());
    final RequestBody body = RequestBody.create(HttpMediaType.JSON, translation.toString());
    final Request request = RequestBuilder.put(path).body(body).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes a custom word based on a translation object.
   *
   * @param model the custom voice model object from which a word is to be deleted
   * @param translation the translation object to be deleted
   * @return the service call
   */
  public ServiceCall<Void> deleteWord(final CustomVoiceModel model, final CustomTranslation translation) {
    Validator.notNull(model, "model cannot be null");
    Validator.notEmpty(model.getId(), "model id must not be empty");
    Validator.notNull(translation, "translation cannot be null");
    Validator.notEmpty(translation.getWord(), "translation word must not be empty");

    return deleteWord(model, translation.getWord());
  }

  /**
   * Deletes a custom word based on a string.
   *
   * @param model the custom voice model object from which a word is to be deleted
   * @param word the word to be deleted
   * @return the service call
   */
  public ServiceCall<Void> deleteWord(final CustomVoiceModel model, final String word) {
    Validator.notNull(model, "model cannot be null");
    Validator.notEmpty(model.getId(), "model id must not be empty");
    Validator.notNull(word, "word cannot be null");

    final String path = String.format(PATH_WORD, model.getId(), word);
    final Request request = RequestBuilder.delete(path).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

}

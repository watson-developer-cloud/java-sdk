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
package com.ibm.watson.developer_cloud.text_to_speech.v1;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.*;
import com.ibm.watson.developer_cloud.util.*;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * The Text to Speech service uses IBM's speech synthesis capabilities to convert text to an audio
 * signal. The audio is streamed back to the client in a {@link InputStream}
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/watson/developercloud/text-to-speech.html"> Text
 *      to Speech</a>
 */
public class TextToSpeech extends WatsonService {

  private final static String URL = "https://stream.watsonplatform.net/text-to-speech/api";
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

  private static final Type TYPE_GET_VOICES = new TypeToken<List<Voice>>() {}.getType();
  private static final Type TYPE_VOICE_MODELS = new TypeToken<List<CustomVoiceModel>>() {}.getType();
  private static final Type TYPE_CUSTOM_TRANSLATIONS = new TypeToken<List<CustomTranslation>>() {}.getType();
  private static final Gson GSON = GsonSingleton.getGson();

  /**
   * Instantiates a new text to speech.
   */
  public TextToSpeech() {
    super(SERVICE_NAME);
    if (getEndPoint() == null || getEndPoint().isEmpty())
      setEndPoint(URL);
  }

  /**
   * Instantiates a new text to speech service by username and password.
   * @param username the username
   * @param password the password
   */
  public TextToSpeech(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Gets the voices.
   * 
   * @return the list of {@link Voice}
   */
  public ServiceCall<List<Voice>> getVoices() {
    final Request request = RequestBuilder.get(PATH_VOICES).build();
    ResponseConverter<List<Voice>> converter = ResponseConverterUtils.getGenericObject(TYPE_GET_VOICES, VOICES);
    return createServiceCall(request, converter);
  }

  /**
   *  Gets the voice based on a given name.
   *
   *  @param voiceName the voice name
   *  @return the {@link Voice}
   */
  public ServiceCall<Voice> getVoice(final String voiceName) {
    Validator.notNull(voiceName, "name can not be null");

    Request request = RequestBuilder.get(String.format(PATH_VOICE, voiceName)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Voice.class));
  }

  /**
   * Returns the phonetic pronunciation for the <code>word</code> specified.
   *
   * @param word The word for which the pronunciation is requested.
   * @param voice the voice to obtain the pronunciation for the specified word in the language of
   *        that voice.
   * @param phoneme the phoneme set in which to return the pronunciation
   * @return the word pronunciation
   * @see Pronunciation
   */
  public ServiceCall<Pronunciation> getPronunciation(String word, Voice voice, Phoneme phoneme) {
    final RequestBuilder requestBuilder = RequestBuilder.get(PATH_GET_PRONUNCIATION).query(TEXT, word);
    if (voice != null)
      requestBuilder.query(VOICE, voice.getName());
    if (phoneme != null)
      requestBuilder.query(FORMAT, phoneme);

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
    Validator.isTrue(text != null && !text.isEmpty(), "text cannot be null or empty");
    Validator.isTrue(voice != null, "voice cannot be null or empty");

    final RequestBuilder request = RequestBuilder.get(PATH_SYNTHESIZE);
    request.query(TEXT, text);
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
   * @param language
   *          the language (e.g. "en-us")
   * @return the VoiceModels
   */
  public ServiceCall<List<CustomVoiceModel>> getCustomVoiceModels(final String language) {
    Validator.notNull(language, "language can not be null");

    final Request request = RequestBuilder.get(PATH_CUSTOMIZATIONS).query(LANGUAGE, language).build();
    ResponseConverter<List<CustomVoiceModel>> converter = ResponseConverterUtils.getGenericObject(TYPE_VOICE_MODELS,
        CUSTOMIZATIONS);
    return createServiceCall(request, converter);
  }

  /**
   * Gets the meta data of a specific CustomVoiceModel.
   *
   * @param id
   *          the customization id of the CustomVoiceModel
   * @return the VoiceModel
   */
  public ServiceCall<CustomVoiceModel> getCustomVoiceModel(final String id) {
    Validator.notNull(id, "id can not be null");

    final Request request = RequestBuilder.get(String.format(PATH_CUSTOMIZATION, id)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(CustomVoiceModel.class));
  }

  /**
   * Saves a CustomVoiceModel. If the given model has an id, this service will
   * update an existing model. When no id is set, a new CustomVoiceModel is
   * created and the id field set.
   *
   * @param model
   *          the model to be saved
   * @return a reference to the given CustomVoiceModel. If a new
   *         CustomVoiceModel is created, the id field will be populated.
   */
  public ServiceCall<CustomVoiceModel> saveCustomVoiceModel(final CustomVoiceModel model) {
    final boolean isNew = model.getId() == null;
    final String path = isNew ? PATH_CUSTOMIZATIONS : String.format(PATH_CUSTOMIZATION, model.getId());

    final RequestBody body = RequestBody.create(HttpMediaType.JSON, model.toString());
    final Request request = RequestBuilder.post(path).body(body).build();

    return createServiceCall(request, new ResponseConverter<CustomVoiceModel>() {
      @Override
      public CustomVoiceModel convert(Response response) {
        CustomVoiceModel newModel = ResponseUtils.getObject(response, CustomVoiceModel.class);

        if (newModel != null && newModel.getId() != null) {
          model.setId(newModel.getId());
        }

        return model;
      }
    });
  }

  /**
   * Deletes the given CustomVoiceModel (requires a valid id to be set).
   *
   * @param model the model
   * @return the service call
   */
  public ServiceCall<Void> deleteCustomVoiceModel(CustomVoiceModel model) {
    Validator.notEmpty(model.getId(), "model id must not be empty");

    final Request request = RequestBuilder.delete(String.format(PATH_CUSTOMIZATION, model.getId())).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Gets all customized word translation of the given CustomVoiceModel.
   *
   * @param model
   *          the VoiceModel
   * @return a list of all CustomTranslations
   */
  public ServiceCall<List<CustomTranslation>> getWords(CustomVoiceModel model) {
    Validator.notNull(model.getId(), "model id can not be null");

    final Request request = RequestBuilder.get(String.format(PATH_WORDS, model.getId())).build();
    final ResponseConverter<List<CustomTranslation>> converter = ResponseConverterUtils
        .getGenericObject(TYPE_CUSTOM_TRANSLATIONS, WORDS);
    return createServiceCall(request, converter);
  }

  /**
   * Saves or updates custom word translations. If no translation with the
   * given word is existing, a new translation is created. Elsewise, the
   * existing translation is updated.
   *
   * @param model          the CustomVoiceModel
   * @param translations          the translations to be saved or updated
   * @return the service call
   */
  public ServiceCall<Void> saveWords(CustomVoiceModel model, CustomTranslation... translations) {
    Validator.notEmpty(model.getId(), "model id must not be empty");

    final String json = GSON.toJson(Collections.singletonMap("words", translations));
    final String path = String.format(PATH_WORDS, model.getId());
    final RequestBody body = RequestBody.create(HttpMediaType.JSON, json);
    final Request request = RequestBuilder.post(path).body(body).build();

    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes a custom word translation.
   *
   * @param model          the CustomVoiceModel
   * @param translation          the translation
   * @return the service call
   */
  public ServiceCall<Void> deleteWord(CustomVoiceModel model, CustomTranslation translation) {
    Validator.notEmpty(model.getId(), "model id must not be empty");
    Validator.notEmpty(translation.getWord(), "word must not be empty");

    final String path = String.format(PATH_WORD, model.getId(), RequestUtils.encode(translation.getWord()));
    final Request request = RequestBuilder.delete(path).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }
  
}

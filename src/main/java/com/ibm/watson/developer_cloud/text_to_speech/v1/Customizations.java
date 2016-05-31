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

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.ResponseUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * The Customizations service is a part of the Text to Speech API that allows
 * the creation of a customized dictionary of words and their pronunciation.
 * Users may manually specify the pronunciation of special terms with foreign
 * origins, personal or geographic names, and abbreviations and acronyms for
 * example.
 * 
 * <p>Use {@code new TextToSpeech().getCustomizations()} to instantiate this
 * service.</p>
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/text-to-speech/custom-intro.shtml">
 *      Customizations</a>
 *
 */
public class Customizations {

  private static final String PATH_CUSTOMIZATIONS = "/v1/customizations";
  private static final String PATH_CUSTOMIZATION = PATH_CUSTOMIZATIONS + "/%s";
  private static final String PATH_WORDS = PATH_CUSTOMIZATION + "/words";
  private static final String PATH_WORD = PATH_WORDS + "/%s";

  private static final Type TYPE_VOICE_MODELS = new TypeToken<List<CustomVoiceModel>>() {
  }.getType();
  private static final Type TYPE_CUSTOM_TRANSLATIONS = new TypeToken<List<CustomTranslation>>() {
  }.getType();

  private static final String CUSTOMIZATIONS = "customizations";
  private static final String LANGUAGE = "language";
  private static final String WORDS = "words";

  private static final Gson GSON = GsonSingleton.getGson();

  private final TextToSpeech service;

  /**
   * Instantiates a new Customizations service, which uses an existing
   * TextToSpeech service as proxy for API requests. You need to configure the
   * API key / username and password of the underlying TextToSpeech service.
   * 
   * @param service
   *          the TextToSpeech service to be used for API requests
   */
  protected Customizations(TextToSpeech service) {
    this.service = service;
  }

  /**
   * Gets all meta data of the CustomVoiceModels that you own.
   * 
   * @param language
   *          the language (e.g. "en-us")
   * @return the VoiceModels
   */
  public ServiceCall<List<CustomVoiceModel>> getVoiceModels(final String language) {
    Validator.notNull(language, "language can not be null");

    final Request request = RequestBuilder.get(PATH_CUSTOMIZATIONS).query(LANGUAGE, language).build();
    ResponseConverter<List<CustomVoiceModel>> converter = ResponseConverterUtils.getGenericObject(TYPE_VOICE_MODELS,
        CUSTOMIZATIONS);
    return service.createNewServiceCall(request, converter);
  }

  /**
   * Gets the meta data of a specific CustomVoiceModel.
   * 
   * @param id
   *          the customization id of the CustomVoiceModel
   * @return the VoiceModel
   */
  public ServiceCall<CustomVoiceModel> getVoiceModel(final String id) {
    Validator.notNull(id, "id can not be null");

    final Request request = RequestBuilder.get(String.format(PATH_CUSTOMIZATION, id)).build();
    return service.createNewServiceCall(request, ResponseConverterUtils.getObject(CustomVoiceModel.class));
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
  public ServiceCall<CustomVoiceModel> saveVoiceModel(final CustomVoiceModel model) {
    final boolean isNew = model.getId() == null;
    final String path = isNew ? PATH_CUSTOMIZATIONS : String.format(PATH_CUSTOMIZATION, model.getId());

    final RequestBody body = RequestBody.create(HttpMediaType.JSON, model.toString());
    final Request request = RequestBuilder.post(path).body(body).build();

    return service.createNewServiceCall(request, new ResponseConverter<CustomVoiceModel>() {
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
   */
  public ServiceCall<Void> deleteVoiceModel(CustomVoiceModel model) {
    Validator.notEmpty(model.getId(), "model id must not be empty");

    final Request request = RequestBuilder.delete(String.format(PATH_CUSTOMIZATION, model.getId())).build();
    return service.createNewServiceCall(request, ResponseConverterUtils.getVoid());
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
    ResponseConverter<List<CustomTranslation>> converter = ResponseConverterUtils
        .getGenericObject(TYPE_CUSTOM_TRANSLATIONS, WORDS);
    return service.createNewServiceCall(request, converter);
  }

  /**
   * Saves or updates a custom word translation. If no translation with the
   * given word is existing, a new translation is created. Elsewise, the
   * existing translation is updated.
   * 
   * @param model
   *          the VoiceModel
   * @param translation
   *          the translation to be saved or updated
   * @return
   */
  public ServiceCall<Void> saveWord(CustomVoiceModel model, CustomTranslation translation) {
    return saveWords(model, Arrays.asList(translation));
  }

  /**
   * Saves or updates multiple custom word translations.
   * 
   * @param model
   *          the CustomVoiceModel
   * @param translations
   *          the translations to be saved or updated
   * @return
   */
  public ServiceCall<Void> saveWords(CustomVoiceModel model, List<CustomTranslation> translations) {
    Validator.notEmpty(model.getId(), "model id must not be empty");

    final String json = GSON.toJson(Collections.singletonMap("words", translations));
    final String path = String.format(PATH_WORDS, model.getId());
    final RequestBody body = RequestBody.create(HttpMediaType.JSON, json);
    final Request request = RequestBuilder.post(path).body(body).build();

    return service.createNewServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Deletes a custom word translation.
   * 
   * @param model
   *          the CustomVoiceModel
   * @param translation
   *          the translation
   * @return
   */
  public ServiceCall<Void> deleteWord(CustomVoiceModel model, CustomTranslation translation) {
    Validator.notEmpty(model.getId(), "model id must not be empty");
    Validator.notEmpty(translation.getWord(), "word must not be empty");

    final String path = String.format(PATH_WORD, model.getId(), RequestUtils.encode(translation.getWord()));
    final Request request = RequestBuilder.delete(path).build();
    return service.createNewServiceCall(request, ResponseConverterUtils.getVoid());
  }
}

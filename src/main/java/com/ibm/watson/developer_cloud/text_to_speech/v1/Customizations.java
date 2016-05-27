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
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.VoiceModel;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.ResponseUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Customizations {

  private static final String PATH_CUSTOMIZATIONS = "/v1/customizations";
  private static final String PATH_CUSTOMIZATION = PATH_CUSTOMIZATIONS + "/%s";
  private static final String PATH_WORDS = PATH_CUSTOMIZATION + "/words";
  private static final String PATH_WORD = PATH_WORDS + "/%s";
  
  private static final Type TYPE_VOICE_MODELS = new TypeToken<List<VoiceModel>>() {}.getType();
  private static final Type TYPE_CUSTOM_TRANSLATIONS = new TypeToken<List<CustomTranslation>>() {}.getType();
  
  private static final String CUSTOMIZATIONS = "customizations";
  private static final String LANGUAGE = "language";
  private static final String WORDS = "words";

  private static final Gson GSON = GsonSingleton.getGson();
  
  private final TextToSpeech service;

  /**
   * Instantiates a new Customizations service, which uses an existing TextToSpeech service as proxy for
   * service calls.
   * 
   * @param service the TextToSpeech service to be used for API requests
   */
  protected Customizations(TextToSpeech service) {
    this.service = service;
  }

  public ServiceCall<List<VoiceModel>> getVoiceModels(final String language) {
    Validator.notNull(language, "language can not be null");

    final Request request = RequestBuilder.get(PATH_CUSTOMIZATIONS).query(LANGUAGE, language).build();
    ResponseConverter<List<VoiceModel>> converter = ResponseConverterUtils.getGenericObject(TYPE_VOICE_MODELS,
        CUSTOMIZATIONS);
    return service.createNewServiceCall(request, converter);
  }

  public ServiceCall<VoiceModel> getVoiceModel(final String id) {
    Validator.notNull(id, "id can not be null");

    final Request request = RequestBuilder.get(String.format(PATH_CUSTOMIZATION, id)).build();
    return service.createNewServiceCall(request, ResponseConverterUtils.getObject(VoiceModel.class));
  }

  public ServiceCall<VoiceModel> saveVoiceModel(final VoiceModel model) {
    final boolean isNew = model.getId() == null;
    final String path = isNew ? PATH_CUSTOMIZATIONS : String.format(PATH_CUSTOMIZATION, model.getId());

    final RequestBody body = RequestBody.create(HttpMediaType.JSON, model.toString());
    final Request request = RequestBuilder.post(path).body(body).build();
    
    return service.createNewServiceCall(request, new ResponseConverter<VoiceModel>() {
      @Override
      public VoiceModel convert(Response response) {
        VoiceModel newModel = ResponseUtils.getObject(response, VoiceModel.class);
        
        if (newModel != null && newModel.getId() != null) {
          model.setId(newModel.getId());
        }

        return model;
      }
    });
  }

  public ServiceCall<Void> deleteVoiceModel(VoiceModel model) {
    Validator.notEmpty(model.getId(), "model id must not be empty");

    final Request request = RequestBuilder.delete(String.format(PATH_CUSTOMIZATION, model.getId())).build();
    return service.createNewServiceCall(request, ResponseConverterUtils.getVoid());
  }

  public ServiceCall<List<CustomTranslation>> getWords(VoiceModel model) {
    Validator.notNull(model.getId(), "model id can not be null");

    final Request request = RequestBuilder.get(String.format(PATH_WORDS, model.getId())).build();
    ResponseConverter<List<CustomTranslation>> converter = ResponseConverterUtils
        .getGenericObject(TYPE_CUSTOM_TRANSLATIONS, WORDS);
    return service.createNewServiceCall(request, converter);
  }

  public ServiceCall<Void> saveWord(VoiceModel model, CustomTranslation word) {
    return saveWords(model, ImmutableList.of(word));
  }

  public ServiceCall<Void> saveWords(VoiceModel model, List<CustomTranslation> words) {
    Validator.notEmpty(model.getId(), "model id must not be empty");

    final String json = GSON.toJson(ImmutableMap.of("words", words));
    final String path = String.format(PATH_WORDS, model.getId());
    final RequestBody body = RequestBody.create(HttpMediaType.JSON, json);
    final Request request = RequestBuilder.post(path).body(body).build();
    
    return service.createNewServiceCall(request, ResponseConverterUtils.getVoid());
  }

  public ServiceCall<Void> deleteWord(VoiceModel model, CustomTranslation word) {
    Validator.notEmpty(model.getId(), "model id must not be empty");

    String path;

    try {
      path = String.format(PATH_WORD, model.getId(), URLEncoder.encode(word.getWord(), "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }

    final Request request = RequestBuilder.delete(path).build();
    return service.createNewServiceCall(request, ResponseConverterUtils.getVoid());
  }
}

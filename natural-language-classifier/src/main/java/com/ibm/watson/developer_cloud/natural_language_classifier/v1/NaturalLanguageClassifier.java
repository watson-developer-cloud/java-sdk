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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifierList;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.DeleteClassifierOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.GetClassifierOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ListClassifiersOptions;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * IBM Watson Natural Language Classifier uses machine learning algorithms to return the top matching predefined classes
 * for short text input. You create and train a classifier to connect predefined classes to example texts so that the
 * service can apply those classes to new inputs.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/natural-language-classifier.html">Natural Language
 *      Classifier</a>
 */
public class NaturalLanguageClassifier extends WatsonService {

  private static final String SERVICE_NAME = "natural_language_classifier";
  private static final String URL = "https://gateway.watsonplatform.net/natural-language-classifier/api";

  /**
   * Instantiates a new `NaturalLanguageClassifier`.
   *
   */
  public NaturalLanguageClassifier() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new `NaturalLanguageClassifier` with username and password.
   *
   * @param username the username
   * @param password the password
   */
  public NaturalLanguageClassifier(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Classify a phrase.
   *
   * Returns label information for the input. The status must be `Available` before you can use the classifier to
   * classify text.
   *
   * @param classifyOptions the {@link ClassifyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classification}
   */
  public ServiceCall<Classification> classify(ClassifyOptions classifyOptions) {
    Validator.notNull(classifyOptions, "classifyOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/classifiers/%s/classify", classifyOptions
        .classifierId()));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", classifyOptions.text());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classification.class));
  }

  /**
   * Create classifier.
   *
   * Sends data to create and train a classifier and returns information about the new classifier.
   *
   * @param createClassifierOptions the {@link CreateClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifier}
   */
  public ServiceCall<Classifier> createClassifier(CreateClassifierOptions createClassifierOptions) {
    Validator.notNull(createClassifierOptions, "createClassifierOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/classifiers");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody trainingMetadataBody = RequestUtils.inputStreamBody(createClassifierOptions.metadata(),
        "application/json");
    multipartBuilder.addFormDataPart("training_metadata", createClassifierOptions.metadataFilename(),
        trainingMetadataBody);
    RequestBody trainingDataBody = RequestUtils.inputStreamBody(createClassifierOptions.trainingData(), "text/csv");
    multipartBuilder.addFormDataPart("training_data", createClassifierOptions.trainingDataFilename(), trainingDataBody);
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classifier.class));
  }

  /**
   * Delete classifier.
   *
   * @param deleteClassifierOptions the {@link DeleteClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteClassifier(DeleteClassifierOptions deleteClassifierOptions) {
    Validator.notNull(deleteClassifierOptions, "deleteClassifierOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/classifiers/%s", deleteClassifierOptions
        .classifierId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get information about a classifier.
   *
   * Returns status and other information about a classifier.
   *
   * @param getClassifierOptions the {@link GetClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifier}
   */
  public ServiceCall<Classifier> getClassifier(GetClassifierOptions getClassifierOptions) {
    Validator.notNull(getClassifierOptions, "getClassifierOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/classifiers/%s", getClassifierOptions
        .classifierId()));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classifier.class));
  }

  /**
   * List classifiers.
   *
   * Returns an empty array if no classifiers are available.
   *
   * @param listClassifiersOptions the {@link ListClassifiersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ClassifierList}
   */
  public ServiceCall<ClassifierList> listClassifiers(ListClassifiersOptions listClassifiersOptions) {
    RequestBuilder builder = RequestBuilder.get("/v1/classifiers");
    if (listClassifiersOptions != null) {
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ClassifierList.class));
  }

  /**
   * List classifiers.
   *
   * Returns an empty array if no classifiers are available.
   *
   * @return a {@link ServiceCall} with a response type of {@link ClassifierList}
   */
  public ServiceCall<ClassifierList> listClassifiers() {
    return listClassifiers(null);
  }

}

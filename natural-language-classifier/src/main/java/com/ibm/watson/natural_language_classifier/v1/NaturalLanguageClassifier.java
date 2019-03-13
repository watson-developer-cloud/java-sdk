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
package com.ibm.watson.natural_language_classifier.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.natural_language_classifier.v1.model.ClassificationCollection;
import com.ibm.watson.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifierList;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifyCollectionOptions;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.natural_language_classifier.v1.model.CreateClassifierOptions;
import com.ibm.watson.natural_language_classifier.v1.model.DeleteClassifierOptions;
import com.ibm.watson.natural_language_classifier.v1.model.GetClassifierOptions;
import com.ibm.watson.natural_language_classifier.v1.model.ListClassifiersOptions;
import com.ibm.cloud.sdk.core.util.Validator;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * IBM Watson&trade; Natural Language Classifier uses machine learning algorithms to return the top matching predefined
 * classes for short text input. You create and train a classifier to connect predefined classes to example texts so
 * that the service can apply those classes to new inputs.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/natural-language-classifier.html">Natural Language
 *      Classifier</a>
 */
public class NaturalLanguageClassifier extends BaseService {

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
   * Instantiates a new `NaturalLanguageClassifier` with IAM. Note that if the access token is specified in the
   * iamOptions, you accept responsibility for managing the access token yourself. You must set a new access token
   * before this
   * one expires or after receiving a 401 error from the service. Failing to do so will result in authentication errors
   * after this token expires.
   *
   * @param iamOptions the options for authenticating through IAM
   */
  public NaturalLanguageClassifier(IamOptions iamOptions) {
    this();
    setIamCredentials(iamOptions);
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
    String[] pathSegments = { "v1/classifiers", "classify" };
    String[] pathParameters = { classifyOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=natural_language_classifier;service_version=v1;operation_id=classify");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", classifyOptions.text());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classification.class));
  }

  /**
   * Classify multiple phrases.
   *
   * Returns label information for multiple phrases. The status must be `Available` before you can use the classifier to
   * classify text.
   *
   * Note that classifying Japanese texts is a beta feature.
   *
   * @param classifyCollectionOptions the {@link ClassifyCollectionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ClassificationCollection}
   */
  public ServiceCall<ClassificationCollection> classifyCollection(ClassifyCollectionOptions classifyCollectionOptions) {
    Validator.notNull(classifyCollectionOptions, "classifyCollectionOptions cannot be null");
    String[] pathSegments = { "v1/classifiers", "classify_collection" };
    String[] pathParameters = { classifyCollectionOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=natural_language_classifier;service_version=v1;operation_id=classifyCollection");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("collection", GsonSingleton.getGson().toJsonTree(classifyCollectionOptions.collection()));
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ClassificationCollection.class));
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
    String[] pathSegments = { "v1/classifiers" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=natural_language_classifier;service_version=v1;operation_id=createClassifier");
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
    String[] pathSegments = { "v1/classifiers" };
    String[] pathParameters = { deleteClassifierOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=natural_language_classifier;service_version=v1;operation_id=deleteClassifier");
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
    String[] pathSegments = { "v1/classifiers" };
    String[] pathParameters = { getClassifierOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=natural_language_classifier;service_version=v1;operation_id=getClassifier");
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
    String[] pathSegments = { "v1/classifiers" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=natural_language_classifier;service_version=v1;operation_id=listClassifiers");
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

  /**
   * Classify.
   *
   * This method is here for backwards-compatibility with the other version of classify.
   *
   * @param classifierId the classifier ID
   * @param text the submitted phrase to classify
   * @return the classification of a phrase with a given classifier
   */
  public ServiceCall<Classification> classify(String classifierId, String text) {
    ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
        .classifierId(classifierId)
        .text(text)
        .build();
    return classify(classifyOptions);
  }

  /**
   * Create classifier.
   *
   * This method is here for backwards-compatibility with the old version of createClassifier.
   *
   * @param name the classifier name
   * @param language IETF primary language for the classifier. for example: 'en'
   * @param trainingData the set of questions and their "keys" used to adapt a system to a domain (the ground truth)
   * @return the classifier
   * @throws FileNotFoundException if the file could not be found
   */
  public ServiceCall<Classifier> createClassifier(String name, String language, File trainingData)
      throws FileNotFoundException {
    Map<String, String> metadataMap = new HashMap<>();
    metadataMap.put("name", name);
    metadataMap.put("language", language);
    String metadataString = GsonSingleton.getGson().toJson(metadataMap);

    CreateClassifierOptions createClassifierOptions = new CreateClassifierOptions.Builder()
        .metadata(new ByteArrayInputStream(metadataString.getBytes()))
        .trainingData(trainingData)
        .build();

    return createClassifier(createClassifierOptions);
  }

  /**
   * Delete classifier.
   *
   * This method is here for backwards-compatibility with the old version of deleteClassifier.
   *
   * @param classifierId the classifier ID
   * @return the service call
   */
  public ServiceCall<Void> deleteClassifier(String classifierId) {
    DeleteClassifierOptions deleteClassifierOptions = new DeleteClassifierOptions.Builder()
        .classifierId(classifierId)
        .build();

    return deleteClassifier(deleteClassifierOptions);
  }

  /**
   * Get information about a classifier.
   *
   * This method is here for backwards-compatibility with the old version of getClassifier.
   *
   * @param classifierId the classifier ID
   * @return the classifier
   */
  public ServiceCall<Classifier> getClassifier(String classifierId) {
    GetClassifierOptions getClassifierOptions = new GetClassifierOptions.Builder()
        .classifierId(classifierId)
        .build();

    return getClassifier(getClassifierOptions);
  }

  /**
   * List classifiers.
   *
   * This method is here for backwards-compatibility with the old version of getClassifiers, which has been renamed
   * to listClassifiers.
   *
   * @return the classifier list
   */
  public ServiceCall<ClassifierList> getClassifiers() {
    return listClassifiers();
  }
}

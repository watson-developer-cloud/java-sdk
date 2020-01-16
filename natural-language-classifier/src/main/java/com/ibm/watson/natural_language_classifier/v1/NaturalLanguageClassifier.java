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
package com.ibm.watson.natural_language_classifier.v1;

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
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * IBM Watson&trade; Natural Language Classifier uses machine learning algorithms to return the top matching predefined
 * classes for short text input. You create and train a classifier to connect predefined classes to example texts so
 * that the service can apply those classes to new inputs.
 *
 * @version v1
 * @see <a href="https://cloud.ibm.com/docs/services/natural-language-classifier/">Natural Language Classifier</a>
 */
public class NaturalLanguageClassifier extends BaseService {

  private static final String DEFAULT_SERVICE_NAME = "natural_language_classifier";

  private static final String DEFAULT_SERVICE_URL
      = "https://gateway.watsonplatform.net/natural-language-classifier/api";

  /**
   * Constructs a new `NaturalLanguageClassifier` client using the DEFAULT_SERVICE_NAME.
   *
   */
  public NaturalLanguageClassifier() {
    this(DEFAULT_SERVICE_NAME, ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs a new `NaturalLanguageClassifier` client with the DEFAULT_SERVICE_NAME
   * and the specified Authenticator.
   *
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public NaturalLanguageClassifier(Authenticator authenticator) {
    this(DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs a new `NaturalLanguageClassifier` client with the specified serviceName.
   *
   * @param serviceName The name of the service to configure.
   */
  public NaturalLanguageClassifier(String serviceName) {
    this(serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs a new `NaturalLanguageClassifier` client with the specified Authenticator
   * and serviceName.
   *
   * @param serviceName The name of the service to configure.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public NaturalLanguageClassifier(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    this.configureService(serviceName);
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
    com.ibm.cloud.sdk.core.util.Validator.notNull(classifyOptions,
        "classifyOptions cannot be null");
    String[] pathSegments = { "v1/classifiers", "classify" };
    String[] pathParameters = { classifyOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "classify");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", classifyOptions.text());
    builder.bodyJson(contentJson);
    ResponseConverter<Classification> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Classification>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
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
    com.ibm.cloud.sdk.core.util.Validator.notNull(classifyCollectionOptions,
        "classifyCollectionOptions cannot be null");
    String[] pathSegments = { "v1/classifiers", "classify_collection" };
    String[] pathParameters = { classifyCollectionOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "classifyCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("collection", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(
        classifyCollectionOptions.collection()));
    builder.bodyJson(contentJson);
    ResponseConverter<ClassificationCollection> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<ClassificationCollection>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
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
    com.ibm.cloud.sdk.core.util.Validator.notNull(createClassifierOptions,
        "createClassifierOptions cannot be null");
    String[] pathSegments = { "v1/classifiers" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "createClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody trainingMetadataBody = RequestUtils.inputStreamBody(createClassifierOptions.trainingMetadata(),
        "application/json");
    multipartBuilder.addFormDataPart("training_metadata", "filename", trainingMetadataBody);
    okhttp3.RequestBody trainingDataBody = RequestUtils.inputStreamBody(createClassifierOptions.trainingData(),
        "text/csv");
    multipartBuilder.addFormDataPart("training_data", "filename", trainingDataBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<Classifier> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Classifier>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
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
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "listClassifiers");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listClassifiersOptions != null) {

    }
    ResponseConverter<ClassifierList> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<ClassifierList>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
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
   * Get information about a classifier.
   *
   * Returns status and other information about a classifier.
   *
   * @param getClassifierOptions the {@link GetClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifier}
   */
  public ServiceCall<Classifier> getClassifier(GetClassifierOptions getClassifierOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getClassifierOptions,
        "getClassifierOptions cannot be null");
    String[] pathSegments = { "v1/classifiers" };
    String[] pathParameters = { getClassifierOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "getClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Classifier> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Classifier>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete classifier.
   *
   * @param deleteClassifierOptions the {@link DeleteClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteClassifier(DeleteClassifierOptions deleteClassifierOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteClassifierOptions,
        "deleteClassifierOptions cannot be null");
    String[] pathSegments = { "v1/classifiers" };
    String[] pathParameters = { deleteClassifierOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "deleteClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}

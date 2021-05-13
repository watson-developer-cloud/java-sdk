/*
 * (C) Copyright IBM Corp. 2021.
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

/*
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-902c9336-20210513-140138
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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * IBM Watson&amp;trade; Natural Language Classifier uses machine learning algorithms to return the
 * top matching predefined classes for short text input. You create and train a classifier to
 * connect predefined classes to example texts so that the service can apply those classes to new
 * inputs.
 *
 * @version v1
 * @see <a href="https://cloud.ibm.com/docs/natural-language-classifier">Natural Language
 *     Classifier</a>
 */
public class NaturalLanguageClassifier extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "natural_language_classifier";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.natural-language-classifier.watson.cloud.ibm.com";

  /**
   * Constructs an instance of the `NaturalLanguageClassifier` client. The default service name is
   * used to configure the client instance.
   */
  public NaturalLanguageClassifier() {
    this(
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `NaturalLanguageClassifier` client. The default service name and
   * specified authenticator are used to configure the client instance.
   *
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public NaturalLanguageClassifier(Authenticator authenticator) {
    this(DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `NaturalLanguageClassifier` client. The specified service name is
   * used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   */
  public NaturalLanguageClassifier(String serviceName) {
    this(serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `NaturalLanguageClassifier` client. The specified service name
   * and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public NaturalLanguageClassifier(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    this.configureService(serviceName);
  }

  /**
   * Classify a phrase.
   *
   * <p>Returns label information for the input. The status must be `Available` before you can use
   * the classifier to classify text.
   *
   * @param classifyOptions the {@link ClassifyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Classification}
   */
  public ServiceCall<Classification> classify(ClassifyOptions classifyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        classifyOptions, "classifyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("classifier_id", classifyOptions.classifierId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/classifiers/{classifier_id}/classify", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "classify");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", classifyOptions.text());
    builder.bodyJson(contentJson);
    ResponseConverter<Classification> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Classification>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Classify multiple phrases.
   *
   * <p>Returns label information for multiple phrases. The status must be `Available` before you
   * can use the classifier to classify text.
   *
   * <p>Note that classifying Japanese texts is a beta feature.
   *
   * @param classifyCollectionOptions the {@link ClassifyCollectionOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link ClassificationCollection}
   */
  public ServiceCall<ClassificationCollection> classifyCollection(
      ClassifyCollectionOptions classifyCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        classifyCollectionOptions, "classifyCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("classifier_id", classifyCollectionOptions.classifierId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/classifiers/{classifier_id}/classify_collection",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "classifyCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add(
        "collection",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(classifyCollectionOptions.collection()));
    builder.bodyJson(contentJson);
    ResponseConverter<ClassificationCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ClassificationCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create classifier.
   *
   * <p>Sends data to create and train a classifier and returns information about the new
   * classifier.
   *
   * @param createClassifierOptions the {@link CreateClassifierOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Classifier}
   */
  public ServiceCall<Classifier> createClassifier(CreateClassifierOptions createClassifierOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createClassifierOptions, "createClassifierOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/classifiers"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "createClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody trainingMetadataBody =
        RequestUtils.inputStreamBody(
            createClassifierOptions.trainingMetadata(), "application/json");
    multipartBuilder.addFormDataPart("training_metadata", "filename", trainingMetadataBody);
    okhttp3.RequestBody trainingDataBody =
        RequestUtils.inputStreamBody(createClassifierOptions.trainingData(), "text/csv");
    multipartBuilder.addFormDataPart("training_data", "filename", trainingDataBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<Classifier> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Classifier>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List classifiers.
   *
   * <p>Returns an empty array if no classifiers are available.
   *
   * @param listClassifiersOptions the {@link ListClassifiersOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link ClassifierList}
   */
  public ServiceCall<ClassifierList> listClassifiers(
      ListClassifiersOptions listClassifiersOptions) {
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/classifiers"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "listClassifiers");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ClassifierList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ClassifierList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List classifiers.
   *
   * <p>Returns an empty array if no classifiers are available.
   *
   * @return a {@link ServiceCall} with a result of type {@link ClassifierList}
   */
  public ServiceCall<ClassifierList> listClassifiers() {
    return listClassifiers(null);
  }

  /**
   * Get information about a classifier.
   *
   * <p>Returns status and other information about a classifier.
   *
   * @param getClassifierOptions the {@link GetClassifierOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Classifier}
   */
  public ServiceCall<Classifier> getClassifier(GetClassifierOptions getClassifierOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getClassifierOptions, "getClassifierOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("classifier_id", getClassifierOptions.classifierId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/classifiers/{classifier_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "getClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Classifier> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Classifier>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete classifier.
   *
   * @param deleteClassifierOptions the {@link DeleteClassifierOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteClassifier(DeleteClassifierOptions deleteClassifierOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteClassifierOptions, "deleteClassifierOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("classifier_id", deleteClassifierOptions.classifierId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/classifiers/{classifier_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural_language_classifier", "v1", "deleteClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }
}

/*
 * (C) Copyright IBM Corp. 2020.
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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-7cc05500-20201106-154555
 */

package com.ibm.watson.visual_recognition.v3;

import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.Classifier;
import com.ibm.watson.visual_recognition.v3.model.Classifiers;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.DeleteClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.DeleteUserDataOptions;
import com.ibm.watson.visual_recognition.v3.model.GetClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.GetCoreMlModelOptions;
import com.ibm.watson.visual_recognition.v3.model.ListClassifiersOptions;
import com.ibm.watson.visual_recognition.v3.model.UpdateClassifierOptions;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * The IBM Watson&amp;trade; Visual Recognition service uses deep learning algorithms to identify
 * scenes and objects in images that you upload to the service. You can create and train a custom
 * classifier to identify subjects that suit your needs.
 *
 * @version v3
 * @see <a href="https://cloud.ibm.com/docs/visual-recognition">Visual Recognition</a>
 */
public class VisualRecognition extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "visual_recognition";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.visual-recognition.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `VisualRecognition` client. The default service name is used to
   * configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2018-03-19`.
   */
  public VisualRecognition(String version) {
    this(
        version,
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `VisualRecognition` client. The default service name and
   * specified authenticator are used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2018-03-19`.
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public VisualRecognition(String version, Authenticator authenticator) {
    this(version, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `VisualRecognition` client. The specified service name is used to
   * configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2018-03-19`.
   * @param serviceName the service name to be used when configuring the client instance
   */
  public VisualRecognition(String version, String serviceName) {
    this(version, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `VisualRecognition` client. The specified service name and
   * authenticator are used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2018-03-19`.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public VisualRecognition(String version, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setVersion(version);
    this.configureService(serviceName);
  }

  /**
   * Gets the version.
   *
   * <p>Release date of the API version you want to use. Specify dates in YYYY-MM-DD format. The
   * current version is `2018-03-19`.
   *
   * @return the version
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(final String version) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(version, "version cannot be empty.");
    this.version = version;
  }

  /**
   * Classify images.
   *
   * <p>Classify images with built-in or custom classifiers.
   *
   * @param classifyOptions the {@link ClassifyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ClassifiedImages}
   */
  public ServiceCall<ClassifiedImages> classify(ClassifyOptions classifyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        classifyOptions, "classifyOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (classifyOptions.imagesFile() != null)
            || (classifyOptions.url() != null)
            || (classifyOptions.threshold() != null)
            || (classifyOptions.owners() != null)
            || (classifyOptions.classifierIds() != null),
        "At least one of imagesFile, url, threshold, owners, or classifierIds must be supplied.");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/classify"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v3", "classify");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (classifyOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", classifyOptions.acceptLanguage());
    }
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (classifyOptions.imagesFile() != null) {
      okhttp3.RequestBody imagesFileBody =
          RequestUtils.inputStreamBody(
              classifyOptions.imagesFile(), classifyOptions.imagesFileContentType());
      multipartBuilder.addFormDataPart(
          "images_file", classifyOptions.imagesFilename(), imagesFileBody);
    }
    if (classifyOptions.url() != null) {
      multipartBuilder.addFormDataPart("url", classifyOptions.url());
    }
    if (classifyOptions.threshold() != null) {
      multipartBuilder.addFormDataPart("threshold", String.valueOf(classifyOptions.threshold()));
    }
    if (classifyOptions.owners() != null) {
      multipartBuilder.addFormDataPart("owners", RequestUtils.join(classifyOptions.owners(), ","));
    }
    if (classifyOptions.classifierIds() != null) {
      multipartBuilder.addFormDataPart(
          "classifier_ids", RequestUtils.join(classifyOptions.classifierIds(), ","));
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<ClassifiedImages> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ClassifiedImages>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Classify images.
   *
   * <p>Classify images with built-in or custom classifiers.
   *
   * @return a {@link ServiceCall} with a result of type {@link ClassifiedImages}
   */
  public ServiceCall<ClassifiedImages> classify() {
    return classify(null);
  }

  /**
   * Create a classifier.
   *
   * <p>Train a new multi-faceted classifier on the uploaded image data. Create your custom
   * classifier with positive or negative example training images. Include at least two sets of
   * examples, either two positive example files or one positive and one negative file. You can
   * upload a maximum of 256 MB per call.
   *
   * <p>**Tips when creating:**
   *
   * <p>- If you set the **X-Watson-Learning-Opt-Out** header parameter to `true` when you create a
   * classifier, the example training images are not stored. Save your training images locally. For
   * more information, see [Data collection](#data-collection).
   *
   * <p>- Encode all names in UTF-8 if they contain non-ASCII characters (.zip and image file names,
   * and classifier and class names). The service assumes UTF-8 encoding if it encounters non-ASCII
   * characters.
   *
   * @param createClassifierOptions the {@link CreateClassifierOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Classifier}
   */
  public ServiceCall<Classifier> createClassifier(CreateClassifierOptions createClassifierOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createClassifierOptions, "createClassifierOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/classifiers"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v3", "createClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("name", createClassifierOptions.name());
    for (Map.Entry<String, InputStream> entry :
        createClassifierOptions.positiveExamples().entrySet()) {
      String partName = String.format("%s_positive_examples", entry.getKey());
      okhttp3.RequestBody part =
          RequestUtils.inputStreamBody(entry.getValue(), "application/octet-stream");
      multipartBuilder.addFormDataPart(partName, entry.getKey() + ".zip", part);
    }
    if (createClassifierOptions.negativeExamples() != null) {
      okhttp3.RequestBody negativeExamplesBody =
          RequestUtils.inputStreamBody(
              createClassifierOptions.negativeExamples(), "application/octet-stream");
      String negativeExamplesFilename = createClassifierOptions.negativeExamplesFilename();
      if (!negativeExamplesFilename.contains(".")) {
        negativeExamplesFilename += ".zip";
      }
      multipartBuilder.addFormDataPart(
          "negative_examples", negativeExamplesFilename, negativeExamplesBody);
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<Classifier> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Classifier>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a list of classifiers.
   *
   * @param listClassifiersOptions the {@link ListClassifiersOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Classifiers}
   */
  public ServiceCall<Classifiers> listClassifiers(ListClassifiersOptions listClassifiersOptions) {
    if (listClassifiersOptions == null) {
      listClassifiersOptions = new ListClassifiersOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/classifiers"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v3", "listClassifiers");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listClassifiersOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(listClassifiersOptions.verbose()));
    }
    ResponseConverter<Classifiers> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Classifiers>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a list of classifiers.
   *
   * @return a {@link ServiceCall} with a result of type {@link Classifiers}
   */
  public ServiceCall<Classifiers> listClassifiers() {
    return listClassifiers(null);
  }

  /**
   * Retrieve classifier details.
   *
   * <p>Retrieve information about a custom classifier.
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
                getServiceUrl(), "/v3/classifiers/{classifier_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v3", "getClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Classifier> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Classifier>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a classifier.
   *
   * <p>Update a custom classifier by adding new positive or negative classes or by adding new
   * images to existing classes. You must supply at least one set of positive or negative examples.
   * For details, see [Updating custom
   * classifiers](https://cloud.ibm.com/docs/visual-recognition?topic=visual-recognition-customizing#updating-custom-classifiers).
   *
   * <p>Encode all names in UTF-8 if they contain non-ASCII characters (.zip and image file names,
   * and classifier and class names). The service assumes UTF-8 encoding if it encounters non-ASCII
   * characters.
   *
   * <p>**Tips about retraining:**
   *
   * <p>- You can't update the classifier if the **X-Watson-Learning-Opt-Out** header parameter was
   * set to `true` when the classifier was created. Training images are not stored in that case.
   * Instead, create another classifier. For more information, see [Data
   * collection](#data-collection).
   *
   * <p>- Don't make retraining calls on a classifier until the status is ready. When you submit
   * retraining requests in parallel, the last request overwrites the previous requests. The
   * `retrained` property shows the last time the classifier retraining finished.
   *
   * @param updateClassifierOptions the {@link UpdateClassifierOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Classifier}
   */
  public ServiceCall<Classifier> updateClassifier(UpdateClassifierOptions updateClassifierOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateClassifierOptions, "updateClassifierOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (updateClassifierOptions.positiveExamples() != null)
            || (updateClassifierOptions.negativeExamples() != null),
        "At least one of positiveExamples or negativeExamples must be supplied.");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("classifier_id", updateClassifierOptions.classifierId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v3/classifiers/{classifier_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v3", "updateClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (updateClassifierOptions.positiveExamples() != null) {
      for (Map.Entry<String, InputStream> entry :
          updateClassifierOptions.positiveExamples().entrySet()) {
        String partName = String.format("%s_positive_examples", entry.getKey());
        okhttp3.RequestBody part =
            RequestUtils.inputStreamBody(entry.getValue(), "application/octet-stream");
        multipartBuilder.addFormDataPart(partName, entry.getKey(), part);
      }
    }
    if (updateClassifierOptions.negativeExamples() != null) {
      okhttp3.RequestBody negativeExamplesBody =
          RequestUtils.inputStreamBody(
              updateClassifierOptions.negativeExamples(), "application/octet-stream");
      multipartBuilder.addFormDataPart(
          "negative_examples",
          updateClassifierOptions.negativeExamplesFilename(),
          negativeExamplesBody);
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<Classifier> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Classifier>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a classifier.
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
                getServiceUrl(), "/v3/classifiers/{classifier_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v3", "deleteClassifier");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a Core ML model of a classifier.
   *
   * <p>Download a Core ML model file (.mlmodel) of a custom classifier that returns
   * &lt;tt&gt;"core_ml_enabled": true&lt;/tt&gt; in the classifier details.
   *
   * @param getCoreMlModelOptions the {@link GetCoreMlModelOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getCoreMlModel(GetCoreMlModelOptions getCoreMlModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCoreMlModelOptions, "getCoreMlModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("classifier_id", getCoreMlModelOptions.classifierId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v3/classifiers/{classifier_id}/core_ml_model", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v3", "getCoreMlModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/octet-stream");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete labeled data.
   *
   * <p>Deletes all data associated with a specified customer ID. The method has no effect if no
   * data is associated with the customer ID.
   *
   * <p>You associate a customer ID with data by passing the `X-Watson-Metadata` header with a
   * request that passes data. For more information about personal data and customer IDs, see
   * [Information
   * security](https://cloud.ibm.com/docs/visual-recognition?topic=visual-recognition-information-security).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/user_data"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v3", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("customer_id", String.valueOf(deleteUserDataOptions.customerId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }
}

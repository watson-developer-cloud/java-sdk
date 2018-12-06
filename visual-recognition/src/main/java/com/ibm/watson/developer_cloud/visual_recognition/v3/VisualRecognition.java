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
package com.ibm.watson.developer_cloud.visual_recognition.v3;

import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifiers;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DeleteClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DeleteUserDataOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.GetClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.GetCoreMlModelOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ListClassifiersOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.UpdateClassifierOptions;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.InputStream;
import java.util.Map;

/**
 * The IBM Watson&trade; Visual Recognition service uses deep learning algorithms to identify scenes, objects, and faces
 * in images you upload to the service. You can create and train a custom classifier to identify subjects that suit
 * your needs.
 *
 * @version v3
 * @see <a href="http://www.ibm.com/watson/developercloud/visual-recognition.html">Visual Recognition</a>
 */
public class VisualRecognition extends WatsonService {

  private static final String SERVICE_NAME = "visual_recognition";
  private static final String URL = "https://gateway.watsonplatform.net/visual-recognition/api";

  private String versionDate;

  /**
   * Instantiates a new `VisualRecognition`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public VisualRecognition(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `VisualRecognition` with API Key.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param apiKey the API Key
   * @deprecated This form of authentication is deprecated and will be removed in the next major release. Please
   *             authenticate using IAM credentials, using either the (String, IamOptions) constructor or with the
   *             setIamCredentials() method.
   */
  public VisualRecognition(String versionDate, String apiKey) {
    this(versionDate);
    setApiKey(apiKey);
  }

  /*
   * (non-Javadoc)
   */
  @Override
  protected void setAuthentication(okhttp3.Request.Builder builder) {
    if ((getUsername() != null && getPassword() != null) || isTokenManagerSet()) {
      super.setAuthentication(builder);
    } else if (getApiKey() != null) {
      addApiKeyQueryParameter(builder, getApiKey());
    } else {
      throw new IllegalArgumentException(
          "Credentials need to be specified. Use setApiKey(), setIamCredentials(), or setUsernameAndPassword().");
    }
  }

  /**
   * Adds the API key as a query parameter to the request URL.
   *
   * @param builder builder for the current request
   * @param apiKey API key to be added
   */
  private void addApiKeyQueryParameter(okhttp3.Request.Builder builder, String apiKey) {
    final okhttp3.HttpUrl url = okhttp3.HttpUrl.parse(builder.build().url().toString());

    if ((url.query() == null) || url.query().isEmpty()) {
      builder.url(builder.build().url() + "?api_key=" + apiKey);
    } else {
      builder.url(builder.build().url() + "&api_key=" + apiKey);
    }
  }

  /**
   * Instantiates a new `VisualRecognition` with IAM. Note that if the access token is specified in the
   * iamOptions, you accept responsibility for managing the access token yourself. You must set a new access token
   * before this
   * one expires or after receiving a 401 error from the service. Failing to do so will result in authentication errors
   * after this token expires.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param iamOptions the options for authenticating through IAM
   */
  public VisualRecognition(String versionDate, IamOptions iamOptions) {
    this(versionDate);
    setIamCredentials(iamOptions);
  }

  /**
   * Classify images.
   *
   * Classify images with built-in or custom classifiers.
   *
   * @param classifyOptions the {@link ClassifyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ClassifiedImages}
   */
  public ServiceCall<ClassifiedImages> classify(ClassifyOptions classifyOptions) {
    Validator.notNull(classifyOptions, "classifyOptions cannot be null");
    Validator.isTrue((classifyOptions.imagesFile() != null)
            || (classifyOptions.url() != null)
            || (classifyOptions.threshold() != null)
            || (classifyOptions.owners() != null)
            || (classifyOptions.classifierIds() != null)
            || (classifyOptions.parameters() != null),
        "At least one of imagesFile, url, threshold, owners, classifierIds, or parameters must be supplied.");
    String[] pathSegments = { "v3/classify" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    if (classifyOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", classifyOptions.acceptLanguage());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (classifyOptions.imagesFile() != null) {
      RequestBody imagesFileBody = RequestUtils.inputStreamBody(classifyOptions.imagesFile(), classifyOptions
          .imagesFileContentType());
      multipartBuilder.addFormDataPart("images_file", classifyOptions.imagesFilename(), imagesFileBody);
    }
    if (classifyOptions.parameters() != null) {
      multipartBuilder.addFormDataPart("parameters", classifyOptions.parameters());
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
      multipartBuilder.addFormDataPart("classifier_ids", RequestUtils.join(classifyOptions.classifierIds(), ","));
    }
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ClassifiedImages.class));
  }

  /**
   * Classify images.
   *
   * Classify images with built-in or custom classifiers.
   *
   * @return a {@link ServiceCall} with a response type of {@link ClassifiedImages}
   */
  public ServiceCall<ClassifiedImages> classify() {
    return classify(null);
  }

  /**
   * Detect faces in images.
   *
   * **Important:** On April 2, 2018, the identity information in the response to calls to the Face model was removed.
   * The identity information refers to the `name` of the person, `score`, and `type_hierarchy` knowledge graph. For
   * details about the enhanced Face model, see the [Release
   * notes](https://console.bluemix.net/docs/services/visual-recognition/release-notes.html#2april2018).
   *
   * Analyze and get data about faces in images. Responses can include estimated age and gender. This feature uses a
   * built-in model, so no training is necessary. The Detect faces method does not support general biometric facial
   * recognition.
   *
   * Supported image formats include .gif, .jpg, .png, and .tif. The maximum image size is 10 MB. The minimum
   * recommended pixel density is 32X32 pixels per inch.
   *
   * @param detectFacesOptions the {@link DetectFacesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DetectedFaces}
   */
  public ServiceCall<DetectedFaces> detectFaces(DetectFacesOptions detectFacesOptions) {
    Validator.notNull(detectFacesOptions, "detectFacesOptions cannot be null");
    Validator.isTrue((detectFacesOptions.imagesFile() != null)
            || (detectFacesOptions.url() != null)
            || (detectFacesOptions.parameters() != null),
        "At least one of imagesFile, url, or parameters must be supplied.");
    String[] pathSegments = { "v3/detect_faces" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (detectFacesOptions.imagesFile() != null) {
      RequestBody imagesFileBody = RequestUtils.inputStreamBody(detectFacesOptions.imagesFile(), detectFacesOptions
          .imagesFileContentType());
      multipartBuilder.addFormDataPart("images_file", detectFacesOptions.imagesFilename(), imagesFileBody);
    }
    if (detectFacesOptions.parameters() != null) {
      multipartBuilder.addFormDataPart("parameters", detectFacesOptions.parameters());
    }
    if (detectFacesOptions.url() != null) {
      multipartBuilder.addFormDataPart("url", detectFacesOptions.url());
    }
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DetectedFaces.class));
  }

  /**
   * Detect faces in images.
   *
   * **Important:** On April 2, 2018, the identity information in the response to calls to the Face model was removed.
   * The identity information refers to the `name` of the person, `score`, and `type_hierarchy` knowledge graph. For
   * details about the enhanced Face model, see the [Release
   * notes](https://console.bluemix.net/docs/services/visual-recognition/release-notes.html#2april2018).
   *
   * Analyze and get data about faces in images. Responses can include estimated age and gender. This feature uses a
   * built-in model, so no training is necessary. The Detect faces method does not support general biometric facial
   * recognition.
   *
   * Supported image formats include .gif, .jpg, .png, and .tif. The maximum image size is 10 MB. The minimum
   * recommended pixel density is 32X32 pixels per inch.
   *
   * @return a {@link ServiceCall} with a response type of {@link DetectedFaces}
   */
  public ServiceCall<DetectedFaces> detectFaces() {
    return detectFaces(null);
  }

  /**
   * Create a classifier.
   *
   * Train a new multi-faceted classifier on the uploaded image data. Create your custom classifier with positive or
   * negative examples. Include at least two sets of examples, either two positive example files or one positive and one
   * negative file. You can upload a maximum of 256 MB per call.
   *
   * Encode all names in UTF-8 if they contain non-ASCII characters (.zip and image file names, and classifier and class
   * names). The service assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * @param createClassifierOptions the {@link CreateClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifier}
   */
  public ServiceCall<Classifier> createClassifier(CreateClassifierOptions createClassifierOptions) {
    Validator.notNull(createClassifierOptions, "createClassifierOptions cannot be null");
    String[] pathSegments = { "v3/classifiers" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("name", createClassifierOptions.name());
    for (Map.Entry<String, InputStream> entry : createClassifierOptions.positiveExamples().entrySet()) {
      String partName = String.format("%s_positive_examples", entry.getKey());
      String fileName = createClassifierOptions.positiveExamplesFilename() != null ? createClassifierOptions
          .positiveExamplesFilename().get(entry.getKey()) : null;
      RequestBody part = RequestUtils.inputStreamBody(entry.getValue(), "application/octet-stream");
      multipartBuilder.addFormDataPart(partName, fileName, part);
    }
    if (createClassifierOptions.negativeExamples() != null) {
      RequestBody negativeExamplesBody = RequestUtils.inputStreamBody(createClassifierOptions.negativeExamples(),
          "application/octet-stream");
      multipartBuilder.addFormDataPart("negative_examples", createClassifierOptions.negativeExamplesFilename(),
          negativeExamplesBody);
    }
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classifier.class));
  }

  /**
   * Delete a classifier.
   *
   * @param deleteClassifierOptions the {@link DeleteClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteClassifier(DeleteClassifierOptions deleteClassifierOptions) {
    Validator.notNull(deleteClassifierOptions, "deleteClassifierOptions cannot be null");
    String[] pathSegments = { "v3/classifiers" };
    String[] pathParameters = { deleteClassifierOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Retrieve classifier details.
   *
   * Retrieve information about a custom classifier.
   *
   * @param getClassifierOptions the {@link GetClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifier}
   */
  public ServiceCall<Classifier> getClassifier(GetClassifierOptions getClassifierOptions) {
    Validator.notNull(getClassifierOptions, "getClassifierOptions cannot be null");
    String[] pathSegments = { "v3/classifiers" };
    String[] pathParameters = { getClassifierOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classifier.class));
  }

  /**
   * Retrieve a list of classifiers.
   *
   * @param listClassifiersOptions the {@link ListClassifiersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifiers}
   */
  public ServiceCall<Classifiers> listClassifiers(ListClassifiersOptions listClassifiersOptions) {
    String[] pathSegments = { "v3/classifiers" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    if (listClassifiersOptions != null) {
      if (listClassifiersOptions.verbose() != null) {
        builder.query("verbose", String.valueOf(listClassifiersOptions.verbose()));
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classifiers.class));
  }

  /**
   * Retrieve a list of classifiers.
   *
   * @return a {@link ServiceCall} with a response type of {@link Classifiers}
   */
  public ServiceCall<Classifiers> listClassifiers() {
    return listClassifiers(null);
  }

  /**
   * Update a classifier.
   *
   * Update a custom classifier by adding new positive or negative classes (examples) or by adding new images to
   * existing classes. You must supply at least one set of positive or negative examples. For details, see [Updating
   * custom
   * classifiers]
   * (https://console.bluemix.net/docs/services/visual-recognition/customizing.html#updating-custom-classifiers).
   *
   * Encode all names in UTF-8 if they contain non-ASCII characters (.zip and image file names, and classifier and class
   * names). The service assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * **Tip:** Don't make retraining calls on a classifier until the status is ready. When you submit retraining requests
   * in parallel, the last request overwrites the previous requests. The retrained property shows the last time the
   * classifier retraining finished.
   *
   * @param updateClassifierOptions the {@link UpdateClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifier}
   */
  public ServiceCall<Classifier> updateClassifier(UpdateClassifierOptions updateClassifierOptions) {
    Validator.notNull(updateClassifierOptions, "updateClassifierOptions cannot be null");
    Validator.isTrue((updateClassifierOptions.positiveExamples() != null) || (updateClassifierOptions
        .negativeExamples() != null), "At least one of positiveExamples or negativeExamples must be supplied.");
    String[] pathSegments = { "v3/classifiers" };
    String[] pathParameters = { updateClassifierOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (updateClassifierOptions.positiveExamples() != null) {
      for (Map.Entry<String, InputStream> entry : updateClassifierOptions.positiveExamples().entrySet()) {
        String partName = String.format("%s_positive_examples", entry.getKey());
        String fileName = updateClassifierOptions.positiveExamplesFilename() != null ? updateClassifierOptions
            .positiveExamplesFilename().get(entry.getKey()) : null;
        RequestBody part = RequestUtils.inputStreamBody(entry.getValue(), "application/octet-stream");
        multipartBuilder.addFormDataPart(partName, fileName, part);
      }
    }
    if (updateClassifierOptions.negativeExamples() != null) {
      RequestBody negativeExamplesBody = RequestUtils.inputStreamBody(updateClassifierOptions.negativeExamples(),
          "application/octet-stream");
      multipartBuilder.addFormDataPart("negative_examples", updateClassifierOptions.negativeExamplesFilename(),
          negativeExamplesBody);
    }
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classifier.class));
  }

  /**
   * Retrieve a Core ML model of a classifier.
   *
   * Download a Core ML model file (.mlmodel) of a custom classifier that returns <tt>\"core_ml_enabled\": true</tt> in
   * the classifier details.
   *
   * @param getCoreMlModelOptions the {@link GetCoreMlModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link InputStream}
   */
  public ServiceCall<InputStream> getCoreMlModel(GetCoreMlModelOptions getCoreMlModelOptions) {
    Validator.notNull(getCoreMlModelOptions, "getCoreMlModelOptions cannot be null");
    String[] pathSegments = { "v3/classifiers", "core_ml_model" };
    String[] pathParameters = { getCoreMlModelOptions.classifierId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getInputStream());
  }

  /**
   * Delete labeled data.
   *
   * Deletes all data associated with a specified customer ID. The method has no effect if no data is associated with
   * the customer ID.
   *
   * You associate a customer ID with data by passing the `X-Watson-Metadata` header with a request that passes data.
   * For more information about personal data and customer IDs, see [Information
   * security](https://console.bluemix.net/docs/services/visual-recognition/information-security.html).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    Validator.notNull(deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    String[] pathSegments = { "v3/user_data" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.query("customer_id", deleteUserDataOptions.customerId());
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

}

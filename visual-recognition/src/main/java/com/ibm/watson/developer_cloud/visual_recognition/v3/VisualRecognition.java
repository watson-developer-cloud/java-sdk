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
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifiers;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DeleteClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.GetClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ListClassifiersOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.UpdateClassifierOptions;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * **Important:** As of September 8, 2017, the beta period for Similarity Search is closed. For more information, see
 * [Visual Recognition API – Similarity Search
 * Update](https://www.ibm.com/blogs/bluemix/2017/08/visual-recognition-api-similarity-search-update).
 *
 * The IBM Watson Visual Recognition service uses deep learning algorithms to identify scenes, objects, and faces in
 * images you upload to the service. You can create and train a custom classifier to identify subjects that suit your
 * needs.
 *
 * **Tip:** To test calls to the **Custom classifiers** methods with the API explorer, provide your `api_key` from your
 * IBM&reg; Cloud service instance.
 *
 * @version v3
 * @see <a href="http://www.ibm.com/watson/developercloud/visual-recognition.html">Visual Recognition</a>
 */
public class VisualRecognition extends WatsonService {

  private static final String SERVICE_NAME = "visual_recognition";
  private static final String URL = "https://gateway-a.watsonplatform.net/visual-recognition/api";

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
    if (getUsername() != null && getPassword() != null) {
      super.setAuthentication(builder);
    } else if (getApiKey() != null) {
      final okhttp3.HttpUrl url = okhttp3.HttpUrl.parse(builder.build().url().toString());

      if ((url.query() == null) || url.query().isEmpty()) {
        builder.url(builder.build().url() + "?api_key=" + getApiKey());
      } else {
        builder.url(builder.build().url() + "&api_key=" + getApiKey());
      }
    } else {
      throw new IllegalArgumentException(
          "Credentials need to be specified. Use setApiKey() or setUsernameAndPassword()");
    }
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
    List<String> pathSegments = Arrays.asList("v3/classify");
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
   * Analyze and get data about faces in images. Responses can include estimated age and gender, and the service can
   * identify celebrities. This feature uses a built-in classifier, so you do not train it on custom classifiers. The
   * Detect faces method does not support general biometric facial recognition.
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
    List<String> pathSegments = Arrays.asList("v3/detect_faces");
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
   * Analyze and get data about faces in images. Responses can include estimated age and gender, and the service can
   * identify celebrities. This feature uses a built-in classifier, so you do not train it on custom classifiers. The
   * Detect faces method does not support general biometric facial recognition.
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
   * negative file. You can upload a maximum of 256 MB per call. Encode all names in UTF-8 if they contain non-ASCII
   * characters (.zip and image file names, and classifier and class names). The service assumes UTF-8 encoding if it
   * encounters non-ASCII characters.
   *
   * @param createClassifierOptions the {@link CreateClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifier}
   */
  public ServiceCall<Classifier> createClassifier(CreateClassifierOptions createClassifierOptions) {
    Validator.notNull(createClassifierOptions, "createClassifierOptions cannot be null");
    List<String> pathSegments = Arrays.asList("v3/classifiers");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("name", createClassifierOptions.name());
    // Classes
    for (String className : createClassifierOptions.classNames()) {
      String dataName = className + "_positive_examples";
      File positiveExamples = createClassifierOptions.positiveExamplesByClassName(className);
      RequestBody body = RequestUtils.fileBody(positiveExamples, "application/octet-stream");
      multipartBuilder.addFormDataPart(dataName, positiveExamples.getName(), body);
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
    List<String> pathSegments = Arrays.asList("v3/classifiers");
    List<String> pathParameters = Arrays.asList(deleteClassifierOptions.classifierId());
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
    List<String> pathSegments = Arrays.asList("v3/classifiers");
    List<String> pathParameters = Arrays.asList(getClassifierOptions.classifierId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Classifier.class));
  }

  /**
   * Retrieve a list of custom classifiers.
   *
   * @param listClassifiersOptions the {@link ListClassifiersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifiers}
   */
  public ServiceCall<Classifiers> listClassifiers(ListClassifiersOptions listClassifiersOptions) {
    List<String> pathSegments = Arrays.asList("v3/classifiers");
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
   * Retrieve a list of custom classifiers.
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
   * Encode all names in UTF-8 if they contain non-ASCII characters (.zip and image file names, and classifier and class
   * names). The service assumes UTF-8 encoding if it encounters non-ASCII characters. **Important:** You can't update a
   * custom classifier with an API key for a Lite plan. To update a custom classifer on a Lite plan, create another
   * service instance on a Standard plan and re-create your custom classifier. **Tip:** Don't make retraining calls on a
   * classifier until the status is ready. When you submit retraining requests in parallel, the last request overwrites
   * the previous requests. The retrained property shows the last time the classifier retraining finished.
   *
   * @param updateClassifierOptions the {@link UpdateClassifierOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Classifier}
   */
  public ServiceCall<Classifier> updateClassifier(UpdateClassifierOptions updateClassifierOptions) {
    Validator.notNull(updateClassifierOptions, "updateClassifierOptions cannot be null");
    Validator.isTrue((updateClassifierOptions.classNames().size() > 0) || (updateClassifierOptions
        .negativeExamples() != null),
        "At least one of classnamePositiveExamples or negativeExamples must be supplied.");
    List<String> pathSegments = Arrays.asList("v3/classifiers");
    List<String> pathParameters = Arrays.asList(updateClassifierOptions.classifierId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    // Classes
    for (String className : updateClassifierOptions.classNames()) {
      String dataName = className + "_positive_examples";
      File positiveExamples = updateClassifierOptions.positiveExamplesByClassName(className);
      RequestBody body = RequestUtils.fileBody(positiveExamples, "application/octet-stream");
      multipartBuilder.addFormDataPart(dataName, positiveExamples.getName(), body);
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

}

/*
 * Copyright 2016 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.visual_recognition.v3;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.RecognizedText;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;

/**
 * Visual Recognition allows you to derive insights from an image based on its visual content. You
 * can organize image libraries, understand an individual image, and create custom classifiers for
 * specific results that are tailored to your needs.
 * 
 * @version v3
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/visual-recognition.html">
 *      Visual Recognition</a>
 */
public class VisualRecognition extends WatsonService {

  private static final String PARAM_API_KEY = "api_key";
  private static final String PARAM_CLASSIFIERS = "classifiers";
  private static final String PARAM_IMAGES_FILE = "images_file";
  private static final String PARAM_NAME = "name";
  private static final String PARAM_NEGATIVE_EXAMPLES = "negative_examples";
  private static final String PARAM_PARAMETERS = "parameters";
  private static final String PARAM_POSITIVE_EXAMPLES = "positive_examples";
  private static final String PARAM_URL = "url";
  private static final String PARAM_CLASSIFIER_IDS = "classifier_ids";
  private static final String PARAM_THRESHOLD = "threshold";
  private static final String PATH_CLASSIFIER = "/v3/classifiers/%s";
  private static final String PATH_CLASSIFIERS = "/v3/classifiers";
  private static final String PATH_CLASSIFY = "/v3/classify";
  private static final String PATH_DETECT_FACES = "/v3/detect_faces";
  private static final String PATH_RECOGNIZE_TEXT = "/v3/recognize_text";
  private static final String SERVICE_NAME = "visual_recognition";
  private static final Type TYPE_LIST_CLASSIFIERS = new TypeToken<List<VisualClassifier>>() {}.getType();
  private static final String URL = "https://gateway-a.watsonplatform.net/visual-recognition/api";
  private static final String VERBOSE = "verbose";
  /** Version date */
  public static final String VERSION_DATE_2016_05_19 = "2016-05-19";

  private String versionDate;

  /**
   * Instantiates a new Visual Recognition V3 service.
   * 
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
   *        will keep your API calls from failing when the service introduces breaking changes.
   */
  public VisualRecognition(String versionDate) {
    super(SERVICE_NAME);
    setEndPoint(URL);
    Validator.notNull(versionDate, "versionDate cannot be null. Use '2016-05-19'");
    this.versionDate = versionDate;
  }

  /**
   * Adds the Alchemy API key to HTTP request.
   * 
   * @param builder the builder
   * @param apiKey the API key token
   */
  private void addApiKeyToRequest(okhttp3.Request.Builder builder, String apiKey) {
    final HttpUrl url = HttpUrl.parse(builder.build().url().toString());
    if (url.query() == null || url.query().isEmpty()) {
      builder.url(builder.build().url() + "?" + apiKey);
    } else {
      builder.url(builder.build().url() + "&" + apiKey);
    }
  }

  private JsonObject getParametersAsJson(ClassifyImagesOptions options) {
    JsonObject ret = new JsonObject();

    if (options.url() != null && options.images() == null) {
      ret.addProperty(PARAM_URL, options.url().toString());
    }
    
    if (options.classifierIds() != null && !options.classifierIds().isEmpty()) {
      JsonArray array = new JsonArray();
      for (String cId : options.classifierIds()) {
        array.add(new JsonPrimitive(cId));
      }
      ret.add(PARAM_CLASSIFIER_IDS, array);
    }
    
    if (options.threshold() != null) {
      ret.addProperty(PARAM_THRESHOLD, options.threshold());
    }
    
    return ret;
  }

  /**
   * Gets the request parameters as {@link JsonObject}.
   *
   * @param options the options
   * @return the parameters as {@link JsonObject}
   */
  private JsonObject getParametersAsJson(VisualRecognitionOptions options) {
    JsonObject ret = new JsonObject();
    ret.addProperty(PARAM_URL, options.url().toString());
    return ret;
  }


  /*
   * (non-Javadoc)
   * 
   * @see
   * com.ibm.watson.developer_cloud.service.WatsonService#setAuthentication(okhttp3.Request.Builder)
   */
  @Override
  protected void setAuthentication(okhttp3.Request.Builder builder) {
    if (getApiKey() == null) {
      throw new IllegalArgumentException("api_key needs to be specified. Use setApiKey()");
    }
    addApiKeyToRequest(builder, PARAM_API_KEY + "=" + getApiKey());
  }

  /**
   *
   * @param options the classify options
   * @return the {@link VisualClassification}
   */
  public ServiceCall<VisualClassification> classify(ClassifyImagesOptions options) {
    Validator.notNull(options, "'options' cannot be null");

    // build body
    Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    
    if (options.images() != null) {
      RequestBody requestBody = RequestBody.create(HttpMediaType.BINARY_FILE, options.images());
      bodyBuilder.addFormDataPart(PARAM_IMAGES_FILE, options.images().getName(), requestBody);
    }
    bodyBuilder.addFormDataPart(PARAM_PARAMETERS, getParametersAsJson(options).toString());

    RequestBuilder requestBuilder = RequestBuilder.post(PATH_CLASSIFY);
    requestBuilder.query(VERSION, versionDate).body(bodyBuilder.build());

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(VisualClassification.class));
  }

  /**
   * Train a new classifier on the uploaded image data. Upload a compressed (.zip) file of images
   * (.jpg, .png, or .gif) with positive examples that show your classifier and another compressed
   * file with negative examples that are similar to but do NOT show your classifier. <br>
   *
   * @param options The parameters to create a classifier
   * @return The created {@link VisualClassifier}
   * @see CreateClassifierOptions
   * @see VisualClassifier
   */
  public ServiceCall<VisualClassifier> createClassifier(CreateClassifierOptions options) {
    Validator.notNull(options, " options cannot be null");

    Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    bodyBuilder.addFormDataPart(PARAM_NAME, options.classifierName());

    // Classes
    for (String className : options.classNames()) {
      String dataName = className + "_" + PARAM_POSITIVE_EXAMPLES;
      RequestBody requestBody =
          RequestBody.create(HttpMediaType.BINARY_FILE, options.positiveExamplesByClassName(className));
      bodyBuilder.addFormDataPart(dataName, options.positiveExamplesByClassName(className).getName(), requestBody);
    }

    if (options.negativeExamples() != null) {
      RequestBody requestBody = RequestBody.create(HttpMediaType.BINARY_FILE, options.negativeExamples());
      bodyBuilder.addFormDataPart(PARAM_NEGATIVE_EXAMPLES, options.negativeExamples().getName(), requestBody);
    }

    RequestBuilder requestBuilder = RequestBuilder.post(PATH_CLASSIFIERS);
    requestBuilder.query(VERSION, versionDate).body(bodyBuilder.build());

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(VisualClassifier.class));
  }

  /**
   * Deletes a classifier.
   *
   * @param classifierId the classifier ID to delete
   * @return the service call
   * @see VisualClassifier
   */
  public ServiceCall<Void> deleteClassifier(String classifierId) {
    Validator.isTrue(classifierId != null && !classifierId.isEmpty(), "classifierId cannot be null or empty");

    RequestBuilder requestBuilder = RequestBuilder.delete(String.format(PATH_CLASSIFIER, classifierId));
    requestBuilder.query(VERSION, versionDate);
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }


  /**
   *
   * @param options the recognize text options
   * @return the {@link VisualClassification}
   */
  public ServiceCall<DetectedFaces> detectFaces(VisualRecognitionOptions options) {
    // build body
    Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    if (options.url() != null) {
      bodyBuilder.addFormDataPart(PARAM_PARAMETERS, getParametersAsJson(options).toString());
    } else {
      RequestBody requestBody = RequestBody.create(HttpMediaType.BINARY_FILE, options.images());
      bodyBuilder.addFormDataPart(PARAM_IMAGES_FILE, options.images().getName(), requestBody);
    }

    RequestBuilder requestBuilder = RequestBuilder.post(PATH_DETECT_FACES);
    requestBuilder.query(VERSION, versionDate).body(bodyBuilder.build());

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(DetectedFaces.class));
  }

  /**
   * Retrieve information about a specific classifier. Only user-trained classifiers may be
   * addressed.
   * 
   * @param classifierId the classifier ID
   * @return the classifier
   * @see VisualClassifier
   */
  public ServiceCall<VisualClassifier> getClassifier(String classifierId) {
    Validator.isTrue(classifierId != null && !classifierId.isEmpty(), "classifierId cannot be null or empty");

    RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_CLASSIFIER, classifierId));
    requestBuilder.query(VERSION, versionDate);
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(VisualClassifier.class));
  }


  /**
   * Retrieve the user-trained classifiers.
   * 
   * @return the classifier list
   * @see VisualClassifier
   */
  public ServiceCall<List<VisualClassifier>> getClassifiers() {
    RequestBuilder requestBuilder =
        RequestBuilder.get(PATH_CLASSIFIERS).query(VERSION, versionDate).query(VERBOSE, true);

    ResponseConverter<List<VisualClassifier>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_LIST_CLASSIFIERS, PARAM_CLASSIFIERS);
    return createServiceCall(requestBuilder.build(), converter);
  }

  /**
   *
   * @param options the recognize text options
   * @return the {@link RecognizedText}
   */
  public ServiceCall<RecognizedText> recognizeText(VisualRecognitionOptions options) {

    // build body
    Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    if (options.url() != null) {
      bodyBuilder.addFormDataPart(PARAM_PARAMETERS, getParametersAsJson(options).toString());
    } else {
      RequestBody requestBody = RequestBody.create(HttpMediaType.BINARY_FILE, options.images());
      bodyBuilder.addFormDataPart(PARAM_IMAGES_FILE, options.images().getName(), requestBody);
    }

    RequestBuilder requestBuilder = RequestBuilder.post(PATH_RECOGNIZE_TEXT);
    requestBuilder.query(VERSION, versionDate).body(bodyBuilder.build());

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(RecognizedText.class));
  }

  @Override
  public void setUsernameAndPassword(String username, String password) {
    throw new IllegalArgumentException("This service requires an api_key. Use the setApiKey() method instead");
  }
}

/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import java.io.File;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * The IBM Watson Natural Language Classifier service applies deep learning techniques to make predictions about the
 * best predefined classes for short sentences or phrases. The classes can trigger a corresponding action in an
 * application, such as directing a request to a location or person, or answering a question. After training, the
 * service returns information for texts that it hasn't seen before. The response includes the name of the top classes
 * and confidence values.
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/nl-classifier.html"> Natural Language Classifier</a>
 */
public class NaturalLanguageClassifier extends WatsonService {

  private static final String SERVICE_NAME = "natural_language_classifier";
  private static final String FORM_DATA_TRAINING_DATA = "form-data; name=\"training_data\"";
  private static final String PATH_CLASSIFIERS = "/v1/classifiers";
  private static final String TEXT = "text";
  private static final String PATH_CLASSIFY = "/v1/classifiers/%s/classify";
  private static final String LANGUAGE = "language";
  private static final String NAME = "name";
  private static final String TRAINING_METADATA = "training_metadata";
  private static final String PATH_CLASSIFIER = "/v1/classifiers/%s";
  private static final String URL = "https://gateway.watsonplatform.net/natural-language-classifier/api";

  /**
   * Instantiates a new Natural Language Classifier service.
   */
  public NaturalLanguageClassifier() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new natural language service by username and password.
   *
   * @param username the username
   * @param password the password
   */
  public NaturalLanguageClassifier(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Returns classification information for a classifier on a phrase.
   *
   * @param classifierId The classifier id
   * @param text The submitted phrase to classify
   * @return the classification of a phrase with a given classifier
   */
  public ServiceCall<Classification> classify(final String classifierId, final String text) {
    Validator.isTrue((classifierId != null) && !classifierId.isEmpty(), "classifierId cannot be null or empty");
    Validator.isTrue((text != null) && !text.isEmpty(), "text cannot be null or empty");

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty(TEXT, text);
    final String path = String.format(PATH_CLASSIFY, classifierId);
    final Request request = RequestBuilder.post(path).bodyJson(contentJson).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Classification.class));
  }

  /**
   * Sends data to create and train a classifier, and returns information about the new classifier. The status has the
   * value of `Training` when the operation is successful, and might remain at this status for a while.
   *
   * @param name the classifier name
   * @param language IETF primary language for the classifier. for example: 'en'
   * @param trainingData The set of questions and their "keys" used to adapt a system to a domain (the ground truth)
   * @return the classifier
   * @see Classifier
   */
  public ServiceCall<Classifier> createClassifier(final String name, final String language, final File trainingData) {
    Validator.isTrue((trainingData != null) && trainingData.exists(), "trainingData cannot be null or not be found");
    Validator.isTrue((language != null) && !language.isEmpty(), "language cannot be null or empty");

    final JsonObject contentJson = new JsonObject();

    contentJson.addProperty(LANGUAGE, language);

    if ((name != null) && !name.isEmpty()) {
      contentJson.addProperty(NAME, name);
    }

    final RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
        .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, FORM_DATA_TRAINING_DATA),
            RequestBody.create(HttpMediaType.BINARY_FILE, trainingData))
        .addFormDataPart(TRAINING_METADATA, contentJson.toString()).build();

    final Request request = RequestBuilder.post(PATH_CLASSIFIERS).body(body).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Classifier.class));
  }

  /**
   * Deletes a classifier.
   *
   * @param classifierId the classifier ID
   * @return the service call
   * @see Classifier
   */
  public ServiceCall<Void> deleteClassifier(String classifierId) {
    Validator.isTrue((classifierId != null) && !classifierId.isEmpty(), "classifierId cannot be null or empty");

    final Request request = RequestBuilder.delete(String.format(PATH_CLASSIFIER, classifierId)).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Retrieves a classifier.
   *
   * @param classifierId the classifier ID
   * @return the classifier list
   * @see Classifier
   */
  public ServiceCall<Classifier> getClassifier(String classifierId) {
    Validator.isTrue((classifierId != null) && !classifierId.isEmpty(), "classifierId cannot be null or empty");

    final Request request = RequestBuilder.get(String.format(PATH_CLASSIFIER, classifierId)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Classifier.class));
  }

  /**
   * Retrieves the list of classifiers for the user.
   *
   * @return the classifier list
   * @see Classifier
   */
  public ServiceCall<Classifiers> getClassifiers() {
    final Request request = RequestBuilder.get(PATH_CLASSIFIERS).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Classifiers.class));

  }

}

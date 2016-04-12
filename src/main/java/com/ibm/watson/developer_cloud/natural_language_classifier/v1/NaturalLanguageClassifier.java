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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1;

import java.io.File;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifiedClass;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * The IBM Watson Natural Language Classifier service applies deep learning techniques to make
 * predictions about the best predefined classes for short sentences or phrases. The classes can
 * trigger a corresponding action in an application, such as directing a request to a location or
 * person, or answering a question. After training, the service returns information for texts that
 * it hasn't seen before. The response includes the name of the top classes and confidence values.
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/nl-classifier.html">
 *      Natural Language Classifier</a>
 */
public class NaturalLanguageClassifier extends WatsonService {

  public static final String LANGUAGE_EN = "en";

  private static final String FORM_DATA_TRAINING_DATA = "form-data; name=\"training_data\"";
  private static final String PATH_CLASSIFIERS = "/v1/classifiers";
  private static final String TEXT = "text";
  private static final String PATH_CLASSIFY = "/v1/classifiers/%s/classify";
  private static final String LANGUAGE = "language";
  private static final String NAME = "name";
  private static final String TRAINING_METADATA = "training_metadata";
  private static final String PATH_CLASSIFIER = "/v1/classifiers/%s";
  private static String URL = "https://gateway.watsonplatform.net/natural-language-classifier/api";

  /**
   * Instantiates a new Natural Language Classifier service.
   */
  public NaturalLanguageClassifier() {
    super("natural_language_classifier");
    setEndPoint(URL);
  }

  /**
   * Returns classification information for a classifier on a phrase.
   * 
   * @param classifierId The classifier id
   * @param text The submitted phrase to classify
   * @return the classification of a phrase with a given classifier
   */
  public Classification classify(final String classifierId, final String text) {
    if (classifierId == null || classifierId.isEmpty())
      throw new IllegalArgumentException("classifierId cannot be null or empty");

    if (text == null || text.isEmpty())
      throw new IllegalArgumentException("text cannot be null or empty");

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty(TEXT, text);

    final String path = String.format(PATH_CLASSIFY, classifierId);

    final Request request = RequestBuilder.post(path).withBodyJson(contentJson).build();

    final Response response = execute(request);
    final Classification classification = ResponseUtil.getObject(response, Classification.class);

    for (final ClassifiedClass klass : classification.getClasses()) {
      if (klass.getName().equals(classification.getTopClass())) {
        classification.setTopConfidence(klass.getConfidence());
        break;
      }
    }
    return classification;
  }

  /**
   * Sends data to create and train a classifier, and returns information about the new classifier.
   * The status has the value of `Training` when the operation is successful, and might remain at
   * this status for a while.
   * 
   * @param name the classifier name
   * @param language IETF primary language for the classifier. for example: 'en'
   * @param trainingData The set of questions and their "keys" used to adapt a system to a domain
   *        (the ground truth)
   * @return the classifier
   * @see Classifier
   */
  public Classifier createClassifier(final String name, final String language,
      final File trainingData) {
    Validate.isTrue(trainingData != null && trainingData.exists(),
        "trainingData cannot be null or not be found");
    Validate.isTrue(language != null && !language.isEmpty(), "language cannot be null or empty");

    final JsonObject contentJson = new JsonObject();

    contentJson.addProperty(LANGUAGE, language);

    if (name != null && !name.isEmpty()) {
      contentJson.addProperty(NAME, name);
    }

    final RequestBody body = new MultipartBuilder().type(MultipartBuilder.FORM)
        .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, FORM_DATA_TRAINING_DATA),
            RequestBody.create(HttpMediaType.BINARY_FILE, trainingData))
        .addFormDataPart(TRAINING_METADATA, contentJson.toString()).build();

    final Request request = RequestBuilder.post(PATH_CLASSIFIERS).withBody(body).build();

    final Response response = execute(request);
    return ResponseUtil.getObject(response, Classifier.class);
  }

  /**
   * Deletes a classifier.
   * 
   * @param classifierId the classifier ID
   * @see Classifier
   */
  public void deleteClassifier(String classifierId) {
    if (classifierId == null || classifierId.isEmpty())
      throw new IllegalArgumentException("classifierId cannot be null or empty");

    final Request request =
        RequestBuilder.delete(String.format(PATH_CLASSIFIER, classifierId)).build();
    executeWithoutResponse(request);
  }

  /**
   * Retrieves a classifier.
   * 
   * @param classifierId the classifier ID
   * @return the classifier list
   * @see Classifier
   */
  public Classifier getClassifier(String classifierId) {
    if (classifierId == null || classifierId.isEmpty())
      throw new IllegalArgumentException("classifierId cannot be null or empty");

    final Request request =
        RequestBuilder.get(String.format(PATH_CLASSIFIER, classifierId)).build();
    return executeRequest(request, Classifier.class);
  }

  /**
   * Retrieves the list of classifiers for the user.
   * 
   * @return the classifier list
   * @see Classifier
   */
  public Classifiers getClassifiers() {
    final Request request = RequestBuilder.get(PATH_CLASSIFIERS).build();
    return executeRequest(request, Classifiers.class);
  }

}

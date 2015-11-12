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
import java.util.List;

import org.apache.commons.csv.CSVFormat;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifiedClass;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.TrainingData;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.util.TrainingDataUtils;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
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
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/nl-classifier.html">
 *      Natural Language Classifier</a>
 */
public class NaturalLanguageClassifier extends WatsonService {

  /** The Constant LANGUAGE (value is "language"). */
  private static final String LANGUAGE = "language";

  /**
   * The Constant LANGUAGE_EN. (value is: "en" )
   */
  public static final String LANGUAGE_EN = "en";

  private static final String NAME = "name";
  private static final String TRAINING_DATA = "training_data";
  private static final String TRAINING_METADATA = "training_metadata";
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
    contentJson.addProperty("text", text);

    final String path = String.format("/v1/classifiers/%s/classify", classifierId);

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
   * @param language IETF primary language for the classifier
   * @param csvTrainingData the CSV training data
   * @return the classifier
   * @see Classifier
   */
  public Classifier createClassifier(final String name, final String language,
      final File csvTrainingData) {
    if (csvTrainingData == null || !csvTrainingData.exists())
      throw new IllegalArgumentException("csvTrainingData cannot be null or not be found");

    final List<TrainingData> trainingData =
        TrainingDataUtils.fromCSV(csvTrainingData, CSVFormat.DEFAULT);
    return createClassifier(name, language, trainingData);
  }

  /**
   * Sends data to create and train a classifier, and returns information about the new classifier.
   * The status has the value of `Training` when the operation is successful, and might remain at
   * this status for a while.
   * 
   * @param name the classifier name
   * @param language IETF primary language for the classifier
   * @param trainingData The set of questions and their "keys" used to adapt a system to a domain
   *        (the ground truth)
   * @return the classifier
   * @see Classifier
   */
  public Classifier createClassifier(final String name, final String language,
      final List<TrainingData> trainingData) {
    if (trainingData == null || trainingData.isEmpty())
      throw new IllegalArgumentException("trainingData cannot be null or empty");

    final JsonObject contentJson = new JsonObject();

    contentJson.addProperty(LANGUAGE, language == null ? LANGUAGE_EN : language);

    if (name != null && !name.isEmpty()) {
      contentJson.addProperty(NAME, name);
    }

    final RequestBody body =
        new MultipartBuilder()
            .addFormDataPart(TRAINING_DATA,
                TrainingDataUtils.toCSV(trainingData.toArray(new TrainingData[0])))
            .addFormDataPart(TRAINING_METADATA, contentJson.toString()).build();

    final Request request = RequestBuilder.post("/v1/classifiers").withBody(body).build();

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

    final Request request = RequestBuilder.delete("/v1/classifiers/" + classifierId).build();
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

    final Request request = RequestBuilder.get("/v1/classifiers/" + classifierId).build();
    return executeRequest(request, Classifier.class);
  }

  /**
   * Retrieves the list of classifiers for the user.
   * 
   * @return the classifier list
   * @see Classifier
   */
  public Classifiers getClassifiers() {
    final Request request = RequestBuilder.get("/v1/classifiers").build();
    return executeRequest(request, Classifiers.class);
  }

}

/*
 * (C) Copyright IBM Corp. 2022, 2024.
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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;
import java.util.List;

/** Information about a document classifier. */
public class DocumentClassifier extends GenericModel {

  @SerializedName("classifier_id")
  protected String classifierId;

  protected String name;
  protected String description;
  protected Date created;
  protected String language;
  protected List<DocumentClassifierEnrichment> enrichments;

  @SerializedName("recognized_fields")
  protected List<String> recognizedFields;

  @SerializedName("answer_field")
  protected String answerField;

  @SerializedName("training_data_file")
  protected String trainingDataFile;

  @SerializedName("test_data_file")
  protected String testDataFile;

  @SerializedName("federated_classification")
  protected ClassifierFederatedModel federatedClassification;

  protected DocumentClassifier() {}

  /**
   * Gets the classifierId.
   *
   * <p>The Universally Unique Identifier (UUID) of the document classifier.
   *
   * @return the classifierId
   */
  public String getClassifierId() {
    return classifierId;
  }

  /**
   * Gets the name.
   *
   * <p>A human-readable name of the document classifier.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>A description of the document classifier.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * <p>The date that the document classifier was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the training data that is associated with the document classifier. Language
   * is specified by using the ISO 639-1 language code, such as `en` for English or `ja` for
   * Japanese.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the enrichments.
   *
   * <p>An array of enrichments to apply to the data that is used to train and test the document
   * classifier. The output from the enrichments is used as features by the classifier to classify
   * the document content both during training and at run time.
   *
   * @return the enrichments
   */
  public List<DocumentClassifierEnrichment> getEnrichments() {
    return enrichments;
  }

  /**
   * Gets the recognizedFields.
   *
   * <p>An array of fields that are used to train the document classifier. The same set of fields
   * must exist in the training data, the test data, and the documents where the resulting document
   * classifier enrichment is applied at run time.
   *
   * @return the recognizedFields
   */
  public List<String> getRecognizedFields() {
    return recognizedFields;
  }

  /**
   * Gets the answerField.
   *
   * <p>The name of the field from the training and test data that contains the classification
   * labels.
   *
   * @return the answerField
   */
  public String getAnswerField() {
    return answerField;
  }

  /**
   * Gets the trainingDataFile.
   *
   * <p>Name of the CSV file with training data that is used to train the document classifier.
   *
   * @return the trainingDataFile
   */
  public String getTrainingDataFile() {
    return trainingDataFile;
  }

  /**
   * Gets the testDataFile.
   *
   * <p>Name of the CSV file with data that is used to test the document classifier. If no test data
   * is provided, a subset of the training data is used for testing purposes.
   *
   * @return the testDataFile
   */
  public String getTestDataFile() {
    return testDataFile;
  }

  /**
   * Gets the federatedClassification.
   *
   * <p>An object with details for creating federated document classifier models.
   *
   * @return the federatedClassification
   */
  public ClassifierFederatedModel getFederatedClassification() {
    return federatedClassification;
  }
}

/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The updateDocumentClassifier options. */
public class UpdateDocumentClassifierOptions extends GenericModel {

  protected String projectId;
  protected String classifierId;
  protected UpdateDocumentClassifier classifier;
  protected InputStream trainingData;
  protected InputStream testData;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String classifierId;
    private UpdateDocumentClassifier classifier;
    private InputStream trainingData;
    private InputStream testData;

    /**
     * Instantiates a new Builder from an existing UpdateDocumentClassifierOptions instance.
     *
     * @param updateDocumentClassifierOptions the instance to initialize the Builder with
     */
    private Builder(UpdateDocumentClassifierOptions updateDocumentClassifierOptions) {
      this.projectId = updateDocumentClassifierOptions.projectId;
      this.classifierId = updateDocumentClassifierOptions.classifierId;
      this.classifier = updateDocumentClassifierOptions.classifier;
      this.trainingData = updateDocumentClassifierOptions.trainingData;
      this.testData = updateDocumentClassifierOptions.testData;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param classifierId the classifierId
     * @param classifier the classifier
     */
    public Builder(String projectId, String classifierId, UpdateDocumentClassifier classifier) {
      this.projectId = projectId;
      this.classifierId = classifierId;
      this.classifier = classifier;
    }

    /**
     * Builds a UpdateDocumentClassifierOptions.
     *
     * @return the new UpdateDocumentClassifierOptions instance
     */
    public UpdateDocumentClassifierOptions build() {
      return new UpdateDocumentClassifierOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the UpdateDocumentClassifierOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the UpdateDocumentClassifierOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }

    /**
     * Set the classifier.
     *
     * @param classifier the classifier
     * @return the UpdateDocumentClassifierOptions builder
     */
    public Builder classifier(UpdateDocumentClassifier classifier) {
      this.classifier = classifier;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the UpdateDocumentClassifierOptions builder
     */
    public Builder trainingData(InputStream trainingData) {
      this.trainingData = trainingData;
      return this;
    }

    /**
     * Set the testData.
     *
     * @param testData the testData
     * @return the UpdateDocumentClassifierOptions builder
     */
    public Builder testData(InputStream testData) {
      this.testData = testData;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the UpdateDocumentClassifierOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder trainingData(File trainingData) throws FileNotFoundException {
      this.trainingData = new FileInputStream(trainingData);
      return this;
    }

    /**
     * Set the testData.
     *
     * @param testData the testData
     * @return the UpdateDocumentClassifierOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder testData(File testData) throws FileNotFoundException {
      this.testData = new FileInputStream(testData);
      return this;
    }
  }

  protected UpdateDocumentClassifierOptions() {}

  protected UpdateDocumentClassifierOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.classifierId, "classifierId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.classifier, "classifier cannot be null");
    projectId = builder.projectId;
    classifierId = builder.classifierId;
    classifier = builder.classifier;
    trainingData = builder.trainingData;
    testData = builder.testData;
  }

  /**
   * New builder.
   *
   * @return a UpdateDocumentClassifierOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The Universally Unique Identifier (UUID) of the project. This information can be found from
   * the *Integrate and Deploy* page in Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the classifierId.
   *
   * <p>The Universally Unique Identifier (UUID) of the classifier.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }

  /**
   * Gets the classifier.
   *
   * <p>An object that contains a new name or description for a document classifier, updated
   * training data, or new or updated test data.
   *
   * @return the classifier
   */
  public UpdateDocumentClassifier classifier() {
    return classifier;
  }

  /**
   * Gets the trainingData.
   *
   * <p>The training data CSV file to upload. The CSV file must have headers. The file must include
   * a field that contains the text you want to classify and a field that contains the
   * classification labels that you want to use to classify your data. If you want to specify
   * multiple values in a single column, use a semicolon as the value separator. For a sample file,
   * see [the product documentation](/docs/discovery-data?topic=discovery-data-cm-doc-classifier).
   *
   * @return the trainingData
   */
  public InputStream trainingData() {
    return trainingData;
  }

  /**
   * Gets the testData.
   *
   * <p>The CSV with test data to upload. The column values in the test file must be the same as the
   * column values in the training data file. If no test data is provided, the training data is
   * split into two separate groups of training and test data.
   *
   * @return the testData
   */
  public InputStream testData() {
    return testData;
  }
}

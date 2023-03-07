/*
 * (C) Copyright IBM Corp. 2023.
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

/** The createDocumentClassifier options. */
public class CreateDocumentClassifierOptions extends GenericModel {

  protected String projectId;
  protected InputStream trainingData;
  protected CreateDocumentClassifier classifier;
  protected InputStream testData;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private InputStream trainingData;
    private CreateDocumentClassifier classifier;
    private InputStream testData;

    /**
     * Instantiates a new Builder from an existing CreateDocumentClassifierOptions instance.
     *
     * @param createDocumentClassifierOptions the instance to initialize the Builder with
     */
    private Builder(CreateDocumentClassifierOptions createDocumentClassifierOptions) {
      this.projectId = createDocumentClassifierOptions.projectId;
      this.trainingData = createDocumentClassifierOptions.trainingData;
      this.classifier = createDocumentClassifierOptions.classifier;
      this.testData = createDocumentClassifierOptions.testData;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param trainingData the trainingData
     * @param classifier the classifier
     */
    public Builder(
        String projectId, InputStream trainingData, CreateDocumentClassifier classifier) {
      this.projectId = projectId;
      this.trainingData = trainingData;
      this.classifier = classifier;
    }

    /**
     * Builds a CreateDocumentClassifierOptions.
     *
     * @return the new CreateDocumentClassifierOptions instance
     */
    public CreateDocumentClassifierOptions build() {
      return new CreateDocumentClassifierOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the CreateDocumentClassifierOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the CreateDocumentClassifierOptions builder
     */
    public Builder trainingData(InputStream trainingData) {
      this.trainingData = trainingData;
      return this;
    }

    /**
     * Set the classifier.
     *
     * @param classifier the classifier
     * @return the CreateDocumentClassifierOptions builder
     */
    public Builder classifier(CreateDocumentClassifier classifier) {
      this.classifier = classifier;
      return this;
    }

    /**
     * Set the testData.
     *
     * @param testData the testData
     * @return the CreateDocumentClassifierOptions builder
     */
    public Builder testData(InputStream testData) {
      this.testData = testData;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the CreateDocumentClassifierOptions builder
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
     * @return the CreateDocumentClassifierOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder testData(File testData) throws FileNotFoundException {
      this.testData = new FileInputStream(testData);
      return this;
    }
  }

  protected CreateDocumentClassifierOptions() {}

  protected CreateDocumentClassifierOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.trainingData, "trainingData cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.classifier, "classifier cannot be null");
    projectId = builder.projectId;
    trainingData = builder.trainingData;
    classifier = builder.classifier;
    testData = builder.testData;
  }

  /**
   * New builder.
   *
   * @return a CreateDocumentClassifierOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the *Integrate and Deploy* page in
   * Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the trainingData.
   *
   * <p>The training data CSV file to upload. The CSV file must have headers. The file must include
   * a field that contains the text you want to classify and a field that contains the
   * classification labels that you want to use to classify your data. If you want to specify
   * multiple values in a single field, use a semicolon as the value separator. For a sample file,
   * see [the product documentation](/docs/discovery-data?topic=discovery-data-cm-doc-classifier).
   *
   * @return the trainingData
   */
  public InputStream trainingData() {
    return trainingData;
  }

  /**
   * Gets the classifier.
   *
   * <p>An object that manages the settings and data that is required to train a document
   * classification model.
   *
   * @return the classifier
   */
  public CreateDocumentClassifier classifier() {
    return classifier;
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

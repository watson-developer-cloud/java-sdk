/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.natural_language_classifier.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createClassifier options.
 */
public class CreateClassifierOptions extends GenericModel {

  protected InputStream trainingMetadata;
  protected InputStream trainingData;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream trainingMetadata;
    private InputStream trainingData;

    private Builder(CreateClassifierOptions createClassifierOptions) {
      this.trainingMetadata = createClassifierOptions.trainingMetadata;
      this.trainingData = createClassifierOptions.trainingData;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param trainingMetadata the trainingMetadata
     * @param trainingData the trainingData
     */
    public Builder(InputStream trainingMetadata, InputStream trainingData) {
      this.trainingMetadata = trainingMetadata;
      this.trainingData = trainingData;
    }

    /**
     * Builds a CreateClassifierOptions.
     *
     * @return the createClassifierOptions
     */
    public CreateClassifierOptions build() {
      return new CreateClassifierOptions(this);
    }

    /**
     * Set the trainingMetadata.
     *
     * @param trainingMetadata the trainingMetadata
     * @return the CreateClassifierOptions builder
     */
    public Builder trainingMetadata(InputStream trainingMetadata) {
      this.trainingMetadata = trainingMetadata;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the CreateClassifierOptions builder
     */
    public Builder trainingData(InputStream trainingData) {
      this.trainingData = trainingData;
      return this;
    }

    /**
     * Set the trainingMetadata.
     *
     * @param trainingMetadata the trainingMetadata
     * @return the CreateClassifierOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder trainingMetadata(File trainingMetadata) throws FileNotFoundException {
      this.trainingMetadata = new FileInputStream(trainingMetadata);
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the CreateClassifierOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder trainingData(File trainingData) throws FileNotFoundException {
      this.trainingData = new FileInputStream(trainingData);
      return this;
    }
  }

  protected CreateClassifierOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.trainingMetadata,
        "trainingMetadata cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.trainingData,
        "trainingData cannot be null");
    trainingMetadata = builder.trainingMetadata;
    trainingData = builder.trainingData;
  }

  /**
   * New builder.
   *
   * @return a CreateClassifierOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the trainingMetadata.
   *
   * Metadata in JSON format. The metadata identifies the language of the data, and an optional name to identify the
   * classifier. Specify the language with the 2-letter primary language code as assigned in ISO standard 639.
   *
   * Supported languages are English (`en`), Arabic (`ar`), French (`fr`), German, (`de`), Italian (`it`), Japanese
   * (`ja`), Korean (`ko`), Brazilian Portuguese (`pt`), and Spanish (`es`).
   *
   * @return the trainingMetadata
   */
  public InputStream trainingMetadata() {
    return trainingMetadata;
  }

  /**
   * Gets the trainingData.
   *
   * Training data in CSV format. Each text value must have at least one class. The data can include up to 3,000 classes
   * and 20,000 records. For details, see [Data
   * preparation]
   * (https://cloud.ibm.com/docs/services/natural-language-classifier
   * ?topic=natural-language-classifier-using-your-data).
   *
   * @return the trainingData
   */
  public InputStream trainingData() {
    return trainingData;
  }
}

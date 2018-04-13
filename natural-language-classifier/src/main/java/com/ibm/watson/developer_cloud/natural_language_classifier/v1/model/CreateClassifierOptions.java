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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createClassifier options.
 */
public class CreateClassifierOptions extends GenericModel {

  private InputStream metadata;
  private String metadataFilename;
  private InputStream trainingData;
  private String trainingDataFilename;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream metadata;
    private String metadataFilename;
    private InputStream trainingData;
    private String trainingDataFilename;

    private Builder(CreateClassifierOptions createClassifierOptions) {
      metadata = createClassifierOptions.metadata;
      metadataFilename = createClassifierOptions.metadataFilename;
      trainingData = createClassifierOptions.trainingData;
      trainingDataFilename = createClassifierOptions.trainingDataFilename;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param metadata the metadata
     * @param trainingData the trainingData
     */
    public Builder(InputStream metadata, InputStream trainingData) {
      this.metadata = metadata;
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
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateClassifierOptions builder
     */
    public Builder metadata(InputStream metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the metadataFilename.
     *
     * @param metadataFilename the metadataFilename
     * @return the CreateClassifierOptions builder
     */
    public Builder metadataFilename(String metadataFilename) {
      this.metadataFilename = metadataFilename;
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
     * Set the trainingDataFilename.
     *
     * @param trainingDataFilename the trainingDataFilename
     * @return the CreateClassifierOptions builder
     */
    public Builder trainingDataFilename(String trainingDataFilename) {
      this.trainingDataFilename = trainingDataFilename;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateClassifierOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder metadata(File metadata) throws FileNotFoundException {
      this.metadata = new FileInputStream(metadata);
      this.metadataFilename = metadata.getName();
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
      this.trainingDataFilename = trainingData.getName();
      return this;
    }
  }

  private CreateClassifierOptions(Builder builder) {
    Validator.notNull(builder.metadata, "metadata cannot be null");
    Validator.notNull(builder.trainingData, "trainingData cannot be null");
    metadata = builder.metadata;
    metadataFilename = builder.metadataFilename;
    trainingData = builder.trainingData;
    trainingDataFilename = builder.trainingDataFilename;
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
   * Gets the metadata.
   *
   * Metadata in JSON format. The metadata identifies the language of the data, and an optional name to identify the
   * classifier. Specify the language with the 2-letter primary language code as assigned in ISO standard 639. Supported
   * languages are English (`en`), Arabic (`ar`), French (`fr`), German, (`de`), Italian (`it`), Japanese (`ja`), Korean
   * (`ko`), Brazilian Portuguese (`pt`), and Spanish (`es`).
   *
   * @return the metadata
   */
  public InputStream metadata() {
    return metadata;
  }

  /**
   * Gets the metadataFilename.
   *
   * The filename for trainingMetadata.
   *
   * @return the metadataFilename
   */
  public String metadataFilename() {
    return metadataFilename;
  }

  /**
   * Gets the trainingData.
   *
   * Training data in CSV format. Each text value must have at least one class. The data can include up to 20,000
   * records. For details, see [Data
   * preparation](https://console.bluemix.net/docs/services/natural-language-classifier/using-your-data.html).
   *
   * @return the trainingData
   */
  public InputStream trainingData() {
    return trainingData;
  }

  /**
   * Gets the trainingDataFilename.
   *
   * The filename for trainingData.
   *
   * @return the trainingDataFilename
   */
  public String trainingDataFilename() {
    return trainingDataFilename;
  }
}

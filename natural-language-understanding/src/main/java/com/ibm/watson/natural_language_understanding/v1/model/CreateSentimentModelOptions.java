/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

/** The createSentimentModel options. */
public class CreateSentimentModelOptions extends GenericModel {

  protected String language;
  protected InputStream trainingData;
  protected String name;
  protected Map<String, Object> userMetadata;
  protected String description;
  protected String modelVersion;
  protected String workspaceId;
  protected String versionDescription;

  /** Builder. */
  public static class Builder {
    private String language;
    private InputStream trainingData;
    private String name;
    private Map<String, Object> userMetadata;
    private String description;
    private String modelVersion;
    private String workspaceId;
    private String versionDescription;

    private Builder(CreateSentimentModelOptions createSentimentModelOptions) {
      this.language = createSentimentModelOptions.language;
      this.trainingData = createSentimentModelOptions.trainingData;
      this.name = createSentimentModelOptions.name;
      this.userMetadata = createSentimentModelOptions.userMetadata;
      this.description = createSentimentModelOptions.description;
      this.modelVersion = createSentimentModelOptions.modelVersion;
      this.workspaceId = createSentimentModelOptions.workspaceId;
      this.versionDescription = createSentimentModelOptions.versionDescription;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param language the language
     * @param trainingData the trainingData
     */
    public Builder(String language, InputStream trainingData) {
      this.language = language;
      this.trainingData = trainingData;
    }

    /**
     * Builds a CreateSentimentModelOptions.
     *
     * @return the new CreateSentimentModelOptions instance
     */
    public CreateSentimentModelOptions build() {
      return new CreateSentimentModelOptions(this);
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateSentimentModelOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the CreateSentimentModelOptions builder
     */
    public Builder trainingData(InputStream trainingData) {
      this.trainingData = trainingData;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateSentimentModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the userMetadata.
     *
     * @param userMetadata the userMetadata
     * @return the CreateSentimentModelOptions builder
     */
    public Builder userMetadata(Map<String, Object> userMetadata) {
      this.userMetadata = userMetadata;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateSentimentModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the modelVersion.
     *
     * @param modelVersion the modelVersion
     * @return the CreateSentimentModelOptions builder
     */
    public Builder modelVersion(String modelVersion) {
      this.modelVersion = modelVersion;
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateSentimentModelOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the versionDescription.
     *
     * @param versionDescription the versionDescription
     * @return the CreateSentimentModelOptions builder
     */
    public Builder versionDescription(String versionDescription) {
      this.versionDescription = versionDescription;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the CreateSentimentModelOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder trainingData(File trainingData) throws FileNotFoundException {
      this.trainingData = new FileInputStream(trainingData);
      return this;
    }
  }

  protected CreateSentimentModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.language, "language cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.trainingData, "trainingData cannot be null");
    language = builder.language;
    trainingData = builder.trainingData;
    name = builder.name;
    userMetadata = builder.userMetadata;
    description = builder.description;
    modelVersion = builder.modelVersion;
    workspaceId = builder.workspaceId;
    versionDescription = builder.versionDescription;
  }

  /**
   * New builder.
   *
   * @return a CreateSentimentModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the language.
   *
   * <p>The 2-letter language code of this model.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the trainingData.
   *
   * <p>Training data in CSV format. For more information, see [Sentiment training data
   * requirements](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-custom-sentiment#sentiment-training-data-requirements).
   *
   * @return the trainingData
   */
  public InputStream trainingData() {
    return trainingData;
  }

  /**
   * Gets the name.
   *
   * <p>An optional name for the model.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the userMetadata.
   *
   * <p>An optional map of metadata key-value pairs to store with this model.
   *
   * @return the userMetadata
   */
  public Map<String, Object> userMetadata() {
    return userMetadata;
  }

  /**
   * Gets the description.
   *
   * <p>An optional description of the model.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the modelVersion.
   *
   * <p>An optional version string.
   *
   * @return the modelVersion
   */
  public String modelVersion() {
    return modelVersion;
  }

  /**
   * Gets the workspaceId.
   *
   * <p>ID of the Watson Knowledge Studio workspace that deployed this model to Natural Language
   * Understanding.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the versionDescription.
   *
   * <p>The description of the version.
   *
   * @return the versionDescription
   */
  public String versionDescription() {
    return versionDescription;
  }
}

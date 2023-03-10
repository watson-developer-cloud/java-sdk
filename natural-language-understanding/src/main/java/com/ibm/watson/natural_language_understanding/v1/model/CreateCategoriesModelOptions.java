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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

/** The createCategoriesModel options. */
public class CreateCategoriesModelOptions extends GenericModel {

  protected String language;
  protected InputStream trainingData;
  protected String trainingDataContentType;
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
    private String trainingDataContentType;
    private String name;
    private Map<String, Object> userMetadata;
    private String description;
    private String modelVersion;
    private String workspaceId;
    private String versionDescription;

    /**
     * Instantiates a new Builder from an existing CreateCategoriesModelOptions instance.
     *
     * @param createCategoriesModelOptions the instance to initialize the Builder with
     */
    private Builder(CreateCategoriesModelOptions createCategoriesModelOptions) {
      this.language = createCategoriesModelOptions.language;
      this.trainingData = createCategoriesModelOptions.trainingData;
      this.trainingDataContentType = createCategoriesModelOptions.trainingDataContentType;
      this.name = createCategoriesModelOptions.name;
      this.userMetadata = createCategoriesModelOptions.userMetadata;
      this.description = createCategoriesModelOptions.description;
      this.modelVersion = createCategoriesModelOptions.modelVersion;
      this.workspaceId = createCategoriesModelOptions.workspaceId;
      this.versionDescription = createCategoriesModelOptions.versionDescription;
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
     * Builds a CreateCategoriesModelOptions.
     *
     * @return the new CreateCategoriesModelOptions instance
     */
    public CreateCategoriesModelOptions build() {
      return new CreateCategoriesModelOptions(this);
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder trainingData(InputStream trainingData) {
      this.trainingData = trainingData;
      return this;
    }

    /**
     * Set the trainingDataContentType.
     *
     * @param trainingDataContentType the trainingDataContentType
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder trainingDataContentType(String trainingDataContentType) {
      this.trainingDataContentType = trainingDataContentType;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the userMetadata.
     *
     * @param userMetadata the userMetadata
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder userMetadata(Map<String, Object> userMetadata) {
      this.userMetadata = userMetadata;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the modelVersion.
     *
     * @param modelVersion the modelVersion
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder modelVersion(String modelVersion) {
      this.modelVersion = modelVersion;
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the versionDescription.
     *
     * @param versionDescription the versionDescription
     * @return the CreateCategoriesModelOptions builder
     */
    public Builder versionDescription(String versionDescription) {
      this.versionDescription = versionDescription;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the CreateCategoriesModelOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder trainingData(File trainingData) throws FileNotFoundException {
      this.trainingData = new FileInputStream(trainingData);
      return this;
    }
  }

  protected CreateCategoriesModelOptions() {}

  protected CreateCategoriesModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.language, "language cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.trainingData, "trainingData cannot be null");
    language = builder.language;
    trainingData = builder.trainingData;
    trainingDataContentType = builder.trainingDataContentType;
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
   * @return a CreateCategoriesModelOptions builder
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
   * <p>Training data in JSON format. For more information, see [Categories training data
   * requirements](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-categories##categories-training-data-requirements).
   *
   * @return the trainingData
   */
  public InputStream trainingData() {
    return trainingData;
  }

  /**
   * Gets the trainingDataContentType.
   *
   * <p>The content type of trainingData. Values for this parameter can be obtained from the
   * HttpMediaType class.
   *
   * @return the trainingDataContentType
   */
  public String trainingDataContentType() {
    return trainingDataContentType;
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

/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.visual_recognition.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The updateCollection options. */
public class UpdateCollectionOptions extends GenericModel {

  protected String collectionId;
  protected String name;
  protected String description;
  protected TrainingStatus trainingStatus;

  /** Builder. */
  public static class Builder {
    private String collectionId;
    private String name;
    private String description;
    private TrainingStatus trainingStatus;

    private Builder(UpdateCollectionOptions updateCollectionOptions) {
      this.collectionId = updateCollectionOptions.collectionId;
      this.name = updateCollectionOptions.name;
      this.description = updateCollectionOptions.description;
      this.trainingStatus = updateCollectionOptions.trainingStatus;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionId the collectionId
     */
    public Builder(String collectionId) {
      this.collectionId = collectionId;
    }

    /**
     * Builds a UpdateCollectionOptions.
     *
     * @return the new UpdateCollectionOptions instance
     */
    public UpdateCollectionOptions build() {
      return new UpdateCollectionOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the UpdateCollectionOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateCollectionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateCollectionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the trainingStatus.
     *
     * @param trainingStatus the trainingStatus
     * @return the UpdateCollectionOptions builder
     */
    public Builder trainingStatus(TrainingStatus trainingStatus) {
      this.trainingStatus = trainingStatus;
      return this;
    }
  }

  protected UpdateCollectionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    collectionId = builder.collectionId;
    name = builder.name;
    description = builder.description;
    trainingStatus = builder.trainingStatus;
  }

  /**
   * New builder.
   *
   * @return a UpdateCollectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * <p>The identifier of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the collection. The name can contain alphanumeric, underscore, hyphen, and dot
   * characters. It cannot begin with the reserved prefix `sys-`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the collection.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the trainingStatus.
   *
   * <p>Training status information for the collection.
   *
   * @return the trainingStatus
   */
  public TrainingStatus trainingStatus() {
    return trainingStatus;
  }
}

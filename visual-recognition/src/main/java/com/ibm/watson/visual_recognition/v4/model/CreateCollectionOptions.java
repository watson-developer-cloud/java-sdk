/*
 * (C) Copyright IBM Corp. 2019, 2021.
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

/** The createCollection options. */
public class CreateCollectionOptions extends GenericModel {

  protected String name;
  protected String description;
  protected TrainingStatus trainingStatus;

  /** Builder. */
  public static class Builder {
    private String name;
    private String description;
    private TrainingStatus trainingStatus;

    private Builder(CreateCollectionOptions createCollectionOptions) {
      this.name = createCollectionOptions.name;
      this.description = createCollectionOptions.description;
      this.trainingStatus = createCollectionOptions.trainingStatus;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a CreateCollectionOptions.
     *
     * @return the new CreateCollectionOptions instance
     */
    public CreateCollectionOptions build() {
      return new CreateCollectionOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateCollectionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateCollectionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the trainingStatus.
     *
     * @param trainingStatus the trainingStatus
     * @return the CreateCollectionOptions builder
     */
    public Builder trainingStatus(TrainingStatus trainingStatus) {
      this.trainingStatus = trainingStatus;
      return this;
    }
  }

  protected CreateCollectionOptions(Builder builder) {
    name = builder.name;
    description = builder.description;
    trainingStatus = builder.trainingStatus;
  }

  /**
   * New builder.
   *
   * @return a CreateCollectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

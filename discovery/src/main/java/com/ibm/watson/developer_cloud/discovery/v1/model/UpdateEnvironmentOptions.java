/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * the updateEnvironment options.
 */
public class UpdateEnvironmentOptions extends GenericModel {

  /** the ID of your environment. */
  @SerializedName("environment_id")
  private String environmentId;
  /** Name that identifies the environment. */
  private String name;
  /** Description of the environment. */
  private String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String name;
    private String description;

    private Builder(UpdateEnvironmentOptions updateEnvironmentOptions) {
      environmentId = updateEnvironmentOptions.environmentId;
      name = updateEnvironmentOptions.name;
      description = updateEnvironmentOptions.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     */
    public Builder(String environmentId) {
      this.environmentId = environmentId;
    }

    /**
     * Builds a UpdateEnvironmentOptions.
     *
     * @return the updateEnvironmentOptions
     */
    public UpdateEnvironmentOptions build() {
      return new UpdateEnvironmentOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  private UpdateEnvironmentOptions(Builder builder) {
    Validator.notNull(builder.environmentId, "environmentId cannot be null");
    environmentId = builder.environmentId;
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UpdateEnvironmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

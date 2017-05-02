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
 * UpdateCollectionRequest.
 */
public class UpdateCollectionRequest extends GenericModel {

  /** The name of the collection. */
  private String name;
  /** A description of the collection. */
  private String description;
  /** The ID of the configuration in which the collection is to be updated. */
  @SerializedName("configuration_id")
  private String configurationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private String configurationId;

    private Builder(UpdateCollectionRequest updateCollectionRequest) {
      name = updateCollectionRequest.name;
      description = updateCollectionRequest.description;
      configurationId = updateCollectionRequest.configurationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds a UpdateCollectionRequest.
     *
     * @return the updateCollectionRequest
     */
    public UpdateCollectionRequest build() {
      return new UpdateCollectionRequest(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateCollectionRequest builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateCollectionRequest builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the configurationId.
     *
     * @param configurationId the configurationId
     * @return the UpdateCollectionRequest builder
     */
    public Builder configurationId(String configurationId) {
      this.configurationId = configurationId;
      return this;
    }
  }

  private UpdateCollectionRequest(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    name = builder.name;
    description = builder.description;
    configurationId = builder.configurationId;
  }

  /**
   * New builder.
   *
   * @return a UpdateCollectionRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

  /**
   * Gets the configurationId.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }
}

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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The deleteConfiguration options.
 */
public class DeleteConfigurationOptions extends GenericModel {

  private String environmentId;
  private String configurationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String configurationId;

    private Builder(DeleteConfigurationOptions deleteConfigurationOptions) {
      environmentId = deleteConfigurationOptions.environmentId;
      configurationId = deleteConfigurationOptions.configurationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param configurationId the configurationId
     */
    public Builder(String environmentId, String configurationId) {
      this.environmentId = environmentId;
      this.configurationId = configurationId;
    }

    /**
     * Builds a DeleteConfigurationOptions.
     *
     * @return the deleteConfigurationOptions
     */
    public DeleteConfigurationOptions build() {
      return new DeleteConfigurationOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the DeleteConfigurationOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the configurationId.
     *
     * @param configurationId the configurationId
     * @return the DeleteConfigurationOptions builder
     */
    public Builder configurationId(String configurationId) {
      this.configurationId = configurationId;
      return this;
    }
  }

  private DeleteConfigurationOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.configurationId, "configurationId cannot be empty");
    environmentId = builder.environmentId;
    configurationId = builder.configurationId;
  }

  /**
   * New builder.
   *
   * @return a DeleteConfigurationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the configurationId.
   *
   * The ID of the configuration.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }
}

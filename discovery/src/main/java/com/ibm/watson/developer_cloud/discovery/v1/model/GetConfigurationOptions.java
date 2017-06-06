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
 * the getConfiguration options.
 */
public class GetConfigurationOptions extends GenericModel {

  /** the ID of your environment. */
  private String environmentId;
  /** the ID of your configuration. */
  private String configurationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String configurationId;

    private Builder(GetConfigurationOptions getConfigurationOptions) {
      environmentId = getConfigurationOptions.environmentId;
      configurationId = getConfigurationOptions.configurationId;
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
     * Builds a GetConfigurationOptions.
     *
     * @return the getConfigurationOptions
     */
    public GetConfigurationOptions build() {
      return new GetConfigurationOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the GetConfigurationOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the configurationId.
     *
     * @param configurationId the configurationId
     * @return the GetConfigurationOptions builder
     */
    public Builder configurationId(String configurationId) {
      this.configurationId = configurationId;
      return this;
    }
  }

  private GetConfigurationOptions(Builder builder) {
    Validator.notNull(builder.environmentId, "environmentId cannot be null");
    Validator.notNull(builder.configurationId, "configurationId cannot be null");
    environmentId = builder.environmentId;
    configurationId = builder.configurationId;
  }

  /**
   * New builder.
   *
   * @return a GetConfigurationOptions builder
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
   * Gets the configurationId.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }
}

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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteConfiguration options. */
public class DeleteConfigurationOptions extends GenericModel {

  protected String environmentId;
  protected String configurationId;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String configurationId;

    /**
     * Instantiates a new Builder from an existing DeleteConfigurationOptions instance.
     *
     * @param deleteConfigurationOptions the instance to initialize the Builder with
     */
    private Builder(DeleteConfigurationOptions deleteConfigurationOptions) {
      this.environmentId = deleteConfigurationOptions.environmentId;
      this.configurationId = deleteConfigurationOptions.configurationId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * @return the new DeleteConfigurationOptions instance
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

  protected DeleteConfigurationOptions() {}

  protected DeleteConfigurationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.configurationId, "configurationId cannot be empty");
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
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the configurationId.
   *
   * <p>The ID of the configuration.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }
}

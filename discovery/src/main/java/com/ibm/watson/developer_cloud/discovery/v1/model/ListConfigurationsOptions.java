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
 * The listConfigurations options.
 */
public class ListConfigurationsOptions extends GenericModel {

  private String environmentId;
  private String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String name;

    private Builder(ListConfigurationsOptions listConfigurationsOptions) {
      environmentId = listConfigurationsOptions.environmentId;
      name = listConfigurationsOptions.name;
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
     */
    public Builder(String environmentId) {
      this.environmentId = environmentId;
    }

    /**
     * Builds a ListConfigurationsOptions.
     *
     * @return the listConfigurationsOptions
     */
    public ListConfigurationsOptions build() {
      return new ListConfigurationsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the ListConfigurationsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListConfigurationsOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  private ListConfigurationsOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    environmentId = builder.environmentId;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a ListConfigurationsOptions builder
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
   * Gets the name.
   *
   * Find configurations with the given name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

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

/**
 * UpdateEnvironmentRequest.
 */
public class UpdateEnvironmentRequest extends GenericModel {

  /** Name that identifies the environment. */
  private String name;
  /** Description of the environment. */
  private String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;

    private Builder(UpdateEnvironmentRequest updateEnvironmentRequest) {
      name = updateEnvironmentRequest.name;
      description = updateEnvironmentRequest.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds a UpdateEnvironmentRequest.
     *
     * @return the updateEnvironmentRequest
     */
    public UpdateEnvironmentRequest build() {
      return new UpdateEnvironmentRequest(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateEnvironmentRequest builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateEnvironmentRequest builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  private UpdateEnvironmentRequest(Builder builder) {
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UpdateEnvironmentRequest builder
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
}

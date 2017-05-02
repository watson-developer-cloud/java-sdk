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
 * CreateEnvironmentRequest.
 */
public class CreateEnvironmentRequest extends GenericModel {

  /** Name that identifies the environment. */
  private String name;
  /** Description of the environment. */
  private String description;
  /** Size of the environment. */
  private Long size;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private Long size;

    private Builder(CreateEnvironmentRequest createEnvironmentRequest) {
      name = createEnvironmentRequest.name;
      description = createEnvironmentRequest.description;
      size = createEnvironmentRequest.size;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds a CreateEnvironmentRequest.
     *
     * @return the createEnvironmentRequest
     */
    public CreateEnvironmentRequest build() {
      return new CreateEnvironmentRequest(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateEnvironmentRequest builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateEnvironmentRequest builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the size.
     *
     * @param size the size
     * @return the CreateEnvironmentRequest builder
     */
    public Builder size(Long size) {
      this.size = size;
      return this;
    }
  }

  private CreateEnvironmentRequest(Builder builder) {
    name = builder.name;
    description = builder.description;
    size = builder.size;
  }

  /**
   * New builder.
   *
   * @return a CreateEnvironmentRequest builder
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
   * Gets the size.
   *
   * @return the size
   */
  public Long size() {
    return size;
  }
}

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
 * the createEnvironment options.
 */
public class CreateEnvironmentOptions extends GenericModel {

  /** Size of the environment. */
  private Long size;
  /** Name that identifies the environment. */
  private String name;
  /** Description of the environment. */
  private String description;

  /**
   * Builder.
   */
  public static class Builder {
    private Long size;
    private String name;
    private String description;

    private Builder(CreateEnvironmentOptions createEnvironmentOptions) {
      size = createEnvironmentOptions.size;
      name = createEnvironmentOptions.name;
      description = createEnvironmentOptions.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateEnvironmentOptions.
     *
     * @return the createEnvironmentOptions
     */
    public CreateEnvironmentOptions build() {
      return new CreateEnvironmentOptions(this);
    }

    /**
     * Set the size.
     *
     * @param size the size
     * @return the CreateEnvironmentOptions builder
     */
    public Builder size(Long size) {
      this.size = size;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateEnvironmentOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateEnvironmentOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  private CreateEnvironmentOptions(Builder builder) {
    size = builder.size;
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateEnvironmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the size.
   *
   * @return the size
   */
  public Long size() {
    return size;
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

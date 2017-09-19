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
 * The createEnvironment options.
 */
public class CreateEnvironmentOptions extends GenericModel {

  private String name;
  private String description;
  private Long size;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private Long size;

    private Builder(CreateEnvironmentOptions createEnvironmentOptions) {
      name = createEnvironmentOptions.name;
      description = createEnvironmentOptions.description;
      size = createEnvironmentOptions.size;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
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

    /**
     * Set the size.
     *
     * @param size the size
     * @return the CreateEnvironmentOptions builder
     */
    public Builder size(long size) {
      this.size = size;
      return this;
    }
  }

  private CreateEnvironmentOptions(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    name = builder.name;
    description = builder.description;
    size = builder.size;
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
   * Gets the name.
   *
   * Name that identifies the environment.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the environment.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the size.
   *
   * **Deprecated**: Size of the environment.
   *
   * @return the size
   */
  public Long size() {
    return size;
  }
}

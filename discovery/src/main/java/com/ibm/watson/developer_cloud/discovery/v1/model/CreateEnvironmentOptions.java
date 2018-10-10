/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

  /**
   * Size of the environment. In the Lite plan the default and only accepted value is `LT`, in all other plans the
   * default is `S`.
   */
  public interface Size {
    /** LT. */
    String LT = "LT";
    /** XS. */
    String XS = "XS";
    /** S. */
    String S = "S";
    /** MS. */
    String MS = "MS";
    /** M. */
    String M = "M";
    /** ML. */
    String ML = "ML";
    /** L. */
    String L = "L";
    /** XL. */
    String XL = "XL";
    /** XXL. */
    String XXL = "XXL";
    /** XXXL. */
    String XXXL = "XXXL";
  }

  private String name;
  private String description;
  private String size;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private String size;

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
    public Builder size(String size) {
      this.size = size;
      return this;
    }

    /**
     * @deprecated This method no longer has an effect on the created environment. Please use the String method.
     */
    public Builder size(Long size) {
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
   * Size of the environment. In the Lite plan the default and only accepted value is `LT`, in all other plans the
   * default is `S`.
   *
   * @return the size
   */
  public String size() {
    return size;
  }
}

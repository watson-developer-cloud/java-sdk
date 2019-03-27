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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The updateEnvironment options.
 */
public class UpdateEnvironmentOptions extends GenericModel {

  /**
   * Size that the environment should be increased to. Environment size cannot be modified when using a Lite plan.
   * Environment size can only increased and not decreased.
   */
  public interface Size {
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

  private String environmentId;
  private String name;
  private String description;
  private String size;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String name;
    private String description;
    private String size;

    private Builder(UpdateEnvironmentOptions updateEnvironmentOptions) {
      this.environmentId = updateEnvironmentOptions.environmentId;
      this.name = updateEnvironmentOptions.name;
      this.description = updateEnvironmentOptions.description;
      this.size = updateEnvironmentOptions.size;
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
     * Builds a UpdateEnvironmentOptions.
     *
     * @return the updateEnvironmentOptions
     */
    public UpdateEnvironmentOptions build() {
      return new UpdateEnvironmentOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the size.
     *
     * @param size the size
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder size(String size) {
      this.size = size;
      return this;
    }
  }

  private UpdateEnvironmentOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    environmentId = builder.environmentId;
    name = builder.name;
    description = builder.description;
    size = builder.size;
  }

  /**
   * New builder.
   *
   * @return a UpdateEnvironmentOptions builder
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
   * Size that the environment should be increased to. Environment size cannot be modified when using a Lite plan.
   * Environment size can only increased and not decreased.
   *
   * @return the size
   */
  public String size() {
    return size;
  }
}

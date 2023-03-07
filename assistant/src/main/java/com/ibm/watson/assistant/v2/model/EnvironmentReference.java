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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** EnvironmentReference. */
public class EnvironmentReference extends GenericModel {

  /**
   * The type of the environment. All environments other than the draft and live environments have
   * the type `staging`.
   */
  public interface Environment {
    /** draft. */
    String DRAFT = "draft";
    /** live. */
    String LIVE = "live";
    /** staging. */
    String STAGING = "staging";
  }

  protected String name;

  @SerializedName("environment_id")
  protected String environmentId;

  protected String environment;

  /** Builder. */
  public static class Builder {
    private String name;

    /**
     * Instantiates a new Builder from an existing EnvironmentReference instance.
     *
     * @param environmentReference the instance to initialize the Builder with
     */
    private Builder(EnvironmentReference environmentReference) {
      this.name = environmentReference.name;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a EnvironmentReference.
     *
     * @return the new EnvironmentReference instance
     */
    public EnvironmentReference build() {
      return new EnvironmentReference(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the EnvironmentReference builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected EnvironmentReference() {}

  protected EnvironmentReference(Builder builder) {
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a EnvironmentReference builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * <p>The name of the environment.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the environmentId.
   *
   * <p>The unique identifier of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the environment.
   *
   * <p>The type of the environment. All environments other than the draft and live environments
   * have the type `staging`.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }
}

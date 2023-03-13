/*
 * (C) Copyright IBM Corp. 2019, 2023.
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

/** The createGateway options. */
public class CreateGatewayOptions extends GenericModel {

  protected String environmentId;
  protected String name;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String name;

    /**
     * Instantiates a new Builder from an existing CreateGatewayOptions instance.
     *
     * @param createGatewayOptions the instance to initialize the Builder with
     */
    private Builder(CreateGatewayOptions createGatewayOptions) {
      this.environmentId = createGatewayOptions.environmentId;
      this.name = createGatewayOptions.name;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     */
    public Builder(String environmentId) {
      this.environmentId = environmentId;
    }

    /**
     * Builds a CreateGatewayOptions.
     *
     * @return the new CreateGatewayOptions instance
     */
    public CreateGatewayOptions build() {
      return new CreateGatewayOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateGatewayOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateGatewayOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected CreateGatewayOptions() {}

  protected CreateGatewayOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    environmentId = builder.environmentId;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a CreateGatewayOptions builder
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
   * Gets the name.
   *
   * <p>User-defined name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

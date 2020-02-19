/*
 * (C) Copyright IBM Corp. 2020.
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

/**
 * The deleteGateway options.
 */
public class DeleteGatewayOptions extends GenericModel {

  protected String environmentId;
  protected String gatewayId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String gatewayId;

    private Builder(DeleteGatewayOptions deleteGatewayOptions) {
      this.environmentId = deleteGatewayOptions.environmentId;
      this.gatewayId = deleteGatewayOptions.gatewayId;
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
     * @param gatewayId the gatewayId
     */
    public Builder(String environmentId, String gatewayId) {
      this.environmentId = environmentId;
      this.gatewayId = gatewayId;
    }

    /**
     * Builds a DeleteGatewayOptions.
     *
     * @return the deleteGatewayOptions
     */
    public DeleteGatewayOptions build() {
      return new DeleteGatewayOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the DeleteGatewayOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the gatewayId.
     *
     * @param gatewayId the gatewayId
     * @return the DeleteGatewayOptions builder
     */
    public Builder gatewayId(String gatewayId) {
      this.gatewayId = gatewayId;
      return this;
    }
  }

  protected DeleteGatewayOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.environmentId,
      "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.gatewayId,
      "gatewayId cannot be empty");
    environmentId = builder.environmentId;
    gatewayId = builder.gatewayId;
  }

  /**
   * New builder.
   *
   * @return a DeleteGatewayOptions builder
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
   * Gets the gatewayId.
   *
   * The requested gateway ID.
   *
   * @return the gatewayId
   */
  public String gatewayId() {
    return gatewayId;
  }
}


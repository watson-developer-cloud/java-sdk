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
 * The getGatewayDetails options.
 */
public class GetGatewayDetailsOptions extends GenericModel {

  private String environmentId;
  private String gatewayId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String gatewayId;

    private Builder(GetGatewayDetailsOptions getGatewayDetailsOptions) {
      environmentId = getGatewayDetailsOptions.environmentId;
      gatewayId = getGatewayDetailsOptions.gatewayId;
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
     * Builds a GetGatewayDetailsOptions.
     *
     * @return the getGatewayDetailsOptions
     */
    public GetGatewayDetailsOptions build() {
      return new GetGatewayDetailsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the GetGatewayDetailsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the gatewayId.
     *
     * @param gatewayId the gatewayId
     * @return the GetGatewayDetailsOptions builder
     */
    public Builder gatewayId(String gatewayId) {
      this.gatewayId = gatewayId;
      return this;
    }
  }

  private GetGatewayDetailsOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.gatewayId, "gatewayId cannot be empty");
    environmentId = builder.environmentId;
    gatewayId = builder.gatewayId;
  }

  /**
   * New builder.
   *
   * @return a GetGatewayDetailsOptions builder
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

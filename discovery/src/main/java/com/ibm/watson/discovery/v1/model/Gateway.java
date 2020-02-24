/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object describing a specific gateway.
 */
public class Gateway extends GenericModel {

  /**
   * The current status of the gateway. `connected` means the gateway is connected to the remotly installed gateway.
   * `idle` means this gateway is not currently in use.
   */
  public interface Status {
    /** connected. */
    String CONNECTED = "connected";
    /** idle. */
    String IDLE = "idle";
  }

  @SerializedName("gateway_id")
  protected String gatewayId;
  protected String name;
  protected String status;
  protected String token;
  @SerializedName("token_id")
  protected String tokenId;

  /**
   * Gets the gatewayId.
   *
   * The gateway ID of the gateway.
   *
   * @return the gatewayId
   */
  public String getGatewayId() {
    return gatewayId;
  }

  /**
   * Gets the name.
   *
   * The user defined name of the gateway.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the status.
   *
   * The current status of the gateway. `connected` means the gateway is connected to the remotly installed gateway.
   * `idle` means this gateway is not currently in use.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the token.
   *
   * The generated **token** for this gateway. The value of this field is used when configuring the remotly installed
   * gateway.
   *
   * @return the token
   */
  public String getToken() {
    return token;
  }

  /**
   * Gets the tokenId.
   *
   * The generated **token_id** for this gateway. The value of this field is used when configuring the remotly installed
   * gateway.
   *
   * @return the tokenId
   */
  public String getTokenId() {
    return tokenId;
  }
}

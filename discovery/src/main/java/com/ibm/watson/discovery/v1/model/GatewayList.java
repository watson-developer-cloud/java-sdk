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
import java.util.List;

/** Object containing gateways array. */
public class GatewayList extends GenericModel {

  protected List<Gateway> gateways;

  protected GatewayList() {}

  /**
   * Gets the gateways.
   *
   * <p>Array of configured gateway connections.
   *
   * @return the gateways
   */
  public List<Gateway> getGateways() {
    return gateways;
  }
}

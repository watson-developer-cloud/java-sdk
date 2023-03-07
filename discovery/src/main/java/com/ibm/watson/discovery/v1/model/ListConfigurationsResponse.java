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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Object containing an array of available configurations. */
public class ListConfigurationsResponse extends GenericModel {

  protected List<Configuration> configurations;

  protected ListConfigurationsResponse() {}

  /**
   * Gets the configurations.
   *
   * <p>An array of configurations that are available for the service instance.
   *
   * @return the configurations
   */
  public List<Configuration> getConfigurations() {
    return configurations;
  }
}

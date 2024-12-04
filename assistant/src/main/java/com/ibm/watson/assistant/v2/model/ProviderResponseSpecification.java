/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** The specification of the provider. */
public class ProviderResponseSpecification extends GenericModel {

  protected List<ProviderResponseSpecificationServersItem> servers;
  protected ProviderResponseSpecificationComponents components;

  protected ProviderResponseSpecification() {}

  /**
   * Gets the servers.
   *
   * <p>An array of objects defining all endpoints of the provider.
   *
   * <p>**Note:** Multiple array items are reserved for future use.
   *
   * @return the servers
   */
  public List<ProviderResponseSpecificationServersItem> getServers() {
    return servers;
  }

  /**
   * Gets the components.
   *
   * <p>An object defining various reusable definitions of the provider.
   *
   * @return the components
   */
  public ProviderResponseSpecificationComponents getComponents() {
    return components;
  }
}

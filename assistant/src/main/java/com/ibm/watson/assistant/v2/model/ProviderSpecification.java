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
import java.util.ArrayList;
import java.util.List;

/** The specification of the provider. */
public class ProviderSpecification extends GenericModel {

  protected List<ProviderSpecificationServersItem> servers;
  protected ProviderSpecificationComponents components;

  /** Builder. */
  public static class Builder {
    private List<ProviderSpecificationServersItem> servers;
    private ProviderSpecificationComponents components;

    /**
     * Instantiates a new Builder from an existing ProviderSpecification instance.
     *
     * @param providerSpecification the instance to initialize the Builder with
     */
    private Builder(ProviderSpecification providerSpecification) {
      this.servers = providerSpecification.servers;
      this.components = providerSpecification.components;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param servers the servers
     */
    public Builder(List<ProviderSpecificationServersItem> servers) {
      this.servers = servers;
    }

    /**
     * Builds a ProviderSpecification.
     *
     * @return the new ProviderSpecification instance
     */
    public ProviderSpecification build() {
      return new ProviderSpecification(this);
    }

    /**
     * Adds a new element to servers.
     *
     * @param servers the new element to be added
     * @return the ProviderSpecification builder
     */
    public Builder addServers(ProviderSpecificationServersItem servers) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(servers, "servers cannot be null");
      if (this.servers == null) {
        this.servers = new ArrayList<ProviderSpecificationServersItem>();
      }
      this.servers.add(servers);
      return this;
    }

    /**
     * Set the servers. Existing servers will be replaced.
     *
     * @param servers the servers
     * @return the ProviderSpecification builder
     */
    public Builder servers(List<ProviderSpecificationServersItem> servers) {
      this.servers = servers;
      return this;
    }

    /**
     * Set the components.
     *
     * @param components the components
     * @return the ProviderSpecification builder
     */
    public Builder components(ProviderSpecificationComponents components) {
      this.components = components;
      return this;
    }
  }

  protected ProviderSpecification() {}

  protected ProviderSpecification(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.servers, "servers cannot be null");
    servers = builder.servers;
    components = builder.components;
  }

  /**
   * New builder.
   *
   * @return a ProviderSpecification builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the servers.
   *
   * <p>An array of objects defining all endpoints of the provider.
   *
   * <p>**Note:** Multiple array items are reserved for future use.
   *
   * @return the servers
   */
  public List<ProviderSpecificationServersItem> servers() {
    return servers;
  }

  /**
   * Gets the components.
   *
   * <p>An object defining various reusable definitions of the provider.
   *
   * @return the components
   */
  public ProviderSpecificationComponents components() {
    return components;
  }
}

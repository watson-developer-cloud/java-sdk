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

/** An object defining various reusable definitions of the provider. */
public class ProviderSpecificationComponents extends GenericModel {

  protected ProviderSpecificationComponentsSecuritySchemes securitySchemes;

  /** Builder. */
  public static class Builder {
    private ProviderSpecificationComponentsSecuritySchemes securitySchemes;

    /**
     * Instantiates a new Builder from an existing ProviderSpecificationComponents instance.
     *
     * @param providerSpecificationComponents the instance to initialize the Builder with
     */
    private Builder(ProviderSpecificationComponents providerSpecificationComponents) {
      this.securitySchemes = providerSpecificationComponents.securitySchemes;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderSpecificationComponents.
     *
     * @return the new ProviderSpecificationComponents instance
     */
    public ProviderSpecificationComponents build() {
      return new ProviderSpecificationComponents(this);
    }

    /**
     * Set the securitySchemes.
     *
     * @param securitySchemes the securitySchemes
     * @return the ProviderSpecificationComponents builder
     */
    public Builder securitySchemes(ProviderSpecificationComponentsSecuritySchemes securitySchemes) {
      this.securitySchemes = securitySchemes;
      return this;
    }
  }

  protected ProviderSpecificationComponents() {}

  protected ProviderSpecificationComponents(Builder builder) {
    securitySchemes = builder.securitySchemes;
  }

  /**
   * New builder.
   *
   * @return a ProviderSpecificationComponents builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the securitySchemes.
   *
   * <p>The definition of the security scheme for the provider.
   *
   * @return the securitySchemes
   */
  public ProviderSpecificationComponentsSecuritySchemes securitySchemes() {
    return securitySchemes;
  }
}

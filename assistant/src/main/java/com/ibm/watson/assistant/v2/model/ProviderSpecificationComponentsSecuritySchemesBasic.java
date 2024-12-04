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

/** Non-private settings for basic access authentication. */
public class ProviderSpecificationComponentsSecuritySchemesBasic extends GenericModel {

  protected ProviderAuthenticationTypeAndValue username;

  /** Builder. */
  public static class Builder {
    private ProviderAuthenticationTypeAndValue username;

    /**
     * Instantiates a new Builder from an existing
     * ProviderSpecificationComponentsSecuritySchemesBasic instance.
     *
     * @param providerSpecificationComponentsSecuritySchemesBasic the instance to initialize the
     *     Builder with
     */
    private Builder(
        ProviderSpecificationComponentsSecuritySchemesBasic
            providerSpecificationComponentsSecuritySchemesBasic) {
      this.username = providerSpecificationComponentsSecuritySchemesBasic.username;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderSpecificationComponentsSecuritySchemesBasic.
     *
     * @return the new ProviderSpecificationComponentsSecuritySchemesBasic instance
     */
    public ProviderSpecificationComponentsSecuritySchemesBasic build() {
      return new ProviderSpecificationComponentsSecuritySchemesBasic(this);
    }

    /**
     * Set the username.
     *
     * @param username the username
     * @return the ProviderSpecificationComponentsSecuritySchemesBasic builder
     */
    public Builder username(ProviderAuthenticationTypeAndValue username) {
      this.username = username;
      return this;
    }
  }

  protected ProviderSpecificationComponentsSecuritySchemesBasic() {}

  protected ProviderSpecificationComponentsSecuritySchemesBasic(Builder builder) {
    username = builder.username;
  }

  /**
   * New builder.
   *
   * @return a ProviderSpecificationComponentsSecuritySchemesBasic builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the username.
   *
   * <p>The username for basic access authentication.
   *
   * @return the username
   */
  public ProviderAuthenticationTypeAndValue username() {
    return username;
  }
}

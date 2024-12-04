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

/** Private information of the provider. */
public class ProviderPrivate extends GenericModel {

  protected ProviderPrivateAuthentication authentication;

  /** Builder. */
  public static class Builder {
    private ProviderPrivateAuthentication authentication;

    /**
     * Instantiates a new Builder from an existing ProviderPrivate instance.
     *
     * @param providerPrivate the instance to initialize the Builder with
     */
    private Builder(ProviderPrivate providerPrivate) {
      this.authentication = providerPrivate.authentication;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param authentication the authentication
     */
    public Builder(ProviderPrivateAuthentication authentication) {
      this.authentication = authentication;
    }

    /**
     * Builds a ProviderPrivate.
     *
     * @return the new ProviderPrivate instance
     */
    public ProviderPrivate build() {
      return new ProviderPrivate(this);
    }

    /**
     * Set the authentication.
     *
     * @param authentication the authentication
     * @return the ProviderPrivate builder
     */
    public Builder authentication(ProviderPrivateAuthentication authentication) {
      this.authentication = authentication;
      return this;
    }
  }

  protected ProviderPrivate() {}

  protected ProviderPrivate(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.authentication, "authentication cannot be null");
    authentication = builder.authentication;
  }

  /**
   * New builder.
   *
   * @return a ProviderPrivate builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the authentication.
   *
   * <p>Private authentication information of the provider.
   *
   * @return the authentication
   */
  public ProviderPrivateAuthentication authentication() {
    return authentication;
  }
}

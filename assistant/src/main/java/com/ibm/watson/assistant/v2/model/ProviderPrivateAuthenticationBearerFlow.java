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

/** The private data for bearer authentication. */
public class ProviderPrivateAuthenticationBearerFlow extends ProviderPrivateAuthentication {

  /** Builder. */
  public static class Builder {
    private ProviderAuthenticationTypeAndValue token;

    /**
     * Instantiates a new Builder from an existing ProviderPrivateAuthenticationBearerFlow instance.
     *
     * @param providerPrivateAuthenticationBearerFlow the instance to initialize the Builder with
     */
    public Builder(ProviderPrivateAuthentication providerPrivateAuthenticationBearerFlow) {
      this.token = providerPrivateAuthenticationBearerFlow.token;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderPrivateAuthenticationBearerFlow.
     *
     * @return the new ProviderPrivateAuthenticationBearerFlow instance
     */
    public ProviderPrivateAuthenticationBearerFlow build() {
      return new ProviderPrivateAuthenticationBearerFlow(this);
    }

    /**
     * Set the token.
     *
     * @param token the token
     * @return the ProviderPrivateAuthenticationBearerFlow builder
     */
    public Builder token(ProviderAuthenticationTypeAndValue token) {
      this.token = token;
      return this;
    }
  }

  protected ProviderPrivateAuthenticationBearerFlow() {}

  protected ProviderPrivateAuthenticationBearerFlow(Builder builder) {
    token = builder.token;
  }

  /**
   * New builder.
   *
   * @return a ProviderPrivateAuthenticationBearerFlow builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

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

/** The private data for basic authentication. */
public class ProviderPrivateAuthenticationBasicFlow extends ProviderPrivateAuthentication {

  /** Builder. */
  public static class Builder {
    private ProviderAuthenticationTypeAndValue password;

    /**
     * Instantiates a new Builder from an existing ProviderPrivateAuthenticationBasicFlow instance.
     *
     * @param providerPrivateAuthenticationBasicFlow the instance to initialize the Builder with
     */
    public Builder(ProviderPrivateAuthentication providerPrivateAuthenticationBasicFlow) {
      this.password = providerPrivateAuthenticationBasicFlow.password;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderPrivateAuthenticationBasicFlow.
     *
     * @return the new ProviderPrivateAuthenticationBasicFlow instance
     */
    public ProviderPrivateAuthenticationBasicFlow build() {
      return new ProviderPrivateAuthenticationBasicFlow(this);
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the ProviderPrivateAuthenticationBasicFlow builder
     */
    public Builder password(ProviderAuthenticationTypeAndValue password) {
      this.password = password;
      return this;
    }
  }

  protected ProviderPrivateAuthenticationBasicFlow() {}

  protected ProviderPrivateAuthenticationBasicFlow(Builder builder) {
    password = builder.password;
  }

  /**
   * New builder.
   *
   * @return a ProviderPrivateAuthenticationBasicFlow builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

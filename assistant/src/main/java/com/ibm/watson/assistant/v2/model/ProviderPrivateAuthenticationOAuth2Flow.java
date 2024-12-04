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

/** The private data for oauth2 authentication. */
public class ProviderPrivateAuthenticationOAuth2Flow extends ProviderPrivateAuthentication {

  /** Builder. */
  public static class Builder {
    private ProviderPrivateAuthenticationOAuth2FlowFlows flows;

    /**
     * Instantiates a new Builder from an existing ProviderPrivateAuthenticationOAuth2Flow instance.
     *
     * @param providerPrivateAuthenticationOAuth2Flow the instance to initialize the Builder with
     */
    public Builder(ProviderPrivateAuthentication providerPrivateAuthenticationOAuth2Flow) {
      this.flows = providerPrivateAuthenticationOAuth2Flow.flows;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderPrivateAuthenticationOAuth2Flow.
     *
     * @return the new ProviderPrivateAuthenticationOAuth2Flow instance
     */
    public ProviderPrivateAuthenticationOAuth2Flow build() {
      return new ProviderPrivateAuthenticationOAuth2Flow(this);
    }

    /**
     * Set the flows.
     *
     * @param flows the flows
     * @return the ProviderPrivateAuthenticationOAuth2Flow builder
     */
    public Builder flows(ProviderPrivateAuthenticationOAuth2FlowFlows flows) {
      this.flows = flows;
      return this;
    }
  }

  protected ProviderPrivateAuthenticationOAuth2Flow() {}

  protected ProviderPrivateAuthenticationOAuth2Flow(Builder builder) {
    flows = builder.flows;
  }

  /**
   * New builder.
   *
   * @return a ProviderPrivateAuthenticationOAuth2Flow builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

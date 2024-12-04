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

/** ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom. */
public class ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
    extends ProviderPrivateAuthenticationOAuth2FlowFlows {

  /** Builder. */
  public static class Builder {
    private ProviderPrivateAuthenticationOAuth2CustomCustomOauth2Property customOauth2Property;

    /**
     * Instantiates a new Builder from an existing
     * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
     * instance.
     *
     * @param providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
     *     the instance to initialize the Builder with
     */
    public Builder(
        ProviderPrivateAuthenticationOAuth2FlowFlows
            providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom) {
      this.customOauth2Property =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
              .customOauth2Property;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a
     * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom.
     *
     * @return the new
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
     *     instance
     */
    public ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
        build() {
      return new ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom(
          this);
    }

    /**
     * Set the customOauth2Property.
     *
     * @param customOauth2Property the customOauth2Property
     * @return the
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
     *     builder
     */
    public Builder customOauth2Property(
        ProviderPrivateAuthenticationOAuth2CustomCustomOauth2Property customOauth2Property) {
      this.customOauth2Property = customOauth2Property;
      return this;
    }
  }

  protected
  ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom() {}

  protected ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom(
      Builder builder) {
    customOauth2Property = builder.customOauth2Property;
  }

  /**
   * New builder.
   *
   * @return a ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
   *     builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

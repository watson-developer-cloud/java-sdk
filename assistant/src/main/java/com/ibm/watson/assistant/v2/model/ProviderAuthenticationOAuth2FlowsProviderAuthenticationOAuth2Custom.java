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

/** ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom. */
public class ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom
    extends ProviderAuthenticationOAuth2Flows {

  /** Builder. */
  public static class Builder {
    private ProviderAuthenticationOAuth2CustomCustomOauth2Property customOauth2Property;

    /**
     * Instantiates a new Builder from an existing
     * ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom instance.
     *
     * @param providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom the instance to
     *     initialize the Builder with
     */
    public Builder(
        ProviderAuthenticationOAuth2Flows
            providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom) {
      this.customOauth2Property =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom.customOauth2Property;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom.
     *
     * @return the new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom instance
     */
    public ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom build() {
      return new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom(this);
    }

    /**
     * Set the customOauth2Property.
     *
     * @param customOauth2Property the customOauth2Property
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom builder
     */
    public Builder customOauth2Property(
        ProviderAuthenticationOAuth2CustomCustomOauth2Property customOauth2Property) {
      this.customOauth2Property = customOauth2Property;
      return this;
    }
  }

  protected ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom() {}

  protected ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom(Builder builder) {
    customOauth2Property = builder.customOauth2Property;
  }

  /**
   * New builder.
   *
   * @return a ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

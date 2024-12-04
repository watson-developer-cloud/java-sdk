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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The definition of the security scheme for the provider. */
public class ProviderSpecificationComponentsSecuritySchemes extends GenericModel {

  /**
   * The authentication method required for requests made from watsonx Assistant to the
   * conversational skill provider.
   */
  public interface AuthenticationMethod {
    /** basic. */
    String BASIC = "basic";
    /** bearer. */
    String BEARER = "bearer";
    /** api_key. */
    String API_KEY = "api_key";
    /** oauth2. */
    String OAUTH2 = "oauth2";
    /** none. */
    String NONE = "none";
  }

  @SerializedName("authentication_method")
  protected String authenticationMethod;

  protected ProviderSpecificationComponentsSecuritySchemesBasic basic;
  protected ProviderAuthenticationOAuth2 oauth2;

  /** Builder. */
  public static class Builder {
    private String authenticationMethod;
    private ProviderSpecificationComponentsSecuritySchemesBasic basic;
    private ProviderAuthenticationOAuth2 oauth2;

    /**
     * Instantiates a new Builder from an existing ProviderSpecificationComponentsSecuritySchemes
     * instance.
     *
     * @param providerSpecificationComponentsSecuritySchemes the instance to initialize the Builder
     *     with
     */
    private Builder(
        ProviderSpecificationComponentsSecuritySchemes
            providerSpecificationComponentsSecuritySchemes) {
      this.authenticationMethod =
          providerSpecificationComponentsSecuritySchemes.authenticationMethod;
      this.basic = providerSpecificationComponentsSecuritySchemes.basic;
      this.oauth2 = providerSpecificationComponentsSecuritySchemes.oauth2;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderSpecificationComponentsSecuritySchemes.
     *
     * @return the new ProviderSpecificationComponentsSecuritySchemes instance
     */
    public ProviderSpecificationComponentsSecuritySchemes build() {
      return new ProviderSpecificationComponentsSecuritySchemes(this);
    }

    /**
     * Set the authenticationMethod.
     *
     * @param authenticationMethod the authenticationMethod
     * @return the ProviderSpecificationComponentsSecuritySchemes builder
     */
    public Builder authenticationMethod(String authenticationMethod) {
      this.authenticationMethod = authenticationMethod;
      return this;
    }

    /**
     * Set the basic.
     *
     * @param basic the basic
     * @return the ProviderSpecificationComponentsSecuritySchemes builder
     */
    public Builder basic(ProviderSpecificationComponentsSecuritySchemesBasic basic) {
      this.basic = basic;
      return this;
    }

    /**
     * Set the oauth2.
     *
     * @param oauth2 the oauth2
     * @return the ProviderSpecificationComponentsSecuritySchemes builder
     */
    public Builder oauth2(ProviderAuthenticationOAuth2 oauth2) {
      this.oauth2 = oauth2;
      return this;
    }
  }

  protected ProviderSpecificationComponentsSecuritySchemes() {}

  protected ProviderSpecificationComponentsSecuritySchemes(Builder builder) {
    authenticationMethod = builder.authenticationMethod;
    basic = builder.basic;
    oauth2 = builder.oauth2;
  }

  /**
   * New builder.
   *
   * @return a ProviderSpecificationComponentsSecuritySchemes builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the authenticationMethod.
   *
   * <p>The authentication method required for requests made from watsonx Assistant to the
   * conversational skill provider.
   *
   * @return the authenticationMethod
   */
  public String authenticationMethod() {
    return authenticationMethod;
  }

  /**
   * Gets the basic.
   *
   * <p>Non-private settings for basic access authentication.
   *
   * @return the basic
   */
  public ProviderSpecificationComponentsSecuritySchemesBasic basic() {
    return basic;
  }

  /**
   * Gets the oauth2.
   *
   * <p>Non-private settings for oauth2 authentication.
   *
   * @return the oauth2
   */
  public ProviderAuthenticationOAuth2 oauth2() {
    return oauth2;
  }
}

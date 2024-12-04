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
public class ProviderResponseSpecificationComponentsSecuritySchemes extends GenericModel {

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

  protected ProviderResponseSpecificationComponentsSecuritySchemesBasic basic;
  protected ProviderAuthenticationOAuth2 oauth2;

  protected ProviderResponseSpecificationComponentsSecuritySchemes() {}

  /**
   * Gets the authenticationMethod.
   *
   * <p>The authentication method required for requests made from watsonx Assistant to the
   * conversational skill provider.
   *
   * @return the authenticationMethod
   */
  public String getAuthenticationMethod() {
    return authenticationMethod;
  }

  /**
   * Gets the basic.
   *
   * <p>Non-private settings for basic access authentication.
   *
   * @return the basic
   */
  public ProviderResponseSpecificationComponentsSecuritySchemesBasic getBasic() {
    return basic;
  }

  /**
   * Gets the oauth2.
   *
   * <p>Non-private settings for oauth2 authentication.
   *
   * @return the oauth2
   */
  public ProviderAuthenticationOAuth2 getOauth2() {
    return oauth2;
  }
}

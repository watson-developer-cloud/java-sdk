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

/**
 * Private authentication information of the provider.
 *
 * <p>Classes which extend this class: - ProviderPrivateAuthenticationBearerFlow -
 * ProviderPrivateAuthenticationBasicFlow - ProviderPrivateAuthenticationOAuth2Flow
 */
public class ProviderPrivateAuthentication extends GenericModel {

  protected ProviderAuthenticationTypeAndValue token;
  protected ProviderAuthenticationTypeAndValue password;
  protected ProviderPrivateAuthenticationOAuth2FlowFlows flows;

  protected ProviderPrivateAuthentication() {}

  /**
   * Gets the token.
   *
   * <p>The token for bearer authentication.
   *
   * @return the token
   */
  public ProviderAuthenticationTypeAndValue token() {
    return token;
  }

  /**
   * Gets the password.
   *
   * <p>The password for bearer authentication.
   *
   * @return the password
   */
  public ProviderAuthenticationTypeAndValue password() {
    return password;
  }

  /**
   * Gets the flows.
   *
   * <p>Scenarios performed by the API client to fetch an access token from the authorization
   * server.
   *
   * @return the flows
   */
  public ProviderPrivateAuthenticationOAuth2FlowFlows flows() {
    return flows;
  }
}

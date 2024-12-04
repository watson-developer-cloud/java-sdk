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

/** The username for oauth2 authentication when the preferred flow is "password". */
public class ProviderAuthenticationOAuth2PasswordUsername extends GenericModel {

  /** The type of property observed in "value". */
  public interface Type {
    /** value. */
    String VALUE = "value";
  }

  protected String type;
  protected String value;

  /** Builder. */
  public static class Builder {
    private String type;
    private String value;

    /**
     * Instantiates a new Builder from an existing ProviderAuthenticationOAuth2PasswordUsername
     * instance.
     *
     * @param providerAuthenticationOAuth2PasswordUsername the instance to initialize the Builder
     *     with
     */
    private Builder(
        ProviderAuthenticationOAuth2PasswordUsername providerAuthenticationOAuth2PasswordUsername) {
      this.type = providerAuthenticationOAuth2PasswordUsername.type;
      this.value = providerAuthenticationOAuth2PasswordUsername.value;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderAuthenticationOAuth2PasswordUsername.
     *
     * @return the new ProviderAuthenticationOAuth2PasswordUsername instance
     */
    public ProviderAuthenticationOAuth2PasswordUsername build() {
      return new ProviderAuthenticationOAuth2PasswordUsername(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ProviderAuthenticationOAuth2PasswordUsername builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ProviderAuthenticationOAuth2PasswordUsername builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected ProviderAuthenticationOAuth2PasswordUsername() {}

  protected ProviderAuthenticationOAuth2PasswordUsername(Builder builder) {
    type = builder.type;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a ProviderAuthenticationOAuth2PasswordUsername builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * <p>The type of property observed in "value".
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the value.
   *
   * <p>The stored information of the value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The registerCallback options. */
public class RegisterCallbackOptions extends GenericModel {

  protected String callbackUrl;
  protected String userSecret;

  /** Builder. */
  public static class Builder {
    private String callbackUrl;
    private String userSecret;

    private Builder(RegisterCallbackOptions registerCallbackOptions) {
      this.callbackUrl = registerCallbackOptions.callbackUrl;
      this.userSecret = registerCallbackOptions.userSecret;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param callbackUrl the callbackUrl
     */
    public Builder(String callbackUrl) {
      this.callbackUrl = callbackUrl;
    }

    /**
     * Builds a RegisterCallbackOptions.
     *
     * @return the new RegisterCallbackOptions instance
     */
    public RegisterCallbackOptions build() {
      return new RegisterCallbackOptions(this);
    }

    /**
     * Set the callbackUrl.
     *
     * @param callbackUrl the callbackUrl
     * @return the RegisterCallbackOptions builder
     */
    public Builder callbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
      return this;
    }

    /**
     * Set the userSecret.
     *
     * @param userSecret the userSecret
     * @return the RegisterCallbackOptions builder
     */
    public Builder userSecret(String userSecret) {
      this.userSecret = userSecret;
      return this;
    }
  }

  protected RegisterCallbackOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.callbackUrl, "callbackUrl cannot be null");
    callbackUrl = builder.callbackUrl;
    userSecret = builder.userSecret;
  }

  /**
   * New builder.
   *
   * @return a RegisterCallbackOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the callbackUrl.
   *
   * <p>An HTTP or HTTPS URL to which callback notifications are to be sent. To be allowlisted, the
   * URL must successfully echo the challenge string during URL verification. During verification,
   * the client can also check the signature that the service sends in the `X-Callback-Signature`
   * header to verify the origin of the request.
   *
   * @return the callbackUrl
   */
  public String callbackUrl() {
    return callbackUrl;
  }

  /**
   * Gets the userSecret.
   *
   * <p>A user-specified string that the service uses to generate the HMAC-SHA1 signature that it
   * sends via the `X-Callback-Signature` header. The service includes the header during URL
   * verification and with every notification sent to the callback URL. It calculates the signature
   * over the payload of the notification. If you omit the parameter, the service does not send the
   * header.
   *
   * @return the userSecret
   */
  public String userSecret() {
    return userSecret;
  }
}

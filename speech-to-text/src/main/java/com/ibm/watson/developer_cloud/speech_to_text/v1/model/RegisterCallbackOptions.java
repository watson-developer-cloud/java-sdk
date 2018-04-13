/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The registerCallback options.
 */
public class RegisterCallbackOptions extends GenericModel {

  private String callbackUrl;
  private String userSecret;

  /**
   * Builder.
   */
  public static class Builder {
    private String callbackUrl;
    private String userSecret;

    private Builder(RegisterCallbackOptions registerCallbackOptions) {
      callbackUrl = registerCallbackOptions.callbackUrl;
      userSecret = registerCallbackOptions.userSecret;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

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
     * @return the registerCallbackOptions
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

  private RegisterCallbackOptions(Builder builder) {
    Validator.notNull(builder.callbackUrl, "callbackUrl cannot be null");
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
   * An HTTP or HTTPS URL to which callback notifications are to be sent. To be white-listed, the URL must successfully
   * echo the challenge string during URL verification. During verification, the client can also check the signature
   * that the service sends in the `X-Callback-Signature` header to verify the origin of the request.
   *
   * @return the callbackUrl
   */
  public String callbackUrl() {
    return callbackUrl;
  }

  /**
   * Gets the userSecret.
   *
   * A user-specified string that the service uses to generate the HMAC-SHA1 signature that it sends via the
   * `X-Callback-Signature` header. The service includes the header during URL verification and with every notification
   * sent to the callback URL. It calculates the signature over the payload of the notification. If you omit the
   * parameter, the service does not send the header.
   *
   * @return the userSecret
   */
  public String userSecret() {
    return userSecret;
  }
}

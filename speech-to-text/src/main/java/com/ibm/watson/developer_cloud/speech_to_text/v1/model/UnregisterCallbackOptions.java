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
 * The unregisterCallback options.
 */
public class UnregisterCallbackOptions extends GenericModel {

  private String callbackUrl;

  /**
   * Builder.
   */
  public static class Builder {
    private String callbackUrl;

    private Builder(UnregisterCallbackOptions unregisterCallbackOptions) {
      callbackUrl = unregisterCallbackOptions.callbackUrl;
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
     * Builds a UnregisterCallbackOptions.
     *
     * @return the unregisterCallbackOptions
     */
    public UnregisterCallbackOptions build() {
      return new UnregisterCallbackOptions(this);
    }

    /**
     * Set the callbackUrl.
     *
     * @param callbackUrl the callbackUrl
     * @return the UnregisterCallbackOptions builder
     */
    public Builder callbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
      return this;
    }
  }

  private UnregisterCallbackOptions(Builder builder) {
    Validator.notNull(builder.callbackUrl, "callbackUrl cannot be null");
    callbackUrl = builder.callbackUrl;
  }

  /**
   * New builder.
   *
   * @return a UnregisterCallbackOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the callbackUrl.
   *
   * The callback URL that is to be unregistered.
   *
   * @return the callbackUrl
   */
  public String callbackUrl() {
    return callbackUrl;
  }
}

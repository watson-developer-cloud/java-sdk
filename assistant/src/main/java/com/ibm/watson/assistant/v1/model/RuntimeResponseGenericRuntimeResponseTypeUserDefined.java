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

package com.ibm.watson.assistant.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** RuntimeResponseGenericRuntimeResponseTypeUserDefined. */
public class RuntimeResponseGenericRuntimeResponseTypeUserDefined extends RuntimeResponseGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private Map<String, Object> userDefined;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing
     * RuntimeResponseGenericRuntimeResponseTypeUserDefined instance.
     *
     * @param runtimeResponseGenericRuntimeResponseTypeUserDefined the instance to initialize the
     *     Builder with
     */
    public Builder(RuntimeResponseGeneric runtimeResponseGenericRuntimeResponseTypeUserDefined) {
      this.responseType = runtimeResponseGenericRuntimeResponseTypeUserDefined.responseType;
      this.userDefined = runtimeResponseGenericRuntimeResponseTypeUserDefined.userDefined;
      this.channels = runtimeResponseGenericRuntimeResponseTypeUserDefined.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param userDefined the userDefined
     */
    public Builder(String responseType, Map<String, Object> userDefined) {
      this.responseType = responseType;
      this.userDefined = userDefined;
    }

    /**
     * Builds a RuntimeResponseGenericRuntimeResponseTypeUserDefined.
     *
     * @return the new RuntimeResponseGenericRuntimeResponseTypeUserDefined instance
     */
    public RuntimeResponseGenericRuntimeResponseTypeUserDefined build() {
      return new RuntimeResponseGenericRuntimeResponseTypeUserDefined(this);
    }

    /**
     * Adds a new element to channels.
     *
     * @param channels the new element to be added
     * @return the RuntimeResponseGenericRuntimeResponseTypeUserDefined builder
     */
    public Builder addChannels(ResponseGenericChannel channels) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(channels, "channels cannot be null");
      if (this.channels == null) {
        this.channels = new ArrayList<ResponseGenericChannel>();
      }
      this.channels.add(channels);
      return this;
    }

    /**
     * Set the responseType.
     *
     * @param responseType the responseType
     * @return the RuntimeResponseGenericRuntimeResponseTypeUserDefined builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the userDefined.
     *
     * @param userDefined the userDefined
     * @return the RuntimeResponseGenericRuntimeResponseTypeUserDefined builder
     */
    public Builder userDefined(Map<String, Object> userDefined) {
      this.userDefined = userDefined;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the RuntimeResponseGenericRuntimeResponseTypeUserDefined builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected RuntimeResponseGenericRuntimeResponseTypeUserDefined() {}

  protected RuntimeResponseGenericRuntimeResponseTypeUserDefined(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.userDefined, "userDefined cannot be null");
    responseType = builder.responseType;
    userDefined = builder.userDefined;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a RuntimeResponseGenericRuntimeResponseTypeUserDefined builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

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

/** RuntimeResponseGenericRuntimeResponseTypeText. */
public class RuntimeResponseGenericRuntimeResponseTypeText extends RuntimeResponseGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String text;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing RuntimeResponseGenericRuntimeResponseTypeText
     * instance.
     *
     * @param runtimeResponseGenericRuntimeResponseTypeText the instance to initialize the Builder
     *     with
     */
    public Builder(RuntimeResponseGeneric runtimeResponseGenericRuntimeResponseTypeText) {
      this.responseType = runtimeResponseGenericRuntimeResponseTypeText.responseType;
      this.text = runtimeResponseGenericRuntimeResponseTypeText.text;
      this.channels = runtimeResponseGenericRuntimeResponseTypeText.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param text the text
     */
    public Builder(String responseType, String text) {
      this.responseType = responseType;
      this.text = text;
    }

    /**
     * Builds a RuntimeResponseGenericRuntimeResponseTypeText.
     *
     * @return the new RuntimeResponseGenericRuntimeResponseTypeText instance
     */
    public RuntimeResponseGenericRuntimeResponseTypeText build() {
      return new RuntimeResponseGenericRuntimeResponseTypeText(this);
    }

    /**
     * Adds a new element to channels.
     *
     * @param channels the new element to be added
     * @return the RuntimeResponseGenericRuntimeResponseTypeText builder
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
     * @return the RuntimeResponseGenericRuntimeResponseTypeText builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the RuntimeResponseGenericRuntimeResponseTypeText builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the RuntimeResponseGenericRuntimeResponseTypeText builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected RuntimeResponseGenericRuntimeResponseTypeText() {}

  protected RuntimeResponseGenericRuntimeResponseTypeText(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    responseType = builder.responseType;
    text = builder.text;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a RuntimeResponseGenericRuntimeResponseTypeText builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

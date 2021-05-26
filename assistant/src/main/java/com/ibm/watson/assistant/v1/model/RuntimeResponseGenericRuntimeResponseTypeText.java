/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/** RuntimeResponseGenericRuntimeResponseTypeText. */
public class RuntimeResponseGenericRuntimeResponseTypeText extends RuntimeResponseGeneric {

  @SerializedName("response_type")
  private String responseType;

  private String text;
  private List<ResponseGenericChannel> channels;

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String text;
    private List<ResponseGenericChannel> channels;

    public Builder(
        RuntimeResponseGenericRuntimeResponseTypeText
            runtimeResponseGenericRuntimeResponseTypeText) {
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
     * Adds an channels to channels.
     *
     * @param channels the new channels
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

  /**
   * Gets the responseType.
   *
   * <p>The type of response returned by the dialog node. The specified response type must be
   * supported by the client application or channel.
   *
   * @return the responseType
   */
  public String responseType() {
    return responseType;
  }

  /**
   * Gets the text.
   *
   * <p>The text of the response.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the channels.
   *
   * <p>An array of objects specifying channels for which the response is intended. If **channels**
   * is present, the response is intended for a built-in integration and should not be handled by an
   * API client.
   *
   * @return the channels
   */
  public List<ResponseGenericChannel> channels() {
    return channels;
  }
}

/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

/** RuntimeResponseGenericRuntimeResponseTypeImage. */
public class RuntimeResponseGenericRuntimeResponseTypeImage extends RuntimeResponseGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String source;
    private String title;
    private String description;
    private List<ResponseGenericChannel> channels;
    private String altText;

    /**
     * Instantiates a new Builder from an existing RuntimeResponseGenericRuntimeResponseTypeImage
     * instance.
     *
     * @param runtimeResponseGenericRuntimeResponseTypeImage the instance to initialize the Builder
     *     with
     */
    public Builder(RuntimeResponseGeneric runtimeResponseGenericRuntimeResponseTypeImage) {
      this.responseType = runtimeResponseGenericRuntimeResponseTypeImage.responseType;
      this.source = runtimeResponseGenericRuntimeResponseTypeImage.source;
      this.title = runtimeResponseGenericRuntimeResponseTypeImage.title;
      this.description = runtimeResponseGenericRuntimeResponseTypeImage.description;
      this.channels = runtimeResponseGenericRuntimeResponseTypeImage.channels;
      this.altText = runtimeResponseGenericRuntimeResponseTypeImage.altText;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param source the source
     */
    public Builder(String responseType, String source) {
      this.responseType = responseType;
      this.source = source;
    }

    /**
     * Builds a RuntimeResponseGenericRuntimeResponseTypeImage.
     *
     * @return the new RuntimeResponseGenericRuntimeResponseTypeImage instance
     */
    public RuntimeResponseGenericRuntimeResponseTypeImage build() {
      return new RuntimeResponseGenericRuntimeResponseTypeImage(this);
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the RuntimeResponseGenericRuntimeResponseTypeImage builder
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
     * @return the RuntimeResponseGenericRuntimeResponseTypeImage builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the RuntimeResponseGenericRuntimeResponseTypeImage builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the RuntimeResponseGenericRuntimeResponseTypeImage builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RuntimeResponseGenericRuntimeResponseTypeImage builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the RuntimeResponseGenericRuntimeResponseTypeImage builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }

    /**
     * Set the altText.
     *
     * @param altText the altText
     * @return the RuntimeResponseGenericRuntimeResponseTypeImage builder
     */
    public Builder altText(String altText) {
      this.altText = altText;
      return this;
    }
  }

  protected RuntimeResponseGenericRuntimeResponseTypeImage() {}

  protected RuntimeResponseGenericRuntimeResponseTypeImage(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.source, "source cannot be null");
    responseType = builder.responseType;
    source = builder.source;
    title = builder.title;
    description = builder.description;
    channels = builder.channels;
    altText = builder.altText;
  }

  /**
   * New builder.
   *
   * @return a RuntimeResponseGenericRuntimeResponseTypeImage builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

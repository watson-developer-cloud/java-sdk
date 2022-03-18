/*
 * (C) Copyright IBM Corp. 2022.
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

/** DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo
    extends DialogNodeOutputGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String source;
    private String title;
    private String description;
    private List<ResponseGenericChannel> channels;
    private Map<String, Object> channelOptions;
    private String altText;

    public Builder(
        DialogNodeOutputGeneric dialogNodeOutputGenericDialogNodeOutputResponseTypeVideo) {
      this.responseType = dialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.responseType;
      this.source = dialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.source;
      this.title = dialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.title;
      this.description = dialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.description;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.channels;
      this.channelOptions = dialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.channelOptions;
      this.altText = dialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.altText;
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
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo(this);
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
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
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }

    /**
     * Set the channelOptions.
     *
     * @param channelOptions the channelOptions
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
     */
    public Builder channelOptions(Map<String, Object> channelOptions) {
      this.channelOptions = channelOptions;
      return this;
    }

    /**
     * Set the altText.
     *
     * @param altText the altText
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
     */
    public Builder altText(String altText) {
      this.altText = altText;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.source, "source cannot be null");
    responseType = builder.responseType;
    source = builder.source;
    title = builder.title;
    description = builder.description;
    channels = builder.channels;
    channelOptions = builder.channelOptions;
    altText = builder.altText;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

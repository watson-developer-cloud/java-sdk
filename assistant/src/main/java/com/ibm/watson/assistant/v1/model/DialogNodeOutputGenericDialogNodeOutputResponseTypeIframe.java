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

/** DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe
    extends DialogNodeOutputGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String source;
    private String title;
    private String description;
    private String imageUrl;
    private List<ResponseGenericChannel> channels;

    public Builder(
        DialogNodeOutputGeneric dialogNodeOutputGenericDialogNodeOutputResponseTypeIframe) {
      this.responseType = dialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.responseType;
      this.source = dialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.source;
      this.title = dialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.title;
      this.description = dialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.description;
      this.imageUrl = dialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.imageUrl;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.channels;
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
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe(this);
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe builder
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
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the imageUrl.
     *
     * @param imageUrl the imageUrl
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe builder
     */
    public Builder imageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe() {}

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.source, "source cannot be null");
    responseType = builder.responseType;
    source = builder.source;
    title = builder.title;
    description = builder.description;
    imageUrl = builder.imageUrl;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** A reference to a media file to be sent as an attachment with the message. */
public class MessageInputAttachment extends GenericModel {

  protected String url;

  @SerializedName("media_type")
  protected String mediaType;

  /** Builder. */
  public static class Builder {
    private String url;
    private String mediaType;

    /**
     * Instantiates a new Builder from an existing MessageInputAttachment instance.
     *
     * @param messageInputAttachment the instance to initialize the Builder with
     */
    private Builder(MessageInputAttachment messageInputAttachment) {
      this.url = messageInputAttachment.url;
      this.mediaType = messageInputAttachment.mediaType;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     */
    public Builder(String url) {
      this.url = url;
    }

    /**
     * Builds a MessageInputAttachment.
     *
     * @return the new MessageInputAttachment instance
     */
    public MessageInputAttachment build() {
      return new MessageInputAttachment(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the MessageInputAttachment builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the mediaType.
     *
     * @param mediaType the mediaType
     * @return the MessageInputAttachment builder
     */
    public Builder mediaType(String mediaType) {
      this.mediaType = mediaType;
      return this;
    }
  }

  protected MessageInputAttachment() {}

  protected MessageInputAttachment(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url, "url cannot be null");
    url = builder.url;
    mediaType = builder.mediaType;
  }

  /**
   * New builder.
   *
   * @return a MessageInputAttachment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * <p>The URL of the media file.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the mediaType.
   *
   * <p>The media content type (such as a MIME type) of the attachment.
   *
   * @return the mediaType
   */
  public String mediaType() {
    return mediaType;
  }
}

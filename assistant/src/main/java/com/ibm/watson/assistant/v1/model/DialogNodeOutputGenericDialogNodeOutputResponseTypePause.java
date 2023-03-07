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
package com.ibm.watson.assistant.v1.model;

import java.util.ArrayList;
import java.util.List;

/** DialogNodeOutputGenericDialogNodeOutputResponseTypePause. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypePause
    extends DialogNodeOutputGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private Long time;
    private Boolean typing;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing
     * DialogNodeOutputGenericDialogNodeOutputResponseTypePause instance.
     *
     * @param dialogNodeOutputGenericDialogNodeOutputResponseTypePause the instance to initialize
     *     the Builder with
     */
    public Builder(
        DialogNodeOutputGeneric dialogNodeOutputGenericDialogNodeOutputResponseTypePause) {
      this.responseType = dialogNodeOutputGenericDialogNodeOutputResponseTypePause.responseType;
      this.time = dialogNodeOutputGenericDialogNodeOutputResponseTypePause.time;
      this.typing = dialogNodeOutputGenericDialogNodeOutputResponseTypePause.typing;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypePause.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param time the time
     */
    public Builder(String responseType, Long time) {
      this.responseType = responseType;
      this.time = time;
    }

    /**
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypePause.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypePause instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypePause build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypePause(this);
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypePause builder
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
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypePause builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the time.
     *
     * @param time the time
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypePause builder
     */
    public Builder time(long time) {
      this.time = time;
      return this;
    }

    /**
     * Set the typing.
     *
     * @param typing the typing
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypePause builder
     */
    public Builder typing(Boolean typing) {
      this.typing = typing;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypePause builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypePause() {}

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypePause(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.time, "time cannot be null");
    responseType = builder.responseType;
    time = builder.time;
    typing = builder.typing;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypePause builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

/*
 * (C) Copyright IBM Corp. 2021.
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

/** RuntimeResponseGenericRuntimeResponseTypePause. */
public class RuntimeResponseGenericRuntimeResponseTypePause extends RuntimeResponseGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private Long time;
    private Boolean typing;
    private List<ResponseGenericChannel> channels;

    public Builder(RuntimeResponseGeneric runtimeResponseGenericRuntimeResponseTypePause) {
      this.responseType = runtimeResponseGenericRuntimeResponseTypePause.responseType;
      this.time = runtimeResponseGenericRuntimeResponseTypePause.time;
      this.typing = runtimeResponseGenericRuntimeResponseTypePause.typing;
      this.channels = runtimeResponseGenericRuntimeResponseTypePause.channels;
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
     * Builds a RuntimeResponseGenericRuntimeResponseTypePause.
     *
     * @return the new RuntimeResponseGenericRuntimeResponseTypePause instance
     */
    public RuntimeResponseGenericRuntimeResponseTypePause build() {
      return new RuntimeResponseGenericRuntimeResponseTypePause(this);
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the RuntimeResponseGenericRuntimeResponseTypePause builder
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
     * @return the RuntimeResponseGenericRuntimeResponseTypePause builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the time.
     *
     * @param time the time
     * @return the RuntimeResponseGenericRuntimeResponseTypePause builder
     */
    public Builder time(long time) {
      this.time = time;
      return this;
    }

    /**
     * Set the typing.
     *
     * @param typing the typing
     * @return the RuntimeResponseGenericRuntimeResponseTypePause builder
     */
    public Builder typing(Boolean typing) {
      this.typing = typing;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the RuntimeResponseGenericRuntimeResponseTypePause builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected RuntimeResponseGenericRuntimeResponseTypePause(Builder builder) {
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
   * @return a RuntimeResponseGenericRuntimeResponseTypePause builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

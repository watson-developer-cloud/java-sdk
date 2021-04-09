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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** ResponseGenericChannel. */
public class ResponseGenericChannel extends GenericModel {

  /** A channel for which the response is intended. */
  public interface Channel {
    /** chat. */
    String CHAT = "chat";
    /** facebook. */
    String FACEBOOK = "facebook";
    /** intercom. */
    String INTERCOM = "intercom";
    /** slack. */
    String SLACK = "slack";
    /** text_messaging. */
    String TEXT_MESSAGING = "text_messaging";
    /** voice_telephony. */
    String VOICE_TELEPHONY = "voice_telephony";
    /** whatsapp. */
    String WHATSAPP = "whatsapp";
  }

  protected String channel;

  /** Builder. */
  public static class Builder {
    private String channel;

    private Builder(ResponseGenericChannel responseGenericChannel) {
      this.channel = responseGenericChannel.channel;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ResponseGenericChannel.
     *
     * @return the new ResponseGenericChannel instance
     */
    public ResponseGenericChannel build() {
      return new ResponseGenericChannel(this);
    }

    /**
     * Set the channel.
     *
     * @param channel the channel
     * @return the ResponseGenericChannel builder
     */
    public Builder channel(String channel) {
      this.channel = channel;
      return this;
    }
  }

  protected ResponseGenericChannel(Builder builder) {
    channel = builder.channel;
  }

  /**
   * New builder.
   *
   * @return a ResponseGenericChannel builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the channel.
   *
   * <p>A channel for which the response is intended.
   *
   * @return the channel
   */
  public String channel() {
    return channel;
  }
}

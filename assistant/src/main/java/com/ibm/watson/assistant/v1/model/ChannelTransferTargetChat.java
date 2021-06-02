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

/** Information for transferring to the web chat integration. */
public class ChannelTransferTargetChat extends GenericModel {

  protected String url;

  /** Builder. */
  public static class Builder {
    private String url;

    private Builder(ChannelTransferTargetChat channelTransferTargetChat) {
      this.url = channelTransferTargetChat.url;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ChannelTransferTargetChat.
     *
     * @return the new ChannelTransferTargetChat instance
     */
    public ChannelTransferTargetChat build() {
      return new ChannelTransferTargetChat(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the ChannelTransferTargetChat builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  protected ChannelTransferTargetChat(Builder builder) {
    url = builder.url;
  }

  /**
   * New builder.
   *
   * @return a ChannelTransferTargetChat builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * <p>The URL of the target web chat.
   *
   * @return the url
   */
  public String url() {
    return url;
  }
}

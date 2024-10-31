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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object specifying target channels available for the transfer. Each property of this object
 * represents an available transfer target. Currently, the only supported property is **chat**,
 * representing the web chat integration.
 */
public class ChannelTransferTarget extends GenericModel {

  protected ChannelTransferTargetChat chat;

  /** Builder. */
  public static class Builder {
    private ChannelTransferTargetChat chat;

    /**
     * Instantiates a new Builder from an existing ChannelTransferTarget instance.
     *
     * @param channelTransferTarget the instance to initialize the Builder with
     */
    private Builder(ChannelTransferTarget channelTransferTarget) {
      this.chat = channelTransferTarget.chat;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ChannelTransferTarget.
     *
     * @return the new ChannelTransferTarget instance
     */
    public ChannelTransferTarget build() {
      return new ChannelTransferTarget(this);
    }

    /**
     * Set the chat.
     *
     * @param chat the chat
     * @return the ChannelTransferTarget builder
     */
    public Builder chat(ChannelTransferTargetChat chat) {
      this.chat = chat;
      return this;
    }
  }

  protected ChannelTransferTarget() {}

  protected ChannelTransferTarget(Builder builder) {
    chat = builder.chat;
  }

  /**
   * New builder.
   *
   * @return a ChannelTransferTarget builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the chat.
   *
   * <p>Information for transferring to the web chat integration.
   *
   * @return the chat
   */
  public ChannelTransferTargetChat chat() {
    return chat;
  }
}

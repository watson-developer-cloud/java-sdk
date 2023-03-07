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

/** DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer
    extends DialogNodeOutputGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String messageToUser;
    private ChannelTransferInfo transferInfo;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing
     * DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer instance.
     *
     * @param dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer the instance to
     *     initialize the Builder with
     */
    public Builder(
        DialogNodeOutputGeneric
            dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer) {
      this.responseType =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.responseType;
      this.messageToUser =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.messageToUser;
      this.transferInfo =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.transferInfo;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param messageToUser the messageToUser
     * @param transferInfo the transferInfo
     */
    public Builder(String responseType, String messageToUser, ChannelTransferInfo transferInfo) {
      this.responseType = responseType;
      this.messageToUser = messageToUser;
      this.transferInfo = transferInfo;
    }

    /**
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer(this);
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer builder
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
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the messageToUser.
     *
     * @param messageToUser the messageToUser
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer builder
     */
    public Builder messageToUser(String messageToUser) {
      this.messageToUser = messageToUser;
      return this;
    }

    /**
     * Set the transferInfo.
     *
     * @param transferInfo the transferInfo
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer builder
     */
    public Builder transferInfo(ChannelTransferInfo transferInfo) {
      this.transferInfo = transferInfo;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer() {}

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.messageToUser, "messageToUser cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.transferInfo, "transferInfo cannot be null");
    responseType = builder.responseType;
    messageToUser = builder.messageToUser;
    transferInfo = builder.transferInfo;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

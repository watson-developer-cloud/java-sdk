/*
 * (C) Copyright IBM Corp. 2020, 2024.
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

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/** DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent
    extends DialogNodeOutputGeneric {

  @SerializedName("transfer_info")
  private DialogNodeOutputConnectToAgentTransferInfo transferInfo;

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String messageToHumanAgent;
    private AgentAvailabilityMessage agentAvailable;
    private AgentAvailabilityMessage agentUnavailable;
    private DialogNodeOutputConnectToAgentTransferInfo transferInfo;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing
     * DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent instance.
     *
     * @param dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent the instance to
     *     initialize the Builder with
     */
    public Builder(
        DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent
            dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent) {
      this.responseType =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.responseType;
      this.messageToHumanAgent =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.messageToHumanAgent;
      this.agentAvailable =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.agentAvailable;
      this.agentUnavailable =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.agentUnavailable;
      this.transferInfo =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.transferInfo;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     */
    public Builder(String responseType) {
      this.responseType = responseType;
    }

    /**
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent(this);
    }

    /**
     * Adds a new element to channels.
     *
     * @param channels the new element to be added
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent builder
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
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the messageToHumanAgent.
     *
     * @param messageToHumanAgent the messageToHumanAgent
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent builder
     */
    public Builder messageToHumanAgent(String messageToHumanAgent) {
      this.messageToHumanAgent = messageToHumanAgent;
      return this;
    }

    /**
     * Set the agentAvailable.
     *
     * @param agentAvailable the agentAvailable
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent builder
     */
    public Builder agentAvailable(AgentAvailabilityMessage agentAvailable) {
      this.agentAvailable = agentAvailable;
      return this;
    }

    /**
     * Set the agentUnavailable.
     *
     * @param agentUnavailable the agentUnavailable
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent builder
     */
    public Builder agentUnavailable(AgentAvailabilityMessage agentUnavailable) {
      this.agentUnavailable = agentUnavailable;
      return this;
    }

    /**
     * Set the transferInfo.
     *
     * @param transferInfo the transferInfo
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent builder
     */
    public Builder transferInfo(DialogNodeOutputConnectToAgentTransferInfo transferInfo) {
      this.transferInfo = transferInfo;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent() {}

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    responseType = builder.responseType;
    messageToHumanAgent = builder.messageToHumanAgent;
    agentAvailable = builder.agentAvailable;
    agentUnavailable = builder.agentUnavailable;
    transferInfo = builder.transferInfo;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the transferInfo.
   *
   * <p>Routing or other contextual information to be used by target service desk systems.
   *
   * @return the transferInfo
   */
  public DialogNodeOutputConnectToAgentTransferInfo transferInfo() {
    return transferInfo;
  }
}

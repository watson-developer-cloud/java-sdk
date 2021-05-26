/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

  @SerializedName("response_type")
  private String responseType;

  @SerializedName("message_to_human_agent")
  private String messageToHumanAgent;

  @SerializedName("agent_available")
  private AgentAvailabilityMessage agentAvailable;

  @SerializedName("agent_unavailable")
  private AgentAvailabilityMessage agentUnavailable;

  @SerializedName("transfer_info")
  private DialogNodeOutputConnectToAgentTransferInfo transferInfo;

  private List<ResponseGenericChannel> channels;

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String messageToHumanAgent;
    private AgentAvailabilityMessage agentAvailable;
    private AgentAvailabilityMessage agentUnavailable;
    private DialogNodeOutputConnectToAgentTransferInfo transferInfo;
    private List<ResponseGenericChannel> channels;

    public Builder(
            DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent) {
      this.responseType =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.responseType;
      this.messageToHumanAgent =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.messageToHumanAgent;
      this.agentAvailable =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.agentAvailable;
      this.agentUnavailable =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.agentUnavailable;
      this.transferInfo =
          (DialogNodeOutputConnectToAgentTransferInfo)
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
     * Adds an channels to channels.
     *
     * @param channels the new channels
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
   * Gets the responseType.
   *
   * <p>The type of response returned by the dialog node. The specified response type must be
   * supported by the client application or channel.
   *
   * @return the responseType
   */
  public String responseType() {
    return responseType;
  }

  /**
   * Gets the channels.
   *
   * <p>An array of objects specifying channels for which the response is intended.
   *
   * @return the channels
   */
  public List<ResponseGenericChannel> channels() {
    return channels;
  }

  /**
   * Gets the messageToHumanAgent.
   *
   * <p>An optional message to be sent to the human agent who will be taking over the conversation.
   *
   * @return the messageToHumanAgent
   */
  public String messageToHumanAgent() {
    return messageToHumanAgent;
  }

  /**
   * Gets the agentAvailable.
   *
   * <p>An optional message to be displayed to the user to indicate that the conversation will be
   * transferred to the next available agent.
   *
   * @return the agentAvailable
   */
  public AgentAvailabilityMessage agentAvailable() {
    return agentAvailable;
  }

  /**
   * Gets the agentUnavailable.
   *
   * <p>An optional message to be displayed to the user to indicate that no online agent is
   * available to take over the conversation.
   *
   * @return the agentUnavailable
   */
  public AgentAvailabilityMessage agentUnavailable() {
    return agentUnavailable;
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

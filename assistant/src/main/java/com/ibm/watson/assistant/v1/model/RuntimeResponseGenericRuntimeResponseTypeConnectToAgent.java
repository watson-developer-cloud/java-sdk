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

/** RuntimeResponseGenericRuntimeResponseTypeConnectToAgent. */
public class RuntimeResponseGenericRuntimeResponseTypeConnectToAgent
    extends RuntimeResponseGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String messageToHumanAgent;
    private AgentAvailabilityMessage agentAvailable;
    private AgentAvailabilityMessage agentUnavailable;
    private DialogNodeOutputConnectToAgentTransferInfo transferInfo;
    private String topic;
    private String dialogNode;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing
     * RuntimeResponseGenericRuntimeResponseTypeConnectToAgent instance.
     *
     * @param runtimeResponseGenericRuntimeResponseTypeConnectToAgent the instance to initialize the
     *     Builder with
     */
    public Builder(RuntimeResponseGeneric runtimeResponseGenericRuntimeResponseTypeConnectToAgent) {
      this.responseType = runtimeResponseGenericRuntimeResponseTypeConnectToAgent.responseType;
      this.messageToHumanAgent =
          runtimeResponseGenericRuntimeResponseTypeConnectToAgent.messageToHumanAgent;
      this.agentAvailable = runtimeResponseGenericRuntimeResponseTypeConnectToAgent.agentAvailable;
      this.agentUnavailable =
          runtimeResponseGenericRuntimeResponseTypeConnectToAgent.agentUnavailable;
      this.transferInfo = runtimeResponseGenericRuntimeResponseTypeConnectToAgent.transferInfo;
      this.topic = runtimeResponseGenericRuntimeResponseTypeConnectToAgent.topic;
      this.dialogNode = runtimeResponseGenericRuntimeResponseTypeConnectToAgent.dialogNode;
      this.channels = runtimeResponseGenericRuntimeResponseTypeConnectToAgent.channels;
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
     * Builds a RuntimeResponseGenericRuntimeResponseTypeConnectToAgent.
     *
     * @return the new RuntimeResponseGenericRuntimeResponseTypeConnectToAgent instance
     */
    public RuntimeResponseGenericRuntimeResponseTypeConnectToAgent build() {
      return new RuntimeResponseGenericRuntimeResponseTypeConnectToAgent(this);
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
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
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the messageToHumanAgent.
     *
     * @param messageToHumanAgent the messageToHumanAgent
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
     */
    public Builder messageToHumanAgent(String messageToHumanAgent) {
      this.messageToHumanAgent = messageToHumanAgent;
      return this;
    }

    /**
     * Set the agentAvailable.
     *
     * @param agentAvailable the agentAvailable
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
     */
    public Builder agentAvailable(AgentAvailabilityMessage agentAvailable) {
      this.agentAvailable = agentAvailable;
      return this;
    }

    /**
     * Set the agentUnavailable.
     *
     * @param agentUnavailable the agentUnavailable
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
     */
    public Builder agentUnavailable(AgentAvailabilityMessage agentUnavailable) {
      this.agentUnavailable = agentUnavailable;
      return this;
    }

    /**
     * Set the transferInfo.
     *
     * @param transferInfo the transferInfo
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
     */
    public Builder transferInfo(DialogNodeOutputConnectToAgentTransferInfo transferInfo) {
      this.transferInfo = transferInfo;
      return this;
    }

    /**
     * Set the topic.
     *
     * @param topic the topic
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
     */
    public Builder topic(String topic) {
      this.topic = topic;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected RuntimeResponseGenericRuntimeResponseTypeConnectToAgent() {}

  protected RuntimeResponseGenericRuntimeResponseTypeConnectToAgent(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    responseType = builder.responseType;
    messageToHumanAgent = builder.messageToHumanAgent;
    agentAvailable = builder.agentAvailable;
    agentUnavailable = builder.agentUnavailable;
    transferInfo = builder.transferInfo;
    topic = builder.topic;
    dialogNode = builder.dialogNode;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a RuntimeResponseGenericRuntimeResponseTypeConnectToAgent builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

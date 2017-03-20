/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.dialog.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Conversation data stores information about a conversation.
 */
public class ConversationData extends GenericModel {
  @SerializedName("client_id")
  private Integer clientId;
  @SerializedName("conversation_id")
  private Integer conversationId;
  @SerializedName("hit_nodes")
  private List<HitNode> hitNodes;
  private List<Message> messages;
  private List<NameValue> profile;

  /**
   * Gets the client id.
   *
   * @return The clientId
   */
  public int getClientId() {
    return clientId;
  }


  /**
   * Gets the conversation id.
   *
   * @return the conversation id
   */
  public Integer getConversationId() {
    return conversationId;
  }

  /**
   * Gets the hit nodes.
   *
   * @return The hitNodes
   */
  public List<HitNode> getHitNodes() {
    return hitNodes;
  }

  /**
   * Gets the messages.
   *
   * @return A list of {@link Message}
   */
  public List<Message> getMessages() {
    return messages;
  }

  /**
   * Gets the profile.
   *
   * @return A list of {@link NameValue } pars
   */
  public List<NameValue> getProfile() {
    return profile;
  }

  /**
   * Sets the client id.
   *
   * @param clientId The client_id
   */
  public void setClientId(final int clientId) {
    this.clientId = clientId;
  }

  /**
   * Sets the client id.
   *
   * @param clientId the new client id
   */
  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  /**
   * Sets the conversation id.
   *
   * @param conversationId the new conversation id
   */
  public void setConversationId(Integer conversationId) {
    this.conversationId = conversationId;
  }

  /**
   * Sets the hit nodes.
   *
   * @param hitNodes The hit_nodes
   */
  public void setHitNodes(final List<HitNode> hitNodes) {
    this.hitNodes = hitNodes;
  }

  /**
   * Sets the messages.
   *
   * @param messages The messages
   */
  public void setMessages(final List<Message> messages) {
    this.messages = messages;
  }

  /**
   * Sets the profile.
   *
   * @param profile The profile
   */
  public void setProfile(final List<NameValue> profile) {
    this.profile = profile;
  }
}

/*
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * An output object that includes the response to the user, the nodes that were hit, and messages from the log.
 */
public class OutputData extends DynamicModel {
  private Type logMessagesType = new TypeToken<List<LogMessage>>() {
  }.getType();
  private Type textType = new TypeToken<List<String>>() {
  }.getType();
  private Type nodesVisitedType = new TypeToken<List<String>>() {
  }.getType();

  /**
   * Gets the logMessages.
   *
   * @return the logMessages
   */
  public List<LogMessage> getLogMessages() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("log_messages"), logMessagesType);
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public List<String> getText() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("text"), textType);
  }

  /**
   * Gets the nodesVisited.
   *
   * @return the nodesVisited
   */
  public List<String> getNodesVisited() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("nodes_visited"), nodesVisitedType);
  }

  /**
   * Sets the logMessages.
   *
   * @param logMessages the new logMessages
   */
  public void setLogMessages(final List<LogMessage> logMessages) {
    this.put("log_messages", logMessages);
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final List<String> text) {
    this.put("text", text);
  }

  /**
   * Sets the nodesVisited.
   *
   * @param nodesVisited the new nodesVisited
   */
  public void setNodesVisited(final List<String> nodesVisited) {
    this.put("nodes_visited", nodesVisited);
  }
}

/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.assistant.v1.model;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import com.ibm.cloud.sdk.core.util.GsonSerializationHelper;

/**
 * An output object that includes the response to the user, the dialog nodes that were triggered, and messages from the
 * log.
 */
public class OutputData extends DynamicModel {
  private Type logMessagesType = new TypeToken<List<LogMessage>>() {
  }.getType();
  private Type textType = new TypeToken<List<String>>() {
  }.getType();
  private Type genericType = new TypeToken<List<DialogRuntimeResponseGeneric>>() {
  }.getType();
  private Type nodesVisitedType = new TypeToken<List<String>>() {
  }.getType();
  private Type nodesVisitedDetailsType = new TypeToken<List<DialogNodeVisitedDetails>>() {
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
   * Gets the generic.
   *
   * @return the generic
   */
  public List<DialogRuntimeResponseGeneric> getGeneric() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("generic"), genericType);
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
   * Gets the nodesVisitedDetails.
   *
   * @return the nodesVisitedDetails
   */
  public List<DialogNodeVisitedDetails> getNodesVisitedDetails() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("nodes_visited_details"),
        nodesVisitedDetailsType);
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
   * Sets the generic.
   *
   * @param generic the new generic
   */
  public void setGeneric(final List<DialogRuntimeResponseGeneric> generic) {
    this.put("generic", generic);
  }

  /**
   * Sets the nodesVisited.
   *
   * @param nodesVisited the new nodesVisited
   */
  public void setNodesVisited(final List<String> nodesVisited) {
    this.put("nodes_visited", nodesVisited);
  }

  /**
   * Sets the nodesVisitedDetails.
   *
   * @param nodesVisitedDetails the new nodesVisitedDetails
   */
  public void setNodesVisitedDetails(final List<DialogNodeVisitedDetails> nodesVisitedDetails) {
    this.put("nodes_visited_details", nodesVisitedDetails);
  }
}

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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * RuntimeOutput.
 */
public class RuntimeOutput extends GenericModel {

  private List<String> text;
  @SerializedName("log_messages")
  private List<RuntimeLogMessage> logMessages;
  @SerializedName("nodes_visited")
  private List<String> nodesVisited;

  /**
   * Gets the text.
   *
   * An array of responses to the user.
   *
   * @return the text
   */
  public List<String> getText() {
    return text;
  }

  /**
   * Gets the logMessages.
   *
   * Up to 50 messages logged with the request.
   *
   * @return the logMessages
   */
  public List<RuntimeLogMessage> getLogMessages() {
    return logMessages;
  }

  /**
   * Gets the nodesVisited.
   *
   * An array of the nodes that were triggered to create the response.
   *
   * @return the nodesVisited
   */
  public List<String> getNodesVisited() {
    return nodesVisited;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final List<String> text) {
    this.text = text;
  }

  /**
   * Sets the logMessages.
   *
   * @param logMessages the new logMessages
   */
  public void setLogMessages(final List<RuntimeLogMessage> logMessages) {
    this.logMessages = logMessages;
  }

  /**
   * Sets the nodesVisited.
   *
   * @param nodesVisited the new nodesVisited
   */
  public void setNodesVisited(final List<String> nodesVisited) {
    this.nodesVisited = nodesVisited;
  }
}

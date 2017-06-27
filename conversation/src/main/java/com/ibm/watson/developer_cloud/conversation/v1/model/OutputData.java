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

import java.util.HashMap;
import java.util.List;

/**
 * An output object that includes the response to the user, the nodes that were hit, and messages from the log.
 */
public class OutputData extends HashMap<String, Object> {

  /**
   * Gets the logMessages.
   *
   * @return the logMessages
   */
  public List<LogMessage> getLogMessages() {
    return (List<LogMessage>) this.get("logMessages");
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public List<String> getText() {
    return (List<String>) this.get("text");
  }

  /**
   * Gets the nodesVisited.
   *
   * @return the nodesVisited
   */
  public List<String> getNodesVisited() {
    return (List<String>) this.get("nodesVisited");
  }

  /**
   * Sets the logMessages.
   *
   * @param logMessages the new logMessages
   */
  public void setLogMessages(final List<LogMessage> logMessages) {
    this.put("logMessages", logMessages);
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
    this.put("nodesVisited", nodesVisited);
  }
}

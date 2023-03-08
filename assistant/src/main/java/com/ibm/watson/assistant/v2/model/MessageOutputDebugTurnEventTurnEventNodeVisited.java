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
package com.ibm.watson.assistant.v2.model;

/** MessageOutputDebugTurnEventTurnEventNodeVisited. */
public class MessageOutputDebugTurnEventTurnEventNodeVisited extends MessageOutputDebugTurnEvent {

  /** The reason the dialog node was visited. */
  public interface Reason {
    /** welcome. */
    String WELCOME = "welcome";
    /** branch_start. */
    String BRANCH_START = "branch_start";
    /** topic_switch. */
    String TOPIC_SWITCH = "topic_switch";
    /** topic_return. */
    String TOPIC_RETURN = "topic_return";
    /** topic_switch_without_return. */
    String TOPIC_SWITCH_WITHOUT_RETURN = "topic_switch_without_return";
    /** jump. */
    String JUMP = "jump";
  }

  protected TurnEventNodeSource source;

  protected MessageOutputDebugTurnEventTurnEventNodeVisited() {}

  /**
   * Gets the source.
   *
   * @return the source
   */
  public TurnEventNodeSource getSource() {
    return source;
  }
}

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

/** MessageOutputDebugTurnEventTurnEventActionVisited. */
public class MessageOutputDebugTurnEventTurnEventActionVisited extends MessageOutputDebugTurnEvent {

  /** The type of condition (if any) that is defined for the action. */
  public interface ConditionType {
    /** user_defined. */
    String USER_DEFINED = "user_defined";
    /** welcome. */
    String WELCOME = "welcome";
    /** anything_else. */
    String ANYTHING_ELSE = "anything_else";
  }

  /** The reason the action was visited. */
  public interface Reason {
    /** intent. */
    String INTENT = "intent";
    /** invoke_subaction. */
    String INVOKE_SUBACTION = "invoke_subaction";
    /** subaction_return. */
    String SUBACTION_RETURN = "subaction_return";
    /** invoke_external. */
    String INVOKE_EXTERNAL = "invoke_external";
    /** topic_switch. */
    String TOPIC_SWITCH = "topic_switch";
    /** topic_return. */
    String TOPIC_RETURN = "topic_return";
    /** agent_requested. */
    String AGENT_REQUESTED = "agent_requested";
    /** step_validation_failed. */
    String STEP_VALIDATION_FAILED = "step_validation_failed";
    /** no_action_matches. */
    String NO_ACTION_MATCHES = "no_action_matches";
  }

  protected MessageOutputDebugTurnEventTurnEventActionVisited() {}
}

/*
 * (C) Copyright IBM Corp. 2022.
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

/** MessageOutputDebugTurnEventTurnEventActionFinished. */
public class MessageOutputDebugTurnEventTurnEventActionFinished
    extends MessageOutputDebugTurnEvent {

  /** The type of condition (if any) that is defined for the action. */
  public interface ConditionType {
    /** user_defined. */
    String USER_DEFINED = "user_defined";
    /** welcome. */
    String WELCOME = "welcome";
    /** anything_else. */
    String ANYTHING_ELSE = "anything_else";
  }

  /** The reason the action finished processing. */
  public interface Reason {
    /** all_steps_done. */
    String ALL_STEPS_DONE = "all_steps_done";
    /** no_steps_visited. */
    String NO_STEPS_VISITED = "no_steps_visited";
    /** ended_by_step. */
    String ENDED_BY_STEP = "ended_by_step";
    /** connect_to_agent. */
    String CONNECT_TO_AGENT = "connect_to_agent";
    /** max_retries_reached. */
    String MAX_RETRIES_REACHED = "max_retries_reached";
    /** fallback. */
    String FALLBACK = "fallback";
  }
}

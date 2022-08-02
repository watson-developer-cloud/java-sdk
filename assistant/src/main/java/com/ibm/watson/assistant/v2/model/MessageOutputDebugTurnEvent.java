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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Map;

/**
 * MessageOutputDebugTurnEvent.
 *
 * <p>Classes which extend this class: - MessageOutputDebugTurnEventTurnEventActionVisited -
 * MessageOutputDebugTurnEventTurnEventActionFinished -
 * MessageOutputDebugTurnEventTurnEventStepVisited -
 * MessageOutputDebugTurnEventTurnEventStepAnswered -
 * MessageOutputDebugTurnEventTurnEventHandlerVisited - MessageOutputDebugTurnEventTurnEventCallout
 * - MessageOutputDebugTurnEventTurnEventSearch - MessageOutputDebugTurnEventTurnEventNodeVisited
 */
public class MessageOutputDebugTurnEvent extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "event";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put(
        "action_visited", MessageOutputDebugTurnEventTurnEventActionVisited.class);
    discriminatorMapping.put(
        "action_finished", MessageOutputDebugTurnEventTurnEventActionFinished.class);
    discriminatorMapping.put("step_visited", MessageOutputDebugTurnEventTurnEventStepVisited.class);
    discriminatorMapping.put(
        "step_answered", MessageOutputDebugTurnEventTurnEventStepAnswered.class);
    discriminatorMapping.put(
        "handler_visited", MessageOutputDebugTurnEventTurnEventHandlerVisited.class);
    discriminatorMapping.put("callout", MessageOutputDebugTurnEventTurnEventCallout.class);
    discriminatorMapping.put("search", MessageOutputDebugTurnEventTurnEventSearch.class);
    discriminatorMapping.put("node_visited", MessageOutputDebugTurnEventTurnEventNodeVisited.class);
  }

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

  protected String event;
  protected TurnEventActionSource source;

  @SerializedName("action_start_time")
  protected String actionStartTime;

  @SerializedName("condition_type")
  protected String conditionType;

  protected String reason;

  @SerializedName("action_variables")
  protected Map<String, Object> actionVariables;

  @SerializedName("has_question")
  protected Boolean hasQuestion;

  protected Boolean prompted;
  protected TurnEventCalloutCallout callout;
  protected TurnEventCalloutError error;

  protected MessageOutputDebugTurnEvent() {}

  /**
   * Gets the event.
   *
   * <p>The type of turn event.
   *
   * @return the event
   */
  public String getEvent() {
    return event;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public TurnEventActionSource getSource() {
    return source;
  }

  /**
   * Gets the actionStartTime.
   *
   * <p>The time when the action started processing the message.
   *
   * @return the actionStartTime
   */
  public String getActionStartTime() {
    return actionStartTime;
  }

  /**
   * Gets the conditionType.
   *
   * <p>The type of condition (if any) that is defined for the action.
   *
   * @return the conditionType
   */
  public String getConditionType() {
    return conditionType;
  }

  /**
   * Gets the reason.
   *
   * <p>The reason the action was visited.
   *
   * @return the reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * Gets the actionVariables.
   *
   * <p>The state of all action variables at the time the action finished.
   *
   * @return the actionVariables
   */
  public Map<String, Object> getActionVariables() {
    return actionVariables;
  }

  /**
   * Gets the hasQuestion.
   *
   * <p>Whether the step collects a customer response.
   *
   * @return the hasQuestion
   */
  public Boolean isHasQuestion() {
    return hasQuestion;
  }

  /**
   * Gets the prompted.
   *
   * <p>Whether the step was answered in response to a prompt from the assistant. If this property
   * is `false`, the user provided the answer without visiting the step.
   *
   * @return the prompted
   */
  public Boolean isPrompted() {
    return prompted;
  }

  /**
   * Gets the callout.
   *
   * @return the callout
   */
  public TurnEventCalloutCallout getCallout() {
    return callout;
  }

  /**
   * Gets the error.
   *
   * @return the error
   */
  public TurnEventCalloutError getError() {
    return error;
  }
}

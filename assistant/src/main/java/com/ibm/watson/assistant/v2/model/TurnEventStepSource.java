/*
 * (C) Copyright IBM Corp. 2025.
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

/** TurnEventStepSource. */
public class TurnEventStepSource extends GenericModel {

  /** The type of turn event. */
  public interface Type {
    /** step. */
    String STEP = "step";
  }

  protected String type;
  protected String action;

  @SerializedName("action_title")
  protected String actionTitle;

  protected String step;

  @SerializedName("is_ai_guided")
  protected Boolean isAiGuided;

  @SerializedName("is_skill_based")
  protected Boolean isSkillBased;

  protected TurnEventStepSource() {}

  /**
   * Gets the type.
   *
   * <p>The type of turn event.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the action.
   *
   * <p>An action that was visited during processing of the message.
   *
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * Gets the actionTitle.
   *
   * <p>The title of the action.
   *
   * @return the actionTitle
   */
  public String getActionTitle() {
    return actionTitle;
  }

  /**
   * Gets the step.
   *
   * <p>A step that was visited during processing of the message.
   *
   * @return the step
   */
  public String getStep() {
    return step;
  }

  /**
   * Gets the isAiGuided.
   *
   * @return the isAiGuided
   */
  public Boolean isIsAiGuided() {
    return isAiGuided;
  }

  /**
   * Gets the isSkillBased.
   *
   * @return the isSkillBased
   */
  public Boolean isIsSkillBased() {
    return isSkillBased;
  }
}

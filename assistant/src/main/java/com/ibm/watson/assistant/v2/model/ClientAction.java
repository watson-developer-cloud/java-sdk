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

/** ClientAction. */
public class ClientAction extends GenericModel {

  /** The skill that is requesting the action. Included only if **type**=`client`. */
  public interface Skill {
    /** main skill. */
    String MAIN_SKILL = "main skill";
    /** actions skill. */
    String ACTIONS_SKILL = "actions skill";
  }

  protected String name;

  @SerializedName("result_variable")
  protected String resultVariable;

  protected String type;
  protected String skill;
  protected ClientActionParameters parameters;

  protected ClientAction() {}

  /**
   * Gets the name.
   *
   * <p>The name of the client action.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the resultVariable.
   *
   * @return the resultVariable
   */
  public String getResultVariable() {
    return resultVariable;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the skill.
   *
   * <p>The skill that is requesting the action. Included only if **type**=`client`.
   *
   * @return the skill
   */
  public String getSkill() {
    return skill;
  }

  /**
   * Gets the parameters.
   *
   * @return the parameters
   */
  public ClientActionParameters getParameters() {
    return parameters;
  }
}

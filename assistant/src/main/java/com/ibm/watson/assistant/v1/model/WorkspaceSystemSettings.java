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
package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.Map;

/**
 * Global settings for the workspace.
 */
public class WorkspaceSystemSettings extends GenericModel {

  private WorkspaceSystemSettingsTooling tooling;
  private WorkspaceSystemSettingsDisambiguation disambiguation;
  @SerializedName("human_agent_assist")
  private Map humanAgentAssist;
  @SerializedName("spelling_suggestions")
  private Boolean spellingSuggestions;
  @SerializedName("spelling_auto_correct")
  private Boolean spellingAutoCorrect;
  @SerializedName("system_entities")
  private WorkspaceSystemSettingsSystemEntities systemEntities;

  /**
   * Gets the tooling.
   *
   * Workspace settings related to the Watson Assistant user interface.
   *
   * @return the tooling
   */
  public WorkspaceSystemSettingsTooling getTooling() {
    return tooling;
  }

  /**
   * Gets the disambiguation.
   *
   * Workspace settings related to the disambiguation feature.
   *
   * **Note:** This feature is available only to Premium users.
   *
   * @return the disambiguation
   */
  public WorkspaceSystemSettingsDisambiguation getDisambiguation() {
    return disambiguation;
  }

  /**
   * Gets the humanAgentAssist.
   *
   * For internal use only.
   *
   * @return the humanAgentAssist
   */
  public Map getHumanAgentAssist() {
    return humanAgentAssist;
  }

  /**
   * Gets the spellingSuggestions.
   *
   * Whether spelling correction is enabled for the workspace.
   *
   * Spelling correction is a beta feature.
   *
   * @return the spellingSuggestions
   */
  public Boolean isSpellingSuggestions() {
    return spellingSuggestions;
  }

  /**
   * Gets the spellingAutoCorrect.
   *
   * Whether autocorrection is enabled for the workspace. If spelling correction is enabled and this property is
   * `false`, any suggested corrections are returned in the **suggested_text** property of the message response. If this
   * property is `true`, any corrections are automatically applied to the user input, and the original text is returned
   * in the **original_text** property of the message response.
   *
   * Spelling correction is a beta feature.
   *
   * @return the spellingAutoCorrect
   */
  public Boolean isSpellingAutoCorrect() {
    return spellingAutoCorrect;
  }

  /**
   * Gets the systemEntities.
   *
   * Workspace settings related to the behavior of system entities.
   *
   * @return the systemEntities
   */
  public WorkspaceSystemSettingsSystemEntities getSystemEntities() {
    return systemEntities;
  }

  /**
   * Sets the tooling.
   *
   * @param tooling the new tooling
   */
  public void setTooling(final WorkspaceSystemSettingsTooling tooling) {
    this.tooling = tooling;
  }

  /**
   * Sets the disambiguation.
   *
   * @param disambiguation the new disambiguation
   */
  public void setDisambiguation(final WorkspaceSystemSettingsDisambiguation disambiguation) {
    this.disambiguation = disambiguation;
  }

  /**
   * Sets the humanAgentAssist.
   *
   * @param humanAgentAssist the new humanAgentAssist
   */
  public void setHumanAgentAssist(final Map humanAgentAssist) {
    this.humanAgentAssist = humanAgentAssist;
  }

  /**
   * Sets the spellingSuggestions.
   *
   * @param spellingSuggestions the new spellingSuggestions
   */
  public void setSpellingSuggestions(final Boolean spellingSuggestions) {
    this.spellingSuggestions = spellingSuggestions;
  }

  /**
   * Sets the spellingAutoCorrect.
   *
   * @param spellingAutoCorrect the new spellingAutoCorrect
   */
  public void setSpellingAutoCorrect(final Boolean spellingAutoCorrect) {
    this.spellingAutoCorrect = spellingAutoCorrect;
  }

  /**
   * Sets the systemEntities.
   *
   * @param systemEntities the new systemEntities
   */
  public void setSystemEntities(final WorkspaceSystemSettingsSystemEntities systemEntities) {
    this.systemEntities = systemEntities;
  }
}

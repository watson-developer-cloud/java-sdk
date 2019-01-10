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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Global settings for the workspace.
 */
public class WorkspaceSystemSettings extends GenericModel {

  private WorkspaceSystemSettingsTooling tooling;
  private WorkspaceSystemSettingsDisambiguation disambiguation;
  @SerializedName("human_agent_assist")
  private Map humanAgentAssist;

  /**
   * Gets the tooling.
   *
   * Workspace settings related to the Watson Assistant tool.
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
}

/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/** Global settings for the workspace. */
public class WorkspaceSystemSettings extends GenericModel {

  protected WorkspaceSystemSettingsTooling tooling;
  protected WorkspaceSystemSettingsDisambiguation disambiguation;

  @SerializedName("human_agent_assist")
  protected Map<String, Object> humanAgentAssist;

  @SerializedName("spelling_suggestions")
  protected Boolean spellingSuggestions;

  @SerializedName("spelling_auto_correct")
  protected Boolean spellingAutoCorrect;

  @SerializedName("system_entities")
  protected WorkspaceSystemSettingsSystemEntities systemEntities;

  @SerializedName("off_topic")
  protected WorkspaceSystemSettingsOffTopic offTopic;

  /** Builder. */
  public static class Builder {
    private WorkspaceSystemSettingsTooling tooling;
    private WorkspaceSystemSettingsDisambiguation disambiguation;
    private Map<String, Object> humanAgentAssist;
    private Boolean spellingSuggestions;
    private Boolean spellingAutoCorrect;
    private WorkspaceSystemSettingsSystemEntities systemEntities;
    private WorkspaceSystemSettingsOffTopic offTopic;

    private Builder(WorkspaceSystemSettings workspaceSystemSettings) {
      this.tooling = workspaceSystemSettings.tooling;
      this.disambiguation = workspaceSystemSettings.disambiguation;
      this.humanAgentAssist = workspaceSystemSettings.humanAgentAssist;
      this.spellingSuggestions = workspaceSystemSettings.spellingSuggestions;
      this.spellingAutoCorrect = workspaceSystemSettings.spellingAutoCorrect;
      this.systemEntities = workspaceSystemSettings.systemEntities;
      this.offTopic = workspaceSystemSettings.offTopic;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a WorkspaceSystemSettings.
     *
     * @return the workspaceSystemSettings
     */
    public WorkspaceSystemSettings build() {
      return new WorkspaceSystemSettings(this);
    }

    /**
     * Set the tooling.
     *
     * @param tooling the tooling
     * @return the WorkspaceSystemSettings builder
     */
    public Builder tooling(WorkspaceSystemSettingsTooling tooling) {
      this.tooling = tooling;
      return this;
    }

    /**
     * Set the disambiguation.
     *
     * @param disambiguation the disambiguation
     * @return the WorkspaceSystemSettings builder
     */
    public Builder disambiguation(WorkspaceSystemSettingsDisambiguation disambiguation) {
      this.disambiguation = disambiguation;
      return this;
    }

    /**
     * Set the humanAgentAssist.
     *
     * @param humanAgentAssist the humanAgentAssist
     * @return the WorkspaceSystemSettings builder
     */
    public Builder humanAgentAssist(Map<String, Object> humanAgentAssist) {
      this.humanAgentAssist = humanAgentAssist;
      return this;
    }

    /**
     * Set the spellingSuggestions.
     *
     * @param spellingSuggestions the spellingSuggestions
     * @return the WorkspaceSystemSettings builder
     */
    public Builder spellingSuggestions(Boolean spellingSuggestions) {
      this.spellingSuggestions = spellingSuggestions;
      return this;
    }

    /**
     * Set the spellingAutoCorrect.
     *
     * @param spellingAutoCorrect the spellingAutoCorrect
     * @return the WorkspaceSystemSettings builder
     */
    public Builder spellingAutoCorrect(Boolean spellingAutoCorrect) {
      this.spellingAutoCorrect = spellingAutoCorrect;
      return this;
    }

    /**
     * Set the systemEntities.
     *
     * @param systemEntities the systemEntities
     * @return the WorkspaceSystemSettings builder
     */
    public Builder systemEntities(WorkspaceSystemSettingsSystemEntities systemEntities) {
      this.systemEntities = systemEntities;
      return this;
    }

    /**
     * Set the offTopic.
     *
     * @param offTopic the offTopic
     * @return the WorkspaceSystemSettings builder
     */
    public Builder offTopic(WorkspaceSystemSettingsOffTopic offTopic) {
      this.offTopic = offTopic;
      return this;
    }
  }

  protected WorkspaceSystemSettings(Builder builder) {
    tooling = builder.tooling;
    disambiguation = builder.disambiguation;
    humanAgentAssist = builder.humanAgentAssist;
    spellingSuggestions = builder.spellingSuggestions;
    spellingAutoCorrect = builder.spellingAutoCorrect;
    systemEntities = builder.systemEntities;
    offTopic = builder.offTopic;
  }

  /**
   * New builder.
   *
   * @return a WorkspaceSystemSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tooling.
   *
   * <p>Workspace settings related to the Watson Assistant user interface.
   *
   * @return the tooling
   */
  public WorkspaceSystemSettingsTooling tooling() {
    return tooling;
  }

  /**
   * Gets the disambiguation.
   *
   * <p>Workspace settings related to the disambiguation feature.
   *
   * <p>**Note:** This feature is available only to Plus and Premium users.
   *
   * @return the disambiguation
   */
  public WorkspaceSystemSettingsDisambiguation disambiguation() {
    return disambiguation;
  }

  /**
   * Gets the humanAgentAssist.
   *
   * <p>For internal use only.
   *
   * @return the humanAgentAssist
   */
  public Map<String, Object> humanAgentAssist() {
    return humanAgentAssist;
  }

  /**
   * Gets the spellingSuggestions.
   *
   * <p>Whether spelling correction is enabled for the workspace.
   *
   * @return the spellingSuggestions
   */
  public Boolean spellingSuggestions() {
    return spellingSuggestions;
  }

  /**
   * Gets the spellingAutoCorrect.
   *
   * <p>Whether autocorrection is enabled for the workspace. If spelling correction is enabled and
   * this property is `false`, any suggested corrections are returned in the **suggested_text**
   * property of the message response. If this property is `true`, any corrections are automatically
   * applied to the user input, and the original text is returned in the **original_text** property
   * of the message response.
   *
   * @return the spellingAutoCorrect
   */
  public Boolean spellingAutoCorrect() {
    return spellingAutoCorrect;
  }

  /**
   * Gets the systemEntities.
   *
   * <p>Workspace settings related to the behavior of system entities.
   *
   * @return the systemEntities
   */
  public WorkspaceSystemSettingsSystemEntities systemEntities() {
    return systemEntities;
  }

  /**
   * Gets the offTopic.
   *
   * <p>Workspace settings related to detection of irrelevant input.
   *
   * @return the offTopic
   */
  public WorkspaceSystemSettingsOffTopic offTopic() {
    return offTopic;
  }
}

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

/**
 * Workspace settings related to the disambiguation feature.
 *
 * **Note:** This feature is available only to Premium users.
 */
public class WorkspaceSystemSettingsDisambiguation extends GenericModel {

  /**
   * The sensitivity of the disambiguation feature to intent detection conflicts. Set to **high** if you want the
   * disambiguation feature to be triggered more often. This can be useful for testing or demonstration purposes.
   */
  public interface Sensitivity {
    /** auto. */
    String AUTO = "auto";
    /** high. */
    String HIGH = "high";
  }

  private String prompt;
  @SerializedName("none_of_the_above_prompt")
  private String noneOfTheAbovePrompt;
  private Boolean enabled;
  private String sensitivity;

  /**
   * Gets the prompt.
   *
   * The text of the introductory prompt that accompanies disambiguation options presented to the user.
   *
   * @return the prompt
   */
  public String getPrompt() {
    return prompt;
  }

  /**
   * Gets the noneOfTheAbovePrompt.
   *
   * The user-facing label for the option users can select if none of the suggested options is correct. If no value is
   * specified for this property, this option does not appear.
   *
   * @return the noneOfTheAbovePrompt
   */
  public String getNoneOfTheAbovePrompt() {
    return noneOfTheAbovePrompt;
  }

  /**
   * Gets the enabled.
   *
   * Whether the disambiguation feature is enabled for the workspace.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the sensitivity.
   *
   * The sensitivity of the disambiguation feature to intent detection conflicts. Set to **high** if you want the
   * disambiguation feature to be triggered more often. This can be useful for testing or demonstration purposes.
   *
   * @return the sensitivity
   */
  public String getSensitivity() {
    return sensitivity;
  }

  /**
   * Sets the prompt.
   *
   * @param prompt the new prompt
   */
  public void setPrompt(final String prompt) {
    this.prompt = prompt;
  }

  /**
   * Sets the noneOfTheAbovePrompt.
   *
   * @param noneOfTheAbovePrompt the new noneOfTheAbovePrompt
   */
  public void setNoneOfTheAbovePrompt(final String noneOfTheAbovePrompt) {
    this.noneOfTheAbovePrompt = noneOfTheAbovePrompt;
  }

  /**
   * Sets the enabled.
   *
   * @param enabled the new enabled
   */
  public void setEnabled(final Boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Sets the sensitivity.
   *
   * @param sensitivity the new sensitivity
   */
  public void setSensitivity(final String sensitivity) {
    this.sensitivity = sensitivity;
  }
}

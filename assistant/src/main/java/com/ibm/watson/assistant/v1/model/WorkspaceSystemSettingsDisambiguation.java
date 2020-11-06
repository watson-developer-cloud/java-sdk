/*
 * (C) Copyright IBM Corp. 2020.
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

/** Workspace settings related to the disambiguation feature. */
public class WorkspaceSystemSettingsDisambiguation extends GenericModel {

  /**
   * The sensitivity of the disambiguation feature to intent detection conflicts. Set to **high** if
   * you want the disambiguation feature to be triggered more often. This can be useful for testing
   * or demonstration purposes.
   */
  public interface Sensitivity {
    /** auto. */
    String AUTO = "auto";
    /** high. */
    String HIGH = "high";
  }

  protected String prompt;

  @SerializedName("none_of_the_above_prompt")
  protected String noneOfTheAbovePrompt;

  protected Boolean enabled;
  protected String sensitivity;
  protected Boolean randomize;

  @SerializedName("max_suggestions")
  protected Long maxSuggestions;

  @SerializedName("suggestion_text_policy")
  protected String suggestionTextPolicy;

  /** Builder. */
  public static class Builder {
    private String prompt;
    private String noneOfTheAbovePrompt;
    private Boolean enabled;
    private String sensitivity;
    private Boolean randomize;
    private Long maxSuggestions;
    private String suggestionTextPolicy;

    private Builder(WorkspaceSystemSettingsDisambiguation workspaceSystemSettingsDisambiguation) {
      this.prompt = workspaceSystemSettingsDisambiguation.prompt;
      this.noneOfTheAbovePrompt = workspaceSystemSettingsDisambiguation.noneOfTheAbovePrompt;
      this.enabled = workspaceSystemSettingsDisambiguation.enabled;
      this.sensitivity = workspaceSystemSettingsDisambiguation.sensitivity;
      this.randomize = workspaceSystemSettingsDisambiguation.randomize;
      this.maxSuggestions = workspaceSystemSettingsDisambiguation.maxSuggestions;
      this.suggestionTextPolicy = workspaceSystemSettingsDisambiguation.suggestionTextPolicy;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a WorkspaceSystemSettingsDisambiguation.
     *
     * @return the new WorkspaceSystemSettingsDisambiguation instance
     */
    public WorkspaceSystemSettingsDisambiguation build() {
      return new WorkspaceSystemSettingsDisambiguation(this);
    }

    /**
     * Set the prompt.
     *
     * @param prompt the prompt
     * @return the WorkspaceSystemSettingsDisambiguation builder
     */
    public Builder prompt(String prompt) {
      this.prompt = prompt;
      return this;
    }

    /**
     * Set the noneOfTheAbovePrompt.
     *
     * @param noneOfTheAbovePrompt the noneOfTheAbovePrompt
     * @return the WorkspaceSystemSettingsDisambiguation builder
     */
    public Builder noneOfTheAbovePrompt(String noneOfTheAbovePrompt) {
      this.noneOfTheAbovePrompt = noneOfTheAbovePrompt;
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the WorkspaceSystemSettingsDisambiguation builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the sensitivity.
     *
     * @param sensitivity the sensitivity
     * @return the WorkspaceSystemSettingsDisambiguation builder
     */
    public Builder sensitivity(String sensitivity) {
      this.sensitivity = sensitivity;
      return this;
    }

    /**
     * Set the randomize.
     *
     * @param randomize the randomize
     * @return the WorkspaceSystemSettingsDisambiguation builder
     */
    public Builder randomize(Boolean randomize) {
      this.randomize = randomize;
      return this;
    }

    /**
     * Set the maxSuggestions.
     *
     * @param maxSuggestions the maxSuggestions
     * @return the WorkspaceSystemSettingsDisambiguation builder
     */
    public Builder maxSuggestions(long maxSuggestions) {
      this.maxSuggestions = maxSuggestions;
      return this;
    }

    /**
     * Set the suggestionTextPolicy.
     *
     * @param suggestionTextPolicy the suggestionTextPolicy
     * @return the WorkspaceSystemSettingsDisambiguation builder
     */
    public Builder suggestionTextPolicy(String suggestionTextPolicy) {
      this.suggestionTextPolicy = suggestionTextPolicy;
      return this;
    }
  }

  protected WorkspaceSystemSettingsDisambiguation(Builder builder) {
    prompt = builder.prompt;
    noneOfTheAbovePrompt = builder.noneOfTheAbovePrompt;
    enabled = builder.enabled;
    sensitivity = builder.sensitivity;
    randomize = builder.randomize;
    maxSuggestions = builder.maxSuggestions;
    suggestionTextPolicy = builder.suggestionTextPolicy;
  }

  /**
   * New builder.
   *
   * @return a WorkspaceSystemSettingsDisambiguation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the prompt.
   *
   * <p>The text of the introductory prompt that accompanies disambiguation options presented to the
   * user.
   *
   * @return the prompt
   */
  public String prompt() {
    return prompt;
  }

  /**
   * Gets the noneOfTheAbovePrompt.
   *
   * <p>The user-facing label for the option users can select if none of the suggested options is
   * correct. If no value is specified for this property, this option does not appear.
   *
   * @return the noneOfTheAbovePrompt
   */
  public String noneOfTheAbovePrompt() {
    return noneOfTheAbovePrompt;
  }

  /**
   * Gets the enabled.
   *
   * <p>Whether the disambiguation feature is enabled for the workspace.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the sensitivity.
   *
   * <p>The sensitivity of the disambiguation feature to intent detection conflicts. Set to **high**
   * if you want the disambiguation feature to be triggered more often. This can be useful for
   * testing or demonstration purposes.
   *
   * @return the sensitivity
   */
  public String sensitivity() {
    return sensitivity;
  }

  /**
   * Gets the randomize.
   *
   * <p>Whether the order in which disambiguation suggestions are presented should be randomized
   * (but still influenced by relative confidence).
   *
   * @return the randomize
   */
  public Boolean randomize() {
    return randomize;
  }

  /**
   * Gets the maxSuggestions.
   *
   * <p>The maximum number of disambigation suggestions that can be included in a `suggestion`
   * response.
   *
   * @return the maxSuggestions
   */
  public Long maxSuggestions() {
    return maxSuggestions;
  }

  /**
   * Gets the suggestionTextPolicy.
   *
   * <p>For internal use only.
   *
   * @return the suggestionTextPolicy
   */
  public String suggestionTextPolicy() {
    return suggestionTextPolicy;
  }
}

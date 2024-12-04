/*
 * (C) Copyright IBM Corp. 2024.
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

/**
 * Status information about the skills for the assistant. Included in responses only if
 * **status**=`Available`.
 */
public class AssistantState extends GenericModel {

  @SerializedName("action_disabled")
  protected Boolean actionDisabled;

  @SerializedName("dialog_disabled")
  protected Boolean dialogDisabled;

  /** Builder. */
  public static class Builder {
    private Boolean actionDisabled;
    private Boolean dialogDisabled;

    /**
     * Instantiates a new Builder from an existing AssistantState instance.
     *
     * @param assistantState the instance to initialize the Builder with
     */
    private Builder(AssistantState assistantState) {
      this.actionDisabled = assistantState.actionDisabled;
      this.dialogDisabled = assistantState.dialogDisabled;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param actionDisabled the actionDisabled
     * @param dialogDisabled the dialogDisabled
     */
    public Builder(Boolean actionDisabled, Boolean dialogDisabled) {
      this.actionDisabled = actionDisabled;
      this.dialogDisabled = dialogDisabled;
    }

    /**
     * Builds a AssistantState.
     *
     * @return the new AssistantState instance
     */
    public AssistantState build() {
      return new AssistantState(this);
    }

    /**
     * Set the actionDisabled.
     *
     * @param actionDisabled the actionDisabled
     * @return the AssistantState builder
     */
    public Builder actionDisabled(Boolean actionDisabled) {
      this.actionDisabled = actionDisabled;
      return this;
    }

    /**
     * Set the dialogDisabled.
     *
     * @param dialogDisabled the dialogDisabled
     * @return the AssistantState builder
     */
    public Builder dialogDisabled(Boolean dialogDisabled) {
      this.dialogDisabled = dialogDisabled;
      return this;
    }
  }

  protected AssistantState() {}

  protected AssistantState(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.actionDisabled, "actionDisabled cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.dialogDisabled, "dialogDisabled cannot be null");
    actionDisabled = builder.actionDisabled;
    dialogDisabled = builder.dialogDisabled;
  }

  /**
   * New builder.
   *
   * @return a AssistantState builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the actionDisabled.
   *
   * <p>Whether the action skill is disabled in the draft environment.
   *
   * @return the actionDisabled
   */
  public Boolean actionDisabled() {
    return actionDisabled;
  }

  /**
   * Gets the dialogDisabled.
   *
   * <p>Whether the dialog skill is disabled in the draft environment.
   *
   * @return the dialogDisabled
   */
  public Boolean dialogDisabled() {
    return dialogDisabled;
  }
}

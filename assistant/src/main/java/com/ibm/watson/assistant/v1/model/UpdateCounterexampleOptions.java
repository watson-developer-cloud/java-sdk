/*
 * (C) Copyright IBM Corp. 2017, 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The updateCounterexample options. */
public class UpdateCounterexampleOptions extends GenericModel {

  protected String workspaceId;
  protected String text;
  protected String newText;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String text;
    private String newText;
    private Boolean includeAudit;

    private Builder(UpdateCounterexampleOptions updateCounterexampleOptions) {
      this.workspaceId = updateCounterexampleOptions.workspaceId;
      this.text = updateCounterexampleOptions.text;
      this.newText = updateCounterexampleOptions.newText;
      this.includeAudit = updateCounterexampleOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param text the text
     */
    public Builder(String workspaceId, String text) {
      this.workspaceId = workspaceId;
      this.text = text;
    }

    /**
     * Builds a UpdateCounterexampleOptions.
     *
     * @return the updateCounterexampleOptions
     */
    public UpdateCounterexampleOptions build() {
      return new UpdateCounterexampleOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateCounterexampleOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the UpdateCounterexampleOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the newText.
     *
     * @param newText the newText
     * @return the UpdateCounterexampleOptions builder
     */
    public Builder newText(String newText) {
      this.newText = newText;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the UpdateCounterexampleOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected UpdateCounterexampleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.text, "text cannot be empty");
    workspaceId = builder.workspaceId;
    text = builder.text;
    newText = builder.newText;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a UpdateCounterexampleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * <p>Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the text.
   *
   * <p>The text of a user input counterexample (for example, `What are you wearing?`).
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the newText.
   *
   * <p>The text of a user input marked as irrelevant input. This string must conform to the
   * following restrictions: - It cannot contain carriage return, newline, or tab characters. - It
   * cannot consist of only whitespace characters.
   *
   * @return the newText
   */
  public String newText() {
    return newText;
  }

  /**
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

/*
 * (C) Copyright IBM Corp. 2017, 2024.
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
import java.util.ArrayList;
import java.util.List;

/** The updateExample options. */
public class UpdateExampleOptions extends GenericModel {

  protected String workspaceId;
  protected String intent;
  protected String text;
  protected String newText;
  protected List<Mention> newMentions;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private String text;
    private String newText;
    private List<Mention> newMentions;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing UpdateExampleOptions instance.
     *
     * @param updateExampleOptions the instance to initialize the Builder with
     */
    private Builder(UpdateExampleOptions updateExampleOptions) {
      this.workspaceId = updateExampleOptions.workspaceId;
      this.intent = updateExampleOptions.intent;
      this.text = updateExampleOptions.text;
      this.newText = updateExampleOptions.newText;
      this.newMentions = updateExampleOptions.newMentions;
      this.includeAudit = updateExampleOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param intent the intent
     * @param text the text
     */
    public Builder(String workspaceId, String intent, String text) {
      this.workspaceId = workspaceId;
      this.intent = intent;
      this.text = text;
    }

    /**
     * Builds a UpdateExampleOptions.
     *
     * @return the new UpdateExampleOptions instance
     */
    public UpdateExampleOptions build() {
      return new UpdateExampleOptions(this);
    }

    /**
     * Adds a new element to newMentions.
     *
     * @param newMentions the new element to be added
     * @return the UpdateExampleOptions builder
     */
    public Builder addNewMentions(Mention newMentions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(newMentions, "newMentions cannot be null");
      if (this.newMentions == null) {
        this.newMentions = new ArrayList<Mention>();
      }
      this.newMentions.add(newMentions);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateExampleOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the UpdateExampleOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the UpdateExampleOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the newText.
     *
     * @param newText the newText
     * @return the UpdateExampleOptions builder
     */
    public Builder newText(String newText) {
      this.newText = newText;
      return this;
    }

    /**
     * Set the newMentions. Existing newMentions will be replaced.
     *
     * @param newMentions the newMentions
     * @return the UpdateExampleOptions builder
     */
    public Builder newMentions(List<Mention> newMentions) {
      this.newMentions = newMentions;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the UpdateExampleOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected UpdateExampleOptions() {}

  protected UpdateExampleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.intent, "intent cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.text, "text cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    text = builder.text;
    newText = builder.newText;
    newMentions = builder.newMentions;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a UpdateExampleOptions builder
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
   * Gets the intent.
   *
   * <p>The intent name.
   *
   * @return the intent
   */
  public String intent() {
    return intent;
  }

  /**
   * Gets the text.
   *
   * <p>The text of the user input example.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the newText.
   *
   * <p>The text of the user input example. This string must conform to the following restrictions:
   * - It cannot contain carriage return, newline, or tab characters. - It cannot consist of only
   * whitespace characters.
   *
   * @return the newText
   */
  public String newText() {
    return newText;
  }

  /**
   * Gets the newMentions.
   *
   * <p>An array of contextual entity mentions.
   *
   * @return the newMentions
   */
  public List<Mention> newMentions() {
    return newMentions;
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

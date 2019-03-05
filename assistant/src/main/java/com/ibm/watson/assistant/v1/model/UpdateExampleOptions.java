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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The updateExample options.
 */
public class UpdateExampleOptions extends GenericModel {

  private String workspaceId;
  private String intent;
  private String text;
  private String newText;
  private List<Mentions> newMentions;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private String text;
    private String newText;
    private List<Mentions> newMentions;

    private Builder(UpdateExampleOptions updateExampleOptions) {
      workspaceId = updateExampleOptions.workspaceId;
      intent = updateExampleOptions.intent;
      text = updateExampleOptions.text;
      newText = updateExampleOptions.newText;
      newMentions = updateExampleOptions.newMentions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

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
     * @return the updateExampleOptions
     */
    public UpdateExampleOptions build() {
      return new UpdateExampleOptions(this);
    }

    /**
     * Adds an newMentions to newMentions.
     *
     * @param newMentions the new newMentions
     * @return the UpdateExampleOptions builder
     */
    public Builder addNewMentions(Mentions newMentions) {
      Validator.notNull(newMentions, "newMentions cannot be null");
      if (this.newMentions == null) {
        this.newMentions = new ArrayList<Mentions>();
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
     * Set the newMentions.
     * Existing newMentions will be replaced.
     *
     * @param newMentions the newMentions
     * @return the UpdateExampleOptions builder
     */
    public Builder newMentions(List<Mentions> newMentions) {
      this.newMentions = newMentions;
      return this;
    }
  }

  private UpdateExampleOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.intent, "intent cannot be empty");
    Validator.notEmpty(builder.text, "text cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    text = builder.text;
    newText = builder.newText;
    newMentions = builder.newMentions;
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
   * Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the intent.
   *
   * The intent name.
   *
   * @return the intent
   */
  public String intent() {
    return intent;
  }

  /**
   * Gets the text.
   *
   * The text of the user input example.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the newText.
   *
   * The text of the user input example. This string must conform to the following restrictions:
   * - It cannot contain carriage return, newline, or tab characters.
   * - It cannot consist of only whitespace characters.
   * - It must be no longer than 1024 characters.
   *
   * @return the newText
   */
  public String newText() {
    return newText;
  }

  /**
   * Gets the newMentions.
   *
   * An array of contextual entity mentions.
   *
   * @return the newMentions
   */
  public List<Mentions> newMentions() {
    return newMentions;
  }
}

/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The updateCounterexample options.
 */
public class UpdateCounterexampleOptions extends GenericModel {

  private String workspaceId;
  private String text;
  private String newText;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String text;
    private String newText;

    private Builder(UpdateCounterexampleOptions updateCounterexampleOptions) {
      workspaceId = updateCounterexampleOptions.workspaceId;
      text = updateCounterexampleOptions.text;
      newText = updateCounterexampleOptions.newText;
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
  }

  private UpdateCounterexampleOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.text, "text cannot be empty");
    workspaceId = builder.workspaceId;
    text = builder.text;
    newText = builder.newText;
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
   * The workspace ID.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the text.
   *
   * The text of a user input counterexample (for example, `What are you wearing?`).
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the newText.
   *
   * The text of the example to be marked as irrelevant input.
   *
   * @return the newText
   */
  public String newText() {
    return newText;
  }
}

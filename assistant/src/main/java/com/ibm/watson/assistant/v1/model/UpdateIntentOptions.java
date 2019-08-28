/*
 * (C) Copyright IBM Corp. 2019.
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

/**
 * The updateIntent options.
 */
public class UpdateIntentOptions extends GenericModel {

  private String workspaceId;
  private String intent;
  private String newIntent;
  private String newDescription;
  private List<Example> newExamples;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private String newIntent;
    private String newDescription;
    private List<Example> newExamples;

    private Builder(UpdateIntentOptions updateIntentOptions) {
      this.workspaceId = updateIntentOptions.workspaceId;
      this.intent = updateIntentOptions.intent;
      this.newIntent = updateIntentOptions.newIntent;
      this.newDescription = updateIntentOptions.newDescription;
      this.newExamples = updateIntentOptions.newExamples;
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
     */
    public Builder(String workspaceId, String intent) {
      this.workspaceId = workspaceId;
      this.intent = intent;
    }

    /**
     * Builds a UpdateIntentOptions.
     *
     * @return the updateIntentOptions
     */
    public UpdateIntentOptions build() {
      return new UpdateIntentOptions(this);
    }

    /**
     * Adds an example to newExamples.
     *
     * @param example the new example
     * @return the UpdateIntentOptions builder
     */
    public Builder addExample(Example example) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(example,
          "example cannot be null");
      if (this.newExamples == null) {
        this.newExamples = new ArrayList<Example>();
      }
      this.newExamples.add(example);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateIntentOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the UpdateIntentOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the newIntent.
     *
     * @param newIntent the newIntent
     * @return the UpdateIntentOptions builder
     */
    public Builder newIntent(String newIntent) {
      this.newIntent = newIntent;
      return this;
    }

    /**
     * Set the newDescription.
     *
     * @param newDescription the newDescription
     * @return the UpdateIntentOptions builder
     */
    public Builder newDescription(String newDescription) {
      this.newDescription = newDescription;
      return this;
    }

    /**
     * Set the newExamples.
     * Existing newExamples will be replaced.
     *
     * @param newExamples the newExamples
     * @return the UpdateIntentOptions builder
     */
    public Builder newExamples(List<Example> newExamples) {
      this.newExamples = newExamples;
      return this;
    }
  }

  private UpdateIntentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.workspaceId,
        "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.intent,
        "intent cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    newIntent = builder.newIntent;
    newDescription = builder.newDescription;
    newExamples = builder.newExamples;
  }

  /**
   * New builder.
   *
   * @return a UpdateIntentOptions builder
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
   * Gets the newIntent.
   *
   * The name of the intent. This string must conform to the following restrictions:
   * - It can contain only Unicode alphanumeric, underscore, hyphen, and dot characters.
   * - It cannot begin with the reserved prefix `sys-`.
   *
   * @return the newIntent
   */
  public String newIntent() {
    return newIntent;
  }

  /**
   * Gets the newDescription.
   *
   * The description of the intent. This string cannot contain carriage return, newline, or tab characters.
   *
   * @return the newDescription
   */
  public String newDescription() {
    return newDescription;
  }

  /**
   * Gets the newExamples.
   *
   * An array of user input examples for the intent.
   *
   * @return the newExamples
   */
  public List<Example> newExamples() {
    return newExamples;
  }
}

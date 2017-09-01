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

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The updateIntent options.
 */
public class UpdateIntentOptions extends GenericModel {

  private String workspaceId;
  private String intent;
  private String newIntent;
  private List<CreateExample> newExamples;
  private String newDescription;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private String newIntent;
    private List<CreateExample> newExamples;
    private String newDescription;

    private Builder(UpdateIntentOptions updateIntentOptions) {
      workspaceId = updateIntentOptions.workspaceId;
      intent = updateIntentOptions.intent;
      newIntent = updateIntentOptions.newIntent;
      newExamples = updateIntentOptions.newExamples;
      newDescription = updateIntentOptions.newDescription;
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
    public Builder addExample(CreateExample example) {
      Validator.notNull(example, "example cannot be null");
      if (this.newExamples == null) {
        this.newExamples = new ArrayList<CreateExample>();
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
     * Set the newExamples.
     * Existing newExamples will be replaced.
     *
     * @param newExamples the newExamples
     * @return the UpdateIntentOptions builder
     */
    public Builder newExamples(List<CreateExample> newExamples) {
      this.newExamples = newExamples;
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
  }

  private UpdateIntentOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.intent, "intent cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    newIntent = builder.newIntent;
    newExamples = builder.newExamples;
    newDescription = builder.newDescription;
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
   * The workspace ID.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the intent.
   *
   * The intent name (for example, `pizza_order`).
   *
   * @return the intent
   */
  public String intent() {
    return intent;
  }

  /**
   * Gets the newIntent.
   *
   * The name of the intent.
   *
   * @return the newIntent
   */
  public String newIntent() {
    return newIntent;
  }

  /**
   * Gets the newExamples.
   *
   * An array of user input examples for the intent.
   *
   * @return the newExamples
   */
  public List<CreateExample> newExamples() {
    return newExamples;
  }

  /**
   * Gets the newDescription.
   *
   * The description of the intent.
   *
   * @return the newDescription
   */
  public String newDescription() {
    return newDescription;
  }
}

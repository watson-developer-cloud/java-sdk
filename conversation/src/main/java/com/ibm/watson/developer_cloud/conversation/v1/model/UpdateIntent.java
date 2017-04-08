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

/**
 * UpdateIntent.
 */
public class UpdateIntent extends GenericModel {

  /** The name of the intent. */
  private String intent;
  /** The description of the intent. */
  private String description;
  /** An array of user input examples for the intent. */
  private List<CreateExample> examples;

  /**
   * Builder.
   */
  public static class Builder {
    private String intent;
    private String description;
    private List<CreateExample> examples;

    private Builder(UpdateIntent updateIntent) {
      intent = updateIntent.intent;
      description = updateIntent.description;
      examples = updateIntent.examples;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the UpdateIntent.
     *
     * @return the updateIntent
     */
    public UpdateIntent build() {
      return new UpdateIntent(this);
    }

    /**
     * Adds an examples to examples.
     *
     * @param examples the new examples
     */
    public Builder examples(CreateExample examples) {
      if (examples == null) {
        this.examples = new ArrayList<CreateExample>();
      }
      this.examples.add(examples);
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return a UpdateIntent Builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return a UpdateIntent Builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the examples.
     * Existing examples will be replaced.
     *
     * @param examples the examples
     * @return a UpdateIntent Builder
     */
    public Builder examples(List<CreateExample> examples) {
      this.examples = examples;
      return this;
    }
  }

  private UpdateIntent(Builder builder) {
    intent = builder.intent;
    description = builder.description;
    examples = builder.examples;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the intent.
   *
   * @return the intent
   */
  public String intent() {
    return intent;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the examples.
   *
   * @return the examples
   */
  public List<CreateExample> examples() {
    return examples;
  }
}

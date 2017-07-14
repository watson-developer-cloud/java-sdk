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
 * the createIntent options.
 */
public class CreateIntentOptions extends GenericModel {

  private String workspaceId;
  private List<CreateExample> examples;
  private String description;
  private String intent;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private List<CreateExample> examples;
    private String description;
    private String intent;

    private Builder(CreateIntentOptions createIntentOptions) {
      workspaceId = createIntentOptions.workspaceId;
      examples = createIntentOptions.examples;
      description = createIntentOptions.description;
      intent = createIntentOptions.intent;
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
     * Builds a CreateIntentOptions.
     *
     * @return the createIntentOptions
     */
    public CreateIntentOptions build() {
      return new CreateIntentOptions(this);
    }

    /**
     * Adds an example to examples.
     *
     * @param example the new example
     * @return the CreateIntentOptions builder
     */
    public Builder addExample(CreateExample example) {
      Validator.notNull(example, "example cannot be null");
      if (this.examples == null) {
        this.examples = new ArrayList<CreateExample>();
      }
      this.examples.add(example);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateIntentOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the examples.
     * Existing examples will be replaced.
     *
     * @param examples the examples
     * @return the CreateIntentOptions builder
     */
    public Builder examples(List<CreateExample> examples) {
      this.examples = examples;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateIntentOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the CreateIntentOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }
  }

  private CreateIntentOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notNull(builder.intent, "intent cannot be null");
    workspaceId = builder.workspaceId;
    examples = builder.examples;
    description = builder.description;
    intent = builder.intent;
  }

  /**
   * New builder.
   *
   * @return a CreateIntentOptions builder
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
   * Gets the examples.
   *
   * An array of user input examples.
   *
   * @return the examples
   */
  public List<CreateExample> examples() {
    return examples;
  }

  /**
   * Gets the description.
   *
   * The description of the intent.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the intent.
   *
   * The name of the intent.
   *
   * @return the intent
   */
  public String intent() {
    return intent;
  }
}

/*
 * (C) Copyright IBM Corp. 2023.
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

/** The createIntent options. */
public class CreateIntentOptions extends GenericModel {

  protected String workspaceId;
  protected String intent;
  protected String description;
  protected List<Example> examples;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private String description;
    private List<Example> examples;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing CreateIntentOptions instance.
     *
     * @param createIntentOptions the instance to initialize the Builder with
     */
    private Builder(CreateIntentOptions createIntentOptions) {
      this.workspaceId = createIntentOptions.workspaceId;
      this.intent = createIntentOptions.intent;
      this.description = createIntentOptions.description;
      this.examples = createIntentOptions.examples;
      this.includeAudit = createIntentOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * @return the new CreateIntentOptions instance
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
    public Builder addExample(Example example) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(example, "example cannot be null");
      if (this.examples == null) {
        this.examples = new ArrayList<Example>();
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
     * Set the intent.
     *
     * @param intent the intent
     * @return the CreateIntentOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
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
     * Set the examples. Existing examples will be replaced.
     *
     * @param examples the examples
     * @return the CreateIntentOptions builder
     */
    public Builder examples(List<Example> examples) {
      this.examples = examples;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the CreateIntentOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected CreateIntentOptions() {}

  protected CreateIntentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.intent, "intent cannot be null");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    description = builder.description;
    examples = builder.examples;
    includeAudit = builder.includeAudit;
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
   * <p>The name of the intent. This string must conform to the following restrictions: - It can
   * contain only Unicode alphanumeric, underscore, hyphen, and dot characters. - It cannot begin
   * with the reserved prefix `sys-`.
   *
   * @return the intent
   */
  public String intent() {
    return intent;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the intent. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the examples.
   *
   * <p>An array of user input examples for the intent.
   *
   * @return the examples
   */
  public List<Example> examples() {
    return examples;
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

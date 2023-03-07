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

/** The createCounterexample options. */
public class CreateCounterexampleOptions extends GenericModel {

  protected String workspaceId;
  protected String text;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String text;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing CreateCounterexampleOptions instance.
     *
     * @param createCounterexampleOptions the instance to initialize the Builder with
     */
    private Builder(CreateCounterexampleOptions createCounterexampleOptions) {
      this.workspaceId = createCounterexampleOptions.workspaceId;
      this.text = createCounterexampleOptions.text;
      this.includeAudit = createCounterexampleOptions.includeAudit;
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
     * Builds a CreateCounterexampleOptions.
     *
     * @return the new CreateCounterexampleOptions instance
     */
    public CreateCounterexampleOptions build() {
      return new CreateCounterexampleOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateCounterexampleOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the CreateCounterexampleOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the CreateCounterexampleOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }

    /**
     * Set the counterexample.
     *
     * @param counterexample the counterexample
     * @return the CreateCounterexampleOptions builder
     */
    public Builder counterexample(Counterexample counterexample) {
      this.text = counterexample.text();
      return this;
    }
  }

  protected CreateCounterexampleOptions() {}

  protected CreateCounterexampleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    workspaceId = builder.workspaceId;
    text = builder.text;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a CreateCounterexampleOptions builder
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
   * <p>The text of a user input marked as irrelevant input. This string must conform to the
   * following restrictions: - It cannot contain carriage return, newline, or tab characters. - It
   * cannot consist of only whitespace characters.
   *
   * @return the text
   */
  public String text() {
    return text;
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

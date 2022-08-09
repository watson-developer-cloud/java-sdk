/*
 * (C) Copyright IBM Corp. 2017, 2022.
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

/** The deleteCounterexample options. */
public class DeleteCounterexampleOptions extends GenericModel {

  protected String workspaceId;
  protected String text;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String text;

    private Builder(DeleteCounterexampleOptions deleteCounterexampleOptions) {
      this.workspaceId = deleteCounterexampleOptions.workspaceId;
      this.text = deleteCounterexampleOptions.text;
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
     * Builds a DeleteCounterexampleOptions.
     *
     * @return the new DeleteCounterexampleOptions instance
     */
    public DeleteCounterexampleOptions build() {
      return new DeleteCounterexampleOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the DeleteCounterexampleOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the DeleteCounterexampleOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected DeleteCounterexampleOptions() {}

  protected DeleteCounterexampleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.text, "text cannot be empty");
    workspaceId = builder.workspaceId;
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a DeleteCounterexampleOptions builder
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
}

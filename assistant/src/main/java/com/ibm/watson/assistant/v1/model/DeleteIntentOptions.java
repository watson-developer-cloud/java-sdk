/*
 * (C) Copyright IBM Corp. 2017, 2020.
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

/** The deleteIntent options. */
public class DeleteIntentOptions extends GenericModel {

  protected String workspaceId;
  protected String intent;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String intent;

    private Builder(DeleteIntentOptions deleteIntentOptions) {
      this.workspaceId = deleteIntentOptions.workspaceId;
      this.intent = deleteIntentOptions.intent;
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
     * Builds a DeleteIntentOptions.
     *
     * @return the deleteIntentOptions
     */
    public DeleteIntentOptions build() {
      return new DeleteIntentOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the DeleteIntentOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the DeleteIntentOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }
  }

  protected DeleteIntentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.intent, "intent cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
  }

  /**
   * New builder.
   *
   * @return a DeleteIntentOptions builder
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
}

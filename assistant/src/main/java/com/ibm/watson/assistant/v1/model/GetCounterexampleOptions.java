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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getCounterexample options.
 */
public class GetCounterexampleOptions extends GenericModel {

  private String workspaceId;
  private String text;
  private Boolean includeAudit;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String text;
    private Boolean includeAudit;

    private Builder(GetCounterexampleOptions getCounterexampleOptions) {
      this.workspaceId = getCounterexampleOptions.workspaceId;
      this.text = getCounterexampleOptions.text;
      this.includeAudit = getCounterexampleOptions.includeAudit;
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
     * Builds a GetCounterexampleOptions.
     *
     * @return the getCounterexampleOptions
     */
    public GetCounterexampleOptions build() {
      return new GetCounterexampleOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the GetCounterexampleOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the GetCounterexampleOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the GetCounterexampleOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  private GetCounterexampleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.workspaceId,
        "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.text,
        "text cannot be empty");
    workspaceId = builder.workspaceId;
    text = builder.text;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a GetCounterexampleOptions builder
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
   * Gets the includeAudit.
   *
   * Whether to include the audit properties (`created` and `updated` timestamps) in the response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

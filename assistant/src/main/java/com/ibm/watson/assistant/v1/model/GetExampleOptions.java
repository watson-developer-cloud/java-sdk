/*
 * (C) Copyright IBM Corp. 2024.
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

/** The getExample options. */
public class GetExampleOptions extends GenericModel {

  protected String workspaceId;
  protected String intent;
  protected String text;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private String text;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing GetExampleOptions instance.
     *
     * @param getExampleOptions the instance to initialize the Builder with
     */
    private Builder(GetExampleOptions getExampleOptions) {
      this.workspaceId = getExampleOptions.workspaceId;
      this.intent = getExampleOptions.intent;
      this.text = getExampleOptions.text;
      this.includeAudit = getExampleOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param intent the intent
     * @param text the text
     */
    public Builder(String workspaceId, String intent, String text) {
      this.workspaceId = workspaceId;
      this.intent = intent;
      this.text = text;
    }

    /**
     * Builds a GetExampleOptions.
     *
     * @return the new GetExampleOptions instance
     */
    public GetExampleOptions build() {
      return new GetExampleOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the GetExampleOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the GetExampleOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the GetExampleOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the GetExampleOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected GetExampleOptions() {}

  protected GetExampleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.intent, "intent cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.text, "text cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    text = builder.text;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a GetExampleOptions builder
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

  /**
   * Gets the text.
   *
   * <p>The text of the user input example.
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

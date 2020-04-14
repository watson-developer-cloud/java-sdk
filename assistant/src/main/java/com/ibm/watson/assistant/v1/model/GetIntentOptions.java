/*
 * (C) Copyright IBM Corp. 2020.
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

/** The getIntent options. */
public class GetIntentOptions extends GenericModel {

  protected String workspaceId;
  protected String intent;
  protected Boolean export;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private Boolean export;
    private Boolean includeAudit;

    private Builder(GetIntentOptions getIntentOptions) {
      this.workspaceId = getIntentOptions.workspaceId;
      this.intent = getIntentOptions.intent;
      this.export = getIntentOptions.export;
      this.includeAudit = getIntentOptions.includeAudit;
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
     * Builds a GetIntentOptions.
     *
     * @return the getIntentOptions
     */
    public GetIntentOptions build() {
      return new GetIntentOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the GetIntentOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the GetIntentOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the export.
     *
     * @param export the export
     * @return the GetIntentOptions builder
     */
    public Builder export(Boolean export) {
      this.export = export;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the GetIntentOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected GetIntentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.intent, "intent cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    export = builder.export;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a GetIntentOptions builder
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
   * Gets the export.
   *
   * <p>Whether to include all element content in the returned data. If **export**=`false`, the
   * returned data includes only information about the element itself. If **export**=`true`, all
   * content, including subelements, is included.
   *
   * @return the export
   */
  public Boolean export() {
    return export;
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

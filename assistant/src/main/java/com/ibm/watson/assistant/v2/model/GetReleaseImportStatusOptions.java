/*
 * (C) Copyright IBM Corp. 2024, 2025.
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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getReleaseImportStatus options. */
public class GetReleaseImportStatusOptions extends GenericModel {

  protected String assistantId;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing GetReleaseImportStatusOptions instance.
     *
     * @param getReleaseImportStatusOptions the instance to initialize the Builder with
     */
    private Builder(GetReleaseImportStatusOptions getReleaseImportStatusOptions) {
      this.assistantId = getReleaseImportStatusOptions.assistantId;
      this.includeAudit = getReleaseImportStatusOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     */
    public Builder(String assistantId) {
      this.assistantId = assistantId;
    }

    /**
     * Builds a GetReleaseImportStatusOptions.
     *
     * @return the new GetReleaseImportStatusOptions instance
     */
    public GetReleaseImportStatusOptions build() {
      return new GetReleaseImportStatusOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the GetReleaseImportStatusOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the GetReleaseImportStatusOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected GetReleaseImportStatusOptions() {}

  protected GetReleaseImportStatusOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    assistantId = builder.assistantId;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a GetReleaseImportStatusOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>Unique identifier of the assistant. To get the **assistant ID** in the watsonx Assistant
   * interface, open the **Assistant settings** page, and scroll to the **Assistant IDs and API
   * details** section and click **View Details**.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
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

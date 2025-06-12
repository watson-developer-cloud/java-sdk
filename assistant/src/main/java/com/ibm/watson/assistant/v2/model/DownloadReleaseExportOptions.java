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

/** The downloadReleaseExport options. */
public class DownloadReleaseExportOptions extends GenericModel {

  protected String assistantId;
  protected String release;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String release;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing DownloadReleaseExportOptions instance.
     *
     * @param downloadReleaseExportOptions the instance to initialize the Builder with
     */
    private Builder(DownloadReleaseExportOptions downloadReleaseExportOptions) {
      this.assistantId = downloadReleaseExportOptions.assistantId;
      this.release = downloadReleaseExportOptions.release;
      this.includeAudit = downloadReleaseExportOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param release the release
     */
    public Builder(String assistantId, String release) {
      this.assistantId = assistantId;
      this.release = release;
    }

    /**
     * Builds a DownloadReleaseExportOptions.
     *
     * @return the new DownloadReleaseExportOptions instance
     */
    public DownloadReleaseExportOptions build() {
      return new DownloadReleaseExportOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the DownloadReleaseExportOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the release.
     *
     * @param release the release
     * @return the DownloadReleaseExportOptions builder
     */
    public Builder release(String release) {
      this.release = release;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the DownloadReleaseExportOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected DownloadReleaseExportOptions() {}

  protected DownloadReleaseExportOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.release, "release cannot be empty");
    assistantId = builder.assistantId;
    release = builder.release;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a DownloadReleaseExportOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>The assistant ID or the environment ID of the environment where the assistant is deployed.
   * Set the value for this ID depending on the type of request:
   *
   * <p>- For message, session, and log requests, specify the environment ID of the environment
   * where the assistant is deployed.
   *
   * <p>- For all other requests, specify the assistant ID of the assistant.
   *
   * <p>To get the **assistant ID** and **environment ID** in the watsonx Assistant interface, open
   * the **Assistant settings** page, and scroll to the **Assistant IDs and API details** section
   * and click **View Details**.
   *
   * <p>**Note:** If you are using the classic Watson Assistant experience, always use the assistant
   * ID.
   *
   * <p>To find the **assistant ID** in the user interface, open the **Assistant settings** and
   * click **API Details**.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the release.
   *
   * <p>Unique identifier of the release.
   *
   * @return the release
   */
  public String release() {
    return release;
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

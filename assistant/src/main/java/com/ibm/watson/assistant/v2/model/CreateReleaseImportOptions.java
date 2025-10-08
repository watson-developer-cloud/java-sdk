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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The createReleaseImport options. */
public class CreateReleaseImportOptions extends GenericModel {

  protected String assistantId;
  protected InputStream body;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private InputStream body;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing CreateReleaseImportOptions instance.
     *
     * @param createReleaseImportOptions the instance to initialize the Builder with
     */
    private Builder(CreateReleaseImportOptions createReleaseImportOptions) {
      this.assistantId = createReleaseImportOptions.assistantId;
      this.body = createReleaseImportOptions.body;
      this.includeAudit = createReleaseImportOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param body the body
     */
    public Builder(String assistantId, InputStream body) {
      this.assistantId = assistantId;
      this.body = body;
    }

    /**
     * Builds a CreateReleaseImportOptions.
     *
     * @return the new CreateReleaseImportOptions instance
     */
    public CreateReleaseImportOptions build() {
      return new CreateReleaseImportOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the CreateReleaseImportOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the CreateReleaseImportOptions builder
     */
    public Builder body(InputStream body) {
      this.body = body;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the CreateReleaseImportOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the CreateReleaseImportOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder body(File body) throws FileNotFoundException {
      this.body = new FileInputStream(body);
      return this;
    }
  }

  protected CreateReleaseImportOptions() {}

  protected CreateReleaseImportOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.body, "body cannot be null");
    assistantId = builder.assistantId;
    body = builder.body;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a CreateReleaseImportOptions builder
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
   * Gets the body.
   *
   * <p>Request body is an Octet-stream of the artifact Zip file that is being imported.
   *
   * @return the body
   */
  public InputStream body() {
    return body;
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

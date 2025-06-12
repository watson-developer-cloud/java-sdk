/*
 * (C) Copyright IBM Corp. 2023, 2025.
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

/** The importSkillsStatus options. */
public class ImportSkillsStatusOptions extends GenericModel {

  protected String assistantId;

  /** Builder. */
  public static class Builder {
    private String assistantId;

    /**
     * Instantiates a new Builder from an existing ImportSkillsStatusOptions instance.
     *
     * @param importSkillsStatusOptions the instance to initialize the Builder with
     */
    private Builder(ImportSkillsStatusOptions importSkillsStatusOptions) {
      this.assistantId = importSkillsStatusOptions.assistantId;
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
     * Builds a ImportSkillsStatusOptions.
     *
     * @return the new ImportSkillsStatusOptions instance
     */
    public ImportSkillsStatusOptions build() {
      return new ImportSkillsStatusOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the ImportSkillsStatusOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }
  }

  protected ImportSkillsStatusOptions() {}

  protected ImportSkillsStatusOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    assistantId = builder.assistantId;
  }

  /**
   * New builder.
   *
   * @return a ImportSkillsStatusOptions builder
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
}

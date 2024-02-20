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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The createRelease options. */
public class CreateReleaseOptions extends GenericModel {

  protected String assistantId;
  protected String description;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String description;

    /**
     * Instantiates a new Builder from an existing CreateReleaseOptions instance.
     *
     * @param createReleaseOptions the instance to initialize the Builder with
     */
    private Builder(CreateReleaseOptions createReleaseOptions) {
      this.assistantId = createReleaseOptions.assistantId;
      this.description = createReleaseOptions.description;
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
     * Builds a CreateReleaseOptions.
     *
     * @return the new CreateReleaseOptions instance
     */
    public CreateReleaseOptions build() {
      return new CreateReleaseOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the CreateReleaseOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateReleaseOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the release.
     *
     * @param release the release
     * @return the CreateReleaseOptions builder
     */
    public Builder release(Release release) {
      this.description = release.description();
      return this;
    }
  }

  protected CreateReleaseOptions() {}

  protected CreateReleaseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    assistantId = builder.assistantId;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateReleaseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>The assistant ID or the environment ID of the environment where the assistant is deployed,
   * depending on the type of request: - For message, session, and log requests, specify the
   * environment ID of the environment where the assistant is deployed. - For all other requests,
   * specify the assistant ID of the assistant.
   *
   * <p>To find the environment ID or assistant ID in the watsonx Assistant user interface, open the
   * assistant settings and scroll to the **Environments** section.
   *
   * <p>**Note:** If you are using the classic Watson Assistant experience, always use the assistant
   * ID. To find the assistant ID in the user interface, open the assistant settings and click API
   * Details.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the release.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

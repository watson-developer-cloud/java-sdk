/*
 * (C) Copyright IBM Corp. 2021, 2024.
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

package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteCustomPrompt options. */
public class DeleteCustomPromptOptions extends GenericModel {

  protected String customizationId;
  protected String promptId;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String promptId;

    /**
     * Instantiates a new Builder from an existing DeleteCustomPromptOptions instance.
     *
     * @param deleteCustomPromptOptions the instance to initialize the Builder with
     */
    private Builder(DeleteCustomPromptOptions deleteCustomPromptOptions) {
      this.customizationId = deleteCustomPromptOptions.customizationId;
      this.promptId = deleteCustomPromptOptions.promptId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param promptId the promptId
     */
    public Builder(String customizationId, String promptId) {
      this.customizationId = customizationId;
      this.promptId = promptId;
    }

    /**
     * Builds a DeleteCustomPromptOptions.
     *
     * @return the new DeleteCustomPromptOptions instance
     */
    public DeleteCustomPromptOptions build() {
      return new DeleteCustomPromptOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the DeleteCustomPromptOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the promptId.
     *
     * @param promptId the promptId
     * @return the DeleteCustomPromptOptions builder
     */
    public Builder promptId(String promptId) {
      this.promptId = promptId;
      return this;
    }
  }

  protected DeleteCustomPromptOptions() {}

  protected DeleteCustomPromptOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.promptId, "promptId cannot be empty");
    customizationId = builder.customizationId;
    promptId = builder.promptId;
  }

  /**
   * New builder.
   *
   * @return a DeleteCustomPromptOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of the custom model. You must make the request with credentials
   * for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the promptId.
   *
   * <p>The identifier (name) of the prompt that is to be deleted.
   *
   * @return the promptId
   */
  public String promptId() {
    return promptId;
  }
}

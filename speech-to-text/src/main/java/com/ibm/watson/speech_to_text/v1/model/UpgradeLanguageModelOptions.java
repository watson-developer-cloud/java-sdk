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

package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The upgradeLanguageModel options. */
public class UpgradeLanguageModelOptions extends GenericModel {

  protected String customizationId;

  /** Builder. */
  public static class Builder {
    private String customizationId;

    /**
     * Instantiates a new Builder from an existing UpgradeLanguageModelOptions instance.
     *
     * @param upgradeLanguageModelOptions the instance to initialize the Builder with
     */
    private Builder(UpgradeLanguageModelOptions upgradeLanguageModelOptions) {
      this.customizationId = upgradeLanguageModelOptions.customizationId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     */
    public Builder(String customizationId) {
      this.customizationId = customizationId;
    }

    /**
     * Builds a UpgradeLanguageModelOptions.
     *
     * @return the new UpgradeLanguageModelOptions instance
     */
    public UpgradeLanguageModelOptions build() {
      return new UpgradeLanguageModelOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the UpgradeLanguageModelOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }
  }

  protected UpgradeLanguageModelOptions() {}

  protected UpgradeLanguageModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
  }

  /**
   * New builder.
   *
   * @return a UpgradeLanguageModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of the custom language model that is to be used for the request.
   * You must make the request with credentials for the instance of the service that owns the custom
   * model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }
}

/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The upgradeAcousticModel options.
 */
public class UpgradeAcousticModelOptions extends GenericModel {

  private String customizationId;
  private String customLanguageModelId;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String customLanguageModelId;

    private Builder(UpgradeAcousticModelOptions upgradeAcousticModelOptions) {
      customizationId = upgradeAcousticModelOptions.customizationId;
      customLanguageModelId = upgradeAcousticModelOptions.customLanguageModelId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     */
    public Builder(String customizationId) {
      this.customizationId = customizationId;
    }

    /**
     * Builds a UpgradeAcousticModelOptions.
     *
     * @return the upgradeAcousticModelOptions
     */
    public UpgradeAcousticModelOptions build() {
      return new UpgradeAcousticModelOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the UpgradeAcousticModelOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the customLanguageModelId.
     *
     * @param customLanguageModelId the customLanguageModelId
     * @return the UpgradeAcousticModelOptions builder
     */
    public Builder customLanguageModelId(String customLanguageModelId) {
      this.customLanguageModelId = customLanguageModelId;
      return this;
    }
  }

  private UpgradeAcousticModelOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
    customLanguageModelId = builder.customLanguageModelId;
  }

  /**
   * New builder.
   *
   * @return a UpgradeAcousticModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom acoustic model that is to be used for the request. You must make the
   * request with credentials for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the customLanguageModelId.
   *
   * If the custom acoustic model was trained with a custom language model, the customization ID (GUID) of that custom
   * language model. The custom language model must be upgraded before the custom acoustic model can be upgraded.
   *
   * @return the customLanguageModelId
   */
  public String customLanguageModelId() {
    return customLanguageModelId;
  }
}

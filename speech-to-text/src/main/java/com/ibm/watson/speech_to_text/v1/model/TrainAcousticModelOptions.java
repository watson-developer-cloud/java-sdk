/*
 * (C) Copyright IBM Corp. 2019.
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

/**
 * The trainAcousticModel options.
 */
public class TrainAcousticModelOptions extends GenericModel {

  private String customizationId;
  private String customLanguageModelId;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String customLanguageModelId;

    private Builder(TrainAcousticModelOptions trainAcousticModelOptions) {
      this.customizationId = trainAcousticModelOptions.customizationId;
      this.customLanguageModelId = trainAcousticModelOptions.customLanguageModelId;
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
     * Builds a TrainAcousticModelOptions.
     *
     * @return the trainAcousticModelOptions
     */
    public TrainAcousticModelOptions build() {
      return new TrainAcousticModelOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the TrainAcousticModelOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the customLanguageModelId.
     *
     * @param customLanguageModelId the customLanguageModelId
     * @return the TrainAcousticModelOptions builder
     */
    public Builder customLanguageModelId(String customLanguageModelId) {
      this.customLanguageModelId = customLanguageModelId;
      return this;
    }
  }

  private TrainAcousticModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.customizationId,
        "customizationId cannot be empty");
    customizationId = builder.customizationId;
    customLanguageModelId = builder.customLanguageModelId;
  }

  /**
   * New builder.
   *
   * @return a TrainAcousticModelOptions builder
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
   * The customization ID (GUID) of a custom language model that is to be used during training of the custom acoustic
   * model. Specify a custom language model that has been trained with verbatim transcriptions of the audio resources or
   * that contains words that are relevant to the contents of the audio resources. The custom language model must be
   * based on the same version of the same base model as the custom acoustic model. The credentials specified with the
   * request must own both custom models.
   *
   * @return the customLanguageModelId
   */
  public String customLanguageModelId() {
    return customLanguageModelId;
  }
}

/*
 * (C) Copyright IBM Corp. 2018, 2023.
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

/** The trainAcousticModel options. */
public class TrainAcousticModelOptions extends GenericModel {

  protected String customizationId;
  protected String customLanguageModelId;
  protected Boolean strict;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String customLanguageModelId;
    private Boolean strict;

    /**
     * Instantiates a new Builder from an existing TrainAcousticModelOptions instance.
     *
     * @param trainAcousticModelOptions the instance to initialize the Builder with
     */
    private Builder(TrainAcousticModelOptions trainAcousticModelOptions) {
      this.customizationId = trainAcousticModelOptions.customizationId;
      this.customLanguageModelId = trainAcousticModelOptions.customLanguageModelId;
      this.strict = trainAcousticModelOptions.strict;
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
     * Builds a TrainAcousticModelOptions.
     *
     * @return the new TrainAcousticModelOptions instance
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

    /**
     * Set the strict.
     *
     * @param strict the strict
     * @return the TrainAcousticModelOptions builder
     */
    public Builder strict(Boolean strict) {
      this.strict = strict;
      return this;
    }
  }

  protected TrainAcousticModelOptions() {}

  protected TrainAcousticModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
    customLanguageModelId = builder.customLanguageModelId;
    strict = builder.strict;
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
   * <p>The customization ID (GUID) of the custom acoustic model that is to be used for the request.
   * You must make the request with credentials for the instance of the service that owns the custom
   * model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the customLanguageModelId.
   *
   * <p>The customization ID (GUID) of a custom language model that is to be used during training of
   * the custom acoustic model. Specify a custom language model that has been trained with verbatim
   * transcriptions of the audio resources or that contains words that are relevant to the contents
   * of the audio resources. The custom language model must be based on the same version of the same
   * base model as the custom acoustic model, and the custom language model must be fully trained
   * and available. The credentials specified with the request must own both custom models.
   *
   * @return the customLanguageModelId
   */
  public String customLanguageModelId() {
    return customLanguageModelId;
  }

  /**
   * Gets the strict.
   *
   * <p>If `false`, allows training of the custom acoustic model to proceed as long as the model
   * contains at least one valid audio resource. The method returns an array of `TrainingWarning`
   * objects that lists any invalid resources. By default (`true`), training of a custom acoustic
   * model fails (status code 400) if the model contains one or more invalid audio resources.
   *
   * @return the strict
   */
  public Boolean strict() {
    return strict;
  }
}

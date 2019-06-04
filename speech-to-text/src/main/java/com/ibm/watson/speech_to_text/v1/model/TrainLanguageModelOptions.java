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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The trainLanguageModel options.
 */
public class TrainLanguageModelOptions extends GenericModel {

  /**
   * The type of words from the custom language model's words resource on which to train the model:
   * * `all` (the default) trains the model on all new words, regardless of whether they were extracted from corpora or
   * grammars or were added or modified by the user.
   * * `user` trains the model only on new words that were added or modified by the user directly. The model is not
   * trained on new words extracted from corpora or grammars.
   */
  public interface WordTypeToAdd {
    /** all. */
    String ALL = "all";
    /** user. */
    String USER = "user";
  }

  private String customizationId;
  private String wordTypeToAdd;
  private Double customizationWeight;
  private Boolean strict;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String wordTypeToAdd;
    private Double customizationWeight;
    private Boolean strict;

    private Builder(TrainLanguageModelOptions trainLanguageModelOptions) {
      this.customizationId = trainLanguageModelOptions.customizationId;
      this.wordTypeToAdd = trainLanguageModelOptions.wordTypeToAdd;
      this.customizationWeight = trainLanguageModelOptions.customizationWeight;
      this.strict = trainLanguageModelOptions.strict;
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
     * Builds a TrainLanguageModelOptions.
     *
     * @return the trainLanguageModelOptions
     */
    public TrainLanguageModelOptions build() {
      return new TrainLanguageModelOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the TrainLanguageModelOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the wordTypeToAdd.
     *
     * @param wordTypeToAdd the wordTypeToAdd
     * @return the TrainLanguageModelOptions builder
     */
    public Builder wordTypeToAdd(String wordTypeToAdd) {
      this.wordTypeToAdd = wordTypeToAdd;
      return this;
    }

    /**
     * Set the customizationWeight.
     *
     * @param customizationWeight the customizationWeight
     * @return the TrainLanguageModelOptions builder
     */
    public Builder customizationWeight(Double customizationWeight) {
      this.customizationWeight = customizationWeight;
      return this;
    }

    /**
     * Set the strict.
     *
     * @param strict the strict
     * @return the TrainLanguageModelOptions builder
     */
    public Builder strict(Boolean strict) {
      this.strict = strict;
      return this;
    }
  }

  private TrainLanguageModelOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
    wordTypeToAdd = builder.wordTypeToAdd;
    customizationWeight = builder.customizationWeight;
    strict = builder.strict;
  }

  /**
   * New builder.
   *
   * @return a TrainLanguageModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom language model that is to be used for the request. You must make the
   * request with credentials for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the wordTypeToAdd.
   *
   * The type of words from the custom language model's words resource on which to train the model:
   * * `all` (the default) trains the model on all new words, regardless of whether they were extracted from corpora or
   * grammars or were added or modified by the user.
   * * `user` trains the model only on new words that were added or modified by the user directly. The model is not
   * trained on new words extracted from corpora or grammars.
   *
   * @return the wordTypeToAdd
   */
  public String wordTypeToAdd() {
    return wordTypeToAdd;
  }

  /**
   * Gets the customizationWeight.
   *
   * Specifies a customization weight for the custom language model. The customization weight tells the service how much
   * weight to give to words from the custom language model compared to those from the base model for speech
   * recognition. Specify a value between 0.0 and 1.0; the default is 0.3.
   *
   * The default value yields the best performance in general. Assign a higher value if your audio makes frequent use of
   * OOV words from the custom model. Use caution when setting the weight: a higher value can improve the accuracy of
   * phrases from the custom model's domain, but it can negatively affect performance on non-domain phrases.
   *
   * The value that you assign is used for all recognition requests that use the model. You can override it for any
   * recognition request by specifying a customization weight for that request.
   *
   * @return the customizationWeight
   */
  public Double customizationWeight() {
    return customizationWeight;
  }

  /**
   * Gets the strict.
   *
   * If `false`, allows training of the custom language model to proceed as long as the model contains at least one
   * valid resource. The method returns an array of `TrainingWarning` objects that lists any invalid resources. By
   * default (`true`), training of a custom language model fails (status code 400) if the model contains one or more
   * invalid resources (corpus files, grammar files, or custom words).
   *
   * @return the strict
   */
  public Boolean strict() {
    return strict;
  }
}

/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/** The trainLanguageModel options. */
public class TrainLanguageModelOptions extends GenericModel {

  /**
   * The type of words from the custom language model's words resource on which to train the model:
   * * `all` (the default) trains the model on all new words, regardless of whether they were
   * extracted from corpora or grammars or were added or modified by the user. * `user` trains the
   * model only on new words that were added or modified by the user directly. The model is not
   * trained on new words extracted from corpora or grammars.
   */
  public interface WordTypeToAdd {
    /** all. */
    String ALL = "all";
    /** user. */
    String USER = "user";
  }

  protected String customizationId;
  protected String wordTypeToAdd;
  protected Double customizationWeight;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String wordTypeToAdd;
    private Double customizationWeight;

    private Builder(TrainLanguageModelOptions trainLanguageModelOptions) {
      this.customizationId = trainLanguageModelOptions.customizationId;
      this.wordTypeToAdd = trainLanguageModelOptions.wordTypeToAdd;
      this.customizationWeight = trainLanguageModelOptions.customizationWeight;
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
  }

  protected TrainLanguageModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
    wordTypeToAdd = builder.wordTypeToAdd;
    customizationWeight = builder.customizationWeight;
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
   * <p>The customization ID (GUID) of the custom language model that is to be used for the request.
   * You must make the request with credentials for the instance of the service that owns the custom
   * model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the wordTypeToAdd.
   *
   * <p>The type of words from the custom language model's words resource on which to train the
   * model: * `all` (the default) trains the model on all new words, regardless of whether they were
   * extracted from corpora or grammars or were added or modified by the user. * `user` trains the
   * model only on new words that were added or modified by the user directly. The model is not
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
   * <p>Specifies a customization weight for the custom language model. The customization weight
   * tells the service how much weight to give to words from the custom language model compared to
   * those from the base model for speech recognition. Specify a value between 0.0 and 1.0; the
   * default is 0.3.
   *
   * <p>The default value yields the best performance in general. Assign a higher value if your
   * audio makes frequent use of OOV words from the custom model. Use caution when setting the
   * weight: a higher value can improve the accuracy of phrases from the custom model's domain, but
   * it can negatively affect performance on non-domain phrases.
   *
   * <p>The value that you assign is used for all recognition requests that use the model. You can
   * override it for any recognition request by specifying a customization weight for that request.
   *
   * @return the customizationWeight
   */
  public Double customizationWeight() {
    return customizationWeight;
  }
}

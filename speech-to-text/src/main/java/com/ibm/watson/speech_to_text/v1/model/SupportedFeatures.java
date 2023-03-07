/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Indicates whether select service features are supported with the model. */
public class SupportedFeatures extends GenericModel {

  @SerializedName("custom_language_model")
  protected Boolean customLanguageModel;

  @SerializedName("custom_acoustic_model")
  protected Boolean customAcousticModel;

  @SerializedName("speaker_labels")
  protected Boolean speakerLabels;

  @SerializedName("low_latency")
  protected Boolean lowLatency;

  protected SupportedFeatures() {}

  /**
   * Gets the customLanguageModel.
   *
   * <p>Indicates whether the customization interface can be used to create a custom language model
   * based on the language model.
   *
   * @return the customLanguageModel
   */
  public Boolean isCustomLanguageModel() {
    return customLanguageModel;
  }

  /**
   * Gets the customAcousticModel.
   *
   * <p>Indicates whether the customization interface can be used to create a custom acoustic model
   * based on the language model.
   *
   * @return the customAcousticModel
   */
  public Boolean isCustomAcousticModel() {
    return customAcousticModel;
  }

  /**
   * Gets the speakerLabels.
   *
   * <p>Indicates whether the `speaker_labels` parameter can be used with the language model.
   *
   * <p>**Note:** The field returns `true` for all models. However, speaker labels are supported for
   * use only with the following languages and models: * _For previous-generation models,_ the
   * parameter can be used with Australian English, US English, German, Japanese, Korean, and
   * Spanish (both broadband and narrowband models) and UK English (narrowband model) transcription
   * only. * _For next-generation models,_ the parameter can be used with Czech, English
   * (Australian, Indian, UK, and US), German, Japanese, Korean, and Spanish transcription only.
   *
   * <p>Speaker labels are not supported for use with any other languages or models.
   *
   * @return the speakerLabels
   */
  public Boolean isSpeakerLabels() {
    return speakerLabels;
  }

  /**
   * Gets the lowLatency.
   *
   * <p>Indicates whether the `low_latency` parameter can be used with a next-generation language
   * model. The field is returned only for next-generation models. Previous-generation models do not
   * support the `low_latency` parameter.
   *
   * @return the lowLatency
   */
  public Boolean isLowLatency() {
    return lowLatency;
  }
}

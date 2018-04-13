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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SupportedFeatures.
 */
public class SupportedFeatures extends GenericModel {

  @SerializedName("custom_language_model")
  private Boolean customLanguageModel;
  @SerializedName("speaker_labels")
  private Boolean speakerLabels;

  /**
   * Gets the customLanguageModel.
   *
   * Indicates whether the customization interface can be used to create a custom language model based on the language
   * model.
   *
   * @return the customLanguageModel
   */
  public Boolean isCustomLanguageModel() {
    return customLanguageModel;
  }

  /**
   * Gets the speakerLabels.
   *
   * Indicates whether the `speaker_labels` parameter can be used with the language model.
   *
   * @return the speakerLabels
   */
  public Boolean isSpeakerLabels() {
    return speakerLabels;
  }
}

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
package com.ibm.watson.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** A custom models for which the speaker has defined prompts. */
public class SpeakerCustomModel extends GenericModel {

  @SerializedName("customization_id")
  protected String customizationId;

  protected List<SpeakerPrompt> prompts;

  protected SpeakerCustomModel() {}

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of a custom model for which the speaker has defined one or more
   * prompts.
   *
   * @return the customizationId
   */
  public String getCustomizationId() {
    return customizationId;
  }

  /**
   * Gets the prompts.
   *
   * <p>An array of `SpeakerPrompt` objects that provides information about each prompt that the
   * user has defined for the custom model.
   *
   * @return the prompts
   */
  public List<SpeakerPrompt> getPrompts() {
    return prompts;
  }
}

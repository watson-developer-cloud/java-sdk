/*
 * (C) Copyright IBM Corp. 2021.
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

/** Additional service features that are supported with the voice. */
public class SupportedFeatures extends GenericModel {

  @SerializedName("custom_pronunciation")
  protected Boolean customPronunciation;

  @SerializedName("voice_transformation")
  protected Boolean voiceTransformation;

  /**
   * Gets the customPronunciation.
   *
   * <p>If `true`, the voice can be customized; if `false`, the voice cannot be customized. (Same as
   * `customizable`.).
   *
   * @return the customPronunciation
   */
  public Boolean isCustomPronunciation() {
    return customPronunciation;
  }

  /**
   * Gets the voiceTransformation.
   *
   * <p>If `true`, the voice can be transformed by using the SSML
   * &amp;lt;voice-transformation&amp;gt; element; if `false`, the voice cannot be transformed. The
   * feature was available only for the now-deprecated standard voices. You cannot use the feature
   * with neural voices.
   *
   * @return the voiceTransformation
   */
  public Boolean isVoiceTransformation() {
    return voiceTransformation;
  }
}

/*
 * (C) Copyright IBM Corp. 2026.
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
import java.util.List;

/** Language detection results. */
public class LanguageDetectionResult extends GenericModel {

  @SerializedName("language_info")
  protected List<LanguageInfo> languageInfo;

  protected LanguageDetectionResult() {}

  /**
   * Gets the languageInfo.
   *
   * <p>An array of `LanguageInfo` objects.
   *
   * @return the languageInfo
   */
  public List<LanguageInfo> getLanguageInfo() {
    return languageInfo;
  }
}

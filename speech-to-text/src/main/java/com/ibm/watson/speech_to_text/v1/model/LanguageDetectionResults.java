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
public class LanguageDetectionResults extends GenericModel {

  protected List<LanguageDetectionResult> results;

  @SerializedName("result_index")
  protected Long resultIndex;

  protected LanguageDetectionResults() {}

  /**
   * Gets the results.
   *
   * <p>An array of `LanguageDetectionResult` objects.
   *
   * @return the results
   */
  public List<LanguageDetectionResult> getResults() {
    return results;
  }

  /**
   * Gets the resultIndex.
   *
   * <p>An index that indicates a change point in the `results` array. The service increments the
   * index for additional results that it sends for new audio for the same request. All results with
   * the same index are delivered at the same time. The same index can include multiple final
   * results that are delivered with the same response.
   *
   * @return the resultIndex
   */
  public Long getResultIndex() {
    return resultIndex;
  }
}

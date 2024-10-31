/*
 * (C) Copyright IBM Corp. 2024.
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
import java.util.List;

/** The response from training of a custom language or custom acoustic model. */
public class TrainingResponse extends GenericModel {

  protected List<TrainingWarning> warnings;

  protected TrainingResponse() {}

  /**
   * Gets the warnings.
   *
   * <p>An array of `TrainingWarning` objects that lists any invalid resources contained in the
   * custom model. For custom language models, invalid resources are grouped and identified by type
   * of resource. The method can return warnings only if the `strict` parameter is set to `false`.
   *
   * @return the warnings
   */
  public List<TrainingWarning> getWarnings() {
    return warnings;
  }
}

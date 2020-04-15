/*
 * (C) Copyright IBM Corp. 2020.
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

/** Information about existing custom acoustic models. */
public class AcousticModels extends GenericModel {

  protected List<AcousticModel> customizations;

  /**
   * Gets the customizations.
   *
   * <p>An array of `AcousticModel` objects that provides information about each available custom
   * acoustic model. The array is empty if the requesting credentials own no custom acoustic models
   * (if no language is specified) or own no custom acoustic models for the specified language.
   *
   * @return the customizations
   */
  public List<AcousticModel> getCustomizations() {
    return customizations;
  }
}

/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about the grammars from a custom language model.
 */
public class Grammars extends GenericModel {

  private List<Grammar> grammars;

  /**
   * Gets the grammars.
   *
   * An array of `Grammar` objects that provides information about the grammars for the custom model. The array is empty
   * if the custom model has no grammars.
   *
   * @return the grammars
   */
  public List<Grammar> getGrammars() {
    return grammars;
  }
}

/*
 * (C) Copyright IBM Corp. 2020, 2023.
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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** BulkClassifyOutput. */
public class BulkClassifyOutput extends GenericModel {

  protected BulkClassifyUtterance input;
  protected List<RuntimeEntity> entities;
  protected List<RuntimeIntent> intents;

  protected BulkClassifyOutput() {}

  /**
   * Gets the input.
   *
   * <p>The user input utterance to classify.
   *
   * @return the input
   */
  public BulkClassifyUtterance getInput() {
    return input;
  }

  /**
   * Gets the entities.
   *
   * <p>An array of entities identified in the utterance.
   *
   * @return the entities
   */
  public List<RuntimeEntity> getEntities() {
    return entities;
  }

  /**
   * Gets the intents.
   *
   * <p>An array of intents recognized in the utterance.
   *
   * @return the intents
   */
  public List<RuntimeIntent> getIntents() {
    return intents;
  }
}

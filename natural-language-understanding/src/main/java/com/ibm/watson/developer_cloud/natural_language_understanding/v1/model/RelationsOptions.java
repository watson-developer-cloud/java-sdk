/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;


import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An option specifying if the relationships found between entities in the analyzed content should be returned.
 */
public class RelationsOptions extends GenericModel {

  /** Enter a custom model ID to override the default model. */
  private String model;

  /**
   * Gets the model.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Sets the model.
   *
   * @param model the new model
   */
  public void setModel(final String model) {
    this.model = model;
  }

}

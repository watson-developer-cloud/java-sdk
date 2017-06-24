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

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Models available for Relations and Entities features.
 */
public class ListModelsResults extends GenericModel {

  private List<Model> models;

  /**
   * Gets the models.
   *
   * @return the models
   */
  public List<Model> getModels() {
    return models;
  }

  /**
   * Sets the models.
   *
   * @param models the new models
   */
  public void setModels(final List<Model> models) {
    this.models = models;
  }
}

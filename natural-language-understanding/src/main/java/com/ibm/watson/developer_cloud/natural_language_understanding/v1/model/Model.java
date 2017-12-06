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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Model.
 */
public class Model extends GenericModel {

  private String status;
  @SerializedName("model_id")
  private String modelId;
  private String language;
  private String description;

  /**
   * Gets the status.
   *
   * Shows as available if the model is ready for use
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the modelId.
   *
   * Unique model ID
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the language.
   *
   * ISO 639-1 code indicating the language of the model
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the description.
   *
   * Model description
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }

  /**
   * Sets the modelId.
   *
   * @param modelId the new modelId
   */
  public void setModelId(final String modelId) {
    this.modelId = modelId;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }
}

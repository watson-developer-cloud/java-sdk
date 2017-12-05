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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * UpdateCollectionRequest.
 */
public class UpdateCollectionRequest extends GenericModel {

  private String name;
  private String description;
  @SerializedName("configuration_id")
  private String configurationId;

  /**
   * Gets the name.
   *
   * The name of the collection.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * A description of the collection.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the configurationId.
   *
   * The ID of the configuration in which the collection is to be updated.
   *
   * @return the configurationId
   */
  public String getConfigurationId() {
    return configurationId;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the configurationId.
   *
   * @param configurationId the new configurationId
   */
  public void setConfigurationId(final String configurationId) {
    this.configurationId = configurationId;
  }
}

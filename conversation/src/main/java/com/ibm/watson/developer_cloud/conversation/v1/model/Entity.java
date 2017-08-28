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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Entity.
 */
public class Entity extends GenericModel {

  private String entity;
  private Date created;
  private Date updated;
  private String description;
  private Map<String, Object> metadata;
  @SerializedName("fuzzy_match")
  private Boolean fuzzyMatch;

  /**
   * Gets the entity.
   *
   * The name of the entity.
   *
   * @return the entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the entity.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the last update to the entity.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the description.
   *
   * The description of the entity.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata related to the entity.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
    return metadata;
  }

  /**
   * Gets the fuzzyMatch.
   *
   * Whether fuzzy matching is used for the entity.
   *
   * @return the fuzzyMatch
   */
  public Boolean isFuzzyMatch() {
    return fuzzyMatch;
  }

  /**
   * Sets the entity.
   *
   * @param entity the new entity
   */
  public void setEntity(final String entity) {
    this.entity = entity;
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
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map<String, Object> metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the fuzzyMatch.
   *
   * @param fuzzyMatch the new fuzzyMatch
   */
  public void setFuzzyMatch(final Boolean fuzzyMatch) {
    this.fuzzyMatch = fuzzyMatch;
  }
}

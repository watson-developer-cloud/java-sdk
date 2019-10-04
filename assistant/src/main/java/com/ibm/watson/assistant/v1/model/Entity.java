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
package com.ibm.watson.assistant.v1.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Entity.
 */
public class Entity extends GenericModel {

  private String entity;
  private String description;
  private Map<String, Object> metadata;
  @SerializedName("fuzzy_match")
  private Boolean fuzzyMatch;
  private Date created;
  private Date updated;
  private List<Value> values;

  /**
   * Gets the entity.
   *
   * The name of the entity. This string must conform to the following restrictions:
   * - It can contain only Unicode alphanumeric, underscore, and hyphen characters.
   * - If you specify an entity name beginning with the reserved prefix `sys-`, it must be the name of a system entity
   * that you want to enable. (Any entity content specified with the request is ignored.).
   *
   * @return the entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * Gets the description.
   *
   * The description of the entity. This string cannot contain carriage return, newline, or tab characters.
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
   * Whether to use fuzzy matching for the entity.
   *
   * @return the fuzzyMatch
   */
  public Boolean isFuzzyMatch() {
    return fuzzyMatch;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the values.
   *
   * An array of objects describing the entity values.
   *
   * @return the values
   */
  public List<Value> getValues() {
    return values;
  }
}

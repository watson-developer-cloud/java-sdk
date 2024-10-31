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

package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;
import java.util.List;
import java.util.Map;

/** Entity. */
public class Entity extends GenericModel {

  protected String entity;
  protected String description;
  protected Map<String, Object> metadata;

  @SerializedName("fuzzy_match")
  protected Boolean fuzzyMatch;

  protected Date created;
  protected Date updated;
  protected List<Value> values;

  protected Entity() {}

  /**
   * Gets the entity.
   *
   * <p>The name of the entity. This string must conform to the following restrictions: - It can
   * contain only Unicode alphanumeric, underscore, and hyphen characters. - If you specify an
   * entity name beginning with the reserved prefix `sys-`, it must be the name of a system entity
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
   * <p>The description of the entity. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the metadata.
   *
   * <p>Any metadata related to the entity.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
    return metadata;
  }

  /**
   * Gets the fuzzyMatch.
   *
   * <p>Whether to use fuzzy matching for the entity.
   *
   * @return the fuzzyMatch
   */
  public Boolean isFuzzyMatch() {
    return fuzzyMatch;
  }

  /**
   * Gets the created.
   *
   * <p>The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the values.
   *
   * <p>An array of objects describing the entity values.
   *
   * @return the values
   */
  public List<Value> getValues() {
    return values;
  }
}

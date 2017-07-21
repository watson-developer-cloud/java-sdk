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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A term from the request that was identified as an entity.
 */
public class RuntimeEntity extends HashMap<String, Object> {

  /**
   * Gets the entity.
   *
   * @return the entity
   */
  public String getEntity() {
    return (String) this.get("entity");
  }

  /**
   * Gets the location.
   *
   * @return the location
   */
  public List<Long> getLocation() {
    return (List<Long>) this.get("location");
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return (String) this.get("value");
  }

  /**
   * Gets the confidence.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return (Double) this.get("confidence");
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return (Map) this.get("metadata");
  }

  /**
   * Sets the entity.
   *
   * @param entity the new entity
   */
  public void setEntity(final String entity) {
    this.put("entity", entity);
  }

  /**
   * Sets the location.
   *
   * @param location the new location
   */
  public void setLocation(final List<Long> location) {
    this.put("location", location);
  }

  /**
   * Sets the value.
   *
   * @param value the new value
   */
  public void setValue(final String value) {
    this.put("value", value);
  }

  /**
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(final Double confidence) {
    this.put("confidence", confidence);
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map metadata) {
    this.put("metadata", metadata);
  }
}

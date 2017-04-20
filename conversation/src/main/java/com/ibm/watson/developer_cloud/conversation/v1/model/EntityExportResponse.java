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
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * EntityExportResponse.
 */
public class EntityExportResponse extends GenericModel {

  /** The name of the entity. */
  private String entity;
  /** The description of the entity. */
  private String description;
  /** The timestamp for creation of the entity. */
  private Date created;
  /** The timestamp for the last update to the entity. */
  private Date updated;
  /** An array of entity values. */
  private List<ValueExportResponse> values;

  /**
   * Gets the entity.
   *
   * @return the entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the values.
   *
   * @return the values
   */
  public List<ValueExportResponse> getValues() {
    return values;
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
   * Sets the created.
   *
   * @param created the new created
   */
  public void setCreated(final Date created) {
    this.created = created;
  }

  /**
   * Sets the updated.
   *
   * @param updated the new updated
   */
  public void setUpdated(final Date updated) {
    this.updated = updated;
  }

  /**
   * Sets the values.
   *
   * @param values the new values
   */
  public void setValues(final List<ValueExportResponse> values) {
    this.values = values;
  }
}

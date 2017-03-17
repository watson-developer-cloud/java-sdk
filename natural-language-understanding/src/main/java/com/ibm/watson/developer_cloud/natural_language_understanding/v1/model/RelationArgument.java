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
 * RelationArgument.
 */
public class RelationArgument extends GenericModel {

  private List<RelationEntity> entities;
  /** Text that corresponds to the argument. */
  private String text;

  /**
   * Adds the entities.
   *
   * @param entities the new entities
   */
  public void addentities(RelationEntity entities) {
    this.entities.add(entities);
  }

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public List<RelationEntity> getEntities() {
    return entities;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final List<RelationEntity> entities) {
    this.entities = entities;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.text = text;
  }

}

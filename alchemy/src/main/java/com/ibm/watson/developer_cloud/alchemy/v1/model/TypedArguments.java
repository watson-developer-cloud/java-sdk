/**
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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Argument of a typed relation. It includes the detected {@link TypedEntity}, text and part.
 *
 * @see AlchemyLanguage#getTypedRelations(java.util.Map)
 */
public class TypedArguments extends GenericModel {

  private String part;
  private String text;
  private List<TypedEntity> entities;

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public List<TypedEntity> getEntities() {
    return entities;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setTypedEntities(List<TypedEntity> entities) {
    this.entities = entities;
  }

  /**
   * Gets the part.
   *
   * @return the part
   */
  public String getPart() {
    return part;
  }

  /**
   * Sets the part.
   *
   * @param part the new part
   */
  public void setPart(String part) {
    this.part = part;
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
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
  }

}

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
package com.ibm.watson.natural_language_understanding.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * RelationArgument.
 */
public class RelationArgument extends GenericModel {

  private List<RelationEntity> entities;
  private List<Long> location;
  private String text;

  /**
   * Gets the entities.
   *
   * An array of extracted entities.
   *
   * @return the entities
   */
  public List<RelationEntity> getEntities() {
    return entities;
  }

  /**
   * Gets the location.
   *
   * Character offsets indicating the beginning and end of the mention in the analyzed text.
   *
   * @return the location
   */
  public List<Long> getLocation() {
    return location;
  }

  /**
   * Gets the text.
   *
   * Text that corresponds to the argument.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }
}

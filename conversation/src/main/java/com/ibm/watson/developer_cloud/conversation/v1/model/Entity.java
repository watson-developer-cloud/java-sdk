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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An class used to describe the entity payload object.
 */
public class Entity extends GenericModel {

  /**
   * Instantiates a new entity.
   *
   * @param entity the entity
   * @param value the value
   * @param location the location
   */
  public Entity(String entity, String value, Integer[] location) {
    super();
    this.entity = entity;
    this.value = value;
    this.location = location;
  }

  private String entity;
  private Integer[] location;
  private String value;

  /**
   * Returns the name of the entity. e.g. "I'd like to get a pepperoni pizza", entity in this case would likely be
   * "topping" (depending on how the system has been trained). The {@link #getValue()} of the input would be
   * "pepperoni".
   *
   * @return the name of an entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * Returns the location of the entity within the input string, the array will have two values: a start index and end
   * index.
   *
   * @return an array of locations (start and end)
   */
  public Integer[] getLocation() {
    return (location == null) ? null : location.clone();
  }

  /**
   * Returns the detected value of the entity.
   *
   * @return a string representing the entity value
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the entity detected by the system for the given input.
   *
   * @param entity the new entity
   */
  public void setEntity(String entity) {
    this.entity = entity;
  }

  /**
   * Sets the location of the entity detected by the system (i.e. starting index and end index).
   *
   * @param location an array of <code>Integers</code> representing a start and end index
   */
  public void setLocation(Integer... location) {
    this.location = (location == null) ? null : location.clone();
  }

  /**
   * Sets the value of the entity as detected by the system.
   *
   * @param value the new value
   */
  public void setValue(String value) {
    this.value = value;
  }
}


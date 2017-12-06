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

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * QueryRelationsRelationship.
 */
public class QueryRelationsRelationship extends GenericModel {

  private String type;
  private Long frequency;
  private List<QueryRelationsArgument> arguments;

  /**
   * Gets the type.
   *
   * The identified relationship type
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the frequency.
   *
   * The number of times the relationship is mentioned.
   *
   * @return the frequency
   */
  public Long getFrequency() {
    return frequency;
  }

  /**
   * Gets the arguments.
   *
   * Information about the relationship
   *
   * @return the arguments
   */
  public List<QueryRelationsArgument> getArguments() {
    return arguments;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }

  /**
   * Sets the frequency.
   *
   * @param frequency the new frequency
   */
  public void setFrequency(final long frequency) {
    this.frequency = frequency;
  }

  /**
   * Sets the arguments.
   *
   * @param arguments the new arguments
   */
  public void setArguments(final List<QueryRelationsArgument> arguments) {
    this.arguments = arguments;
  }
}

/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object describing the role played by a system entity that is specifies the beginning or end of a range recognized
 * in the user input.
 *
 * This property is part of the new system entities, which are a beta feature.
 */
public class RuntimeEntityRole extends GenericModel {

  /**
   * The relationship of the entity to the range.
   */
  public interface Type {
    /** date_from. */
    String DATE_FROM = "date_from";
    /** date_to. */
    String DATE_TO = "date_to";
    /** number_from. */
    String NUMBER_FROM = "number_from";
    /** number_to. */
    String NUMBER_TO = "number_to";
    /** time_from. */
    String TIME_FROM = "time_from";
    /** time_to. */
    String TIME_TO = "time_to";
  }

  private String type;

  /**
   * Gets the type.
   *
   * The relationship of the entity to the range.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }
}

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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * List of document attributes.
 */
public class Attribute extends GenericModel {

  /**
   * The type of attribute.
   */
  public interface Type {
    /** Currency. */
    String CURRENCY = "Currency";
    /** DateTime. */
    String DATETIME = "DateTime";
    /** Duration. */
    String DURATION = "Duration";
    /** Location. */
    String LOCATION = "Location";
    /** Organization. */
    String ORGANIZATION = "Organization";
    /** Percentage. */
    String PERCENTAGE = "Percentage";
    /** Person. */
    String PERSON = "Person";
  }

  private String type;
  private String text;
  private Location location;

  /**
   * Gets the type.
   *
   * The type of attribute.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the text.
   *
   * The text associated with the attribute.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the location.
   *
   * The numeric location of the identified element in the document, represented with two integers labeled `begin` and
   * `end`.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }
}

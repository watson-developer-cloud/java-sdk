/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * List of document attributes.
 */
public class DocumentAttribute extends GenericModel {

  protected String type;
  protected String text;
  protected TableElementLocation location;

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
  public TableElementLocation getLocation() {
    return location;
  }
}

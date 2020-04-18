/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
import java.util.List;

/** A component part of the document. */
public class Element extends GenericModel {

  protected Location location;
  protected String text;
  protected List<TypeLabel> types;
  protected List<Category> categories;
  protected List<Attribute> attributes;

  /**
   * Gets the location.
   *
   * <p>The numeric location of the identified element in the document, represented with two
   * integers labeled `begin` and `end`.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Gets the text.
   *
   * <p>The text of the element.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the types.
   *
   * <p>Description of the action specified by the element and whom it affects.
   *
   * @return the types
   */
  public List<TypeLabel> getTypes() {
    return types;
  }

  /**
   * Gets the categories.
   *
   * <p>List of functional categories into which the element falls; in other words, the subject
   * matter of the element.
   *
   * @return the categories
   */
  public List<Category> getCategories() {
    return categories;
  }

  /**
   * Gets the attributes.
   *
   * <p>List of document attributes.
   *
   * @return the attributes
   */
  public List<Attribute> getAttributes() {
    return attributes;
  }
}

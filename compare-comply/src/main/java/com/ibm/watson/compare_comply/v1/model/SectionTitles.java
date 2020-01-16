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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An array containing one object per section or subsection detected in the input document. Sections and subsections are
 * not nested; instead, they are flattened out and can be placed back in order by using the `begin` and `end` values of
 * the element and the `level` value of the section.
 */
public class SectionTitles extends GenericModel {

  protected String text;
  protected Location location;
  protected Long level;
  @SerializedName("element_locations")
  protected List<ElementLocations> elementLocations;

  /**
   * Gets the text.
   *
   * The text of the section title, if identified.
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

  /**
   * Gets the level.
   *
   * An integer indicating the level at which the section is located in the input document. For example, `1` represents
   * a top-level section, `2` represents a subsection within the level `1` section, and so forth.
   *
   * @return the level
   */
  public Long getLevel() {
    return level;
  }

  /**
   * Gets the elementLocations.
   *
   * An array of `location` objects that lists the locations of detected section titles.
   *
   * @return the elementLocations
   */
  public List<ElementLocations> getElementLocations() {
    return elementLocations;
  }
}

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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updated labeling from the input document, accounting for the submitted feedback.
 */
public class UpdatedLabelsOut extends GenericModel {

  /**
   * The type of modification the feedback entry in the `updated_labels` array. Possible values are `added`,
   * `not_changed`, and `removed`.
   */
  public interface Modification {
    /** added. */
    String ADDED = "added";
    /** not_changed. */
    String NOT_CHANGED = "not_changed";
    /** removed. */
    String REMOVED = "removed";
  }

  protected List<TypeLabel> types;
  protected List<Category> categories;
  protected String modification;

  /**
   * Gets the types.
   *
   * Description of the action specified by the element and whom it affects.
   *
   * @return the types
   */
  public List<TypeLabel> getTypes() {
    return types;
  }

  /**
   * Gets the categories.
   *
   * List of functional categories into which the element falls; in other words, the subject matter of the element.
   *
   * @return the categories
   */
  public List<Category> getCategories() {
    return categories;
  }

  /**
   * Gets the modification.
   *
   * The type of modification the feedback entry in the `updated_labels` array. Possible values are `added`,
   * `not_changed`, and `removed`.
   *
   * @return the modification
   */
  public String getModification() {
    return modification;
  }
}

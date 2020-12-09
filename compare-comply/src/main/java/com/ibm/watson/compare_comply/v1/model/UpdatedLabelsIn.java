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
import java.util.ArrayList;
import java.util.List;

/** The updated labeling from the input document, accounting for the submitted feedback. */
public class UpdatedLabelsIn extends GenericModel {

  protected List<TypeLabel> types;
  protected List<Category> categories;

  /** Builder. */
  public static class Builder {
    private List<TypeLabel> types;
    private List<Category> categories;

    private Builder(UpdatedLabelsIn updatedLabelsIn) {
      this.types = updatedLabelsIn.types;
      this.categories = updatedLabelsIn.categories;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param types the types
     * @param categories the categories
     */
    public Builder(List<TypeLabel> types, List<Category> categories) {
      this.types = types;
      this.categories = categories;
    }

    /**
     * Builds a UpdatedLabelsIn.
     *
     * @return the new UpdatedLabelsIn instance
     */
    public UpdatedLabelsIn build() {
      return new UpdatedLabelsIn(this);
    }

    /**
     * Adds an types to types.
     *
     * @param types the new types
     * @return the UpdatedLabelsIn builder
     */
    public Builder addTypes(TypeLabel types) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(types, "types cannot be null");
      if (this.types == null) {
        this.types = new ArrayList<TypeLabel>();
      }
      this.types.add(types);
      return this;
    }

    /**
     * Adds an categories to categories.
     *
     * @param categories the new categories
     * @return the UpdatedLabelsIn builder
     */
    public Builder addCategories(Category categories) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(categories, "categories cannot be null");
      if (this.categories == null) {
        this.categories = new ArrayList<Category>();
      }
      this.categories.add(categories);
      return this;
    }

    /**
     * Set the types. Existing types will be replaced.
     *
     * @param types the types
     * @return the UpdatedLabelsIn builder
     */
    public Builder types(List<TypeLabel> types) {
      this.types = types;
      return this;
    }

    /**
     * Set the categories. Existing categories will be replaced.
     *
     * @param categories the categories
     * @return the UpdatedLabelsIn builder
     */
    public Builder categories(List<Category> categories) {
      this.categories = categories;
      return this;
    }
  }

  protected UpdatedLabelsIn(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.types, "types cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.categories, "categories cannot be null");
    types = builder.types;
    categories = builder.categories;
  }

  /**
   * New builder.
   *
   * @return a UpdatedLabelsIn builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the types.
   *
   * <p>Description of the action specified by the element and whom it affects.
   *
   * @return the types
   */
  public List<TypeLabel> types() {
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
  public List<Category> categories() {
    return categories;
  }
}

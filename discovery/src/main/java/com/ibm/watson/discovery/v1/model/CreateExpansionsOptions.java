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
package com.ibm.watson.discovery.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createExpansions options.
 */
public class CreateExpansionsOptions extends GenericModel {

  protected String environmentId;
  protected String collectionId;
  protected List<Expansion> expansions;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private List<Expansion> expansions;

    private Builder(CreateExpansionsOptions createExpansionsOptions) {
      this.environmentId = createExpansionsOptions.environmentId;
      this.collectionId = createExpansionsOptions.collectionId;
      this.expansions = createExpansionsOptions.expansions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     * @param expansions the expansions
     */
    public Builder(String environmentId, String collectionId, List<Expansion> expansions) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
      this.expansions = expansions;
    }

    /**
     * Builds a CreateExpansionsOptions.
     *
     * @return the createExpansionsOptions
     */
    public CreateExpansionsOptions build() {
      return new CreateExpansionsOptions(this);
    }

    /**
     * Adds an expansions to expansions.
     *
     * @param expansions the new expansions
     * @return the CreateExpansionsOptions builder
     */
    public Builder addExpansions(Expansion expansions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(expansions,
          "expansions cannot be null");
      if (this.expansions == null) {
        this.expansions = new ArrayList<Expansion>();
      }
      this.expansions.add(expansions);
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateExpansionsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the CreateExpansionsOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the expansions.
     * Existing expansions will be replaced.
     *
     * @param expansions the expansions
     * @return the CreateExpansionsOptions builder
     */
    public Builder expansions(List<Expansion> expansions) {
      this.expansions = expansions;
      return this;
    }

    /**
     * Set the expansions.
     *
     * @param expansions the expansions
     * @return the CreateExpansionsOptions builder
     */
    public Builder expansions(Expansions expansions) {
      this.expansions = expansions.expansions();
      return this;
    }
  }

  protected CreateExpansionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.environmentId,
        "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.collectionId,
        "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.expansions,
        "expansions cannot be null");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    expansions = builder.expansions;
  }

  /**
   * New builder.
   *
   * @return a CreateExpansionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the expansions.
   *
   * An array of query expansion definitions.
   *
   * Each object in the **expansions** array represents a term or set of terms that will be expanded into other terms.
   * Each expansion object can be configured as bidirectional or unidirectional. Bidirectional means that all terms are
   * expanded to all other terms in the object. Unidirectional means that a set list of terms can be expanded into a
   * second list of terms.
   *
   * To create a bi-directional expansion specify an **expanded_terms** array. When found in a query, all items in the
   * **expanded_terms** array are then expanded to the other items in the same array.
   *
   * To create a uni-directional expansion, specify both an array of **input_terms** and an array of
   * **expanded_terms**. When items in the **input_terms** array are present in a query, they are expanded using the
   * items listed in the **expanded_terms** array.
   *
   * @return the expansions
   */
  public List<Expansion> expansions() {
    return expansions;
  }
}

/*
 * (C) Copyright IBM Corp. 2022, 2023.
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
import java.util.ArrayList;
import java.util.List;

/** The createExpansions options. */
public class CreateExpansionsOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected List<Expansion> expansions;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private List<Expansion> expansions;

    /**
     * Instantiates a new Builder from an existing CreateExpansionsOptions instance.
     *
     * @param createExpansionsOptions the instance to initialize the Builder with
     */
    private Builder(CreateExpansionsOptions createExpansionsOptions) {
      this.projectId = createExpansionsOptions.projectId;
      this.collectionId = createExpansionsOptions.collectionId;
      this.expansions = createExpansionsOptions.expansions;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     * @param expansions the expansions
     */
    public Builder(String projectId, String collectionId, List<Expansion> expansions) {
      this.projectId = projectId;
      this.collectionId = collectionId;
      this.expansions = expansions;
    }

    /**
     * Builds a CreateExpansionsOptions.
     *
     * @return the new CreateExpansionsOptions instance
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
      com.ibm.cloud.sdk.core.util.Validator.notNull(expansions, "expansions cannot be null");
      if (this.expansions == null) {
        this.expansions = new ArrayList<Expansion>();
      }
      this.expansions.add(expansions);
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the CreateExpansionsOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
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
     * Set the expansions. Existing expansions will be replaced.
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

  protected CreateExpansionsOptions() {}

  protected CreateExpansionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.expansions, "expansions cannot be null");
    projectId = builder.projectId;
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
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the *Integrate and Deploy* page in
   * Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the expansions.
   *
   * <p>An array of query expansion definitions.
   *
   * <p>Each object in the **expansions** array represents a term or set of terms that will be
   * expanded into other terms. Each expansion object can be configured as `bidirectional` or
   * `unidirectional`.
   *
   * <p>* **Bidirectional**: Each entry in the `expanded_terms` list expands to include all expanded
   * terms. For example, a query for `ibm` expands to `ibm OR international business machines OR big
   * blue`.
   *
   * <p>* **Unidirectional**: The terms in `input_terms` in the query are replaced by the terms in
   * `expanded_terms`. For example, a query for the often misused term `on premise` is converted to
   * `on premises OR on-premises` and does not contain the original term. If you want an input term
   * to be included in the query, then repeat the input term in the expanded terms list.
   *
   * @return the expansions
   */
  public List<Expansion> expansions() {
    return expansions;
  }
}

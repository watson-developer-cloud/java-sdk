/*
 * (C) Copyright IBM Corp. 2019, 2023.
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

/** The listFields options. */
public class ListFieldsOptions extends GenericModel {

  protected String projectId;
  protected List<String> collectionIds;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private List<String> collectionIds;

    /**
     * Instantiates a new Builder from an existing ListFieldsOptions instance.
     *
     * @param listFieldsOptions the instance to initialize the Builder with
     */
    private Builder(ListFieldsOptions listFieldsOptions) {
      this.projectId = listFieldsOptions.projectId;
      this.collectionIds = listFieldsOptions.collectionIds;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     */
    public Builder(String projectId) {
      this.projectId = projectId;
    }

    /**
     * Builds a ListFieldsOptions.
     *
     * @return the new ListFieldsOptions instance
     */
    public ListFieldsOptions build() {
      return new ListFieldsOptions(this);
    }

    /**
     * Adds an collectionIds to collectionIds.
     *
     * @param collectionIds the new collectionIds
     * @return the ListFieldsOptions builder
     */
    public Builder addCollectionIds(String collectionIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(collectionIds, "collectionIds cannot be null");
      if (this.collectionIds == null) {
        this.collectionIds = new ArrayList<String>();
      }
      this.collectionIds.add(collectionIds);
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the ListFieldsOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionIds. Existing collectionIds will be replaced.
     *
     * @param collectionIds the collectionIds
     * @return the ListFieldsOptions builder
     */
    public Builder collectionIds(List<String> collectionIds) {
      this.collectionIds = collectionIds;
      return this;
    }
  }

  protected ListFieldsOptions() {}

  protected ListFieldsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    projectId = builder.projectId;
    collectionIds = builder.collectionIds;
  }

  /**
   * New builder.
   *
   * @return a ListFieldsOptions builder
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
   * Gets the collectionIds.
   *
   * <p>Comma separated list of the collection IDs. If this parameter is not specified, all
   * collections in the project are used.
   *
   * @return the collectionIds
   */
  public List<String> collectionIds() {
    return collectionIds;
  }
}

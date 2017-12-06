/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The listFields options.
 */
public class ListFieldsOptions extends GenericModel {

  private String environmentId;
  private List<String> collectionIds;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private List<String> collectionIds;

    private Builder(ListFieldsOptions listFieldsOptions) {
      environmentId = listFieldsOptions.environmentId;
      collectionIds = listFieldsOptions.collectionIds;
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
     * @param collectionIds the collectionIds
     */
    public Builder(String environmentId, List<String> collectionIds) {
      this.environmentId = environmentId;
      this.collectionIds = collectionIds;
    }

    /**
     * Builds a ListFieldsOptions.
     *
     * @return the listFieldsOptions
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
      Validator.notNull(collectionIds, "collectionIds cannot be null");
      if (this.collectionIds == null) {
        this.collectionIds = new ArrayList<String>();
      }
      this.collectionIds.add(collectionIds);
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the ListFieldsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionIds.
     * Existing collectionIds will be replaced.
     *
     * @param collectionIds the collectionIds
     * @return the ListFieldsOptions builder
     */
    public Builder collectionIds(List<String> collectionIds) {
      this.collectionIds = collectionIds;
      return this;
    }
  }

  private ListFieldsOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notNull(builder.collectionIds, "collectionIds cannot be null");
    environmentId = builder.environmentId;
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
   * Gets the collectionIds.
   *
   * A comma-separated list of collection IDs to be queried against.
   *
   * @return the collectionIds
   */
  public List<String> collectionIds() {
    return collectionIds;
  }
}

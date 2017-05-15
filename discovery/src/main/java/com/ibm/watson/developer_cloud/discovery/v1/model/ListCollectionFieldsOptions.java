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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * the listCollectionFields options.
 */
public class ListCollectionFieldsOptions extends GenericModel {

  /** the ID of your environment. */
  @SerializedName("environment_id")
  private String environmentId;
  /** the ID of your collection. */
  @SerializedName("collection_id")
  private String collectionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;

    private Builder(ListCollectionFieldsOptions listCollectionFieldsOptions) {
      environmentId = listCollectionFieldsOptions.environmentId;
      collectionId = listCollectionFieldsOptions.collectionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     */
    public Builder(String environmentId, String collectionId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a ListCollectionFieldsOptions.
     *
     * @return the listCollectionFieldsOptions
     */
    public ListCollectionFieldsOptions build() {
      return new ListCollectionFieldsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the ListCollectionFieldsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the ListCollectionFieldsOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }
  }

  private ListCollectionFieldsOptions(Builder builder) {
    Validator.notNull(builder.environmentId, "environmentId cannot be null");
    Validator.notNull(builder.collectionId, "collectionId cannot be null");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
  }

  /**
   * New builder.
   *
   * @return a ListCollectionFieldsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }
}

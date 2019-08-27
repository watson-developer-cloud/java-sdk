/*
 * (C) Copyright IBM Corp. 2019.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * QueryRelationsFilter.
 */
public class QueryRelationsFilter extends GenericModel {

  @SerializedName("relation_types")
  private QueryFilterType relationTypes;
  @SerializedName("entity_types")
  private QueryFilterType entityTypes;
  @SerializedName("document_ids")
  private List<String> documentIds;

  /**
   * Builder.
   */
  public static class Builder {
    private QueryFilterType relationTypes;
    private QueryFilterType entityTypes;
    private List<String> documentIds;

    private Builder(QueryRelationsFilter queryRelationsFilter) {
      this.relationTypes = queryRelationsFilter.relationTypes;
      this.entityTypes = queryRelationsFilter.entityTypes;
      this.documentIds = queryRelationsFilter.documentIds;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a QueryRelationsFilter.
     *
     * @return the queryRelationsFilter
     */
    public QueryRelationsFilter build() {
      return new QueryRelationsFilter(this);
    }

    /**
     * Adds an documentIds to documentIds.
     *
     * @param documentIds the new documentIds
     * @return the QueryRelationsFilter builder
     */
    public Builder addDocumentIds(String documentIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(documentIds,
          "documentIds cannot be null");
      if (this.documentIds == null) {
        this.documentIds = new ArrayList<String>();
      }
      this.documentIds.add(documentIds);
      return this;
    }

    /**
     * Set the relationTypes.
     *
     * @param relationTypes the relationTypes
     * @return the QueryRelationsFilter builder
     */
    public Builder relationTypes(QueryFilterType relationTypes) {
      this.relationTypes = relationTypes;
      return this;
    }

    /**
     * Set the entityTypes.
     *
     * @param entityTypes the entityTypes
     * @return the QueryRelationsFilter builder
     */
    public Builder entityTypes(QueryFilterType entityTypes) {
      this.entityTypes = entityTypes;
      return this;
    }

    /**
     * Set the documentIds.
     * Existing documentIds will be replaced.
     *
     * @param documentIds the documentIds
     * @return the QueryRelationsFilter builder
     */
    public Builder documentIds(List<String> documentIds) {
      this.documentIds = documentIds;
      return this;
    }
  }

  private QueryRelationsFilter(Builder builder) {
    relationTypes = builder.relationTypes;
    entityTypes = builder.entityTypes;
    documentIds = builder.documentIds;
  }

  /**
   * New builder.
   *
   * @return a QueryRelationsFilter builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the relationTypes.
   *
   * @return the relationTypes
   */
  public QueryFilterType relationTypes() {
    return relationTypes;
  }

  /**
   * Gets the entityTypes.
   *
   * @return the entityTypes
   */
  public QueryFilterType entityTypes() {
    return entityTypes;
  }

  /**
   * Gets the documentIds.
   *
   * A comma-separated list of document IDs to include in the query.
   *
   * @return the documentIds
   */
  public List<String> documentIds() {
    return documentIds;
  }
}

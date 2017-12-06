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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

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
   * Gets the relationTypes.
   *
   * A list of relation types to include or exclude from the query.
   *
   * @return the relationTypes
   */
  public QueryFilterType getRelationTypes() {
    return relationTypes;
  }

  /**
   * Gets the entityTypes.
   *
   * A list of entity types to include or exclude from the query.
   *
   * @return the entityTypes
   */
  public QueryFilterType getEntityTypes() {
    return entityTypes;
  }

  /**
   * Gets the documentIds.
   *
   * A comma-separated list of document IDs to include in the query
   *
   * @return the documentIds
   */
  public List<String> getDocumentIds() {
    return documentIds;
  }

  /**
   * Sets the relationTypes.
   *
   * @param relationTypes the new relationTypes
   */
  public void setRelationTypes(final QueryFilterType relationTypes) {
    this.relationTypes = relationTypes;
  }

  /**
   * Sets the entityTypes.
   *
   * @param entityTypes the new entityTypes
   */
  public void setEntityTypes(final QueryFilterType entityTypes) {
    this.entityTypes = entityTypes;
  }

  /**
   * Sets the documentIds.
   *
   * @param documentIds the new documentIds
   */
  public void setDocumentIds(final List<String> documentIds) {
    this.documentIds = documentIds;
  }
}

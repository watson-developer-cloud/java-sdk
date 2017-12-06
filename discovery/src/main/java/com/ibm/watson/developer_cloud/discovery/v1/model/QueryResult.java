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

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * QueryResult.
 */
public class QueryResult extends DynamicModel {
  private Type idType = new TypeToken<String>() {
  }.getType();
  private Type scoreType = new TypeToken<Double>() {
  }.getType();
  private Type metadataType = new TypeToken<Map>() {
  }.getType();
  private Type collectionIdType = new TypeToken<String>() {
  }.getType();
  private Type resultMetadataType = new TypeToken<QueryResultResultMetadata>() {
  }.getType();

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("id"), idType);
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("score"), scoreType);
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("metadata"), metadataType);
  }

  /**
   * Gets the collectionId.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("collection_id"), collectionIdType);
  }

  /**
   * Gets the resultMetadata.
   *
   * @return the resultMetadata
   */
  public QueryResultResultMetadata getResultMetadata() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("result_metadata"), resultMetadataType);
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final String id) {
    this.put("id", id);
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(final Double score) {
    this.put("score", score);
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map metadata) {
    this.put("metadata", metadata);
  }

  /**
   * Sets the collectionId.
   *
   * @param collectionId the new collectionId
   */
  public void setCollectionId(final String collectionId) {
    this.put("collection_id", collectionId);
  }

  /**
   * Sets the resultMetadata.
   *
   * @param resultMetadata the new resultMetadata
   */
  public void setResultMetadata(final QueryResultResultMetadata resultMetadata) {
    this.put("result_metadata", resultMetadata);
  }
}

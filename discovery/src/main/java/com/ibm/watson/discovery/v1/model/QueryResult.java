/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import com.ibm.cloud.sdk.core.util.GsonSerializationHelper;

import java.util.Map;

/**
 * QueryResult.
 */
public class QueryResult extends DynamicModel {
  private java.lang.reflect.Type idType = new TypeToken<String>() {
  }.getType();
  private java.lang.reflect.Type metadataType = new TypeToken<Map<String, Object>>() {
  }.getType();
  private java.lang.reflect.Type collectionIdType = new TypeToken<String>() {
  }.getType();
  private java.lang.reflect.Type resultMetadataType = new TypeToken<QueryResultMetadata>() {
  }.getType();
  private java.lang.reflect.Type titleType = new TypeToken<String>() {
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
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
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
  public QueryResultMetadata getResultMetadata() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("result_metadata"), resultMetadataType);
  }

  /**
   * Gets the title.
   *
   * @return the title
   */
  public String getTitle() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("title"), titleType);
  }
}

/*
 * (C) Copyright IBM Corp. 2017, 2020.
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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Query result object.
 */
public class QueryResult extends DynamicModel<Object> {

  @SerializedName("id")
  protected String id;
  @SerializedName("metadata")
  protected Map<String, Object> metadata;
  @SerializedName("collection_id")
  protected String collectionId;
  @SerializedName("result_metadata")
  protected QueryResultMetadata resultMetadata;

  public QueryResult() {
    super(new TypeToken<Object>() {
    });
  }

  /**
   * Gets the id.
   *
   * The unique identifier of the document.
   *
   * @return the id
   */
  public String getId() {
    return this.id;
  }

  /**
   * Gets the metadata.
   *
   * Metadata of the document.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
    return this.metadata;
  }

  /**
   * Gets the collectionId.
   *
   * The collection ID of the collection containing the document for this result.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return this.collectionId;
  }

  /**
   * Gets the resultMetadata.
   *
   * Metadata of a query result.
   *
   * @return the resultMetadata
   */
  public QueryResultMetadata getResultMetadata() {
    return this.resultMetadata;
  }
}

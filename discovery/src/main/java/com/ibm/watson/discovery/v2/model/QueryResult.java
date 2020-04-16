/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.List;
import java.util.Map;

/** Result document for the specified query. */
public class QueryResult extends DynamicModel<Object> {

  @SerializedName("document_id")
  protected String documentId;

  @SerializedName("metadata")
  protected Map<String, Object> metadata;

  @SerializedName("result_metadata")
  protected QueryResultMetadata resultMetadata;

  @SerializedName("document_passages")
  protected List<QueryResultPassage> documentPassages;

  public QueryResult() {
    super(new TypeToken<Object>() {});
  }

  /**
   * Gets the documentId.
   *
   * <p>The unique identifier of the document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return this.documentId;
  }

  /**
   * Gets the metadata.
   *
   * <p>Metadata of the document.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
    return this.metadata;
  }

  /**
   * Gets the resultMetadata.
   *
   * <p>Metadata of a query result.
   *
   * @return the resultMetadata
   */
  public QueryResultMetadata getResultMetadata() {
    return this.resultMetadata;
  }

  /**
   * Gets the documentPassages.
   *
   * <p>Passages returned by Discovery.
   *
   * @return the documentPassages
   */
  public List<QueryResultPassage> getDocumentPassages() {
    return this.documentPassages;
  }
}

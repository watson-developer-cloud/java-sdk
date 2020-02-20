/*
 * (C) Copyright IBM Corp. 2020.
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
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A tables whose content or context match a search query.
 */
public class QueryTableResult extends GenericModel {

  @SerializedName("table_id")
  protected String tableId;
  @SerializedName("source_document_id")
  protected String sourceDocumentId;
  @SerializedName("collection_id")
  protected String collectionId;
  @SerializedName("table_html")
  protected String tableHtml;
  @SerializedName("table_html_offset")
  protected Long tableHtmlOffset;
  protected TableResultTable table;

  /**
   * Gets the tableId.
   *
   * The identifier for the retrieved table.
   *
   * @return the tableId
   */
  public String getTableId() {
    return tableId;
  }

  /**
   * Gets the sourceDocumentId.
   *
   * The identifier of the document the table was retrieved from.
   *
   * @return the sourceDocumentId
   */
  public String getSourceDocumentId() {
    return sourceDocumentId;
  }

  /**
   * Gets the collectionId.
   *
   * The identifier of the collection the table was retrieved from.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the tableHtml.
   *
   * HTML snippet of the table info.
   *
   * @return the tableHtml
   */
  public String getTableHtml() {
    return tableHtml;
  }

  /**
   * Gets the tableHtmlOffset.
   *
   * The offset of the table html snippet in the original document html.
   *
   * @return the tableHtmlOffset
   */
  public Long getTableHtmlOffset() {
    return tableHtmlOffset;
  }

  /**
   * Gets the table.
   *
   * Full table object retrieved from Table Understanding Enrichment.
   *
   * @return the table
   */
  public TableResultTable getTable() {
    return table;
  }
}

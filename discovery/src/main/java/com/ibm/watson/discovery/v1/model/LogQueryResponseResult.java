/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/**
 * Individual result object for a **logs** query. Each object represents either a query to a
 * Discovery collection or an event that is associated with a query.
 */
public class LogQueryResponseResult extends GenericModel {

  /**
   * The type of log entry returned.
   *
   * <p>**query** indicates that the log represents the results of a call to the single collection
   * **query** method.
   *
   * <p>**event** indicates that the log represents a call to the **events** API.
   */
  public interface DocumentType {
    /** query. */
    String QUERY = "query";
    /** event. */
    String EVENT = "event";
  }

  /**
   * The type of event that this object respresents. Possible values are
   *
   * <p>- `query` the log of a query to a collection
   *
   * <p>- `click` the result of a call to the **events** endpoint.
   */
  public interface EventType {
    /** click. */
    String CLICK = "click";
    /** query. */
    String QUERY = "query";
  }

  /**
   * The type of result that this **event** is associated with. Only returned with logs of type
   * `event`.
   */
  public interface ResultType {
    /** document. */
    String DOCUMENT = "document";
  }

  @SerializedName("environment_id")
  protected String environmentId;

  @SerializedName("customer_id")
  protected String customerId;

  @SerializedName("document_type")
  protected String documentType;

  @SerializedName("natural_language_query")
  protected String naturalLanguageQuery;

  @SerializedName("document_results")
  protected LogQueryResponseResultDocuments documentResults;

  @SerializedName("created_timestamp")
  protected Date createdTimestamp;

  @SerializedName("client_timestamp")
  protected Date clientTimestamp;

  @SerializedName("query_id")
  protected String queryId;

  @SerializedName("session_token")
  protected String sessionToken;

  @SerializedName("collection_id")
  protected String collectionId;

  @SerializedName("display_rank")
  protected Long displayRank;

  @SerializedName("document_id")
  protected String documentId;

  @SerializedName("event_type")
  protected String eventType;

  @SerializedName("result_type")
  protected String resultType;

  protected LogQueryResponseResult() {}

  /**
   * Gets the environmentId.
   *
   * <p>The environment ID that is associated with this log entry.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the customerId.
   *
   * <p>The **customer_id** label that was specified in the header of the query or event API call
   * that corresponds to this log entry.
   *
   * @return the customerId
   */
  public String getCustomerId() {
    return customerId;
  }

  /**
   * Gets the documentType.
   *
   * <p>The type of log entry returned.
   *
   * <p>**query** indicates that the log represents the results of a call to the single collection
   * **query** method.
   *
   * <p>**event** indicates that the log represents a call to the **events** API.
   *
   * @return the documentType
   */
  public String getDocumentType() {
    return documentType;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * <p>The value of the **natural_language_query** query parameter that was used to create these
   * results. Only returned with logs of type **query**.
   *
   * <p>**Note:** Other query parameters (such as **filter** or **deduplicate**) might have been
   * used with this query, but are not recorded.
   *
   * @return the naturalLanguageQuery
   */
  public String getNaturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the documentResults.
   *
   * <p>Object containing result information that was returned by the query used to create this log
   * entry. Only returned with logs of type `query`.
   *
   * @return the documentResults
   */
  public LogQueryResponseResultDocuments getDocumentResults() {
    return documentResults;
  }

  /**
   * Gets the createdTimestamp.
   *
   * <p>Date that the log result was created. Returned in `YYYY-MM-DDThh:mm:ssZ` format.
   *
   * @return the createdTimestamp
   */
  public Date getCreatedTimestamp() {
    return createdTimestamp;
  }

  /**
   * Gets the clientTimestamp.
   *
   * <p>Date specified by the user when recording an event. Returned in `YYYY-MM-DDThh:mm:ssZ`
   * format. Only returned with logs of type **event**.
   *
   * @return the clientTimestamp
   */
  public Date getClientTimestamp() {
    return clientTimestamp;
  }

  /**
   * Gets the queryId.
   *
   * <p>Identifier that corresponds to the **natural_language_query** string used in the original or
   * associated query. All **event** and **query** log entries that have the same original
   * **natural_language_query** string also have them same **query_id**. This field can be used to
   * recall all **event** and **query** log results that have the same original query (**event**
   * logs do not contain the original **natural_language_query** field).
   *
   * @return the queryId
   */
  public String getQueryId() {
    return queryId;
  }

  /**
   * Gets the sessionToken.
   *
   * <p>Unique identifier (within a 24-hour period) that identifies a single `query` log and any
   * `event` logs that were created for it.
   *
   * <p>**Note:** If the exact same query is run at the exact same time on different days, the
   * **session_token** for those queries might be identical. However, the **created_timestamp**
   * differs.
   *
   * <p>**Note:** Session tokens are case sensitive. To avoid matching on session tokens that are
   * identical except for case, use the exact match operator (`::`) when you query for a specific
   * session token.
   *
   * @return the sessionToken
   */
  public String getSessionToken() {
    return sessionToken;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The collection ID of the document associated with this event. Only returned with logs of
   * type `event`.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the displayRank.
   *
   * <p>The original display rank of the document associated with this event. Only returned with
   * logs of type `event`.
   *
   * @return the displayRank
   */
  public Long getDisplayRank() {
    return displayRank;
  }

  /**
   * Gets the documentId.
   *
   * <p>The document ID of the document associated with this event. Only returned with logs of type
   * `event`.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the eventType.
   *
   * <p>The type of event that this object respresents. Possible values are
   *
   * <p>- `query` the log of a query to a collection
   *
   * <p>- `click` the result of a call to the **events** endpoint.
   *
   * @return the eventType
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * Gets the resultType.
   *
   * <p>The type of result that this **event** is associated with. Only returned with logs of type
   * `event`.
   *
   * @return the resultType
   */
  public String getResultType() {
    return resultType;
  }
}

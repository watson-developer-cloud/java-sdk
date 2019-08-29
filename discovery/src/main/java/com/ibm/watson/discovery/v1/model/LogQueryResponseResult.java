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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Individual result object for a **logs** query. Each object represents either a query to a Discovery collection or an
 * event that is associated with a query.
 */
public class LogQueryResponseResult extends GenericModel {

  /**
   * The type of log entry returned.
   *
   * **query** indicates that the log represents the results of a call to the single collection **query** method.
   *
   * **event** indicates that the log represents a call to the **events** API.
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
   * - `query` the log of a query to a collection
   *
   * - `click` the result of a call to the **events** endpoint.
   */
  public interface EventType {
    /** click. */
    String CLICK = "click";
    /** query. */
    String QUERY = "query";
  }

  /**
   * The type of result that this **event** is associated with. Only returned with logs of type `event`.
   */
  public interface ResultType {
    /** document. */
    String DOCUMENT = "document";
  }

  @SerializedName("environment_id")
  private String environmentId;
  @SerializedName("customer_id")
  private String customerId;
  @SerializedName("document_type")
  private String documentType;
  @SerializedName("natural_language_query")
  private String naturalLanguageQuery;
  @SerializedName("document_results")
  private LogQueryResponseResultDocuments documentResults;
  @SerializedName("created_timestamp")
  private Date createdTimestamp;
  @SerializedName("client_timestamp")
  private Date clientTimestamp;
  @SerializedName("query_id")
  private String queryId;
  @SerializedName("session_token")
  private String sessionToken;
  @SerializedName("collection_id")
  private String collectionId;
  @SerializedName("display_rank")
  private Long displayRank;
  @SerializedName("document_id")
  private String documentId;
  @SerializedName("event_type")
  private String eventType;
  @SerializedName("result_type")
  private String resultType;

  /**
   * Gets the environmentId.
   *
   * The environment ID that is associated with this log entry.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the customerId.
   *
   * The **customer_id** label that was specified in the header of the query or event API call that corresponds to this
   * log entry.
   *
   * @return the customerId
   */
  public String getCustomerId() {
    return customerId;
  }

  /**
   * Gets the documentType.
   *
   * The type of log entry returned.
   *
   * **query** indicates that the log represents the results of a call to the single collection **query** method.
   *
   * **event** indicates that the log represents a call to the **events** API.
   *
   * @return the documentType
   */
  public String getDocumentType() {
    return documentType;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * The value of the **natural_language_query** query parameter that was used to create these results. Only returned
   * with logs of type **query**.
   *
   * **Note:** Other query parameters (such as **filter** or **deduplicate**) might have been used with this query, but
   * are not recorded.
   *
   * @return the naturalLanguageQuery
   */
  public String getNaturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the documentResults.
   *
   * Object containing result information that was returned by the query used to create this log entry. Only returned
   * with logs of type `query`.
   *
   * @return the documentResults
   */
  public LogQueryResponseResultDocuments getDocumentResults() {
    return documentResults;
  }

  /**
   * Gets the createdTimestamp.
   *
   * Date that the log result was created. Returned in `YYYY-MM-DDThh:mm:ssZ` format.
   *
   * @return the createdTimestamp
   */
  public Date getCreatedTimestamp() {
    return createdTimestamp;
  }

  /**
   * Gets the clientTimestamp.
   *
   * Date specified by the user when recording an event. Returned in `YYYY-MM-DDThh:mm:ssZ` format. Only returned with
   * logs of type **event**.
   *
   * @return the clientTimestamp
   */
  public Date getClientTimestamp() {
    return clientTimestamp;
  }

  /**
   * Gets the queryId.
   *
   * Identifier that corresponds to the **natural_language_query** string used in the original or associated query. All
   * **event** and **query** log entries that have the same original **natural_language_query** string also have them
   * same **query_id**. This field can be used to recall all **event** and **query** log results that have the same
   * original query (**event** logs do not contain the original **natural_language_query** field).
   *
   * @return the queryId
   */
  public String getQueryId() {
    return queryId;
  }

  /**
   * Gets the sessionToken.
   *
   * Unique identifier (within a 24-hour period) that identifies a single `query` log and any `event` logs that were
   * created for it.
   *
   * **Note:** If the exact same query is run at the exact same time on different days, the **session_token** for those
   * queries might be identical. However, the **created_timestamp** differs.
   *
   * **Note:** Session tokens are case sensitive. To avoid matching on session tokens that are identical except for
   * case, use the exact match operator (`::`) when you query for a specific session token.
   *
   * @return the sessionToken
   */
  public String getSessionToken() {
    return sessionToken;
  }

  /**
   * Gets the collectionId.
   *
   * The collection ID of the document associated with this event. Only returned with logs of type `event`.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the displayRank.
   *
   * The original display rank of the document associated with this event. Only returned with logs of type `event`.
   *
   * @return the displayRank
   */
  public Long getDisplayRank() {
    return displayRank;
  }

  /**
   * Gets the documentId.
   *
   * The document ID of the document associated with this event. Only returned with logs of type `event`.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the eventType.
   *
   * The type of event that this object respresents. Possible values are
   *
   * - `query` the log of a query to a collection
   *
   * - `click` the result of a call to the **events** endpoint.
   *
   * @return the eventType
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * Gets the resultType.
   *
   * The type of result that this **event** is associated with. Only returned with logs of type `event`.
   *
   * @return the resultType
   */
  public String getResultType() {
    return resultType;
  }
}

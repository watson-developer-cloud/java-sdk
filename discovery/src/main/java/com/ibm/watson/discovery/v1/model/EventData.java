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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Query event data object.
 */
public class EventData extends GenericModel {

  @SerializedName("environment_id")
  private String environmentId;
  @SerializedName("session_token")
  private String sessionToken;
  @SerializedName("client_timestamp")
  private Date clientTimestamp;
  @SerializedName("display_rank")
  private Long displayRank;
  @SerializedName("collection_id")
  private String collectionId;
  @SerializedName("document_id")
  private String documentId;
  @SerializedName("query_id")
  private String queryId;

  /**
   * Gets the environmentId.
   *
   * The **environment_id** associated with the query that the event is associated with.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the sessionToken.
   *
   * The session token that was returned as part of the query results that this event is associated with.
   *
   * @return the sessionToken
   */
  public String getSessionToken() {
    return sessionToken;
  }

  /**
   * Gets the clientTimestamp.
   *
   * The optional timestamp for the event that was created. If not provided, the time that the event was created in the
   * log was used.
   *
   * @return the clientTimestamp
   */
  public Date getClientTimestamp() {
    return clientTimestamp;
  }

  /**
   * Gets the displayRank.
   *
   * The rank of the result item which the event is associated with.
   *
   * @return the displayRank
   */
  public Long getDisplayRank() {
    return displayRank;
  }

  /**
   * Gets the collectionId.
   *
   * The **collection_id** of the document that this event is associated with.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the documentId.
   *
   * The **document_id** of the document that this event is associated with.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the queryId.
   *
   * The query identifier stored in the log. The query and any events associated with that query are stored with the
   * same **query_id**.
   *
   * @return the queryId
   */
  public String getQueryId() {
    return queryId;
  }

  /**
   * Sets the environmentId.
   *
   * @param environmentId the new environmentId
   */
  public void setEnvironmentId(final String environmentId) {
    this.environmentId = environmentId;
  }

  /**
   * Sets the sessionToken.
   *
   * @param sessionToken the new sessionToken
   */
  public void setSessionToken(final String sessionToken) {
    this.sessionToken = sessionToken;
  }

  /**
   * Sets the clientTimestamp.
   *
   * @param clientTimestamp the new clientTimestamp
   */
  public void setClientTimestamp(final Date clientTimestamp) {
    this.clientTimestamp = clientTimestamp;
  }

  /**
   * Sets the displayRank.
   *
   * @param displayRank the new displayRank
   */
  public void setDisplayRank(final long displayRank) {
    this.displayRank = displayRank;
  }

  /**
   * Sets the collectionId.
   *
   * @param collectionId the new collectionId
   */
  public void setCollectionId(final String collectionId) {
    this.collectionId = collectionId;
  }

  /**
   * Sets the documentId.
   *
   * @param documentId the new documentId
   */
  public void setDocumentId(final String documentId) {
    this.documentId = documentId;
  }
}

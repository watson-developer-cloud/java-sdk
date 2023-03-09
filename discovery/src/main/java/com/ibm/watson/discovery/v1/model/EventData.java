/*
 * (C) Copyright IBM Corp. 2018, 2023.
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

/** Query event data object. */
public class EventData extends GenericModel {

  @SerializedName("environment_id")
  protected String environmentId;

  @SerializedName("session_token")
  protected String sessionToken;

  @SerializedName("client_timestamp")
  protected Date clientTimestamp;

  @SerializedName("display_rank")
  protected Long displayRank;

  @SerializedName("collection_id")
  protected String collectionId;

  @SerializedName("document_id")
  protected String documentId;

  @SerializedName("query_id")
  protected String queryId;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String sessionToken;
    private Date clientTimestamp;
    private Long displayRank;
    private String collectionId;
    private String documentId;

    /**
     * Instantiates a new Builder from an existing EventData instance.
     *
     * @param eventData the instance to initialize the Builder with
     */
    private Builder(EventData eventData) {
      this.environmentId = eventData.environmentId;
      this.sessionToken = eventData.sessionToken;
      this.clientTimestamp = eventData.clientTimestamp;
      this.displayRank = eventData.displayRank;
      this.collectionId = eventData.collectionId;
      this.documentId = eventData.documentId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param sessionToken the sessionToken
     * @param collectionId the collectionId
     * @param documentId the documentId
     */
    public Builder(
        String environmentId, String sessionToken, String collectionId, String documentId) {
      this.environmentId = environmentId;
      this.sessionToken = sessionToken;
      this.collectionId = collectionId;
      this.documentId = documentId;
    }

    /**
     * Builds a EventData.
     *
     * @return the new EventData instance
     */
    public EventData build() {
      return new EventData(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the EventData builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the sessionToken.
     *
     * @param sessionToken the sessionToken
     * @return the EventData builder
     */
    public Builder sessionToken(String sessionToken) {
      this.sessionToken = sessionToken;
      return this;
    }

    /**
     * Set the clientTimestamp.
     *
     * @param clientTimestamp the clientTimestamp
     * @return the EventData builder
     */
    public Builder clientTimestamp(Date clientTimestamp) {
      this.clientTimestamp = clientTimestamp;
      return this;
    }

    /**
     * Set the displayRank.
     *
     * @param displayRank the displayRank
     * @return the EventData builder
     */
    public Builder displayRank(long displayRank) {
      this.displayRank = displayRank;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the EventData builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the EventData builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }
  }

  protected EventData() {}

  protected EventData(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.environmentId, "environmentId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.sessionToken, "sessionToken cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.collectionId, "collectionId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.documentId, "documentId cannot be null");
    environmentId = builder.environmentId;
    sessionToken = builder.sessionToken;
    clientTimestamp = builder.clientTimestamp;
    displayRank = builder.displayRank;
    collectionId = builder.collectionId;
    documentId = builder.documentId;
  }

  /**
   * New builder.
   *
   * @return a EventData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * <p>The **environment_id** associated with the query that the event is associated with.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the sessionToken.
   *
   * <p>The session token that was returned as part of the query results that this event is
   * associated with.
   *
   * @return the sessionToken
   */
  public String sessionToken() {
    return sessionToken;
  }

  /**
   * Gets the clientTimestamp.
   *
   * <p>The optional timestamp for the event that was created. If not provided, the time that the
   * event was created in the log was used.
   *
   * @return the clientTimestamp
   */
  public Date clientTimestamp() {
    return clientTimestamp;
  }

  /**
   * Gets the displayRank.
   *
   * <p>The rank of the result item which the event is associated with.
   *
   * @return the displayRank
   */
  public Long displayRank() {
    return displayRank;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The **collection_id** of the document that this event is associated with.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the documentId.
   *
   * <p>The **document_id** of the document that this event is associated with.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the queryId.
   *
   * <p>The query identifier stored in the log. The query and any events associated with that query
   * are stored with the same **query_id**.
   *
   * @return the queryId
   */
  public String queryId() {
    return queryId;
  }
}

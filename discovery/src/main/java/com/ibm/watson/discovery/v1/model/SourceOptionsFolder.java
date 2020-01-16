/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/**
 * Object that defines a box folder to crawl with this configuration.
 */
public class SourceOptionsFolder extends GenericModel {

  @SerializedName("owner_user_id")
  protected String ownerUserId;
  @SerializedName("folder_id")
  protected String folderId;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String ownerUserId;
    private String folderId;
    private Long limit;

    private Builder(SourceOptionsFolder sourceOptionsFolder) {
      this.ownerUserId = sourceOptionsFolder.ownerUserId;
      this.folderId = sourceOptionsFolder.folderId;
      this.limit = sourceOptionsFolder.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ownerUserId the ownerUserId
     * @param folderId the folderId
     */
    public Builder(String ownerUserId, String folderId) {
      this.ownerUserId = ownerUserId;
      this.folderId = folderId;
    }

    /**
     * Builds a SourceOptionsFolder.
     *
     * @return the sourceOptionsFolder
     */
    public SourceOptionsFolder build() {
      return new SourceOptionsFolder(this);
    }

    /**
     * Set the ownerUserId.
     *
     * @param ownerUserId the ownerUserId
     * @return the SourceOptionsFolder builder
     */
    public Builder ownerUserId(String ownerUserId) {
      this.ownerUserId = ownerUserId;
      return this;
    }

    /**
     * Set the folderId.
     *
     * @param folderId the folderId
     * @return the SourceOptionsFolder builder
     */
    public Builder folderId(String folderId) {
      this.folderId = folderId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the SourceOptionsFolder builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected SourceOptionsFolder(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ownerUserId,
        "ownerUserId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.folderId,
        "folderId cannot be null");
    ownerUserId = builder.ownerUserId;
    folderId = builder.folderId;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a SourceOptionsFolder builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ownerUserId.
   *
   * The Box user ID of the user who owns the folder to crawl.
   *
   * @return the ownerUserId
   */
  public String ownerUserId() {
    return ownerUserId;
  }

  /**
   * Gets the folderId.
   *
   * The Box folder ID of the folder to crawl.
   *
   * @return the folderId
   */
  public String folderId() {
    return folderId;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of documents to crawl for this folder. By default, all documents in the folder are crawled.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

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

/** A collection for storing documents. */
public class Collection extends GenericModel {

  /** The status of the collection. */
  public interface Status {
    /** active. */
    String ACTIVE = "active";
    /** pending. */
    String PENDING = "pending";
    /** maintenance. */
    String MAINTENANCE = "maintenance";
  }

  @SerializedName("collection_id")
  protected String collectionId;

  protected String name;
  protected String description;
  protected Date created;
  protected Date updated;
  protected String status;

  @SerializedName("configuration_id")
  protected String configurationId;

  protected String language;

  @SerializedName("document_counts")
  protected DocumentCounts documentCounts;

  @SerializedName("disk_usage")
  protected CollectionDiskUsage diskUsage;

  @SerializedName("training_status")
  protected TrainingStatus trainingStatus;

  @SerializedName("crawl_status")
  protected CollectionCrawlStatus crawlStatus;

  @SerializedName("smart_document_understanding")
  protected SduStatus smartDocumentUnderstanding;

  protected Collection() {}

  /**
   * Gets the collectionId.
   *
   * <p>The unique identifier of the collection.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the collection.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the collection.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * <p>The creation date of the collection in the format yyyy-MM-dd'T'HH:mmcon:ss.SSS'Z'.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp of when the collection was last updated in the format
   * yyyy-MM-dd'T'HH:mm:ss.SSS'Z'.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the status.
   *
   * <p>The status of the collection.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the configurationId.
   *
   * <p>The unique identifier of the collection's configuration.
   *
   * @return the configurationId
   */
  public String getConfigurationId() {
    return configurationId;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the documents stored in the collection. Permitted values include `en`
   * (English), `de` (German), and `es` (Spanish).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the documentCounts.
   *
   * <p>Object containing collection document count information.
   *
   * @return the documentCounts
   */
  public DocumentCounts getDocumentCounts() {
    return documentCounts;
  }

  /**
   * Gets the diskUsage.
   *
   * <p>Summary of the disk usage statistics for this collection.
   *
   * @return the diskUsage
   */
  public CollectionDiskUsage getDiskUsage() {
    return diskUsage;
  }

  /**
   * Gets the trainingStatus.
   *
   * <p>Training status details.
   *
   * @return the trainingStatus
   */
  public TrainingStatus getTrainingStatus() {
    return trainingStatus;
  }

  /**
   * Gets the crawlStatus.
   *
   * <p>Object containing information about the crawl status of this collection.
   *
   * @return the crawlStatus
   */
  public CollectionCrawlStatus getCrawlStatus() {
    return crawlStatus;
  }

  /**
   * Gets the smartDocumentUnderstanding.
   *
   * <p>Object containing smart document understanding information for this collection.
   *
   * @return the smartDocumentUnderstanding
   */
  public SduStatus getSmartDocumentUnderstanding() {
    return smartDocumentUnderstanding;
  }
}

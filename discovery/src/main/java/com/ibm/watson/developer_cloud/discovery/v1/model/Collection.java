/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A collection for storing documents.
 */
public class Collection extends GenericModel {

  /**
   * The status of the collection.
   */
  public interface Status {
    /** active. */
    String ACTIVE = "active";
    /** pending. */
    String PENDING = "pending";
    /** maintenance. */
    String MAINTENANCE = "maintenance";
  }

  @SerializedName("collection_id")
  private String collectionId;
  private String name;
  private String description;
  private Date created;
  private Date updated;
  private String status;
  @SerializedName("configuration_id")
  private String configurationId;
  private String language;
  @SerializedName("document_counts")
  private DocumentCounts documentCounts;
  @SerializedName("disk_usage")
  private CollectionDiskUsage diskUsage;
  @SerializedName("training_status")
  private TrainingStatus trainingStatus;

  /**
   * Gets the collectionId.
   *
   * The unique identifier of the collection.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the name.
   *
   * The name of the collection.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the collection.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * The creation date of the collection in the format yyyy-MM-dd'T'HH:mmcon:ss.SSS'Z'
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp of when the collection was last updated in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the status.
   *
   * The status of the collection.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the configurationId.
   *
   * The unique identifier of the collection's configuration.
   *
   * @return the configurationId
   */
  public String getConfigurationId() {
    return configurationId;
  }

  /**
   * Gets the language.
   *
   * The language of the documents stored in the collection. Permitted values include `en_us` (U.S. English), `de`
   * (German), and `es` (Spanish).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the documentCounts.
   *
   * The object providing information about the documents in the collection. Present only when retrieving details of a
   * collection.
   *
   * @return the documentCounts
   */
  public DocumentCounts getDocumentCounts() {
    return documentCounts;
  }

  /**
   * Gets the diskUsage.
   *
   * The object providing information about the disk usage of the collection. Present only when retrieving details of a
   * collection.
   *
   * @return the diskUsage
   */
  public CollectionDiskUsage getDiskUsage() {
    return diskUsage;
  }

  /**
   * Gets the trainingStatus.
   *
   * Provides information about the status of relevance training for collection.
   *
   * @return the trainingStatus
   */
  public TrainingStatus getTrainingStatus() {
    return trainingStatus;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the configurationId.
   *
   * @param configurationId the new configurationId
   */
  public void setConfigurationId(final String configurationId) {
    this.configurationId = configurationId;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the documentCounts.
   *
   * @param documentCounts the new documentCounts
   */
  public void setDocumentCounts(final DocumentCounts documentCounts) {
    this.documentCounts = documentCounts;
  }

  /**
   * Sets the diskUsage.
   *
   * @param diskUsage the new diskUsage
   */
  public void setDiskUsage(final CollectionDiskUsage diskUsage) {
    this.diskUsage = diskUsage;
  }

  /**
   * Sets the trainingStatus.
   *
   * @param trainingStatus the new trainingStatus
   */
  public void setTrainingStatus(final TrainingStatus trainingStatus) {
    this.trainingStatus = trainingStatus;
  }
}

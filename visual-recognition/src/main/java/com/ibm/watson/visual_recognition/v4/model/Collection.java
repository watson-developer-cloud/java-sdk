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
package com.ibm.watson.visual_recognition.v4.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Details about a collection.
 */
public class Collection extends GenericModel {

  @SerializedName("collection_id")
  private String collectionId;
  private String name;
  private String description;
  private Date created;
  private Date updated;
  @SerializedName("image_count")
  private Long imageCount;
  @SerializedName("training_status")
  private TrainingStatus trainingStatus;

  /**
   * Gets the collectionId.
   *
   * The identifier of the collection.
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
   * The descripion of the collection.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the created.
   *
   * Date and time in Coordinated Universal Time (UTC) that the collection was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * Date and time in Coordinated Universal Time (UTC) that the collection was most recently updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the imageCount.
   *
   * Number of images in the collection.
   *
   * @return the imageCount
   */
  public Long getImageCount() {
    return imageCount;
  }

  /**
   * Gets the trainingStatus.
   *
   * Training status information for the collection.
   *
   * @return the trainingStatus
   */
  public TrainingStatus getTrainingStatus() {
    return trainingStatus;
  }
}

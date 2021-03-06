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
package com.ibm.watson.visual_recognition.v4.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/** Details about a collection. */
public class Collection extends GenericModel {

  @SerializedName("collection_id")
  protected String collectionId;

  protected String name;
  protected String description;
  protected Date created;
  protected Date updated;

  @SerializedName("image_count")
  protected Long imageCount;

  @SerializedName("training_status")
  protected CollectionTrainingStatus trainingStatus;

  /**
   * Gets the collectionId.
   *
   * <p>The identifier of the collection.
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
   * <p>Date and time in Coordinated Universal Time (UTC) that the collection was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>Date and time in Coordinated Universal Time (UTC) that the collection was most recently
   * updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the imageCount.
   *
   * <p>Number of images in the collection.
   *
   * @return the imageCount
   */
  public Long getImageCount() {
    return imageCount;
  }

  /**
   * Gets the trainingStatus.
   *
   * <p>Training status information for the collection.
   *
   * @return the trainingStatus
   */
  public CollectionTrainingStatus getTrainingStatus() {
    return trainingStatus;
  }
}

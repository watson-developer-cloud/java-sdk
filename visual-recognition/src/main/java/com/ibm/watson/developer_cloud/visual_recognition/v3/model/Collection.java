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
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * success.
 */
public class Collection extends GenericModel {

  /**
   * The status of collection creation.
   */
  public interface Status {
    /** available. */
    String AVAILABLE = "available";
    /** unavailable. */
    String UNAVAILABLE = "unavailable";
  }

  @SerializedName("collection_id")
  private String collectionId;
  private String name;
  private Date created;
  private Long images;
  private String status;
  private Long capacity;

  /**
   * Gets the collectionId.
   *
   * The ID of the collection.
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
   * Gets the created.
   *
   * The date the collection was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the images.
   *
   * The number of images in the collection.
   *
   * @return the images
   */
  public Long getImages() {
    return images;
  }

  /**
   * Gets the status.
   *
   * The status of collection creation.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the capacity.
   *
   * The number of images possible in the collection.
   *
   * @return the capacity
   */
  public Long getCapacity() {
    return capacity;
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
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the images.
   *
   * @param images the new images
   */
  public void setImages(final long images) {
    this.images = images;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }

  /**
   * Sets the capacity.
   *
   * @param capacity the new capacity
   */
  public void setCapacity(final long capacity) {
    this.capacity = capacity;
  }
}

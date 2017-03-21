/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Visual Recognition Collection.
 */
public class Collection extends GenericModel {

  /**
   * Collection status.
   */
  public enum Status {

    /** The collection is available to add images. */
    @SerializedName("available") AVAILABLE,

    /** The collection training failed. */
    @SerializedName("failed") FAILED,

    /** The collection is being created or trained. */
    @SerializedName("unavailable") UNAVAILABLE
  }
  private Integer capacity;
  private Date created;
  @SerializedName("collection_id")
  private String id;
  private Integer images;
  private String name;

  private Status status;

  /**
   * Gets the number of images possible in the collection.
   *
   * @return the capacity
   */
  public Integer getCapacity() {
    return capacity;
  }

  /**
   * Gets the date when the collection was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the number of images in the collection.
   *
   * @return the images
   */
  public Integer getImages() {
    return images;
  }

  /**
   * Gets the name of the collection.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Sets the capacity.
   *
   * @param capacity the new capacity
   */
  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  /**
   * Sets the created.
   *
   * @param created the new created
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the images.
   *
   * @param images the new images
   */
  public void setImages(Integer images) {
    this.images = images;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(Status status) {
    this.status = status;
  }
}

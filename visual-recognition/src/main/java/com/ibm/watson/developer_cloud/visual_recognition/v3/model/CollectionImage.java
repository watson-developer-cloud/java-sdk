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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Collection image.
 */
public class CollectionImage extends GenericModel {

  private Date created;
  @SerializedName("image_file")
  private String imageFile;
  @SerializedName("image_id")
  private String imageId;
  private Map<String, String> metadata;
  private Double score;

  /**
   * Gets the created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the image file.
   *
   * @return the image file
   */
  public String getImageFile() {
    return imageFile;
  }


  /**
   * Gets the image id.
   *
   * @return the image id
   */
  public String getImageId() {
    return imageId;
  }


  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, String> getMetadata() {
    return metadata;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
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
   * Sets the image file.
   *
   * @param imageFile the new image file
   */
  public void setImageFile(String imageFile) {
    this.imageFile = imageFile;
  }

  /**
   * Sets the image id.
   *
   * @param imageId the new image id
   */
  public void setImageId(String imageId) {
    this.imageId = imageId;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the metadata
   */
  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(Double score) {
    this.score = score;
  }


}

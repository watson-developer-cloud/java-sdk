/*
 * (C) Copyright IBM Corp. 2020.
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
 * Details about the training event.
 */
public class TrainingEvent extends GenericModel {

  /**
   * Trained object type. Only `objects` is currently supported.
   */
  public interface Type {
    /** objects. */
    String OBJECTS = "objects";
  }

  /**
   * Training status of the training event.
   */
  public interface Status {
    /** failed. */
    String FAILED = "failed";
    /** succeeded. */
    String SUCCEEDED = "succeeded";
  }

  protected String type;
  @SerializedName("collection_id")
  protected String collectionId;
  @SerializedName("completion_time")
  protected Date completionTime;
  protected String status;
  @SerializedName("image_count")
  protected Long imageCount;

  /**
   * Gets the type.
   *
   * Trained object type. Only `objects` is currently supported.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the collectionId.
   *
   * Identifier of the trained collection.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the completionTime.
   *
   * Date and time in Coordinated Universal Time (UTC) that training on the collection finished.
   *
   * @return the completionTime
   */
  public Date getCompletionTime() {
    return completionTime;
  }

  /**
   * Gets the status.
   *
   * Training status of the training event.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the imageCount.
   *
   * The total number of images that were used in training for this training event.
   *
   * @return the imageCount
   */
  public Long getImageCount() {
    return imageCount;
  }
}

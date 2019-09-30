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
 * Base details about a collection.
 */
public class BaseCollection extends GenericModel {

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
   * Builder.
   */
  public static class Builder {
    private String collectionId;
    private String name;
    private String description;
    private Date created;
    private Date updated;
    private Long imageCount;
    private TrainingStatus trainingStatus;

    private Builder(BaseCollection baseCollection) {
      this.collectionId = baseCollection.collectionId;
      this.name = baseCollection.name;
      this.description = baseCollection.description;
      this.created = baseCollection.created;
      this.updated = baseCollection.updated;
      this.imageCount = baseCollection.imageCount;
      this.trainingStatus = baseCollection.trainingStatus;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a BaseCollection.
     *
     * @return the baseCollection
     */
    public BaseCollection build() {
      return new BaseCollection(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the BaseCollection builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the BaseCollection builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the BaseCollection builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the created.
     *
     * @param created the created
     * @return the BaseCollection builder
     */
    public Builder created(Date created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the BaseCollection builder
     */
    public Builder updated(Date updated) {
      this.updated = updated;
      return this;
    }

    /**
     * Set the imageCount.
     *
     * @param imageCount the imageCount
     * @return the BaseCollection builder
     */
    public Builder imageCount(long imageCount) {
      this.imageCount = imageCount;
      return this;
    }

    /**
     * Set the trainingStatus.
     *
     * @param trainingStatus the trainingStatus
     * @return the BaseCollection builder
     */
    public Builder trainingStatus(TrainingStatus trainingStatus) {
      this.trainingStatus = trainingStatus;
      return this;
    }
  }

  private BaseCollection(Builder builder) {
    collectionId = builder.collectionId;
    name = builder.name;
    description = builder.description;
    created = builder.created;
    updated = builder.updated;
    imageCount = builder.imageCount;
    trainingStatus = builder.trainingStatus;
  }

  /**
   * New builder.
   *
   * @return a BaseCollection builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * The identifier of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the name.
   *
   * The name of the collection. The name can contain alphanumeric, underscore, hyphen, and dot characters. It cannot
   * begin with the reserved prefix `sys-`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the collection.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the created.
   *
   * Date and time in Coordinated Universal Time (UTC) that the collection was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * Date and time in Coordinated Universal Time (UTC) that the collection was most recently updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }

  /**
   * Gets the imageCount.
   *
   * Number of images in the collection.
   *
   * @return the imageCount
   */
  public Long imageCount() {
    return imageCount;
  }

  /**
   * Gets the trainingStatus.
   *
   * Training status information for the collection.
   *
   * @return the trainingStatus
   */
  public TrainingStatus trainingStatus() {
    return trainingStatus;
  }
}

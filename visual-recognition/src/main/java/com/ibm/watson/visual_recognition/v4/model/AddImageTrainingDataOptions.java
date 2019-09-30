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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addImageTrainingData options.
 */
public class AddImageTrainingDataOptions extends GenericModel {

  private String collectionId;
  private String imageId;
  private List<BaseObject> objects;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionId;
    private String imageId;
    private List<BaseObject> objects;

    private Builder(AddImageTrainingDataOptions addImageTrainingDataOptions) {
      this.collectionId = addImageTrainingDataOptions.collectionId;
      this.imageId = addImageTrainingDataOptions.imageId;
      this.objects = addImageTrainingDataOptions.objects;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionId the collectionId
     * @param imageId the imageId
     */
    public Builder(String collectionId, String imageId) {
      this.collectionId = collectionId;
      this.imageId = imageId;
    }

    /**
     * Builds a AddImageTrainingDataOptions.
     *
     * @return the addImageTrainingDataOptions
     */
    public AddImageTrainingDataOptions build() {
      return new AddImageTrainingDataOptions(this);
    }

    /**
     * Adds an objects to objects.
     *
     * @param objects the new objects
     * @return the AddImageTrainingDataOptions builder
     */
    public Builder addObjects(BaseObject objects) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(objects,
          "objects cannot be null");
      if (this.objects == null) {
        this.objects = new ArrayList<BaseObject>();
      }
      this.objects.add(objects);
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the AddImageTrainingDataOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the imageId.
     *
     * @param imageId the imageId
     * @return the AddImageTrainingDataOptions builder
     */
    public Builder imageId(String imageId) {
      this.imageId = imageId;
      return this;
    }

    /**
     * Set the objects.
     * Existing objects will be replaced.
     *
     * @param objects the objects
     * @return the AddImageTrainingDataOptions builder
     */
    public Builder objects(List<BaseObject> objects) {
      this.objects = objects;
      return this;
    }
  }

  private AddImageTrainingDataOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.collectionId,
        "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.imageId,
        "imageId cannot be empty");
    collectionId = builder.collectionId;
    imageId = builder.imageId;
    objects = builder.objects;
  }

  /**
   * New builder.
   *
   * @return a AddImageTrainingDataOptions builder
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
   * Gets the imageId.
   *
   * The identifier of the image.
   *
   * @return the imageId
   */
  public String imageId() {
    return imageId;
  }

  /**
   * Gets the objects.
   *
   * Training data for specific objects.
   *
   * @return the objects
   */
  public List<BaseObject> objects() {
    return objects;
  }
}

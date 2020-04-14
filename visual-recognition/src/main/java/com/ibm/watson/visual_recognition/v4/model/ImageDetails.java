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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;
import java.util.List;

/** Details about an image. */
public class ImageDetails extends GenericModel {

  @SerializedName("image_id")
  protected String imageId;

  protected Date updated;
  protected Date created;
  protected ImageSource source;
  protected ImageDimensions dimensions;
  protected List<Error> errors;

  @SerializedName("training_data")
  protected TrainingDataObjects trainingData;

  /**
   * Gets the imageId.
   *
   * <p>The identifier of the image.
   *
   * @return the imageId
   */
  public String getImageId() {
    return imageId;
  }

  /**
   * Gets the updated.
   *
   * <p>Date and time in Coordinated Universal Time (UTC) that the image was most recently updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the created.
   *
   * <p>Date and time in Coordinated Universal Time (UTC) that the image was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the source.
   *
   * <p>The source type of the image.
   *
   * @return the source
   */
  public ImageSource getSource() {
    return source;
  }

  /**
   * Gets the dimensions.
   *
   * <p>Height and width of an image.
   *
   * @return the dimensions
   */
  public ImageDimensions getDimensions() {
    return dimensions;
  }

  /**
   * Gets the errors.
   *
   * @return the errors
   */
  public List<Error> getErrors() {
    return errors;
  }

  /**
   * Gets the trainingData.
   *
   * <p>Training data for all objects.
   *
   * @return the trainingData
   */
  public TrainingDataObjects getTrainingData() {
    return trainingData;
  }
}

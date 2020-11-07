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

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The addImages options. */
public class AddImagesOptions extends GenericModel {

  protected String collectionId;
  protected List<FileWithMetadata> imagesFile;
  protected List<String> imageUrl;
  protected String trainingData;

  /** Builder. */
  public static class Builder {
    private String collectionId;
    private List<FileWithMetadata> imagesFile;
    private List<String> imageUrl;
    private String trainingData;

    private Builder(AddImagesOptions addImagesOptions) {
      this.collectionId = addImagesOptions.collectionId;
      this.imagesFile = addImagesOptions.imagesFile;
      this.imageUrl = addImagesOptions.imageUrl;
      this.trainingData = addImagesOptions.trainingData;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionId the collectionId
     */
    public Builder(String collectionId) {
      this.collectionId = collectionId;
    }

    /**
     * Builds a AddImagesOptions.
     *
     * @return the new AddImagesOptions instance
     */
    public AddImagesOptions build() {
      return new AddImagesOptions(this);
    }

    /**
     * Adds an imagesFile to imagesFile.
     *
     * @param imagesFile the new imagesFile
     * @return the AddImagesOptions builder
     */
    public Builder addImagesFile(FileWithMetadata imagesFile) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(imagesFile, "imagesFile cannot be null");
      if (this.imagesFile == null) {
        this.imagesFile = new ArrayList<FileWithMetadata>();
      }
      this.imagesFile.add(imagesFile);
      return this;
    }

    /**
     * Adds an imageUrl to imageUrl.
     *
     * @param imageUrl the new imageUrl
     * @return the AddImagesOptions builder
     */
    public Builder addImageUrl(String imageUrl) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(imageUrl, "imageUrl cannot be null");
      if (this.imageUrl == null) {
        this.imageUrl = new ArrayList<String>();
      }
      this.imageUrl.add(imageUrl);
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the AddImagesOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the imagesFile. Existing imagesFile will be replaced.
     *
     * @param imagesFile the imagesFile
     * @return the AddImagesOptions builder
     */
    public Builder imagesFile(List<FileWithMetadata> imagesFile) {
      this.imagesFile = imagesFile;
      return this;
    }

    /**
     * Set the imageUrl. Existing imageUrl will be replaced.
     *
     * @param imageUrl the imageUrl
     * @return the AddImagesOptions builder
     */
    public Builder imageUrl(List<String> imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    /**
     * Set the trainingData.
     *
     * @param trainingData the trainingData
     * @return the AddImagesOptions builder
     */
    public Builder trainingData(String trainingData) {
      this.trainingData = trainingData;
      return this;
    }
  }

  protected AddImagesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    collectionId = builder.collectionId;
    imagesFile = builder.imagesFile;
    imageUrl = builder.imageUrl;
    trainingData = builder.trainingData;
  }

  /**
   * New builder.
   *
   * @return a AddImagesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * <p>The identifier of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the imagesFile.
   *
   * <p>An array of image files (.jpg or .png) or .zip files with images. - Include a maximum of 20
   * images in a request. - Limit the .zip file to 100 MB. - Limit each image file to 10 MB.
   *
   * <p>You can also include an image with the **image_url** parameter.
   *
   * @return the imagesFile
   */
  public List<FileWithMetadata> imagesFile() {
    return imagesFile;
  }

  /**
   * Gets the imageUrl.
   *
   * <p>The array of URLs of image files (.jpg or .png). - Include a maximum of 20 images in a
   * request. - Limit each image file to 10 MB. - Minimum width and height is 30 pixels, but the
   * service tends to perform better with images that are at least 300 x 300 pixels. Maximum is 5400
   * pixels for either height or width.
   *
   * <p>You can also include images with the **images_file** parameter.
   *
   * @return the imageUrl
   */
  public List<String> imageUrl() {
    return imageUrl;
  }

  /**
   * Gets the trainingData.
   *
   * <p>Training data for a single image. Include training data only if you add one image with the
   * request.
   *
   * <p>The `object` property can contain alphanumeric, underscore, hyphen, space, and dot
   * characters. It cannot begin with the reserved prefix `sys-` and must be no longer than 32
   * characters.
   *
   * @return the trainingData
   */
  public String trainingData() {
    return trainingData;
  }
}

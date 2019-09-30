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

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The analyze options.
 */
public class AnalyzeOptions extends GenericModel {

  /**
   * The features to analyze. Separate multiple values with commas.
   */
  public interface Features {
    /** objects. */
    String OBJECTS = "objects";
  }

  private String collectionIds;
  private String features;
  private List<FileWithMetadata> imagesFile;
  private List<String> imageUrl;
  private Float threshold;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionIds;
    private String features;
    private List<FileWithMetadata> imagesFile;
    private List<String> imageUrl;
    private Float threshold;

    private Builder(AnalyzeOptions analyzeOptions) {
      this.collectionIds = analyzeOptions.collectionIds;
      this.features = analyzeOptions.features;
      this.imagesFile = analyzeOptions.imagesFile;
      this.imageUrl = analyzeOptions.imageUrl;
      this.threshold = analyzeOptions.threshold;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionIds the collectionIds
     * @param features the features
     */
    public Builder(String collectionIds, String features) {
      this.collectionIds = collectionIds;
      this.features = features;
    }

    /**
     * Builds a AnalyzeOptions.
     *
     * @return the analyzeOptions
     */
    public AnalyzeOptions build() {
      return new AnalyzeOptions(this);
    }

    /**
     * Adds an imagesFile to imagesFile.
     *
     * @param imagesFile the new imagesFile
     * @return the AnalyzeOptions builder
     */
    public Builder addImagesFile(FileWithMetadata imagesFile) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(imagesFile,
          "imagesFile cannot be null");
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
     * @return the AnalyzeOptions builder
     */
    public Builder addImageUrl(String imageUrl) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(imageUrl,
          "imageUrl cannot be null");
      if (this.imageUrl == null) {
        this.imageUrl = new ArrayList<String>();
      }
      this.imageUrl.add(imageUrl);
      return this;
    }

    /**
     * Set the collectionIds.
     *
     * @param collectionIds the collectionIds
     * @return the AnalyzeOptions builder
     */
    public Builder collectionIds(String collectionIds) {
      this.collectionIds = collectionIds;
      return this;
    }

    /**
     * Set the features.
     *
     * @param features the features
     * @return the AnalyzeOptions builder
     */
    public Builder features(String features) {
      this.features = features;
      return this;
    }

    /**
     * Set the imagesFile.
     * Existing imagesFile will be replaced.
     *
     * @param imagesFile the imagesFile
     * @return the AnalyzeOptions builder
     */
    public Builder imagesFile(List<FileWithMetadata> imagesFile) {
      this.imagesFile = imagesFile;
      return this;
    }

    /**
     * Set the imageUrl.
     * Existing imageUrl will be replaced.
     *
     * @param imageUrl the imageUrl
     * @return the AnalyzeOptions builder
     */
    public Builder imageUrl(List<String> imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    /**
     * Set the threshold.
     *
     * @param threshold the threshold
     * @return the AnalyzeOptions builder
     */
    public Builder threshold(Float threshold) {
      this.threshold = threshold;
      return this;
    }
  }

  private AnalyzeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.collectionIds,
        "collectionIds cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.features,
        "features cannot be null");
    collectionIds = builder.collectionIds;
    features = builder.features;
    imagesFile = builder.imagesFile;
    imageUrl = builder.imageUrl;
    threshold = builder.threshold;
  }

  /**
   * New builder.
   *
   * @return a AnalyzeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionIds.
   *
   * The IDs of the collections to analyze. Separate multiple values with commas.
   *
   * @return the collectionIds
   */
  public String collectionIds() {
    return collectionIds;
  }

  /**
   * Gets the features.
   *
   * The features to analyze. Separate multiple values with commas.
   *
   * @return the features
   */
  public String features() {
    return features;
  }

  /**
   * Gets the imagesFile.
   *
   * An array of image files (.jpg or .png) or .zip files with images.
   * - Include a maximum of 20 images in a request.
   * - Limit the .zip file to 100 MB.
   * - Limit each image file to 10 MB.
   *
   * You can also include an image with the **image_url** parameter.
   *
   * @return the imagesFile
   */
  public List<FileWithMetadata> imagesFile() {
    return imagesFile;
  }

  /**
   * Gets the imageUrl.
   *
   * An array of URLs of image files (.jpg or .png).
   * - Include a maximum of 20 images in a request.
   * - Limit each image file to 10 MB.
   * - Minimum width and height is 30 pixels, but the service tends to perform better with images that are at least 300
   * x 300 pixels. Maximum is 5400 pixels for either height or width.
   *
   * You can also include images with the **images_file** parameter.
   *
   * @return the imageUrl
   */
  public List<String> imageUrl() {
    return imageUrl;
  }

  /**
   * Gets the threshold.
   *
   * The minimum score a feature must have to be returned.
   *
   * @return the threshold
   */
  public Float threshold() {
    return threshold;
  }
}

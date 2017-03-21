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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.HttpUrl;

/**
 * Classify Images request options.
 */
public class ClassifyImagesOptions {

  /**
   * Classify Images Request Builder.
   */
  public static class Builder {
    private List<String> classifierIds;
    private String imageName = "placeholder.png";
    private byte[] imagesBinary;
    private File imagesFile;
    private Double threshold;
    private HttpUrl url;


    private Builder(ClassifyImagesOptions options) {
      this();
      imagesFile = options.imagesFile;
      imagesBinary = options.imagesBinary;
      url = options.url;
      classifierIds = new ArrayList<String>(options.classifierIds);
      threshold = options.threshold;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the profile options.
     *
     * @return the profile options
     */
    public ClassifyImagesOptions build() {
      Validator.isTrue((url != null) || (imagesFile != null || imagesBinary != null),
      "url or imagesFile or imagesBinary should be specified");
      return new ClassifyImagesOptions(this);
      }

    /**
     * Classifier ids.
     *
     * @param classifierIds the classifier ids
     * @return the builder
     */
    public Builder classifierIds(List<String> classifierIds) {
      this.classifierIds = classifierIds;
      return this;
    }

    /**
     * Classifier ids.
     *
     * @param classifierId the classifier id
     * @return the builder
     */
    public Builder classifierIds(String classifierId) {
      if (classifierIds == null) {
        classifierIds = new ArrayList<String>();
      }

      classifierIds.add(classifierId);
      return this;
    }


    /**
     * Sets the images.
     *
     * @param imagesBinary the images bytes
     * @param imageName the image name
     * @return the builder
     */
    public Builder images(byte[] imagesBinary, String imageName) {
      Validator.notNull(imagesBinary, "'imagesBinary' cannot be null");
      this.imagesBinary = imagesBinary;
      this.imageName = imageName;
      return this;
    }

    /**
     * Sets the images.
     *
     * @param imagesFile the images file
     * @return the builder
     */
    public Builder images(File imagesFile) {
      Validator.notNull(imagesFile, "'imagesFile' cannot be null");
      this.imagesFile = imagesFile;
      return this;
    }

    /**
     * Threshold.
     *
     * @param threshold the threshold
     * @return the builder
     */
    public Builder threshold(double threshold) {
      Validator.isTrue((threshold <= 1.0) && (threshold >= 0.0), "'threshold' needs to be between 0.0 and 1.0");
      this.threshold = threshold;
      return this;
    }

    /**
     * Sets the image url.
     *
     * @param url the url
     * @return the builder
     */
    public Builder url(HttpUrl url) {
      Validator.notNull(url, "'url' cannot be null");
      this.url = url;
      return this;
    }

  /**
   * Sets the image url.
   *
   * @param url the url
   * @return the builder
   */
  public Builder url(String url) {
    return url(HttpUrl.parse(url));
  }

  }

  private List<String> classifierIds;
  private String imageName = "placeholder.png";
  private byte[] imagesBinary;
  private File imagesFile;
  private Double threshold;
  private HttpUrl url;

  private ClassifyImagesOptions(Builder builder) {
    imagesFile = builder.imagesFile;
    imagesBinary = builder.imagesBinary;
    url = builder.url;
    classifierIds = builder.classifierIds;
    threshold = builder.threshold;
    imageName = builder.imageName;
  }

  /**
   * Returns the classifier ids.
   *
   * @return the classifier ids
   */
  public List<String> classifierIds() {
    return classifierIds;
  }

  /**
   * Image name.
   *
   * @return the string
   */
  public String imageName() {
    return imageName;
  }

  /**
   * Returns the images file.
   *
   * @return the images file
   */
  public File images() {
    return imagesFile;
  }

  /**
   * Returns the images binary.
   *
   * @return the images binary
   */
  public byte[] imagesBinary() {
    return imagesBinary;
  }

  /**
   * Creates a new Builder using the current values.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Returns the classification threshold.
   *
   * @return the classification threshold
   */
  public Double threshold() {
    return threshold;
  }


  /**
   * Returns the {@link HttpUrl}.
   *
   * @return the image url
   */
  public HttpUrl url() {
    return url;
  }
}

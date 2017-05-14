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

import com.ibm.watson.developer_cloud.util.Validator;
import okhttp3.HttpUrl;

/**
 * Visual Recognition request options.
 */
public class VisualRecognitionOptions {

  /**
   * Visual Recognition Request Builder.
   */
  public static class Builder {
    private File imagesFile;
    private HttpUrl url;
    private byte[] imagesBinary;
    private String imageName;


    private Builder(VisualRecognitionOptions options) {
      this();
      imagesFile = options.imagesFile;
      url = options.url;
      imagesBinary = options.imagesBinary;
      imageName = options.imageName;
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
    public VisualRecognitionOptions build() {
      Validator.isTrue((url != null) || (imagesFile != null) || (imagesBinary != null),
          "url, imagesBinary or imagesFile should be specified");
      return new VisualRecognitionOptions(this);
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

  private File imagesFile;
  private HttpUrl url;
  private byte[] imagesBinary;
  private String imageName;

  private VisualRecognitionOptions(Builder builder) {
    imagesFile = builder.imagesFile;
    url = builder.url;
    imagesBinary = builder.imagesBinary;
    imageName = builder.imageName;
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
   * Creates a new Builder using the current values.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Returns the {@link HttpUrl}.
   *
   * @return the sets the
   */
  public HttpUrl url() {
    return url;
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
   * Returns the images binary.
   *
   * @return the images binary
   */
  public byte[] imagesBinary() {
    return imagesBinary;
  }
}

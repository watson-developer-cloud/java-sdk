/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
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

import java.io.File;

import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.HttpUrl;

/**
 * Visual Recognition request options.
 */
public class VisualRecognitionOptions {

  private VisualRecognitionOptions(Builder builder) {
    this.imagesFile = builder.imagesFile;
    this.url = builder.url;
  }

  private File imagesFile;
  private HttpUrl url;

  /**
   * Visual Recognition Request Builder.
   */
  public static class Builder {
    private File imagesFile;
    private HttpUrl url;


    private Builder(VisualRecognitionOptions options) {
      this();
      this.imagesFile = options.imagesFile;
      this.url = options.url;
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
    
    /**
     * Instantiates a new builder.
     */
    public Builder() {}

    /**
     * Builds the profile options.
     *
     * @return the profile options
     */
    public VisualRecognitionOptions build() {
      Validator.isTrue(url != null || imagesFile != null, "url or imagesFile should be specified");
      return new VisualRecognitionOptions(this);
    }

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
   * Returns the {@link HttpUrl}.
   *
   * @return the sets the
   */
  public HttpUrl url() {
    return url;
  }

  /**
   * Creates a new Builder using the current values.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

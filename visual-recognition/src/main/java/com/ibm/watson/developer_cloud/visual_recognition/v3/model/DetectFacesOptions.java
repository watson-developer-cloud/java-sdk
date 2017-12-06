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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The detectFaces options.
 */
public class DetectFacesOptions extends GenericModel {

  private InputStream imagesFile;
  private String imagesFilename;
  private String parameters;
  private String imagesFileContentType;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream imagesFile;
    private String imagesFilename;
    private String parameters;
    private String imagesFileContentType;

    private Builder(DetectFacesOptions detectFacesOptions) {
      imagesFile = detectFacesOptions.imagesFile;
      imagesFilename = detectFacesOptions.imagesFilename;
      parameters = detectFacesOptions.parameters;
      imagesFileContentType = detectFacesOptions.imagesFileContentType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DetectFacesOptions.
     *
     * @return the detectFacesOptions
     */
    public DetectFacesOptions build() {
      return new DetectFacesOptions(this);
    }

    /**
     * Set the imagesFile.
     *
     * @param imagesFile the imagesFile
     * @return the DetectFacesOptions builder
     */
    public Builder imagesFile(InputStream imagesFile) {
      this.imagesFile = imagesFile;
      return this;
    }

    /**
     * Set the imagesFilename.
     *
     * @param imagesFilename the imagesFilename
     * @return the DetectFacesOptions builder
     */
    public Builder imagesFilename(String imagesFilename) {
      this.imagesFilename = imagesFilename;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the DetectFacesOptions builder
     */
    public Builder parameters(String parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the imagesFileContentType.
     *
     * @param imagesFileContentType the imagesFileContentType
     * @return the DetectFacesOptions builder
     */
    public Builder imagesFileContentType(String imagesFileContentType) {
      this.imagesFileContentType = imagesFileContentType;
      return this;
    }

    /**
     * Set the imagesFile.
     *
     * @param imagesFile the imagesFile
     * @return the DetectFacesOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder imagesFile(File imagesFile) throws FileNotFoundException {
      this.imagesFile = new FileInputStream(imagesFile);
      this.imagesFilename = imagesFile.getName();
      return this;
    }
  }

  private DetectFacesOptions(Builder builder) {
    imagesFile = builder.imagesFile;
    imagesFilename = builder.imagesFilename;
    parameters = builder.parameters;
    imagesFileContentType = builder.imagesFileContentType;
  }

  /**
   * New builder.
   *
   * @return a DetectFacesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the imagesFile.
   *
   * An image file (.jpg, .png) or .zip file with images. Include no more than 15 images. You can also include images
   * with the `url` property in the **parameters** object. All faces are detected, but if there are more than 10 faces
   * in an image, age and gender confidence scores might return scores of 0.
   *
   * @return the imagesFile
   */
  public InputStream imagesFile() {
    return imagesFile;
  }

  /**
   * Gets the imagesFilename.
   *
   * The filename for imagesFile.
   *
   * @return the imagesFilename
   */
  public String imagesFilename() {
    return imagesFilename;
  }

  /**
   * Gets the parameters.
   *
   * A JSON string containing the image URL to analyze. For example: {"url": "..."}
   *
   * @return the parameters
   */
  public String parameters() {
    return parameters;
  }

  /**
   * Gets the imagesFileContentType.
   *
   * The content type of imagesFile. Values for this parameter can be obtained from the HttpMediaType class.
   *
   * @return the imagesFileContentType
   */
  public String imagesFileContentType() {
    return imagesFileContentType;
  }
}

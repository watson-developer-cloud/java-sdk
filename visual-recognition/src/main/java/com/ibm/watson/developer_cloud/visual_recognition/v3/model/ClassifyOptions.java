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
 * The classify options.
 */
public class ClassifyOptions extends GenericModel {

  /**
   * Specifies the language of the output class names. Can be `en` (English), `ar` (Arabic), `de` (German), `es`
   * (Spanish), `it` (Italian), `ja` (Japanese), or `ko` (Korean). Classes for which no translation is available are
   * omitted. The response might not be in the specified language under these conditions: - English is returned when the
   * requested language is not supported. - Classes are not returned when there is no translation for them. - Custom
   * classifiers returned with this method return tags in the language of the custom classifier.
   */
  public interface AcceptLanguage {
    /** en. */
    String EN = "en";
    /** ar. */
    String AR = "ar";
    /** de. */
    String DE = "de";
    /** es. */
    String ES = "es";
    /** it. */
    String IT = "it";
    /** ja. */
    String JA = "ja";
    /** ko. */
    String KO = "ko";
  }

  private InputStream imagesFile;
  private String imagesFilename;
  private String parameters;
  private String acceptLanguage;
  private String imagesFileContentType;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream imagesFile;
    private String imagesFilename;
    private String parameters;
    private String acceptLanguage;
    private String imagesFileContentType;

    private Builder(ClassifyOptions classifyOptions) {
      imagesFile = classifyOptions.imagesFile;
      imagesFilename = classifyOptions.imagesFilename;
      parameters = classifyOptions.parameters;
      acceptLanguage = classifyOptions.acceptLanguage;
      imagesFileContentType = classifyOptions.imagesFileContentType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ClassifyOptions.
     *
     * @return the classifyOptions
     */
    public ClassifyOptions build() {
      return new ClassifyOptions(this);
    }

    /**
     * Set the imagesFile.
     *
     * @param imagesFile the imagesFile
     * @return the ClassifyOptions builder
     */
    public Builder imagesFile(InputStream imagesFile) {
      this.imagesFile = imagesFile;
      return this;
    }

    /**
     * Set the imagesFilename.
     *
     * @param imagesFilename the imagesFilename
     * @return the ClassifyOptions builder
     */
    public Builder imagesFilename(String imagesFilename) {
      this.imagesFilename = imagesFilename;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the ClassifyOptions builder
     */
    public Builder parameters(String parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ClassifyOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the imagesFileContentType.
     *
     * @param imagesFileContentType the imagesFileContentType
     * @return the ClassifyOptions builder
     */
    public Builder imagesFileContentType(String imagesFileContentType) {
      this.imagesFileContentType = imagesFileContentType;
      return this;
    }

    /**
     * Set the imagesFile.
     *
     * @param imagesFile the imagesFile
     * @return the ClassifyOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder imagesFile(File imagesFile) throws FileNotFoundException {
      this.imagesFile = new FileInputStream(imagesFile);
      this.imagesFilename = imagesFile.getName();
      return this;
    }
  }

  private ClassifyOptions(Builder builder) {
    imagesFile = builder.imagesFile;
    imagesFilename = builder.imagesFilename;
    parameters = builder.parameters;
    acceptLanguage = builder.acceptLanguage;
    imagesFileContentType = builder.imagesFileContentType;
  }

  /**
   * New builder.
   *
   * @return a ClassifyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the imagesFile.
   *
   * An image file (.jpg, .png) or .zip file with images. Include no more than 20 images and limit the .zip file to 5
   * MB. You can also include images with the `url` property in the **parameters** object.
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
   * Specifies input parameters. The parameter can include these inputs in a JSON object: - url: A string with the image
   * URL to analyze. You can also include images in the **images_file** parameter. - classifier_ids: An array of
   * classifier IDs to classify the images against. - owners: An array with the values IBM, me, or both to specify which
   * classifiers to run. - threshold: A floating point value that specifies the minimum score a class must have to be
   * displayed in the response. For example: {"url": "...", "classifier_ids": ["...","..."], "owners": ["IBM", "me"],
   * "threshold": 0.4}
   *
   * @return the parameters
   */
  public String parameters() {
    return parameters;
  }

  /**
   * Gets the acceptLanguage.
   *
   * Specifies the language of the output class names. Can be `en` (English), `ar` (Arabic), `de` (German), `es`
   * (Spanish), `it` (Italian), `ja` (Japanese), or `ko` (Korean). Classes for which no translation is available are
   * omitted. The response might not be in the specified language under these conditions: - English is returned when the
   * requested language is not supported. - Classes are not returned when there is no translation for them. - Custom
   * classifiers returned with this method return tags in the language of the custom classifier.
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
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

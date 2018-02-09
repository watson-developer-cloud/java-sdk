/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
     * @throws FileNotFoundException if the file could not be found
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
   * An image file (.jpg, .png) or .zip file with images. Maximum image size is 10 MB. Include no more than 20 images
   * and limit the .zip file to 100 MB. Encode the image and .zip file names in UTF-8 if they contain non-ASCII
   * characters. The service assumes UTF-8 encoding if it encounters non-ASCII characters. You can also include images
   * with the `url` property in the **parameters** object.
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
   * A JSON object that specifies additional request options. The parameter can be sent as a string or a file, and can
   * include these inputs: - **url**: A string with the image URL to analyze. Must be in .jpg, or .png format. The
   * minimum recommended pixel density is 32X32 pixels per inch, and the maximum image size is 10 MB. You can also
   * include images in the **images_file** parameter. - **threshold**: A floating point value that specifies the minimum
   * score a class must have to be displayed in the response. The default threshold for returning scores from a
   * classifier is `0.5`. Set the threshold to `0.0` to ignore the classification score and return all values. -
   * **owners**: An array of the categories of classifiers to apply. Use `IBM` to classify against the `default` general
   * classifier, and use `me` to classify against your custom classifiers. To analyze the image against both classifier
   * categories, set the value to both `IBM` and `me`. The built-in `default` classifier is used if both
   * **classifier_ids** and **owners** parameters are empty. The **classifier_ids** parameter overrides **owners**, so
   * make sure that **classifier_ids** is empty. - **classifier_ids**: Specifies which classifiers to apply and
   * overrides the **owners** parameter. You can specify both custom and built-in classifiers. The built-in `default`
   * classifier is used if both **classifier_ids** and **owners** parameters are empty. The following built-in
   * classifier IDs require no training: - `default`: Returns classes from thousands of general tags. - `food`: (Beta)
   * Enhances specificity and accuracy for images of food items. - `explicit`: (Beta) Evaluates whether the image might
   * be pornographic. Example: `{"classifier_ids":["CarsvsTrucks_1479118188","explicit"],"threshold":0.6}`.
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

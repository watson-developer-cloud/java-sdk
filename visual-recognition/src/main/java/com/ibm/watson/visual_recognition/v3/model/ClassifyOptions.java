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
package com.ibm.watson.visual_recognition.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/** The classify options. */
public class ClassifyOptions extends GenericModel {

  /** The desired language of parts of the response. See the response for details. */
  public interface AcceptLanguage {
    /** en. */
    String EN = "en";
    /** ar. */
    String AR = "ar";
    /** de. */
    String DE = "de";
    /** es. */
    String ES = "es";
    /** fr. */
    String FR = "fr";
    /** it. */
    String IT = "it";
    /** ja. */
    String JA = "ja";
    /** ko. */
    String KO = "ko";
    /** pt-br. */
    String PT_BR = "pt-br";
    /** zh-cn. */
    String ZH_CN = "zh-cn";
    /** zh-tw. */
    String ZH_TW = "zh-tw";
  }

  protected InputStream imagesFile;
  protected String imagesFilename;
  protected String imagesFileContentType;
  protected String url;
  protected Float threshold;
  protected List<String> owners;
  protected List<String> classifierIds;
  protected String acceptLanguage;

  /** Builder. */
  public static class Builder {
    private InputStream imagesFile;
    private String imagesFilename;
    private String imagesFileContentType;
    private String url;
    private Float threshold;
    private List<String> owners;
    private List<String> classifierIds;
    private String acceptLanguage;

    private Builder(ClassifyOptions classifyOptions) {
      this.imagesFile = classifyOptions.imagesFile;
      this.imagesFilename = classifyOptions.imagesFilename;
      this.imagesFileContentType = classifyOptions.imagesFileContentType;
      this.url = classifyOptions.url;
      this.threshold = classifyOptions.threshold;
      this.owners = classifyOptions.owners;
      this.classifierIds = classifyOptions.classifierIds;
      this.acceptLanguage = classifyOptions.acceptLanguage;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ClassifyOptions.
     *
     * @return the new ClassifyOptions instance
     */
    public ClassifyOptions build() {
      return new ClassifyOptions(this);
    }

    /**
     * Adds an owner to owners.
     *
     * @param owner the new owner
     * @return the ClassifyOptions builder
     */
    public Builder addOwner(String owner) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(owner, "owner cannot be null");
      if (this.owners == null) {
        this.owners = new ArrayList<String>();
      }
      this.owners.add(owner);
      return this;
    }

    /**
     * Adds an classifierId to classifierIds.
     *
     * @param classifierId the new classifierId
     * @return the ClassifyOptions builder
     */
    public Builder addClassifierId(String classifierId) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(classifierId, "classifierId cannot be null");
      if (this.classifierIds == null) {
        this.classifierIds = new ArrayList<String>();
      }
      this.classifierIds.add(classifierId);
      return this;
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
     * Set the url.
     *
     * @param url the url
     * @return the ClassifyOptions builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the threshold.
     *
     * @param threshold the threshold
     * @return the ClassifyOptions builder
     */
    public Builder threshold(Float threshold) {
      this.threshold = threshold;
      return this;
    }

    /**
     * Set the owners. Existing owners will be replaced.
     *
     * @param owners the owners
     * @return the ClassifyOptions builder
     */
    public Builder owners(List<String> owners) {
      this.owners = owners;
      return this;
    }

    /**
     * Set the classifierIds. Existing classifierIds will be replaced.
     *
     * @param classifierIds the classifierIds
     * @return the ClassifyOptions builder
     */
    public Builder classifierIds(List<String> classifierIds) {
      this.classifierIds = classifierIds;
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
     * Set the imagesFile.
     *
     * @param imagesFile the imagesFile
     * @return the ClassifyOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder imagesFile(File imagesFile) throws FileNotFoundException {
      this.imagesFile = new FileInputStream(imagesFile);
      this.imagesFilename = imagesFile.getName();
      return this;
    }
  }

  protected ClassifyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (builder.imagesFile == null) || (builder.imagesFilename != null),
        "imagesFilename cannot be null if imagesFile is not null.");
    imagesFile = builder.imagesFile;
    imagesFilename = builder.imagesFilename;
    imagesFileContentType = builder.imagesFileContentType;
    url = builder.url;
    threshold = builder.threshold;
    owners = builder.owners;
    classifierIds = builder.classifierIds;
    acceptLanguage = builder.acceptLanguage;
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
   * <p>An image file (.gif, .jpg, .png, .tif) or .zip file with images. Maximum image size is 10
   * MB. Include no more than 20 images and limit the .zip file to 100 MB. Encode the image and .zip
   * file names in UTF-8 if they contain non-ASCII characters. The service assumes UTF-8 encoding if
   * it encounters non-ASCII characters.
   *
   * <p>You can also include an image with the **url** parameter.
   *
   * @return the imagesFile
   */
  public InputStream imagesFile() {
    return imagesFile;
  }

  /**
   * Gets the imagesFilename.
   *
   * <p>The filename for imagesFile.
   *
   * @return the imagesFilename
   */
  public String imagesFilename() {
    return imagesFilename;
  }

  /**
   * Gets the imagesFileContentType.
   *
   * <p>The content type of imagesFile. Values for this parameter can be obtained from the
   * HttpMediaType class.
   *
   * @return the imagesFileContentType
   */
  public String imagesFileContentType() {
    return imagesFileContentType;
  }

  /**
   * Gets the url.
   *
   * <p>The URL of an image (.gif, .jpg, .png, .tif) to analyze. The minimum recommended pixel
   * density is 32X32 pixels, but the service tends to perform better with images that are at least
   * 224 x 224 pixels. The maximum image size is 10 MB.
   *
   * <p>You can also include images with the **images_file** parameter.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the threshold.
   *
   * <p>The minimum score a class must have to be displayed in the response. Set the threshold to
   * `0.0` to return all identified classes.
   *
   * @return the threshold
   */
  public Float threshold() {
    return threshold;
  }

  /**
   * Gets the owners.
   *
   * <p>The categories of classifiers to apply. The **classifier_ids** parameter overrides
   * **owners**, so make sure that **classifier_ids** is empty. - Use `IBM` to classify against the
   * `default` general classifier. You get the same result if both **classifier_ids** and **owners**
   * parameters are empty. - Use `me` to classify against all your custom classifiers. However, for
   * better performance use **classifier_ids** to specify the specific custom classifiers to apply.
   * - Use both `IBM` and `me` to analyze the image against both classifier categories.
   *
   * @return the owners
   */
  public List<String> owners() {
    return owners;
  }

  /**
   * Gets the classifierIds.
   *
   * <p>Which classifiers to apply. Overrides the **owners** parameter. You can specify both custom
   * and built-in classifier IDs. The built-in `default` classifier is used if both
   * **classifier_ids** and **owners** parameters are empty.
   *
   * <p>The following built-in classifier IDs require no training: - `default`: Returns classes from
   * thousands of general tags. - `food`: Enhances specificity and accuracy for images of food
   * items. - `explicit`: Evaluates whether the image might be pornographic.
   *
   * @return the classifierIds
   */
  public List<String> classifierIds() {
    return classifierIds;
  }

  /**
   * Gets the acceptLanguage.
   *
   * <p>The desired language of parts of the response. See the response for details.
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }
}

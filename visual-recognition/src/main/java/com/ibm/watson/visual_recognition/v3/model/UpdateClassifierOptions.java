/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
import java.util.HashMap;
import java.util.Map;

/** The updateClassifier options. */
public class UpdateClassifierOptions extends GenericModel {

  protected String classifierId;
  protected Map<String, InputStream> positiveExamples;
  protected InputStream negativeExamples;
  protected String negativeExamplesFilename;

  /** Builder. */
  public static class Builder {
    private String classifierId;
    private Map<String, InputStream> positiveExamples;
    private InputStream negativeExamples;
    private String negativeExamplesFilename;

    private Builder(UpdateClassifierOptions updateClassifierOptions) {
      this.classifierId = updateClassifierOptions.classifierId;
      this.positiveExamples = updateClassifierOptions.positiveExamples;
      this.negativeExamples = updateClassifierOptions.negativeExamples;
      this.negativeExamplesFilename = updateClassifierOptions.negativeExamplesFilename;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param classifierId the classifierId
     */
    public Builder(String classifierId) {
      this.classifierId = classifierId;
    }

    /**
     * Builds a UpdateClassifierOptions.
     *
     * @return the updateClassifierOptions
     */
    public UpdateClassifierOptions build() {
      return new UpdateClassifierOptions(this);
    }

    /**
     * Adds an entry to the positiveExamples map.
     *
     * @param classname the key associated with the map entry to be added
     * @param positiveExamples the value associated with the map entry to be added
     * @return the UpdateClassifierOptions builder
     */
    public Builder addPositiveExamples(String classname, InputStream positiveExamples) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(classname, "classname cannot be null");
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          positiveExamples, "positiveExamples cannot be null");
      if (this.positiveExamples == null) {
        this.positiveExamples = new HashMap<String, InputStream>();
      }
      this.positiveExamples.put(classname, positiveExamples);
      return this;
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the UpdateClassifierOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }

    /**
     * Set the positiveExamples. Existing positiveExamples map will be replaced.
     *
     * @param positiveExamples the positiveExamples
     * @return the UpdateClassifierOptions builder
     */
    public Builder positiveExamples(Map<String, InputStream> positiveExamples) {
      this.positiveExamples = positiveExamples;
      return this;
    }

    /**
     * Set the negativeExamples.
     *
     * @param negativeExamples the negativeExamples
     * @return the UpdateClassifierOptions builder
     */
    public Builder negativeExamples(InputStream negativeExamples) {
      this.negativeExamples = negativeExamples;
      return this;
    }

    /**
     * Set the negativeExamplesFilename.
     *
     * @param negativeExamplesFilename the negativeExamplesFilename
     * @return the UpdateClassifierOptions builder
     */
    public Builder negativeExamplesFilename(String negativeExamplesFilename) {
      this.negativeExamplesFilename = negativeExamplesFilename;
      return this;
    }

    /**
     * Adds an entry to the positiveExamples map.
     *
     * @param classname the key associated with the map entry to be added
     * @param positiveExamples the value associated with the map entry to be added
     * @return the UpdateClassifierOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder addPositiveExamples(String classname, File positiveExamples)
        throws FileNotFoundException {
      this.addPositiveExamples(classname, new FileInputStream(positiveExamples));
      return this;
    }

    /**
     * Set the negativeExamples.
     *
     * @param negativeExamples the negativeExamples
     * @return the UpdateClassifierOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder negativeExamples(File negativeExamples) throws FileNotFoundException {
      this.negativeExamples = new FileInputStream(negativeExamples);
      this.negativeExamplesFilename = negativeExamples.getName();
      return this;
    }
  }

  protected UpdateClassifierOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.classifierId, "classifierId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (builder.negativeExamples == null) || (builder.negativeExamplesFilename != null),
        "negativeExamplesFilename cannot be null if negativeExamples is not null.");
    classifierId = builder.classifierId;
    positiveExamples = builder.positiveExamples;
    negativeExamples = builder.negativeExamples;
    negativeExamplesFilename = builder.negativeExamplesFilename;
  }

  /**
   * New builder.
   *
   * @return a UpdateClassifierOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the classifierId.
   *
   * <p>The ID of the classifier.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }

  /**
   * Gets the positiveExamples.
   *
   * <p>A .zip file of images that depict the visual subject of a class in the classifier. The
   * positive examples create or update classes in the classifier. You can include more than one
   * positive example file in a call.
   *
   * <p>Specify the parameter name by appending `_positive_examples` to the class name. For example,
   * `goldenretriever_positive_examples` creates the class `goldenretriever`. The string cannot
   * contain the following characters: ``$ * - { } \ | / ' " ` [ ]``.
   *
   * <p>Include at least 10 images in .jpg or .png format. The minimum recommended image resolution
   * is 32X32 pixels. The maximum number of images is 10,000 images or 100 MB per .zip file.
   *
   * <p>Encode special characters in the file name in UTF-8.
   *
   * @return the positiveExamples
   */
  public Map<String, InputStream> positiveExamples() {
    return positiveExamples;
  }

  /**
   * Gets the negativeExamples.
   *
   * <p>A .zip file of images that do not depict the visual subject of any of the classes of the new
   * classifier. Must contain a minimum of 10 images.
   *
   * <p>Encode special characters in the file name in UTF-8.
   *
   * @return the negativeExamples
   */
  public InputStream negativeExamples() {
    return negativeExamples;
  }

  /**
   * Gets the negativeExamplesFilename.
   *
   * <p>The filename for negativeExamples.
   *
   * @return the negativeExamplesFilename
   */
  public String negativeExamplesFilename() {
    return negativeExamplesFilename;
  }
}

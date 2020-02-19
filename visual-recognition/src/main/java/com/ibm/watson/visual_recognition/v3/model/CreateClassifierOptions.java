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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createClassifier options.
 */
public class CreateClassifierOptions extends GenericModel {

  protected String name;
  protected Map<String, InputStream> positiveExamples;
  protected InputStream negativeExamples;
  protected String negativeExamplesFilename;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Map<String, InputStream> positiveExamples;
    private InputStream negativeExamples;
    private String negativeExamplesFilename;

    private Builder(CreateClassifierOptions createClassifierOptions) {
      this.name = createClassifierOptions.name;
      this.positiveExamples = createClassifierOptions.positiveExamples;
      this.negativeExamples = createClassifierOptions.negativeExamples;
      this.negativeExamplesFilename = createClassifierOptions.negativeExamplesFilename;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a CreateClassifierOptions.
     *
     * @return the createClassifierOptions
     */
    public CreateClassifierOptions build() {
      return new CreateClassifierOptions(this);
    }

    /**
     * Adds an entry to the positiveExamples map.
     *
     * @param classname the key associated with the map entry to be added
     * @param positiveExamples the value associated with the map entry to be added
     * @return the CreateClassifierOptions builder
     */
    public Builder addPositiveExamples(String classname, InputStream positiveExamples) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(classname,
        "classname cannot be null");
      com.ibm.cloud.sdk.core.util.Validator.notNull(positiveExamples,
        "positiveExamples cannot be null");
      if (this.positiveExamples == null) {
        this.positiveExamples = new HashMap<String, InputStream>();
      }
      this.positiveExamples.put(classname, positiveExamples);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateClassifierOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the positiveExamples.
     * Existing positiveExamples map will be replaced.
     *
     * @param positiveExamples the positiveExamples
     * @return the CreateClassifierOptions builder
     */
    public Builder positiveExamples(Map<String, InputStream> positiveExamples) {
      this.positiveExamples = positiveExamples;
      return this;
    }

    /**
     * Set the negativeExamples.
     *
     * @param negativeExamples the negativeExamples
     * @return the CreateClassifierOptions builder
     */
    public Builder negativeExamples(InputStream negativeExamples) {
      this.negativeExamples = negativeExamples;
      return this;
    }

    /**
     * Set the negativeExamplesFilename.
     *
     * @param negativeExamplesFilename the negativeExamplesFilename
     * @return the CreateClassifierOptions builder
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
     * @return the CreateClassifierOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder addPositiveExamples(String classname, File positiveExamples) throws FileNotFoundException {
      this.addPositiveExamples(classname, new FileInputStream(positiveExamples));
      return this;
    }

    /**
     * Set the negativeExamples.
     *
     * @param negativeExamples the negativeExamples
     * @return the CreateClassifierOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder negativeExamples(File negativeExamples) throws FileNotFoundException {
      this.negativeExamples = new FileInputStream(negativeExamples);
      this.negativeExamplesFilename = negativeExamples.getName();
      return this;
    }
  }

  protected CreateClassifierOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((builder.negativeExamples == null)  || (builder.negativeExamplesFilename != null),
      "negativeExamplesFilename cannot be null if negativeExamples is not null.");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(builder.positiveExamples != null && !builder.positiveExamples.isEmpty(),
      "positiveExamples cannot be null or empty");
    name = builder.name;
    positiveExamples = builder.positiveExamples;
    negativeExamples = builder.negativeExamples;
    negativeExamplesFilename = builder.negativeExamplesFilename;
  }

  /**
   * New builder.
   *
   * @return a CreateClassifierOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the new classifier. Encode special characters in UTF-8.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the positiveExamples.
   *
   * A .zip file of images that depict the visual subject of a class in the new classifier. You can include more than
   * one positive example file in a call.
   *
   * Specify the parameter name by appending `_positive_examples` to the class name. For example,
   * `goldenretriever_positive_examples` creates the class **goldenretriever**. The string cannot contain the following
   * characters: ``$ * - { } \ | / ' " ` [ ]``.
   *
   * Include at least 10 images in .jpg or .png format. The minimum recommended image resolution is 32X32 pixels. The
   * maximum number of images is 10,000 images or 100 MB per .zip file.
   *
   * Encode special characters in the file name in UTF-8.
   *
   * @return the positiveExamples
   */
  public Map<String, InputStream> positiveExamples() {
    return positiveExamples;
  }

  /**
   * Gets the negativeExamples.
   *
   * A .zip file of images that do not depict the visual subject of any of the classes of the new classifier. Must
   * contain a minimum of 10 images.
   *
   * Encode special characters in the file name in UTF-8.
   *
   * @return the negativeExamples
   */
  public InputStream negativeExamples() {
    return negativeExamples;
  }

  /**
   * Gets the negativeExamplesFilename.
   *
   * The filename for negativeExamples.
   *
   * @return the negativeExamplesFilename
   */
  public String negativeExamplesFilename() {
    return negativeExamplesFilename;
  }
}


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
import java.util.HashMap;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The createClassifier options.
 */
public class CreateClassifierOptions extends GenericModel {

  private String name;
  private Map<String, InputStream> positiveExamples;
  private Map<String, String> positiveExamplesFilename;
  private InputStream negativeExamples;
  private String negativeExamplesFilename;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Map<String, InputStream> positiveExamples;
    private Map<String, String> positiveExamplesFilename;
    private InputStream negativeExamples;
    private String negativeExamplesFilename;

    private Builder(CreateClassifierOptions createClassifierOptions) {
      name = createClassifierOptions.name;
      positiveExamples = createClassifierOptions.positiveExamples;
      positiveExamplesFilename = createClassifierOptions.positiveExamplesFilename;
      negativeExamples = createClassifierOptions.negativeExamples;
      negativeExamplesFilename = createClassifierOptions.negativeExamplesFilename;
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
      Validator.notNull(classname, "classname cannot be null");
      Validator.notNull(positiveExamples, "positiveExamples cannot be null");
      if (this.positiveExamples == null) {
        this.positiveExamples = new HashMap<String, InputStream>();
      }
      this.positiveExamples.put(classname, positiveExamples);
      return this;
    }

    /**
     * Adds an entry to the positiveExamplesFilename map.
     *
     * @param classname the key associated with the map entry to be added
     * @param positiveExamplesFilename the value associated with the map entry to be added
     * @return the CreateClassifierOptions builder
     */
    public Builder addPositiveExamplesFilename(String classname, String positiveExamplesFilename) {
      Validator.notNull(classname, "classname cannot be null");
      Validator.notNull(positiveExamplesFilename, "positiveExamplesFilename cannot be null");
      if (this.positiveExamplesFilename == null) {
        this.positiveExamplesFilename = new HashMap<String, String>();
      }
      this.positiveExamplesFilename.put(classname, positiveExamplesFilename);
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
     * Set the positiveExamplesFilename.
     * Existing positiveExamplesFilename map will be replaced.
     *
     * @param positiveExamplesFilename the positiveExamplesFilename
     * @return the CreateClassifierOptions builder
     */
    public Builder positiveExamplesFilename(Map<String, String> positiveExamplesFilename) {
      this.positiveExamplesFilename = positiveExamplesFilename;
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
      this.addPositiveExamplesFilename(classname, positiveExamples.getName());
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

    /**
     * Adds a classifier with a name and positive examples. If the classifier name is already contained, the old
     * positive examples are replaced by the specified value.
     *
     * @param classname the class name
     * @param positiveExamples the positive examples
     * @return the builder
     * @throws FileNotFoundException if the file could not be found
     * @deprecated This method has been replaced by addPositiveExamples(String, File) and will be removed in the next
     *             major release
     */
    public Builder addClass(String classname, File positiveExamples) throws FileNotFoundException {
      return addPositiveExamples(classname, positiveExamples);
    }
  }

  private CreateClassifierOptions(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    Validator.isTrue((builder.negativeExamples == null) || (builder.negativeExamplesFilename != null),
        "negativeExamplesFilename cannot be null if negativeExamples is not null.");
    Validator.isTrue(builder.positiveExamples != null && !builder.positiveExamples.isEmpty(),
        "positiveExamples cannot be null or empty");
    name = builder.name;
    positiveExamples = builder.positiveExamples;
    positiveExamplesFilename = builder.positiveExamplesFilename;
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
   * `goldenretriever_positive_examples` creates the class **goldenretriever**.
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
   * Gets the positiveExamplesFilename.
   *
   * The filename for positiveExamples.
   *
   * @return the positiveExamplesFilename
   */
  public Map<String, String> positiveExamplesFilename() {
    return positiveExamplesFilename;
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

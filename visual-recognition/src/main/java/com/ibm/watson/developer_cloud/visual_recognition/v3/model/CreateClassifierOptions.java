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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createClassifier options.
 */
public class CreateClassifierOptions extends GenericModel {

  private String name;
  private Map<String, File> classnamePositiveExamples;
  private InputStream negativeExamples;
  private String negativeExamplesFilename;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Map<String, File> classnamePositiveExamples;
    private InputStream negativeExamples;
    private String negativeExamplesFilename;

    private Builder(CreateClassifierOptions createClassifierOptions) {
      name = createClassifierOptions.name;
      classnamePositiveExamples.putAll(createClassifierOptions.classnamePositiveExamples);
      negativeExamples = createClassifierOptions.negativeExamples;
      negativeExamplesFilename = createClassifierOptions.negativeExamplesFilename;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
      classnamePositiveExamples = new HashMap<String, File>();
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this();
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
     * Adds a classifier with a name and positive examples. If the classifier name is already contained, the old
     * positive examples are replaced by the specified value.
     *
     * @param className the class name
     * @param positiveExamples the positive examples
     * @return the builder
     */
    public Builder addClass(String className, File positiveExamples) {
      Validator.notNull(className, "'className' cannot be null");
      Validator.notNull(positiveExamples, "'positiveExamples' cannot be null");
      classnamePositiveExamples.put(className, positiveExamples);
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
     * Set the negativeExamples.
     *
     * @param negativeExamples the negativeExamples
     * @return the CreateClassifierOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder negativeExamples(File negativeExamples) throws FileNotFoundException {
      this.negativeExamples = new FileInputStream(negativeExamples);
      this.negativeExamplesFilename = negativeExamples.getName();
      return this;
    }
  }

  private CreateClassifierOptions(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    Validator.isTrue(!builder.classnamePositiveExamples.isEmpty(),
        "To create a classifier, you must supply at least one positive examples file.");
    name = builder.name;
    classnamePositiveExamples = builder.classnamePositiveExamples;
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
   * The name of the new classifier. Cannot contain special characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the class names.
   *
   * A compressed (.zip) file of images that depict the visual subject for a class within the new classifier. Must
   * contain a minimum of 10 images. The swagger limits you to training only one class. To train more classes, use the
   * API functionality.
   * @return the classNames
   */
  public Set<String> classNames() {
    return classnamePositiveExamples.keySet();
  }

  /**
   * Gets the positive examples by class name.
   *
   * @param className the class name
   * @return the positiveExamples
   */
  public File positiveExamplesByClassName(String className) {
    return classnamePositiveExamples.get(className);
  }

  /**
   * Gets the negativeExamples.
   *
   * A compressed (.zip) file of images that do not depict the visual subject of any of the classes of the new
   * classifier. Must contain a minimum of 10 images.
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

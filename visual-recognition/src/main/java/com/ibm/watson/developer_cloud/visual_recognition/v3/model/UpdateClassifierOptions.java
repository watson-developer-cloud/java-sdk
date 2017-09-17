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
 * The updateClassifier options.
 */
public class UpdateClassifierOptions extends GenericModel {

  private String classifierId;
  private Map<String, File> classnamePositiveExamples;
  private InputStream negativeExamples;
  private String negativeExamplesFilename;

  /**
   * Builder.
   */
  public static class Builder {
    private String classifierId;
    private Map<String, File> classnamePositiveExamples;
    private InputStream negativeExamples;
    private String negativeExamplesFilename;

    private Builder(UpdateClassifierOptions updateClassifierOptions) {
      classifierId = updateClassifierOptions.classifierId;
      classnamePositiveExamples.putAll(updateClassifierOptions.classnamePositiveExamples);
      negativeExamples = updateClassifierOptions.negativeExamples;
      negativeExamplesFilename = updateClassifierOptions.negativeExamplesFilename;
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
     * @param classifierId the classifierId
     */
    public Builder(String classifierId) {
      this();
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
     * Adds a classifier with a name and positive examples. If the classifier name is already contained, the old
     * positive examples are replaced by the specified value.
     *
     * @param className the class name
     * @param positiveExamples the positive examples
     * @return the UpdateClassifierOptions builder
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
     * Set the negativeExamples.
     *
     * @param negativeExamples the negativeExamples
     * @return the UpdateClassifierOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder negativeExamples(File negativeExamples) throws FileNotFoundException {
      this.negativeExamples = new FileInputStream(negativeExamples);
      this.negativeExamplesFilename = negativeExamples.getName();
      return this;
    }
  }

  private UpdateClassifierOptions(Builder builder) {
    Validator.notEmpty(builder.classifierId, "classifierId cannot be empty");
    Validator.isTrue(!builder.classnamePositiveExamples.isEmpty() || (builder.negativeExamples != null),
        "To update a classifier, you must supply at least one positive examples file or a negative examples file.");
    Validator.isTrue((builder.negativeExamples == null) || (builder.negativeExamplesFilename != null),
        "negativeExamplesFilename cannot be null if negativeExamples is not null.");
    classifierId = builder.classifierId;
    classnamePositiveExamples = builder.classnamePositiveExamples;
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
   * The ID of the classifier.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }

  /**
   * Gets the class names.
   *
   * @return the contentItems
   */
  public Set<String> classNames() {
    return classnamePositiveExamples.keySet();
  }

  /**
   * Gets the positive examples by class name.
   *
   * @param className the class name
   * @return the classes
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

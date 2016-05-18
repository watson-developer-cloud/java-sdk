/**
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
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ibm.watson.developer_cloud.util.Validator;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

/**
 * Create Classifier Options when using the
 * {@link VisualRecognition#createClassifier(CreateClassifierOptions)} method.
 */
public class CreateClassifierOptions {

  private File negativeExamples;
  private Map<String, File> positiveExamplesByName;
  private String classifierName;

  /**
   * Create Classifier Options Builder.
   */
  public static class Builder {
    private File negativeExamples;
    private Map<String, File> positiveExamplesByName;
    private String classifierName;

    private Builder(CreateClassifierOptions options) {
      this();
      this.classifierName = options.classifierName;
      this.negativeExamples = options.negativeExamples;
      this.positiveExamplesByName.putAll(options.positiveExamplesByName);
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
      positiveExamplesByName = new HashMap<String, File>();
    }

    /**
     * Adds a classifier with a name and positive examples. If the classifier name is already
     * contained, the old positive examples are replaced by the specified value.
     *
     * @param className the class name
     * @param positiveExamples the positive examples
     * @return the builder
     * @throws FileNotFoundException if the file does not exist, is a directory rather than a
     *         regular file, or for some other reason cannot be opened for reading.
     */
    public Builder addClass(String className, File positiveExamples) {
      Validator.notNull(className, "'className' cannot be null");
      Validator.notNull(positiveExamples, "'positiveExamples' cannot be null");

      positiveExamplesByName.put(className, positiveExamples);
      return this;
    }


    /**
     * Sets the negative examples.
     *
     * @param negativeExamples the negative examples
     * @return the builder
     */
    public Builder negativeExamples(File negativeExamples) {
      this.negativeExamples = negativeExamples;
      return this;
    }

    /**
     * Builds a <code>CreateClassifierOptions</code>.
     *
     * @return the creates the classifier options
     */
    public CreateClassifierOptions build() {
      return new CreateClassifierOptions(this);
    }

    /**
     * Classifier name.
     *
     * @param classifierName the classifier name
     * @return the builder
     */
    public Builder classifierName(String classifierName) {
      Validator.notNull(classifierName, "'classifierName' cannot be null");
      this.classifierName = classifierName;
      return this;
    }

  }

  private CreateClassifierOptions(Builder builder) {
    String errorMessage = "To create a classifier, you must supply at least 2 zip files - "
        + "either 2 positive example sets, or 1 positive and 1 negative set";

    Validator.notNull(builder.classifierName, "'classifierName' cannot be null");
    Validator.isTrue(!builder.positiveExamplesByName.isEmpty(), "There are no classes. " + errorMessage);

    boolean hasExamples = builder.positiveExamplesByName.size() > 1
        || (builder.negativeExamples != null && builder.positiveExamplesByName.size() == 1);
    Validator.isTrue(hasExamples, errorMessage);
    this.classifierName = builder.classifierName;
    this.negativeExamples = builder.negativeExamples;
    this.positiveExamplesByName = builder.positiveExamplesByName;
  }


  /**
   * Gets the content items.
   * 
   * @return the contentItems
   */
  public Set<String> classNames() {
    return positiveExamplesByName.keySet();
  }

  /**
   * Gets the positive examples by class name.
   *
   * @param className the class name
   * @return the classes
   */
  public File positiveExamplesByClassName(String className) {
    return positiveExamplesByName.get(className);
  }


  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }


  /**
   * Gets the classifier name.
   * 
   * @return the classifier name
   */
  public String classifierName() {
    return classifierName;
  }

  /**
   * Gets the negative examples.
   * 
   * @return the negative examples
   */
  public File negativeExamples() {
    return negativeExamples;
  }

}

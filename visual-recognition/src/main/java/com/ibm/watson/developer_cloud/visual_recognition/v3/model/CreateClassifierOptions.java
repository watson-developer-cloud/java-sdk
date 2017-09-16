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
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createClassifier options.
 */
public class CreateClassifierOptions extends GenericModel {

  private String name;
  private InputStream classnamePositiveExamples;
  private String classnamePositiveExamplesFilename;
  private InputStream negativeExamples;
  private String negativeExamplesFilename;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private InputStream classnamePositiveExamples;
    private String classnamePositiveExamplesFilename;
    private InputStream negativeExamples;
    private String negativeExamplesFilename;

    private Builder(CreateClassifierOptions createClassifierOptions) {
      name = createClassifierOptions.name;
      classnamePositiveExamples = createClassifierOptions.classnamePositiveExamples;
      classnamePositiveExamplesFilename = createClassifierOptions.classnamePositiveExamplesFilename;
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
     * @param classnamePositiveExamples the classnamePositiveExamples
     */
    public Builder(String name, InputStream classnamePositiveExamples) {
      this.name = name;
      this.classnamePositiveExamples = classnamePositiveExamples;
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
     * Set the classnamePositiveExamples.
     *
     * @param classnamePositiveExamples the classnamePositiveExamples
     * @return the CreateClassifierOptions builder
     */
    public Builder classnamePositiveExamples(InputStream classnamePositiveExamples) {
      this.classnamePositiveExamples = classnamePositiveExamples;
      return this;
    }

    /**
     * Set the classnamePositiveExamplesFilename.
     *
     * @param classnamePositiveExamplesFilename the classnamePositiveExamplesFilename
     * @return the CreateClassifierOptions builder
     */
    public Builder classnamePositiveExamplesFilename(String classnamePositiveExamplesFilename) {
      this.classnamePositiveExamplesFilename = classnamePositiveExamplesFilename;
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
     * Set the classnamePositiveExamples.
     *
     * @param classnamePositiveExamples the classnamePositiveExamples
     * @return the CreateClassifierOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder classnamePositiveExamples(File classnamePositiveExamples) throws FileNotFoundException {
      this.classnamePositiveExamples = new FileInputStream(classnamePositiveExamples);
      this.classnamePositiveExamplesFilename = classnamePositiveExamples.getName();
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
    Validator.notNull(builder.classnamePositiveExamples, "classnamePositiveExamples cannot be null");
    Validator.isTrue((builder.negativeExamples == null) || (builder.negativeExamplesFilename != null),
        "negativeExamplesFilename cannot be null if negativeExamples is not null.");
    name = builder.name;
    classnamePositiveExamples = builder.classnamePositiveExamples;
    classnamePositiveExamplesFilename = builder.classnamePositiveExamplesFilename;
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
   * Gets the classnamePositiveExamples.
   *
   * A compressed (.zip) file of images that depict the visual subject for a class within the new classifier. Must
   * contain a minimum of 10 images. The swagger limits you to training only one class. To train more classes, use the
   * API functionality.
   *
   * @return the classnamePositiveExamples
   */
  public InputStream classnamePositiveExamples() {
    return classnamePositiveExamples;
  }

  /**
   * Gets the classnamePositiveExamplesFilename.
   *
   * The filename for classnamePositiveExamples.
   *
   * @return the classnamePositiveExamplesFilename
   */
  public String classnamePositiveExamplesFilename() {
    return classnamePositiveExamplesFilename;
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

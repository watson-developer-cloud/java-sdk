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
package com.ibm.watson.natural_language_classifier.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The classifyCollection options.
 */
public class ClassifyCollectionOptions extends GenericModel {

  protected String classifierId;
  protected List<ClassifyInput> collection;

  /**
   * Builder.
   */
  public static class Builder {
    private String classifierId;
    private List<ClassifyInput> collection;

    private Builder(ClassifyCollectionOptions classifyCollectionOptions) {
      this.classifierId = classifyCollectionOptions.classifierId;
      this.collection = classifyCollectionOptions.collection;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param classifierId the classifierId
     * @param collection the collection
     */
    public Builder(String classifierId, List<ClassifyInput> collection) {
      this.classifierId = classifierId;
      this.collection = collection;
    }

    /**
     * Builds a ClassifyCollectionOptions.
     *
     * @return the classifyCollectionOptions
     */
    public ClassifyCollectionOptions build() {
      return new ClassifyCollectionOptions(this);
    }

    /**
     * Adds an classifyInput to collection.
     *
     * @param classifyInput the new classifyInput
     * @return the ClassifyCollectionOptions builder
     */
    public Builder addClassifyInput(ClassifyInput classifyInput) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(classifyInput,
          "classifyInput cannot be null");
      if (this.collection == null) {
        this.collection = new ArrayList<ClassifyInput>();
      }
      this.collection.add(classifyInput);
      return this;
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the ClassifyCollectionOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }

    /**
     * Set the collection.
     * Existing collection will be replaced.
     *
     * @param collection the collection
     * @return the ClassifyCollectionOptions builder
     */
    public Builder collection(List<ClassifyInput> collection) {
      this.collection = collection;
      return this;
    }
  }

  protected ClassifyCollectionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.classifierId,
        "classifierId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.collection,
        "collection cannot be null");
    classifierId = builder.classifierId;
    collection = builder.collection;
  }

  /**
   * New builder.
   *
   * @return a ClassifyCollectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the classifierId.
   *
   * Classifier ID to use.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }

  /**
   * Gets the collection.
   *
   * The submitted phrases.
   *
   * @return the collection
   */
  public List<ClassifyInput> collection() {
    return collection;
  }
}

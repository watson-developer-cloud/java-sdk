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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The classify options.
 */
public class ClassifyOptions extends GenericModel {

  protected String classifierId;
  protected String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String classifierId;
    private String text;

    private Builder(ClassifyOptions classifyOptions) {
      this.classifierId = classifyOptions.classifierId;
      this.text = classifyOptions.text;
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
     * @param text the text
     */
    public Builder(String classifierId, String text) {
      this.classifierId = classifierId;
      this.text = text;
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
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the ClassifyOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the ClassifyOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected ClassifyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.classifierId,
        "classifierId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
        "text cannot be null");
    classifierId = builder.classifierId;
    text = builder.text;
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
   * Gets the text.
   *
   * The submitted phrase. The maximum length is 2048 characters.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}

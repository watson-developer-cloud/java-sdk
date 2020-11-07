/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

/** Request payload to classify. */
public class ClassifyInput extends GenericModel {

  protected String text;

  /** Builder. */
  public static class Builder {
    private String text;

    private Builder(ClassifyInput classifyInput) {
      this.text = classifyInput.text;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     */
    public Builder(String text) {
      this.text = text;
    }

    /**
     * Builds a ClassifyInput.
     *
     * @return the new ClassifyInput instance
     */
    public ClassifyInput build() {
      return new ClassifyInput(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the ClassifyInput builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected ClassifyInput(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a ClassifyInput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * <p>The submitted phrase. The maximum length is 2048 characters.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}

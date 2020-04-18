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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** An alternative value for the recognized entity. */
public class RuntimeEntityAlternative extends GenericModel {

  protected String value;
  protected Double confidence;

  /** Builder. */
  public static class Builder {
    private String value;
    private Double confidence;

    private Builder(RuntimeEntityAlternative runtimeEntityAlternative) {
      this.value = runtimeEntityAlternative.value;
      this.confidence = runtimeEntityAlternative.confidence;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a RuntimeEntityAlternative.
     *
     * @return the runtimeEntityAlternative
     */
    public RuntimeEntityAlternative build() {
      return new RuntimeEntityAlternative(this);
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the RuntimeEntityAlternative builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the confidence.
     *
     * @param confidence the confidence
     * @return the RuntimeEntityAlternative builder
     */
    public Builder confidence(Double confidence) {
      this.confidence = confidence;
      return this;
    }
  }

  protected RuntimeEntityAlternative(Builder builder) {
    value = builder.value;
    confidence = builder.confidence;
  }

  /**
   * New builder.
   *
   * @return a RuntimeEntityAlternative builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the value.
   *
   * <p>The entity value that was recognized in the user input.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the confidence.
   *
   * <p>A decimal percentage that represents Watson's confidence in the recognized entity.
   *
   * @return the confidence
   */
  public Double confidence() {
    return confidence;
  }
}

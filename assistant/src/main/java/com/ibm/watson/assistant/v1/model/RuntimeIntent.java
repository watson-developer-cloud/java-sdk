/*
 * (C) Copyright IBM Corp. 2017, 2023.
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
package com.ibm.watson.assistant.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** An intent identified in the user input. */
public class RuntimeIntent extends GenericModel {

  protected String intent;
  protected Double confidence;

  /** Builder. */
  public static class Builder {
    private String intent;
    private Double confidence;

    /**
     * Instantiates a new Builder from an existing RuntimeIntent instance.
     *
     * @param runtimeIntent the instance to initialize the Builder with
     */
    private Builder(RuntimeIntent runtimeIntent) {
      this.intent = runtimeIntent.intent;
      this.confidence = runtimeIntent.confidence;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param intent the intent
     */
    public Builder(String intent) {
      this.intent = intent;
    }

    /**
     * Builds a RuntimeIntent.
     *
     * @return the new RuntimeIntent instance
     */
    public RuntimeIntent build() {
      return new RuntimeIntent(this);
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the RuntimeIntent builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the confidence.
     *
     * @param confidence the confidence
     * @return the RuntimeIntent builder
     */
    public Builder confidence(Double confidence) {
      this.confidence = confidence;
      return this;
    }
  }

  protected RuntimeIntent() {}

  protected RuntimeIntent(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.intent, "intent cannot be null");
    intent = builder.intent;
    confidence = builder.confidence;
  }

  /**
   * New builder.
   *
   * @return a RuntimeIntent builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the intent.
   *
   * <p>The name of the recognized intent.
   *
   * @return the intent
   */
  public String intent() {
    return intent;
  }

  /**
   * Gets the confidence.
   *
   * <p>A decimal percentage that represents Watson's confidence in the intent. If you are
   * specifying an intent as part of a request, but you do not have a calculated confidence value,
   * specify `1`.
   *
   * @return the confidence
   */
  public Double confidence() {
    return confidence;
  }
}

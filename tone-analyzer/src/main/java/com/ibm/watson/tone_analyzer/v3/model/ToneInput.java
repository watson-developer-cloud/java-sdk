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
package com.ibm.watson.tone_analyzer.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * ToneInput.
 */
public class ToneInput extends GenericModel {

  private String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;

    private Builder(ToneInput toneInput) {
      this.text = toneInput.text;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     */
    public Builder(String text) {
      this.text = text;
    }

    /**
     * Builds a ToneInput.
     *
     * @return the toneInput
     */
    public ToneInput build() {
      return new ToneInput(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the ToneInput builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  private ToneInput(Builder builder) {
    Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a ToneInput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * The input content that the service is to analyze.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}

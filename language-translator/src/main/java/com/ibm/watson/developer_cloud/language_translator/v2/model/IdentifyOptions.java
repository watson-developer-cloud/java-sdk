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
package com.ibm.watson.developer_cloud.language_translator.v2.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * the identify options.
 */
public class IdentifyOptions extends GenericModel {

  private String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;

    private Builder(IdentifyOptions identifyOptions) {
      text = identifyOptions.text;
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
     * Builds a IdentifyOptions.
     *
     * @return the identifyOptions
     */
    public IdentifyOptions build() {
      return new IdentifyOptions(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the IdentifyOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  private IdentifyOptions(Builder builder) {
    Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a IdentifyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * Input text in UTF-8 format.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}

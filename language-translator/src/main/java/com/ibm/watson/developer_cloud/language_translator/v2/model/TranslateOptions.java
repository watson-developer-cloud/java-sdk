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
package com.ibm.watson.developer_cloud.language_translator.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The translate options.
 */
public class TranslateOptions extends GenericModel {

  private List<String> text;
  private String modelId;
  private String source;
  private String target;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> text;
    private String modelId;
    private String source;
    private String target;

    private Builder(TranslateOptions translateOptions) {
      text = translateOptions.text;
      modelId = translateOptions.modelId;
      source = translateOptions.source;
      target = translateOptions.target;
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
    public Builder(List<String> text) {
      this.text = text;
    }

    /**
     * Builds a TranslateOptions.
     *
     * @return the translateOptions
     */
    public TranslateOptions build() {
      return new TranslateOptions(this);
    }

    /**
     * Adds an text to text.
     *
     * @param text the new text
     * @return the TranslateOptions builder
     */
    public Builder addText(String text) {
      Validator.notNull(text, "text cannot be null");
      if (this.text == null) {
        this.text = new ArrayList<String>();
      }
      this.text.add(text);
      return this;
    }

    /**
     * Set the text.
     * Existing text will be replaced.
     *
     * @param text the text
     * @return the TranslateOptions builder
     */
    public Builder text(List<String> text) {
      this.text = text;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the TranslateOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the TranslateOptions builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the TranslateOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }
  }

  private TranslateOptions(Builder builder) {
    Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
    modelId = builder.modelId;
    source = builder.source;
    target = builder.target;
  }

  /**
   * New builder.
   *
   * @return a TranslateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * Input text in UTF-8 encoding. Multiple entries will result in multiple translations in the response.
   *
   * @return the text
   */
  public List<String> text() {
    return text;
  }

  /**
   * Gets the modelId.
   *
   * Model ID of the translation model to use. If this is specified, the `source` and `target` parameters will be
   * ignored. The method requires either a model ID or both the `source` and `target` parameters.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }

  /**
   * Gets the source.
   *
   * Language code of the source text language. Use with `target` as an alternative way to select a translation model.
   * When `source` and `target` are set, and a model ID is not set, the system chooses a default model for the language
   * pair (usually the model based on the news domain).
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the target.
   *
   * Language code of the translation target language. Use with source as an alternative way to select a translation
   * model.
   *
   * @return the target
   */
  public String target() {
    return target;
  }
}

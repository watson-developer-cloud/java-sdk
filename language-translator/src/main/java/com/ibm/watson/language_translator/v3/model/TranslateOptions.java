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
package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The translate options. */
public class TranslateOptions extends GenericModel {

  protected List<String> text;
  protected String modelId;
  protected String source;
  protected String target;

  /** Builder. */
  public static class Builder {
    private List<String> text;
    private String modelId;
    private String source;
    private String target;

    private Builder(TranslateOptions translateOptions) {
      this.text = translateOptions.text;
      this.modelId = translateOptions.modelId;
      this.source = translateOptions.source;
      this.target = translateOptions.target;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
      com.ibm.cloud.sdk.core.util.Validator.notNull(text, "text cannot be null");
      if (this.text == null) {
        this.text = new ArrayList<String>();
      }
      this.text.add(text);
      return this;
    }

    /**
     * Set the text. Existing text will be replaced.
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

  protected TranslateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
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
   * <p>Input text in UTF-8 encoding. Multiple entries result in multiple translations in the
   * response.
   *
   * @return the text
   */
  public List<String> text() {
    return text;
  }

  /**
   * Gets the modelId.
   *
   * <p>The model to use for translation. For example, `en-de` selects the IBM-provided base model
   * for English-to-German translation. A model ID overrides the `source` and `target` parameters
   * and is required if you use a custom model. If no model ID is specified, you must specify at
   * least a target language.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }

  /**
   * Gets the source.
   *
   * <p>Language code that specifies the language of the input text. If omitted, the service derives
   * the source language from the input text. The input must contain sufficient text for the service
   * to identify the language reliably.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the target.
   *
   * <p>Language code that specifies the target language for translation. Required if model ID is
   * not specified.
   *
   * @return the target
   */
  public String target() {
    return target;
  }
}

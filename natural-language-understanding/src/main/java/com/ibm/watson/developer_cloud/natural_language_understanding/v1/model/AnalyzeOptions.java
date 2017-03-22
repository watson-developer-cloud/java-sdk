/**
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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * An object containing request parameters.
 */
public class AnalyzeOptions extends GenericModel {

  /** The plain text to analyze. */
  private String text;
  /** The HTML file to analyze. */
  private String html;
  /** The web page to analyze. */
  private String url;
  /** Specific features to analyze the document for. */
  private Features features;
  /** Remove website elements, such as links, ads, etc. */
  private Boolean clean;
  /** XPath query for targeting nodes in HTML. */
  private String xpath;
  /** Whether to use raw HTML content if text cleaning fails. */
  @SerializedName("fallback_to_raw")
  private Boolean fallbackToRaw;
  /** Whether or not to return the analyzed text. */
  @SerializedName("return_analyzed_text")
  private Boolean returnAnalyzedText;
  /** ISO 639-1 code indicating the language to use in the analysis. */
  private String language;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;
    private String html;
    private String url;
    private Features features;
    private Boolean clean;
    private String xpath;
    private Boolean fallbackToRaw;
    private Boolean returnAnalyzedText;
    private String language;

    private Builder(AnalyzeOptions parameters) {
      text = parameters.text;
      html = parameters.html;
      url = parameters.url;
      features = parameters.features;
      clean = parameters.clean;
      xpath = parameters.xpath;
      fallbackToRaw = parameters.fallbackToRaw;
      returnAnalyzedText = parameters.returnAnalyzedText;
      language = parameters.language;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the Parameters.
     *
     * @return the parameters
     */
    public AnalyzeOptions build() {
      return new AnalyzeOptions(this);
    }

    /**
     * Add the text.
     *
     * @param text the text
     * @return a Parameters Builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Add the html.
     *
     * @param html the html
     * @return a Parameters Builder
     */
    public Builder html(String html) {
      this.html = html;
      return this;
    }

    /**
     * Add the url.
     *
     * @param url the url
     * @return a Parameters Builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Add the features.
     *
     * @param features the features
     * @return a Parameters Builder
     */
    public Builder features(Features features) {
      this.features = features;
      return this;
    }

    /**
     * Add the clean.
     *
     * @param clean the clean
     * @return a Parameters Builder
     */
    public Builder clean(Boolean clean) {
      this.clean = clean;
      return this;
    }

    /**
     * Add the xpath.
     *
     * @param xpath the xpath
     * @return a Parameters Builder
     */
    public Builder xpath(String xpath) {
      this.xpath = xpath;
      return this;
    }

    /**
     * Add the fallbackToRaw.
     *
     * @param fallbackToRaw the fallbackToRaw
     * @return a Parameters Builder
     */
    public Builder fallbackToRaw(Boolean fallbackToRaw) {
      this.fallbackToRaw = fallbackToRaw;
      return this;
    }

    /**
     * Add the returnAnalyzedText.
     *
     * @param returnAnalyzedText the returnAnalyzedText
     * @return a Parameters Builder
     */
    public Builder returnAnalyzedText(Boolean returnAnalyzedText) {
      this.returnAnalyzedText = returnAnalyzedText;
      return this;
    }

    /**
     * Add the language.
     *
     * @param language the language
     * @return a Parameters Builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }
  }

  private AnalyzeOptions(Builder builder) {
    Validator.notNull(builder.features, "features cannot be null");
    Validator.notNull(builder.text != null && (builder.url != null || builder.html != null),
       "Only text, html or url can be specified");
    Validator.notNull(builder.url != null && (builder.text != null || builder.html != null),
        "Only text, html or url can be specified");
    Validator.notNull(builder.html != null && (builder.url != null || builder.text != null),
        "Only text, html or url can be specified");

    text = builder.text;
    html = builder.html;
    url = builder.url;
    features = builder.features;
    clean = builder.clean;
    xpath = builder.xpath;
    fallbackToRaw = builder.fallbackToRaw;
    returnAnalyzedText = builder.returnAnalyzedText;
    language = builder.language;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the html.
   *
   * @return the html
   */
  public String html() {
    return html;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the features.
   *
   * @return the features
   */
  public Features features() {
    return features;
  }

  /**
   * Gets the clean.
   *
   * @return the clean
   */
  public Boolean clean() {
    return clean;
  }

  /**
   * Gets the xpath.
   *
   * @return the xpath
   */
  public String xpath() {
    return xpath;
  }

  /**
   * Gets the fallbackToRaw.
   *
   * @return the fallbackToRaw
   */
  public Boolean fallbackToRaw() {
    return fallbackToRaw;
  }

  /**
   * Gets the returnAnalyzedText.
   *
   * @return the returnAnalyzedText
   */
  public Boolean returnAnalyzedText() {
    return returnAnalyzedText;
  }

  /**
   * Gets the language.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

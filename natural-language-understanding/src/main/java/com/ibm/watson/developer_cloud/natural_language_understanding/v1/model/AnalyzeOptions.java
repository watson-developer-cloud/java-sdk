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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The analyze options.
 */
public class AnalyzeOptions extends GenericModel {

  private String text;
  private String html;
  private String url;
  private Features features;
  private Boolean clean;
  private String xpath;
  private Boolean fallbackToRaw;
  private Boolean returnAnalyzedText;
  private String language;
  private Long limitTextCharacters;

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
    private Long limitTextCharacters;

    private Builder(AnalyzeOptions analyzeOptions) {
      text = analyzeOptions.text;
      html = analyzeOptions.html;
      url = analyzeOptions.url;
      features = analyzeOptions.features;
      clean = analyzeOptions.clean;
      xpath = analyzeOptions.xpath;
      fallbackToRaw = analyzeOptions.fallbackToRaw;
      returnAnalyzedText = analyzeOptions.returnAnalyzedText;
      language = analyzeOptions.language;
      limitTextCharacters = analyzeOptions.limitTextCharacters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param features the features
     */
    public Builder(Features features) {
      this.features = features;
    }

    /**
     * Builds a AnalyzeOptions.
     *
     * @return the analyzeOptions
     */
    public AnalyzeOptions build() {
      return new AnalyzeOptions(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the AnalyzeOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the html.
     *
     * @param html the html
     * @return the AnalyzeOptions builder
     */
    public Builder html(String html) {
      this.html = html;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the AnalyzeOptions builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the features.
     *
     * @param features the features
     * @return the AnalyzeOptions builder
     */
    public Builder features(Features features) {
      this.features = features;
      return this;
    }

    /**
     * Set the clean.
     *
     * @param clean the clean
     * @return the AnalyzeOptions builder
     */
    public Builder clean(Boolean clean) {
      this.clean = clean;
      return this;
    }

    /**
     * Set the xpath.
     *
     * @param xpath the xpath
     * @return the AnalyzeOptions builder
     */
    public Builder xpath(String xpath) {
      this.xpath = xpath;
      return this;
    }

    /**
     * Set the fallbackToRaw.
     *
     * @param fallbackToRaw the fallbackToRaw
     * @return the AnalyzeOptions builder
     */
    public Builder fallbackToRaw(Boolean fallbackToRaw) {
      this.fallbackToRaw = fallbackToRaw;
      return this;
    }

    /**
     * Set the returnAnalyzedText.
     *
     * @param returnAnalyzedText the returnAnalyzedText
     * @return the AnalyzeOptions builder
     */
    public Builder returnAnalyzedText(Boolean returnAnalyzedText) {
      this.returnAnalyzedText = returnAnalyzedText;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the AnalyzeOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the limitTextCharacters.
     *
     * @param limitTextCharacters the limitTextCharacters
     * @return the AnalyzeOptions builder
     */
    public Builder limitTextCharacters(long limitTextCharacters) {
      this.limitTextCharacters = limitTextCharacters;
      return this;
    }
  }

  private AnalyzeOptions(Builder builder) {
    Validator.notNull(builder.features, "features cannot be null");
    text = builder.text;
    html = builder.html;
    url = builder.url;
    features = builder.features;
    clean = builder.clean;
    xpath = builder.xpath;
    fallbackToRaw = builder.fallbackToRaw;
    returnAnalyzedText = builder.returnAnalyzedText;
    language = builder.language;
    limitTextCharacters = builder.limitTextCharacters;
  }

  /**
   * New builder.
   *
   * @return a AnalyzeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * The plain text to analyze
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the html.
   *
   * The HTML file to analyze
   *
   * @return the html
   */
  public String html() {
    return html;
  }

  /**
   * Gets the url.
   *
   * The web page to analyze
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the features.
   *
   * Specific features to analyze the document for
   *
   * @return the features
   */
  public Features features() {
    return features;
  }

  /**
   * Gets the clean.
   *
   * Remove website elements, such as links, ads, etc
   *
   * @return the clean
   */
  public Boolean clean() {
    return clean;
  }

  /**
   * Gets the xpath.
   *
   * XPath query for targeting nodes in HTML
   *
   * @return the xpath
   */
  public String xpath() {
    return xpath;
  }

  /**
   * Gets the fallbackToRaw.
   *
   * Whether to use raw HTML content if text cleaning fails
   *
   * @return the fallbackToRaw
   */
  public Boolean fallbackToRaw() {
    return fallbackToRaw;
  }

  /**
   * Gets the returnAnalyzedText.
   *
   * Whether or not to return the analyzed text
   *
   * @return the returnAnalyzedText
   */
  public Boolean returnAnalyzedText() {
    return returnAnalyzedText;
  }

  /**
   * Gets the language.
   *
   * ISO 639-1 code indicating the language to use in the analysis
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the limitTextCharacters.
   *
   * Sets the maximum number of characters that are processed by the service.
   *
   * @return the limitTextCharacters
   */
  public Long limitTextCharacters() {
    return limitTextCharacters;
  }
}

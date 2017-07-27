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

/**
 * the analyze options.
 */
public class AnalyzeOptions extends GenericModel {

  /** Specific features to analyze the document for. */
  private Features features;
  /** XPath query for targeting nodes in HTML. */
  private String xpath;
  /** Whether or not to return the analyzed text. */
  private Boolean returnAnalyzedText;
  /** ISO 639-1 code indicating the language to use in the analysis. */
  private String language;
  /** The HTML file to analyze. */
  private String html;
  /** The plain text to analyze. */
  private String text;
  /** Remove website elements, such as links, ads, etc. */
  private Boolean clean;
  /** The web page to analyze. */
  private String url;
  /** Whether to use raw HTML content if text cleaning fails. */
  private Boolean fallbackToRaw;

  /**
   * Builder.
   */
  public static class Builder {
    private Features features;
    private String xpath;
    private Boolean returnAnalyzedText;
    private String language;
    private String html;
    private String text;
    private Boolean clean;
    private String url;
    private Boolean fallbackToRaw;

    private Builder(AnalyzeOptions analyzeOptions) {
      features = analyzeOptions.features;
      xpath = analyzeOptions.xpath;
      returnAnalyzedText = analyzeOptions.returnAnalyzedText;
      language = analyzeOptions.language;
      html = analyzeOptions.html;
      text = analyzeOptions.text;
      clean = analyzeOptions.clean;
      url = analyzeOptions.url;
      fallbackToRaw = analyzeOptions.fallbackToRaw;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
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
     * Set the fallbackToRaw.
     *
     * @param fallbackToRaw the fallbackToRaw
     * @return the AnalyzeOptions builder
     */
    public Builder fallbackToRaw(Boolean fallbackToRaw) {
      this.fallbackToRaw = fallbackToRaw;
      return this;
    }
  }

  private AnalyzeOptions(Builder builder) {
    features = builder.features;
    xpath = builder.xpath;
    returnAnalyzedText = builder.returnAnalyzedText;
    language = builder.language;
    html = builder.html;
    text = builder.text;
    clean = builder.clean;
    url = builder.url;
    fallbackToRaw = builder.fallbackToRaw;
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
   * Gets the features.
   *
   * @return the features
   */
  public Features features() {
    return features;
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
   * Gets the html.
   *
   * @return the html
   */
  public String html() {
    return html;
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
   * Gets the clean.
   *
   * @return the clean
   */
  public Boolean clean() {
    return clean;
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
   * Gets the fallbackToRaw.
   *
   * @return the fallbackToRaw
   */
  public Boolean fallbackToRaw() {
    return fallbackToRaw;
  }
}

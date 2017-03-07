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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An object containing request parameters.
 */
public class Parameters extends GenericModel {

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
   * Instantiates a new `Parameters`
   *
   * @param text The plain text to analyze.
   * @param html The HTML file to analyze.
   * @param url The web page to analyze.
   * @param features Specific features to analyze the document for.
   * @param clean Remove website elements, such as links, ads, etc.
   * @param xpath XPath query for targeting nodes in HTML.
   * @param fallbackToRaw Whether to use raw HTML content if text cleaning fails.
   * @param returnAnalyzedText Whether or not to return the analyzed text.
   * @param language ISO 639-1 code indicating the language to use in the analysis.
   */
  public Parameters(final String text, final String html, final String url, final Features features, final Boolean clean, final String xpath, final Boolean fallbackToRaw, final Boolean returnAnalyzedText, final String language) {
    this.text = text;
    this.html = html;
    this.url = url;
    this.features = features;
    this.clean = clean;
    this.xpath = xpath;
    this.fallbackToRaw = fallbackToRaw;
    this.returnAnalyzedText = returnAnalyzedText;
    this.language = language;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the html.
   *
   * @return the html
   */
  public String getHtml() {
    return html;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the features.
   *
   * @return the features
   */
  public Features getFeatures() {
    return features;
  }

  /**
   * Gets the clean.
   *
   * @return the clean
   */
  public Boolean isClean() {
    return clean;
  }

  /**
   * Gets the xpath.
   *
   * @return the xpath
   */
  public String getXpath() {
    return xpath;
  }

  /**
   * Gets the fallbackToRaw.
   *
   * @return the fallbackToRaw
   */
  public Boolean isFallbackToRaw() {
    return fallbackToRaw;
  }

  /**
   * Gets the returnAnalyzedText.
   *
   * @return the returnAnalyzedText
   */
  public Boolean isReturnAnalyzedText() {
    return returnAnalyzedText;
  }

  /**
   * Gets the language.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Sets the html.
   *
   * @param html the new html
   */
  public void setHtml(final String html) {
    this.html = html;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(final String url) {
    this.url = url;
  }

  /**
   * Sets the features.
   *
   * @param features the new features
   */
  public void setFeatures(final Features features) {
    this.features = features;
  }

  /**
   * Sets the clean.
   *
   * @param clean the new clean
   */
  public void setClean(final Boolean clean) {
    this.clean = clean;
  }

  /**
   * Sets the xpath.
   *
   * @param xpath the new xpath
   */
  public void setXpath(final String xpath) {
    this.xpath = xpath;
  }

  /**
   * Sets the fallbackToRaw.
   *
   * @param fallbackToRaw the new fallbackToRaw
   */
  public void setFallbackToRaw(final Boolean fallbackToRaw) {
    this.fallbackToRaw = fallbackToRaw;
  }

  /**
   * Sets the returnAnalyzedText.
   *
   * @param returnAnalyzedText the new returnAnalyzedText
   */
  public void setReturnAnalyzedText(final Boolean returnAnalyzedText) {
    this.returnAnalyzedText = returnAnalyzedText;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

}

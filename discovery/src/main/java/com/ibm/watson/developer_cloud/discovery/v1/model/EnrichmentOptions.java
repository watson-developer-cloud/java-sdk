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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Options which are specific to a particular enrichment.
 */
public class EnrichmentOptions extends GenericModel {

  /**
   * If provided, then do not attempt to detect the language of the input document. Instead, assume the language is the
   * one specified in this field. You can set this property to work around `unsupported-text-language` errors. Supported
   * languages include English, German, French, Italian, Portuguese, Russian, Spanish and Swedish. Supported language
   * codes are the ISO-639-1, ISO-639-2, ISO-639-3, and the plain english name of the language (for example "russian").
   */
  public interface Language {
    /** english. */
    String ENGLISH = "english";
    /** german. */
    String GERMAN = "german";
    /** french. */
    String FRENCH = "french";
    /** italian. */
    String ITALIAN = "italian";
    /** portuguese. */
    String PORTUGUESE = "portuguese";
    /** russian. */
    String RUSSIAN = "russian";
    /** spanish. */
    String SPANISH = "spanish";
    /** swedish. */
    String SWEDISH = "swedish";
    /** en. */
    String EN = "en";
    /** eng. */
    String ENG = "eng";
    /** de. */
    String DE = "de";
    /** ger. */
    String GER = "ger";
    /** deu. */
    String DEU = "deu";
    /** fr. */
    String FR = "fr";
    /** fre. */
    String FRE = "fre";
    /** fra. */
    String FRA = "fra";
    /** it. */
    String IT = "it";
    /** ita. */
    String ITA = "ita";
    /** pt. */
    String PT = "pt";
    /** por. */
    String POR = "por";
    /** ru. */
    String RU = "ru";
    /** rus. */
    String RUS = "rus";
    /** es. */
    String ES = "es";
    /** spa. */
    String SPA = "spa";
    /** sv. */
    String SV = "sv";
    /** swe. */
    String SWE = "swe";
  }

  private List<String> extract;
  private Boolean sentiment;
  private Boolean quotations;
  private Boolean showSourceText;
  private Boolean hierarchicalTypedRelations;
  private String model;
  private String language;

  /**
   * Gets the extract.
   *
   * A comma-separated list of analyses that will be applied when using the `alchemy_language` enrichment. See the
   * service documentation for details on each extract option. Possible values include: * entity * keyword * taxonomy *
   * concept * relation * doc-sentiment * doc-emotion * typed-rels
   *
   * @return the extract
   */
  public List<String> getExtract() {
    return extract;
  }

  /**
   * Gets the sentiment.
   *
   * @return the sentiment
   */
  public Boolean isSentiment() {
    return sentiment;
  }

  /**
   * Gets the quotations.
   *
   * @return the quotations
   */
  public Boolean isQuotations() {
    return quotations;
  }

  /**
   * Gets the showSourceText.
   *
   * @return the showSourceText
   */
  public Boolean isShowSourceText() {
    return showSourceText;
  }

  /**
   * Gets the hierarchicalTypedRelations.
   *
   * @return the hierarchicalTypedRelations
   */
  public Boolean isHierarchicalTypedRelations() {
    return hierarchicalTypedRelations;
  }

  /**
   * Gets the model.
   *
   * Required when using the `typed-rel` extract option. Should be set to the ID of a previously published custom Watson
   * Knowledge Studio model.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Gets the language.
   *
   * If provided, then do not attempt to detect the language of the input document. Instead, assume the language is the
   * one specified in this field. You can set this property to work around `unsupported-text-language` errors. Supported
   * languages include English, German, French, Italian, Portuguese, Russian, Spanish and Swedish. Supported language
   * codes are the ISO-639-1, ISO-639-2, ISO-639-3, and the plain english name of the language (for example "russian").
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Sets the extract.
   *
   * @param extract the new extract
   */
  public void setExtract(final List<String> extract) {
    this.extract = extract;
  }

  /**
   * Sets the sentiment.
   *
   * @param sentiment the new sentiment
   */
  public void setSentiment(final Boolean sentiment) {
    this.sentiment = sentiment;
  }

  /**
   * Sets the quotations.
   *
   * @param quotations the new quotations
   */
  public void setQuotations(final Boolean quotations) {
    this.quotations = quotations;
  }

  /**
   * Sets the showSourceText.
   *
   * @param showSourceText the new showSourceText
   */
  public void setShowSourceText(final Boolean showSourceText) {
    this.showSourceText = showSourceText;
  }

  /**
   * Sets the hierarchicalTypedRelations.
   *
   * @param hierarchicalTypedRelations the new hierarchicalTypedRelations
   */
  public void setHierarchicalTypedRelations(final Boolean hierarchicalTypedRelations) {
    this.hierarchicalTypedRelations = hierarchicalTypedRelations;
  }

  /**
   * Sets the model.
   *
   * @param model the new model
   */
  public void setModel(final String model) {
    this.model = model;
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

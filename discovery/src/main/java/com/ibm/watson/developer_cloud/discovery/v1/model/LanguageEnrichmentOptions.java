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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * options specific to the `alchemy_language` enrichment.
 */
public class LanguageEnrichmentOptions extends GenericModel {

  /**
   * If provided, then do not attempt to detect the language of the input document. Instead, assume the language is the one specified in this field.  You can set this property to work around `unsupported-text-language` errors.  Supported languages include English, German, French, Italian, Portuguese, Russian, Spanish and Swedish. Supported language codes are the ISO-639-1, ISO-639-2, ISO-639-3, and the plain english name of the language (e.g. "russian").
   */
  public enum Language {

    /** english. */
    @SerializedName("english") ENGLISH,

    /** german. */
    @SerializedName("german") GERMAN,

    /** french. */
    @SerializedName("french") FRENCH,

    /** italian. */
    @SerializedName("italian") ITALIAN,

    /** portuguese. */
    @SerializedName("portuguese") PORTUGUESE,

    /** russian. */
    @SerializedName("russian") RUSSIAN,

    /** spanish. */
    @SerializedName("spanish") SPANISH,

    /** swedish. */
    @SerializedName("swedish") SWEDISH,

    /** en. */
    @SerializedName("en") EN,

    /** eng. */
    @SerializedName("eng") ENG,

    /** de. */
    @SerializedName("de") DE,

    /** ger. */
    @SerializedName("ger") GER,

    /** deu. */
    @SerializedName("deu") DEU,

    /** fr. */
    @SerializedName("fr") FR,

    /** fre. */
    @SerializedName("fre") FRE,

    /** fra. */
    @SerializedName("fra") FRA,

    /** it. */
    @SerializedName("it") IT,

    /** ita. */
    @SerializedName("ita") ITA,

    /** pt. */
    @SerializedName("pt") PT,

    /** por. */
    @SerializedName("por") POR,

    /** ru. */
    @SerializedName("ru") RU,

    /** rus. */
    @SerializedName("rus") RUS,

    /** es. */
    @SerializedName("es") ES,

    /** spa. */
    @SerializedName("spa") SPA,

    /** sv. */
    @SerializedName("sv") SV,

    /** swe. */
    @SerializedName("swe") SWE
  }

  /** A comma sepeated list of analyses that should be applied when using the `alchemy_language` enrichment. See the the service documentation for details on each extract option.  Possible values include:    * entity   * keyword   * taxonomy   * concept   * relation   * doc-sentiment   * doc-emotion   * typed-rels. */
  private String extract;
  private Boolean sentiment;
  private Boolean quotations;
  private Boolean showSourceText;
  private Boolean hierarchicalTypedRelations;
  /** Required when using the `typed-rel` extract option. Should be set to the ID of a previously published custom Watson Knowledge Studio model. */
  private String model;
  /** If provided, then do not attempt to detect the language of the input document. Instead, assume the language is the one specified in this field.  You can set this property to work around `unsupported-text-language` errors.  Supported languages include English, German, French, Italian, Portuguese, Russian, Spanish and Swedish. Supported language codes are the ISO-639-1, ISO-639-2, ISO-639-3, and the plain english name of the language (e.g. "russian"). */
  private Language language;

  /**
   * Gets the extract.
   *
   * @return the extract
   */
  public String getExtract() {
    return extract;
  }

  /**
   * Gets the sentiment.
   *
   * @return the sentiment
   */
  public Boolean getSentiment() {
    return sentiment;
  }

  /**
   * Gets the quotations.
   *
   * @return the quotations
   */
  public Boolean getQuotations() {
    return quotations;
  }

  /**
   * Gets the showSourceText.
   *
   * @return the showSourceText
   */
  public Boolean getShowSourceText() {
    return showSourceText;
  }

  /**
   * Gets the hierarchicalTypedRelations.
   *
   * @return the hierarchicalTypedRelations
   */
  public Boolean getHierarchicalTypedRelations() {
    return hierarchicalTypedRelations;
  }

  /**
   * Gets the model.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Gets the language.
   *
   * @return the language
   */
  public Language getLanguage() {
    return language;
  }

  /**
   * Sets the extract.
   *
   * @param extract the new extract
   */
  public void setExtract(final String extract) {
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
  public void setLanguage(final Language language) {
    this.language = language;
  }
}

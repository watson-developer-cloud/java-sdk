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
package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Profile.
 */
public class Profile extends GenericModel {

  /**
   * The language model that was used to process the input.
   */
  public interface ProcessedLanguage {
    /** ar. */
    String AR = "ar";
    /** en. */
    String EN = "en";
    /** es. */
    String ES = "es";
    /** ja. */
    String JA = "ja";
    /** ko. */
    String KO = "ko";
  }

  @SerializedName("processed_language")
  private String processedLanguage;
  @SerializedName("word_count")
  private Long wordCount;
  @SerializedName("word_count_message")
  private String wordCountMessage;
  private List<Trait> personality;
  private List<Trait> values;
  private List<Trait> needs;
  private List<Behavior> behavior;
  @SerializedName("consumption_preferences")
  private List<ConsumptionPreferencesCategory> consumptionPreferences;
  private List<Warning> warnings;

  /**
   * Gets the processedLanguage.
   *
   * The language model that was used to process the input.
   *
   * @return the processedLanguage
   */
  public String getProcessedLanguage() {
    return processedLanguage;
  }

  /**
   * Gets the wordCount.
   *
   * The number of words that were found in the input.
   *
   * @return the wordCount
   */
  public Long getWordCount() {
    return wordCount;
  }

  /**
   * Gets the wordCountMessage.
   *
   * When guidance is appropriate, a string that provides a message that indicates the number of words found and where
   * that value falls in the range of required or suggested number of words.
   *
   * @return the wordCountMessage
   */
  public String getWordCountMessage() {
    return wordCountMessage;
  }

  /**
   * Gets the personality.
   *
   * Detailed results for the Big Five personality characteristics (dimensions and facets) inferred from the input text.
   *
   * @return the personality
   */
  public List<Trait> getPersonality() {
    return personality;
  }

  /**
   * Gets the values.
   *
   * Detailed results for the Needs characteristics inferred from the input text.
   *
   * @return the values
   */
  public List<Trait> getValues() {
    return values;
  }

  /**
   * Gets the needs.
   *
   * Detailed results for the Values characteristics inferred from the input text.
   *
   * @return the needs
   */
  public List<Trait> getNeeds() {
    return needs;
  }

  /**
   * Gets the behavior.
   *
   * For JSON content that is timestamped, detailed results about the social behavior disclosed by the input in terms of
   * temporal characteristics. The results include information about the distribution of the content over the days of
   * the week and the hours of the day.
   *
   * @return the behavior
   */
  public List<Behavior> getBehavior() {
    return behavior;
  }

  /**
   * Gets the consumptionPreferences.
   *
   * If the `consumption_preferences` query parameter is `true`, detailed results for each category of consumption
   * preferences. Each element of the array provides information inferred from the input text for the individual
   * preferences of that category.
   *
   * @return the consumptionPreferences
   */
  public List<ConsumptionPreferencesCategory> getConsumptionPreferences() {
    return consumptionPreferences;
  }

  /**
   * Gets the warnings.
   *
   * Warning messages associated with the input text submitted with the request. The array is empty if the input
   * generated no warnings.
   *
   * @return the warnings
   */
  public List<Warning> getWarnings() {
    return warnings;
  }

  /**
   * Sets the processedLanguage.
   *
   * @param processedLanguage the new processedLanguage
   */
  public void setProcessedLanguage(final String processedLanguage) {
    this.processedLanguage = processedLanguage;
  }

  /**
   * Sets the wordCount.
   *
   * @param wordCount the new wordCount
   */
  public void setWordCount(final long wordCount) {
    this.wordCount = wordCount;
  }

  /**
   * Sets the wordCountMessage.
   *
   * @param wordCountMessage the new wordCountMessage
   */
  public void setWordCountMessage(final String wordCountMessage) {
    this.wordCountMessage = wordCountMessage;
  }

  /**
   * Sets the personality.
   *
   * @param personality the new personality
   */
  public void setPersonality(final List<Trait> personality) {
    this.personality = personality;
  }

  /**
   * Sets the values.
   *
   * @param values the new values
   */
  public void setValues(final List<Trait> values) {
    this.values = values;
  }

  /**
   * Sets the needs.
   *
   * @param needs the new needs
   */
  public void setNeeds(final List<Trait> needs) {
    this.needs = needs;
  }

  /**
   * Sets the behavior.
   *
   * @param behavior the new behavior
   */
  public void setBehavior(final List<Behavior> behavior) {
    this.behavior = behavior;
  }

  /**
   * Sets the consumptionPreferences.
   *
   * @param consumptionPreferences the new consumptionPreferences
   */
  public void setConsumptionPreferences(final List<ConsumptionPreferencesCategory> consumptionPreferences) {
    this.consumptionPreferences = consumptionPreferences;
  }

  /**
   * Sets the warnings.
   *
   * @param warnings the new warnings
   */
  public void setWarnings(final List<Warning> warnings) {
    this.warnings = warnings;
  }
}

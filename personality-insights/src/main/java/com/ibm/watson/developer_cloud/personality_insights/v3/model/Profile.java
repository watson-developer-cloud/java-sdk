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
 * Personality profile.
 */
public class Profile extends GenericModel {

  /**
   * Warning message associated with the input text submitted with the request.
   */
  public class Warning extends GenericModel {
    @SerializedName("warning_id")
    private String id;
    private String message;

    /**
     * Gets the identifier of the warning message.
     *
     * @return the id
     */
    public String getId() {
      return id;
    }

    /**
     * Sets the identifier of the warning message.
     *
     * @param id the new id
     */
    public void setId(String id) {
      this.id = id;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
      return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
      this.message = message;
    }

  }

  @SerializedName("word_count")
  private Integer wordCount;

  @SerializedName("word_count_message")
  private String wordCountMessage;

  @SerializedName("processed_language")
  private String processedLanguage;

  private List<Trait> personality;
  private List<Trait> needs;
  private List<Trait> values;
  private List<Behavior> behavior;

  @SerializedName("consumption_preferences")
  private List<ConsumptionPreferences> consumptionPreferences;
  private List<Warning> warnings;

  /**
   * Gets the word count message.
   *
   * @return the word count message
   */
  public String getWordCountMessage() {
    return wordCountMessage;
  }

  /**
   * Gets the detailed results about the social behavior disclosed by the input in terms of temporal characteristics.
   * The results include information about the distribution of the content over the days of the week and the hours of
   * the day.
   *
   * @return the behavior
   */
  public List<Behavior> getBehavior() {
    return behavior;
  }

  /**
   * Sets the detailed results about the social behavior disclosed by the input in terms of temporal characteristics.
   * The results include information about the distribution of the content over the days of the week and the hours of
   * the day.
   *
   * @param behavior the new behaviors
   */
  public void setBehavior(List<Behavior> behavior) {
    this.behavior = behavior;
  }

  /**
   * Sets the word count message.
   *
   * @param wordCountMessage the new word count message
   */
  public void setWordCountMessage(String wordCountMessage) {
    this.wordCountMessage = wordCountMessage;
  }

  /**
   * Gets the number of words that were found in the input.
   *
   * @return the word count
   */
  public Integer getWordCount() {
    return wordCount;
  }

  /**
   * Sets the number of words that were found in the input.
   *
   * @param wordCount the new word count
   */
  public void setWordCount(Integer wordCount) {
    this.wordCount = wordCount;
  }

  /**
   * Gets the processed language.
   *
   * @return the processed language
   */
  public String getProcessedLanguage() {
    return processedLanguage;
  }

  /**
   * Sets the processed language.
   *
   * @param processedLanguage the new processed language
   */
  public void setProcessedLanguage(String processedLanguage) {
    this.processedLanguage = processedLanguage;
  }

  /**
   * Gets the detailed results for the Big Five personality characteristics (dimensions and facets) inferred from the
   * input text.
   *
   * @return the personality
   */
  public List<Trait> getPersonality() {
    return personality;
  }

  /**
   * Sets the detailed results for the Big Five personality characteristics (dimensions and facets) inferred from the
   * input text.
   *
   * @param personality the new personality
   */
  public void setPersonality(List<Trait> personality) {
    this.personality = personality;
  }

  /**
   * Gets the detailed results for the Needs characteristics inferred from the input text.
   *
   * @return the needs
   */
  public List<Trait> getNeeds() {
    return needs;
  }

  /**
   * Sets the detailed results for the Needs characteristics inferred from the input text.
   *
   * @param needs the new needs
   */
  public void setNeeds(List<Trait> needs) {
    this.needs = needs;
  }

  /**
   * Gets the detailed results for the Values characteristics inferred from the input text.
   *
   * @return the values
   */
  public List<Trait> getValues() {
    return values;
  }

  /**
   * Sets the detailed results for the Values characteristics inferred from the input text.
   *
   * @param values the new values
   */
  public void setValues(List<Trait> values) {
    this.values = values;
  }

  /**
   * Gets the consumption preferences.
   *
   * @return the consumption preferences
   */
  public List<ConsumptionPreferences> getConsumptionPreferences() {
    return consumptionPreferences;
  }

  /**
   * Sets the consumption preferences.
   *
   * @param consumptionPreferences the new consumption preferences
   */
  public void setConsumptionPreferences(List<ConsumptionPreferences> consumptionPreferences) {
    this.consumptionPreferences = consumptionPreferences;
  }

  /**
   * Gets the warning messages associated with the input text submitted with the request.
   *
   * @return the warnings
   */
  public List<Warning> getWarnings() {
    return warnings;
  }

  /**
   * Sets the warning messages associated with the input text submitted with the request.
   *
   * @param warnings the new warnings
   */
  public void setWarnings(List<Warning> warnings) {
    this.warnings = warnings;
  }

}

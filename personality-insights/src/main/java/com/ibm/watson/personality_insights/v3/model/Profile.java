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
package com.ibm.watson.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** The personality profile that the service generated for the input content. */
public class Profile extends GenericModel {

  /** The language model that was used to process the input. */
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
  protected String processedLanguage;

  @SerializedName("word_count")
  protected Long wordCount;

  @SerializedName("word_count_message")
  protected String wordCountMessage;

  protected List<Trait> personality;
  protected List<Trait> needs;
  protected List<Trait> values;
  protected List<Behavior> behavior;

  @SerializedName("consumption_preferences")
  protected List<ConsumptionPreferencesCategory> consumptionPreferences;

  protected List<Warning> warnings;

  /**
   * Gets the processedLanguage.
   *
   * <p>The language model that was used to process the input.
   *
   * @return the processedLanguage
   */
  public String getProcessedLanguage() {
    return processedLanguage;
  }

  /**
   * Gets the wordCount.
   *
   * <p>The number of words from the input that were used to produce the profile.
   *
   * @return the wordCount
   */
  public Long getWordCount() {
    return wordCount;
  }

  /**
   * Gets the wordCountMessage.
   *
   * <p>When guidance is appropriate, a string that provides a message that indicates the number of
   * words found and where that value falls in the range of required or suggested number of words.
   *
   * @return the wordCountMessage
   */
  public String getWordCountMessage() {
    return wordCountMessage;
  }

  /**
   * Gets the personality.
   *
   * <p>A recursive array of `Trait` objects that provides detailed results for the Big Five
   * personality characteristics (dimensions and facets) inferred from the input text.
   *
   * @return the personality
   */
  public List<Trait> getPersonality() {
    return personality;
  }

  /**
   * Gets the needs.
   *
   * <p>Detailed results for the Needs characteristics inferred from the input text.
   *
   * @return the needs
   */
  public List<Trait> getNeeds() {
    return needs;
  }

  /**
   * Gets the values.
   *
   * <p>Detailed results for the Values characteristics inferred from the input text.
   *
   * @return the values
   */
  public List<Trait> getValues() {
    return values;
  }

  /**
   * Gets the behavior.
   *
   * <p>For JSON content that is timestamped, detailed results about the social behavior disclosed
   * by the input in terms of temporal characteristics. The results include information about the
   * distribution of the content over the days of the week and the hours of the day.
   *
   * @return the behavior
   */
  public List<Behavior> getBehavior() {
    return behavior;
  }

  /**
   * Gets the consumptionPreferences.
   *
   * <p>If the **consumption_preferences** parameter is `true`, detailed results for each category
   * of consumption preferences. Each element of the array provides information inferred from the
   * input text for the individual preferences of that category.
   *
   * @return the consumptionPreferences
   */
  public List<ConsumptionPreferencesCategory> getConsumptionPreferences() {
    return consumptionPreferences;
  }

  /**
   * Gets the warnings.
   *
   * <p>An array of warning messages that are associated with the input text for the request. The
   * array is empty if the input generated no warnings.
   *
   * @return the warnings
   */
  public List<Warning> getWarnings() {
    return warnings;
  }
}

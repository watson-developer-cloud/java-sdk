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
package com.ibm.watson.developer_cloud.conversation_tone_analyzer_integration.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;

/**
 * ToneDetection.
 */
public class ToneDetection {

  /**
   * Thresholds for identifying meaningful tones returned by the Watson Tone Analyzer. Current values are based on the
   * recommendations made by the Watson Tone Analyzer at
   * https://console.bluemix.net/docs/services/tone-analyzer/using-tone.html These thresholds can be
   * adjusted to client/domain requirements.
   */
  private static final Double PRIMARY_EMOTION_SCORE_THRESHOLD = 0.5;
  private static final Double LANGUAGE_HIGH_SCORE_THRESHOLD = 0.75;
  private static final Double LANGUAGE_NO_SCORE_THRESHOLD = 0.0;
  private static final Double SOCIAL_HIGH_SCORE_THRESHOLD = 0.75;
  private static final Double SOCIAL_LOW_SCORE_THRESHOLD = 0.25;

  /**
   * Instantiates a new tone detection.
   */
  private ToneDetection() { }

  /**
   * Labels for the tone categories returned by the Watson Tone Analyzer.
   */
  private static final String EMOTION_TONE_LABEL = "emotion_tone";
  private static final String LANGUAGE_TONE_LABEL = "language_tone";
  private static final String SOCIAL_TONE_LABEL = "social_tone";

  /**
   * updateUserTone processes the Tone Analyzer payload to pull out the emotion, language and social tones, and identify
   * the meaningful tones (i.e., those tones that meet the specified thresholds). The conversationPayload json object is
   * updated to include these tones.
   *
   * @param context the context
   * @param toneAnalyzerPayload json object returned by the Watson Tone Analyzer Service
   * @param maintainHistory the maintain history
   * @return the map
   * @returns conversationPayload where the user object has been updated with tone information from the
   *          toneAnalyzerPayload
   */
  public static Map<String, Object> updateUserTone(Map<String, Object> context, ToneAnalysis toneAnalyzerPayload,
      Boolean maintainHistory) {

    List<ToneScore> emotionTone = new ArrayList<ToneScore>();
    List<ToneScore> languageTone = new ArrayList<ToneScore>();
    List<ToneScore> socialTone = new ArrayList<ToneScore>();

    // If the context doesn't already contain the user object, initialize it
    if (!context.containsKey("user")) {
      context.put("user", initUser());
    }

    // For convenience sake, define a variable for the user object to
    @SuppressWarnings("unchecked")
    Map<String, Object> user = (Map<String, Object>) context.get("user");

    if (toneAnalyzerPayload != null && toneAnalyzerPayload.getDocumentTone() != null) {
      List<ToneCategory> tones = toneAnalyzerPayload.getDocumentTone().getTones();
      for (ToneCategory tone : tones) {
        if (tone.getId().equals(EMOTION_TONE_LABEL)) {
          emotionTone = tone.getTones();
        }
        if (tone.getId().equals(LANGUAGE_TONE_LABEL)) {
          languageTone = tone.getTones();
        }
        if (tone.getId().equals(SOCIAL_TONE_LABEL)) {
          socialTone = tone.getTones();
        }
      }

      updateEmotionTone(user, emotionTone, maintainHistory);
      updateLanguageTone(user, languageTone, maintainHistory);
      updateSocialTone(user, socialTone, maintainHistory);

    }

    context.put("user", user);
    return user;
  }

  /**
   * initUser initializes a user containing tone data (from the Watson Tone Analyzer).
   *
   * @return the map
   * @returns user with the emotion, language and social tones. The current tone identifies the tone for a specific
   *          conversation turn, and the history provides the conversation for all tones up to the current tone for a
   *          conversation instance with a user.
   */
  public static Map<String, Object> initUser() {

    Map<String, Object> user = new HashMap<String, Object>();
    Map<String, Object> tone = new HashMap<String, Object>();

    Map<String, Object> emotionTone = new HashMap<String, Object>();
    emotionTone.put("current", null);

    Map<String, Object> socialTone = new HashMap<String, Object>();
    socialTone.put("current", null);

    Map<String, Object> languageTone = new HashMap<String, Object>();
    languageTone.put("current", null);

    tone.put("emotion", emotionTone);
    tone.put("social", socialTone);
    tone.put("language", languageTone);

    user.put("tone", tone);

    return user;
  }

  /**
   * updateEmotionTone updates the user emotion tone with the primary emotion - the emotion tone that has a score
   * greater than or equal to the EMOTION_SCORE_THRESHOLD; otherwise primary emotion will be 'neutral'.
   *
   * @param user a json object representing user information (tone) to be used in conversing with the Conversation
   *        Service
   * @param emotionTone a json object containing the emotion tones in the payload returned by the Tone Analyzer
   */
  @SuppressWarnings("unchecked")
  private static void updateEmotionTone(Map<String, Object> user, List<ToneScore> emotionTone,
      Boolean maintainHistory) {

    Double maxScore = 0.0;
    String primaryEmotion = null;
    Double primaryEmotionScore = null;

    for (ToneScore tone : emotionTone) {
      if (tone.getScore() > maxScore) {
        maxScore = tone.getScore();
        primaryEmotion = tone.getName().toLowerCase();
        primaryEmotionScore = tone.getScore();
      }
    }

    if (maxScore <= PRIMARY_EMOTION_SCORE_THRESHOLD) {
      primaryEmotion = "neutral";
      primaryEmotionScore = null;
    }

    // update user emotion tone
    Map<String, Object> emotion = (Map<String, Object>) ((Map<String, Object>) (user.get("tone"))).get("emotion");
    emotion.put("current", primaryEmotion);

    if (maintainHistory) {
      List<Map<String, Object>> history = new ArrayList<Map<String, Object>>();
      if (emotion.get("history") != null) {
        history = (List<Map<String, Object>>) emotion.get("history");
      }

      Map<String, Object> emotionHistoryObject = new HashMap<String, Object>();
      emotionHistoryObject.put("tone_name", primaryEmotion);
      emotionHistoryObject.put("score", primaryEmotionScore);
      history.add(emotionHistoryObject);

      emotion.put("history", history);
    }
  }

  /**
   * updateLanguageTone updates the user with the language tones interpreted based on the specified thresholds.
   *
   * @param user a json object representing user information (tone) to be used in conversing with the Conversation
   *        Service
   * @param languageTone a json object containing the language tones in the payload returned by the Tone Analyzer
   */
  @SuppressWarnings("unchecked")
  private static void updateLanguageTone(Map<String, Object> user, List<ToneScore> languageTone,
      Boolean maintainHistory) {

    List<String> currentLanguage = new ArrayList<String>();
    Map<String, Object> currentLanguageObject = new HashMap<String, Object>();

    // Process each language tone and determine if it is high or low
    for (ToneScore tone : languageTone) {
      if (tone.getScore() >= LANGUAGE_HIGH_SCORE_THRESHOLD) {
        currentLanguage.add(tone.getName().toLowerCase() + "_high");
        currentLanguageObject.put("tone_name", tone.getName().toLowerCase());
        currentLanguageObject.put("score", tone.getScore());
        currentLanguageObject.put("interpretation", "likely high");
      } else if (tone.getScore() <= LANGUAGE_NO_SCORE_THRESHOLD) {
        currentLanguageObject.put("tone_name", tone.getName().toLowerCase());
        currentLanguageObject.put("score", tone.getScore());
        currentLanguageObject.put("interpretation", "no evidence");
      } else {
        currentLanguageObject.put("tone_name", tone.getName().toLowerCase());
        currentLanguageObject.put("score", tone.getScore());
        currentLanguageObject.put("interpretation", "likely medium");
      }
    }

    // update user language tone
    Map<String, Object> language = (Map<String, Object>) ((Map<String, Object>) user.get("tone")).get("language");

    // the current language pulled from tone
    language.put("current", currentLanguage);

    // if history needs to be maintained
    if (maintainHistory) {
      List<Map<String, Object>> history = new ArrayList<Map<String, Object>>();
      if (language.get("history") != null) {
        history = (List<Map<String, Object>>) language.get("history");
      }
      history.add(currentLanguageObject);
      language.put("history", history);
    }
  }

  /**
   * updateSocialTone updates the user with the social tones interpreted based on the specified thresholds.
   *
   * @param user a json object representing user information (tone) to be used in conversing with the Conversation
   *        Service
   * @param socialTone a json object containing the social tones in the payload returned by the Tone Analyzer
   * @param maintainHistory the maintain history
   */
  @SuppressWarnings("unchecked")
  public static void updateSocialTone(Map<String, Object> user, List<ToneScore> socialTone, Boolean maintainHistory) {

    List<String> currentSocial = new ArrayList<String>();
    Map<String, Object> currentSocialObject = new HashMap<String, Object>();

    for (ToneScore tone : socialTone) {
      if (tone.getScore() >= SOCIAL_HIGH_SCORE_THRESHOLD) {
        currentSocial.add(tone.getName().toLowerCase() + "_high");
        currentSocialObject.put("tone_name", tone.getName().toLowerCase());
        currentSocialObject.put("score", tone.getScore());
        currentSocialObject.put("interpretation", "likely high");
      } else if (tone.getScore() <= SOCIAL_LOW_SCORE_THRESHOLD) {
        currentSocial.add(tone.getName().toLowerCase() + "_low");
        currentSocialObject.put("tone_name", tone.getName().toLowerCase());
        currentSocialObject.put("score", tone.getScore());
        currentSocialObject.put("interpretation", "likely low");
      } else {
        currentSocialObject.put("tone_name", tone.getName().toLowerCase());
        currentSocialObject.put("score", tone.getScore());
        currentSocialObject.put("interpretation", "likely medium");
      }
    }

    // update user language tone
    Map<String, Object> social = (Map<String, Object>) ((Map<String, Object>) user.get("tone")).get("social");
    social.put("current", currentSocial);

    // if history needs to be maintained
    if (maintainHistory) {
      List<Map<String, Object>> history = new ArrayList<Map<String, Object>>();
      if (social.get("history") != null) {
        history = (List<Map<String, Object>>) social.get("history");
      }
      history.add(currentSocialObject);
      social.put("history", history);
    }
  }
}

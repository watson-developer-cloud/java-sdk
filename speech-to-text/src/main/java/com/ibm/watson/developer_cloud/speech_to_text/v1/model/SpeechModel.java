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

package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Speech model.
 */
public class SpeechModel extends GenericModel {

  /**
   * Describes the additional service features supported with the speech
   * model.
   */
  public class SupportedFeatures {
    @SerializedName("custom_language_model")
    private Boolean customLanguageModel;
    @SerializedName("speaker_labels")
    private Boolean speakerLabels;

    /**
     * Gets the custom language model attribute.
     *
     * @return the custom language model atribute.
     */
      public Boolean getCustomLanguageModel() {
      return customLanguageModel;
    }

    /**
     * Gets the speaker labels attribute.
     *
     * @return the speaker labels attribute.
     */
    public Boolean getSpeakerLabels() {
      return speakerLabels;
    }

    /**
     * Sets the custom language model attribute.
     *
     * @param customLanguageModel the new custom language model attribute
     * value.
     */
    public void setCustomLanguageModel(final Boolean customLanguageModel) {
      this.customLanguageModel = customLanguageModel;
    }

    /**
     * Sets the speaker labels attribute.
     *
     * @param speakerLabels the new speaker labels attribute value.
     */
    public void setSpeakerLabels(final Boolean speakerLabels) {
      this.speakerLabels = speakerLabels;
    }

  }

  /** Modern Standard Arabic broadband model. */
  public static final SpeechModel AR_AR_BROADBANDMODEL = new SpeechModel("ar-AR_BroadbandModel");

  /** UK English broadband model. */
  public static final SpeechModel EN_GB_BROADBANDMODEL = new SpeechModel("en-GB_BroadbandModel");

  /** UK English narrowband model. */
  public static final SpeechModel EN_GB_NARROWBANDMODEL = new SpeechModel("en-GB_NarrowbandModel");

  /** US English broadband model. */
  public static final SpeechModel EN_US_BROADBANDMODEL = new SpeechModel("en-US_BroadbandModel");

  /** US English narrowband model. */
  public static final SpeechModel EN_US_NARROWBANDMODEL = new SpeechModel("en-US_NarrowbandModel");

  /** Spanish broadband model. */
  public static final SpeechModel ES_ES_BROADBANDMODEL = new SpeechModel("es-ES_BroadbandModel");

  /** Spanish narrowband model. */
  public static final SpeechModel ES_ES_NARROWBANDMODEL = new SpeechModel("es-ES_NarrowbandModel");

  /** Japanese broadband model. */
  public static final SpeechModel JA_JP_BROADBANDMODEL = new SpeechModel("ja-JP_BroadbandModel");

  /** French broadband model. */
  public static final SpeechModel FR_FR_BROADBANDMODEL = new SpeechModel("fr-FR_BroadbandModel");

  /** Japanese narrowband model. */
  public static final SpeechModel JA_JP_NARROWBANDMODEL = new SpeechModel("ja-JP_NarrowbandModel");

  /** Brazilian Portuguese broadband model. */
  public static final SpeechModel PT_BR_BROADBANDMODEL = new SpeechModel("pt-BR_BroadbandModel");

  /** Brazilian Portuguese narrowband model. */
  public static final SpeechModel PT_BR_NARROWBANDMODEL = new SpeechModel("pt-BR_NarrowbandModel");

  /** Mandarin broadband model. */
  public static final SpeechModel ZH_CN_BROADBANDMODEL = new SpeechModel("zh-CN_BroadbandModel");

  /** Mandarin narrowband model. */
  public static final SpeechModel ZH_CN_NARROWBANDMODEL = new SpeechModel("zh-CN_NarrowbandModel");

  private String name;
  private String language;
  private int rate;
  private String url;
  private String description;
  private String sessions;

  @SerializedName("supported_features")
  private SupportedFeatures supportedFeatures;

  /**
   * Instantiates a new speech model.
   *
   * @param name the name
   */
  public SpeechModel(String name) {
    super();
    this.name = name;
  }

  /**
   * Gets the name.
   *
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the language.
   *
   * @return The language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the rate.
   *
   * @return The rate
   */
  public int getRate() {
    return rate;
  }

  /**
   * Gets the url.
   *
   * @return The url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the sessions.
   *
   * @return the sessions
   */
  public String getSessions() {
    return sessions;
  }

  /**
   * Gets the supported features.
   *
   * @return the supported features
   */
  public SupportedFeatures getSupportedFeatures() {
    return supportedFeatures;
  }

  /**
   * Sets the name.
   *
   * @param name The name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the language.
   *
   * @param language The language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the rate.
   *
   * @param rate The rate
   */
  public void setRate(final int rate) {
    this.rate = rate;
  }

  /**
   * Sets the url.
   *
   * @param url The url.
   */
  public void setUrl(final String url) {
      this.url = url;
  }

  /**
   * Sets the description.
   *
   * @param description The description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the sessions.
   *
   * @param sessions the new sessions
   */
  public void setSessions(final String sessions) {
    this.sessions = sessions;
  }

  /**
   * Sets the supported features.
   *
   * @param supportedFeatures the new supported features
   */
  public void setSupportedFeatures(final SupportedFeatures supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
  }

}

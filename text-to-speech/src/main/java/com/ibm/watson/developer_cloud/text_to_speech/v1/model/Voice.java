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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;

/**
 * {@link TextToSpeech} voice.
 */
public class Voice extends GenericModel {

  /**
   * Describes the additional service features supported with the voice.
   */
  public class SupportedFeatures {
    @SerializedName("custom_pronunciation")
    private Boolean customPronunciation;
    @SerializedName("voice_transformation")
    private Boolean voiceTransformation;

    /**
     * Gets the custom pronunciation.
     *
     * @return the custom pronunciation
     */
    public Boolean getCustomPronunciation() {
      return customPronunciation;
    }

    /**
     * Gets the voice transformation.
     *
     * @return the voice transformation
     */
    public Boolean getVoiceTransformation() {
      return voiceTransformation;
    }

    /**
     * Sets the custom pronunciation.
     *
     * @param customPronunciation the new custom pronunciation
     */
    public void setCustomPronunciation(Boolean customPronunciation) {
      this.customPronunciation = customPronunciation;
    }

    /**
     * Sets the voice transformation.
     *
     * @param voiceTransformation the new voice transformation
     */
    public void setVoiceTransformation(Boolean voiceTransformation) {
      this.voiceTransformation = voiceTransformation;
    }
  }

  private static final String FEMALE = "female";

  private static final String MALE = "male";

  /** The Constant DE_BIRGIT (value is "de-DE_BirgitVoice"). */
  public static final Voice DE_BIRGIT = new Voice("de-DE_BirgitVoice", FEMALE, "de-DE");

  /** The Constant DE_DIETER (value is "de-DE_DieterVoice"). */
  public static final Voice DE_DIETER = new Voice("de-DE_DieterVoice", MALE, "de-DE");

  /** The Constant EN_ALLISON (value is "en-US_AllisonVoice"). */
  public static final Voice EN_ALLISON = new Voice("en-US_AllisonVoice", FEMALE, "en-US");

  /** The Constant EN_LISA (value is "en-US_LisaVoice"). */
  public static final Voice EN_LISA = new Voice("en-US_LisaVoice", FEMALE, "en-US");

  /** The Constant EN_MICHAEL (value is "en-US_MichaelVoice"). */
  public static final Voice EN_MICHAEL = new Voice("en-US_MichaelVoice", MALE, "en-US");

  /** The Constant ES_ENRIQUE (value is "es-ES_EnriqueVoice"). */
  public static final Voice ES_ENRIQUE = new Voice("es-ES_EnriqueVoice", MALE, "es-ES");

  /** The Constant ES_LAURA (value is "es-ES_LauraVoice"). */
  public static final Voice ES_LAURA = new Voice("es-ES_LauraVoice", FEMALE, "es-US");

  /** The Constant ES_SOFIA (value is "es-US_SofiaVoice"). */
  public static final Voice ES_SOFIA = new Voice("es-US_SofiaVoice", FEMALE, "es-US");

  /** The Constant FR_RENEE (value is "fr-FR_ReneeVoice"). */
  public static final Voice FR_RENEE = new Voice("fr-FR_ReneeVoice", FEMALE, "fr-FR");

  /** The Constant GB_KATE (value is "en-GB_KateVoice"). */
  public static final Voice GB_KATE = new Voice("en-GB_KateVoice", FEMALE, "en-GB");

  /** The Constant IT_FRANCESCA (value is "it-IT_FrancescaVoice"). */
  public static final Voice IT_FRANCESCA = new Voice("it-IT_FrancescaVoice", FEMALE, "it-IT");

  /** The Constant JA_EMI (value is "ja-JP_EmiVoice"). */
  public static final Voice JA_EMI = new Voice("ja-JP_EmiVoice", FEMALE, "ja-JP");

  /** The Constant LA_SOFIA (value is "es-LA_SofiaVoice"). */
  public static final Voice LA_SOFIA = new Voice("es-LA_SofiaVoice", FEMALE, "es-LA");

  /** The Constant PT_ISABELA (value is "pt-BR_IsabelaVoice"). */
  public static final Voice PT_ISABELA = new Voice("pt-BR_IsabelaVoice", FEMALE, "pt-BR");

  /** The List of all predefined Voices. */
  public static final List<Voice> ALL = Collections.unmodifiableList(Arrays.asList(DE_DIETER, DE_BIRGIT, EN_ALLISON,
      EN_LISA, EN_MICHAEL, ES_ENRIQUE, ES_LAURA, ES_SOFIA, LA_SOFIA, FR_RENEE, GB_KATE,
      IT_FRANCESCA, JA_EMI, PT_ISABELA));


  /**
   * Gets the Voice by its name (e.g. en-US_AllisonVoice).
   *
   * @param name the Voice name
   * @return the Voice, or null if no matching Voice was found
   */
  public static Voice getByName(String name) {
    for (Voice voice : ALL) {
      if (voice.getName().equals(name)) {
        return voice;
      }
    }

    return null;
  }
  private String description;
  private String gender;
  private String language;
  private String name;
  private String url;

  @SerializedName("supported_features")
  private SupportedFeatures supportedFeatures;

  @SerializedName("customization")
  private CustomVoiceModel customVoiceModel;

  /**
   * Instantiates a new voice.
   */
  public Voice() { }

  /**
   * Instantiates a new voice.
   *
   * @param name the name
   * @param gender the gender
   * @param language the language
   */
  public Voice(final String name, final String gender, final String language) {
    this.name = name;
    this.gender = gender;
    this.language = language;
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
   * Gets the gender.
   *
   * @return the gender
   */
  public String getGender() {
    return gender;
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
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
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
   * Gets the supported features.
   *
   * @return the supported features
   */
  public SupportedFeatures getSupportedFeatures() {
    return supportedFeatures;
  }

  /**
   * Gets the custom voice model if present.
   *
   * @return the custom voice model
   */
  public CustomVoiceModel getCustomVoiceModel() {
    return customVoiceModel;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets the gender.
   *
   * @param gender the new gender
   */
  public void setGender(final String gender) {
    this.gender = gender;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
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
   * Sets the supported features.
   *
   * @param supportedFeatures the new supported features
   */
  public void setSupportedFeatures(SupportedFeatures supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
  }

  /**
   * Sets the custom voice model if present.
   *
   * @param customVoiceModel the new custom voice model
   */
  public void setCustomVoiceModel(CustomVoiceModel customVoiceModel) {
    this.customVoiceModel = customVoiceModel;
  }

}

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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * A customized word translation, assigning a specific pronunciation to a given word. The translation can be either a
 * simple String of the desired pronunciation ({@code "Sunday"} as translation for {@code "Sun."}), an International
 * Phonetic Alphabet (IPA) representation. A Japanese translation can also specify a part of speech.
 *
 * @see <a href= "http://www.ibm.com/watson/developercloud/doc/text-to-speech/custom-intro.shtml">Customization</a>
 *
 */
public class CustomTranslation extends GenericModel {

  /**
   * The Enum PartOfSpeech for Japanese custom translations only.
   */
  public enum PartOfSpeech {
    JOSI, /** Joshi: participle. */
    MESI, /** Meishi: noun. */
    KIGO, /** Kigou: symbol. */
    GOBI, /** Gobi: inflection. */
    DOSI, /** Doushi: verb. */
    JODO, /** Jodoushi: auxiliary verb. */
    KOYU, /** Koyuumeishi: proper noun. */
    STBI, /** Setsubiji: suffix. */
    SUJI, /** Suuji: numeral. */
    KEDO, /** Keiyodoushi: adjective verb. */
    FUKU, /** Fukishi: adverb. */
    KEYO, /** Keiyoshi: adjective verb. */
    STTO, /** Settoji: prefix. */
    RETA, /** Rentaish: determiner. */
    STZO, /** Setsuzokushi: conjunction. */
    KATO, /** Kantoushi: interjection. */
    HOKA  /** Hoka: other. */
  }

  private String word;

  private String translation;

  @SerializedName("part_of_speech")
  private String partOfSpeech;

  /**
   * Instantiates a new custom translation.
   */
  public CustomTranslation() {
    super();
  }

  /**
   * Creates a new CustomTranslation without a part of speech.
   *
   * @param word the word
   * @param translation the custom translation
   */
  public CustomTranslation(String word, String translation) {
    this(word, translation, null);
  }

  /**
   * Creates a new CustomTranslation with a part of speech.
   *
   * @param word the word
   * @param translation the custom translation
   * @param partOfSpeech the part of speech
   */
  public CustomTranslation(String word, String translation, CustomTranslation.PartOfSpeech partOfSpeech) {
    this();
    setWord(word);
    setTranslation(translation);
    if (partOfSpeech != null) {
      String pos = partOfSpeech.toString();
      setPartOfSpeech(pos.charAt(0) + pos.substring(1).toLowerCase());
    }
  }

  /**
   * Returns the original word.
   *
   * @return the word
   */
  public String getWord() {
    return word;
  }

  /**
   * Sets the original word.
   *
   * @param word the word
   */
  public void setWord(String word) {
    Validator.notEmpty(word, "word must not be empty");
    this.word = word;
  }

  /**
   * Returns the custom translation.
   *
   * @return the translation
   */
  public String getTranslation() {
    return translation;
  }

  /**
   * Sets the custom translation. It can be either a simple String of the desired pronunciation, an International
   * Phonetic Alphabet (IPA) representation an IBM Symbolic Phonetic Representation (SPR), or a mix of them.
   *
   * @param translation the translation
   * @see <a href= "http://www.ibm.com/watson/developercloud/doc/text-to-speech/custom-intro.shtml">Customization</a>
   */
  public void setTranslation(String translation) {
    this.translation = translation;
  }

  /**
   * Returns the part of speech.
   *
   * @return the part of speech
   */
  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  /**
   * Sets the original part of speech.
   *
   * @param partOfSpeech the part of speech
   */
  public void setPartOfSpeech(String partOfSpeech) {
    this.partOfSpeech = partOfSpeech;
  }

}

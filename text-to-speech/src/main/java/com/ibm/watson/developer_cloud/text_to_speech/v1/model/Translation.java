/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

/**
 * Translation.
 */
public class Translation extends GenericModel {

  /**
   * **Japanese only.** The part of speech for the word. The service uses the value to produce the correct intonation
   * for the word. You can create only a single entry, with or without a single part of speech, for any word; you cannot
   * create multiple entries with different parts of speech for the same word. For more information, see [Working with
   * Japanese entries](https://cloud.ibm.com/docs/services/text-to-speech/custom-rules.html#jaNotes).
   */
  public interface PartOfSpeech {
    /** Josi. */
    String JOSI = "Josi";
    /** Mesi. */
    String MESI = "Mesi";
    /** Kigo. */
    String KIGO = "Kigo";
    /** Gobi. */
    String GOBI = "Gobi";
    /** Dosi. */
    String DOSI = "Dosi";
    /** Jodo. */
    String JODO = "Jodo";
    /** Koyu. */
    String KOYU = "Koyu";
    /** Stbi. */
    String STBI = "Stbi";
    /** Suji. */
    String SUJI = "Suji";
    /** Kedo. */
    String KEDO = "Kedo";
    /** Fuku. */
    String FUKU = "Fuku";
    /** Keyo. */
    String KEYO = "Keyo";
    /** Stto. */
    String STTO = "Stto";
    /** Reta. */
    String RETA = "Reta";
    /** Stzo. */
    String STZO = "Stzo";
    /** Kato. */
    String KATO = "Kato";
    /** Hoka. */
    String HOKA = "Hoka";
  }

  private String translation;
  @SerializedName("part_of_speech")
  private String partOfSpeech;

  /**
   * Gets the translation.
   *
   * The phonetic or sounds-like translation for the word. A phonetic translation is based on the SSML format for
   * representing the phonetic string of a word either as an IPA translation or as an IBM SPR translation. A sounds-like
   * is one or more words that, when combined, sound like the word.
   *
   * @return the translation
   */
  public String getTranslation() {
    return translation;
  }

  /**
   * Gets the partOfSpeech.
   *
   * **Japanese only.** The part of speech for the word. The service uses the value to produce the correct intonation
   * for the word. You can create only a single entry, with or without a single part of speech, for any word; you cannot
   * create multiple entries with different parts of speech for the same word. For more information, see [Working with
   * Japanese entries](https://cloud.ibm.com/docs/services/text-to-speech/custom-rules.html#jaNotes).
   *
   * @return the partOfSpeech
   */
  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  /**
   * Sets the translation.
   *
   * @param translation the new translation
   */
  public void setTranslation(final String translation) {
    this.translation = translation;
  }

  /**
   * Sets the partOfSpeech.
   *
   * @param partOfSpeech the new partOfSpeech
   */
  public void setPartOfSpeech(final String partOfSpeech) {
    this.partOfSpeech = partOfSpeech;
  }
}

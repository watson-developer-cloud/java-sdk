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
package com.ibm.watson.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about the translation for the specified text.
 */
public class Translation extends GenericModel {

  /**
   * **Japanese only.** The part of speech for the word. The service uses the value to produce the correct intonation
   * for the word. You can create only a single entry, with or without a single part of speech, for any word; you cannot
   * create multiple entries with different parts of speech for the same word. For more information, see [Working with
   * Japanese entries](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-rules#jaNotes).
   */
  public interface PartOfSpeech {
    /** Dosi. */
    String DOSI = "Dosi";
    /** Fuku. */
    String FUKU = "Fuku";
    /** Gobi. */
    String GOBI = "Gobi";
    /** Hoka. */
    String HOKA = "Hoka";
    /** Jodo. */
    String JODO = "Jodo";
    /** Josi. */
    String JOSI = "Josi";
    /** Kato. */
    String KATO = "Kato";
    /** Kedo. */
    String KEDO = "Kedo";
    /** Keyo. */
    String KEYO = "Keyo";
    /** Kigo. */
    String KIGO = "Kigo";
    /** Koyu. */
    String KOYU = "Koyu";
    /** Mesi. */
    String MESI = "Mesi";
    /** Reta. */
    String RETA = "Reta";
    /** Stbi. */
    String STBI = "Stbi";
    /** Stto. */
    String STTO = "Stto";
    /** Stzo. */
    String STZO = "Stzo";
    /** Suji. */
    String SUJI = "Suji";
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
   * Japanese entries](https://cloud.ibm.com/docs/services/text-to-speech?topic=text-to-speech-rules#jaNotes).
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

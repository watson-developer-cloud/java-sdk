/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/** Information about a word for the custom model. */
public class Word extends GenericModel {

  /**
   * **Japanese only.** The part of speech for the word. The service uses the value to produce the
   * correct intonation for the word. You can create only a single entry, with or without a single
   * part of speech, for any word; you cannot create multiple entries with different parts of speech
   * for the same word. For more information, see [Working with Japanese
   * entries](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-rules#jaNotes).
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

  protected String word;
  protected String translation;

  @SerializedName("part_of_speech")
  protected String partOfSpeech;

  /** Builder. */
  public static class Builder {
    private String word;
    private String translation;
    private String partOfSpeech;

    private Builder(Word word) {
      this.word = word.word;
      this.translation = word.translation;
      this.partOfSpeech = word.partOfSpeech;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param word the word
     * @param translation the translation
     */
    public Builder(String word, String translation) {
      this.word = word;
      this.translation = translation;
    }

    /**
     * Builds a Word.
     *
     * @return the new Word instance
     */
    public Word build() {
      return new Word(this);
    }

    /**
     * Set the word.
     *
     * @param word the word
     * @return the Word builder
     */
    public Builder word(String word) {
      this.word = word;
      return this;
    }

    /**
     * Set the translation.
     *
     * @param translation the translation
     * @return the Word builder
     */
    public Builder translation(String translation) {
      this.translation = translation;
      return this;
    }

    /**
     * Set the partOfSpeech.
     *
     * @param partOfSpeech the partOfSpeech
     * @return the Word builder
     */
    public Builder partOfSpeech(String partOfSpeech) {
      this.partOfSpeech = partOfSpeech;
      return this;
    }
  }

  protected Word(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.word, "word cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.translation, "translation cannot be null");
    word = builder.word;
    translation = builder.translation;
    partOfSpeech = builder.partOfSpeech;
  }

  /**
   * New builder.
   *
   * @return a Word builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the word.
   *
   * <p>The word for the custom model. The maximum length of a word is 49 characters.
   *
   * @return the word
   */
  public String word() {
    return word;
  }

  /**
   * Gets the translation.
   *
   * <p>The phonetic or sounds-like translation for the word. A phonetic translation is based on the
   * SSML format for representing the phonetic string of a word either as an IPA or IBM SPR
   * translation. The Arabic, Chinese, Dutch, and Korean languages support only IPA. A sounds-like
   * translation consists of one or more words that, when combined, sound like the word. The maximum
   * length of a translation is 499 characters.
   *
   * @return the translation
   */
  public String translation() {
    return translation;
  }

  /**
   * Gets the partOfSpeech.
   *
   * <p>**Japanese only.** The part of speech for the word. The service uses the value to produce
   * the correct intonation for the word. You can create only a single entry, with or without a
   * single part of speech, for any word; you cannot create multiple entries with different parts of
   * speech for the same word. For more information, see [Working with Japanese
   * entries](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-rules#jaNotes).
   *
   * @return the partOfSpeech
   */
  public String partOfSpeech() {
    return partOfSpeech;
  }
}

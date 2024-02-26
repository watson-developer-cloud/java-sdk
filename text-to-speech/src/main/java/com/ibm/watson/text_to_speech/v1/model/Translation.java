/*
 * (C) Copyright IBM Corp. 2018, 2024.
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

/** Information about the translation for the specified text. */
public class Translation extends GenericModel {

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

  protected String translation;

  @SerializedName("part_of_speech")
  protected String partOfSpeech;

  /** Builder. */
  public static class Builder {
    private String translation;
    private String partOfSpeech;

    /**
     * Instantiates a new Builder from an existing Translation instance.
     *
     * @param translation the instance to initialize the Builder with
     */
    private Builder(Translation translation) {
      this.translation = translation.translation;
      this.partOfSpeech = translation.partOfSpeech;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param translation the translation
     */
    public Builder(String translation) {
      this.translation = translation;
    }

    /**
     * Builds a Translation.
     *
     * @return the new Translation instance
     */
    public Translation build() {
      return new Translation(this);
    }

    /**
     * Set the translation.
     *
     * @param translation the translation
     * @return the Translation builder
     */
    public Builder translation(String translation) {
      this.translation = translation;
      return this;
    }

    /**
     * Set the partOfSpeech.
     *
     * @param partOfSpeech the partOfSpeech
     * @return the Translation builder
     */
    public Builder partOfSpeech(String partOfSpeech) {
      this.partOfSpeech = partOfSpeech;
      return this;
    }
  }

  protected Translation() {}

  protected Translation(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.translation, "translation cannot be null");
    translation = builder.translation;
    partOfSpeech = builder.partOfSpeech;
  }

  /**
   * New builder.
   *
   * @return a Translation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the translation.
   *
   * <p>The phonetic or sounds-like translation for the word. A phonetic translation is based on the
   * SSML format for representing the phonetic string of a word either as an IPA translation or as
   * an IBM SPR translation. A sounds-like is one or more words that, when combined, sound like the
   * word.
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

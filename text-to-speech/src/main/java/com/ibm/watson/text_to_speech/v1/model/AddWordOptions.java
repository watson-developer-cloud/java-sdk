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
package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addWord options.
 */
public class AddWordOptions extends GenericModel {

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

  protected String customizationId;
  protected String word;
  protected String translation;
  protected String partOfSpeech;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String word;
    private String translation;
    private String partOfSpeech;

    private Builder(AddWordOptions addWordOptions) {
      this.customizationId = addWordOptions.customizationId;
      this.word = addWordOptions.word;
      this.translation = addWordOptions.translation;
      this.partOfSpeech = addWordOptions.partOfSpeech;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param word the word
     * @param translation the translation
     */
    public Builder(String customizationId, String word, String translation) {
      this.customizationId = customizationId;
      this.word = word;
      this.translation = translation;
    }

    /**
     * Builds a AddWordOptions.
     *
     * @return the addWordOptions
     */
    public AddWordOptions build() {
      return new AddWordOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the AddWordOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the word.
     *
     * @param word the word
     * @return the AddWordOptions builder
     */
    public Builder word(String word) {
      this.word = word;
      return this;
    }

    /**
     * Set the translation.
     *
     * @param translation the translation
     * @return the AddWordOptions builder
     */
    public Builder translation(String translation) {
      this.translation = translation;
      return this;
    }

    /**
     * Set the partOfSpeech.
     *
     * @param partOfSpeech the partOfSpeech
     * @return the AddWordOptions builder
     */
    public Builder partOfSpeech(String partOfSpeech) {
      this.partOfSpeech = partOfSpeech;
      return this;
    }

    /**
     * Set the translation.
     *
     * @param translation the translation
     * @return the AddWordOptions builder
     */
    public Builder translation(Translation translation) {
      this.translation = translation.translation();
      this.partOfSpeech = translation.partOfSpeech();
      return this;
    }
  }

  protected AddWordOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.customizationId,
        "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.word,
        "word cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.translation,
        "translation cannot be null");
    customizationId = builder.customizationId;
    word = builder.word;
    translation = builder.translation;
    partOfSpeech = builder.partOfSpeech;
  }

  /**
   * New builder.
   *
   * @return a AddWordOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom voice model. You must make the request with credentials for the instance
   * of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the word.
   *
   * The word that is to be added or updated for the custom voice model.
   *
   * @return the word
   */
  public String word() {
    return word;
  }

  /**
   * Gets the translation.
   *
   * The phonetic or sounds-like translation for the word. A phonetic translation is based on the SSML format for
   * representing the phonetic string of a word either as an IPA translation or as an IBM SPR translation. A sounds-like
   * is one or more words that, when combined, sound like the word.
   *
   * @return the translation
   */
  public String translation() {
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
  public String partOfSpeech() {
    return partOfSpeech;
  }
}

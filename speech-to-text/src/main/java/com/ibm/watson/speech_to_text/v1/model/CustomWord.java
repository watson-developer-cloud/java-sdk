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
package com.ibm.watson.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** Information about a word that is to be added to a custom language model. */
public class CustomWord extends GenericModel {

  protected String word;

  @SerializedName("sounds_like")
  protected List<String> soundsLike;

  @SerializedName("display_as")
  protected String displayAs;

  /** Builder. */
  public static class Builder {
    private String word;
    private List<String> soundsLike;
    private String displayAs;

    private Builder(CustomWord customWord) {
      this.word = customWord.word;
      this.soundsLike = customWord.soundsLike;
      this.displayAs = customWord.displayAs;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a CustomWord.
     *
     * @return the customWord
     */
    public CustomWord build() {
      return new CustomWord(this);
    }

    /**
     * Adds an soundsLike to soundsLike.
     *
     * @param soundsLike the new soundsLike
     * @return the CustomWord builder
     */
    public Builder addSoundsLike(String soundsLike) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(soundsLike, "soundsLike cannot be null");
      if (this.soundsLike == null) {
        this.soundsLike = new ArrayList<String>();
      }
      this.soundsLike.add(soundsLike);
      return this;
    }

    /**
     * Set the word.
     *
     * @param word the word
     * @return the CustomWord builder
     */
    public Builder word(String word) {
      this.word = word;
      return this;
    }

    /**
     * Set the soundsLike. Existing soundsLike will be replaced.
     *
     * @param soundsLike the soundsLike
     * @return the CustomWord builder
     */
    public Builder soundsLike(List<String> soundsLike) {
      this.soundsLike = soundsLike;
      return this;
    }

    /**
     * Set the displayAs.
     *
     * @param displayAs the displayAs
     * @return the CustomWord builder
     */
    public Builder displayAs(String displayAs) {
      this.displayAs = displayAs;
      return this;
    }
  }

  protected CustomWord(Builder builder) {
    word = builder.word;
    soundsLike = builder.soundsLike;
    displayAs = builder.displayAs;
  }

  /**
   * New builder.
   *
   * @return a CustomWord builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the word.
   *
   * <p>For the **Add custom words** method, you must specify the custom word that is to be added to
   * or updated in the custom model. Do not include spaces in the word. Use a `-` (dash) or `_`
   * (underscore) to connect the tokens of compound words.
   *
   * <p>Omit this parameter for the **Add a custom word** method.
   *
   * @return the word
   */
  public String word() {
    return word;
  }

  /**
   * Gets the soundsLike.
   *
   * <p>An array of sounds-like pronunciations for the custom word. Specify how words that are
   * difficult to pronounce, foreign words, acronyms, and so on can be pronounced by users. * For a
   * word that is not in the service's base vocabulary, omit the parameter to have the service
   * automatically generate a sounds-like pronunciation for the word. * For a word that is in the
   * service's base vocabulary, use the parameter to specify additional pronunciations for the word.
   * You cannot override the default pronunciation of a word; pronunciations you add augment the
   * pronunciation from the base vocabulary.
   *
   * <p>A word can have at most five sounds-like pronunciations. A pronunciation can include at most
   * 40 characters not including spaces.
   *
   * @return the soundsLike
   */
  public List<String> soundsLike() {
    return soundsLike;
  }

  /**
   * Gets the displayAs.
   *
   * <p>An alternative spelling for the custom word when it appears in a transcript. Use the
   * parameter when you want the word to have a spelling that is different from its usual
   * representation or from its spelling in corpora training data.
   *
   * @return the displayAs
   */
  public String displayAs() {
    return displayAs;
  }
}

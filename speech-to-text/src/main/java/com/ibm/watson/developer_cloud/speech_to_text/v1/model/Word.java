/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
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

import java.util.Arrays;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * Represents the Word in the context of a custom model's for {@link SpeechToText}.
 */
public class Word extends GenericModel {

  /**
   * The Enum Type to specify the type of words to be listed. The default is ALL.
   */
  public enum Type {
    ALL, /** The corpora and user words. */
    CORPORA, /** The corpora words. */
    USER /** The user words. */
  }

  /**
   * The Enum Sort to specify how words are to be sorted when listed. The default is ALPHA.
   */
  public enum Sort {

    /** Lexicographically (in ascending order). */
    ALPHA("alphabetical"),

    /** Lexicographically in ascending order. */
    PLUS_ALPHA("+alphabetical"),

    /** Lexicographically in descending order. */
    MINUS_ALPHA("-alphabetical"),

    /** By count (in descending order). */
    COUNT("count"),

    /** By count in ascending order. */
    PLUS_COUNT("+count"),

    /** By count in descending order. */
    MINUS_COUNT("-count");

    private String sort;

    private Sort(String s) {
      sort = s;
    }

    public String getSort() {
      return sort;
    }
  }

  @SerializedName("display_as")
  private String displayAs;
  @SerializedName("sounds_like")
  private List<String> soundsLike;
  private String word;

  /**
   * Instantiates a new word.
   */
  public Word() { }

  /**
   * Instantiates a new word.
   *
   * @param word the spelling of the word is used to train the model.
   * @param displayAs the spelling of the custom word that the service uses to display the word in a transcript.
   * @param soundsLike An array of pronunciations for the custom word.
   */
  public Word(String word, String displayAs, String... soundsLike) {
    this();
    this.word = word;
    this.displayAs = displayAs;
    this.soundsLike = Arrays.asList(soundsLike);
  }

  /**
   * Gets the spelling of the custom word that the service uses to display the word in a transcript.
   *
   * @return The displayAs
   */
  public String getDisplayAs() {
    return displayAs;
  }

  /**
   * Gets the sounds like. An array of pronunciations for the custom word
   *
   * @return The soundsLike
   */
  public List<String> getSoundsLike() {
    return soundsLike;
  }

  /**
   * Gets the spelling of the word is used to train the model.
   *
   * @return The word
   */
  public String getWord() {
    return word;
  }

  /**
   * Sets the spelling of the custom word that the service uses to display the word in a transcript.
   *
   * @param displayAs The display_as
   */
  public void setDisplayAs(String displayAs) {
    this.displayAs = displayAs;
  }

  /**
   * Sets the sounds like. An array of pronunciations for the custom word.
   *
   * @param soundsLike The sounds_like
   */
  public void setSoundsLike(List<String> soundsLike) {
    this.soundsLike = soundsLike;
  }

  /**
   * Sets the word.
   *
   * @param word The word
   */
  public void setWord(String word) {
    this.word = word;
  }

}

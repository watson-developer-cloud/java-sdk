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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * Represents the Word in the context of a custom model's for {@link SpeechToText}.
 */
public class Word extends GenericModel {

  public enum Type {
    ALL, CORPORA, USER
  }

  @SerializedName("display_as")
  private String displayAs;
  @SerializedName("sounds_like")
  private List<String> soundsLike;
  private String word;

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
   * Gets the word.
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

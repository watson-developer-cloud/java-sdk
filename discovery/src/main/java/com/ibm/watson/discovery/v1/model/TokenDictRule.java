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
package com.ibm.watson.discovery.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object defining a single tokenizaion rule.
 */
public class TokenDictRule extends GenericModel {

  private String text;
  private List<String> tokens;
  private List<String> readings;
  @SerializedName("part_of_speech")
  private String partOfSpeech;

  /**
   * Gets the text.
   *
   * The string to tokenize.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the tokens.
   *
   * Array of tokens that the `text` field is split into when found.
   *
   * @return the tokens
   */
  public List<String> getTokens() {
    return tokens;
  }

  /**
   * Gets the readings.
   *
   * Array of tokens that represent the content of the `text` field in an alternate character set.
   *
   * @return the readings
   */
  public List<String> getReadings() {
    return readings;
  }

  /**
   * Gets the partOfSpeech.
   *
   * The part of speech that the `text` string belongs to. For example `noun`. Custom parts of speech can be specified.
   *
   * @return the partOfSpeech
   */
  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Sets the tokens.
   *
   * @param tokens the new tokens
   */
  public void setTokens(final List<String> tokens) {
    this.tokens = tokens;
  }

  /**
   * Sets the readings.
   *
   * @param readings the new readings
   */
  public void setReadings(final List<String> readings) {
    this.readings = readings;
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

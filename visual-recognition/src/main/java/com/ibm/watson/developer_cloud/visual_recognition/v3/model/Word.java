/*
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

package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

/**
 * The recognized word in an image.
 *
 * See {@link VisualRecognition}
 */
public class Word {

  @SerializedName("line_number")
  private Integer lineNumber;
  private Location location;
  private Double score;
  private String word;

  /**
   * Gets the line number.
   *
   * @return the line number
   */
  public Integer getLineNumber() {
    return lineNumber;
  }

  /**
   * Gets the location.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Gets the word.
   *
   * @return the word
   */
  public String getWord() {
    return word;
  }

  /**
   * Sets the line number.
   *
   * @param lineNumber the new line number
   */
  public void setLineNumber(Integer lineNumber) {
    this.lineNumber = lineNumber;
  }

  /**
   * Sets the location.
   *
   * @param location the new location
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(Double score) {
    this.score = score;
  }

  /**
   * Sets the word.
   *
   * @param word the new word
   */
  public void setWord(String word) {
    this.word = word;
  }
}

/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Object representing scoring of a single Tone (of any category) on our responses. It contains the
 * Tone ID, a score, and optionally a list of evidences.
 */
public class ToneScore extends GenericModel {

  @SerializedName("tone_id")
  private String id;

  @SerializedName("tone_name")
  private String name;

  /** The score. */
  private Double score;

  /**
   * Instantiates a new tone score.
   */
  public ToneScore() {

  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
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
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(Double score) {
    this.score = score;
  }

}

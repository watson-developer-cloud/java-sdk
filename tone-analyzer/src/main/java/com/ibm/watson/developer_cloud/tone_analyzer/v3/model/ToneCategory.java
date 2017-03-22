/**
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
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Top level tone (or Tone Category) from the list of Writing Tone, Emotion Tone or Social Tone. It holds a list of
 * scores for individual Tones.
 */
public class ToneCategory extends GenericModel {

  @SerializedName("category_id")
  private String id;
  @SerializedName("category_name")
  private String name;
  private List<ToneScore> tones;

  /**
   * Adds the tone.
   *
   * @param score the score
   */
  public void addTone(ToneScore score) {
    tones.add(score);
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
   * Gets the tones.
   *
   * @return the tones
   */
  public List<ToneScore> getTones() {
    return tones;
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
   * Sets the tones.
   *
   * @param tones the new tones
   */
  public void setTones(List<ToneScore> tones) {
    this.tones = tones;
  }
}

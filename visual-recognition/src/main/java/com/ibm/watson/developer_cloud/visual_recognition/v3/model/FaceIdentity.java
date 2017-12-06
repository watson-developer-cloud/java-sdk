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
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Provides information about a celebrity who is detected in the image. Not returned when a celebrity is not detected.
 */
public class FaceIdentity extends GenericModel {

  private String name;
  private Float score;
  @SerializedName("type_hierarchy")
  private String typeHierarchy;

  /**
   * Gets the name.
   *
   * Name of the person.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the score.
   *
   * Confidence score for the property. Scores range from 0-1, with a higher score indicating greater correlation.
   *
   * @return the score
   */
  public Float getScore() {
    return score;
  }

  /**
   * Gets the typeHierarchy.
   *
   * Knowledge graph of the property. For example, `People/Leaders/Presidents/USA/Barack Obama`. Included only if
   * identified.
   *
   * @return the typeHierarchy
   */
  public String getTypeHierarchy() {
    return typeHierarchy;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(final Float score) {
    this.score = score;
  }

  /**
   * Sets the typeHierarchy.
   *
   * @param typeHierarchy the new typeHierarchy
   */
  public void setTypeHierarchy(final String typeHierarchy) {
    this.typeHierarchy = typeHierarchy;
  }
}

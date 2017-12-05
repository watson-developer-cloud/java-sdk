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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Provides information about the gender of the face. If there are more than 10 faces in an image, the response might
 * return the confidence score 0.
 */
public class FaceGender extends GenericModel {

  private String gender;
  private Float score;

  /**
   * Gets the gender.
   *
   * Gender identified by the face. For example, `MALE` or `FEMALE`
   *
   * @return the gender
   */
  public String getGender() {
    return gender;
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
   * Sets the gender.
   *
   * @param gender the new gender
   */
  public void setGender(final String gender) {
    this.gender = gender;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(final Float score) {
    this.score = score;
  }
}

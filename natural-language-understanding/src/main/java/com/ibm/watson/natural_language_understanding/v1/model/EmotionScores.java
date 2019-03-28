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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * EmotionScores.
 */
public class EmotionScores extends GenericModel {

  private Double anger;
  private Double disgust;
  private Double fear;
  private Double joy;
  private Double sadness;

  /**
   * Gets the anger.
   *
   * Anger score from 0 to 1. A higher score means that the text is more likely to convey anger.
   *
   * @return the anger
   */
  public Double getAnger() {
    return anger;
  }

  /**
   * Gets the disgust.
   *
   * Disgust score from 0 to 1. A higher score means that the text is more likely to convey disgust.
   *
   * @return the disgust
   */
  public Double getDisgust() {
    return disgust;
  }

  /**
   * Gets the fear.
   *
   * Fear score from 0 to 1. A higher score means that the text is more likely to convey fear.
   *
   * @return the fear
   */
  public Double getFear() {
    return fear;
  }

  /**
   * Gets the joy.
   *
   * Joy score from 0 to 1. A higher score means that the text is more likely to convey joy.
   *
   * @return the joy
   */
  public Double getJoy() {
    return joy;
  }

  /**
   * Gets the sadness.
   *
   * Sadness score from 0 to 1. A higher score means that the text is more likely to convey sadness.
   *
   * @return the sadness
   */
  public Double getSadness() {
    return sadness;
  }
}

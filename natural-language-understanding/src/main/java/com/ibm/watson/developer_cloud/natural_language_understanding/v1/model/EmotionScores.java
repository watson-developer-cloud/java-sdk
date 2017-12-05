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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

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
   * Anger score from 0 to 1. A higher score means that the text is more likely to convey anger
   *
   * @return the anger
   */
  public Double getAnger() {
    return anger;
  }

  /**
   * Gets the disgust.
   *
   * Disgust score from 0 to 1. A higher score means that the text is more likely to convey disgust
   *
   * @return the disgust
   */
  public Double getDisgust() {
    return disgust;
  }

  /**
   * Gets the fear.
   *
   * Fear score from 0 to 1. A higher score means that the text is more likely to convey fear
   *
   * @return the fear
   */
  public Double getFear() {
    return fear;
  }

  /**
   * Gets the joy.
   *
   * Joy score from 0 to 1. A higher score means that the text is more likely to convey joy
   *
   * @return the joy
   */
  public Double getJoy() {
    return joy;
  }

  /**
   * Gets the sadness.
   *
   * Sadness score from 0 to 1. A higher score means that the text is more likely to convey sadness
   *
   * @return the sadness
   */
  public Double getSadness() {
    return sadness;
  }

  /**
   * Sets the anger.
   *
   * @param anger the new anger
   */
  public void setAnger(final Double anger) {
    this.anger = anger;
  }

  /**
   * Sets the disgust.
   *
   * @param disgust the new disgust
   */
  public void setDisgust(final Double disgust) {
    this.disgust = disgust;
  }

  /**
   * Sets the fear.
   *
   * @param fear the new fear
   */
  public void setFear(final Double fear) {
    this.fear = fear;
  }

  /**
   * Sets the joy.
   *
   * @param joy the new joy
   */
  public void setJoy(final Double joy) {
    this.joy = joy;
  }

  /**
   * Sets the sadness.
   *
   * @param sadness the new sadness
   */
  public void setSadness(final Double sadness) {
    this.sadness = sadness;
  }
}

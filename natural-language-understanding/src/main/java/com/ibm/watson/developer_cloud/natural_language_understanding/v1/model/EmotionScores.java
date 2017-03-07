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

import java.math.BigDecimal;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * EmotionScores
 */
public class EmotionScores extends GenericModel {

  /** Anger score from 0 to 1. A higher score means that the text is more likely to convey anger. */
  private BigDecimal anger;
  /** Disgust score from 0 to 1. A higher score means that the text is more likely to convey disgust. */
  private BigDecimal disgust;
  /** Fear score from 0 to 1. A higher score means that the text is more likely to convey fear. */
  private BigDecimal fear;
  /** Joy score from 0 to 1. A higher score means that the text is more likely to convey joy. */
  private BigDecimal joy;
  /** Sadness score from 0 to 1. A higher score means that the text is more likely to convey sadness. */
  private BigDecimal sadness;

  /**
   * Instantiates a new `EmotionScores`
   *
   * @param anger Anger score from 0 to 1. A higher score means that the text is more likely to convey anger.
   * @param disgust Disgust score from 0 to 1. A higher score means that the text is more likely to convey disgust.
   * @param fear Fear score from 0 to 1. A higher score means that the text is more likely to convey fear.
   * @param joy Joy score from 0 to 1. A higher score means that the text is more likely to convey joy.
   * @param sadness Sadness score from 0 to 1. A higher score means that the text is more likely to convey sadness.
   */
  public EmotionScores(final BigDecimal anger, final BigDecimal disgust, final BigDecimal fear, final BigDecimal joy, final BigDecimal sadness) {
    this.anger = anger;
    this.disgust = disgust;
    this.fear = fear;
    this.joy = joy;
    this.sadness = sadness;
  }

  /**
   * Gets the anger.
   *
   * @return the anger
   */
  public BigDecimal getAnger() {
    return anger;
  }

  /**
   * Gets the disgust.
   *
   * @return the disgust
   */
  public BigDecimal getDisgust() {
    return disgust;
  }

  /**
   * Gets the fear.
   *
   * @return the fear
   */
  public BigDecimal getFear() {
    return fear;
  }

  /**
   * Gets the joy.
   *
   * @return the joy
   */
  public BigDecimal getJoy() {
    return joy;
  }

  /**
   * Gets the sadness.
   *
   * @return the sadness
   */
  public BigDecimal getSadness() {
    return sadness;
  }

  /**
   * Sets the anger.
   *
   * @param anger the new anger
   */
  public void setAnger(final BigDecimal anger) {
    this.anger = anger;
  }

  /**
   * Sets the disgust.
   *
   * @param disgust the new disgust
   */
  public void setDisgust(final BigDecimal disgust) {
    this.disgust = disgust;
  }

  /**
   * Sets the fear.
   *
   * @param fear the new fear
   */
  public void setFear(final BigDecimal fear) {
    this.fear = fear;
  }

  /**
   * Sets the joy.
   *
   * @param joy the new joy
   */
  public void setJoy(final BigDecimal joy) {
    this.joy = joy;
  }

  /**
   * Sets the sadness.
   *
   * @param sadness the new sadness
   */
  public void setSadness(final BigDecimal sadness) {
    this.sadness = sadness;
  }

}

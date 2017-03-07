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

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionScores;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * TargetedEmotionResults
 */
public class TargetedEmotionResults extends GenericModel {

  /** Targeted text. */
  private String text;
  /** Anger score from 0 to 1. A higher score means that the text is more likely to convey anger. */
  private Long anger;
  /** Disgust score from 0 to 1. A higher score means that the text is more likely to convey disgust. */
  private Long disgust;
  /** Fear score from 0 to 1. A higher score means that the text is more likely to convey fear. */
  private Long fear;
  /** Joy score from 0 to 1. A higher score means that the text is more likely to convey joy. */
  private Long joy;
  /** Sadness score from 0 to 1. A higher score means that the text is more likely to convey sadness. */
  private Long sadness;

  /**
   * Instantiates a new `TargetedEmotionResults`
   *
   * @param text Targeted text.
   * @param anger Anger score from 0 to 1. A higher score means that the text is more likely to convey anger.
   * @param disgust Disgust score from 0 to 1. A higher score means that the text is more likely to convey disgust.
   * @param fear Fear score from 0 to 1. A higher score means that the text is more likely to convey fear.
   * @param joy Joy score from 0 to 1. A higher score means that the text is more likely to convey joy.
   * @param sadness Sadness score from 0 to 1. A higher score means that the text is more likely to convey sadness.
   */
  public TargetedEmotionResults(final String text, final Long anger, final Long disgust, final Long fear, final Long joy, final Long sadness) {
    this.text = text;
    this.anger = anger;
    this.disgust = disgust;
    this.fear = fear;
    this.joy = joy;
    this.sadness = sadness;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the anger.
   *
   * @return the anger
   */
  public Long getAnger() {
    return anger;
  }

  /**
   * Gets the disgust.
   *
   * @return the disgust
   */
  public Long getDisgust() {
    return disgust;
  }

  /**
   * Gets the fear.
   *
   * @return the fear
   */
  public Long getFear() {
    return fear;
  }

  /**
   * Gets the joy.
   *
   * @return the joy
   */
  public Long getJoy() {
    return joy;
  }

  /**
   * Gets the sadness.
   *
   * @return the sadness
   */
  public Long getSadness() {
    return sadness;
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
   * Sets the anger.
   *
   * @param anger the new anger
   */
  public void setAnger(final Long anger) {
    this.anger = anger;
  }

  /**
   * Sets the disgust.
   *
   * @param disgust the new disgust
   */
  public void setDisgust(final Long disgust) {
    this.disgust = disgust;
  }

  /**
   * Sets the fear.
   *
   * @param fear the new fear
   */
  public void setFear(final Long fear) {
    this.fear = fear;
  }

  /**
   * Sets the joy.
   *
   * @param joy the new joy
   */
  public void setJoy(final Long joy) {
    this.joy = joy;
  }

  /**
   * Sets the sadness.
   *
   * @param sadness the new sadness
   */
  public void setSadness(final Long sadness) {
    this.sadness = sadness;
  }

}

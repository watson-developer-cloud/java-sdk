/*
 * (C) Copyright IBM Corp. 2017, 2023.
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

/** EmotionScores. */
public class EmotionScores extends GenericModel {

  protected Double anger;
  protected Double disgust;
  protected Double fear;
  protected Double joy;
  protected Double sadness;

  protected EmotionScores() {}

  /**
   * Gets the anger.
   *
   * <p>Anger score from 0 to 1. A higher score means that the text is more likely to convey anger.
   *
   * @return the anger
   */
  public Double getAnger() {
    return anger;
  }

  /**
   * Gets the disgust.
   *
   * <p>Disgust score from 0 to 1. A higher score means that the text is more likely to convey
   * disgust.
   *
   * @return the disgust
   */
  public Double getDisgust() {
    return disgust;
  }

  /**
   * Gets the fear.
   *
   * <p>Fear score from 0 to 1. A higher score means that the text is more likely to convey fear.
   *
   * @return the fear
   */
  public Double getFear() {
    return fear;
  }

  /**
   * Gets the joy.
   *
   * <p>Joy score from 0 to 1. A higher score means that the text is more likely to convey joy.
   *
   * @return the joy
   */
  public Double getJoy() {
    return joy;
  }

  /**
   * Gets the sadness.
   *
   * <p>Sadness score from 0 to 1. A higher score means that the text is more likely to convey
   * sadness.
   *
   * @return the sadness
   */
  public Double getSadness() {
    return sadness;
  }
}

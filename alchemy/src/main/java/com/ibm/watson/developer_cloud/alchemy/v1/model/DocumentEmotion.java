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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The document emotion from {@link AlchemyLanguage#getEmotion(java.util.Map)}.
 *
 */
public class DocumentEmotion extends AlchemyLanguageGenericModel {

  /**
   * The extracted emotion from {@link AlchemyLanguage#getEmotion(java.util.Map)}.
   */
  public static class Emotion extends GenericModel {
    private Double anger;
    private Double disgust;
    private Double fear;
    private Double joy;
    private Double sadness;

    /**
     * Gets the anger.
     *
     * @return the anger
     */
    public Double getAnger() {
      return anger;
    }

    /**
     * Gets the disgust.
     *
     * @return the disgust
     */
    public Double getDisgust() {
      return disgust;
    }

    /**
     * Gets the fear.
     *
     * @return the fear
     */
    public Double getFear() {
      return fear;
    }

    /**
     * Gets the joy.
     *
     * @return the joy
     */
    public Double getJoy() {
      return joy;
    }

    /**
     * Gets the sadness.
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
    public void setAnger(Double anger) {
      this.anger = anger;
    }

    /**
     * Sets the disgust.
     *
     * @param disgust the new disgust
     */
    public void setDisgust(Double disgust) {
      this.disgust = disgust;
    }

    /**
     * Sets the fear.
     *
     * @param fear the new fear
     */
    public void setFear(Double fear) {
      this.fear = fear;
    }

    /**
     * Sets the joy.
     *
     * @param joy the new joy
     */
    public void setJoy(Double joy) {
      this.joy = joy;
    }

    /**
     * Sets the sadness.
     *
     * @param sadness the new sadness
     */
    public void setSadness(Double sadness) {
      this.sadness = sadness;
    }

  }

  @SerializedName("docEmotions")
  private Emotion emotion;

  private String text;

  /**
   * Gets the emotion.
   *
   * @return the emotion
   */
  public Emotion getEmotion() {
    return emotion;
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
   * Sets the emotion.
   *
   * @param emotion the new emotion
   */
  public void setEmotion(Emotion emotion) {
    this.emotion = emotion;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
  }
}


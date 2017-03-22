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

import java.util.List;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ImageSceneTextLine returned by {@link AlchemyVision#getImageSceneText(java.io.File)}.
 *
 */
public class ImageSceneTextLine extends GenericModel {

  /**
   * Region.
   */
  public static class Region extends GenericModel {

    /** The height. */
    private Integer height;

    /** The width. */
    private Integer width;

    /** The x. */
    private Integer x;

    /** The y. */
    private Integer y;

    /**
     * Gets the region height.
     *
     * @return The height
     */
    public Integer getHeight() {
      return height;
    }

    /**
     * Gets the region width.
     *
     * @return The width
     */
    public Integer getWidth() {
      return width;
    }

    /**
     * Gets the region x.
     *
     * @return The x
     */
    public Integer getX() {
      return x;
    }

    /**
     * Gets the region y.
     *
     * @return The y
     */
    public Integer getY() {
      return y;
    }

    /**
     * Sets the region height.
     *
     * @param height The height
     */
    public void setHeight(Integer height) {
      this.height = height;
    }

    /**
     * Sets the region width.
     *
     * @param width The width
     */
    public void setWidth(Integer width) {
      this.width = width;
    }

    /**
     * Sets the region x.
     *
     * @param x The x.
     */
    public void setX(Integer x) {
      this.x = x;
    }

    /**
     * Sets the region y.
     *
     * @param y The y
     */
    public void setY(Integer y) {
      this.y = y;
    }
  }

  /**
   * A word within a line of text.
   */
  public static class Word extends GenericModel {

    /** The confidence. */
    private Double confidence;

    /** The region. */
    private Region region;

    /** The text. */
    private String text;

    /**
     * Gets the confidence.
     *
     * @return The confidence
     */
    public Double getConfidence() {
      return confidence;
    }

    /**
     * Gets the region.
     *
     * @return The region
     */
    public Region getRegion() {
      return region;
    }

    /**
     * Gets the text.
     *
     * @return The text
     */
    public String getText() {
      return text;
    }

    /**
     * Sets the confidence.
     *
     * @param confidence The confidence
     */
    public void setConfidence(Double confidence) {
      this.confidence = confidence;
    }

    /**
     * Sets the region.
     *
     * @param region The region
     */
    public void setRegion(Region region) {
      this.region = region;
    }

    /**
     * Sets the text.
     *
     * @param text The text
     */
    public void setText(String text) {
      this.text = text;
    }

  }

  /** The confidence. */
  private Double confidence;

  /** The region. */
  private Region region;

  /** The text. */
  private String text;

  /** The words. */
  private List<Word> words;

  /**
   * Gets the confidence.
   *
   * @return The confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the region.
   *
   * @return The region
   */
  public Region getRegion() {
    return region;
  }

  /**
   * Gets the text.
   *
   * @return The text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the words.
   *
   * @return The words
   */
  public List<Word> getWords() {
    return words;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence The confidence
   */
  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }

  /**
   * Sets the region.
   *
   * @param region The region
   */
  public void setRegion(Region region) {
    this.region = region;
  }

  /**
   * Sets the text.
   *
   * @param text The text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Sets the words.
   *
   * @param words The words
   */
  public void setWords(List<Word> words) {
    this.words = words;
  }

}

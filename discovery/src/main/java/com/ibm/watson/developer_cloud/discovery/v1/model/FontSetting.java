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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * FontSetting.
 */
public class FontSetting extends GenericModel {

  private Long level;
  @SerializedName("min_size")
  private Long minSize;
  @SerializedName("max_size")
  private Long maxSize;
  private Boolean bold;
  private Boolean italic;
  private String name;

  /**
   * Builder.
   */
  public static class Builder {
    private Long level;
    private Long minSize;
    private Long maxSize;
    private Boolean bold;
    private Boolean italic;
    private String name;

    private Builder(FontSetting fontSetting) {
      level = fontSetting.level;
      minSize = fontSetting.minSize;
      maxSize = fontSetting.maxSize;
      bold = fontSetting.bold;
      italic = fontSetting.italic;
      name = fontSetting.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a FontSetting.
     *
     * @return the fontSetting
     */
    public FontSetting build() {
      return new FontSetting(this);
    }

    /**
     * Set the level.
     *
     * @param level the level
     * @return the FontSetting builder
     */
    public Builder level(long level) {
      this.level = level;
      return this;
    }

    /**
     * Set the minSize.
     *
     * @param minSize the minSize
     * @return the FontSetting builder
     */
    public Builder minSize(long minSize) {
      this.minSize = minSize;
      return this;
    }

    /**
     * Set the maxSize.
     *
     * @param maxSize the maxSize
     * @return the FontSetting builder
     */
    public Builder maxSize(long maxSize) {
      this.maxSize = maxSize;
      return this;
    }

    /**
     * Set the bold.
     *
     * @param bold the bold
     * @return the FontSetting builder
     */
    public Builder bold(Boolean bold) {
      this.bold = bold;
      return this;
    }

    /**
     * Set the italic.
     *
     * @param italic the italic
     * @return the FontSetting builder
     */
    public Builder italic(Boolean italic) {
      this.italic = italic;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the FontSetting builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  private FontSetting(Builder builder) {
    level = builder.level;
    minSize = builder.minSize;
    maxSize = builder.maxSize;
    bold = builder.bold;
    italic = builder.italic;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a FontSetting builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the level.
   *
   * @return the level
   */
  public Long level() {
    return level;
  }

  /**
   * Gets the minSize.
   *
   * @return the minSize
   */
  public Long minSize() {
    return minSize;
  }

  /**
   * Gets the maxSize.
   *
   * @return the maxSize
   */
  public Long maxSize() {
    return maxSize;
  }

  /**
   * Gets the bold.
   *
   * @return the bold
   */
  public Boolean bold() {
    return bold;
  }

  /**
   * Gets the italic.
   *
   * @return the italic
   */
  public Boolean italic() {
    return italic;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

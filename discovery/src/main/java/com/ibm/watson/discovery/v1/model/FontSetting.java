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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

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
   * Gets the level.
   *
   * The HTML heading level that any content with the matching font will be converted to.
   *
   * @return the level
   */
  public Long getLevel() {
    return level;
  }

  /**
   * Gets the minSize.
   *
   * The minimum size of the font to match.
   *
   * @return the minSize
   */
  public Long getMinSize() {
    return minSize;
  }

  /**
   * Gets the maxSize.
   *
   * The maximum size of the font to match.
   *
   * @return the maxSize
   */
  public Long getMaxSize() {
    return maxSize;
  }

  /**
   * Gets the bold.
   *
   * When `true`, the font is matched if it is bold.
   *
   * @return the bold
   */
  public Boolean isBold() {
    return bold;
  }

  /**
   * Gets the italic.
   *
   * When `true`, the font is matched if it is italic.
   *
   * @return the italic
   */
  public Boolean isItalic() {
    return italic;
  }

  /**
   * Gets the name.
   *
   * The name of the font.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the level.
   *
   * @param level the new level
   */
  public void setLevel(final long level) {
    this.level = level;
  }

  /**
   * Sets the minSize.
   *
   * @param minSize the new minSize
   */
  public void setMinSize(final long minSize) {
    this.minSize = minSize;
  }

  /**
   * Sets the maxSize.
   *
   * @param maxSize the new maxSize
   */
  public void setMaxSize(final long maxSize) {
    this.maxSize = maxSize;
  }

  /**
   * Sets the bold.
   *
   * @param bold the new bold
   */
  public void setBold(final Boolean bold) {
    this.bold = bold;
  }

  /**
   * Sets the italic.
   *
   * @param italic the new italic
   */
  public void setItalic(final Boolean italic) {
    this.italic = italic;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }
}

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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * WordHeadingDetection.
 */
public class WordHeadingDetection extends GenericModel {

  private List<FontSetting> fonts;
  private List<WordStyle> styles;

  /**
   * Gets the fonts.
   *
   * @return the fonts
   */
  public List<FontSetting> getFonts() {
    return fonts;
  }

  /**
   * Gets the styles.
   *
   * @return the styles
   */
  public List<WordStyle> getStyles() {
    return styles;
  }

  /**
   * Sets the fonts.
   *
   * @param fonts the new fonts
   */
  public void setFonts(final List<FontSetting> fonts) {
    this.fonts = fonts;
  }

  /**
   * Sets the styles.
   *
   * @param styles the new styles
   */
  public void setStyles(final List<WordStyle> styles) {
    this.styles = styles;
  }
}

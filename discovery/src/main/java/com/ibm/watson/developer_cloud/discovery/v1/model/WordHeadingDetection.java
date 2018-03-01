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

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * WordHeadingDetection.
 */
public class WordHeadingDetection extends GenericModel {

  private List<FontSetting> fonts;
  private List<WordStyle> styles;

  /**
   * Builder.
   */
  public static class Builder {
    private List<FontSetting> fonts;
    private List<WordStyle> styles;

    private Builder(WordHeadingDetection wordHeadingDetection) {
      fonts = wordHeadingDetection.fonts;
      styles = wordHeadingDetection.styles;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a WordHeadingDetection.
     *
     * @return the wordHeadingDetection
     */
    public WordHeadingDetection build() {
      return new WordHeadingDetection(this);
    }

    /**
     * Adds an fonts to fonts.
     *
     * @param fonts the new fonts
     * @return the WordHeadingDetection builder
     */
    public Builder addFonts(FontSetting fonts) {
      Validator.notNull(fonts, "fonts cannot be null");
      if (this.fonts == null) {
        this.fonts = new ArrayList<FontSetting>();
      }
      this.fonts.add(fonts);
      return this;
    }

    /**
     * Adds an styles to styles.
     *
     * @param styles the new styles
     * @return the WordHeadingDetection builder
     */
    public Builder addStyles(WordStyle styles) {
      Validator.notNull(styles, "styles cannot be null");
      if (this.styles == null) {
        this.styles = new ArrayList<WordStyle>();
      }
      this.styles.add(styles);
      return this;
    }

    /**
     * Set the fonts.
     * Existing fonts will be replaced.
     *
     * @param fonts the fonts
     * @return the WordHeadingDetection builder
     */
    public Builder fonts(List<FontSetting> fonts) {
      this.fonts = fonts;
      return this;
    }

    /**
     * Set the styles.
     * Existing styles will be replaced.
     *
     * @param styles the styles
     * @return the WordHeadingDetection builder
     */
    public Builder styles(List<WordStyle> styles) {
      this.styles = styles;
      return this;
    }
  }

  private WordHeadingDetection(Builder builder) {
    fonts = builder.fonts;
    styles = builder.styles;
  }

  /**
   * New builder.
   *
   * @return a WordHeadingDetection builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the fonts.
   *
   * @return the fonts
   */
  public List<FontSetting> fonts() {
    return fonts;
  }

  /**
   * Gets the styles.
   *
   * @return the styles
   */
  public List<WordStyle> styles() {
    return styles;
  }
}

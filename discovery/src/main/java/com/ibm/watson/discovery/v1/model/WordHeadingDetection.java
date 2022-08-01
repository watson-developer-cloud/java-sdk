/*
 * (C) Copyright IBM Corp. 2022.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** Object containing heading detection conversion settings for Microsoft Word documents. */
public class WordHeadingDetection extends GenericModel {

  protected List<FontSetting> fonts;
  protected List<WordStyle> styles;

  /** Builder. */
  public static class Builder {
    private List<FontSetting> fonts;
    private List<WordStyle> styles;

    private Builder(WordHeadingDetection wordHeadingDetection) {
      this.fonts = wordHeadingDetection.fonts;
      this.styles = wordHeadingDetection.styles;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a WordHeadingDetection.
     *
     * @return the new WordHeadingDetection instance
     */
    public WordHeadingDetection build() {
      return new WordHeadingDetection(this);
    }

    /**
     * Adds an fontSetting to fonts.
     *
     * @param fontSetting the new fontSetting
     * @return the WordHeadingDetection builder
     */
    public Builder addFontSetting(FontSetting fontSetting) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(fontSetting, "fontSetting cannot be null");
      if (this.fonts == null) {
        this.fonts = new ArrayList<FontSetting>();
      }
      this.fonts.add(fontSetting);
      return this;
    }

    /**
     * Adds an wordStyle to styles.
     *
     * @param wordStyle the new wordStyle
     * @return the WordHeadingDetection builder
     */
    public Builder addWordStyle(WordStyle wordStyle) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(wordStyle, "wordStyle cannot be null");
      if (this.styles == null) {
        this.styles = new ArrayList<WordStyle>();
      }
      this.styles.add(wordStyle);
      return this;
    }

    /**
     * Set the fonts. Existing fonts will be replaced.
     *
     * @param fonts the fonts
     * @return the WordHeadingDetection builder
     */
    public Builder fonts(List<FontSetting> fonts) {
      this.fonts = fonts;
      return this;
    }

    /**
     * Set the styles. Existing styles will be replaced.
     *
     * @param styles the styles
     * @return the WordHeadingDetection builder
     */
    public Builder styles(List<WordStyle> styles) {
      this.styles = styles;
      return this;
    }
  }

  protected WordHeadingDetection() {}

  protected WordHeadingDetection(Builder builder) {
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
   * <p>Array of font matching configurations.
   *
   * @return the fonts
   */
  public List<FontSetting> fonts() {
    return fonts;
  }

  /**
   * Gets the styles.
   *
   * <p>Array of Microsoft Word styles to convert.
   *
   * @return the styles
   */
  public List<WordStyle> styles() {
    return styles;
  }
}

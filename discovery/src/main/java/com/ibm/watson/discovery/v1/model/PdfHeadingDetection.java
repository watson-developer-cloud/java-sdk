/*
 * (C) Copyright IBM Corp. 2024.
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

/** Object containing heading detection conversion settings for PDF documents. */
public class PdfHeadingDetection extends GenericModel {

  protected List<FontSetting> fonts;

  /** Builder. */
  public static class Builder {
    private List<FontSetting> fonts;

    /**
     * Instantiates a new Builder from an existing PdfHeadingDetection instance.
     *
     * @param pdfHeadingDetection the instance to initialize the Builder with
     */
    private Builder(PdfHeadingDetection pdfHeadingDetection) {
      this.fonts = pdfHeadingDetection.fonts;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a PdfHeadingDetection.
     *
     * @return the new PdfHeadingDetection instance
     */
    public PdfHeadingDetection build() {
      return new PdfHeadingDetection(this);
    }

    /**
     * Adds a new element to fonts.
     *
     * @param fontSetting the new element to be added
     * @return the PdfHeadingDetection builder
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
     * Set the fonts. Existing fonts will be replaced.
     *
     * @param fonts the fonts
     * @return the PdfHeadingDetection builder
     */
    public Builder fonts(List<FontSetting> fonts) {
      this.fonts = fonts;
      return this;
    }
  }

  protected PdfHeadingDetection() {}

  protected PdfHeadingDetection(Builder builder) {
    fonts = builder.fonts;
  }

  /**
   * New builder.
   *
   * @return a PdfHeadingDetection builder
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
}

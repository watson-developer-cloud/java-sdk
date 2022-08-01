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

/** A list of PDF conversion settings. */
public class PdfSettings extends GenericModel {

  protected PdfHeadingDetection heading;

  /** Builder. */
  public static class Builder {
    private PdfHeadingDetection heading;

    private Builder(PdfSettings pdfSettings) {
      this.heading = pdfSettings.heading;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a PdfSettings.
     *
     * @return the new PdfSettings instance
     */
    public PdfSettings build() {
      return new PdfSettings(this);
    }

    /**
     * Set the heading.
     *
     * @param heading the heading
     * @return the PdfSettings builder
     */
    public Builder heading(PdfHeadingDetection heading) {
      this.heading = heading;
      return this;
    }
  }

  protected PdfSettings() {}

  protected PdfSettings(Builder builder) {
    heading = builder.heading;
  }

  /**
   * New builder.
   *
   * @return a PdfSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the heading.
   *
   * <p>Object containing heading detection conversion settings for PDF documents.
   *
   * @return the heading
   */
  public PdfHeadingDetection heading() {
    return heading;
  }
}

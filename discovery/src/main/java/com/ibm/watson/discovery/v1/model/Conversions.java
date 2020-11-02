/*
 * (C) Copyright IBM Corp. 2020.
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
import java.util.ArrayList;
import java.util.List;

/** Document conversion settings. */
public class Conversions extends GenericModel {

  protected PdfSettings pdf;
  protected WordSettings word;
  protected HtmlSettings html;
  protected SegmentSettings segment;

  @SerializedName("json_normalizations")
  protected List<NormalizationOperation> jsonNormalizations;

  @SerializedName("image_text_recognition")
  protected Boolean imageTextRecognition;

  /** Builder. */
  public static class Builder {
    private PdfSettings pdf;
    private WordSettings word;
    private HtmlSettings html;
    private SegmentSettings segment;
    private List<NormalizationOperation> jsonNormalizations;
    private Boolean imageTextRecognition;

    private Builder(Conversions conversions) {
      this.pdf = conversions.pdf;
      this.word = conversions.word;
      this.html = conversions.html;
      this.segment = conversions.segment;
      this.jsonNormalizations = conversions.jsonNormalizations;
      this.imageTextRecognition = conversions.imageTextRecognition;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a Conversions.
     *
     * @return the new Conversions instance
     */
    public Conversions build() {
      return new Conversions(this);
    }

    /**
     * Adds an normalization to jsonNormalizations.
     *
     * @param normalization the new normalization
     * @return the Conversions builder
     */
    public Builder addNormalization(NormalizationOperation normalization) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(normalization, "normalization cannot be null");
      if (this.jsonNormalizations == null) {
        this.jsonNormalizations = new ArrayList<NormalizationOperation>();
      }
      this.jsonNormalizations.add(normalization);
      return this;
    }

    /**
     * Set the pdf.
     *
     * @param pdf the pdf
     * @return the Conversions builder
     */
    public Builder pdf(PdfSettings pdf) {
      this.pdf = pdf;
      return this;
    }

    /**
     * Set the word.
     *
     * @param word the word
     * @return the Conversions builder
     */
    public Builder word(WordSettings word) {
      this.word = word;
      return this;
    }

    /**
     * Set the html.
     *
     * @param html the html
     * @return the Conversions builder
     */
    public Builder html(HtmlSettings html) {
      this.html = html;
      return this;
    }

    /**
     * Set the segment.
     *
     * @param segment the segment
     * @return the Conversions builder
     */
    public Builder segment(SegmentSettings segment) {
      this.segment = segment;
      return this;
    }

    /**
     * Set the jsonNormalizations. Existing jsonNormalizations will be replaced.
     *
     * @param jsonNormalizations the jsonNormalizations
     * @return the Conversions builder
     */
    public Builder jsonNormalizations(List<NormalizationOperation> jsonNormalizations) {
      this.jsonNormalizations = jsonNormalizations;
      return this;
    }

    /**
     * Set the imageTextRecognition.
     *
     * @param imageTextRecognition the imageTextRecognition
     * @return the Conversions builder
     */
    public Builder imageTextRecognition(Boolean imageTextRecognition) {
      this.imageTextRecognition = imageTextRecognition;
      return this;
    }
  }

  protected Conversions(Builder builder) {
    pdf = builder.pdf;
    word = builder.word;
    html = builder.html;
    segment = builder.segment;
    jsonNormalizations = builder.jsonNormalizations;
    imageTextRecognition = builder.imageTextRecognition;
  }

  /**
   * New builder.
   *
   * @return a Conversions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the pdf.
   *
   * <p>A list of PDF conversion settings.
   *
   * @return the pdf
   */
  public PdfSettings pdf() {
    return pdf;
  }

  /**
   * Gets the word.
   *
   * <p>A list of Word conversion settings.
   *
   * @return the word
   */
  public WordSettings word() {
    return word;
  }

  /**
   * Gets the html.
   *
   * <p>A list of HTML conversion settings.
   *
   * @return the html
   */
  public HtmlSettings html() {
    return html;
  }

  /**
   * Gets the segment.
   *
   * <p>A list of Document Segmentation settings.
   *
   * @return the segment
   */
  public SegmentSettings segment() {
    return segment;
  }

  /**
   * Gets the jsonNormalizations.
   *
   * <p>Defines operations that can be used to transform the final output JSON into a normalized
   * form. Operations are executed in the order that they appear in the array.
   *
   * @return the jsonNormalizations
   */
  public List<NormalizationOperation> jsonNormalizations() {
    return jsonNormalizations;
  }

  /**
   * Gets the imageTextRecognition.
   *
   * <p>When `true`, automatic text extraction from images (this includes images embedded in
   * supported document formats, for example PDF, and suppported image formats, for example TIFF) is
   * performed on documents uploaded to the collection. This field is supported on **Advanced** and
   * higher plans only. **Lite** plans do not support image text recognition.
   *
   * @return the imageTextRecognition
   */
  public Boolean imageTextRecognition() {
    return imageTextRecognition;
  }
}

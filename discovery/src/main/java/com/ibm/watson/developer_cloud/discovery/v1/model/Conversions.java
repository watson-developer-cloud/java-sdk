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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;
import java.util.ArrayList;

/**
 * Document conversion settings.
 */
public class Conversions extends GenericModel {

  private PdfSettings pdf;
  private WordSettings word;
  private HtmlSettings html;
  @SerializedName("json_normalizations")
  private List<NormalizationOperation> jsonNormalizations;

  /**
   * Builder.
   */
  public static class Builder {
    private PdfSettings pdf;
    private WordSettings word;
    private HtmlSettings html;
    private List<NormalizationOperation> jsonNormalizations;

    private Builder(Conversions conversions) {
      pdf = conversions.pdf;
      word = conversions.word;
      html = conversions.html;
      jsonNormalizations = conversions.jsonNormalizations;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Conversions.
     *
     * @return the conversions
     */
    public Conversions build() {
      return new Conversions(this);
    }

    /**
     * Adds an jsonNormalizations to jsonNormalizations.
     *
     * @param jsonNormalizations the new jsonNormalizations
     * @return the Conversions builder
     */
    public Builder addJsonNormalizations(NormalizationOperation jsonNormalizations) {
      Validator.notNull(jsonNormalizations, "jsonNormalizations cannot be null");
      if (this.jsonNormalizations == null) {
        this.jsonNormalizations = new ArrayList<NormalizationOperation>();
      }
      this.jsonNormalizations.add(jsonNormalizations);
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
     * Set the jsonNormalizations.
     * Existing jsonNormalizations will be replaced.
     *
     * @param jsonNormalizations the jsonNormalizations
     * @return the Conversions builder
     */
    public Builder jsonNormalizations(List<NormalizationOperation> jsonNormalizations) {
      this.jsonNormalizations = jsonNormalizations;
      return this;
    }
  }

  private Conversions(Builder builder) {
    pdf = builder.pdf;
    word = builder.word;
    html = builder.html;
    jsonNormalizations = builder.jsonNormalizations;
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
   * A list of PDF conversion settings.
   *
   * @return the pdf
   */
  public PdfSettings pdf() {
    return pdf;
  }

  /**
   * Gets the word.
   *
   * A list of Word conversion settings.
   *
   * @return the word
   */
  public WordSettings word() {
    return word;
  }

  /**
   * Gets the html.
   *
   * A list of HTML conversion settings.
   *
   * @return the html
   */
  public HtmlSettings html() {
    return html;
  }

  /**
   * Gets the jsonNormalizations.
   *
   * Defines operations that can be used to transform the final output JSON into a normalized form. Operations are
   * executed in the order that they appear in the array.
   *
   * @return the jsonNormalizations
   */
  public List<NormalizationOperation> jsonNormalizations() {
    return jsonNormalizations;
  }
}

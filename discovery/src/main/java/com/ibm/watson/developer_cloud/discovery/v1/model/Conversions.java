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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

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
   * Gets the pdf.
   *
   * A list of PDF conversion settings.
   *
   * @return the pdf
   */
  public PdfSettings getPdf() {
    return pdf;
  }

  /**
   * Gets the word.
   *
   * A list of Word conversion settings.
   *
   * @return the word
   */
  public WordSettings getWord() {
    return word;
  }

  /**
   * Gets the html.
   *
   * A list of HTML conversion settings.
   *
   * @return the html
   */
  public HtmlSettings getHtml() {
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
  public List<NormalizationOperation> getJsonNormalizations() {
    return jsonNormalizations;
  }

  /**
   * Sets the pdf.
   *
   * @param pdf the new pdf
   */
  public void setPdf(final PdfSettings pdf) {
    this.pdf = pdf;
  }

  /**
   * Sets the word.
   *
   * @param word the new word
   */
  public void setWord(final WordSettings word) {
    this.word = word;
  }

  /**
   * Sets the html.
   *
   * @param html the new html
   */
  public void setHtml(final HtmlSettings html) {
    this.html = html;
  }

  /**
   * Sets the jsonNormalizations.
   *
   * @param jsonNormalizations the new jsonNormalizations
   */
  public void setJsonNormalizations(final List<NormalizationOperation> jsonNormalizations) {
    this.jsonNormalizations = jsonNormalizations;
  }
}

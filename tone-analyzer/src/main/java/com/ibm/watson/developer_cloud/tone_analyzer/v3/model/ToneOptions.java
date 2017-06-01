/**
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
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;

/**
 * This class contains the parameters when using {@link ToneAnalyzer#getTone(String, ToneOptions)}.
 *
 * @see ToneAnalyzer
 */
public class ToneOptions {

  private Boolean isHtml;
  private List<Tone> tones;
  private Boolean includeSentences;
  private String contentLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean isHtml;
    private Boolean includeSentences;
    private List<Tone> tones;
    private String contentLanguage;

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Instantiates a new builder.
     *
     * @param options the options
     */
    public Builder(ToneOptions options) {
      isHtml = options.isHtml;
      tones = options.tones;
      includeSentences = options.includeSentences;
      contentLanguage = options.contentLanguage;
    }

    /**
     * Sets the text as HTML.
     *
     * @param isHtml sets the text as html
     * @return the builder
     */
    public Builder html(Boolean isHtml) {
      this.isHtml = isHtml;
      return this;
    }

    /**
     * Indicates whether to return sentence-level tone analysis.
     *
     * @param sentences sets sentence-level analysis.
     * @return the builder
     */
    public Builder includeSentences(Boolean sentences) {
      this.includeSentences = sentences;
      return this;
    }

    /**
     * Adds the tone.
     *
     * @param tone the tone to add
     * @return the builder
     */
    public Builder addTone(Tone tone) {
      if (tones == null) {
        tones = new ArrayList<Tone>();
      }
      if (!tones.contains(tone)) {
        tones.add(tone);
      }
      return this;
    }

    /**
     * Specifies the language of the content
     *
     * @param contentLanguage language of the content
     * @return the builder
     */
    public Builder contentLanguage(String contentLanguage) {
      this.contentLanguage = contentLanguage;
      return this;
    }

    /**
     * Builds the {@link ToneOptions} object.
     *
     * @return the tone options object
     */
    public ToneOptions build() {
      return new ToneOptions(this);
    }
  }

  private ToneOptions(Builder builder) {
    isHtml = builder.isHtml;
    tones = builder.tones;
    includeSentences = builder.includeSentences;
    contentLanguage = builder.contentLanguage;
  }

  /**
   * Gets the isHtml.
   *
   * @return the isHtml attribute
   */
  public Boolean html() {
    return isHtml;
  }

  /**
   * Get the includeSentences.
   *
   * @return the includeSentences attribute
   */
  public Boolean includeSentences() {
    return includeSentences;
  }

  /**
   * Gets the tones.
   *
   * @return the list of tones
   */
  public List<Tone> tones() {
    return tones;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the language of the content
   *
   * @return content langauge
   */
  public String contentLanguage() {
    return contentLanguage;
  }

}

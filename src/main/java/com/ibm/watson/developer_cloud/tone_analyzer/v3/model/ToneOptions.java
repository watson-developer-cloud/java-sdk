/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;

/**
 * This class contains the parameters when using {@link ToneAnalyzer#getTone(ToneOptions)}.
 * 
 * @see ToneAnalyzer
 */
public class ToneOptions {

  private Boolean isHtml;
  private List<Tone> tones;
  private Boolean includeSentences;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean isHtml;
    private Boolean includeSentences;
    private List<Tone> tones;


    /**
     * Instantiates a new builder.
     */
    public Builder() {}

    /**
     * Instantiates a new builder.
     *
     * @param options the options
     */
    public Builder(ToneOptions options) {
      this.isHtml = options.isHtml;
      this.tones = options.tones;
      this.includeSentences = options.includeSentences;
    }

    /**
     * Sets the text as HTML.
     *
     * @param text the text
     * @return the builder
     */
    public Builder html(Boolean isHtml) {
      this.isHtml = isHtml;
      return this;
    }

    /**
     * Adds the tone.
     *
     * @param tone the tone
     * @return the builder
     */
    public Builder addTone(Tone tone) {
      if (tones == null) {
        this.tones = new ArrayList<Tone>();
      }
      if (!tones.contains(tone)) {
        tones.add(tone);
      }
      return this;
    }

    /**
     * Builds the {@link ToneOptions} object.
     *
     * @return the gets the tone options
     */
    public ToneOptions build() {
      return new ToneOptions(this);
    }
  }

  private ToneOptions(Builder builder) {
    this.isHtml = builder.isHtml;
    this.tones = builder.tones;
    this.includeSentences = builder.includeSentences;
  }

  /**
   * Gets the html.
   * 
   * @return the html
   */
  public Boolean html() {
    return this.isHtml;
  }


  /**
   * include sentences.
   * 
   * @return the text
   */
  public Boolean includeSentences() {
    return includeSentences;
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
   * Gets the tones
   *
   * @return the tone list
   */
  public List<Tone> tones() {
    return tones;
  }

}

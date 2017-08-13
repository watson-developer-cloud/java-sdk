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
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The tone options.
 */
public class ToneOptions extends GenericModel {

  /**
   * The type of the input: application/json, text/plain, or text/html. A character encoding can be specified by
   * including a `charset` parameter. For example, 'text/plain;charset=utf-8'.
   */
  public interface ContentType {
    /** application/json. */
    String APPLICATION_JSON = "application/json";
    /** text/plain. */
    String TEXT_PLAIN = "text/plain";
    /** text/html. */
    String TEXT_HTML = "text/html";
  }

  public interface Tone {
    /** emotion. */
    String EMOTION = "emotion";
    /** language. */
    String LANGUAGE = "language";
    /** social. */
    String SOCIAL = "social";
  }

  private ToneInput toneInput;
  private String body;
  private String contentType;
  private List<String> tones;
  private Boolean sentences;

  /**
   * Builder.
   */
  public static class Builder {
    private ToneInput toneInput;
    private String body;
    private String contentType;
    private List<String> tones;
    private Boolean sentences;

    private Builder(ToneOptions toneOptions) {
      toneInput = toneOptions.toneInput;
      body = toneOptions.body;
      contentType = toneOptions.contentType;
      tones = toneOptions.tones;
      sentences = toneOptions.sentences;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ToneOptions.
     *
     * @return the toneOptions
     */
    public ToneOptions build() {
      return new ToneOptions(this);
    }

    /**
     * Adds an tone to tones.
     *
     * @param tone the new tone
     * @return the ToneOptions builder
     */
    public Builder addTone(String tone) {
      Validator.notNull(tone, "tone cannot be null");
      if (this.tones == null) {
        this.tones = new ArrayList<String>();
      }
      this.tones.add(tone);
      return this;
    }

    /**
     * Set the tones.
     * Existing tones will be replaced.
     *
     * @param tones the tones
     * @return the ToneOptions builder
     */
    public Builder tones(List<String> tones) {
      this.tones = tones;
      return this;
    }

    /**
     * Set the sentences.
     *
     * @param sentences the sentences
     * @return the ToneOptions builder
     */
    public Builder sentences(Boolean sentences) {
      this.sentences = sentences;
      return this;
    }

    /**
     * Set the toneInput.
     *
     * @param toneInput the toneInput
     * @return the ToneOptions builder
     */
    public Builder toneInput(ToneInput toneInput) {
      this.toneInput = toneInput;
      this.contentType = ToneOptions.ContentType.APPLICATION_JSON;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the ToneOptions builder
     */
    public Builder text(String text) {
      this.body = text;
      this.contentType = ToneOptions.ContentType.TEXT_PLAIN;
      return this;
    }

    /**
     * Set the html.
     *
     * @param html the html
     * @return the ToneOptions builder
     */
    public Builder html(String html) {
      this.body = html;
      this.contentType = ToneOptions.ContentType.TEXT_HTML;
      return this;
    }
  }

  private ToneOptions(Builder builder) {
    Validator.isTrue(builder.contentType != null, "contentType cannot be null");
    toneInput = builder.toneInput;
    body = builder.body;
    contentType = builder.contentType;
    tones = builder.tones;
    sentences = builder.sentences;
  }

  /**
   * New builder.
   *
   * @return a ToneOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the toneInput.
   *
   * JSON, plain text, or HTML input that contains the content to be analyzed. For JSON input, provide an object of type
   * `ToneInput`. Submit a maximum of 128 KB of content. Sentences with fewer than three words cannot be analyzed.
   *
   * @return the toneInput
   */
  public ToneInput toneInput() {
    return toneInput;
  }

  /**
   * Gets the body.
   *
   * JSON, plain text, or HTML input that contains the content to be analyzed. For JSON input, provide an object of type
   * `ToneInput`. Submit a maximum of 128 KB of content. Sentences with fewer than three words cannot be analyzed.
   *
   * @return the body
   */
  public String body() {
    return body;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input: application/json, text/plain, or text/html. A character encoding can be specified by
   * including a `charset` parameter. For example, 'text/plain;charset=utf-8'.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the tones.
   *
   * A comma-separated list of tones for which the service is to return its analysis of the input; the indicated tones
   * apply both to the full document and to individual sentences of the document. You can specify one or more of the
   * following values: `emotion`, `language`, and `social`. Omit the parameter to request results for all three tones.
   *
   * @return the tones
   */
  public List<String> tones() {
    return tones;
  }

  /**
   * Gets the sentences.
   *
   * Indicates whether the service is to return an analysis of each individual sentence in addition to its analysis of
   * the full document. If `true` (the default), the service returns results for each sentence. The service returns
   * results only for the first 100 sentences of the input.
   *
   * @return the sentences
   */
  public Boolean sentences() {
    return sentences;
  }
}

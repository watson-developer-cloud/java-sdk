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
package com.ibm.watson.tone_analyzer.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The tone options.
 */
public class ToneOptions extends GenericModel {

  public interface Tone {
    /** emotion. */
    String EMOTION = "emotion";
    /** language. */
    String LANGUAGE = "language";
    /** social. */
    String SOCIAL = "social";
  }

  /**
   * The language of the input text for the request: English or French. Regional variants are treated as their parent
   * language; for example, `en-US` is interpreted as `en`. The input content must match the specified language. Do not
   * submit content that contains both languages. You can use different languages for **Content-Language** and
   * **Accept-Language**.
   * * **`2017-09-21`:** Accepts `en` or `fr`.
   * * **`2016-05-19`:** Accepts only `en`.
   */
  public interface ContentLanguage {
    /** en. */
    String EN = "en";
    /** fr. */
    String FR = "fr";
  }

  /**
   * The desired language of the response. For two-character arguments, regional variants are treated as their parent
   * language; for example, `en-US` is interpreted as `en`. You can use different languages for **Content-Language** and
   * **Accept-Language**.
   */
  public interface AcceptLanguage {
    /** ar. */
    String AR = "ar";
    /** de. */
    String DE = "de";
    /** en. */
    String EN = "en";
    /** es. */
    String ES = "es";
    /** fr. */
    String FR = "fr";
    /** it. */
    String IT = "it";
    /** ja. */
    String JA = "ja";
    /** ko. */
    String KO = "ko";
    /** pt-br. */
    String PT_BR = "pt-br";
    /** zh-cn. */
    String ZH_CN = "zh-cn";
    /** zh-tw. */
    String ZH_TW = "zh-tw";
  }

  /**
   * The type of the input. A character encoding can be specified by including a `charset` parameter. For example,
   * 'text/plain;charset=utf-8'.
   */
  public interface ContentType {
    /** application/json. */
    String APPLICATION_JSON = "application/json";
    /** text/plain. */
    String TEXT_PLAIN = "text/plain";
    /** text/html. */
    String TEXT_HTML = "text/html";
  }

  private ToneInput toneInput;
  private String body;
  private Boolean sentences;
  private List<String> tones;
  private String contentLanguage;
  private String acceptLanguage;
  private String contentType;

  /**
   * Builder.
   */
  public static class Builder {
    private ToneInput toneInput;
    private String body;
    private Boolean sentences;
    private List<String> tones;
    private String contentLanguage;
    private String acceptLanguage;
    private String contentType;

    private Builder(ToneOptions toneOptions) {
      this.toneInput = toneOptions.toneInput;
      this.body = toneOptions.body;
      this.sentences = toneOptions.sentences;
      this.tones = toneOptions.tones;
      this.contentLanguage = toneOptions.contentLanguage;
      this.acceptLanguage = toneOptions.acceptLanguage;
      this.contentType = toneOptions.contentType;
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
     * Set the contentLanguage.
     *
     * @param contentLanguage the contentLanguage
     * @return the ToneOptions builder
     */
    public Builder contentLanguage(String contentLanguage) {
      this.contentLanguage = contentLanguage;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ToneOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
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
    toneInput = builder.toneInput;
    body = builder.body;
    sentences = builder.sentences;
    tones = builder.tones;
    contentLanguage = builder.contentLanguage;
    acceptLanguage = builder.acceptLanguage;
    contentType = builder.contentType;
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
   * `ToneInput`.
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
   * `ToneInput`.
   *
   * @return the body
   */
  public String body() {
    return body;
  }

  /**
   * Gets the sentences.
   *
   * Indicates whether the service is to return an analysis of each individual sentence in addition to its analysis of
   * the full document. If `true` (the default), the service returns results for each sentence.
   *
   * @return the sentences
   */
  public Boolean sentences() {
    return sentences;
  }

  /**
   * Gets the tones.
   *
   * **`2017-09-21`:** Deprecated. The service continues to accept the parameter for backward-compatibility, but the
   * parameter no longer affects the response.
   *
   * **`2016-05-19`:** A comma-separated list of tones for which the service is to return its analysis of the input; the
   * indicated tones apply both to the full document and to individual sentences of the document. You can specify one or
   * more of the valid values. Omit the parameter to request results for all three tones.
   *
   * @return the tones
   */
  public List<String> tones() {
    return tones;
  }

  /**
   * Gets the contentLanguage.
   *
   * The language of the input text for the request: English or French. Regional variants are treated as their parent
   * language; for example, `en-US` is interpreted as `en`. The input content must match the specified language. Do not
   * submit content that contains both languages. You can use different languages for **Content-Language** and
   * **Accept-Language**.
   * * **`2017-09-21`:** Accepts `en` or `fr`.
   * * **`2016-05-19`:** Accepts only `en`.
   *
   * @return the contentLanguage
   */
  public String contentLanguage() {
    return contentLanguage;
  }

  /**
   * Gets the acceptLanguage.
   *
   * The desired language of the response. For two-character arguments, regional variants are treated as their parent
   * language; for example, `en-US` is interpreted as `en`. You can use different languages for **Content-Language** and
   * **Accept-Language**.
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input. A character encoding can be specified by including a `charset` parameter. For example,
   * 'text/plain;charset=utf-8'.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }
}

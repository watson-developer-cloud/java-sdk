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
 * The toneChat options.
 */
public class ToneChatOptions extends GenericModel {

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

  private List<Utterance> utterances;
  private String contentLanguage;
  private String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Utterance> utterances;
    private String contentLanguage;
    private String acceptLanguage;

    private Builder(ToneChatOptions toneChatOptions) {
      this.utterances = toneChatOptions.utterances;
      this.contentLanguage = toneChatOptions.contentLanguage;
      this.acceptLanguage = toneChatOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param utterances the utterances
     */
    public Builder(List<Utterance> utterances) {
      this.utterances = utterances;
    }

    /**
     * Builds a ToneChatOptions.
     *
     * @return the toneChatOptions
     */
    public ToneChatOptions build() {
      return new ToneChatOptions(this);
    }

    /**
     * Adds an utterances to utterances.
     *
     * @param utterances the new utterances
     * @return the ToneChatOptions builder
     */
    public Builder addUtterances(Utterance utterances) {
      Validator.notNull(utterances, "utterances cannot be null");
      if (this.utterances == null) {
        this.utterances = new ArrayList<Utterance>();
      }
      this.utterances.add(utterances);
      return this;
    }

    /**
     * Set the utterances.
     * Existing utterances will be replaced.
     *
     * @param utterances the utterances
     * @return the ToneChatOptions builder
     */
    public Builder utterances(List<Utterance> utterances) {
      this.utterances = utterances;
      return this;
    }

    /**
     * Set the contentLanguage.
     *
     * @param contentLanguage the contentLanguage
     * @return the ToneChatOptions builder
     */
    public Builder contentLanguage(String contentLanguage) {
      this.contentLanguage = contentLanguage;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ToneChatOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  private ToneChatOptions(Builder builder) {
    Validator.notNull(builder.utterances, "utterances cannot be null");
    utterances = builder.utterances;
    contentLanguage = builder.contentLanguage;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a ToneChatOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the utterances.
   *
   * An array of `Utterance` objects that provides the input content that the service is to analyze.
   *
   * @return the utterances
   */
  public List<Utterance> utterances() {
    return utterances;
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
}

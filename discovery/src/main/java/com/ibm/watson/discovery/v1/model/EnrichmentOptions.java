/*
 * (C) Copyright IBM Corp. 2023.
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

/**
 * Options that are specific to a particular enrichment.
 *
 * <p>The `elements` enrichment type is deprecated. Use the [Create a
 * project](https://cloud.ibm.com/apidocs/discovery-data#createproject) method of the Discovery v2
 * API to create a `content_intelligence` project type instead.
 */
public class EnrichmentOptions extends GenericModel {

  /**
   * ISO 639-1 code indicating the language to use for the analysis. This code overrides the
   * automatic language detection performed by the service. Valid codes are `ar` (Arabic), `en`
   * (English), `fr` (French), `de` (German), `it` (Italian), `pt` (Portuguese), `ru` (Russian),
   * `es` (Spanish), and `sv` (Swedish). **Note:** Not all features support all languages, automatic
   * detection is recommended.
   */
  public interface Language {
    /** ar. */
    String AR = "ar";
    /** en. */
    String EN = "en";
    /** fr. */
    String FR = "fr";
    /** de. */
    String DE = "de";
    /** it. */
    String IT = "it";
    /** pt. */
    String PT = "pt";
    /** ru. */
    String RU = "ru";
    /** es. */
    String ES = "es";
    /** sv. */
    String SV = "sv";
  }

  protected NluEnrichmentFeatures features;
  protected String language;
  protected String model;

  /** Builder. */
  public static class Builder {
    private NluEnrichmentFeatures features;
    private String language;
    private String model;

    /**
     * Instantiates a new Builder from an existing EnrichmentOptions instance.
     *
     * @param enrichmentOptions the instance to initialize the Builder with
     */
    private Builder(EnrichmentOptions enrichmentOptions) {
      this.features = enrichmentOptions.features;
      this.language = enrichmentOptions.language;
      this.model = enrichmentOptions.model;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a EnrichmentOptions.
     *
     * @return the new EnrichmentOptions instance
     */
    public EnrichmentOptions build() {
      return new EnrichmentOptions(this);
    }

    /**
     * Set the features.
     *
     * @param features the features
     * @return the EnrichmentOptions builder
     */
    public Builder features(NluEnrichmentFeatures features) {
      this.features = features;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the EnrichmentOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the EnrichmentOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected EnrichmentOptions() {}

  protected EnrichmentOptions(Builder builder) {
    features = builder.features;
    language = builder.language;
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a EnrichmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the features.
   *
   * <p>Object containing Natural Language Understanding features to be used.
   *
   * @return the features
   */
  public NluEnrichmentFeatures features() {
    return features;
  }

  /**
   * Gets the language.
   *
   * <p>ISO 639-1 code indicating the language to use for the analysis. This code overrides the
   * automatic language detection performed by the service. Valid codes are `ar` (Arabic), `en`
   * (English), `fr` (French), `de` (German), `it` (Italian), `pt` (Portuguese), `ru` (Russian),
   * `es` (Spanish), and `sv` (Swedish). **Note:** Not all features support all languages, automatic
   * detection is recommended.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the model.
   *
   * <p>The element extraction model to use, which can be `contract` only. The `elements` enrichment
   * is deprecated.
   *
   * @return the model
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String model() {
    return model;
  }
}

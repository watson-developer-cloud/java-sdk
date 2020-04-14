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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The updateConfiguration options. */
public class UpdateConfigurationOptions extends GenericModel {

  protected String environmentId;
  protected String configurationId;
  protected String name;
  protected String description;
  protected Conversions conversions;
  protected List<Enrichment> enrichments;
  protected List<NormalizationOperation> normalizations;
  protected Source source;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String configurationId;
    private String name;
    private String description;
    private Conversions conversions;
    private List<Enrichment> enrichments;
    private List<NormalizationOperation> normalizations;
    private Source source;

    private Builder(UpdateConfigurationOptions updateConfigurationOptions) {
      this.environmentId = updateConfigurationOptions.environmentId;
      this.configurationId = updateConfigurationOptions.configurationId;
      this.name = updateConfigurationOptions.name;
      this.description = updateConfigurationOptions.description;
      this.conversions = updateConfigurationOptions.conversions;
      this.enrichments = updateConfigurationOptions.enrichments;
      this.normalizations = updateConfigurationOptions.normalizations;
      this.source = updateConfigurationOptions.source;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param configurationId the configurationId
     * @param name the name
     */
    public Builder(String environmentId, String configurationId, String name) {
      this.environmentId = environmentId;
      this.configurationId = configurationId;
      this.name = name;
    }

    /**
     * Builds a UpdateConfigurationOptions.
     *
     * @return the updateConfigurationOptions
     */
    public UpdateConfigurationOptions build() {
      return new UpdateConfigurationOptions(this);
    }

    /**
     * Adds an enrichment to enrichments.
     *
     * @param enrichment the new enrichment
     * @return the UpdateConfigurationOptions builder
     */
    public Builder addEnrichment(Enrichment enrichment) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(enrichment, "enrichment cannot be null");
      if (this.enrichments == null) {
        this.enrichments = new ArrayList<Enrichment>();
      }
      this.enrichments.add(enrichment);
      return this;
    }

    /**
     * Adds an normalization to normalizations.
     *
     * @param normalization the new normalization
     * @return the UpdateConfigurationOptions builder
     */
    public Builder addNormalization(NormalizationOperation normalization) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(normalization, "normalization cannot be null");
      if (this.normalizations == null) {
        this.normalizations = new ArrayList<NormalizationOperation>();
      }
      this.normalizations.add(normalization);
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the UpdateConfigurationOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the configurationId.
     *
     * @param configurationId the configurationId
     * @return the UpdateConfigurationOptions builder
     */
    public Builder configurationId(String configurationId) {
      this.configurationId = configurationId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateConfigurationOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateConfigurationOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the conversions.
     *
     * @param conversions the conversions
     * @return the UpdateConfigurationOptions builder
     */
    public Builder conversions(Conversions conversions) {
      this.conversions = conversions;
      return this;
    }

    /**
     * Set the enrichments. Existing enrichments will be replaced.
     *
     * @param enrichments the enrichments
     * @return the UpdateConfigurationOptions builder
     */
    public Builder enrichments(List<Enrichment> enrichments) {
      this.enrichments = enrichments;
      return this;
    }

    /**
     * Set the normalizations. Existing normalizations will be replaced.
     *
     * @param normalizations the normalizations
     * @return the UpdateConfigurationOptions builder
     */
    public Builder normalizations(List<NormalizationOperation> normalizations) {
      this.normalizations = normalizations;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the UpdateConfigurationOptions builder
     */
    public Builder source(Source source) {
      this.source = source;
      return this;
    }

    /**
     * Set the configuration.
     *
     * @param configuration the configuration
     * @return the UpdateConfigurationOptions builder
     */
    public Builder configuration(Configuration configuration) {
      this.name = configuration.name();
      this.description = configuration.description();
      this.conversions = configuration.conversions();
      this.enrichments = configuration.enrichments();
      this.normalizations = configuration.normalizations();
      this.source = configuration.source();
      return this;
    }
  }

  protected UpdateConfigurationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.configurationId, "configurationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    environmentId = builder.environmentId;
    configurationId = builder.configurationId;
    name = builder.name;
    description = builder.description;
    conversions = builder.conversions;
    enrichments = builder.enrichments;
    normalizations = builder.normalizations;
    source = builder.source;
  }

  /**
   * New builder.
   *
   * @return a UpdateConfigurationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the configurationId.
   *
   * <p>The ID of the configuration.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the configuration.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the configuration, if available.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the conversions.
   *
   * <p>Document conversion settings.
   *
   * @return the conversions
   */
  public Conversions conversions() {
    return conversions;
  }

  /**
   * Gets the enrichments.
   *
   * <p>An array of document enrichment settings for the configuration.
   *
   * @return the enrichments
   */
  public List<Enrichment> enrichments() {
    return enrichments;
  }

  /**
   * Gets the normalizations.
   *
   * <p>Defines operations that can be used to transform the final output JSON into a normalized
   * form. Operations are executed in the order that they appear in the array.
   *
   * @return the normalizations
   */
  public List<NormalizationOperation> normalizations() {
    return normalizations;
  }

  /**
   * Gets the source.
   *
   * <p>Object containing source parameters for the configuration.
   *
   * @return the source
   */
  public Source source() {
    return source;
  }
}

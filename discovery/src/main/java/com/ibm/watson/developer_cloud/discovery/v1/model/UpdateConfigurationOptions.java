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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * the updateConfiguration options.
 */
public class UpdateConfigurationOptions extends GenericModel {

  /** the ID of your environment. */
  @SerializedName("environment_id")
  private String environmentId;
  /** the ID of your configuration. */
  @SerializedName("configuration_id")
  private String configurationId;
  /** The document conversion settings for the configuration. */
  private Conversions conversions;
  /** The name of the configuration. */
  private String name;
  /** The description of the configuration, if available. */
  private String description;
  /** Defines operations that can be used to transform the final output JSON into a normalized form. Operations are
   * executed in the order that they appear in the array. */
  private List<NormalizationOperation> normalizations;
  /** An array of document enrichment settings for the configuration. */
  private List<Enrichment> enrichments;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String configurationId;
    private Conversions conversions;
    private String name;
    private String description;
    private List<NormalizationOperation> normalizations;
    private List<Enrichment> enrichments;

    private Builder(UpdateConfigurationOptions updateConfigurationOptions) {
      environmentId = updateConfigurationOptions.environmentId;
      configurationId = updateConfigurationOptions.configurationId;
      conversions = updateConfigurationOptions.conversions;
      name = updateConfigurationOptions.name;
      description = updateConfigurationOptions.description;
      normalizations = updateConfigurationOptions.normalizations;
      enrichments = updateConfigurationOptions.enrichments;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     */
    public Builder(String environmentId, String configurationId) {
      this.environmentId = environmentId;
      this.configurationId = configurationId;
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
     * Adds an normalization to normalizations.
     *
     * @param normalization the new normalization
     * @return the UpdateConfigurationOptions builder
     */
    public Builder addNormalizations(NormalizationOperation normalization) {
      if (this.normalizations == null) {
        this.normalizations = new ArrayList<NormalizationOperation>();
      }
      this.normalizations.add(normalization);
      return this;
    }

    /**
     * Adds an enrichment to enrichments.
     *
     * @param enrichment the new enrichment
     * @return the UpdateConfigurationOptions builder
     */
    public Builder addEnrichments(Enrichment enrichment) {
      if (this.enrichments == null) {
        this.enrichments = new ArrayList<Enrichment>();
      }
      this.enrichments.add(enrichment);
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
     * Set the normalizations.
     * Existing normalizations will be replaced.
     *
     * @param normalizations the normalizations
     * @return the UpdateConfigurationOptions builder
     */
    public Builder normalizations(List<NormalizationOperation> normalizations) {
      this.normalizations = normalizations;
      return this;
    }

    /**
     * Set the enrichments.
     * Existing enrichments will be replaced.
     *
     * @param enrichments the enrichments
     * @return the UpdateConfigurationOptions builder
     */
    public Builder enrichments(List<Enrichment> enrichments) {
      this.enrichments = enrichments;
      return this;
    }

    /**
     * Set the configuration.
     *
     * @param configuration the configuration
     * @return the UpdateConfigurationOptions builder
     */
    public Builder configuration(Configuration configuration) {
      this.conversions = configuration.getConversions();
      this.name = configuration.getName();
      this.description = configuration.getDescription();
      this.normalizations = configuration.getNormalizations();
      this.enrichments = configuration.getEnrichments();
      return this;
    }
  }

  private UpdateConfigurationOptions(Builder builder) {
    Validator.notNull(builder.environmentId, "environmentId cannot be null");
    Validator.notNull(builder.configurationId, "configurationId cannot be null");
    environmentId = builder.environmentId;
    configurationId = builder.configurationId;
    conversions = builder.conversions;
    name = builder.name;
    description = builder.description;
    normalizations = builder.normalizations;
    enrichments = builder.enrichments;
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
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the configurationId.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }

  /**
   * Gets the conversions.
   *
   * @return the conversions
   */
  public Conversions conversions() {
    return conversions;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the normalizations.
   *
   * @return the normalizations
   */
  public List<NormalizationOperation> normalizations() {
    return normalizations;
  }

  /**
   * Gets the enrichments.
   *
   * @return the enrichments
   */
  public List<Enrichment> enrichments() {
    return enrichments;
  }
}

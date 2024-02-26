/*
 * (C) Copyright IBM Corp. 2017, 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** A custom configuration for the environment. */
public class Configuration extends GenericModel {

  @SerializedName("configuration_id")
  protected String configurationId;

  protected String name;
  protected Date created;
  protected Date updated;
  protected String description;
  protected Conversions conversions;
  protected List<Enrichment> enrichments;
  protected List<NormalizationOperation> normalizations;
  protected Source source;

  /** Builder. */
  public static class Builder {
    private String name;
    private String description;
    private Conversions conversions;
    private List<Enrichment> enrichments;
    private List<NormalizationOperation> normalizations;
    private Source source;

    /**
     * Instantiates a new Builder from an existing Configuration instance.
     *
     * @param configuration the instance to initialize the Builder with
     */
    private Builder(Configuration configuration) {
      this.name = configuration.name;
      this.description = configuration.description;
      this.conversions = configuration.conversions;
      this.enrichments = configuration.enrichments;
      this.normalizations = configuration.normalizations;
      this.source = configuration.source;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a Configuration.
     *
     * @return the new Configuration instance
     */
    public Configuration build() {
      return new Configuration(this);
    }

    /**
     * Adds a new element to enrichments.
     *
     * @param enrichment the new element to be added
     * @return the Configuration builder
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
     * Adds a new element to normalizations.
     *
     * @param normalization the new element to be added
     * @return the Configuration builder
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
     * Set the name.
     *
     * @param name the name
     * @return the Configuration builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the Configuration builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the conversions.
     *
     * @param conversions the conversions
     * @return the Configuration builder
     */
    public Builder conversions(Conversions conversions) {
      this.conversions = conversions;
      return this;
    }

    /**
     * Set the enrichments. Existing enrichments will be replaced.
     *
     * @param enrichments the enrichments
     * @return the Configuration builder
     */
    public Builder enrichments(List<Enrichment> enrichments) {
      this.enrichments = enrichments;
      return this;
    }

    /**
     * Set the normalizations. Existing normalizations will be replaced.
     *
     * @param normalizations the normalizations
     * @return the Configuration builder
     */
    public Builder normalizations(List<NormalizationOperation> normalizations) {
      this.normalizations = normalizations;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the Configuration builder
     */
    public Builder source(Source source) {
      this.source = source;
      return this;
    }
  }

  protected Configuration() {}

  protected Configuration(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
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
   * @return a Configuration builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the configurationId.
   *
   * <p>The unique identifier of the configuration.
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
   * Gets the created.
   *
   * <p>The creation date of the configuration in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp of when the configuration was last updated in the format
   * yyyy-MM-dd'T'HH:mm:ss.SSS'Z'.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
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

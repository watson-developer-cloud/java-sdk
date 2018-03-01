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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Enrichment.
 */
public class Enrichment extends GenericModel {

  private String description;
  @SerializedName("destination_field")
  private String destinationField;
  @SerializedName("source_field")
  private String sourceField;
  private Boolean overwrite;
  @SerializedName("enrichment")
  private String enrichmentName;
  @SerializedName("ignore_downstream_errors")
  private Boolean ignoreDownstreamErrors;
  private EnrichmentOptions options;

  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private String destinationField;
    private String sourceField;
    private Boolean overwrite;
    private String enrichmentName;
    private Boolean ignoreDownstreamErrors;
    private EnrichmentOptions options;

    private Builder(Enrichment enrichment) {
      description = enrichment.description;
      destinationField = enrichment.destinationField;
      sourceField = enrichment.sourceField;
      overwrite = enrichment.overwrite;
      enrichmentName = enrichment.enrichmentName;
      ignoreDownstreamErrors = enrichment.ignoreDownstreamErrors;
      options = enrichment.options;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param destinationField the destinationField
     * @param sourceField the sourceField
     * @param enrichmentName the enrichmentName
     */
    public Builder(String destinationField, String sourceField, String enrichmentName) {
      this.destinationField = destinationField;
      this.sourceField = sourceField;
      this.enrichmentName = enrichmentName;
    }

    /**
     * Builds a Enrichment.
     *
     * @return the enrichment
     */
    public Enrichment build() {
      return new Enrichment(this);
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the Enrichment builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the destinationField.
     *
     * @param destinationField the destinationField
     * @return the Enrichment builder
     */
    public Builder destinationField(String destinationField) {
      this.destinationField = destinationField;
      return this;
    }

    /**
     * Set the sourceField.
     *
     * @param sourceField the sourceField
     * @return the Enrichment builder
     */
    public Builder sourceField(String sourceField) {
      this.sourceField = sourceField;
      return this;
    }

    /**
     * Set the overwrite.
     *
     * @param overwrite the overwrite
     * @return the Enrichment builder
     */
    public Builder overwrite(Boolean overwrite) {
      this.overwrite = overwrite;
      return this;
    }

    /**
     * Set the enrichmentName.
     *
     * @param enrichmentName the enrichmentName
     * @return the Enrichment builder
     */
    public Builder enrichmentName(String enrichmentName) {
      this.enrichmentName = enrichmentName;
      return this;
    }

    /**
     * Set the ignoreDownstreamErrors.
     *
     * @param ignoreDownstreamErrors the ignoreDownstreamErrors
     * @return the Enrichment builder
     */
    public Builder ignoreDownstreamErrors(Boolean ignoreDownstreamErrors) {
      this.ignoreDownstreamErrors = ignoreDownstreamErrors;
      return this;
    }

    /**
     * Set the options.
     *
     * @param options the options
     * @return the Enrichment builder
     */
    public Builder options(EnrichmentOptions options) {
      this.options = options;
      return this;
    }
  }

  private Enrichment(Builder builder) {
    Validator.notNull(builder.destinationField, "destinationField cannot be null");
    Validator.notNull(builder.sourceField, "sourceField cannot be null");
    Validator.notNull(builder.enrichmentName, "enrichmentName cannot be null");
    description = builder.description;
    destinationField = builder.destinationField;
    sourceField = builder.sourceField;
    overwrite = builder.overwrite;
    enrichmentName = builder.enrichmentName;
    ignoreDownstreamErrors = builder.ignoreDownstreamErrors;
    options = builder.options;
  }

  /**
   * New builder.
   *
   * @return a Enrichment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the description.
   *
   * Describes what the enrichment step does.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the destinationField.
   *
   * Field where enrichments will be stored. This field must already exist or be at most 1 level deeper than an existing
   * field. For example, if `text` is a top-level field with no sub-fields, `text.foo` is a valid destination but
   * `text.foo.bar` is not.
   *
   * @return the destinationField
   */
  public String destinationField() {
    return destinationField;
  }

  /**
   * Gets the sourceField.
   *
   * Field to be enriched.
   *
   * @return the sourceField
   */
  public String sourceField() {
    return sourceField;
  }

  /**
   * Gets the overwrite.
   *
   * Indicates that the enrichments will overwrite the destination_field field if it already exists.
   *
   * @return the overwrite
   */
  public Boolean overwrite() {
    return overwrite;
  }

  /**
   * Gets the enrichmentName.
   *
   * Name of the enrichment service to call. Current options are `natural_language_understanding` and `elements`. When
   * using `natual_language_understanding`, the `options` object must contain Natural Language Understanding Options.
   * When using `elements` the `options` object must contain Element Classification options. Additionally, when using
   * the `elements` enrichment the configuration specified and files ingested must meet all the criteria specified in
   * [the documentation](https://console.bluemix.net/docs/services/discovery/element-classification.html) Previous API
   * versions also supported `alchemy_language`.
   *
   * @return the enrichmentName
   */
  public String enrichmentName() {
    return enrichmentName;
  }

  /**
   * Gets the ignoreDownstreamErrors.
   *
   * If true, then most errors generated during the enrichment process will be treated as warnings and will not cause
   * the document to fail processing.
   *
   * @return the ignoreDownstreamErrors
   */
  public Boolean ignoreDownstreamErrors() {
    return ignoreDownstreamErrors;
  }

  /**
   * Gets the options.
   *
   * A list of options specific to the enrichment.
   *
   * @return the options
   */
  public EnrichmentOptions options() {
    return options;
  }
}

/*
 * (C) Copyright IBM Corp. 2017, 2023.
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

/**
 * Enrichment step to perform on the document. Each enrichment is performed on the specified field
 * in the order that they are listed in the configuration.
 */
public class Enrichment extends GenericModel {

  protected String description;

  @SerializedName("destination_field")
  protected String destinationField;

  @SerializedName("source_field")
  protected String sourceField;

  protected Boolean overwrite;
  protected String enrichment;

  @SerializedName("ignore_downstream_errors")
  protected Boolean ignoreDownstreamErrors;

  protected EnrichmentOptions options;

  /** Builder. */
  public static class Builder {
    private String description;
    private String destinationField;
    private String sourceField;
    private Boolean overwrite;
    private String enrichment;
    private Boolean ignoreDownstreamErrors;
    private EnrichmentOptions options;

    /**
     * Instantiates a new Builder from an existing Enrichment instance.
     *
     * @param enrichment the instance to initialize the Builder with
     */
    private Builder(Enrichment enrichment) {
      this.description = enrichment.description;
      this.destinationField = enrichment.destinationField;
      this.sourceField = enrichment.sourceField;
      this.overwrite = enrichment.overwrite;
      this.enrichment = enrichment.enrichment;
      this.ignoreDownstreamErrors = enrichment.ignoreDownstreamErrors;
      this.options = enrichment.options;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param destinationField the destinationField
     * @param sourceField the sourceField
     * @param enrichment the enrichment
     */
    public Builder(String destinationField, String sourceField, String enrichment) {
      this.destinationField = destinationField;
      this.sourceField = sourceField;
      this.enrichment = enrichment;
    }

    /**
     * Builds a Enrichment.
     *
     * @return the new Enrichment instance
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
     * Set the enrichment.
     *
     * @param enrichment the enrichment
     * @return the Enrichment builder
     */
    public Builder enrichment(String enrichment) {
      this.enrichment = enrichment;
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

  protected Enrichment() {}

  protected Enrichment(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.destinationField, "destinationField cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.sourceField, "sourceField cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enrichment, "enrichment cannot be null");
    description = builder.description;
    destinationField = builder.destinationField;
    sourceField = builder.sourceField;
    overwrite = builder.overwrite;
    enrichment = builder.enrichment;
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
   * <p>Describes what the enrichment step does.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the destinationField.
   *
   * <p>Field where enrichments will be stored. This field must already exist or be at most 1 level
   * deeper than an existing field. For example, if `text` is a top-level field with no sub-fields,
   * `text.foo` is a valid destination but `text.foo.bar` is not.
   *
   * @return the destinationField
   */
  public String destinationField() {
    return destinationField;
  }

  /**
   * Gets the sourceField.
   *
   * <p>Field to be enriched.
   *
   * <p>Arrays can be specified as the **source_field** if the **enrichment** service for this
   * enrichment is set to `natural_language_undstanding`.
   *
   * @return the sourceField
   */
  public String sourceField() {
    return sourceField;
  }

  /**
   * Gets the overwrite.
   *
   * <p>Indicates that the enrichments will overwrite the destination_field field if it already
   * exists.
   *
   * @return the overwrite
   */
  public Boolean overwrite() {
    return overwrite;
  }

  /**
   * Gets the enrichment.
   *
   * <p>Name of the enrichment service to call. The only supported option is
   * `natural_language_understanding`. The `elements` option is deprecated and support ended on 10
   * July 2020.
   *
   * <p>The **options** object must contain Natural Language Understanding options.
   *
   * @return the enrichment
   */
  public String enrichment() {
    return enrichment;
  }

  /**
   * Gets the ignoreDownstreamErrors.
   *
   * <p>If true, then most errors generated during the enrichment process will be treated as
   * warnings and will not cause the document to fail processing.
   *
   * @return the ignoreDownstreamErrors
   */
  public Boolean ignoreDownstreamErrors() {
    return ignoreDownstreamErrors;
  }

  /**
   * Gets the options.
   *
   * <p>Options that are specific to a particular enrichment.
   *
   * <p>The `elements` enrichment type is deprecated. Use the [Create a
   * project](https://cloud.ibm.com/apidocs/discovery-data#createproject) method of the Discovery v2
   * API to create a `content_intelligence` project type instead.
   *
   * @return the options
   */
  public EnrichmentOptions options() {
    return options;
  }
}

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

/**
 * Enrichment.
 */
public class Enrichment extends GenericModel {

  /** Describes what the enrichment step does. */
  private String description;
  /**
   * Field where enrichments will be stored. This field must already exist or be at most 1 level deeper than an existing
   * field. For example, if `text` is a top-level field with no sub-fields, `text.foo` is a valid destination but
   * `text.foo.bar` is not.
   */
  @SerializedName("destination_field")
  private String destinationField;
  /** Field to be enriched. */
  @SerializedName("source_field")
  private String sourceField;
  /** Indicates that the enrichments will overwrite the destination_field field if it already exists. */
  private Boolean overwrite;
  /** Name of the enrichment service to call. Currently the only valid value is `alchemy_language`. */
  private String enrichment;
  /**
   * If true, then most errors generated during the enrichment process will be treated as warnings and will not cause
   * the document to fail processing.
   */
  @SerializedName("ignore_downstream_errors")
  private Boolean ignoreDownstreamErrors;
  /** A list of options specific to the enrichment. */
  private EnrichmentOptions options;

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the destinationField.
   *
   * @return the destinationField
   */
  public String getDestinationField() {
    return destinationField;
  }

  /**
   * Gets the sourceField.
   *
   * @return the sourceField
   */
  public String getSourceField() {
    return sourceField;
  }

  /**
   * Gets the overwrite.
   *
   * @return the overwrite
   */
  public Boolean isOverwrite() {
    return overwrite;
  }

  /**
   * Gets the enrichment.
   *
   * @return the enrichment
   */
  public String getEnrichment() {
    return enrichment;
  }

  /**
   * Gets the ignoreDownstreamErrors.
   *
   * @return the ignoreDownstreamErrors
   */
  public Boolean isIgnoreDownstreamErrors() {
    return ignoreDownstreamErrors;
  }

  /**
   * Gets the options.
   *
   * @return the options
   */
  public EnrichmentOptions getOptions() {
    return options;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the destinationField.
   *
   * @param destinationField the new destinationField
   */
  public void setDestinationField(final String destinationField) {
    this.destinationField = destinationField;
  }

  /**
   * Sets the sourceField.
   *
   * @param sourceField the new sourceField
   */
  public void setSourceField(final String sourceField) {
    this.sourceField = sourceField;
  }

  /**
   * Sets the overwrite.
   *
   * @param overwrite the new overwrite
   */
  public void setOverwrite(final Boolean overwrite) {
    this.overwrite = overwrite;
  }

  /**
   * Sets the enrichment.
   *
   * @param enrichment the new enrichment
   */
  public void setEnrichment(final String enrichment) {
    this.enrichment = enrichment;
  }

  /**
   * Sets the ignoreDownstreamErrors.
   *
   * @param ignoreDownstreamErrors the new ignoreDownstreamErrors
   */
  public void setIgnoreDownstreamErrors(final Boolean ignoreDownstreamErrors) {
    this.ignoreDownstreamErrors = ignoreDownstreamErrors;
  }

  /**
   * Sets the options.
   *
   * @param options the new options
   */
  public void setOptions(final EnrichmentOptions options) {
    this.options = options;
  }
}

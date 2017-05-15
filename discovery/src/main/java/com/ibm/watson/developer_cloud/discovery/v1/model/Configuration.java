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

import java.util.Date;
import java.util.List;

/**
 * A custom configuration for the environment.
 */
public class Configuration extends GenericModel {

  /** The unique identifier of the configuration. */
  @SerializedName("configuration_id")
  private String configurationId;
  /** The name of the configuration. */
  private String name;
  /** The creation date of the configuration in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'. */
  private Date created;
  /** The timestamp of when the configuration was last updated in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'. */
  private Date updated;
  /** The description of the configuration, if available. */
  private String description;
  /** The document conversion settings for the configuration. */
  private Conversions conversions;
  /** An array of document enrichment settings for the configuration. */
  private List<Enrichment> enrichments;
  /** Defines operations that can be used to transform the final output JSON into a normalized form. Operations are
   * executed in the order that they appear in the array. */
  private List<NormalizationOperation> normalizations;

  /**
   * Gets the configurationId.
   *
   * @return the configurationId
   */
  public String getConfigurationId() {
    return configurationId;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the conversions.
   *
   * @return the conversions
   */
  public Conversions getConversions() {
    return conversions;
  }

  /**
   * Gets the enrichments.
   *
   * @return the enrichments
   */
  public List<Enrichment> getEnrichments() {
    return enrichments;
  }

  /**
   * Gets the normalizations.
   *
   * @return the normalizations
   */
  public List<NormalizationOperation> getNormalizations() {
    return normalizations;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
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
   * Sets the conversions.
   *
   * @param conversions the new conversions
   */
  public void setConversions(final Conversions conversions) {
    this.conversions = conversions;
  }

  /**
   * Sets the enrichments.
   *
   * @param enrichments the new enrichments
   */
  public void setEnrichments(final List<Enrichment> enrichments) {
    this.enrichments = enrichments;
  }

  /**
   * Sets the normalizations.
   *
   * @param normalizations the new normalizations
   */
  public void setNormalizations(final List<NormalizationOperation> normalizations) {
    this.normalizations = normalizations;
  }
}

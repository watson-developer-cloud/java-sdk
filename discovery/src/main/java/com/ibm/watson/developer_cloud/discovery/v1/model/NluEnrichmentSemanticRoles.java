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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An object specifiying the semantic roles enrichment and related parameters.
 */
public class NluEnrichmentSemanticRoles extends GenericModel {

  private Boolean entities;
  private Boolean keywords;
  private Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean entities;
    private Boolean keywords;
    private Long limit;

    private Builder(NluEnrichmentSemanticRoles nluEnrichmentSemanticRoles) {
      entities = nluEnrichmentSemanticRoles.entities;
      keywords = nluEnrichmentSemanticRoles.keywords;
      limit = nluEnrichmentSemanticRoles.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NluEnrichmentSemanticRoles.
     *
     * @return the nluEnrichmentSemanticRoles
     */
    public NluEnrichmentSemanticRoles build() {
      return new NluEnrichmentSemanticRoles(this);
    }

    /**
     * Set the entities.
     *
     * @param entities the entities
     * @return the NluEnrichmentSemanticRoles builder
     */
    public Builder entities(Boolean entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the keywords.
     *
     * @param keywords the keywords
     * @return the NluEnrichmentSemanticRoles builder
     */
    public Builder keywords(Boolean keywords) {
      this.keywords = keywords;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the NluEnrichmentSemanticRoles builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  private NluEnrichmentSemanticRoles(Builder builder) {
    entities = builder.entities;
    keywords = builder.keywords;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a NluEnrichmentSemanticRoles builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the entities.
   *
   * When `true` entities are extracted from the identified sentence parts.
   *
   * @return the entities
   */
  public Boolean entities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * When `true`, keywords are extracted from the identified sentence parts.
   *
   * @return the keywords
   */
  public Boolean keywords() {
    return keywords;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of semantic roles enrichments to extact from each instance of the specified field.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

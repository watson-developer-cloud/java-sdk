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
 * Options which are specific to a particular enrichment.
 */
public class EnrichmentOptions extends GenericModel {

  private NluEnrichmentFeatures features;
  private String model;

  /**
   * Builder.
   */
  public static class Builder {
    private NluEnrichmentFeatures features;
    private String model;

    private Builder(EnrichmentOptions enrichmentOptions) {
      features = enrichmentOptions.features;
      model = enrichmentOptions.model;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a EnrichmentOptions.
     *
     * @return the enrichmentOptions
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
     * Set the model.
     *
     * @param model the model
     * @return the EnrichmentOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  private EnrichmentOptions(Builder builder) {
    features = builder.features;
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
   * An object representing the enrichment features that will be applied to the specified field.
   *
   * @return the features
   */
  public NluEnrichmentFeatures features() {
    return features;
  }

  /**
   * Gets the model.
   *
   * *For use with `elements` enrichments only.* The element extraction model to use. Models available are: `contract`.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}

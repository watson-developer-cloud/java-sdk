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

/**
 * An object specifying the relations enrichment and related parameters.
 */
public class NluEnrichmentRelations extends GenericModel {

  protected String model;

  /**
   * Builder.
   */
  public static class Builder {
    private String model;

    private Builder(NluEnrichmentRelations nluEnrichmentRelations) {
      this.model = nluEnrichmentRelations.model;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NluEnrichmentRelations.
     *
     * @return the nluEnrichmentRelations
     */
    public NluEnrichmentRelations build() {
      return new NluEnrichmentRelations(this);
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the NluEnrichmentRelations builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected NluEnrichmentRelations(Builder builder) {
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a NluEnrichmentRelations builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the model.
   *
   * *For use with `natural_language_understanding` enrichments only.* The enrichement model to use with relationship
   * extraction. May be a custom model provided by Watson Knowledge Studio, the default public model is`en-news`.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}

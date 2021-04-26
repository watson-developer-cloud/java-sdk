/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/** An object specifiying the concepts enrichment and related parameters. */
public class NluEnrichmentConcepts extends GenericModel {

  protected Long limit;

  /** Builder. */
  public static class Builder {
    private Long limit;

    private Builder(NluEnrichmentConcepts nluEnrichmentConcepts) {
      this.limit = nluEnrichmentConcepts.limit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a NluEnrichmentConcepts.
     *
     * @return the new NluEnrichmentConcepts instance
     */
    public NluEnrichmentConcepts build() {
      return new NluEnrichmentConcepts(this);
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the NluEnrichmentConcepts builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected NluEnrichmentConcepts(Builder builder) {
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a NluEnrichmentConcepts builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the limit.
   *
   * <p>The maximum number of concepts enrichments to extact from each instance of the specified
   * field.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

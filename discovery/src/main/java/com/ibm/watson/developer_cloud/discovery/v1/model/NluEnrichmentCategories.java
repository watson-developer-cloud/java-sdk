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

import com.ibm.watson.developer_cloud.service.model.DynamicModel;

/**
 * An object that indicates the Categories enrichment will be applied to the specified field.
 */
public class NluEnrichmentCategories extends DynamicModel {

  /**
   * Builder.
   */
  public static class Builder {

    private Builder(NluEnrichmentCategories nluEnrichmentCategories) {
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NluEnrichmentCategories.
     *
     * @return the nluEnrichmentCategories
     */
    public NluEnrichmentCategories build() {
      NluEnrichmentCategories nluEnrichmentCategories = new NluEnrichmentCategories();
      return nluEnrichmentCategories;
    }
  }

  private NluEnrichmentCategories(Builder builder) {
  }

  /**
   * New builder.
   *
   * @return a NluEnrichmentCategories builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

}

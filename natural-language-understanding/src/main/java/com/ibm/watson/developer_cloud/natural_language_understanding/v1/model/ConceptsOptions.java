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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Whether or not to analyze content for general concepts that are referenced or alluded to.
 */
public class ConceptsOptions extends GenericModel {

  /** Maximum number of concepts to return. */
  private Integer limit;

  /**
   * Builder.
   */
  public static class Builder {
    private Integer limit;

    private Builder(ConceptsOptions conceptsOptions) {
      limit = conceptsOptions.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the ConceptsOptions.
     *
     * @return the conceptsOptions
     */
    public ConceptsOptions build() {
      return new ConceptsOptions(this);
    }

    /**
     * Add the limit.
     *
     * @param limit the limit
     * @return a ConceptsOptions Builder
     */
    public Builder limit(Integer limit) {
      this.limit = limit;
      return this;
    }
  }

  private ConceptsOptions(Builder builder) {
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the limit.
   *
   * @return the limit
   */
  public Integer limit() {
    return limit;
  }

}

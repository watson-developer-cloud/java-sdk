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

  private Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private Long limit;

    private Builder(ConceptsOptions conceptsOptions) {
      limit = conceptsOptions.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ConceptsOptions.
     *
     * @return the conceptsOptions
     */
    public ConceptsOptions build() {
      return new ConceptsOptions(this);
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ConceptsOptions builder
     */
    public Builder limit(long limit) {
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
   * @return a ConceptsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the limit.
   *
   * Maximum number of concepts to return
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

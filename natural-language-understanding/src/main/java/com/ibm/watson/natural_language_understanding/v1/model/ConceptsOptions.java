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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Returns high-level concepts in the content. For example, a research paper about deep learning
 * might return the concept, "Artificial Intelligence" although the term is not mentioned.
 *
 * <p>Supported languages: English, French, German, Italian, Japanese, Korean, Portuguese, Spanish.
 */
public class ConceptsOptions extends GenericModel {

  protected Long limit;

  /** Builder. */
  public static class Builder {
    private Long limit;

    /**
     * Instantiates a new Builder from an existing ConceptsOptions instance.
     *
     * @param conceptsOptions the instance to initialize the Builder with
     */
    private Builder(ConceptsOptions conceptsOptions) {
      this.limit = conceptsOptions.limit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ConceptsOptions.
     *
     * @return the new ConceptsOptions instance
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

  protected ConceptsOptions() {}

  protected ConceptsOptions(Builder builder) {
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
   * <p>Maximum number of concepts to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

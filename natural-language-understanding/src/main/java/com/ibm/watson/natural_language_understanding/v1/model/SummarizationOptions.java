/*
 * (C) Copyright IBM Corp. 2021, 2022.
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
 * (Experimental) Returns a summary of content.
 *
 * <p>Supported languages: English only.
 */
public class SummarizationOptions extends GenericModel {

  protected Long limit;

  /** Builder. */
  public static class Builder {
    private Long limit;

    private Builder(SummarizationOptions summarizationOptions) {
      this.limit = summarizationOptions.limit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SummarizationOptions.
     *
     * @return the new SummarizationOptions instance
     */
    public SummarizationOptions build() {
      return new SummarizationOptions(this);
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the SummarizationOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected SummarizationOptions() {}

  protected SummarizationOptions(Builder builder) {
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a SummarizationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the limit.
   *
   * <p>Maximum number of summary sentences to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

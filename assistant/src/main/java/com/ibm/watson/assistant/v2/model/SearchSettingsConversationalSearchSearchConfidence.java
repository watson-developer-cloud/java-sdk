/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** SearchSettingsConversationalSearchSearchConfidence. */
public class SearchSettingsConversationalSearchSearchConfidence extends GenericModel {

  /**
   * The search confidence threshold. It controls the tendency for conversational search to produce
   * “I don't know” answers.
   */
  public interface Threshold {
    /** rarely. */
    String RARELY = "rarely";
    /** less_often. */
    String LESS_OFTEN = "less_often";
    /** more_often. */
    String MORE_OFTEN = "more_often";
    /** most_often. */
    String MOST_OFTEN = "most_often";
  }

  protected String threshold;

  /** Builder. */
  public static class Builder {
    private String threshold;

    /**
     * Instantiates a new Builder from an existing
     * SearchSettingsConversationalSearchSearchConfidence instance.
     *
     * @param searchSettingsConversationalSearchSearchConfidence the instance to initialize the
     *     Builder with
     */
    private Builder(
        SearchSettingsConversationalSearchSearchConfidence
            searchSettingsConversationalSearchSearchConfidence) {
      this.threshold = searchSettingsConversationalSearchSearchConfidence.threshold;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SearchSettingsConversationalSearchSearchConfidence.
     *
     * @return the new SearchSettingsConversationalSearchSearchConfidence instance
     */
    public SearchSettingsConversationalSearchSearchConfidence build() {
      return new SearchSettingsConversationalSearchSearchConfidence(this);
    }

    /**
     * Set the threshold.
     *
     * @param threshold the threshold
     * @return the SearchSettingsConversationalSearchSearchConfidence builder
     */
    public Builder threshold(String threshold) {
      this.threshold = threshold;
      return this;
    }
  }

  protected SearchSettingsConversationalSearchSearchConfidence() {}

  protected SearchSettingsConversationalSearchSearchConfidence(Builder builder) {
    threshold = builder.threshold;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsConversationalSearchSearchConfidence builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the threshold.
   *
   * <p>The search confidence threshold. It controls the tendency for conversational search to
   * produce “I don't know” answers.
   *
   * @return the threshold
   */
  public String threshold() {
    return threshold;
  }
}

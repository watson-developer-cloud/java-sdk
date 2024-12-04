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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Configuration settings for conversational search. */
public class SearchSettingsConversationalSearch extends GenericModel {

  protected Boolean enabled;

  @SerializedName("response_length")
  protected SearchSettingsConversationalSearchResponseLength responseLength;

  @SerializedName("search_confidence")
  protected SearchSettingsConversationalSearchSearchConfidence searchConfidence;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;
    private SearchSettingsConversationalSearchResponseLength responseLength;
    private SearchSettingsConversationalSearchSearchConfidence searchConfidence;

    /**
     * Instantiates a new Builder from an existing SearchSettingsConversationalSearch instance.
     *
     * @param searchSettingsConversationalSearch the instance to initialize the Builder with
     */
    private Builder(SearchSettingsConversationalSearch searchSettingsConversationalSearch) {
      this.enabled = searchSettingsConversationalSearch.enabled;
      this.responseLength = searchSettingsConversationalSearch.responseLength;
      this.searchConfidence = searchSettingsConversationalSearch.searchConfidence;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param enabled the enabled
     */
    public Builder(Boolean enabled) {
      this.enabled = enabled;
    }

    /**
     * Builds a SearchSettingsConversationalSearch.
     *
     * @return the new SearchSettingsConversationalSearch instance
     */
    public SearchSettingsConversationalSearch build() {
      return new SearchSettingsConversationalSearch(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the SearchSettingsConversationalSearch builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the responseLength.
     *
     * @param responseLength the responseLength
     * @return the SearchSettingsConversationalSearch builder
     */
    public Builder responseLength(SearchSettingsConversationalSearchResponseLength responseLength) {
      this.responseLength = responseLength;
      return this;
    }

    /**
     * Set the searchConfidence.
     *
     * @param searchConfidence the searchConfidence
     * @return the SearchSettingsConversationalSearch builder
     */
    public Builder searchConfidence(
        SearchSettingsConversationalSearchSearchConfidence searchConfidence) {
      this.searchConfidence = searchConfidence;
      return this;
    }
  }

  protected SearchSettingsConversationalSearch() {}

  protected SearchSettingsConversationalSearch(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled, "enabled cannot be null");
    enabled = builder.enabled;
    responseLength = builder.responseLength;
    searchConfidence = builder.searchConfidence;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsConversationalSearch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>Whether to enable conversational search.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the responseLength.
   *
   * @return the responseLength
   */
  public SearchSettingsConversationalSearchResponseLength responseLength() {
    return responseLength;
  }

  /**
   * Gets the searchConfidence.
   *
   * @return the searchConfidence
   */
  public SearchSettingsConversationalSearchSearchConfidence searchConfidence() {
    return searchConfidence;
  }
}

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
import java.util.Map;

/**
 * Configuration settings for the client-side search service or server-side search service used by
 * the search integration.
 */
public class SearchSettingsClientSideSearch extends GenericModel {

  protected String filter;
  protected Map<String, Object> metadata;

  /** Builder. */
  public static class Builder {
    private String filter;
    private Map<String, Object> metadata;

    /**
     * Instantiates a new Builder from an existing SearchSettingsClientSideSearch instance.
     *
     * @param searchSettingsClientSideSearch the instance to initialize the Builder with
     */
    private Builder(SearchSettingsClientSideSearch searchSettingsClientSideSearch) {
      this.filter = searchSettingsClientSideSearch.filter;
      this.metadata = searchSettingsClientSideSearch.metadata;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SearchSettingsClientSideSearch.
     *
     * @return the new SearchSettingsClientSideSearch instance
     */
    public SearchSettingsClientSideSearch build() {
      return new SearchSettingsClientSideSearch(this);
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the SearchSettingsClientSideSearch builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the SearchSettingsClientSideSearch builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }
  }

  protected SearchSettingsClientSideSearch() {}

  protected SearchSettingsClientSideSearch(Builder builder) {
    filter = builder.filter;
    metadata = builder.metadata;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsClientSideSearch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the filter.
   *
   * <p>The filter string that is applied to the search results.
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the metadata.
   *
   * <p>The metadata object.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }
}

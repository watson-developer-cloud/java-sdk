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

/**
 * An object describing the search skill configuration.
 *
 * <p>**Note:** Search settings are not supported in **Import skills** requests, and are not
 * included in **Export skills** responses.
 */
public class SearchSettings extends GenericModel {

  protected SearchSettingsDiscovery discovery;
  protected SearchSettingsMessages messages;

  @SerializedName("schema_mapping")
  protected SearchSettingsSchemaMapping schemaMapping;

  @SerializedName("elastic_search")
  protected SearchSettingsElasticSearch elasticSearch;

  @SerializedName("conversational_search")
  protected SearchSettingsConversationalSearch conversationalSearch;

  @SerializedName("server_side_search")
  protected SearchSettingsServerSideSearch serverSideSearch;

  @SerializedName("client_side_search")
  protected SearchSettingsClientSideSearch clientSideSearch;

  /** Builder. */
  public static class Builder {
    private SearchSettingsDiscovery discovery;
    private SearchSettingsMessages messages;
    private SearchSettingsSchemaMapping schemaMapping;
    private SearchSettingsElasticSearch elasticSearch;
    private SearchSettingsConversationalSearch conversationalSearch;
    private SearchSettingsServerSideSearch serverSideSearch;
    private SearchSettingsClientSideSearch clientSideSearch;

    /**
     * Instantiates a new Builder from an existing SearchSettings instance.
     *
     * @param searchSettings the instance to initialize the Builder with
     */
    private Builder(SearchSettings searchSettings) {
      this.discovery = searchSettings.discovery;
      this.messages = searchSettings.messages;
      this.schemaMapping = searchSettings.schemaMapping;
      this.elasticSearch = searchSettings.elasticSearch;
      this.conversationalSearch = searchSettings.conversationalSearch;
      this.serverSideSearch = searchSettings.serverSideSearch;
      this.clientSideSearch = searchSettings.clientSideSearch;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param discovery the discovery
     * @param messages the messages
     * @param schemaMapping the schemaMapping
     */
    public Builder(
        SearchSettingsDiscovery discovery,
        SearchSettingsMessages messages,
        SearchSettingsSchemaMapping schemaMapping) {
      this.discovery = discovery;
      this.messages = messages;
      this.schemaMapping = schemaMapping;
    }

    /**
     * Builds a SearchSettings.
     *
     * @return the new SearchSettings instance
     */
    public SearchSettings build() {
      return new SearchSettings(this);
    }

    /**
     * Set the discovery.
     *
     * @param discovery the discovery
     * @return the SearchSettings builder
     */
    public Builder discovery(SearchSettingsDiscovery discovery) {
      this.discovery = discovery;
      return this;
    }

    /**
     * Set the messages.
     *
     * @param messages the messages
     * @return the SearchSettings builder
     */
    public Builder messages(SearchSettingsMessages messages) {
      this.messages = messages;
      return this;
    }

    /**
     * Set the schemaMapping.
     *
     * @param schemaMapping the schemaMapping
     * @return the SearchSettings builder
     */
    public Builder schemaMapping(SearchSettingsSchemaMapping schemaMapping) {
      this.schemaMapping = schemaMapping;
      return this;
    }

    /**
     * Set the elasticSearch.
     *
     * @param elasticSearch the elasticSearch
     * @return the SearchSettings builder
     */
    public Builder elasticSearch(SearchSettingsElasticSearch elasticSearch) {
      this.elasticSearch = elasticSearch;
      return this;
    }

    /**
     * Set the conversationalSearch.
     *
     * @param conversationalSearch the conversationalSearch
     * @return the SearchSettings builder
     */
    public Builder conversationalSearch(SearchSettingsConversationalSearch conversationalSearch) {
      this.conversationalSearch = conversationalSearch;
      return this;
    }

    /**
     * Set the serverSideSearch.
     *
     * @param serverSideSearch the serverSideSearch
     * @return the SearchSettings builder
     */
    public Builder serverSideSearch(SearchSettingsServerSideSearch serverSideSearch) {
      this.serverSideSearch = serverSideSearch;
      return this;
    }

    /**
     * Set the clientSideSearch.
     *
     * @param clientSideSearch the clientSideSearch
     * @return the SearchSettings builder
     */
    public Builder clientSideSearch(SearchSettingsClientSideSearch clientSideSearch) {
      this.clientSideSearch = clientSideSearch;
      return this;
    }
  }

  protected SearchSettings() {}

  protected SearchSettings(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.discovery, "discovery cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.messages, "messages cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.schemaMapping, "schemaMapping cannot be null");
    discovery = builder.discovery;
    messages = builder.messages;
    schemaMapping = builder.schemaMapping;
    elasticSearch = builder.elasticSearch;
    conversationalSearch = builder.conversationalSearch;
    serverSideSearch = builder.serverSideSearch;
    clientSideSearch = builder.clientSideSearch;
  }

  /**
   * New builder.
   *
   * @return a SearchSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the discovery.
   *
   * <p>Configuration settings for the Watson Discovery service instance used by the search
   * integration.
   *
   * @return the discovery
   */
  public SearchSettingsDiscovery discovery() {
    return discovery;
  }

  /**
   * Gets the messages.
   *
   * <p>The messages included with responses from the search integration.
   *
   * @return the messages
   */
  public SearchSettingsMessages messages() {
    return messages;
  }

  /**
   * Gets the schemaMapping.
   *
   * <p>The mapping between fields in the Watson Discovery collection and properties in the search
   * response.
   *
   * @return the schemaMapping
   */
  public SearchSettingsSchemaMapping schemaMapping() {
    return schemaMapping;
  }

  /**
   * Gets the elasticSearch.
   *
   * <p>Configuration settings for the Elasticsearch service used by the search integration. You can
   * provide either basic auth or apiKey auth.
   *
   * @return the elasticSearch
   */
  public SearchSettingsElasticSearch elasticSearch() {
    return elasticSearch;
  }

  /**
   * Gets the conversationalSearch.
   *
   * <p>Configuration settings for conversational search.
   *
   * @return the conversationalSearch
   */
  public SearchSettingsConversationalSearch conversationalSearch() {
    return conversationalSearch;
  }

  /**
   * Gets the serverSideSearch.
   *
   * <p>Configuration settings for the server-side search service used by the search integration.
   * You can provide either basic auth, apiKey auth or none.
   *
   * @return the serverSideSearch
   */
  public SearchSettingsServerSideSearch serverSideSearch() {
    return serverSideSearch;
  }

  /**
   * Gets the clientSideSearch.
   *
   * <p>Configuration settings for the client-side search service or server-side search service used
   * by the search integration.
   *
   * @return the clientSideSearch
   */
  public SearchSettingsClientSideSearch clientSideSearch() {
    return clientSideSearch;
  }
}

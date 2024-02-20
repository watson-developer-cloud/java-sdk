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

  /** Builder. */
  public static class Builder {
    private SearchSettingsDiscovery discovery;
    private SearchSettingsMessages messages;
    private SearchSettingsSchemaMapping schemaMapping;

    /**
     * Instantiates a new Builder from an existing SearchSettings instance.
     *
     * @param searchSettings the instance to initialize the Builder with
     */
    private Builder(SearchSettings searchSettings) {
      this.discovery = searchSettings.discovery;
      this.messages = searchSettings.messages;
      this.schemaMapping = searchSettings.schemaMapping;
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
}

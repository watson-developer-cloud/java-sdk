/*
 * (C) Copyright IBM Corp. 2023, 2024.
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

/**
 * The mapping between fields in the Watson Discovery collection and properties in the search
 * response.
 */
public class SearchSettingsSchemaMapping extends GenericModel {

  protected String url;
  protected String body;
  protected String title;

  /** Builder. */
  public static class Builder {
    private String url;
    private String body;
    private String title;

    /**
     * Instantiates a new Builder from an existing SearchSettingsSchemaMapping instance.
     *
     * @param searchSettingsSchemaMapping the instance to initialize the Builder with
     */
    private Builder(SearchSettingsSchemaMapping searchSettingsSchemaMapping) {
      this.url = searchSettingsSchemaMapping.url;
      this.body = searchSettingsSchemaMapping.body;
      this.title = searchSettingsSchemaMapping.title;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     * @param body the body
     * @param title the title
     */
    public Builder(String url, String body, String title) {
      this.url = url;
      this.body = body;
      this.title = title;
    }

    /**
     * Builds a SearchSettingsSchemaMapping.
     *
     * @return the new SearchSettingsSchemaMapping instance
     */
    public SearchSettingsSchemaMapping build() {
      return new SearchSettingsSchemaMapping(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the SearchSettingsSchemaMapping builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the SearchSettingsSchemaMapping builder
     */
    public Builder body(String body) {
      this.body = body;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the SearchSettingsSchemaMapping builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }
  }

  protected SearchSettingsSchemaMapping() {}

  protected SearchSettingsSchemaMapping(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url, "url cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.body, "body cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.title, "title cannot be null");
    url = builder.url;
    body = builder.body;
    title = builder.title;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsSchemaMapping builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * <p>The field in the collection to map to the **url** property of the response.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the body.
   *
   * <p>The field in the collection to map to the **body** property in the response.
   *
   * @return the body
   */
  public String body() {
    return body;
  }

  /**
   * Gets the title.
   *
   * <p>The field in the collection to map to the **title** property for the schema.
   *
   * @return the title
   */
  public String title() {
    return title;
  }
}

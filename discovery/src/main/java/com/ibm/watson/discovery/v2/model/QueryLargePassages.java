/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.discovery.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Configuration for passage retrieval.
 */
public class QueryLargePassages extends GenericModel {

  protected Boolean enabled;
  @SerializedName("per_document")
  protected Boolean perDocument;
  @SerializedName("max_per_document")
  protected Long maxPerDocument;
  protected List<String> fields;
  protected Long count;
  protected Long characters;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private Boolean perDocument;
    private Long maxPerDocument;
    private List<String> fields;
    private Long count;
    private Long characters;

    private Builder(QueryLargePassages queryLargePassages) {
      this.enabled = queryLargePassages.enabled;
      this.perDocument = queryLargePassages.perDocument;
      this.maxPerDocument = queryLargePassages.maxPerDocument;
      this.fields = queryLargePassages.fields;
      this.count = queryLargePassages.count;
      this.characters = queryLargePassages.characters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a QueryLargePassages.
     *
     * @return the queryLargePassages
     */
    public QueryLargePassages build() {
      return new QueryLargePassages(this);
    }

    /**
     * Adds an fields to fields.
     *
     * @param fields the new fields
     * @return the QueryLargePassages builder
     */
    public Builder addFields(String fields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(fields,
          "fields cannot be null");
      if (this.fields == null) {
        this.fields = new ArrayList<String>();
      }
      this.fields.add(fields);
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the QueryLargePassages builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the perDocument.
     *
     * @param perDocument the perDocument
     * @return the QueryLargePassages builder
     */
    public Builder perDocument(Boolean perDocument) {
      this.perDocument = perDocument;
      return this;
    }

    /**
     * Set the maxPerDocument.
     *
     * @param maxPerDocument the maxPerDocument
     * @return the QueryLargePassages builder
     */
    public Builder maxPerDocument(long maxPerDocument) {
      this.maxPerDocument = maxPerDocument;
      return this;
    }

    /**
     * Set the fields.
     * Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the QueryLargePassages builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryLargePassages builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the characters.
     *
     * @param characters the characters
     * @return the QueryLargePassages builder
     */
    public Builder characters(long characters) {
      this.characters = characters;
      return this;
    }
  }

  protected QueryLargePassages(Builder builder) {
    enabled = builder.enabled;
    perDocument = builder.perDocument;
    maxPerDocument = builder.maxPerDocument;
    fields = builder.fields;
    count = builder.count;
    characters = builder.characters;
  }

  /**
   * New builder.
   *
   * @return a QueryLargePassages builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * A passages query that returns the most relevant passages from the results.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the perDocument.
   *
   * When `true`, passages will be returned within their respective result.
   *
   * @return the perDocument
   */
  public Boolean perDocument() {
    return perDocument;
  }

  /**
   * Gets the maxPerDocument.
   *
   * Maximum number of passages to return per result.
   *
   * @return the maxPerDocument
   */
  public Long maxPerDocument() {
    return maxPerDocument;
  }

  /**
   * Gets the fields.
   *
   * A list of fields that passages are drawn from. If this parameter not specified, then all top-level fields are
   * included.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }

  /**
   * Gets the count.
   *
   * The maximum number of passages to return. The search returns fewer passages if the requested total is not found.
   * The default is `10`. The maximum is `100`.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the characters.
   *
   * The approximate number of characters that any one passage will have.
   *
   * @return the characters
   */
  public Long characters() {
    return characters;
  }
}

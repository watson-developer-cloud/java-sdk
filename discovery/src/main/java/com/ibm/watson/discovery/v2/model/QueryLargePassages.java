/*
 * (C) Copyright IBM Corp. 2019.
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

  private Boolean enabled;
  @SerializedName("per_document")
  private Boolean perDocument;
  @SerializedName("max_passages_per_document")
  private Long maxPassagesPerDocument;
  private List<String> fields;
  private Long count;
  private Long characters;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private Boolean perDocument;
    private Long maxPassagesPerDocument;
    private List<String> fields;
    private Long count;
    private Long characters;

    private Builder(QueryLargePassages queryLargePassages) {
      this.enabled = queryLargePassages.enabled;
      this.perDocument = queryLargePassages.perDocument;
      this.maxPassagesPerDocument = queryLargePassages.maxPassagesPerDocument;
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
     * Set the maxPassagesPerDocument.
     *
     * @param maxPassagesPerDocument the maxPassagesPerDocument
     * @return the QueryLargePassages builder
     */
    public Builder maxPassagesPerDocument(long maxPassagesPerDocument) {
      this.maxPassagesPerDocument = maxPassagesPerDocument;
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

  private QueryLargePassages(Builder builder) {
    enabled = builder.enabled;
    perDocument = builder.perDocument;
    maxPassagesPerDocument = builder.maxPassagesPerDocument;
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
   * When `true`, passages will be returned whithin their respective result.
   *
   * @return the perDocument
   */
  public Boolean perDocument() {
    return perDocument;
  }

  /**
   * Gets the maxPassagesPerDocument.
   *
   * Maximum number of passages to return per result.
   *
   * @return the maxPassagesPerDocument
   */
  public Long maxPassagesPerDocument() {
    return maxPassagesPerDocument;
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

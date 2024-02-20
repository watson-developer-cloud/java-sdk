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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** Default settings configuration for passage search options. */
public class DefaultQueryParamsPassages extends GenericModel {

  protected Boolean enabled;
  protected Long count;
  protected List<String> fields;
  protected Long characters;

  @SerializedName("per_document")
  protected Boolean perDocument;

  @SerializedName("max_per_document")
  protected Long maxPerDocument;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;
    private Long count;
    private List<String> fields;
    private Long characters;
    private Boolean perDocument;
    private Long maxPerDocument;

    /**
     * Instantiates a new Builder from an existing DefaultQueryParamsPassages instance.
     *
     * @param defaultQueryParamsPassages the instance to initialize the Builder with
     */
    private Builder(DefaultQueryParamsPassages defaultQueryParamsPassages) {
      this.enabled = defaultQueryParamsPassages.enabled;
      this.count = defaultQueryParamsPassages.count;
      this.fields = defaultQueryParamsPassages.fields;
      this.characters = defaultQueryParamsPassages.characters;
      this.perDocument = defaultQueryParamsPassages.perDocument;
      this.maxPerDocument = defaultQueryParamsPassages.maxPerDocument;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DefaultQueryParamsPassages.
     *
     * @return the new DefaultQueryParamsPassages instance
     */
    public DefaultQueryParamsPassages build() {
      return new DefaultQueryParamsPassages(this);
    }

    /**
     * Adds a new element to fields.
     *
     * @param fields the new element to be added
     * @return the DefaultQueryParamsPassages builder
     */
    public Builder addFields(String fields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(fields, "fields cannot be null");
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
     * @return the DefaultQueryParamsPassages builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the DefaultQueryParamsPassages builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the fields. Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the DefaultQueryParamsPassages builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the characters.
     *
     * @param characters the characters
     * @return the DefaultQueryParamsPassages builder
     */
    public Builder characters(long characters) {
      this.characters = characters;
      return this;
    }

    /**
     * Set the perDocument.
     *
     * @param perDocument the perDocument
     * @return the DefaultQueryParamsPassages builder
     */
    public Builder perDocument(Boolean perDocument) {
      this.perDocument = perDocument;
      return this;
    }

    /**
     * Set the maxPerDocument.
     *
     * @param maxPerDocument the maxPerDocument
     * @return the DefaultQueryParamsPassages builder
     */
    public Builder maxPerDocument(long maxPerDocument) {
      this.maxPerDocument = maxPerDocument;
      return this;
    }
  }

  protected DefaultQueryParamsPassages() {}

  protected DefaultQueryParamsPassages(Builder builder) {
    enabled = builder.enabled;
    count = builder.count;
    fields = builder.fields;
    characters = builder.characters;
    perDocument = builder.perDocument;
    maxPerDocument = builder.maxPerDocument;
  }

  /**
   * New builder.
   *
   * @return a DefaultQueryParamsPassages builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>When `true`, a passage search is performed by default.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the count.
   *
   * <p>The number of passages to return.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the fields.
   *
   * <p>An array of field names to perform the passage search on.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }

  /**
   * Gets the characters.
   *
   * <p>The approximate number of characters that each returned passage will contain.
   *
   * @return the characters
   */
  public Long characters() {
    return characters;
  }

  /**
   * Gets the perDocument.
   *
   * <p>When `true` the number of passages that can be returned from a single document is restricted
   * to the *max_per_document* value.
   *
   * @return the perDocument
   */
  public Boolean perDocument() {
    return perDocument;
  }

  /**
   * Gets the maxPerDocument.
   *
   * <p>The default maximum number of passages that can be taken from a single document as the
   * result of a passage query.
   *
   * @return the maxPerDocument
   */
  public Long maxPerDocument() {
    return maxPerDocument;
  }
}

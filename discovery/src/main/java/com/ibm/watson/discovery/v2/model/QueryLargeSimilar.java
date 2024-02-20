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

/**
 * Finds results from documents that are similar to documents of interest. Use this parameter to add
 * a *More like these* function to your search. You can include this parameter with or without a
 * **query**, **filter** or **natural_language_query** parameter.
 */
public class QueryLargeSimilar extends GenericModel {

  protected Boolean enabled;

  @SerializedName("document_ids")
  protected List<String> documentIds;

  protected List<String> fields;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;
    private List<String> documentIds;
    private List<String> fields;

    /**
     * Instantiates a new Builder from an existing QueryLargeSimilar instance.
     *
     * @param queryLargeSimilar the instance to initialize the Builder with
     */
    private Builder(QueryLargeSimilar queryLargeSimilar) {
      this.enabled = queryLargeSimilar.enabled;
      this.documentIds = queryLargeSimilar.documentIds;
      this.fields = queryLargeSimilar.fields;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a QueryLargeSimilar.
     *
     * @return the new QueryLargeSimilar instance
     */
    public QueryLargeSimilar build() {
      return new QueryLargeSimilar(this);
    }

    /**
     * Adds a new element to documentIds.
     *
     * @param documentIds the new element to be added
     * @return the QueryLargeSimilar builder
     */
    public Builder addDocumentIds(String documentIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(documentIds, "documentIds cannot be null");
      if (this.documentIds == null) {
        this.documentIds = new ArrayList<String>();
      }
      this.documentIds.add(documentIds);
      return this;
    }

    /**
     * Adds a new element to fields.
     *
     * @param fields the new element to be added
     * @return the QueryLargeSimilar builder
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
     * @return the QueryLargeSimilar builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the documentIds. Existing documentIds will be replaced.
     *
     * @param documentIds the documentIds
     * @return the QueryLargeSimilar builder
     */
    public Builder documentIds(List<String> documentIds) {
      this.documentIds = documentIds;
      return this;
    }

    /**
     * Set the fields. Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the QueryLargeSimilar builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }
  }

  protected QueryLargeSimilar() {}

  protected QueryLargeSimilar(Builder builder) {
    enabled = builder.enabled;
    documentIds = builder.documentIds;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a QueryLargeSimilar builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>When `true`, includes documents in the query results that are similar to documents you
   * specify.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the documentIds.
   *
   * <p>The list of documents of interest. Required if **enabled** is `true`.
   *
   * @return the documentIds
   */
  public List<String> documentIds() {
    return documentIds;
  }

  /**
   * Gets the fields.
   *
   * <p>Looks for similarities in the specified subset of fields in the documents. If not specified,
   * all of the document fields are used.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }
}

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
 * An object that describes enrichments that are applied to the training and test data that is used
 * by the document classifier.
 */
public class DocumentClassifierEnrichment extends GenericModel {

  @SerializedName("enrichment_id")
  protected String enrichmentId;

  protected List<String> fields;

  /** Builder. */
  public static class Builder {
    private String enrichmentId;
    private List<String> fields;

    /**
     * Instantiates a new Builder from an existing DocumentClassifierEnrichment instance.
     *
     * @param documentClassifierEnrichment the instance to initialize the Builder with
     */
    private Builder(DocumentClassifierEnrichment documentClassifierEnrichment) {
      this.enrichmentId = documentClassifierEnrichment.enrichmentId;
      this.fields = documentClassifierEnrichment.fields;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param enrichmentId the enrichmentId
     * @param fields the fields
     */
    public Builder(String enrichmentId, List<String> fields) {
      this.enrichmentId = enrichmentId;
      this.fields = fields;
    }

    /**
     * Builds a DocumentClassifierEnrichment.
     *
     * @return the new DocumentClassifierEnrichment instance
     */
    public DocumentClassifierEnrichment build() {
      return new DocumentClassifierEnrichment(this);
    }

    /**
     * Adds a new element to fields.
     *
     * @param fields the new element to be added
     * @return the DocumentClassifierEnrichment builder
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
     * Set the enrichmentId.
     *
     * @param enrichmentId the enrichmentId
     * @return the DocumentClassifierEnrichment builder
     */
    public Builder enrichmentId(String enrichmentId) {
      this.enrichmentId = enrichmentId;
      return this;
    }

    /**
     * Set the fields. Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the DocumentClassifierEnrichment builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }
  }

  protected DocumentClassifierEnrichment() {}

  protected DocumentClassifierEnrichment(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.enrichmentId, "enrichmentId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.fields, "fields cannot be null");
    enrichmentId = builder.enrichmentId;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a DocumentClassifierEnrichment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enrichmentId.
   *
   * <p>The Universally Unique Identifier (UUID) of the enrichment.
   *
   * @return the enrichmentId
   */
  public String enrichmentId() {
    return enrichmentId;
  }

  /**
   * Gets the fields.
   *
   * <p>An array of field names where the enrichment is applied.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }
}

/*
 * (C) Copyright IBM Corp. 2021.
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

/** An object describing an Enrichment for a collection. */
public class CollectionEnrichment extends GenericModel {

  @SerializedName("enrichment_id")
  protected String enrichmentId;

  protected List<String> fields;

  /** Builder. */
  public static class Builder {
    private String enrichmentId;
    private List<String> fields;

    private Builder(CollectionEnrichment collectionEnrichment) {
      this.enrichmentId = collectionEnrichment.enrichmentId;
      this.fields = collectionEnrichment.fields;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a CollectionEnrichment.
     *
     * @return the new CollectionEnrichment instance
     */
    public CollectionEnrichment build() {
      return new CollectionEnrichment(this);
    }

    /**
     * Adds an fields to fields.
     *
     * @param fields the new fields
     * @return the CollectionEnrichment builder
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
     * @return the CollectionEnrichment builder
     */
    public Builder enrichmentId(String enrichmentId) {
      this.enrichmentId = enrichmentId;
      return this;
    }

    /**
     * Set the fields. Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the CollectionEnrichment builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }
  }

  protected CollectionEnrichment(Builder builder) {
    enrichmentId = builder.enrichmentId;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a CollectionEnrichment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enrichmentId.
   *
   * <p>The unique identifier of this enrichment.
   *
   * @return the enrichmentId
   */
  public String enrichmentId() {
    return enrichmentId;
  }

  /**
   * Gets the fields.
   *
   * <p>An array of field names that the enrichment is applied to.
   *
   * <p>If you apply an enrichment to a field from a JSON file, the data is converted to an array
   * automatically, even if the field contains a single value.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }
}

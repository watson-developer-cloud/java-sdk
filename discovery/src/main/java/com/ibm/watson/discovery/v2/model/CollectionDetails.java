/*
 * (C) Copyright IBM Corp. 2023.
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
import java.util.Date;
import java.util.List;

/** A collection for storing documents. */
public class CollectionDetails extends GenericModel {

  @SerializedName("collection_id")
  protected String collectionId;

  protected String name;
  protected String description;
  protected Date created;
  protected String language;
  protected List<CollectionEnrichment> enrichments;

  @SerializedName("smart_document_understanding")
  protected CollectionDetailsSmartDocumentUnderstanding smartDocumentUnderstanding;

  /** Builder. */
  public static class Builder {
    private String name;
    private String description;
    private String language;
    private List<CollectionEnrichment> enrichments;

    /**
     * Instantiates a new Builder from an existing CollectionDetails instance.
     *
     * @param collectionDetails the instance to initialize the Builder with
     */
    private Builder(CollectionDetails collectionDetails) {
      this.name = collectionDetails.name;
      this.description = collectionDetails.description;
      this.language = collectionDetails.language;
      this.enrichments = collectionDetails.enrichments;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a CollectionDetails.
     *
     * @return the new CollectionDetails instance
     */
    public CollectionDetails build() {
      return new CollectionDetails(this);
    }

    /**
     * Adds an enrichments to enrichments.
     *
     * @param enrichments the new enrichments
     * @return the CollectionDetails builder
     */
    public Builder addEnrichments(CollectionEnrichment enrichments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(enrichments, "enrichments cannot be null");
      if (this.enrichments == null) {
        this.enrichments = new ArrayList<CollectionEnrichment>();
      }
      this.enrichments.add(enrichments);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CollectionDetails builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CollectionDetails builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CollectionDetails builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the enrichments. Existing enrichments will be replaced.
     *
     * @param enrichments the enrichments
     * @return the CollectionDetails builder
     */
    public Builder enrichments(List<CollectionEnrichment> enrichments) {
      this.enrichments = enrichments;
      return this;
    }
  }

  protected CollectionDetails() {}

  protected CollectionDetails(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    name = builder.name;
    description = builder.description;
    language = builder.language;
    enrichments = builder.enrichments;
  }

  /**
   * New builder.
   *
   * @return a CollectionDetails builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * <p>The unique identifier of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the collection.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>A description of the collection.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the created.
   *
   * <p>The date that the collection was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the collection. For a list of supported languages, see the [product
   * documentation](/docs/discovery-data?topic=discovery-data-language-support).
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the enrichments.
   *
   * <p>An array of enrichments that are applied to this collection. To get a list of enrichments
   * that are available for a project, use the [List enrichments](#listenrichments) method.
   *
   * <p>If no enrichments are specified when the collection is created, the default enrichments for
   * the project type are applied. For more information about project default settings, see the
   * [product documentation](/docs/discovery-data?topic=discovery-data-project-defaults).
   *
   * @return the enrichments
   */
  public List<CollectionEnrichment> enrichments() {
    return enrichments;
  }

  /**
   * Gets the smartDocumentUnderstanding.
   *
   * <p>An object that describes the Smart Document Understanding model for a collection.
   *
   * @return the smartDocumentUnderstanding
   */
  public CollectionDetailsSmartDocumentUnderstanding smartDocumentUnderstanding() {
    return smartDocumentUnderstanding;
  }
}

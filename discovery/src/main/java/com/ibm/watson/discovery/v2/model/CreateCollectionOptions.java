/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The createCollection options. */
public class CreateCollectionOptions extends GenericModel {

  protected String projectId;
  protected String name;
  protected String description;
  protected String language;
  protected List<CollectionEnrichment> enrichments;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String name;
    private String description;
    private String language;
    private List<CollectionEnrichment> enrichments;

    /**
     * Instantiates a new Builder from an existing CreateCollectionOptions instance.
     *
     * @param createCollectionOptions the instance to initialize the Builder with
     */
    private Builder(CreateCollectionOptions createCollectionOptions) {
      this.projectId = createCollectionOptions.projectId;
      this.name = createCollectionOptions.name;
      this.description = createCollectionOptions.description;
      this.language = createCollectionOptions.language;
      this.enrichments = createCollectionOptions.enrichments;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param name the name
     */
    public Builder(String projectId, String name) {
      this.projectId = projectId;
      this.name = name;
    }

    /**
     * Builds a CreateCollectionOptions.
     *
     * @return the new CreateCollectionOptions instance
     */
    public CreateCollectionOptions build() {
      return new CreateCollectionOptions(this);
    }

    /**
     * Adds an enrichments to enrichments.
     *
     * @param enrichments the new enrichments
     * @return the CreateCollectionOptions builder
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
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the CreateCollectionOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateCollectionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateCollectionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateCollectionOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the enrichments. Existing enrichments will be replaced.
     *
     * @param enrichments the enrichments
     * @return the CreateCollectionOptions builder
     */
    public Builder enrichments(List<CollectionEnrichment> enrichments) {
      this.enrichments = enrichments;
      return this;
    }

    /**
     * Set the collectionDetails.
     *
     * @param collectionDetails the collectionDetails
     * @return the CreateCollectionOptions builder
     */
    public Builder collectionDetails(CollectionDetails collectionDetails) {
      this.name = collectionDetails.name();
      this.description = collectionDetails.description();
      this.language = collectionDetails.language();
      this.enrichments = collectionDetails.enrichments();
      return this;
    }
  }

  protected CreateCollectionOptions() {}

  protected CreateCollectionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    projectId = builder.projectId;
    name = builder.name;
    description = builder.description;
    language = builder.language;
    enrichments = builder.enrichments;
  }

  /**
   * New builder.
   *
   * @return a CreateCollectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the *Integrate and Deploy* page in
   * Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
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
}

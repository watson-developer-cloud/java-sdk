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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The updateCollection options. */
public class UpdateCollectionOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected String name;
  protected String description;
  protected Boolean ocrEnabled;
  protected List<CollectionEnrichment> enrichments;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private String name;
    private String description;
    private Boolean ocrEnabled;
    private List<CollectionEnrichment> enrichments;

    /**
     * Instantiates a new Builder from an existing UpdateCollectionOptions instance.
     *
     * @param updateCollectionOptions the instance to initialize the Builder with
     */
    private Builder(UpdateCollectionOptions updateCollectionOptions) {
      this.projectId = updateCollectionOptions.projectId;
      this.collectionId = updateCollectionOptions.collectionId;
      this.name = updateCollectionOptions.name;
      this.description = updateCollectionOptions.description;
      this.ocrEnabled = updateCollectionOptions.ocrEnabled;
      this.enrichments = updateCollectionOptions.enrichments;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     */
    public Builder(String projectId, String collectionId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a UpdateCollectionOptions.
     *
     * @return the new UpdateCollectionOptions instance
     */
    public UpdateCollectionOptions build() {
      return new UpdateCollectionOptions(this);
    }

    /**
     * Adds a new element to enrichments.
     *
     * @param enrichments the new element to be added
     * @return the UpdateCollectionOptions builder
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
     * @return the UpdateCollectionOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the UpdateCollectionOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateCollectionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateCollectionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the ocrEnabled.
     *
     * @param ocrEnabled the ocrEnabled
     * @return the UpdateCollectionOptions builder
     */
    public Builder ocrEnabled(Boolean ocrEnabled) {
      this.ocrEnabled = ocrEnabled;
      return this;
    }

    /**
     * Set the enrichments. Existing enrichments will be replaced.
     *
     * @param enrichments the enrichments
     * @return the UpdateCollectionOptions builder
     */
    public Builder enrichments(List<CollectionEnrichment> enrichments) {
      this.enrichments = enrichments;
      return this;
    }
  }

  protected UpdateCollectionOptions() {}

  protected UpdateCollectionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    name = builder.name;
    description = builder.description;
    ocrEnabled = builder.ocrEnabled;
    enrichments = builder.enrichments;
  }

  /**
   * New builder.
   *
   * @return a UpdateCollectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The Universally Unique Identifier (UUID) of the project. This information can be found from
   * the *Integrate and Deploy* page in Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The Universally Unique Identifier (UUID) of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the name.
   *
   * <p>The new name of the collection.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The new description of the collection.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the ocrEnabled.
   *
   * <p>If set to `true`, optical character recognition (OCR) is enabled. For more information, see
   * [Optical character recognition](/docs/discovery-data?topic=discovery-data-collections#ocr).
   *
   * @return the ocrEnabled
   */
  public Boolean ocrEnabled() {
    return ocrEnabled;
  }

  /**
   * Gets the enrichments.
   *
   * <p>An array of enrichments that are applied to this collection.
   *
   * @return the enrichments
   */
  public List<CollectionEnrichment> enrichments() {
    return enrichments;
  }
}

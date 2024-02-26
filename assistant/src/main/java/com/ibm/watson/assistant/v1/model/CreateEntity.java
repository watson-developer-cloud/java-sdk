/*
 * (C) Copyright IBM Corp. 2017, 2024.
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
package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/** CreateEntity. */
public class CreateEntity extends GenericModel {

  protected String entity;
  protected String description;
  protected Map<String, Object> metadata;

  @SerializedName("fuzzy_match")
  protected Boolean fuzzyMatch;

  protected Date created;
  protected Date updated;
  protected List<CreateValue> values;

  /** Builder. */
  public static class Builder {
    private String entity;
    private String description;
    private Map<String, Object> metadata;
    private Boolean fuzzyMatch;
    private List<CreateValue> values;

    /**
     * Instantiates a new Builder from an existing CreateEntity instance.
     *
     * @param createEntity the instance to initialize the Builder with
     */
    private Builder(CreateEntity createEntity) {
      this.entity = createEntity.entity;
      this.description = createEntity.description;
      this.metadata = createEntity.metadata;
      this.fuzzyMatch = createEntity.fuzzyMatch;
      this.values = createEntity.values;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param entity the entity
     */
    public Builder(String entity) {
      this.entity = entity;
    }

    /**
     * Builds a CreateEntity.
     *
     * @return the new CreateEntity instance
     */
    public CreateEntity build() {
      return new CreateEntity(this);
    }

    /**
     * Adds a new element to values.
     *
     * @param values the new element to be added
     * @return the CreateEntity builder
     */
    public Builder addValues(CreateValue values) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(values, "values cannot be null");
      if (this.values == null) {
        this.values = new ArrayList<CreateValue>();
      }
      this.values.add(values);
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the CreateEntity builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateEntity builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateEntity builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the fuzzyMatch.
     *
     * @param fuzzyMatch the fuzzyMatch
     * @return the CreateEntity builder
     */
    public Builder fuzzyMatch(Boolean fuzzyMatch) {
      this.fuzzyMatch = fuzzyMatch;
      return this;
    }

    /**
     * Set the values. Existing values will be replaced.
     *
     * @param values the values
     * @return the CreateEntity builder
     */
    public Builder values(List<CreateValue> values) {
      this.values = values;
      return this;
    }
  }

  protected CreateEntity() {}

  protected CreateEntity(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.entity, "entity cannot be null");
    entity = builder.entity;
    description = builder.description;
    metadata = builder.metadata;
    fuzzyMatch = builder.fuzzyMatch;
    values = builder.values;
  }

  /**
   * New builder.
   *
   * @return a CreateEntity builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the entity.
   *
   * <p>The name of the entity. This string must conform to the following restrictions: - It can
   * contain only Unicode alphanumeric, underscore, and hyphen characters. - If you specify an
   * entity name beginning with the reserved prefix `sys-`, it must be the name of a system entity
   * that you want to enable. (Any entity content specified with the request is ignored.).
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the entity. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the metadata.
   *
   * <p>Any metadata related to the entity.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the fuzzyMatch.
   *
   * <p>Whether to use fuzzy matching for the entity.
   *
   * @return the fuzzyMatch
   */
  public Boolean fuzzyMatch() {
    return fuzzyMatch;
  }

  /**
   * Gets the created.
   *
   * <p>The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }

  /**
   * Gets the values.
   *
   * <p>An array of objects describing the entity values.
   *
   * @return the values
   */
  public List<CreateValue> values() {
    return values;
  }
}

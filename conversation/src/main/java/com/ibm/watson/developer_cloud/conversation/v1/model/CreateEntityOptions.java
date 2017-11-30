/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createEntity options.
 */
public class CreateEntityOptions extends GenericModel {

  private String workspaceId;
  private String entity;
  private String description;
  private Map metadata;
  private List<CreateValue> values;
  private Boolean fuzzyMatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String description;
    private Map metadata;
    private List<CreateValue> values;
    private Boolean fuzzyMatch;

    private Builder(CreateEntityOptions createEntityOptions) {
      workspaceId = createEntityOptions.workspaceId;
      entity = createEntityOptions.entity;
      description = createEntityOptions.description;
      metadata = createEntityOptions.metadata;
      values = createEntityOptions.values;
      fuzzyMatch = createEntityOptions.fuzzyMatch;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param entity the entity
     */
    public Builder(String workspaceId, String entity) {
      this.workspaceId = workspaceId;
      this.entity = entity;
    }

    /**
     * Builds a CreateEntityOptions.
     *
     * @return the createEntityOptions
     */
    public CreateEntityOptions build() {
      return new CreateEntityOptions(this);
    }

    /**
     * Adds an value to values.
     *
     * @param value the new value
     * @return the CreateEntityOptions builder
     */
    public Builder addValue(CreateValue value) {
      Validator.notNull(value, "value cannot be null");
      if (this.values == null) {
        this.values = new ArrayList<CreateValue>();
      }
      this.values.add(value);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateEntityOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the CreateEntityOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateEntityOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateEntityOptions builder
     */
    public Builder metadata(Map metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the values.
     * Existing values will be replaced.
     *
     * @param values the values
     * @return the CreateEntityOptions builder
     */
    public Builder values(List<CreateValue> values) {
      this.values = values;
      return this;
    }

    /**
     * Set the fuzzyMatch.
     *
     * @param fuzzyMatch the fuzzyMatch
     * @return the CreateEntityOptions builder
     */
    public Builder fuzzyMatch(Boolean fuzzyMatch) {
      this.fuzzyMatch = fuzzyMatch;
      return this;
    }
  }

  private CreateEntityOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notNull(builder.entity, "entity cannot be null");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    description = builder.description;
    metadata = builder.metadata;
    values = builder.values;
    fuzzyMatch = builder.fuzzyMatch;
  }

  /**
   * New builder.
   *
   * @return a CreateEntityOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * The workspace ID.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the entity.
   *
   * The name of the entity.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the description.
   *
   * The description of the entity.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata related to the value.
   *
   * @return the metadata
   */
  public Map metadata() {
    return metadata;
  }

  /**
   * Gets the values.
   *
   * An array of entity values.
   *
   * @return the values
   */
  public List<CreateValue> values() {
    return values;
  }

  /**
   * Gets the fuzzyMatch.
   *
   * Whether to use fuzzy matching for the entity.
   *
   * @return the fuzzyMatch
   */
  public Boolean fuzzyMatch() {
    return fuzzyMatch;
  }
}

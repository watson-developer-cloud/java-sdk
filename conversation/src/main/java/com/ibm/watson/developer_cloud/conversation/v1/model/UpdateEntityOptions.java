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
 * The updateEntity options.
 */
public class UpdateEntityOptions extends GenericModel {

  private String workspaceId;
  private String entity;
  private Boolean newFuzzyMatch;
  private String newEntity;
  private Map newMetadata;
  private List<CreateValue> newValues;
  private String newDescription;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private Boolean newFuzzyMatch;
    private String newEntity;
    private Map newMetadata;
    private List<CreateValue> newValues;
    private String newDescription;

    private Builder(UpdateEntityOptions updateEntityOptions) {
      workspaceId = updateEntityOptions.workspaceId;
      entity = updateEntityOptions.entity;
      newFuzzyMatch = updateEntityOptions.newFuzzyMatch;
      newEntity = updateEntityOptions.newEntity;
      newMetadata = updateEntityOptions.newMetadata;
      newValues = updateEntityOptions.newValues;
      newDescription = updateEntityOptions.newDescription;
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
     * Builds a UpdateEntityOptions.
     *
     * @return the updateEntityOptions
     */
    public UpdateEntityOptions build() {
      return new UpdateEntityOptions(this);
    }

    /**
     * Adds an value to newValues.
     *
     * @param value the new value
     * @return the UpdateEntityOptions builder
     */
    public Builder addValue(CreateValue value) {
      Validator.notNull(value, "value cannot be null");
      if (this.newValues == null) {
        this.newValues = new ArrayList<CreateValue>();
      }
      this.newValues.add(value);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateEntityOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the UpdateEntityOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the newFuzzyMatch.
     *
     * @param newFuzzyMatch the newFuzzyMatch
     * @return the UpdateEntityOptions builder
     */
    public Builder newFuzzyMatch(Boolean newFuzzyMatch) {
      this.newFuzzyMatch = newFuzzyMatch;
      return this;
    }

    /**
     * Set the newEntity.
     *
     * @param newEntity the newEntity
     * @return the UpdateEntityOptions builder
     */
    public Builder newEntity(String newEntity) {
      this.newEntity = newEntity;
      return this;
    }

    /**
     * Set the newMetadata.
     *
     * @param newMetadata the newMetadata
     * @return the UpdateEntityOptions builder
     */
    public Builder newMetadata(Map newMetadata) {
      this.newMetadata = newMetadata;
      return this;
    }

    /**
     * Set the newValues.
     * Existing newValues will be replaced.
     *
     * @param newValues the newValues
     * @return the UpdateEntityOptions builder
     */
    public Builder newValues(List<CreateValue> newValues) {
      this.newValues = newValues;
      return this;
    }

    /**
     * Set the newDescription.
     *
     * @param newDescription the newDescription
     * @return the UpdateEntityOptions builder
     */
    public Builder newDescription(String newDescription) {
      this.newDescription = newDescription;
      return this;
    }
  }

  private UpdateEntityOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.entity, "entity cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    newFuzzyMatch = builder.newFuzzyMatch;
    newEntity = builder.newEntity;
    newMetadata = builder.newMetadata;
    newValues = builder.newValues;
    newDescription = builder.newDescription;
  }

  /**
   * New builder.
   *
   * @return a UpdateEntityOptions builder
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
   * Gets the newFuzzyMatch.
   *
   * Whether to use fuzzy matching for the entity.
   *
   * @return the newFuzzyMatch
   */
  public Boolean newFuzzyMatch() {
    return newFuzzyMatch;
  }

  /**
   * Gets the newEntity.
   *
   * The name of the entity.
   *
   * @return the newEntity
   */
  public String newEntity() {
    return newEntity;
  }

  /**
   * Gets the newMetadata.
   *
   * Any metadata related to the entity.
   *
   * @return the newMetadata
   */
  public Map newMetadata() {
    return newMetadata;
  }

  /**
   * Gets the newValues.
   *
   * An array of entity values.
   *
   * @return the newValues
   */
  public List<CreateValue> newValues() {
    return newValues;
  }

  /**
   * Gets the newDescription.
   *
   * The description of the entity.
   *
   * @return the newDescription
   */
  public String newDescription() {
    return newDescription;
  }
}

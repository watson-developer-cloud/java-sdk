/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createEntity options.
 */
public class CreateEntityOptions extends GenericModel {

  protected String workspaceId;
  protected String entity;
  protected String description;
  protected Map<String, Object> metadata;
  protected Boolean fuzzyMatch;
  protected List<CreateValue> values;
  protected Boolean includeAudit;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String description;
    private Map<String, Object> metadata;
    private Boolean fuzzyMatch;
    private List<CreateValue> values;
    private Boolean includeAudit;

    private Builder(CreateEntityOptions createEntityOptions) {
      this.workspaceId = createEntityOptions.workspaceId;
      this.entity = createEntityOptions.entity;
      this.description = createEntityOptions.description;
      this.metadata = createEntityOptions.metadata;
      this.fuzzyMatch = createEntityOptions.fuzzyMatch;
      this.values = createEntityOptions.values;
      this.includeAudit = createEntityOptions.includeAudit;
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
     * Adds an values to values.
     *
     * @param values the new values
     * @return the CreateEntityOptions builder
     */
    public Builder addValues(CreateValue values) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(values,
        "values cannot be null");
      if (this.values == null) {
        this.values = new ArrayList<CreateValue>();
      }
      this.values.add(values);
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
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
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
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the CreateEntityOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected CreateEntityOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.workspaceId,
      "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.entity,
      "entity cannot be null");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    description = builder.description;
    metadata = builder.metadata;
    fuzzyMatch = builder.fuzzyMatch;
    values = builder.values;
    includeAudit = builder.includeAudit;
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
   * Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the entity.
   *
   * The name of the entity. This string must conform to the following restrictions:
   * - It can contain only Unicode alphanumeric, underscore, and hyphen characters.
   * - If you specify an entity name beginning with the reserved prefix `sys-`, it must be the name of a system entity
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
   * The description of the entity. This string cannot contain carriage return, newline, or tab characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata related to the entity.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
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

  /**
   * Gets the values.
   *
   * An array of objects describing the entity values.
   *
   * @return the values
   */
  public List<CreateValue> values() {
    return values;
  }

  /**
   * Gets the includeAudit.
   *
   * Whether to include the audit properties (`created` and `updated` timestamps) in the response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}


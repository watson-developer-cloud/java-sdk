/*
 * (C) Copyright IBM Corp. 2017, 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** The updateEntity options. */
public class UpdateEntityOptions extends GenericModel {

  protected String workspaceId;
  protected String entity;
  protected String newEntity;
  protected String newDescription;
  protected Map<String, Object> newMetadata;
  protected Boolean newFuzzyMatch;
  protected List<CreateValue> newValues;
  protected Boolean append;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String newEntity;
    private String newDescription;
    private Map<String, Object> newMetadata;
    private Boolean newFuzzyMatch;
    private List<CreateValue> newValues;
    private Boolean append;
    private Boolean includeAudit;

    private Builder(UpdateEntityOptions updateEntityOptions) {
      this.workspaceId = updateEntityOptions.workspaceId;
      this.entity = updateEntityOptions.entity;
      this.newEntity = updateEntityOptions.newEntity;
      this.newDescription = updateEntityOptions.newDescription;
      this.newMetadata = updateEntityOptions.newMetadata;
      this.newFuzzyMatch = updateEntityOptions.newFuzzyMatch;
      this.newValues = updateEntityOptions.newValues;
      this.append = updateEntityOptions.append;
      this.includeAudit = updateEntityOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * @return the new UpdateEntityOptions instance
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
      com.ibm.cloud.sdk.core.util.Validator.notNull(value, "value cannot be null");
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
     * Set the newDescription.
     *
     * @param newDescription the newDescription
     * @return the UpdateEntityOptions builder
     */
    public Builder newDescription(String newDescription) {
      this.newDescription = newDescription;
      return this;
    }

    /**
     * Set the newMetadata.
     *
     * @param newMetadata the newMetadata
     * @return the UpdateEntityOptions builder
     */
    public Builder newMetadata(Map<String, Object> newMetadata) {
      this.newMetadata = newMetadata;
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
     * Set the newValues. Existing newValues will be replaced.
     *
     * @param newValues the newValues
     * @return the UpdateEntityOptions builder
     */
    public Builder newValues(List<CreateValue> newValues) {
      this.newValues = newValues;
      return this;
    }

    /**
     * Set the append.
     *
     * @param append the append
     * @return the UpdateEntityOptions builder
     */
    public Builder append(Boolean append) {
      this.append = append;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the UpdateEntityOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected UpdateEntityOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entity, "entity cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    newEntity = builder.newEntity;
    newDescription = builder.newDescription;
    newMetadata = builder.newMetadata;
    newFuzzyMatch = builder.newFuzzyMatch;
    newValues = builder.newValues;
    append = builder.append;
    includeAudit = builder.includeAudit;
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
   * <p>Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the entity.
   *
   * <p>The name of the entity.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the newEntity.
   *
   * <p>The name of the entity. This string must conform to the following restrictions: - It can
   * contain only Unicode alphanumeric, underscore, and hyphen characters. - It cannot begin with
   * the reserved prefix `sys-`.
   *
   * @return the newEntity
   */
  public String newEntity() {
    return newEntity;
  }

  /**
   * Gets the newDescription.
   *
   * <p>The description of the entity. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the newDescription
   */
  public String newDescription() {
    return newDescription;
  }

  /**
   * Gets the newMetadata.
   *
   * <p>Any metadata related to the entity.
   *
   * @return the newMetadata
   */
  public Map<String, Object> newMetadata() {
    return newMetadata;
  }

  /**
   * Gets the newFuzzyMatch.
   *
   * <p>Whether to use fuzzy matching for the entity.
   *
   * @return the newFuzzyMatch
   */
  public Boolean newFuzzyMatch() {
    return newFuzzyMatch;
  }

  /**
   * Gets the newValues.
   *
   * <p>An array of objects describing the entity values.
   *
   * @return the newValues
   */
  public List<CreateValue> newValues() {
    return newValues;
  }

  /**
   * Gets the append.
   *
   * <p>Whether the new data is to be appended to the existing data in the entity. If
   * **append**=`false`, elements included in the new data completely replace the corresponding
   * existing elements, including all subelements. For example, if the new data for the entity
   * includes **values** and **append**=`false`, all existing values for the entity are discarded
   * and replaced with the new values.
   *
   * <p>If **append**=`true`, existing elements are preserved, and the new elements are added. If
   * any elements in the new data collide with existing elements, the update request fails.
   *
   * @return the append
   */
  public Boolean append() {
    return append;
  }

  /**
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

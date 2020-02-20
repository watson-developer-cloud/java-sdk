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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteSynonym options.
 */
public class DeleteSynonymOptions extends GenericModel {

  protected String workspaceId;
  protected String entity;
  protected String value;
  protected String synonym;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private String synonym;

    private Builder(DeleteSynonymOptions deleteSynonymOptions) {
      this.workspaceId = deleteSynonymOptions.workspaceId;
      this.entity = deleteSynonymOptions.entity;
      this.value = deleteSynonymOptions.value;
      this.synonym = deleteSynonymOptions.synonym;
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
     * @param value the value
     * @param synonym the synonym
     */
    public Builder(String workspaceId, String entity, String value, String synonym) {
      this.workspaceId = workspaceId;
      this.entity = entity;
      this.value = value;
      this.synonym = synonym;
    }

    /**
     * Builds a DeleteSynonymOptions.
     *
     * @return the deleteSynonymOptions
     */
    public DeleteSynonymOptions build() {
      return new DeleteSynonymOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the DeleteSynonymOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the DeleteSynonymOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the DeleteSynonymOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the synonym.
     *
     * @param synonym the synonym
     * @return the DeleteSynonymOptions builder
     */
    public Builder synonym(String synonym) {
      this.synonym = synonym;
      return this;
    }
  }

  protected DeleteSynonymOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.workspaceId,
        "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entity,
        "entity cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.value,
        "value cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.synonym,
        "synonym cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    synonym = builder.synonym;
  }

  /**
   * New builder.
   *
   * @return a DeleteSynonymOptions builder
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
   * The name of the entity.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the value.
   *
   * The text of the entity value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the synonym.
   *
   * The text of the synonym.
   *
   * @return the synonym
   */
  public String synonym() {
    return synonym;
  }
}

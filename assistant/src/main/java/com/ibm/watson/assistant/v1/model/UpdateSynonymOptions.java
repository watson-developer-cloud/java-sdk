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

/** The updateSynonym options. */
public class UpdateSynonymOptions extends GenericModel {

  protected String workspaceId;
  protected String entity;
  protected String value;
  protected String synonym;
  protected String newSynonym;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private String synonym;
    private String newSynonym;
    private Boolean includeAudit;

    private Builder(UpdateSynonymOptions updateSynonymOptions) {
      this.workspaceId = updateSynonymOptions.workspaceId;
      this.entity = updateSynonymOptions.entity;
      this.value = updateSynonymOptions.value;
      this.synonym = updateSynonymOptions.synonym;
      this.newSynonym = updateSynonymOptions.newSynonym;
      this.includeAudit = updateSynonymOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * Builds a UpdateSynonymOptions.
     *
     * @return the updateSynonymOptions
     */
    public UpdateSynonymOptions build() {
      return new UpdateSynonymOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateSynonymOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the UpdateSynonymOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the UpdateSynonymOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the synonym.
     *
     * @param synonym the synonym
     * @return the UpdateSynonymOptions builder
     */
    public Builder synonym(String synonym) {
      this.synonym = synonym;
      return this;
    }

    /**
     * Set the newSynonym.
     *
     * @param newSynonym the newSynonym
     * @return the UpdateSynonymOptions builder
     */
    public Builder newSynonym(String newSynonym) {
      this.newSynonym = newSynonym;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the UpdateSynonymOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected UpdateSynonymOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entity, "entity cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.value, "value cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.synonym, "synonym cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    synonym = builder.synonym;
    newSynonym = builder.newSynonym;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a UpdateSynonymOptions builder
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
   * Gets the value.
   *
   * <p>The text of the entity value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the synonym.
   *
   * <p>The text of the synonym.
   *
   * @return the synonym
   */
  public String synonym() {
    return synonym;
  }

  /**
   * Gets the newSynonym.
   *
   * <p>The text of the synonym. This string must conform to the following restrictions: - It cannot
   * contain carriage return, newline, or tab characters. - It cannot consist of only whitespace
   * characters.
   *
   * @return the newSynonym
   */
  public String newSynonym() {
    return newSynonym;
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

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

package com.ibm.watson.assistant.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getValue options. */
public class GetValueOptions extends GenericModel {

  protected String workspaceId;
  protected String entity;
  protected String value;
  protected Boolean export;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private Boolean export;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing GetValueOptions instance.
     *
     * @param getValueOptions the instance to initialize the Builder with
     */
    private Builder(GetValueOptions getValueOptions) {
      this.workspaceId = getValueOptions.workspaceId;
      this.entity = getValueOptions.entity;
      this.value = getValueOptions.value;
      this.export = getValueOptions.export;
      this.includeAudit = getValueOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param entity the entity
     * @param value the value
     */
    public Builder(String workspaceId, String entity, String value) {
      this.workspaceId = workspaceId;
      this.entity = entity;
      this.value = value;
    }

    /**
     * Builds a GetValueOptions.
     *
     * @return the new GetValueOptions instance
     */
    public GetValueOptions build() {
      return new GetValueOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the GetValueOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the GetValueOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the GetValueOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the export.
     *
     * @param export the export
     * @return the GetValueOptions builder
     */
    public Builder export(Boolean export) {
      this.export = export;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the GetValueOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected GetValueOptions() {}

  protected GetValueOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entity, "entity cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.value, "value cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    export = builder.export;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a GetValueOptions builder
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
   * Gets the export.
   *
   * <p>Whether to include all element content in the returned data. If **export**=`false`, the
   * returned data includes only information about the element itself. If **export**=`true`, all
   * content, including subelements, is included.
   *
   * @return the export
   */
  public Boolean export() {
    return export;
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

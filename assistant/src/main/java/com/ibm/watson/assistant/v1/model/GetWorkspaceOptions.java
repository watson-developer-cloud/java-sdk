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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getWorkspace options. */
public class GetWorkspaceOptions extends GenericModel {

  /**
   * Indicates how the returned workspace data will be sorted. This parameter is valid only if
   * **export**=`true`. Specify `sort=stable` to sort all workspace objects by unique identifier, in
   * ascending alphabetical order.
   */
  public interface Sort {
    /** stable. */
    String STABLE = "stable";
  }

  protected String workspaceId;
  protected Boolean export;
  protected Boolean includeAudit;
  protected String sort;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private Boolean export;
    private Boolean includeAudit;
    private String sort;

    /**
     * Instantiates a new Builder from an existing GetWorkspaceOptions instance.
     *
     * @param getWorkspaceOptions the instance to initialize the Builder with
     */
    private Builder(GetWorkspaceOptions getWorkspaceOptions) {
      this.workspaceId = getWorkspaceOptions.workspaceId;
      this.export = getWorkspaceOptions.export;
      this.includeAudit = getWorkspaceOptions.includeAudit;
      this.sort = getWorkspaceOptions.sort;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     */
    public Builder(String workspaceId) {
      this.workspaceId = workspaceId;
    }

    /**
     * Builds a GetWorkspaceOptions.
     *
     * @return the new GetWorkspaceOptions instance
     */
    public GetWorkspaceOptions build() {
      return new GetWorkspaceOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the GetWorkspaceOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the export.
     *
     * @param export the export
     * @return the GetWorkspaceOptions builder
     */
    public Builder export(Boolean export) {
      this.export = export;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the GetWorkspaceOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the GetWorkspaceOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected GetWorkspaceOptions() {}

  protected GetWorkspaceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    export = builder.export;
    includeAudit = builder.includeAudit;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a GetWorkspaceOptions builder
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

  /**
   * Gets the sort.
   *
   * <p>Indicates how the returned workspace data will be sorted. This parameter is valid only if
   * **export**=`true`. Specify `sort=stable` to sort all workspace objects by unique identifier, in
   * ascending alphabetical order.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

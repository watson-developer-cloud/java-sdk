/*
 * (C) Copyright IBM Corp. 2022, 2023.
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

/** The exportWorkspaceAsync options. */
public class ExportWorkspaceAsyncOptions extends GenericModel {

  /**
   * Indicates how the returned workspace data will be sorted. Specify `sort=stable` to sort all
   * workspace objects by unique identifier, in ascending alphabetical order.
   */
  public interface Sort {
    /** stable. */
    String STABLE = "stable";
  }

  protected String workspaceId;
  protected Boolean includeAudit;
  protected String sort;
  protected Boolean verbose;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private Boolean includeAudit;
    private String sort;
    private Boolean verbose;

    /**
     * Instantiates a new Builder from an existing ExportWorkspaceAsyncOptions instance.
     *
     * @param exportWorkspaceAsyncOptions the instance to initialize the Builder with
     */
    private Builder(ExportWorkspaceAsyncOptions exportWorkspaceAsyncOptions) {
      this.workspaceId = exportWorkspaceAsyncOptions.workspaceId;
      this.includeAudit = exportWorkspaceAsyncOptions.includeAudit;
      this.sort = exportWorkspaceAsyncOptions.sort;
      this.verbose = exportWorkspaceAsyncOptions.verbose;
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
     * Builds a ExportWorkspaceAsyncOptions.
     *
     * @return the new ExportWorkspaceAsyncOptions instance
     */
    public ExportWorkspaceAsyncOptions build() {
      return new ExportWorkspaceAsyncOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the ExportWorkspaceAsyncOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the ExportWorkspaceAsyncOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ExportWorkspaceAsyncOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the ExportWorkspaceAsyncOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }
  }

  protected ExportWorkspaceAsyncOptions() {}

  protected ExportWorkspaceAsyncOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    includeAudit = builder.includeAudit;
    sort = builder.sort;
    verbose = builder.verbose;
  }

  /**
   * New builder.
   *
   * @return a ExportWorkspaceAsyncOptions builder
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
   * <p>Indicates how the returned workspace data will be sorted. Specify `sort=stable` to sort all
   * workspace objects by unique identifier, in ascending alphabetical order.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the verbose.
   *
   * <p>Whether the response should include the `counts` property, which indicates how many of each
   * component (such as intents and entities) the workspace contains.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }
}

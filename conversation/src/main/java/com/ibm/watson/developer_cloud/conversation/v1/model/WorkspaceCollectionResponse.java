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

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * WorkspaceCollectionResponse.
 */
public class WorkspaceCollectionResponse extends GenericModel {

  /** An array of WorkspaceResponse objects describing the workspaces associated with the service instance. */
  private List<WorkspaceResponse> workspaces;
  private PaginationResponse pagination;

  /**
   * Gets the workspaces.
   *
   * @return the workspaces
   */
  public List<WorkspaceResponse> getWorkspaces() {
    return workspaces;
  }

  /**
   * Gets the pagination.
   *
   * @return the pagination
   */
  public PaginationResponse getPagination() {
    return pagination;
  }

  /**
   * Sets the workspaces.
   *
   * @param workspaces the new workspaces
   */
  public void setWorkspaces(final List<WorkspaceResponse> workspaces) {
    this.workspaces = workspaces;
  }

  /**
   * Sets the pagination.
   *
   * @param pagination the new pagination
   */
  public void setPagination(final PaginationResponse pagination) {
    this.pagination = pagination;
  }
}

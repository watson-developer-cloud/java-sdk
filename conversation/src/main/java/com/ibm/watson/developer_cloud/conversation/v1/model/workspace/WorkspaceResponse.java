/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model.workspace;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.JsonConstants;

/**
 * The response payload from the Conversation service's workspaces API call
 * {@link ConversationService#createWorkspace(WorkspaceRequest)}.
 * {@link ConversationService#getWorkspace(String)}.
 * {@link ConversationService#updateWorkspace(String, WorkspaceRequest)} .
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html">
 *      http://www.ibm.com/ watson/developercloud/conversation.html</a>
 */
public class WorkspaceResponse extends Workspace {

  private WorkspaceStatus status;

  private Date created;

  private Date updated;

  @SerializedName(JsonConstants.WORKSPACE_ID)
  private String workspaceID;

  /**
   * @return The timestamp for creation of the workspace.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * @return The timestamp for the last update to the workspace.
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * @return the workspaceID
   */
  public String getWorkspaceID() {
    return workspaceID;
  }

  /**
   * @return The current status of the workspace
   */
  public WorkspaceStatus getStatus() {
    return status;
  }

}

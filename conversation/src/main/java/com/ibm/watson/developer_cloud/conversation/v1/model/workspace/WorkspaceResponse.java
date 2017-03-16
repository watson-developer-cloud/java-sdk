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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.JsonConstants;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The response payload from the Conversation service's workspaces API call
 * {@link ConversationService#createWorkspace(WorkspaceRequest)}.
 * {@link ConversationService#getWorkspace(String)}.
 * {@link ConversationService#updateWorkspace(String, WorkspaceRequest)}
 * .
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html">
 *      http://www.ibm.com/ watson/developercloud/conversation.html</a>
 */
public class WorkspaceResponse extends GenericModel {

    private String name;
    private String description;
    private String language;
    private Object metadata;
    private String created;
    private String updated;

    @SerializedName(JsonConstants.WORKSPACE_ID)
    private String workspaceID;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }
    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }
    /**
     * @return the metadata
     */
    public Object getMetadata() {
        return metadata;
    }
    /**
     * @param metadata the metadata to set
     */
    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }
    /**
     * @return the created
     */
    public String getCreated() {
        return created;
    }
    /**
     * @param created the created to set
     */
    public void setCreated(String created) {
        this.created = created;
    }
    /**
     * @return the updated
     */
    public String getUpdated() {
        return updated;
    }
    /**
     * @param updated the updated to set
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }
    /**
     * @return the workspaceID
     */
    public String getWorkspaceID() {
        return workspaceID;
    }
    /**
     * @param workspaceID the workspaceID to set
     */
    public void setWorkspaceID(String workspaceID) {
        this.workspaceID = workspaceID;
    }

}

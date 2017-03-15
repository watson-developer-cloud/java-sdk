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
import com.ibm.watson.developer_cloud.conversation.v1.model.JsonConstants;

public class Workspace {

    private String name;
    private String description;
    private String language;
    private Object metadata;
    private String created;
    private String updated;

    @SerializedName(JsonConstants.WORKSPACE_ID)
    private String workspaceID;

    /**
     * Instantiates a new workspace.
     *
     * @param name workspace name
     * @param description workspace description
     * @param language language
     * @param metadata metadata
     * @param created creation time-stamp
     * @param updated last update time-stamp
     * @param workspaceID workspace identifier
     */
    public Workspace(String name, String description, String language, Object metadata, String created, String updated,
            String workspaceID) {
        super();
        this.name = name;
        this.description = description;
        this.language = language;
        this.metadata = metadata;
        this.created = created;
        this.updated = updated;
        this.workspaceID = workspaceID;
    }

    /**
     * Returns the name of the workspace.
     *
     * @return the name of the workspace
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the workspace.
     *
     * @param name the name of the workspace
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the workspace's description.
     *
     * @return the workspace's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the workspace's description.
     *
     * @param description the workspace's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the workspace's language.
     *
     * @return the workspace's language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the workspace's language.
     *
     * @param language the workspace's language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Returns the workspace's metadata.
     *
     * @return the workspace's metadata
     */
    public Object getMetadata() {
        return metadata;
    }

    /**
     * Sets the workspace's metadata.
     *
     * @param metadata the workspace's metadata
     */
    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    /**
     * Returns the time stamp for the workspace creation.
     *
     * @return the time stamp for the workspace creation
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the time stamp for the workspace creation.
     *
     * @param created the time stamp for the workspace creation
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * Returns the time stamp for the intent's last update.
     *
     * @return the time stamp for the intent's last update
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Sets the time stamp for the intent's last update.
     *
     * @param updated the time stamp for the intent's last update
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * Returns the workspace ID.
     *
     * @return the workspace ID
     */
    public String getWorkspaceID() {
        return workspaceID;
    }

    /**
     * Sets the workspace ID.
     *
     * @param workspaceID the workspace ID
     */
    public void setWorkspaceID(String workspaceID) {
        this.workspaceID = workspaceID;
    }
}

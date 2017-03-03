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
 * Object that represents the workspace of a conversation workspace. This is
 * used by the
 * {@link ConversationService#createWorkspace(WorkspaceRequest)} method
 * {@link ConversationService#updateWorkspace(String, WorkspaceRequest)}
 * method
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html">
 *      http://www.ibm.com/ watson/developercloud/conversation.html</a>
 *
 */
public class WorkspaceRequest extends GenericModel {

    /**
     * The Class Builder.
     */
    public static class Builder {
        private String name;
        private String description;
        private String language;
        private Object metadata;
        private String created;
        private String updated;

        @SerializedName(JsonConstants.WORKSPACE_ID)
        private String workspaceID;

        /**
         * Instantiates a new builder.
         *
         * @param workspaceRequest the workspace request
         */
        private Builder(WorkspaceRequest workspaceRequest) {
            this.name = workspaceRequest.name;
            this.description = workspaceRequest.description;
            this.language = workspaceRequest.language;
            this.metadata = workspaceRequest.metadata;
            this.created = workspaceRequest.created;
            this.updated = workspaceRequest.updated;
            this.workspaceID = workspaceRequest.workspaceID;
        }

        /**
         * Instantiates a new Builder.
         */
        public Builder() {
        }

        /**
         * Generates a new {@link WorkspaceRequest} object. It will contain the
         * parameters set in the builder.
         *
         * @return a {@link WorkspaceRequest} instance
         */
        public WorkspaceRequest build() {
            return new WorkspaceRequest(this);
        }

        /**
         * Sets the workspace name.
         *
         * @param the workspace name
         * @return a builder object
         */
        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the description used to elaborate on the purpose and usage of a
         * given workspace.
         *
         * @param string representing the description
         * @return a builder object
         */
        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the language setting for the workspace.
         *
         * @param string representing the language
         * @return a builder object
         */
        public Builder setLanguage(final String language) {
            this.language = language;
            return this;
        }

        /**
         * Sets the metadata associated with a workspace.
         *
         * @param string representing the description
         * @return a builder object
         */
        public Builder setMetadata(Object metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Sets the time that an workspace is created.
         *
         * @param string representing a time stamp for time of creation
         * @return a builder object
         */
        public Builder setCreated(final String created) {
            this.created = created;
            return this;
        }

        /**
         * Sets the time that an workspace is created.
         *
         * @param string representing a time stamp for time of last creation
         * @return a builder object
         */
        public Builder setUpdated(final String updated) {
            this.updated = updated;
            return this;
        }

        /**
         * Sets workspace id for the workspace.
         *
         * @param string unique id for a workspace
         * @return a builder object
         */
        public Builder setWorkspaceID(final String workspaceID) {
            this.workspaceID = workspaceID;
            return this;
        }
    }

    private String name;
    private String description;
    private String language;
    private Object metadata;
    private String created;
    private String updated;

    @SerializedName(JsonConstants.WORKSPACE_ID)
    private String workspaceID;

    /**
     * Creates a new instance of the WorkspaceRequest for the
     * {@link ConversationService} service. Clients must use the {@link Builder}
     * class to construct new instances of the class.
     *
     * @param options a builder configured with the various parameters for the
     *            request
     */
    private WorkspaceRequest(Builder options) {
        name = options.name;
        description = options.description;
        language = options.language;
        metadata = options.metadata;
        created = options.created;
        updated = options.updated;
        workspaceID = options.workspaceID;
    }

    /**
     * Returns the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the language.
     *
     * @return the language
     */
    public String getLanguage() {
        return description;
    }

    /**
     * Returns the metadata associated with the workspace.
     *
     * @return the metadata
     */
    public Object getMetadata() {
        return metadata;
    }

    /**
     * Returns a time stamp for workspace creation.
     *
     * @return a time stamp for workspace creation
     */
    public String getCreated() {
        return created;
    }

    /**
     * Returns a time stamp for last update.
     *
     * @return a time stamp for last update
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Identifier of the workspace.
     *
     * @return the identifier of the workspace
     */
    public String getWorkspace() {
        return workspaceID;
    }

    /**
     * New builder.
     *
     * @return the builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }
}

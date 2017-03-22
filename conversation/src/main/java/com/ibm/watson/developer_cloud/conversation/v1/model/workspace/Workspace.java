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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class Workspace extends GenericModel{

    private String name;
    private String description;
    private String language;
    private Object metadata;

    public Workspace(){}
    /**
     * Instantiates a new workspace.
     *
     * @param name workspace name
     * @param description workspace description
     * @param language language
     * @param metadata metadata
     */
    public Workspace(String name, String description, String language, Object metadata) {
        this.name = name;
        this.description = description;
        this.language = language;
        this.metadata = metadata;
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
     * Returns the workspace's description.
     *
     * @return the workspace's description
     */
    public String getDescription() {
        return description;
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
     * Returns the workspace's metadata.
     *
     * @return the workspace's metadata
     */
    public Object getMetadata() {
        return metadata;
    }

}

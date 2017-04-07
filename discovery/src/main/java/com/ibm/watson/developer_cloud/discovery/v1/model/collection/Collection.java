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

package com.ibm.watson.developer_cloud.discovery.v1.model.collection;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.Status;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A Collection holds the documents that have been ingested and allows querying against it.
 */
public class Collection extends GenericModel {
    @SerializedName(CollectionManager.ID)
    private String collectionId;
    @SerializedName(CollectionManager.NAME)
    private String name;
    @SerializedName(CollectionManager.STATUS)
    private Status status;
    @SerializedName(CollectionManager.CREATED)
    private Date created;
    @SerializedName(CollectionManager.UPDATED)
    private Date updated;
    @SerializedName(CollectionManager.DESCRIPTION)
    private String description;
    @SerializedName(CollectionManager.CONFIGURATION_ID)
    private String configurationId;
    @SerializedName(CollectionManager.LANGUAGE)
    private String language;
    @SerializedName(CollectionManager.DOCUMENT_COUNTS)
    private DocumentCounts documentCounts;

    public String getCollectionId() {
        return collectionId;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getDescription() {
        return description;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public String getLanguage() {
        return language;
    }

    public DocumentCounts getDocumentCounts() {
        return documentCounts;
    }
}

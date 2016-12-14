/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
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

import static com.ibm.watson.developer_cloud.discovery.v1.model.collection.CollectionManager.*;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.Date;

/**
 */
public class Collection extends GenericModel {
    @SerializedName(ID)
    private String collectionId;
    @SerializedName(NAME)
    private String name;
    //TODO make this an enum
    @SerializedName(STATUS)
    private String status;
    @SerializedName(CollectionManager.CREATED)
    private Date created;
    @SerializedName(UPDATED)
    private Date updated;
    @SerializedName(CollectionManager.DESCRIPTION)
    private String description;
    @SerializedName(CONFIGURATION_ID)
    private String configurationId;
    @SerializedName(LANGUAGE)
    private String language;
    @SerializedName(DOCUMENT_COUNTS)
    private DocumentCounts documentCounts;

    public String getCollectionId() {
        return collectionId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
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

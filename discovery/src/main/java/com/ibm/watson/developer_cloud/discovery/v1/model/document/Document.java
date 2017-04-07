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

package com.ibm.watson.developer_cloud.discovery.v1.model.document;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.CommonManager;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.Notice;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryManager;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A Document contains the processing status and notices, if any, for a document in the index.
 * It does not return the document itself.
 *
 * @see QueryManager to see how to fetch the actual document content.
 */
public class Document extends GenericModel {
    @SerializedName(DocumentManager.ID)
    private String documentId;
    @SerializedName(DocumentManager.CONFIGURATION_ID)
    private String configurationId;
    @SerializedName(DocumentManager.CREATED)
    private Date created;
    @SerializedName(DocumentManager.UPDATED)
    private Date updated;
    @SerializedName(DocumentManager.STATUS)
    private Status status;
    @SerializedName(DocumentManager.STATUS_DESCRIPTION)
    private String statusDescription;
    @SerializedName(CommonManager.NOTICES)
    private List<Notice> notices;

    public String getDocumentId() {
        return documentId;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public enum Status {
        @SerializedName("available")
        AVAILABLE,
        @SerializedName("available with notices")
        AVAILABLE_WITH_NOTICES,
        @SerializedName("processing")
        PROCESSING,
        @SerializedName("failed")
        FAILED
    }
}

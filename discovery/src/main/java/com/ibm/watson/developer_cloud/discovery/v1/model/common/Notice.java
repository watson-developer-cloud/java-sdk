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

package com.ibm.watson.developer_cloud.discovery.v1.model.common;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Notice is a warning or error on a Document or Configuration deletion.
 */
public class Notice extends GenericModel {
    @SerializedName(CommonManager.NOTICE_ID)
    private String noticeId;
    //Only exists in Configuration Deletion
    @SerializedName(CommonManager.CREATED)
    private String created;
    //TODO make an enum
    @SerializedName(CommonManager.SEVERITY)
    private String severity;
    //Only exists in Document Get
    @SerializedName(CommonManager.STEP)
    private String step;
    @SerializedName(CommonManager.DESCRIPTION)
    private String description;

    public String getNoticeId() {
        return noticeId;
    }

    public String getCreated() {
        return created;
    }

    public String getSeverity() {
        return severity;
    }

    public String getStep() {
        return step;
    }

    public String getDescription() {
        return description;
    }
}

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

package com.ibm.watson.developer_cloud.discovery.v1.model.common;

import static com.ibm.watson.developer_cloud.discovery.v1.model.common.CommonManager.*;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 */
public class Notice extends GenericModel {
    @SerializedName(NOTICE_ID)
    private String noticeId;
    //Only exists in Configuration Deletion
    @SerializedName(CREATED)
    private String created;
    //TODO make an enum
    @SerializedName(SEVERITY)
    private String severity;
    //Only exists in Document Get
    @SerializedName(STEP)
    private String step;
    @SerializedName(DESCRIPTION)
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

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

package com.ibm.watson.developer_cloud.discovery.v1.model.configuration;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.CommonManager;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.Notice;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.Status;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Response from a {@link DeleteConfigurationRequest}.
 * The response contains a {@link Notice} if the configuration was referenced by at least one collection.
 */
public class DeleteConfigurationResponse extends GenericModel {
    @SerializedName(ConfigurationManager.ID)
    private String configurationId;
    @SerializedName(ConfigurationManager.STATUS)
    private Status status;
    @SerializedName(CommonManager.NOTICES)
    private List<Notice> notices;

    public String getConfigurationId() {
        return configurationId;
    }

    public Status getStatus() {
        return status;
    }

    public List<Notice> getNotices() {
        return notices;
    }
}

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

package com.ibm.watson.developer_cloud.discovery.v1.model.environment;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.Status;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Container where Collections and Configurations are stored.
 * An Environment gives information about the memory and storage space allocated
 */
public class Environment extends GenericModel {
    @SerializedName(EnvironmentManager.ID)
    private String environmentId;
    @SerializedName(EnvironmentManager.NAME)
    private String name;
    @SerializedName(EnvironmentManager.DESCRIPTION)
    private String description;
    @SerializedName(EnvironmentManager.CREATED)
    private Date created;
    @SerializedName(EnvironmentManager.UPDATED)
    private Date updated;
    @SerializedName(EnvironmentManager.STATUS)
    private Status status;
    @SerializedName(EnvironmentManager.READ_ONLY)
    private Boolean readOnly;
    @SerializedName(EnvironmentManager.INDEX_CAPACITY)
    private IndexCapacity indexCapacity;

    public String getEnvironmentId() {
        return environmentId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public Boolean isReadOnly() {
        return readOnly;
    }

    public IndexCapacity getIndexCapacity() {
        return indexCapacity;
    }
}

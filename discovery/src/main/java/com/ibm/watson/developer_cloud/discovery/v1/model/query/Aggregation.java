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

package com.ibm.watson.developer_cloud.discovery.v1.model.query;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Base class for all {@link AggregationType}s.
 */
@JsonAdapter(AggregationAdapterFactory.class)
public abstract class Aggregation extends GenericModel {
    @SerializedName(QueryManager.AGGREGATION_ID)
    private String id;
    @SerializedName(QueryManager.TYPE)
    private String type;
    @SerializedName(QueryManager.FIELD)
    private String field;
    @SerializedName(QueryManager.LOGIC)
    private Logic logic;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getField() {
        return field;
    }

    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public enum Logic {
        AND,
        OR
    }
}

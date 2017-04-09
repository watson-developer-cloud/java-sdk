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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Results contained within a Nestable Aggregation.
 *
 * @see NestableAggregation
 */
public class NestableAggregationResult extends GenericModel {
    @SerializedName(QueryManager.KEY)
    private String key;
    @SerializedName(QueryManager.MATCHING_RESULTS)
    private Long matchingResults;
    @SerializedName(QueryManager.AGGREGATIONS)
    private List<Aggregation> aggregations;

    public String getKey() {
        return key;
    }

    public Long getMatchingResults() {
        return matchingResults;
    }

    public List<Aggregation> getAggregations() {
        return aggregations;
    }
}

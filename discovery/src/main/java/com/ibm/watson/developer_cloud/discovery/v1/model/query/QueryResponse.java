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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A response containing the documents and aggregations from the QueryRequest.
 *
 * @see QueryRequest
 */
public class QueryResponse extends GenericModel {
    @SerializedName(QueryManager.MATCHING_RESULTS)
    private Long matchingResults;
    @SerializedName(QueryManager.RESULTS)
    private List<Map<String, Object>> results;
    @SerializedName(QueryManager.AGGREGATIONS)
    private List<Aggregation> aggregations;

    public QueryResponse() {
        this.matchingResults = 0L;
        this.results = new ArrayList<Map<String, Object>>();
    }

    public Long getMatchingResults() {
        return matchingResults;
    }

    public List<Map<String, Object>> getResults() {
        return results;
    }

    public List<Aggregation> getAggregations() {
        return aggregations;
    }
}

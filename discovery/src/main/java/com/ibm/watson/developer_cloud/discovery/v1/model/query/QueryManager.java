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

import com.ibm.watson.developer_cloud.http.ServiceCall;

/**
 * Interface defining the constants and methods associated with Queries.
 *
 * @see QueryRequest
 */
public interface QueryManager {
    // QueryRequest
    String FILTER = "filter";
    String QUERY = "query";
    String AGGREGATION = "aggregation";
    String COUNT = "count";
    String OFFSET = "offset";
    String RETURN = "return";

    // QueryResponse
    String MATCHING_RESULTS = "matching_results";
    String RESULTS = "results";
    String AGGREGATIONS = "aggregations";

    // Result
    String INTERNAL_ID = "_id";
    String ID = "id";
    String SCORE = "score";

    // QueryAggregation
    String AGGREGATION_ID = "id";
    String TYPE = "type";
    String FIELD = "field";
    String LOGIC = "logic";
    String COUNT_PARAM = "count";

    // NestableAggregationResult
    // includes RESULTS, MATCHING_RESULTS, AGGREGATIONS
    String KEY = "key";

    // Aggregations -> Histogram
    String INTERVAL = "interval";

    // Aggregations -> Calculation
    String VALUE = "value";

    /**
     * Executes a query.
     *
     * @param queryRequest options for the query
     * @return a {@link QueryResponse} containing the details from the {@link QueryRequest}
     */
    ServiceCall<QueryResponse> query(QueryRequest queryRequest);
}

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

/**
 * Handles aggregations that can use the {@link Operator#NEST_AGGREGATION}.
 */
public abstract class NestableAggregation extends Aggregation {
    @SerializedName(QueryManager.RESULTS)
    private List<NestableAggregationResult> results;

    public List<NestableAggregationResult> getResults() {
        return results;
    }
}

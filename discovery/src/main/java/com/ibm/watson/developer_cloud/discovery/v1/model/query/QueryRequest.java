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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A query that will retrieve back documents from the Discovery service.
 */
public class QueryRequest extends GenericModel {
    private final String environmentId;
    private final String collectionId;
    private final String filter;
    private final String query;
    private final String aggregation;
    private final Integer count;
    private final Integer offset;
    private final Iterable<String> returnFields;

    private QueryRequest(Builder builder) {
        this.environmentId = builder.environmentId;
        this.collectionId = builder.collectionId;
        this.filter = builder.filter;
        this.query = builder.query;
        this.aggregation = builder.aggregation;
        this.count = builder.count;
        this.offset = builder.offset;
        this.returnFields = builder.returnFields;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public String getFilter() {
        return filter;
    }

    public String getQuery() {
        return query;
    }

    public String getAggregation() {
        return aggregation;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getOffset() {
        return offset;
    }

    public Iterable<String> getReturnFields() {
        return returnFields;
    }

    public static class Builder {
        private final String environmentId;
        private final String collectionId;
        private String filter;
        private String query;
        private String aggregation;
        private Integer count = 10;
        private Integer offset = 0;
        private Iterable<String> returnFields;

        public Builder(String environmentId, String collectionId) {
            this.environmentId = environmentId;
            this.collectionId = collectionId;
        }

        public Builder filter(String filter) {
            this.filter = filter;
            return this;
        }

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        public Builder aggregation(String aggregation) {
            this.aggregation = aggregation;
            return this;
        }

        public Builder count(Integer count) {
            this.count = count;
            return this;
        }

        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public Builder returnFields(Iterable<String> returnFields) {
            this.returnFields = returnFields;
            return this;
        }

        public QueryRequest build() {
            return new QueryRequest(this);
        }
    }
}

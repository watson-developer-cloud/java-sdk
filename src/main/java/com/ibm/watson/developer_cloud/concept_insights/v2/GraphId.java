/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.concept_insights.v2;

/**
 * GraphId builder returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class GraphId {

    private final String GRAPHS = "graphs";

    private final String accountId;

    private final String graph;

    /**
     * Graph ID constructor
     *
     * @param accountId String the Account Id.
     * @param graph String the graph name
     */
    public GraphId(final String accountId, final String graph) {
        this.accountId = accountId;
        this.graph = graph;
     }

    /**
     * Graph ID builder
     * /graphs/{account_id}/{graph}
     *
     * @return graphId
     */
    @Override
    public String toString() {

        return new StringBuilder().append("/").append(GRAPHS).append("/").append(accountId).append("/").append(graph).toString();
    }
}

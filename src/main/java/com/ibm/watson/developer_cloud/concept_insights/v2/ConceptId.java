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
 * ConceptId builder returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ConceptId {

    private final String GRAPHS = "graphs";

    private final String CONCEPTS = "concepts";

    private final String accountId;

    private final String graph;

    private final String concept;

    /**
     * ConceptId constructor
     *
     * @param accountId String the Account Id.
     * @param graph String the graph name
     * @param concept String the concept name
     */
    public ConceptId(final String accountId, final String graph,final String concept) {
        this.accountId = accountId;
        this.graph = graph;
        this.concept = concept;
    }

    /**
     * Concept ID builder
     * /graphs/{account_id}/{graph}/concepts/{concept}
     *
     * @return conceptId
     */
    public String build() {
        return new StringBuilder().append("/").append(GRAPHS).
                   append("/").append(accountId).append("/").
                   append(graph).append("/").append(CONCEPTS).append("/").append(concept).toString();
    }

    @Override
    public String toString() {
        return String.format("ConceptId [accountId=%s, graph=%s,concept=%s ]", accountId, graph,concept);
    }

}

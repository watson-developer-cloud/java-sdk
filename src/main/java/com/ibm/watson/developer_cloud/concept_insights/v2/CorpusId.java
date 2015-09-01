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
 * CorpusId builder returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class CorpusId {

    private final String CORPORA = "corpora";

    private final String accountId;

    private final String corpus;

    /**
     * CorpusId constructor
     *
     * @param accountId String the Account Id.
     * @param corpus String the graph name
     */
    public CorpusId(final String accountId, final String corpus) {
        this.accountId = accountId;
        this.corpus = corpus;
    }

    /**
     * Corpus ID builder
     * /corpora/{account_id}/{corpus}
     *
     * @return CorpusId
     */
    public String build() {
        return new StringBuilder().append("/").append(CORPORA).append("/").
                   append(accountId).append("/").append(corpus).toString();
    }

    @Override
    public String toString() {
        return String.format("CorpusId [accountId=%s, corpus=%s ]", accountId, corpus);
    }

}

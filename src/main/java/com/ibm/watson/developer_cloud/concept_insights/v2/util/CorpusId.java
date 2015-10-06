/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package com.ibm.watson.developer_cloud.concept_insights.v2.util;

/**
 * Created by Nizar Alseddeg.
 */
public class CorpusId {

    private final String accountId;

    private final String corpus;

    /**
     * The CORPORA. (value is "corpora")
     */
    public static final String CORPORA = "corpora";

    public CorpusId(String accountId, String corpus) {
        this.accountId = accountId;
        this.corpus = corpus;
    }

    @Override
    public String toString() {
        return String.format("/%s/%s/%s", CORPORA, accountId, corpus);
    }
}

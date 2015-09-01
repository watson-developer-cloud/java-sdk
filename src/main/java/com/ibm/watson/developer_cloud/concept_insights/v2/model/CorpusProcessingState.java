
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

package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;

/**
 * DocumentProcessingState returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class CorpusProcessingState {

    private String id;

    private Integer documents;

    @SerializedName("last_updated")
    private String lastUpdated;

    @SerializedName("build_status")
    private BuildStatus buildStatus;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public CorpusProcessingState withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The documents
     */
    public Integer getDocuments() {
        return documents;
    }

    /**
     * 
     * @param documents
     *     The documents
     */
    public void setDocuments(Integer documents) {
        this.documents = documents;
    }

    public CorpusProcessingState withDocuments(Integer documents) {
        this.documents = documents;
        return this;
    }

    /**
     * 
     * @return
     *     The lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 
     * @param lastUpdated
     *     The last_updated
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public CorpusProcessingState withLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * 
     * @return
     *     The buildStatus
     */
    public BuildStatus getBuildStatus() {
        return buildStatus;
    }

    /**
     * 
     * @param buildStatus
     *     The build_status
     */
    public void setBuildStatus(BuildStatus buildStatus) {
        this.buildStatus = buildStatus;
    }

    public CorpusProcessingState withBuildStatus(BuildStatus buildStatus) {
        this.buildStatus = buildStatus;
        return this;
    }

}

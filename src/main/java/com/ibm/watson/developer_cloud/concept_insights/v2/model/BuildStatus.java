
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

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;

/**
 * BuildStatus returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */

public class BuildStatus {

    private Integer ready;

    private Integer error;

    private Integer processing;

    /**
     * @return The ready
     */
    public Integer getReady() {
        return ready;
    }

    /**
     * @param ready The ready
     */
    public void setReady(Integer ready) {
        this.ready = ready;
    }

    public BuildStatus withReady(Integer ready) {
        this.ready = ready;
        return this;
    }

    /**
     * @return The error
     */
    public Integer getError() {
        return error;
    }

    /**
     * @param error The error
     */
    public void setError(Integer error) {
        this.error = error;
    }

    public BuildStatus withError(Integer error) {
        this.error = error;
        return this;
    }

    /**
     * @return The processing
     */
    public Integer getProcessing() {
        return processing;
    }

    /**
     * @param processing The processing
     */
    public void setProcessing(Integer processing) {
        this.processing = processing;
    }

    public BuildStatus withProcessing(Integer processing) {
        this.processing = processing;
        return this;
    }

}


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

import java.util.ArrayList;
import java.util.List;

public class Result {

    @SerializedName("explanation_tags")
    private List<ExplanationTag> explanationTags = new ArrayList<ExplanationTag>();

    private String id;

    private String label;

    private Float score;

    /**
     * @return The explanationTags
     */
    public List<ExplanationTag> getExplanationTags() {
        return explanationTags;
    }

    /**
     * @param explanationTags The explanation_tags
     */
    public void setExplanationTags(List<ExplanationTag> explanationTags) {
        this.explanationTags = explanationTags;
    }

    public Result withExplanationTags(List<ExplanationTag> explanationTags) {
        this.explanationTags = explanationTags;
        return this;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Result withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public Result withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * @return The score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    public Result withScore(Float score) {
        this.score = score;
        return this;
    }

}

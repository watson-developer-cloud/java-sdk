
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


public class Annotation {


    private Concept concept;

    private Float score;

    @SerializedName("parts_index")
    private Integer partsIndex;

    @SerializedName("text_index")
    private List<Integer> textIndex = new ArrayList<Integer>();

    /**
     * 
     * @return
     *     The concept
     */
    public Concept getConcept() {
        return concept;
    }

    /**
     * 
     * @param concept
     *     The concept
     */
    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Annotation withConcept(Concept concept) {
        this.concept = concept;
        return this;
    }

    /**
     * 
     * @return
     *     The score
     */
    public Float getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    public Annotation withScore(Float score) {
        this.score = score;
        return this;
    }

    /**
     * 
     * @return
     *     The partsIndex
     */
    public Integer getPartsIndex() {
        return partsIndex;
    }

    /**
     * 
     * @param partsIndex
     *     The parts_index
     */
    public void setPartsIndex(Integer partsIndex) {
        this.partsIndex = partsIndex;
    }

    public Annotation withPartsIndex(Integer partsIndex) {
        this.partsIndex = partsIndex;
        return this;
    }

    /**
     * 
     * @return
     *     The textIndex
     */
    public List<Integer> getTextIndex() {
        return textIndex;
    }

    /**
     * 
     * @param textIndex
     *     The text_index
     */
    public void setTextIndex(List<Integer> textIndex) {
        this.textIndex = textIndex;
    }

    public Annotation withTextIndex(List<Integer> textIndex) {
        this.textIndex = textIndex;
        return this;
    }

}

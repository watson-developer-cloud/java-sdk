/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.visual_recognition.v2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Score;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.List;

/**
 * The Class RecognizedImage.
 */
public class RecognizedImage extends GenericModel {

    @Expose
    private List<Score> scores;

    /**
     * The name.
     */
    @SerializedName("image")
    private String name;

    /**
     * Gets the scores.
     *
     * @return The scores
     */
    public List<Score> getScores() {
        return scores;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the scores.
     *
     * @param scores The scores
     */
    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

}

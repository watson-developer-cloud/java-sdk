/**
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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

/**
 * Emotions returned by the {@link AlchemyLanguage} service.
 *
 */
public class Emotions extends AlchemyGenericModel {

    /** The anger value. */
    private Double anger;
    /** The disgust value. */
    private Double disgust;
    /** The fear value. */
    private Double fear;
    /** The joy value. */
    private Double joy;
    /** The sadness value. */
    private Double sadness;

    /**
     * Gets the anger.
     *
     * @return the anger
     */
    public Double getAnger() {
        return anger;
    }

    /**
     * Gets the disgust.
     *
     * @return the disgust
     */
    public Double getDisgust() {
        return disgust;
    }

    /**
     * Gets the fear.
     *
     * @return the fear
     */
    public Double getFear() {
        return fear;
    }

    /**
     * Gets the joy.
     *
     * @return the joy
     */
    public Double getJoy() {
        return joy;
    }

    /**
     * Gets the sadness.
     *
     * @return the sadness
     */
    public Double getSadness() {
        return sadness;
    }

    /**
     * Sets the mixed.
     *
     * @param anger the mixed to set
     */
    public void setAnger(Double anger) {
        this.anger = anger;
    }

    /**
     * Sets the mixed.
     *
     * @param disgust the mixed to set
     */
    public void setDisgust(Double disgust) {
        this.disgust = disgust;
    }

    /**
     * Sets the mixed.
     *
     * @param fear the mixed to set
     */
    public void setFear(Double fear) {
        this.fear = fear;
    }

    /**
     * Sets the mixed.
     *
     * @param joy the mixed to set
     */
    public void setJoy(Double joy) {
        this.joy = joy;
    }

    /**
     * Sets the mixed.
     *
     * @param sadness the mixed to set
     */
    public void setSadness(Double sadness) {
        this.sadness = sadness;
    }
}

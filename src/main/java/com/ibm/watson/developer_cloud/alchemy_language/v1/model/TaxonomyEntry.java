
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

package com.ibm.watson.developer_cloud.alchemy_language.v1.model;

import com.ibm.watson.developer_cloud.alchemy_language.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * TaxonomyEntry returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class TaxonomyEntry {

    /** The label. */
    private String label;

    /** The score. */
    private String score;

    /** The confident. */
    private String confident;

    /**
     * Gets the label.
     *
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * With label.
     *
     * @param label the label
     * @return the taxonomy entry
     */
    public TaxonomyEntry withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * Gets the score.
     *
     * @return The score
     */
    public String getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score The score
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * With score.
     *
     * @param score the score
     * @return the taxonomy entry
     */
    public TaxonomyEntry withScore(String score) {
        this.score = score;
        return this;
    }

    /**
     * Gets the confident.
     *
     * @return The confident
     */
    public String getConfident() {
        return confident;
    }

    /**
     * Sets the confident.
     *
     * @param confident The confident
     */
    public void setConfident(String confident) {
        this.confident = confident;
    }

    /**
     * With confident.
     *
     * @param confident the confident
     * @return the taxonomy entry
     */
    public TaxonomyEntry withConfident(String confident) {
        this.confident = confident;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxonomyEntry that = (TaxonomyEntry) o;

        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        return !(confident != null ? !confident.equals(that.confident) : that.confident != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = label != null ? label.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (confident != null ? confident.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}


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

/**
 * TaxonomyEntry returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class TaxonomyEntry {

    private String label;

    private String score;

    private String confident;

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

    public TaxonomyEntry withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * @return The score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    public void setScore(String score) {
        this.score = score;
    }

    public TaxonomyEntry withScore(String score) {
        this.score = score;
        return this;
    }

    /**
     * @return The confident
     */
    public String getConfident() {
        return confident;
    }

    /**
     * @param confident The confident
     */
    public void setConfident(String confident) {
        this.confident = confident;
    }

    public TaxonomyEntry withConfident(String confident) {
        this.confident = confident;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxonomyEntry that = (TaxonomyEntry) o;

        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        return !(confident != null ? !confident.equals(that.confident) : that.confident != null);

    }

    @Override
    public int hashCode() {
        int result = label != null ? label.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (confident != null ? confident.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("TaxonomyEntry [label=%s,score=%s,confident=%s]", label, score, confident);
    }
}

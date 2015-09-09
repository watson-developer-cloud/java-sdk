
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

package com.ibm.watson.developer_cloud.alchemy_news.v1.Model;

import com.ibm.watson.developer_cloud.alchemy_news.v1.AlchemyDataNews;

/**
 * Taxonomy by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Taxonomy {

    private String confident;

    private String label;

    private double score;

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

    public Taxonomy withConfident(String confident) {
        this.confident = confident;
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

    public Taxonomy withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * @return The score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    public void setScore(double score) {
        this.score = score;
    }

    public Taxonomy withScore(double score) {
        this.score = score;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Taxonomy taxonomy = (Taxonomy) o;

        if (Double.compare(taxonomy.score, score) != 0) return false;
        if (confident != null ? !confident.equals(taxonomy.confident) : taxonomy.confident != null) return false;
        return !(label != null ? !label.equals(taxonomy.label) : taxonomy.label != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = confident != null ? confident.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("Taxonomy [label=%s,score=%s,confident=%s]", label, score, confident);
    }
}

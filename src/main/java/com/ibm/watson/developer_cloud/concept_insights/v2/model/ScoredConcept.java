
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
 * Concept returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ScoredConcept {

    private Float score;

    private Concept concept;

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

    public ScoredConcept withScore(Float score) {
        this.score = score;
        return this;
    }

    /**
     * @return The concept
     */
    public Concept getConcept() {
        return concept;
    }

    /**
     * @param concept The concept
     */
    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public ScoredConcept withConcept(Concept concept) {
        this.concept = concept;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoredConcept concept1 = (ScoredConcept) o;

        if (score != null ? !score.equals(concept1.score) : concept1.score != null) return false;
        return !(concept != null ? !concept.equals(concept1.concept) : concept1.concept != null);

    }

    @Override
    public int hashCode() {
        int result = score != null ? score.hashCode() : 0;
        result = 31 * result + (concept != null ? concept.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Annotation [score=%s,concept=%s]", score, concept);
    }
}

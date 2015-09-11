
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

package com.ibm.watson.developer_cloud.alchemy_vision.v1.model;

import com.ibm.watson.developer_cloud.alchemy_vision.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Identity by the {@link AlchemyVision} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Identity {

    private Disambiguated disambiguated;

    private KnowledgeGraph knowledgeGraph;

    private String name;

    private String score;

    /**
     * @return The disambiguated
     */
    public Disambiguated getDisambiguated() {
        return disambiguated;
    }

    /**
     * @param disambiguated The disambiguated
     */
    public void setDisambiguated(Disambiguated disambiguated) {
        this.disambiguated = disambiguated;
    }

    public Identity withDisambiguated(Disambiguated disambiguated) {
        this.disambiguated = disambiguated;
        return this;
    }

    /**
     * @return The knowledgeGraph
     */
    public KnowledgeGraph getKnowledgeGraph() {
        return knowledgeGraph;
    }

    /**
     * @param knowledgeGraph The knowledgeGraph
     */
    public void setKnowledgeGraph(KnowledgeGraph knowledgeGraph) {
        this.knowledgeGraph = knowledgeGraph;
    }

    public Identity withKnowledgeGraph(KnowledgeGraph knowledgeGraph) {
        this.knowledgeGraph = knowledgeGraph;
        return this;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Identity withName(String name) {
        this.name = name;
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

    public Identity withScore(String score) {
        this.score = score;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identity identity = (Identity) o;

        if (disambiguated != null ? !disambiguated.equals(identity.disambiguated) : identity.disambiguated != null)
            return false;
        if (knowledgeGraph != null ? !knowledgeGraph.equals(identity.knowledgeGraph) : identity.knowledgeGraph != null)
            return false;
        if (name != null ? !name.equals(identity.name) : identity.name != null) return false;
        return !(score != null ? !score.equals(identity.score) : identity.score != null);

    }

    @Override
    public int hashCode() {
        int result = disambiguated != null ? disambiguated.hashCode() : 0;
        result = 31 * result + (knowledgeGraph != null ? knowledgeGraph.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}

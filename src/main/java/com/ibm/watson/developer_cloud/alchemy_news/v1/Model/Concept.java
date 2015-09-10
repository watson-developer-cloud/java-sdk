
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
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Concept returned by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Concept {

    private KnowledgeGraph knowledgeGraph;

    private double relevance;

    private String text;

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

    public Concept withKnowledgeGraph(KnowledgeGraph knowledgeGraph) {
        this.knowledgeGraph = knowledgeGraph;
        return this;
    }

    /**
     * @return The relevance
     */
    public double getRelevance() {
        return relevance;
    }

    /**
     * @param relevance The relevance
     */
    public void setRelevance(double relevance) {
        this.relevance = relevance;
    }

    public Concept withRelevance(double relevance) {
        this.relevance = relevance;
        return this;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    public Concept withText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Concept concept = (Concept) o;

        if (Double.compare(concept.relevance, relevance) != 0) return false;
        if (knowledgeGraph != null ? !knowledgeGraph.equals(concept.knowledgeGraph) : concept.knowledgeGraph != null)
            return false;
        return !(text != null ? !text.equals(concept.text) : concept.text != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = knowledgeGraph != null ? knowledgeGraph.hashCode() : 0;
        temp = Double.doubleToLongBits(relevance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}


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

import java.util.ArrayList;
import java.util.List;

/**
 * Entity returned by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Entity {

    private int count;

    private Disambiguated disambiguated;

    private KnowledgeGraph knowledgeGraph;

    private List<Object> quotations = new ArrayList<Object>();

    private double relevance;

    private Sentiment sentiment;

    private String text;

    private String type;

    /**
     * @return The count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    public Entity withCount(int count) {
        this.count = count;
        return this;
    }

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

    public Entity withDisambiguated(Disambiguated disambiguated) {
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

    public Entity withKnowledgeGraph(KnowledgeGraph knowledgeGraph) {
        this.knowledgeGraph = knowledgeGraph;
        return this;
    }

    /**
     * @return The quotations
     */
    public List<Object> getQuotations() {
        return quotations;
    }

    /**
     * @param quotations The quotations
     */
    public void setQuotations(List<Object> quotations) {
        this.quotations = quotations;
    }

    public Entity withQuotations(List<Object> quotations) {
        this.quotations = quotations;
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

    public Entity withRelevance(double relevance) {
        this.relevance = relevance;
        return this;
    }

    /**
     * @return The sentiment
     */
    public Sentiment getSentiment() {
        return sentiment;
    }

    /**
     * @param sentiment The sentiment
     */
    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    public Entity withSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
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

    public Entity withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Entity withType(String type) {
        this.type = type;
        return this;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Entity entity = (Entity) o;
//
//        if (count != entity.count) return false;
//        if (Double.compare(entity.relevance, relevance) != 0) return false;
//        if (disambiguated != null ? !disambiguated.equals(entity.disambiguated) : entity.disambiguated != null)
//            return false;
//        if (knowledgeGraph != null ? !knowledgeGraph.equals(entity.knowledgeGraph) : entity.knowledgeGraph != null)
//            return false;
//        if (quotations != null ? !quotations.equals(entity.quotations) : entity.quotations != null) return false;
//        if (sentiment != null ? !sentiment.equals(entity.sentiment) : entity.sentiment != null) return false;
//        if (text != null ? !text.equals(entity.text) : entity.text != null) return false;
//        return !(type != null ? !type.equals(entity.type) : entity.type != null);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = count;
//        result = 31 * result + (disambiguated != null ? disambiguated.hashCode() : 0);
//        result = 31 * result + (knowledgeGraph != null ? knowledgeGraph.hashCode() : 0);
//        result = 31 * result + (quotations != null ? quotations.hashCode() : 0);
//        temp = Double.doubleToLongBits(relevance);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (sentiment != null ? sentiment.hashCode() : 0);
//        result = 31 * result + (text != null ? text.hashCode() : 0);
//        result = 31 * result + (type != null ? type.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("Entity [count=%s,disambiguated=%s,knowledgeGraph=%s,quotations=%s,relevance=%s,sentiment=%s,text=%s,type=%s]", count, disambiguated, knowledgeGraph, quotations, relevance, sentiment, text, type);
//    }
}

/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.watson.developer_cloud.alchemy_language.v1.model;

import com.ibm.watson.developer_cloud.alchemy_language.v1.AlchemyLanguage;

/**
 * Entity returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Entity {


    private String type;

    private String relevance;

    private Sentiment sentiment;

    private String count;

    private String text;

    private Disambiguated disambiguated;

    /**
     *
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Entity withType(String type) {
        this.type = type;
        return this;
    }

    /**
     *
     * @return
     *     The relevance
     */
    public String getRelevance() {
        return relevance;
    }

    /**
     *
     * @param relevance
     *     The relevance
     */
    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public Entity withRelevance(String relevance) {
        this.relevance = relevance;
        return this;
    }

    /**
     *
     * @return
     *     The sentiment
     */
    public Sentiment getSentiment() {
        return sentiment;
    }

    /**
     *
     * @param sentiment
     *     The sentiment
     */
    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    public Entity withSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
        return this;
    }

    /**
     *
     * @return
     *     The count
     */
    public String getCount() {
        return count;
    }

    /**
     *
     * @param count
     *     The count
     */
    public void setCount(String count) {
        this.count = count;
    }

    public Entity withCount(String count) {
        this.count = count;
        return this;
    }

    /**
     *
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    public Entity withText(String text) {
        this.text = text;
        return this;
    }

    /**
     *
     * @return
     *     The disambiguated
     */
    public Disambiguated getDisambiguated() {
        return disambiguated;
    }

    /**
     *
     * @param disambiguated
     *     The disambiguated
     */
    public void setDisambiguated(Disambiguated disambiguated) {
        this.disambiguated = disambiguated;
    }

    public Entity withDisambiguated(Disambiguated disambiguated) {
        this.disambiguated = disambiguated;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (type != null ? !type.equals(entity.type) : entity.type != null) return false;
        if (relevance != null ? !relevance.equals(entity.relevance) : entity.relevance != null) return false;
        if (sentiment != null ? !sentiment.equals(entity.sentiment) : entity.sentiment != null) return false;
        if (count != null ? !count.equals(entity.count) : entity.count != null) return false;
        if (text != null ? !text.equals(entity.text) : entity.text != null) return false;
        return !(disambiguated != null ? !disambiguated.equals(entity.disambiguated) : entity.disambiguated != null);

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (relevance != null ? relevance.hashCode() : 0);
        result = 31 * result + (sentiment != null ? sentiment.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (disambiguated != null ? disambiguated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Entity [type=%s,relevance=%s,sentiment=%s,count=%s,text=%s]", type, relevance, sentiment, count, text);
    }
}

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
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Entity returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Entity {


    /** The type. */
    private String type;

    /** The relevance. */
    private String relevance;

    /** The sentiment. */
    private Sentiment sentiment;

    /** The count. */
    private String count;

    /** The text. */
    private String text;

    /** The disambiguated. */
    private Disambiguated disambiguated;

    /**
     * Gets the type.
     *
     * @return     The type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * With type.
     *
     * @param type the type
     * @return the entity
     */
    public Entity withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Gets the relevance.
     *
     * @return     The relevance
     */
    public String getRelevance() {
        return relevance;
    }

    /**
     * Sets the relevance.
     *
     * @param relevance     The relevance
     */
    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    /**
     * With relevance.
     *
     * @param relevance the relevance
     * @return the entity
     */
    public Entity withRelevance(String relevance) {
        this.relevance = relevance;
        return this;
    }

    /**
     * Gets the sentiment.
     *
     * @return     The sentiment
     */
    public Sentiment getSentiment() {
        return sentiment;
    }

    /**
     * Sets the sentiment.
     *
     * @param sentiment     The sentiment
     */
    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    /**
     * With sentiment.
     *
     * @param sentiment the sentiment
     * @return the entity
     */
    public Entity withSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
        return this;
    }

    /**
     * Gets the count.
     *
     * @return     The count
     */
    public String getCount() {
        return count;
    }

    /**
     * Sets the count.
     *
     * @param count     The count
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * With count.
     *
     * @param count the count
     * @return the entity
     */
    public Entity withCount(String count) {
        this.count = count;
        return this;
    }

    /**
     * Gets the text.
     *
     * @return     The text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * With text.
     *
     * @param text the text
     * @return the entity
     */
    public Entity withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets the disambiguated.
     *
     * @return     The disambiguated
     */
    public Disambiguated getDisambiguated() {
        return disambiguated;
    }

    /**
     * Sets the disambiguated.
     *
     * @param disambiguated     The disambiguated
     */
    public void setDisambiguated(Disambiguated disambiguated) {
        this.disambiguated = disambiguated;
    }

    /**
     * With disambiguated.
     *
     * @param disambiguated the disambiguated
     * @return the entity
     */
    public Entity withDisambiguated(Disambiguated disambiguated) {
        this.disambiguated = disambiguated;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}

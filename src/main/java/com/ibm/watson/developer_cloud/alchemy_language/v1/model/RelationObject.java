
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

import java.util.ArrayList;
import java.util.List;

/**
 * RelationObject returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class RelationObject {

    /** The text. */
    private String text;

    /** The sentiment. */
    private Sentiment sentiment;

    /** The keywords. */
    private List<Keyword> keywords = new ArrayList<Keyword>();

    /**
     * Gets the text.
     *
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * With text.
     *
     * @param text the text
     * @return the relation object
     */
    public RelationObject withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets the sentiment.
     *
     * @return The sentiment
     */
    public Sentiment getSentiment() {
        return sentiment;
    }

    /**
     * Sets the sentiment.
     *
     * @param sentiment The sentiment
     */
    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    /**
     * With sentiment.
     *
     * @param sentiment the sentiment
     * @return the relation object
     */
    public RelationObject withSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
        return this;
    }

    /**
     * Gets the keywords.
     *
     * @return The keywords
     */
    public List<Keyword> getKeywords() {
        return keywords;
    }

    /**
     * Sets the keywords.
     *
     * @param keywords The keywords
     */
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    /**
     * With keywords.
     *
     * @param keywords the keywords
     * @return the relation object
     */
    public RelationObject withKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelationObject that = (RelationObject) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (sentiment != null ? !sentiment.equals(that.sentiment) : that.sentiment != null) return false;
        return !(keywords != null ? !keywords.equals(that.keywords) : that.keywords != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (sentiment != null ? sentiment.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("RelationObject [text=%s,sentiment=%s]", text, sentiment);
    }
}

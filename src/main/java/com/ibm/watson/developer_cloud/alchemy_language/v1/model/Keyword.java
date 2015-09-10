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
 * Keyword returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Keyword {


    /** The relevance. */
    private String relevance;

    /** The sentiment. */
    private Sentiment sentiment;

    /** The text. */
    private String text;

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
     * @return the keyword
     */
    public Keyword withRelevance(String relevance) {
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
     * @return the keyword
     */
    public Keyword withSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
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
     * @return the keyword
     */
    public Keyword withText(String text) {
        this.text = text;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keyword keyword = (Keyword) o;

        if (relevance != null ? !relevance.equals(keyword.relevance) : keyword.relevance != null) return false;
        if (sentiment != null ? !sentiment.equals(keyword.sentiment) : keyword.sentiment != null) return false;
        return !(text != null ? !text.equals(keyword.text) : keyword.text != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = relevance != null ? relevance.hashCode() : 0;
        result = 31 * result + (sentiment != null ? sentiment.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Keyword [relevance=%s,sentiment=%s,text=%s]", relevance, sentiment, text);
    }

}

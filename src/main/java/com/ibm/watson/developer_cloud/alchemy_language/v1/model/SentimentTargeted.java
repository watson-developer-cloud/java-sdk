
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
 * SentimentTargeted returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class SentimentTargeted {


    private String text;

    private String type;

    private SentimentTargetedEntry sentiment;

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

    public SentimentTargeted withText(String text) {
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

    public SentimentTargeted withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return The sentiment
     */
    public SentimentTargetedEntry getSentiment() {
        return sentiment;
    }

    /**
     * @param sentiment The sentiment
     */
    public void setSentiment(SentimentTargetedEntry sentiment) {
        this.sentiment = sentiment;
    }

    public SentimentTargeted withSentiment(SentimentTargetedEntry sentiment) {
        this.sentiment = sentiment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SentimentTargeted that = (SentimentTargeted) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return !(sentiment != null ? !sentiment.equals(that.sentiment) : that.sentiment != null);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (sentiment != null ? sentiment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("SentimentTargeted [text=%s,type=%s,sentiment=%s]", text, type, sentiment);
    }
}

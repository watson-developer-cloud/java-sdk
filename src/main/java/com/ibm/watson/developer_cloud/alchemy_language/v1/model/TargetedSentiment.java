
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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.alchemy_language.v1.AlchemyLanguage;

import java.util.ArrayList;
import java.util.List;

/**
 * TargetedSentiment returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class TargetedSentiment {

    /** The sentiment targeted. */
    @SerializedName("sentiment_targeted")
    private List<SentimentTargeted> sentimentTargeted = new ArrayList<SentimentTargeted>();

    /**
     * Gets the sentiment targeted.
     *
     * @return The sentimentTargeted
     */
    public List<SentimentTargeted> getSentimentTargeted() {
        return sentimentTargeted;
    }

    /**
     * Sets the sentiment targeted.
     *
     * @param sentimentTargeted The sentiment_targeted
     */
    public void setSentimentTargeted(List<SentimentTargeted> sentimentTargeted) {
        this.sentimentTargeted = sentimentTargeted;
    }

    /**
     * With sentiment targeted.
     *
     * @param sentimentTargeted the sentiment targeted
     * @return the targeted sentiment
     */
    public TargetedSentiment withSentimentTargeted(List<SentimentTargeted> sentimentTargeted) {
        this.sentimentTargeted = sentimentTargeted;
        return this;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TargetedSentiment that = (TargetedSentiment) o;

        return !(sentimentTargeted != null ? !sentimentTargeted.equals(that.sentimentTargeted) : that.sentimentTargeted != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return sentimentTargeted != null ? sentimentTargeted.hashCode() : 0;
    }
}

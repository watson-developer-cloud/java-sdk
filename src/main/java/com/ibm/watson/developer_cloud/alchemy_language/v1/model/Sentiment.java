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
 * Sentiment returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Sentiment {

    /** The type. */
    private String type;

    /** The score. */
    private String score;

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
     * Gets the score.
     *
     * @return the score
     */
    public String getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score the new score
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * With type.
     *
     * @param type the type
     * @return the sentiment
     */
    public Sentiment withType(String type) {
        this.type = type;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentiment sentiment = (Sentiment) o;

        if (type != null ? !type.equals(sentiment.type) : sentiment.type != null) return false;
        return !(score != null ? !score.equals(sentiment.score) : sentiment.score != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Sentiment [type=%s,score=%s]", type, score);
    }
}

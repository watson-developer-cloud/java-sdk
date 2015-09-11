
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
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * DocSentiment returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class DocumentSentiment {

    /** The mixed. */
    private String mixed;

    /** The score. */
    private String score;

    /** The type. */
    private String type;

    /**
     * Gets the mixed.
     *
     * @return The mixed
     */
    public String getMixed() {
        return mixed;
    }

    /**
     * Sets the mixed.
     *
     * @param mixed The mixed
     */
    public void setMixed(String mixed) {
        this.mixed = mixed;
    }

    /**
     * With mixed.
     *
     * @param mixed the mixed
     * @return the doc sentiment
     */
    public DocumentSentiment withMixed(String mixed) {
        this.mixed = mixed;
        return this;
    }

    /**
     * Gets the score.
     *
     * @return The score
     */
    public String getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score The score
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * With score.
     *
     * @param score the score
     * @return the doc sentiment
     */
    public DocumentSentiment withScore(String score) {
        this.score = score;
        return this;
    }

    /**
     * Gets the type.
     *
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * With type.
     *
     * @param type the type
     * @return the doc sentiment
     */
    public DocumentSentiment withType(String type) {
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

        DocumentSentiment that = (DocumentSentiment) o;

        if (mixed != null ? !mixed.equals(that.mixed) : that.mixed != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        return !(type != null ? !type.equals(that.type) : that.type != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = mixed != null ? mixed.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
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

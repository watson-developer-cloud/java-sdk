
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
 * Subject returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Subject {

    /** The text. */
    private String text;

    /** The entities. */
    private List<Entity> entities = new ArrayList<Entity>();

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
     * @return the subject
     */
    public Subject withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets the entities.
     *
     * @return The entities
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * Sets the entities.
     *
     * @param entities The entities
     */
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    /**
     * With entities.
     *
     * @param entities the entities
     * @return the subject
     */
    public Subject withEntities(List<Entity> entities) {
        this.entities = entities;
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
     * @return the subject
     */
    public Subject withKeywords(List<Keyword> keywords) {
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

        Subject subject = (Subject) o;

        if (text != null ? !text.equals(subject.text) : subject.text != null) return false;
        if (entities != null ? !entities.equals(subject.entities) : subject.entities != null) return false;
        return !(keywords != null ? !keywords.equals(subject.keywords) : subject.keywords != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (entities != null ? entities.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Subject [text=%s]", text);
    }

}

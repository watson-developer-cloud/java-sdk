
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

    private String text;

    private List<Entity> entities = new ArrayList<Entity>();

    private List<Keyword> keywords = new ArrayList<Keyword>();

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

    public Subject withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return The entities
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * @param entities The entities
     */
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public Subject withEntities(List<Entity> entities) {
        this.entities = entities;
        return this;
    }

    /**
     * @return The keywords
     */
    public List<Keyword> getKeywords() {
        return keywords;
    }

    /**
     * @param keywords The keywords
     */
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Subject withKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (text != null ? !text.equals(subject.text) : subject.text != null) return false;
        if (entities != null ? !entities.equals(subject.entities) : subject.entities != null) return false;
        return !(keywords != null ? !keywords.equals(subject.keywords) : subject.keywords != null);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (entities != null ? entities.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Subject [text=%s]", text);
    }

}

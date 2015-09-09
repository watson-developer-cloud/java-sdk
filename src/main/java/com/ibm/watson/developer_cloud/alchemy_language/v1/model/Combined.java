
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
 * Combined returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Combined {

    private String url;

    private String totalTransactions;

    private String language;

    private List<Keyword> keywords = new ArrayList<Keyword>();

    private List<Concept> concepts = new ArrayList<Concept>();

    private List<Entity> entities = new ArrayList<Entity>();

    private List<Taxonomy> taxonomy = new ArrayList<Taxonomy>();

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public Combined withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * @return The totalTransactions
     */
    public String getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * @param totalTransactions The totalTransactions
     */
    public void setTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public Combined withTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
        return this;
    }

    /**
     * @return The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    public Combined withLanguage(String language) {
        this.language = language;
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

    public Combined withKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
        return this;
    }

    /**
     * @return The concepts
     */
    public List<Concept> getConcepts() {
        return concepts;
    }

    /**
     * @param concepts The concepts
     */
    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public Combined withConcepts(List<Concept> concepts) {
        this.concepts = concepts;
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

    public Combined withEntities(List<Entity> entities) {
        this.entities = entities;
        return this;
    }

    /**
     * @return The taxonomy
     */
    public List<Taxonomy> getTaxonomy() {
        return taxonomy;
    }

    /**
     * @param taxonomy The taxonomy
     */
    public void setTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Combined withTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combined combined = (Combined) o;

        if (url != null ? !url.equals(combined.url) : combined.url != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(combined.totalTransactions) : combined.totalTransactions != null)
            return false;
        if (language != null ? !language.equals(combined.language) : combined.language != null) return false;
        if (keywords != null ? !keywords.equals(combined.keywords) : combined.keywords != null) return false;
        if (concepts != null ? !concepts.equals(combined.concepts) : combined.concepts != null) return false;
        if (entities != null ? !entities.equals(combined.entities) : combined.entities != null) return false;
        return !(taxonomy != null ? !taxonomy.equals(combined.taxonomy) : combined.taxonomy != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (concepts != null ? concepts.hashCode() : 0);
        result = 31 * result + (entities != null ? entities.hashCode() : 0);
        result = 31 * result + (taxonomy != null ? taxonomy.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Combined [url=%s,totalTransactions=%s]", url, totalTransactions);
    }
}

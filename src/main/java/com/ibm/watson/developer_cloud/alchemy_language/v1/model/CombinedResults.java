
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

import java.util.ArrayList;
import java.util.List;

/**
 * Combined returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class CombinedResults {

    /** The url. */
    private String url;

    /** The total transactions. */
    private String totalTransactions;

    /** The language. */
    private String language;

    /** The keywords. */
    private List<Keyword> keywords = new ArrayList<Keyword>();

    /** The concepts. */
    private List<Concept> concepts = new ArrayList<Concept>();

    /** The entities. */
    private List<Entity> entities = new ArrayList<Entity>();

    /** The taxonomy. */
    private List<Taxonomy> taxonomy = new ArrayList<Taxonomy>();

    /**
     * Gets the url.
     *
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * With url.
     *
     * @param url the url
     * @return the combined
     */
    public CombinedResults withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the total transactions.
     *
     * @return The totalTransactions
     */
    public String getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * Sets the total transactions.
     *
     * @param totalTransactions The totalTransactions
     */
    public void setTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    /**
     * With total transactions.
     *
     * @param totalTransactions the total transactions
     * @return the combined
     */
    public CombinedResults withTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
        return this;
    }

    /**
     * Gets the language.
     *
     * @return The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * With language.
     *
     * @param language the language
     * @return the combined
     */
    public CombinedResults withLanguage(String language) {
        this.language = language;
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
     * @return the combined
     */
    public CombinedResults withKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
        return this;
    }

    /**
     * Gets the concepts.
     *
     * @return The concepts
     */
    public List<Concept> getConcepts() {
        return concepts;
    }

    /**
     * Sets the concepts.
     *
     * @param concepts The concepts
     */
    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    /**
     * With concepts.
     *
     * @param concepts the concepts
     * @return the combined
     */
    public CombinedResults withConcepts(List<Concept> concepts) {
        this.concepts = concepts;
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
     * @return the combined
     */
    public CombinedResults withEntities(List<Entity> entities) {
        this.entities = entities;
        return this;
    }

    /**
     * Gets the taxonomy.
     *
     * @return The taxonomy
     */
    public List<Taxonomy> getTaxonomy() {
        return taxonomy;
    }

    /**
     * Sets the taxonomy.
     *
     * @param taxonomy The taxonomy
     */
    public void setTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
    }

    /**
     * With taxonomy.
     *
     * @param taxonomy the taxonomy
     * @return the combined
     */
    public CombinedResults withTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CombinedResults combined = (CombinedResults) o;

        if (url != null ? !url.equals(combined.url) : combined.url != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(combined.totalTransactions) : combined.totalTransactions != null)
            return false;
        if (language != null ? !language.equals(combined.language) : combined.language != null) return false;
        if (keywords != null ? !keywords.equals(combined.keywords) : combined.keywords != null) return false;
        if (concepts != null ? !concepts.equals(combined.concepts) : combined.concepts != null) return false;
        if (entities != null ? !entities.equals(combined.entities) : combined.entities != null) return false;
        return !(taxonomy != null ? !taxonomy.equals(combined.taxonomy) : combined.taxonomy != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}

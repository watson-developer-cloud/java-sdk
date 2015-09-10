
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
 * Relations returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Relations {


    /** The warning message. */
    private String warningMessage;

    /** The url. */
    private String url;

    /** The total transactions. */
    private String totalTransactions;

    /** The language. */
    private String language;

    /** The relations. */
    private List<Relation> relations = new ArrayList<Relation>();


    /**
     * Gets the warning message.
     *
     * @return The warningMessage
     */
    public String getWarningMessage() {
        return warningMessage;
    }

    /**
     * Sets the warning message.
     *
     * @param warningMessage The warningMessage
     */
    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    /**
     * With warning message.
     *
     * @param warningMessage the warning message
     * @return the relations
     */
    public Relations withWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
        return this;
    }

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
     * @return the relations
     */
    public Relations withUrl(String url) {
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
     * @return the relations
     */
    public Relations withTotalTransactions(String totalTransactions) {
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
     * @return the relations
     */
    public Relations withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Gets the relations.
     *
     * @return The relations
     */
    public List<Relation> getRelations() {
        return relations;
    }

    /**
     * Sets the relations.
     *
     * @param relations The relations
     */
    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    /**
     * With relations.
     *
     * @param relations the relations
     * @return the relations
     */
    public Relations withRelations(List<Relation> relations) {
        this.relations = relations;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relations relations1 = (Relations) o;

        if (warningMessage != null ? !warningMessage.equals(relations1.warningMessage) : relations1.warningMessage != null)
            return false;
        if (url != null ? !url.equals(relations1.url) : relations1.url != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(relations1.totalTransactions) : relations1.totalTransactions != null)
            return false;
        if (language != null ? !language.equals(relations1.language) : relations1.language != null) return false;
        return !(relations != null ? !relations.equals(relations1.relations) : relations1.relations != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = warningMessage != null ? warningMessage.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (relations != null ? relations.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Relations [url=%s,totalTransactions=%s,language=%s]", url, totalTransactions, language);
    }
}

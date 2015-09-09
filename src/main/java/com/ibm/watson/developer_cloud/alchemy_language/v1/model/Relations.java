
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


    private String warningMessage;

    private String url;

    private String totalTransactions;

    private String language;

    private List<Relation> relations = new ArrayList<Relation>();


    /**
     * @return The warningMessage
     */
    public String getWarningMessage() {
        return warningMessage;
    }

    /**
     * @param warningMessage The warningMessage
     */
    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    public Relations withWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
        return this;
    }

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

    public Relations withUrl(String url) {
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

    public Relations withTotalTransactions(String totalTransactions) {
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

    public Relations withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * @return The relations
     */
    public List<Relation> getRelations() {
        return relations;
    }

    /**
     * @param relations The relations
     */
    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public Relations withRelations(List<Relation> relations) {
        this.relations = relations;
        return this;
    }

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

    @Override
    public int hashCode() {
        int result = warningMessage != null ? warningMessage.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (relations != null ? relations.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Relations [url=%s,totalTransactions=%s,language=%s]", url, totalTransactions, language);
    }
}

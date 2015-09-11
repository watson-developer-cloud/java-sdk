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
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * KeywordExtraction returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class KeywordExtraction {


    /** The status. */
    private String status;

    /** The usage. */
    private String usage;

    /** The total transactions. */
    private String totalTransactions;

    /** The language. */
    private String language;

    /** The keywords. */
    private List<Keyword> keywords = new ArrayList<Keyword>();

    /**
     * Gets the status.
     *
     * @return     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * With status.
     *
     * @param status the status
     * @return the keyword extraction
     */
    public KeywordExtraction withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Gets the usage.
     *
     * @return     The usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the usage.
     *
     * @param usage     The usage
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * With usage.
     *
     * @param usage the usage
     * @return the keyword extraction
     */
    public KeywordExtraction withUsage(String usage) {
        this.usage = usage;
        return this;
    }

    /**
     * Gets the total transactions.
     *
     * @return     The totalTransactions
     */
    public String getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * Sets the total transactions.
     *
     * @param totalTransactions     The totalTransactions
     */
    public void setTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    /**
     * With total transactions.
     *
     * @param totalTransactions the total transactions
     * @return the keyword extraction
     */
    public KeywordExtraction withTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
        return this;
    }

    /**
     * Gets the language.
     *
     * @return     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * With language.
     *
     * @param language the language
     * @return the keyword extraction
     */
    public KeywordExtraction withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Gets the keywords.
     *
     * @return     The keywords
     */
    public List<Keyword> getKeywords() {
        return keywords;
    }

    /**
     * Sets the keywords.
     *
     * @param keywords     The keywords
     */
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    /**
     * With keywords.
     *
     * @param keywords the keywords
     * @return the keyword extraction
     */
    public KeywordExtraction withKeywords(List<Keyword> keywords) {
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

        KeywordExtraction that = (KeywordExtraction) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (usage != null ? !usage.equals(that.usage) : that.usage != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(that.totalTransactions) : that.totalTransactions != null)
            return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        return !(keywords != null ? !keywords.equals(that.keywords) : that.keywords != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (usage != null ? usage.hashCode() : 0);
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
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

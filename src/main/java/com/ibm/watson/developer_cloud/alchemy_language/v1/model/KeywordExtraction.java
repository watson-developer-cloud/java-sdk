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

import java.util.ArrayList;
import java.util.List;

/**
 * KeywordExtraction returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class KeywordExtraction {


    private String status;

    private String usage;

    private String totalTransactions;

    private String language;

    private List<Keyword> keywords = new ArrayList<Keyword>();

    /**
     *
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public KeywordExtraction withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     *
     * @return
     *     The usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     *
     * @param usage
     *     The usage
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    public KeywordExtraction withUsage(String usage) {
        this.usage = usage;
        return this;
    }

    /**
     *
     * @return
     *     The totalTransactions
     */
    public String getTotalTransactions() {
        return totalTransactions;
    }

    /**
     *
     * @param totalTransactions
     *     The totalTransactions
     */
    public void setTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public KeywordExtraction withTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
        return this;
    }

    /**
     *
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    public KeywordExtraction withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     *
     * @return
     *     The keywords
     */
    public List<Keyword> getKeywords() {
        return keywords;
    }

    /**
     *
     * @param keywords
     *     The keywords
     */
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public KeywordExtraction withKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
        return this;
    }

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

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (usage != null ? usage.hashCode() : 0);
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("KeywordExtraction [status=%s,usage=%s,totalTransactions=%s,language=%s]", status, usage, totalTransactions, language);
    }
}

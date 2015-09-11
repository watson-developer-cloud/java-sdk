
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
public class DocumentSentimentResults {

    /** The url. */
    private String url;

    /** The total transactions. */
    private String totalTransactions;

    /** The language. */
    private String language;

    /** The doc sentiment. */
    private DocumentSentiment docSentiment;

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
     * @return the document sentiment
     */
    public DocumentSentimentResults withUrl(String url) {
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
     * @return the document sentiment
     */
    public DocumentSentimentResults withTotalTransactions(String totalTransactions) {
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
     * @return the document sentiment
     */
    public DocumentSentimentResults withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Gets the doc sentiment.
     *
     * @return The docSentiment
     */
    public DocumentSentiment getDocSentiment() {
        return docSentiment;
    }

    /**
     * Sets the doc sentiment.
     *
     * @param docSentiment The docSentiment
     */
    public void setDocSentiment(DocumentSentiment docSentiment) {
        this.docSentiment = docSentiment;
    }

    /**
     * With doc sentiment.
     *
     * @param docSentiment the doc sentiment
     * @return the document sentiment
     */
    public DocumentSentimentResults withDocSentiment(DocumentSentiment docSentiment) {
        this.docSentiment = docSentiment;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentSentimentResults that = (DocumentSentimentResults) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(that.totalTransactions) : that.totalTransactions != null)
            return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        return !(docSentiment != null ? !docSentiment.equals(that.docSentiment) : that.docSentiment != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (docSentiment != null ? docSentiment.hashCode() : 0);
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

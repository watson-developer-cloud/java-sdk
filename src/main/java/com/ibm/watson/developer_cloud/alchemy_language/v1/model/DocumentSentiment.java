
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

/**
 * DocSentiment returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class DocumentSentiment {

    private String url;

    private String totalTransactions;

    private String language;

    private DocSentiment docSentiment;

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

    public DocumentSentiment withUrl(String url) {
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

    public DocumentSentiment withTotalTransactions(String totalTransactions) {
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

    public DocumentSentiment withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * @return The docSentiment
     */
    public DocSentiment getDocSentiment() {
        return docSentiment;
    }

    /**
     * @param docSentiment The docSentiment
     */
    public void setDocSentiment(DocSentiment docSentiment) {
        this.docSentiment = docSentiment;
    }

    public DocumentSentiment withDocSentiment(DocSentiment docSentiment) {
        this.docSentiment = docSentiment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentSentiment that = (DocumentSentiment) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (totalTransactions != null ? !totalTransactions.equals(that.totalTransactions) : that.totalTransactions != null)
            return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        return !(docSentiment != null ? !docSentiment.equals(that.docSentiment) : that.docSentiment != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (totalTransactions != null ? totalTransactions.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (docSentiment != null ? docSentiment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("DocumentSentiment [url=%s,totalTransactions=%s,language=%s]", url, totalTransactions, language);
    }
}

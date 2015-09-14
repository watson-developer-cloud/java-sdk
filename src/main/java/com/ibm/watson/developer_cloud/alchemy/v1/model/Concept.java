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

package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Concept returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Concept extends GenericModel {

    /** The crunchbase. */
    private String crunchbase;

    /** The dbpedia. */
    private String dbpedia;

    /** The freebase. */
    private String freebase;

    /** The opencyc. */
    private String opencyc;

    /** The relevance. */
    private Double relevance;

    /** The text. */
    private String text;

    /** The website. */
    private String website;

    /** The yago. */
    private String yago;

    /**
     * Gets the crunchbase.
     *
     * @return The crunchbase
     */
    public String getCrunchbase() {
        return crunchbase;
    }

    /**
     * Gets the dbpedia.
     *
     * @return The dbpedia
     */
    public String getDbpedia() {
        return dbpedia;
    }

    /**
     * Gets the freebase.
     *
     * @return The freebase
     */
    public String getFreebase() {
        return freebase;
    }

    /**
     * Gets the opencyc.
     *
     * @return The opencyc
     */
    public String getOpencyc() {
        return opencyc;
    }

    /**
     * Gets the relevance.
     *
     * @return The relevance
     */
    public Double getRelevance() {
        return relevance;
    }

    /**
     * Gets the text.
     *
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the website.
     *
     * @return The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Gets the yago.
     *
     * @return The yago
     */
    public String getYago() {
        return yago;
    }

    /**
     * Sets the crunchbase.
     *
     * @param crunchbase The crunchbase
     */
    public void setCrunchbase(String crunchbase) {
        this.crunchbase = crunchbase;
    }

    /**
     * Sets the dbpedia.
     *
     * @param dbpedia The dbpedia
     */
    public void setDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
    }

    /**
     * Sets the freebase.
     *
     * @param freebase The freebase
     */
    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    /**
     * Sets the opencyc.
     *
     * @param opencyc The opencyc
     */
    public void setOpencyc(String opencyc) {
        this.opencyc = opencyc;
    }

    /**
     * Sets the relevance.
     *
     * @param relevance The relevance
     */
    public void setRelevance(Double relevance) {
        this.relevance = relevance;
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
     * Sets the website.
     *
     * @param website The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Sets the yago.
     *
     * @param yago The yago
     */
    public void setYago(String yago) {
        this.yago = yago;
    }
}

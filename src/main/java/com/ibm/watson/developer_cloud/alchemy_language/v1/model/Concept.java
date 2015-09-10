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

/**
 * Concept returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Concept {

    /** The text. */
    private String text;

    /** The relevance. */
    private String relevance;

    /** The website. */
    private String website;

    /** The dbpedia. */
    private String dbpedia;

    /** The freebase. */
    private String freebase;

    /** The opencyc. */
    private String opencyc;

    /** The yago. */
    private String yago;

    /** The crunchbase. */
    private String crunchbase;

    /**
     * Gets the text.
     *
     * @return The text
     */
    public String getText() {
        return text;
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
     * With text.
     *
     * @param text the text
     * @return the concept
     */
    public Concept withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets the relevance.
     *
     * @return The relevance
     */
    public String getRelevance() {
        return relevance;
    }

    /**
     * Sets the relevance.
     *
     * @param relevance The relevance
     */
    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    /**
     * With relevance.
     *
     * @param relevance the relevance
     * @return the concept
     */
    public Concept withRelevance(String relevance) {
        this.relevance = relevance;
        return this;
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
     * Sets the website.
     *
     * @param website The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * With website.
     *
     * @param website the website
     * @return the concept
     */
    public Concept withWebsite(String website) {
        this.website = website;
        return this;
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
     * Sets the dbpedia.
     *
     * @param dbpedia The dbpedia
     */
    public void setDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
    }

    /**
     * With dbpedia.
     *
     * @param dbpedia the dbpedia
     * @return the concept
     */
    public Concept withDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
        return this;
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
     * Sets the freebase.
     *
     * @param freebase The freebase
     */
    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    /**
     * With freebase.
     *
     * @param freebase the freebase
     * @return the concept
     */
    public Concept withFreebase(String freebase) {
        this.freebase = freebase;
        return this;
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
     * Sets the opencyc.
     *
     * @param opencyc The opencyc
     */
    public void setOpencyc(String opencyc) {
        this.opencyc = opencyc;
    }

    /**
     * With opencyc.
     *
     * @param opencyc the opencyc
     * @return the concept
     */
    public Concept withOpencyc(String opencyc) {
        this.opencyc = opencyc;
        return this;
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
     * Sets the yago.
     *
     * @param yago The yago
     */
    public void setYago(String yago) {
        this.yago = yago;
    }

    /**
     * With yago.
     *
     * @param yago the yago
     * @return the concept
     */
    public Concept withYago(String yago) {
        this.yago = yago;
        return this;
    }

    /**
     * Gets the crunchbase.
     *
     * @return The crunchbase
     */
    public String getCrunchbase() {
        return crunchbase;
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
     * With crunchbase.
     *
     * @param crunchbase the crunchbase
     * @return the concept
     */
    public Concept withCrunchbase(String crunchbase) {
        this.crunchbase = crunchbase;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Concept concept = (Concept) o;

        if (text != null ? !text.equals(concept.text) : concept.text != null) return false;
        if (relevance != null ? !relevance.equals(concept.relevance) : concept.relevance != null) return false;
        if (website != null ? !website.equals(concept.website) : concept.website != null) return false;
        if (dbpedia != null ? !dbpedia.equals(concept.dbpedia) : concept.dbpedia != null) return false;
        if (freebase != null ? !freebase.equals(concept.freebase) : concept.freebase != null) return false;
        if (opencyc != null ? !opencyc.equals(concept.opencyc) : concept.opencyc != null) return false;
        if (yago != null ? !yago.equals(concept.yago) : concept.yago != null) return false;
        return !(crunchbase != null ? !crunchbase.equals(concept.crunchbase) : concept.crunchbase != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (relevance != null ? relevance.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (dbpedia != null ? dbpedia.hashCode() : 0);
        result = 31 * result + (freebase != null ? freebase.hashCode() : 0);
        result = 31 * result + (opencyc != null ? opencyc.hashCode() : 0);
        result = 31 * result + (yago != null ? yago.hashCode() : 0);
        result = 31 * result + (crunchbase != null ? crunchbase.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Concept [text=%s,relevance=%s,website=%s,dbpedia=%s,freebase=%s,opencyc=%s,yago=%s,crunchbase=%s]", text, relevance, website, dbpedia, freebase, opencyc, yago, crunchbase);
    }
}

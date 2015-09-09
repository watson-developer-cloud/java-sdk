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

    private String text;

    private String relevance;

    private String website;

    private String dbpedia;

    private String freebase;

    private String opencyc;

    private String yago;

    private String crunchbase;

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    public Concept withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return The relevance
     */
    public String getRelevance() {
        return relevance;
    }

    /**
     * @param relevance The relevance
     */
    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public Concept withRelevance(String relevance) {
        this.relevance = relevance;
        return this;
    }

    /**
     * @return The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    public Concept withWebsite(String website) {
        this.website = website;
        return this;
    }

    /**
     * @return The dbpedia
     */
    public String getDbpedia() {
        return dbpedia;
    }

    /**
     * @param dbpedia The dbpedia
     */
    public void setDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
    }

    public Concept withDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
        return this;
    }

    /**
     * @return The freebase
     */
    public String getFreebase() {
        return freebase;
    }

    /**
     * @param freebase The freebase
     */
    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    public Concept withFreebase(String freebase) {
        this.freebase = freebase;
        return this;
    }

    /**
     * @return The opencyc
     */
    public String getOpencyc() {
        return opencyc;
    }

    /**
     * @param opencyc The opencyc
     */
    public void setOpencyc(String opencyc) {
        this.opencyc = opencyc;
    }

    public Concept withOpencyc(String opencyc) {
        this.opencyc = opencyc;
        return this;
    }

    /**
     * @return The yago
     */
    public String getYago() {
        return yago;
    }

    /**
     * @param yago The yago
     */
    public void setYago(String yago) {
        this.yago = yago;
    }

    public Concept withYago(String yago) {
        this.yago = yago;
        return this;
    }

    /**
     * @return The crunchbase
     */
    public String getCrunchbase() {
        return crunchbase;
    }

    /**
     * @param crunchbase The crunchbase
     */
    public void setCrunchbase(String crunchbase) {
        this.crunchbase = crunchbase;
    }

    public Concept withCrunchbase(String crunchbase) {
        this.crunchbase = crunchbase;
        return this;
    }

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

    @Override
    public String toString() {
        return String.format("Concept [text=%s,relevance=%s,website=%s,dbpedia=%s,freebase=%s,opencyc=%s,yago=%s,crunchbase=%s]", text, relevance, website, dbpedia, freebase, opencyc, yago, crunchbase);
    }
}

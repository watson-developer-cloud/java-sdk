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
 * Disambiguated returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Disambiguated {

    /** The sub type. */
    private List<String> subType = new ArrayList<String>();

    /** The name. */
    private String name;

    /** The website. */
    private String website;

    /** The dbpedia. */
    private String dbpedia;

    /** The freebase. */
    private String freebase;

    /**
     * Gets the sub type.
     *
     * @return     The subType
     */
    public List<String> getSubType() {
        return subType;
    }

    /**
     * Sets the sub type.
     *
     * @param subType     The subType
     */
    public void setSubType(List<String> subType) {
        this.subType = subType;
    }

    /**
     * With sub type.
     *
     * @param subType the sub type
     * @return the disambiguated
     */
    public Disambiguated withSubType(List<String> subType) {
        this.subType = subType;
        return this;
    }

    /**
     * Gets the name.
     *
     * @return     The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * With name.
     *
     * @param name the name
     * @return the disambiguated
     */
    public Disambiguated withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the website.
     *
     * @return     The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets the website.
     *
     * @param website     The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * With website.
     *
     * @param website the website
     * @return the disambiguated
     */
    public Disambiguated withWebsite(String website) {
        this.website = website;
        return this;
    }

    /**
     * Gets the dbpedia.
     *
     * @return     The dbpedia
     */
    public String getDbpedia() {
        return dbpedia;
    }

    /**
     * Sets the dbpedia.
     *
     * @param dbpedia     The dbpedia
     */
    public void setDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
    }

    /**
     * With dbpedia.
     *
     * @param dbpedia the dbpedia
     * @return the disambiguated
     */
    public Disambiguated withDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
        return this;
    }

    /**
     * Gets the freebase.
     *
     * @return     The freebase
     */
    public String getFreebase() {
        return freebase;
    }

    /**
     * Sets the freebase.
     *
     * @param freebase     The freebase
     */
    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    /**
     * With freebase.
     *
     * @param freebase the freebase
     * @return the disambiguated
     */
    public Disambiguated withFreebase(String freebase) {
        this.freebase = freebase;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disambiguated that = (Disambiguated) o;

        if (subType != null ? !subType.equals(that.subType) : that.subType != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (dbpedia != null ? !dbpedia.equals(that.dbpedia) : that.dbpedia != null) return false;
        return !(freebase != null ? !freebase.equals(that.freebase) : that.freebase != null);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = subType != null ? subType.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (dbpedia != null ? dbpedia.hashCode() : 0);
        result = 31 * result + (freebase != null ? freebase.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Disambiguated [name=%s,website=%s,dbpedia=%s,freebase=%s]", name, website, dbpedia, freebase);
    }
}

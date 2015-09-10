
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

package com.ibm.watson.developer_cloud.alchemy_news.v1.Model;

import com.ibm.watson.developer_cloud.alchemy_news.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Disambiguated returned by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Disambiguated {

    private List<String> subType = new ArrayList<String>();

    private String name;

    private String website;

    private String dbpedia;

    private String freebase;

    /**
     * @return The subType
     */
    public List<String> getSubType() {
        return subType;
    }

    /**
     * @param subType The subType
     */
    public void setSubType(List<String> subType) {
        this.subType = subType;
    }

    public Disambiguated withSubType(List<String> subType) {
        this.subType = subType;
        return this;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Disambiguated withName(String name) {
        this.name = name;
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

    public Disambiguated withWebsite(String website) {
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

    public Disambiguated withDbpedia(String dbpedia) {
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

    public Disambiguated withFreebase(String freebase) {
        this.freebase = freebase;
        return this;
    }

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

    @Override
    public int hashCode() {
        int result = subType != null ? subType.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (dbpedia != null ? dbpedia.hashCode() : 0);
        result = 31 * result + (freebase != null ? freebase.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}

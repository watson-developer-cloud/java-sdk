
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

package com.ibm.watson.developer_cloud.alchemy_vision.v1.model;

import com.ibm.watson.developer_cloud.alchemy_vision.v1.AlchemyVision;

import java.util.ArrayList;
import java.util.List;

/**
 * Disambiguated by the {@link AlchemyVision} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Disambiguated {


    private String dbpedia;

    private String freebase;

    private String name;

    private String opencyc;

    private List<String> subType = new ArrayList<String>();

    private String yago;

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

    public Disambiguated withOpencyc(String opencyc) {
        this.opencyc = opencyc;
        return this;
    }

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

    public Disambiguated withYago(String yago) {
        this.yago = yago;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disambiguated that = (Disambiguated) o;

        if (dbpedia != null ? !dbpedia.equals(that.dbpedia) : that.dbpedia != null) return false;
        if (freebase != null ? !freebase.equals(that.freebase) : that.freebase != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (opencyc != null ? !opencyc.equals(that.opencyc) : that.opencyc != null) return false;
        if (subType != null ? !subType.equals(that.subType) : that.subType != null) return false;
        return !(yago != null ? !yago.equals(that.yago) : that.yago != null);

    }

    @Override
    public int hashCode() {
        int result = dbpedia != null ? dbpedia.hashCode() : 0;
        result = 31 * result + (freebase != null ? freebase.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (opencyc != null ? opencyc.hashCode() : 0);
        result = 31 * result + (subType != null ? subType.hashCode() : 0);
        result = 31 * result + (yago != null ? yago.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Disambiguated [dbpedia=%s,freebase=%s,name=%s,opencyc=%s,subType=%s,yago=%s]", dbpedia, freebase, name, opencyc, subType, yago);
    }
}

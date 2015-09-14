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

import java.util.List;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Disambiguated returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Disambiguated extends GenericModel {

    /** The dbpedia. */
    private String dbpedia;

    /** The freebase. */
    private String freebase;

    /** The name. */
    private String name;

    /** The opencyc. */
    private String opencyc;

	/** The sub type. */
    private List<String> subType;

	/** The website. */
    private String website;

	/** The yago. */
    private String yago;

	/**
     * Gets the dbpedia.
     *
     * @return     The dbpedia
     */
    public String getDbpedia() {
        return dbpedia;
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
     * Gets the name.
     *
     * @return     The name
     */
    public String getName() {
        return name;
    }

    /**
	 * Gets the opencyc.
	 *
	 * @return the opencyc
	 */
	public String getOpencyc() {
		return opencyc;
	}

    /**
     * Gets the sub type.
     *
     * @return     The subType
     */
    public List<String> getSubType() {
        return subType;
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
     * Gets the yago.
     *
     * @return the yago
     */
	public String getYago() {
		return yago;
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
     * Sets the freebase.
     *
     * @param freebase     The freebase
     */
    public void setFreebase(String freebase) {
        this.freebase = freebase;
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
	 * Sets the opencyc.
	 *
	 * @param opencyc the opencyc to set
	 */
	public void setOpencyc(String opencyc) {
		this.opencyc = opencyc;
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
     * Sets the website.
     *
     * @param website     The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
	 * Sets the yago.
	 *
	 * @param yago the yago to set
	 */
	public void setYago(String yago) {
		this.yago = yago;
	}
}

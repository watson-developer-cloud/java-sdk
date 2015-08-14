/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.watson.developer_cloud.concept_expansion.v1.model;

import com.ibm.watson.developer_cloud.concept_expansion.v1.ConceptExpansion;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * This class map a Concept returned by {@link ConceptExpansion}.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class Concept {

	/** The name. */
	private String name;
	
	/** The prevalence. */
	private Double prevalence;

	/**
	 * Instantiates a new concept.
	 * 
	 * @param name
	 *            the name
	 * @param prevalence
	 *            the prevalence
	 */
	public Concept(String name, Double prevalence) {
		super();
		this.name = name;
		this.prevalence = prevalence;
	}

	/**
	 * Gets the name.
	 * 
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the prevalence.
	 * 
	 * 
	 * @return the prevalence
	 */
	public Double getPrevalence() {
		return prevalence;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ GsonSingleton.getGson().toJson(this);
	}

}

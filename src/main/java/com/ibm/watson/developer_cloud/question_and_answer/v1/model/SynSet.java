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

package com.ibm.watson.developer_cloud.question_and_answer.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class SynSet.
 */
public class SynSet {

	/** The name. */
	private String name;
	
	/** The synonym. */
	private List<Synonym> synonym = new ArrayList<Synonym>();

	/**
	 * Gets the name.
	 * 
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the synonym.
	 * 
	 * 
	 * @return The synonym
	 */
	public List<Synonym> getSynonym() {
		return synonym;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the synonym.
	 * 
	 * @param synonym
	 *            The synonym
	 */
	public void setSynonym(List<Synonym> synonym) {
		this.synonym = synonym;
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

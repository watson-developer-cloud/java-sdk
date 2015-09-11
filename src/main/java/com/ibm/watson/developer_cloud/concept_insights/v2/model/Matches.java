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

package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import java.util.List;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Matches graph returned by the {@link ConceptInsights} service.
 * 
 */
public class Matches {

	/** The matches. */
	private List<Match> matches;

	/**
	 * Gets the matches.
	 * 
	 * @return The matches
	 */
	public List<Match> getMatches() {
		return matches;
	}

	/**
	 * Sets the matches.
	 * 
	 * @param matches
	 *            The matches
	 */
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
	}

	/**
	 * With matches.
	 * 
	 * @param matches
	 *            the matches
	 * @return the matches
	 */
	public Matches withMatches(List<Match> matches) {
		this.matches = matches;
		return this;
	}
}

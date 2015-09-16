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
package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Concept returned by the {@link ConceptInsights} service.
 * 
 */
public class ScoredConcept extends GenericModel {

	/** The concept. */
	private Concept concept;

	/** The score. */
	private Double score;

	/**
	 * Gets the concept.
	 * 
	 * @return The concept
	 */
	public Concept getConcept() {
		return concept;
	}

	/**
	 * Gets the score.
	 * 
	 * @return The score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * Sets the concept.
	 * 
	 * @param concept
	 *            The concept
	 */
	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	/**
	 * Sets the score.
	 * 
	 * @param score
	 *            The score
	 */
	public void setScore(Double score) {
		this.score = score;
	}
}

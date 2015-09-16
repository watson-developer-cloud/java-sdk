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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class QueryConcepts.
 */
public class QueryConcepts extends GenericModel {

	/** The query concepts. */
	@SerializedName("query_concepts")
	private List<Concept> queryConcepts;

	/** The results. */
	private List<Result> results;

	/**
	 * Gets the query concepts.
	 * 
	 * @return The queryConcepts
	 */
	public List<Concept> getQueryConcepts() {
		return queryConcepts;
	}

	/**
	 * Gets the results.
	 * 
	 * @return The results
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * Sets the query concepts.
	 * 
	 * @param queryConcepts
	 *            The query_concepts
	 */
	public void setQueryConcepts(List<Concept> queryConcepts) {
		this.queryConcepts = queryConcepts;
	}

	/**
	 * Sets the results.
	 * 
	 * @param results
	 *            The results
	 */
	public void setResults(List<Result> results) {
		this.results = results;
	}

}

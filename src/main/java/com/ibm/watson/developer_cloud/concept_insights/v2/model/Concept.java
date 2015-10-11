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
public class Concept extends GenericModel {

	/** The id. */
	private String id;

	/** The label. */
	private String label;

	/** The concept name. */
	private String name;

	/**
	 * Instantiates a new concept.
	 */
	public Concept() {
	}

	/**
	 * Instantiates a new concept.
	 * 
	 * @param graph
	 *            the graph
	 * @param concept
	 *            the concept
	 */
	public Concept(Graph graph, String concept) {
		setName(concept);
		setId(graph.getId() + "/concepts/" + concept);
	}

	/**
	 * Instantiates a new concept.
	 * 
	 * @param accountId
	 *            the account id
	 * @param graphName
	 *            the graph name
	 * @param conceptId
	 *            the concept id
	 */
	public Concept(String accountId, String graphName, String conceptId) {
		setId(new Graph(accountId, graphName).getId() + "/concepts/" + conceptId);
	}

	/**
	 * Gets the id.
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the label.
	 * 
	 * @return The label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the label.
	 * 
	 * @param label
	 *            The label
	 */
	public void setLabel(String label) {
		this.label = label;
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
}

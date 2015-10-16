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

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validate;

/**
 * Document returned by the {@link ConceptInsights} service.
 * 
 */
public class Document extends GenericModel {

	/** The id. */
	private String id;

	/** The label. */
	private String label;

	/** The document name. */
	private String name;

	public Document() {}

	public Document(final String accountId, final String corpusName, final String document) {
		Validate.notEmpty(document, "document cannot be empty");
		setName(document);
		setId(new Corpus(accountId, corpusName).getId() + "/documents/" + document);
	}

	/**
	 * Instantiates a new document.
	 * 
	 * @param corpus
	 *            the corpus
	 * @param concept
	 *            the concept
	 */
	public Document(final Corpus corpus, final String concept) {
		Validate.notNull(corpus, "corpus cannot be null");
		Validate.notEmpty(corpus.getId(), "corpus.id cannot be empty");
		setName(concept);
		setId(corpus.getId() + "/documents/" + concept);
	}

	/** The last modified. */
	@SerializedName("last_modified")
	private Date lastModified;

	/** The parts. */
	private List<Part> parts;

	/** The user fields. */
	@SerializedName("user_fields")
	private Map<String, String> userFields;

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
	 * Gets the last modified.
	 * 
	 * @return The lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * Gets the parts.
	 * 
	 * @return The parts
	 */
	public List<Part> getParts() {
		return parts;
	}

	/**
	 * Gets the user fields.
	 * 
	 * @return the userFields
	 */
	public Map<String, String> getUserFields() {
		return userFields;
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
	 * Sets the last modified.
	 * 
	 * @param lastModified
	 *            The last_modified
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * Sets the parts.
	 * 
	 * @param parts
	 *            The parts
	 */
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/**
	 * Sets the user fields.
	 * 
	 * @param userFields
	 *            the userFields to set
	 */
	public void setUserFields(Map<String, String> userFields) {
		this.userFields = userFields;
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

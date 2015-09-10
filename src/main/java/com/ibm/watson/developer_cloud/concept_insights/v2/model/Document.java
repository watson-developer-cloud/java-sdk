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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;

/**
 * Document returned by the {@link ConceptInsights} service.
 * 
 */
public class Document {

	/** The id. */
	private String id;

	/** The label. */
	private String label;

	/** The last modified. */
	@SerializedName("last_modified")
	private String lastModified;

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
	public String getLastModified() {
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
	public void setLastModified(String lastModified) {
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
	 * With id.
	 * 
	 * @param id
	 *            the id
	 * @return the document
	 */
	public Document withId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * With label.
	 * 
	 * @param label
	 *            the label
	 * @return the document
	 */
	public Document withLabel(String label) {
		this.label = label;
		return this;
	}

	/**
	 * With last modified.
	 * 
	 * @param lastModified
	 *            the last modified
	 * @return the document
	 */
	public Document withLastModified(String lastModified) {
		this.lastModified = lastModified;
		return this;
	}

	/**
	 * With parts.
	 * 
	 * @param parts
	 *            the parts
	 * @return the document
	 */
	public Document withParts(List<Part> parts) {
		this.parts = parts;
		return this;
	}
}

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

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class Evidence.
 */
public class Evidence {

	/** The copyright. */
	private String copyright;
	
	/** The document. */
	private String document;
	
	/** The id. */
	private String id;
	
	/** The metadata map. */
	private MetadataMap metadataMap;
	
	/** The terms of use. */
	private String termsOfUse;
	
	/** The text. */
	private String text;
	
	/** The title. */
	private String title;
	
	/** The value. */
	private String value;

	/**
	 * Gets the copyright.
	 * 
	 * 
	 * @return The copyright
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * Gets the document.
	 * 
	 * 
	 * @return The document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * Gets the id.
	 * 
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the metadata map.
	 * 
	 * 
	 * @return The metadataMap
	 */
	public MetadataMap getMetadataMap() {
		return metadataMap;
	}

	/**
	 * Gets the terms of use.
	 * 
	 * 
	 * @return The termsOfUse
	 */
	public String getTermsOfUse() {
		return termsOfUse;
	}

	/**
	 * Gets the text.
	 * 
	 * 
	 * @return The text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the title.
	 * 
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the value.
	 * 
	 * 
	 * @return The value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the copyright.
	 * 
	 * @param copyright
	 *            The copyright
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * Sets the document.
	 * 
	 * @param document
	 *            The document
	 */
	public void setDocument(String document) {
		this.document = document;
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
	 * Sets the metadata map.
	 * 
	 * @param metadataMap
	 *            The metadataMap
	 */
	public void setMetadataMap(MetadataMap metadataMap) {
		this.metadataMap = metadataMap;
	}

	/**
	 * Sets the terms of use.
	 * 
	 * @param termsOfUse
	 *            The termsOfUse
	 */
	public void setTermsOfUse(String termsOfUse) {
		this.termsOfUse = termsOfUse;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            The text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            The value
	 */
	public void setValue(String value) {
		this.value = value;
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

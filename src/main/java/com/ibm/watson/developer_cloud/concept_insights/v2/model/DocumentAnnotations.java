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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class DocumentAnnotations.
 */
public class DocumentAnnotations extends GenericModel {

	/** The annotations. */
	private List<List<Annotation>> annotations;

	/** The id. */
	private String id;

	/** The label. */
	private String label;

	/**
	 * Gets the annotations.
	 * 
	 * @return The annotations
	 */
	public List<List<Annotation>> getAnnotations() {
		return annotations;
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
	 * Gets the label.
	 * 
	 * @return The label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the annotations.
	 * 
	 * @param annotations
	 *            The annotations
	 */
	public void setAnnotations(List<List<Annotation>> annotations) {
		this.annotations = annotations;
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
}

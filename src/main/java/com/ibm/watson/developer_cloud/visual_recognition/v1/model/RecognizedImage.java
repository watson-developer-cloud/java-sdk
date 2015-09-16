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

package com.ibm.watson.developer_cloud.visual_recognition.v1.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class RecognizedImage.
 */
public class RecognizedImage extends GenericModel {

	/** The id. */
	@SerializedName("image_id")
	private String id;

	/** The name. */
	@SerializedName("image_name")
	private String name;

	/** The labels. */
	@Expose
	private List<Label> labels;

	/**
	 * Gets the identifier.
	 * 
	 * @return the identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the identifier.
	 * 
	 * @param id
	 *            the new identifier
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the labels.
	 * 
	 * @return The labels
	 */
	public List<Label> getLabels() {
		return labels;
	}

	/**
	 * Sets the labels.
	 * 
	 * @param labels
	 *            The labels
	 */
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

}

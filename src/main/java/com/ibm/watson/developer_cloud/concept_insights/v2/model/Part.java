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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class Part.
 */
public class Part extends GenericModel {

	/** The content type. */
	@SerializedName("content-type")
	private String contentType;

	/** The data. */
	private String data;

	/** The name. */
	private String name;

	/**
	 * Gets the content type.
	 * 
	 * @return The contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Gets the data.
	 * 
	 * @return The data
	 */
	public String getData() {
		return data;
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
	 * Sets the content type.
	 * 
	 * @param contentType
	 *            The content-type
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * Sets the data.
	 * 
	 * @param data
	 *            The data
	 */
	public void setData(String data) {
		this.data = data;
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

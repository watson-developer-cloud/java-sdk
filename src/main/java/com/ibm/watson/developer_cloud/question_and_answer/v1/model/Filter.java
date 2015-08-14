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
 * The Class Filter.
 */
public class Filter {

	/** The filter type. */
	private String filterType;
	
	/** The filter name. */
	private String filterName;
	
	/** The values. */
	private String values;

	/**
	 * Gets the filter name.
	 * 
	 * @return The filterName
	 */
	public String getFilterName() {
		return filterName;
	}

	/**
	 * Gets the filter type.
	 * 
	 * @return The filterType
	 */
	public String getFilterType() {
		return filterType;
	}

	/**
	 * Gets the values.
	 * 
	 * @return The values
	 */
	public String getValues() {
		return values;
	}

	/**
	 * Sets the filter name.
	 * 
	 * @param filterName
	 *            The filterName
	 */
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	/**
	 * Sets the filter type.
	 * 
	 * @param filterType
	 *            The filterType
	 */
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	/**
	 * Sets the values.
	 * 
	 * @param values
	 *            The values
	 */
	public void setValues(String values) {
		this.values = values;
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

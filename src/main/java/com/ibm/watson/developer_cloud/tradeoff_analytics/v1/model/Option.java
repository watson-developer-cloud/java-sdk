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

package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class Option.
 */
public class Option extends GenericModel {

	/** The app_data. */
	@SerializedName("app_data")
	private Map<String, String> appData;

	/** The description html. */
	@SerializedName("description_html")
	private String descriptionHtml;

	/** The key. */
	private String key;

	/** The name. */
	private String name;

	/** The values. */
	private HashMap<String, Object> values;

	/**
	 * Instantiates a new option.
	 */
	public Option() {
		super();
	}

	/**
	 * Instantiates a new option.
	 * 
	 * @param key
	 *            the key
	 * @param name
	 *            the name
	 */
	public Option(String key, String name) {
		super();
		this.key = key;
		this.name = name;
	}

	/**
	 * Instantiates a new option.
	 * 
	 * @param key
	 *            the key
	 * @param name
	 *            the name
	 * @param values
	 *            the values
	 * @param descriptionHtml
	 *            the description html
	 */
	public Option(String key, String name, HashMap<String, Object> values, String descriptionHtml) {
		super();
		this.key = key;
		this.name = name;
		this.values = values;
		this.descriptionHtml = descriptionHtml;
	}

	/**
	 * Gets the description html.
	 * 
	 * @return The descriptionHtml
	 */
	public String getDescriptionHtml() {
		return descriptionHtml;
	}

	/**
	 * Gets the key.
	 * 
	 * @return The key
	 */
	public String getKey() {
		return key;
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
	 * Gets the values.
	 * 
	 * @return The values
	 */
	public HashMap<String, Object> getValues() {
		return values;
	}

	/**
	 * Sets the description html.
	 * 
	 * @param descriptionHtml
	 *            The description_html
	 */
	public void setDescriptionHtml(String descriptionHtml) {
		this.descriptionHtml = descriptionHtml;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            The key
	 */
	public void setKey(String key) {
		this.key = key;
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

	/**
	 * Sets the values.
	 * 
	 * @param values
	 *            The values
	 */
	public void setValues(HashMap<String, Object> values) {
		this.values = values;
	}

	/**
	 * With application data.
	 * 
	 * @param appData
	 *            the app data
	 * @return the option
	 */
	public Option withAppData(HashMap<String, String> appData) {
		this.appData = appData;
		return this;
	}

	/**
	 * With description html.
	 * 
	 * @param descriptionHtml
	 *            the description html
	 * @return the option
	 */
	public Option withDescriptionHtml(String descriptionHtml) {
		this.descriptionHtml = descriptionHtml;
		return this;
	}

	/**
	 * With key.
	 * 
	 * @param key
	 *            the key
	 * @return the option
	 */
	public Option withKey(String key) {
		this.key = key;
		return this;
	}

	/**
	 * With name.
	 * 
	 * @param name
	 *            the name
	 * @return the option
	 */
	public Option withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * With value.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @return the option
	 */
	public Option withValue(String name, Object value) {
		if (values == null) {
			values = new HashMap<String, Object>();
		}

		values.put(name, value);
		return this;
	}

	/**
	 * With values.
	 * 
	 * @param values
	 *            the values
	 * @return the option
	 */
	public Option withValues(HashMap<String, Object> values) {
		this.values = values;
		return this;
	}

}

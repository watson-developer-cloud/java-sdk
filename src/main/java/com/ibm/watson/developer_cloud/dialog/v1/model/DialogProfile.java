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
package com.ibm.watson.developer_cloud.dialog.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


/**
 * The Class DialogProfile.
 */
public class DialogProfile {

	@SerializedName("client_id")
	private int clientId;

	@SerializedName("name_values")
	private List<NameValue> nameValues = new ArrayList<NameValue>();

	/**
	 * Gets the client id.
	 * 
	 * @return The clientId
	 */
	public int getClientId() {
		return clientId;
	}

	/**
	 * Sets the client id.
	 * 
	 * @param clientId
	 *            The client_id
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	/**
	 * With client id.
	 * 
	 * @param clientId
	 *            the client id
	 * @return the dialog profile
	 */
	public DialogProfile withClientId(int clientId) {
		this.clientId = clientId;
		return this;
	}

	/**
	 * Gets the name values.
	 * 
	 * @return The nameValues
	 */
	public List<NameValue> getNameValues() {
		return nameValues;
	}

	/**
	 * Sets the name values.
	 * 
	 * @param nameValues
	 *            The name_values
	 */
	public void setNameValues(List<NameValue> nameValues) {
		this.nameValues = nameValues;
	}

	/**
	 * With name values.
	 * 
	 * @param nameValues
	 *            the name values
	 * @return the dialog profile
	 */
	public DialogProfile withNameValues(List<NameValue> nameValues) {
		this.nameValues = nameValues;
		return this;
	}

}
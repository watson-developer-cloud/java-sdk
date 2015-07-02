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

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.dialog.v1.DialogService;

/**
 * Dialog used by the {@link DialogService}.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class Dialog {

	/** The id. */
	@SerializedName("dialog_id")
	private String id;
	
	/** The name. */
	private String name;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the dialog id.
	 * 
	 * @param id
	 *            the new dialog id
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * With dialog id.
	 * 
	 * @param id
	 *            the id
	 * @return the dialog
	 */
	public Dialog withDialogId(final String id) {
		this.id = id;
		return this;
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
	 * Sets the name.
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * With name.
	 * 
	 * @param name
	 *            the name
	 * @return the dialog
	 */
	public Dialog withName(final String name) {
		this.name = name;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
}
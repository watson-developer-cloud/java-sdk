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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class Message.
 */
public class Message  extends GenericModel {

	/** The text. */
	private String text;
	
	/** The date time. */
	@SerializedName("date_time")
	private Date dateTime;
	
	/** The from client. */
	@SerializedName("from_client")
	private String fromClient;

	/**
	 * Gets the text.
	 * 
	 * @return The text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            The text
	 */
	public void setText(final String text) {
		this.text = text;
	}

	/**
	 * Gets the date time.
	 * 
	 * @return The dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date time.
	 * 
	 * @param dateTime
	 *            The date_time
	 */
	public void setDateTime(final Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Gets the from client.
	 * 
	 * @return The fromClient
	 */
	public String getFromClient() {
		return fromClient;
	}

	/**
	 * Sets the from client.
	 * 
	 * @param fromClient
	 *            The from_client
	 */
	public void setFromClient(final String fromClient) {
		this.fromClient = fromClient;
	}
}

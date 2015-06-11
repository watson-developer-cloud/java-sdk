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

import com.google.gson.annotations.SerializedName;

public class Message {

	private String text;
	@SerializedName("date_time")
	private String dateTime;
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
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * With text.
	 * 
	 * @param text
	 *            the text
	 * @return the message
	 */
	public Message withText(String text) {
		this.text = text;
		return this;
	}

	/**
	 * Gets the date time.
	 * 
	 * @return The dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date time.
	 * 
	 * @param dateTime
	 *            The date_time
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * With date time.
	 * 
	 * @param dateTime
	 *            the date time
	 * @return the message
	 */
	public Message withDateTime(String dateTime) {
		this.dateTime = dateTime;
		return this;
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
	public void setFromClient(String fromClient) {
		this.fromClient = fromClient;
	}

	/**
	 * With from client.
	 * 
	 * @param fromClient
	 *            the from client
	 * @return the message
	 */
	public Message withFromClient(String fromClient) {
		this.fromClient = fromClient;
		return this;
	}

}

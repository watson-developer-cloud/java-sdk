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

/**
 * The Class Message.
 */
public class Message {

	/** The text. */
	private String text;
	
	/** The date time. */
	@SerializedName("date_time")
	private String dateTime;
	
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
	 * With text.
	 * 
	 * @param text
	 *            the text
	 * @return the message
	 */
	public Message withText(final String text) {
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
	public void setDateTime(final String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * With date time.
	 * 
	 * @param dateTime
	 *            the date time
	 * @return the message
	 */
	public Message withDateTime(final String dateTime) {
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
	public void setFromClient(final String fromClient) {
		this.fromClient = fromClient;
	}

	/**
	 * With from client.
	 * 
	 * @param fromClient
	 *            the from client
	 * @return the message
	 */
	public Message withFromClient(final String fromClient) {
		this.fromClient = fromClient;
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

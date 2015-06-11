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

public class Conversation {

	private List<String> response = new ArrayList<String>();
	private String input;

	@SerializedName("conversation_id")
	private int conversationId;
	private int confidence;

	@SerializedName("client_id")
	private int clientId;

	/**
	 * Gets the response.
	 * 
	 * @return The response
	 */
	public List<String> getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 * 
	 * @param response
	 *            The response
	 */
	public void setResponse(List<String> response) {
		this.response = response;
	}

	/**
	 * With response.
	 * 
	 * @param response
	 *            the response
	 * @return the conversation
	 */
	public Conversation withResponse(List<String> response) {
		this.response = response;
		return this;
	}

	/**
	 * Gets the input.
	 * 
	 * @return The input
	 */
	public String getInput() {
		return input;
	}

	/**
	 * Sets the input.
	 * 
	 * @param input
	 *            The input
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * With input.
	 * 
	 * @param input
	 *            the input
	 * @return the conversation
	 */
	public Conversation withInput(String input) {
		this.input = input;
		return this;
	}

	/**
	 * Gets the conversation id.
	 * 
	 * @return The conversationId
	 */
	public int getConversationId() {
		return conversationId;
	}

	/**
	 * Sets the conversation id.
	 * 
	 * @param conversationId
	 *            The conversation_id
	 */
	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}

	/**
	 * With conversation id.
	 * 
	 * @param conversationId
	 *            the conversation id
	 * @return the conversation
	 */
	public Conversation withConversationId(int conversationId) {
		this.conversationId = conversationId;
		return this;
	}

	/**
	 * Gets the confidence.
	 * 
	 * @return The confidence
	 */
	public int getConfidence() {
		return confidence;
	}

	/**
	 * Sets the confidence.
	 * 
	 * @param confidence
	 *            The confidence
	 */
	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	/**
	 * With confidence.
	 * 
	 * @param confidence
	 *            the confidence
	 * @return the conversation
	 */
	public Conversation withConfidence(int confidence) {
		this.confidence = confidence;
		return this;
	}

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
	 * @return the conversation
	 */
	public Conversation withClientId(int clientId) {
		this.clientId = clientId;
		return this;
	}
}

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

public class Session {

	@SerializedName("hit_nodes")
	private List<HitNode> hitNodes = new ArrayList<HitNode>();
	@SerializedName("Session_id")
	private int SessionId;
	@SerializedName("client_id")

	private int clientId;
	private List<Message> messages = new ArrayList<Message>();
	private List<NameValue> profile = new ArrayList<NameValue>();

	/**
	 * Gets the hit nodes.
	 * 
	 * @return The hitNodes
	 */
	public List<HitNode> getHitNodes() {
		return hitNodes;
	}

	/**
	 * Sets the hit nodes.
	 * 
	 * @param hitNodes
	 *            The hit_nodes
	 */
	public void setHitNodes(List<HitNode> hitNodes) {
		this.hitNodes = hitNodes;
	}

	/**
	 * With hit nodes.
	 * 
	 * @param hitNodes
	 *            the hit nodes
	 * @return the Session
	 */
	public Session withHitNodes(List<HitNode> hitNodes) {
		this.hitNodes = hitNodes;
		return this;
	}

	/**
	 * Gets the Session id.
	 * 
	 * @return The SessionId
	 */
	public int getSessionId() {
		return SessionId;
	}

	/**
	 * Sets the Session id.
	 * 
	 * @param SessionId
	 *            The Session_id
	 */
	public void setSessionId(int SessionId) {
		this.SessionId = SessionId;
	}

	/**
	 * With Session id.
	 * 
	 * @param SessionId
	 *            the Session id
	 * @return the Session
	 */
	public Session withSessionId(int SessionId) {
		this.SessionId = SessionId;
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
	 * @return the Session
	 */
	public Session withClientId(int clientId) {
		this.clientId = clientId;
		return this;
	}

	/**
	 * Gets the messages.
	 * 
	 * @return The messages
	 */
	public List<Message> getMessages() {
		return messages;
	}

	/**
	 * Sets the messages.
	 * 
	 * @param messages
	 *            The messages
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	/**
	 * With messages.
	 * 
	 * @param messages
	 *            the messages
	 * @return the Session
	 */
	public Session withMessages(List<Message> messages) {
		this.messages = messages;
		return this;
	}

	/**
	 * Gets the profile.
	 * 
	 * @return The profile
	 */
	public List<NameValue> getProfile() {
		return profile;
	}

	/**
	 * Sets the profile.
	 * 
	 * @param profile
	 *            The profile
	 */
	public void setProfile(List<NameValue> profile) {
		this.profile = profile;
	}

	/**
	 * With profile.
	 * 
	 * @param profile
	 *            the profile
	 * @return the Session
	 */
	public Session withProfile(List<NameValue> profile) {
		this.profile = profile;
		return this;
	}

}

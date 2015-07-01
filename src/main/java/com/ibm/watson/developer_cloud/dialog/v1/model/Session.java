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

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * The Class Session.
 */
public class Session {

	/** The hit nodes. */
	@SerializedName("hit_nodes")
	private List<HitNode> hitNodes = new ArrayList<HitNode>();
	
	/** The conversation id. */
	@SerializedName("conversation_id")
	private int conversationId;
	
	/** The client id. */
	@SerializedName("client_id")
	private int clientId;
	
	/** The messages. */
	private List<Message> messages = new ArrayList<Message>();
	
	/** The profile. */
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
	public void setHitNodes(final List<HitNode> hitNodes) {
		this.hitNodes = hitNodes;
	}

	/**
	 * With hit nodes.
	 * 
	 * @param hitNodes
	 *            the hit nodes
	 * @return the Session
	 */
	public Session withHitNodes(final List<HitNode> hitNodes) {
		this.hitNodes = hitNodes;
		return this;
	}

	/**
	 * Gets the Session id.
	 * 
	 * @return The SessionId
	 */
	public int getSessionId() {
		return conversationId;
	}

	/**
	 * Sets the Session id.
	 * 
	 * @param SessionId
	 *            The Session_id
	 */
	public void setSessionId(final int SessionId) {
		this.conversationId = SessionId;
	}

	/**
	 * With Session id.
	 * 
	 * @param SessionId
	 *            the Session id
	 * @return the Session
	 */
	public Session withSessionId(final int SessionId) {
		this.conversationId = SessionId;
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
	public void setClientId(final int clientId) {
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
	public void setMessages(final List<Message> messages) {
		this.messages = messages;
	}

	/**
	 * With messages.
	 * 
	 * @param messages
	 *            the messages
	 * @return the Session
	 */
	public Session withMessages(final List<Message> messages) {
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
	public void setProfile(final List<NameValue> profile) {
		this.profile = profile;
	}

	/**
	 * With profile.
	 * 
	 * @param profile
	 *            the profile
	 * @return the Session
	 */
	public Session withProfile(final List<NameValue> profile) {
		this.profile = profile;
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

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
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Conversation data stores information about a conversation.
 */
public class ConversationData {

	/** The hit nodes. */
	@SerializedName("hit_nodes")
	private List<HitNode> hitNodes = new ArrayList<HitNode>();
	
	/** The conversation id. */
	@SerializedName("conversation_id")
	private Integer conversationId;
	
	/** The client id. */
	@SerializedName("client_id")
	private Integer clientId;
	
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
	 * Gets the conversation id.
	 *
	 * @return the conversation id
	 */
	public Integer getConversationId() {
		return conversationId;
	}

	/**
	 * Sets the conversation id.
	 *
	 * @param conversationId the new conversation id
	 */
	public void setConversationId(Integer conversationId) {
		this.conversationId = conversationId;
	}

	/**
	 * Sets the client id.
	 *
	 * @param clientId the new client id
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
	 * @return The {@link ConversationData}
	 */
	public ConversationData withHitNodes(final List<HitNode> hitNodes) {
		this.hitNodes = hitNodes;
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
	 * @return the {@link ConversationData}
	 */
	public ConversationData withClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}

	/**
	 * Gets the messages.
	 * 
	 * @return A list of {@link Message}
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
	 * @return the {@link ConversationData }
	 */
	public ConversationData withMessages(final List<Message> messages) {
		this.messages = messages;
		return this;
	}

	/**
	 * Gets the profile.
	 * 
	 * @return A list of  {@link NameValue } pars
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
	 * @return the {@link ConversationData }
	 */
	public ConversationData withProfile(final List<NameValue> profile) {
		this.profile = profile;
		return this;
	}

	/**
	 * With conversationId.
	 * 
	 * @param conversationId
	 *            the conversation identifier
	 * @return the {@link ConversationData }
	 */
	public ConversationData withConversationId(final Integer conversationId) {
		this.conversationId = conversationId;
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
				+ GsonSingleton.getGson().toJson(this);
	}
}

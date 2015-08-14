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
package com.ibm.watson.developer_cloud.message_resonance.v1.model;

import com.ibm.watson.developer_cloud.message_resonance.v1.MessageResonance;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Dataset used by the {@link MessageResonance} service.
 */
public class MessageResonanceDataset {

	/** The Constant CLOUD. */
	public static final MessageResonanceDataset CLOUD = new MessageResonanceDataset("Cloud Computing", 1);
	
	/** The Constant BIG_DATA. */
	public static final MessageResonanceDataset BIG_DATA = new MessageResonanceDataset("Big Data & Analytics", 2);

	/** The id. */
	private final int id;
	
	/** The name. */
	private final String name;

	/**
	 * Instantiates a new dataset.
	 * 
	 * @param name
	 *            String
	 * @param id
	 *            the id
	 */
	public MessageResonanceDataset(final String name,final int id) {
		this.name = name;
		this.id = id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the id.
	 * 
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
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
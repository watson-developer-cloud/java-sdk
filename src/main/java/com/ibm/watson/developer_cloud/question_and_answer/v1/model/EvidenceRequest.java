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

package com.ibm.watson.developer_cloud.question_and_answer.v1.model;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class EvidenceRequest.
 */
public class EvidenceRequest {

	/** The items. */
	private int items;
	
	/** The profile. */
	private String profile;

	/**
	 * Gets the items.
	 * 
	 * 
	 * @return The items
	 */
	public int getItems() {
		return items;
	}

	/**
	 * Gets the profile.
	 * 
	 * 
	 * @return The profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * Sets the items.
	 * 
	 * @param items
	 *            The items
	 */
	public void setItems(int items) {
		this.items = items;
	}

	/**
	 * Sets the profile.
	 * 
	 * @param profile
	 *            The profile
	 */
	public void setProfile(String profile) {
		this.profile = profile;
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

	/**
	 * With items.
	 * 
	 * @param items
	 *            the items
	 * 
	 * @return the evidence request
	 */
	public EvidenceRequest withItems(int items) {
		this.items = items;
		return this;
	}

	/**
	 * With profile.
	 * 
	 * @param profile
	 *            the profile
	 * 
	 * @return the evidence request
	 */
	public EvidenceRequest withProfile(String profile) {
		this.profile = profile;
		return this;
	}

}

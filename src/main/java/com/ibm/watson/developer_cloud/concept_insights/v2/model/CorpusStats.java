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
package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class CorpusStats.
 */
public class CorpusStats extends GenericModel {

	/** The id. */
	private String id;

	/** The last updated. */
	@SerializedName("last_updated")
	private Date lastUpdated;

	/** The top tags. */
	@SerializedName("top_tags")
	private TopTags topTags;

	/**
	 * Gets the id.
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the last updated.
	 * 
	 * @return The lastUpdated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Gets the top tags.
	 * 
	 * @return The topTags
	 */
	public TopTags getTopTags() {
		return topTags;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the last updated.
	 * 
	 * @param lastUpdated
	 *            The last_updated
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * Sets the top tags.
	 * 
	 * @param topTags
	 *            The top_tags
	 */
	public void setTopTags(TopTags topTags) {
		this.topTags = topTags;
	}
}

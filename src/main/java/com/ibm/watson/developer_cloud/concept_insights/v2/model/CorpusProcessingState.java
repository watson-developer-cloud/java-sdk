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
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DocumentProcessingState returned by the {@link ConceptInsights} service.
 * 
 */
public class CorpusProcessingState extends GenericModel {

	/** The build status. */
	@SerializedName("build_status")
	private BuildStatus buildStatus;

	/** The documents. */
	private Integer documents;

	/** The id. */
	private String id;

	/** The last updated. */
	@SerializedName("last_updated")
	private Date lastUpdated;

	/**
	 * Gets the builds the status.
	 * 
	 * @return The buildStatus
	 */
	public BuildStatus getBuildStatus() {
		return buildStatus;
	}

	/**
	 * Gets the documents.
	 * 
	 * @return The documents
	 */
	public Integer getDocuments() {
		return documents;
	}

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
	 * Sets the builds the status.
	 * 
	 * @param buildStatus
	 *            The build_status
	 */
	public void setBuildStatus(BuildStatus buildStatus) {
		this.buildStatus = buildStatus;
	}

	/**
	 * Sets the documents.
	 * 
	 * @param documents
	 *            The documents
	 */
	public void setDocuments(Integer documents) {
		this.documents = documents;
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
}

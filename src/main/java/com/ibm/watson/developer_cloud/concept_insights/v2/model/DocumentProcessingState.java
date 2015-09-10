/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class DocumentProcessingState.
 */
public class DocumentProcessingState {

	/** The last modified. */
	@SerializedName("last_modified")
	private String lastModified;

	/** The status. */
	private String status;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DocumentProcessingState that = (DocumentProcessingState) o;

		if (status != null ? !status.equals(that.status) : that.status != null)
			return false;
		return !(lastModified != null ? !lastModified.equals(that.lastModified) : that.lastModified != null);

	}

	/**
	 * Gets the last modified.
	 * 
	 * @return The lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}

	/**
	 * Gets the status.
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = status != null ? status.hashCode() : 0;
		result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
		return result;
	}

	/**
	 * Sets the last modified.
	 * 
	 * @param lastModified
	 *            The last_modified
	 */
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
	}

	/**
	 * With last modified.
	 * 
	 * @param lastModified
	 *            the last modified
	 * @return the document processing state
	 */
	public DocumentProcessingState withLastModified(String lastModified) {
		this.lastModified = lastModified;
		return this;
	}

	/**
	 * With status.
	 * 
	 * @param status
	 *            the status
	 * @return the document processing state
	 */
	public DocumentProcessingState withStatus(String status) {
		this.status = status;
		return this;
	}
}

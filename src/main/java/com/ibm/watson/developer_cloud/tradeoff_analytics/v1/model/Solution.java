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

package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class Solution.
 */
public class Solution extends GenericModel {

	/** The solution ref. */
	@SerializedName("solution_ref")
	private String solutionRef;

	/** The status. */
	private String status;

	/** The status cause. */
	@SerializedName("status_cause")
	private StatusCause statusCause;

	/**
	 * Gets the solution ref.
	 * 
	 * @return The solutionRef
	 */
	public String getSolutionRef() {
		return solutionRef;
	}

	/**
	 * Gets the status.
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the solution ref.
	 * 
	 * @param solutionRef
	 *            The solution_ref
	 */
	public void setSolutionRef(String solutionRef) {
		this.solutionRef = solutionRef;
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

}

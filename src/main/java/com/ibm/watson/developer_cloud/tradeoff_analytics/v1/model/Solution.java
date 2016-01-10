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

import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;



/**
 * The Class Solution.
 */
public class Solution {

	private String status;
	@SerializedName("solution_ref")
	private String solutionRef;
	@SerializedName("status_cause")
	private String statusCause;
	
	private List<String> shadows;

	@SerializedName("shadow_me")
	private List<String> shadowMe;
	
	
	/**
	 * Gets the shadows of a solution.
	 * 
	 * @return The shadows
	 */
	public List<String> getShadows() {
		return shadows;
	}

	/**
	 * 
	 * @param shadows
	 *     The shadows
	 */
	public void setShadows(List<String> shadows) {
		this.shadows = shadows;
	}

	/**
	 * With shadows.
	 * 
	 * @param shadows
	 *            the shadows
	 * @return the solution
	 */
	public Solution withShadows(List<String> shadows) {
		this.shadows = shadows;
		return this;
	}
	
	/**
	 * 
	 * @param shadowMe
	 *     The highlights
	 */
	public void setShadowMe(List<String> shadowMe) {
		this.shadowMe = shadowMe;
	}

	/**
	 * Gets the solution ids of those that shadow this solution.
	 * 
	 * @return The highlights
	 */
	public List<String> getShadowMe() {
		return shadowMe;
	}
	
	/**
	 * With shadowME.
	 * 
	 * @param shadowMe
	 *            the highlights
	 * @return the solution
	 */
	public Solution withShadowMe(List<String> shadowMe) {
		this.shadowMe = shadowMe;
		return this;
	}
	
	
	/**
	 * Gets the status cause.
	 * 
	 * @return The status cause
	 */
	public String getStatusCause() {
		return statusCause;
	}

	/**
	 * Sets the status cause.
	 * 
	 * @param statusCause
	 *            The status cause
	 */
	public void setStatusCause(String statusCause) {
		this.statusCause = statusCause;
	}

	/**
	 * With status cause.
	 * 
	 * @param statusCause
	 *            the status cause
	 * @return the solution
	 */
	public Solution withStatusCause(String statusCause) {
		this.statusCause = statusCause;
		return this;
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
	 * Sets the status.
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * With status.
	 * 
	 * @param status
	 *            the status
	 * @return the solution
	 */
	public Solution withStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Gets the solution ref.
	 * 
	 * @return The solutionRef
	 */
	public String getSolutionRef() {
		return solutionRef;
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
	 * With solution ref.
	 * 
	 * @param solutionRef
	 *            the solution ref
	 * @return the solution
	 */
	public Solution withSolutionRef(String solutionRef) {
		this.solutionRef = solutionRef;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}

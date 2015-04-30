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

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;


public class Column {

	private String key;
	@SerializedName("full_name")
	private String fullName;
	private String type;
	@SerializedName("is_objective")
	private boolean isObjective;
	private String goal;


	/**
	 * Instantiates a new column.
	 */
	public Column() {
		super();
	}

	/**
	 * Instantiates a new column.
	 * 
	 * @param key
	 *            the key
	 * @param fullName
	 *            the full name
	 * @param type
	 *            the type
	 * @param isObjective
	 *            the is objective
	 * @param goal
	 *            the goal
	 */
	public Column(String key, String fullName, String type,
			boolean isObjective, String goal) {
		super();
		this.key = key;
		this.fullName = fullName;
		this.type = type;
		this.isObjective = isObjective;
		this.goal = goal;
	}

	/**
	 * Gets the key.
	 * 
	 * @return The key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            The key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * With key.
	 * 
	 * @param key
	 *            the key
	 * @return the column
	 */
	public Column withKey(String key) {
		this.key = key;
		return this;
	}

	/**
	 * Gets the full name.
	 * 
	 * @return The fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 * 
	 * @param fullName
	 *            The full_name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * With full name.
	 * 
	 * @param fullName
	 *            the full name
	 * @return the column
	 */
	public Column withFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	/**
	 * Gets the type.
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * With type.
	 * 
	 * @param type
	 *            the type
	 * @return the column
	 */
	public Column withType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Checks if is checks if is objective.
	 * 
	 * @return The isObjective
	 */
	public boolean isIsObjective() {
		return isObjective;
	}

	/**
	 * Sets the checks if is objective.
	 * 
	 * @param isObjective
	 *            The is_objective
	 */
	public void setIsObjective(boolean isObjective) {
		this.isObjective = isObjective;
	}

	/**
	 * With is objective.
	 * 
	 * @param isObjective
	 *            the is objective
	 * @return the column
	 */
	public Column withIsObjective(boolean isObjective) {
		this.isObjective = isObjective;
		return this;
	}

	/**
	 * Gets the goal.
	 * 
	 * @return The goal
	 */
	public String getGoal() {
		return goal;
	}

	/**
	 * Sets the goal.
	 * 
	 * @param goal
	 *            The goal
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}

	/**
	 * With goal.
	 * 
	 * @param goal
	 *            the goal
	 * @return the column
	 */
	public Column withGoal(String goal) {
		this.goal = goal;
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

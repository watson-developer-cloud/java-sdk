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

package com.ibm.watson.developer_cloud.visual_recognition.v1.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * The Class Label.
 */
public class Label {

	/** The name. */
	@SerializedName("label_name")
	private String name;

	/** The score. */
	@SerializedName("label_score")
	private double score;

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the score.
	 * 
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 * 
	 * @param score
	 *            the new score
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * With label name.
	 * 
	 * @param name
	 *            the name
	 * @return the image label
	 */
	public Label withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * With score.
	 * 
	 * @param score
	 *            the score
	 * @return the image
	 */
	public Label withScore(double score) {
		this.score = score;
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

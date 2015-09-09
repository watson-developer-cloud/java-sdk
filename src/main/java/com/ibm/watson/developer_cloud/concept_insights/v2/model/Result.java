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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class Result.
 */
public class Result {

	/** The explanation tags. */
	@SerializedName("explanation_tags")
	private List<ExplanationTag> explanationTags;

	/** The id. */
	private String id;

	/** The label. */
	private String label;

	/** The score. */
	private Float score;

	/**
	 * Gets the explanation tags.
	 * 
	 * @return The explanationTags
	 */
	public List<ExplanationTag> getExplanationTags() {
		return explanationTags;
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
	 * Gets the label.
	 * 
	 * @return The label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Gets the score.
	 * 
	 * @return The score
	 */
	public Float getScore() {
		return score;
	}

	/**
	 * Sets the explanation tags.
	 * 
	 * @param explanationTags
	 *            The explanation_tags
	 */
	public void setExplanationTags(List<ExplanationTag> explanationTags) {
		this.explanationTags = explanationTags;
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
	 * Sets the label.
	 * 
	 * @param label
	 *            The label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Sets the score.
	 * 
	 * @param score
	 *            The score
	 */
	public void setScore(Float score) {
		this.score = score;
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
	 * With explanation tags.
	 * 
	 * @param explanationTags
	 *            the explanation tags
	 * @return the result
	 */
	public Result withExplanationTags(List<ExplanationTag> explanationTags) {
		this.explanationTags = explanationTags;
		return this;
	}

	/**
	 * With id.
	 * 
	 * @param id
	 *            the id
	 * @return the result
	 */
	public Result withId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * With label.
	 * 
	 * @param label
	 *            the label
	 * @return the result
	 */
	public Result withLabel(String label) {
		this.label = label;
		return this;
	}

	/**
	 * With score.
	 * 
	 * @param score
	 *            the score
	 * @return the result
	 */
	public Result withScore(Float score) {
		this.score = score;
		return this;
	}
}

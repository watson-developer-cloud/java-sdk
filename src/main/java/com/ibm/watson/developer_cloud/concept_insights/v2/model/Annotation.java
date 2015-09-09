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
 * The Class Annotation.
 */
public class Annotation {

	/** The concept. */
	private Concept concept;

	/** The parts index. */
	@SerializedName("parts_index")
	private Integer partsIndex;

	/** The score. */
	private Float score;

	/** The text index. */
	@SerializedName("text_index")
	private List<Integer> textIndex;

	/**
	 * Gets the concept.
	 * 
	 * @return The concept
	 */
	public Concept getConcept() {
		return concept;
	}

	/**
	 * Gets the parts index.
	 * 
	 * @return The partsIndex
	 */
	public Integer getPartsIndex() {
		return partsIndex;
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
	 * Gets the text index.
	 * 
	 * @return The textIndex
	 */
	public List<Integer> getTextIndex() {
		return textIndex;
	}

	/**
	 * Sets the concept.
	 * 
	 * @param concept
	 *            The concept
	 */
	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	/**
	 * Sets the parts index.
	 * 
	 * @param partsIndex
	 *            The parts_index
	 */
	public void setPartsIndex(Integer partsIndex) {
		this.partsIndex = partsIndex;
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

	/**
	 * Sets the text index.
	 * 
	 * @param textIndex
	 *            The text_index
	 */
	public void setTextIndex(List<Integer> textIndex) {
		this.textIndex = textIndex;
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
	 * With concept.
	 * 
	 * @param concept
	 *            the concept
	 * @return the annotation
	 */
	public Annotation withConcept(Concept concept) {
		this.concept = concept;
		return this;
	}

	/**
	 * With parts index.
	 * 
	 * @param partsIndex
	 *            the parts index
	 * @return the annotation
	 */
	public Annotation withPartsIndex(Integer partsIndex) {
		this.partsIndex = partsIndex;
		return this;
	}

	/**
	 * With score.
	 * 
	 * @param score
	 *            the score
	 * @return the annotation
	 */
	public Annotation withScore(Float score) {
		this.score = score;
		return this;
	}

	/**
	 * With text index.
	 * 
	 * @param textIndex
	 *            the text index
	 * @return the annotation
	 */
	public Annotation withTextIndex(List<Integer> textIndex) {
		this.textIndex = textIndex;
		return this;
	}
}

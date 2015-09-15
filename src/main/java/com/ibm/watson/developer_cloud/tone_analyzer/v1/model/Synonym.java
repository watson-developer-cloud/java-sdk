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

package com.ibm.watson.developer_cloud.tone_analyzer.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Synonym.
 */
public class Synonym extends GenericModel {

	/**
	 * Number of "hops" to get to this suggested word: 1 for direct synonyms, 2 for
	 * synonyms of synonyms, etc.
	 */
	private Integer hops;

	/** The meaning of the original term. */
	private String meaning;

	/** The type of the original word (noun, verb, etc.). */
	@SerializedName("semantic-type")
	private String semanticType;

	/** The sense of the original word used to obtain related words. */
	private String sense;

	/** The weight. */
	// /** The weight. */
	private Double weight;

	/** The returned given as a synonym or related word. */
	private String word;

	/**
	 * Gets the hops.
	 * 
	 * @return The hops
	 */
	public Integer getHops() {
		return hops;
	}

	/**
	 * Gets the meaning.
	 * 
	 * @return The meaning
	 */
	public String getMeaning() {
		return meaning;
	}

	/**
	 * Gets the semantic type.
	 * 
	 * @return The semanticType
	 */
	public String getSemanticType() {
		return semanticType;
	}

	/**
	 * Gets the sense.
	 * 
	 * @return The sense
	 */
	public String getSense() {
		return sense;
	}

	/**
	 * Gets the weight.
	 * 
	 * @return The weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * Gets the word.
	 * 
	 * @return The word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Sets the hops.
	 * 
	 * @param hops
	 *            The hops
	 */
	public void setHops(final Integer hops) {
		this.hops = hops;
	}

	/**
	 * Sets the meaning.
	 * 
	 * @param meaning
	 *            The meaning
	 */
	public void setMeaning(final String meaning) {
		this.meaning = meaning;
	}

	/**
	 * Sets the semantic type.
	 * 
	 * @param semanticType
	 *            The semantic-type
	 */
	public void setSemanticType(final String semanticType) {
		this.semanticType = semanticType;
	}

	/**
	 * Sets the sense.
	 * 
	 * @param sense
	 *            The sense
	 */
	public void setSense(final String sense) {
		this.sense = sense;
	}

	/**
	 * Sets the weight.
	 * 
	 * @param weight
	 *            the new weight
	 */
	public void setWeight(final Double weight) {
		this.weight = weight;
	}

	/**
	 * Sets the word.
	 * 
	 * @param word
	 *            The word
	 */
	public void setWord(final String word) {
		this.word = word;
	}
}

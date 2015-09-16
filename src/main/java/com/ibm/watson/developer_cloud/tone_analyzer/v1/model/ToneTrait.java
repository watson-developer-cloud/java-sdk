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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class ToneTrait.
 */
public class ToneTrait extends GenericModel {

	/** The id. */
	private String id;

	/** The linguistic evidence. */
	@SerializedName("linguistic_evidence")
	private List<LinguisticEvidence> linguisticEvidence;

	/** The name of the trait. For example "Cheerfulness", "Agreeableness", etc., */
	private String name;

	/** A percentile comparing the current score (raw_score) to a given population. */
	@SerializedName("normalized_score")
	private Double normalizedScore;

	/** A raw score computed by the algorithms. */
	@SerializedName("raw_score")
	private Double rawScore;

	/** Number of words showing evidence of this trait. */
	@SerializedName("word_count")
	private Integer wordCount;

	/**
	 * Gets the id.
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the linguistic evidence.
	 * 
	 * @return The linguisticEvidence
	 */
	public List<LinguisticEvidence> getLinguisticEvidence() {
		return linguisticEvidence;
	}

	/**
	 * Gets the name.
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the normalized score.
	 * 
	 * @return The normalizedScore
	 */
	public Double getNormalizedScore() {
		return normalizedScore;
	}

	/**
	 * Gets the raw score.
	 * 
	 * @return The rawScore
	 */
	public Double getRawScore() {
		return rawScore;
	}

	/**
	 * Gets the word count.
	 * 
	 * @return The wordCount
	 */
	public Integer getWordCount() {
		return wordCount;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Sets the linguistic evidence.
	 * 
	 * @param linguisticEvidence
	 *            The linguistic_evidence
	 */
	public void setLinguisticEvidence(final List<LinguisticEvidence> linguisticEvidence) {
		this.linguisticEvidence = linguisticEvidence;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Sets the normalized score.
	 * 
	 * @param normalizedScore
	 *            The normalized_score
	 */
	public void setNormalizedScore(final Double normalizedScore) {
		this.normalizedScore = normalizedScore;
	}

	/**
	 * Sets the raw score.
	 * 
	 * @param rawScore
	 *            The raw score
	 */
	public void setRawScore(final Double rawScore) {
		this.rawScore = rawScore;
	}

	/**
	 * Sets the word count.
	 * 
	 * @param wordCount
	 *            The word count
	 */
	public void setWordCount(final Integer wordCount) {
		this.wordCount = wordCount;
	}
}

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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class ToneTrait.
 */
public class ToneTrait {

    /** The name of the trait. For example "Cheerfulness", "Agreeableness", etc., */
    private String name;
    
    /** The id. */
    private String id;

    /** Number of words showing evidence of this trait. */
    @SerializedName("word_count")
    private Integer wordCount;

    /** A percentile comparing the current score (raw_score) to a given population.  */
    @SerializedName("normalized_score")
    private Double normalizedScore;

    /** A raw score computed by the algorithms. */
    @SerializedName("raw_score")
    private Double rawScore;
    
    /** The linguistic evidence. */
    @SerializedName("linguistic_evidence")
    private List<LinguisticEvidence> linguisticEvidence = new ArrayList<LinguisticEvidence>();

    /**
     * Gets the name.
     *
     * @return     The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name     The name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * With name.
     *
     * @param name the name
     * @return the tone trait
     */
    public ToneTrait withName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the id.
     *
     * @return     The id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id     The id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * With id.
     *
     * @param id the id
     * @return the tone trait
     */
    public ToneTrait withId(final String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets the word count.
     *
     * @return     The wordCount
     */
    public Integer getWordCount() {
        return wordCount;
    }

    /**
     * Sets the word count.
     *
     * @param wordCount     The word count
     */
    public void setWordCount(final Integer wordCount) {
        this.wordCount = wordCount;
    }

    /**
     * With word count.
     *
     * @param wordCount the word count
     * @return the tone trait
     */
    public ToneTrait withWordCount(final Integer wordCount) {
        this.wordCount = wordCount;
        return this;
    }

    /**
     * Gets the normalized score.
     *
     * @return     The normalizedScore
     */
    public Double getNormalizedScore() {
        return normalizedScore;
    }

    /**
     * Sets the normalized score.
     *
     * @param normalizedScore     The normalized_score
     */
    public void setNormalizedScore(final Double normalizedScore) {
        this.normalizedScore = normalizedScore;
    }

    /**
     * With normalized score.
     *
     * @param normalizedScore the normalized score
     * @return the tone trait
     */
    public ToneTrait withNormalizedScore(final Double normalizedScore) {
        this.normalizedScore = normalizedScore;
        return this;
    }

    /**
     * Gets the raw score.
     *
     * @return     The rawScore
     */
    public Double getRawScore() {
        return rawScore;
    }

    /**
     * Sets the raw score.
     *
     * @param rawScore     The raw score
     */
    public void setRawScore(final Double rawScore) {
        this.rawScore = rawScore;
    }

    /**
     * With raw score.
     *
     * @param rawScore the raw score
     * @return the tone trait
     */
    public ToneTrait withRawScore(final Double rawScore) {
        this.rawScore = rawScore;
        return this;
    }

    /**
     * Gets the linguistic evidence.
     *
     * @return     The linguisticEvidence
     */
    public List<LinguisticEvidence> getLinguisticEvidence() {
        return linguisticEvidence;
    }

    /**
     * Sets the linguistic evidence.
     *
     * @param linguisticEvidence     The linguistic_evidence
     */
    public void setLinguisticEvidence(final List<LinguisticEvidence> linguisticEvidence) {
        this.linguisticEvidence = linguisticEvidence;
    }

    /**
     * With linguistic evidence.
     *
     * @param linguisticEvidence the linguistic evidence
     * @return the tone trait
     */
    public ToneTrait withLinguisticEvidence(final List<LinguisticEvidence> linguisticEvidence) {
        this.linguisticEvidence = linguisticEvidence;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToneTrait toneTrait = (ToneTrait) o;

        if (name != null ? !name.equals(toneTrait.name) : toneTrait.name != null) return false;
        if (!id.equals(toneTrait.id)) return false;
        if (wordCount != null ? !wordCount.equals(toneTrait.wordCount) : toneTrait.wordCount != null) return false;
        if (normalizedScore != null ? !normalizedScore.equals(toneTrait.normalizedScore) : toneTrait.normalizedScore != null)
            return false;
        if (rawScore != null ? !rawScore.equals(toneTrait.rawScore) : toneTrait.rawScore != null) return false;
        return !(linguisticEvidence != null ? !linguisticEvidence.equals(toneTrait.linguisticEvidence) : toneTrait.linguisticEvidence != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id.hashCode();
        result = 31 * result + (wordCount != null ? wordCount.hashCode() : 0);
        result = 31 * result + (normalizedScore != null ? normalizedScore.hashCode() : 0);
        result = 31 * result + (rawScore != null ? rawScore.hashCode() : 0);
        result = 31 * result + (linguisticEvidence != null ? linguisticEvidence.hashCode() : 0);
        return result;
    }

    /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ GsonSingleton.getGson().toJson(this);
	}
}

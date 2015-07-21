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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The Class LinguisticEvidence.
 */
public class LinguisticEvidence {

    /** A score telling how much this evidence contributes to the trait */
    @SerializedName("evidence_score")
    private Integer evidenceScore;

    /** Number of words found to show evidence with this trait, */
    @SerializedName("word_count")
    private Integer wordCount;

    /** The words. */
    @Expose
    private List<String> words = new ArrayList<String>();
    
    /** Either "positive" or "negative", telling if this linguistic evidence is showing positive (resp. negative) correlation with the trait */
    @Expose
    private String correlation;

    /**
     * Gets the evidence score.
     *
     * @return     The evidenceScore
     */
    public Integer getEvidenceScore() {
        return evidenceScore;
    }

    /**
     * Sets the evidence score.
     *
     * @param evidenceScore     The evidence_score
     */
    public void setEvidenceScore(final Integer evidenceScore) {
        this.evidenceScore = evidenceScore;
    }

    /**
     * With evidence score.
     *
     * @param evidenceScore the evidence score
     * @return the linguistic evidence
     */
    public LinguisticEvidence withEvidenceScore(final Integer evidenceScore) {
        this.evidenceScore = evidenceScore;
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
     * @return the linguistic evidence
     */
    public LinguisticEvidence withWordCount(final Integer wordCount) {
        this.wordCount = wordCount;
        return this;
    }

    /**
     * Gets the words.
     *
     * @return     The words
     */
    public List<String> getWords() {
        return words;
    }

    /**
     * Sets the words.
     *
     * @param words     The words
     */
    public void setWords(final List<String> words) {
        this.words = words;
    }

    /**
     * With words.
     *
     * @param words the words
     * @return the linguistic evidence
     */
    public LinguisticEvidence withWords(final List<String> words) {
        this.words = words;
        return this;
    }

    /**
     * Gets the correlation.
     *
     * @return     The correlation
     */
    public String getCorrelation() {
        return correlation;
    }

    /**
     * Sets the correlation.
     *
     * @param correlation     The correlation
     */
    public void setCorrelation(final String correlation) {
        this.correlation = correlation;
    }

    /**
     * With correlation.
     *
     * @param correlation the correlation
     * @return the linguistic evidence
     */
    public LinguisticEvidence withCorrelation(final String correlation) {
        this.correlation = correlation;
        return this;
    }

}

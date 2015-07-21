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

/**
 * The Synonym.
 */
public class Synonym {

    /** The returned given as a synonym or related word. */
    private String word;
    
    /** The sense of the original word used to obtain related words. */
    private String sense;
    
    /** The meaning of the original term. */
    private String meaning;
    
    /** Number of "hops" to get to this suggested word: 1 for direct synonyms, 2 for synonyms of synonyms, etc */
    private Integer hops;
    
    /** The type of the original word (noun, verb, etc.). */
    @SerializedName("semantic-type")
    private String semanticType;

    /**
     * Gets the word.
     *
     * @return     The word
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word.
     *
     * @param word     The word
     */
    public void setWord(final String word) {
        this.word = word;
    }

    /**
     * With word.
     *
     * @param word the word
     * @return the synonym
     */
    public Synonym withWord(final String word) {
        this.word = word;
        return this;
    }

    /**
     * Gets the sense.
     *
     * @return     The sense
     */
    public String getSense() {
        return sense;
    }

    /**
     * Sets the sense.
     *
     * @param sense     The sense
     */
    public void setSense(final String sense) {
        this.sense = sense;
    }

    /**
     * With sense.
     *
     * @param sense the sense
     * @return the synonym
     */
    public Synonym withSense(final String sense) {
        this.sense = sense;
        return this;
    }

    /**
     * Gets the meaning.
     *
     * @return     The meaning
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * Sets the meaning.
     *
     * @param meaning     The meaning
     */
    public void setMeaning(final String meaning) {
        this.meaning = meaning;
    }

    /**
     * With meaning.
     *
     * @param meaning the meaning
     * @return the synonym
     */
    public Synonym withMeaning(final String meaning) {
        this.meaning = meaning;
        return this;
    }

    /**
     * Gets the hops.
     *
     * @return     The hops
     */
    public Integer getHops() {
        return hops;
    }

    /**
     * Sets the hops.
     *
     * @param hops     The hops
     */
    public void setHops(final Integer hops) {
        this.hops = hops;
    }

    /**
     * With hops.
     *
     * @param hops the hops
     * @return the synonym
     */
    public Synonym withHops(final Integer hops) {
        this.hops = hops;
        return this;
    }

    /**
     * Gets the semantic type.
     *
     * @return     The semanticType
     */
    public String getSemanticType() {
        return semanticType;
    }

    /**
     * Sets the semantic type.
     *
     * @param semanticType     The semantic-type
     */
    public void setSemanticType(final String semanticType) {
        this.semanticType = semanticType;
    }

    /**
     * With semantic type.
     *
     * @param semanticType the semantic type
     * @return the synonym
     */
    public Synonym withSemanticType(final String semanticType) {
        this.semanticType = semanticType;
        return this;
    }
}

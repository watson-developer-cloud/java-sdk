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
import com.ibm.watson.developer_cloud.util.GsonSingleton;

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
    
    /**  Number of "hops" to get to this suggested word: 1 for direct synonyms, 2 for synonyms of synonyms, etc. */
    private Integer hops;
    
    /** The type of the original word (noun, verb, etc.). */
    @SerializedName("semantic-type")
    private String semanticType;

//    /** The weight. */
    private Double weight;

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

    /**
     * Gets the weight.
     *
     * @return     The weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Sets the weight.
     *
     * @param weight
     */
    public void setWeight(final Double weight) {
        this.weight = weight;
    }

    /**
     * With weight.
     *
     * @param weight
     * @return the synonym
     */
    public Synonym withWeight(final Double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Synonym synonym = (Synonym) o;

        if (word != null ? !word.equals(synonym.word) : synonym.word != null) return false;
        if (sense != null ? !sense.equals(synonym.sense) : synonym.sense != null) return false;
        if (meaning != null ? !meaning.equals(synonym.meaning) : synonym.meaning != null) return false;
        if (hops != null ? !hops.equals(synonym.hops) : synonym.hops != null) return false;
        if (semanticType != null ? !semanticType.equals(synonym.semanticType) : synonym.semanticType != null)
            return false;
        return !(weight != null ? !weight.equals(synonym.weight) : synonym.weight != null);

    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (sense != null ? sense.hashCode() : 0);
        result = 31 * result + (meaning != null ? meaning.hashCode() : 0);
        result = 31 * result + (hops != null ? hops.hashCode() : 0);
        result = 31 * result + (semanticType != null ? semanticType.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
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

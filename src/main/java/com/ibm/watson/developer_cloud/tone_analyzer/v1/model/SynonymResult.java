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

import com.google.gson.GsonBuilder;

/**
 * The SynonymResult.
 */
public class SynonymResult {

    /** The trait. */
    private String trait;
    
    /** The headword. */
    private String headword;
    
    /** The synonyms. */
    private List<Synonym> synonyms = new ArrayList<Synonym>();

    /**
     * Gets the trait.
     *
     * @return     The trait
     */
    public String getTrait() {
        return trait;
    }

    /**
     * Sets the trait.
     *
     * @param trait     The trait
     */
    public void setTrait(String trait) {
        this.trait = trait;
    }

    /**
     * With trait.
     *
     * @param trait the trait
     * @return the synonym result
     */
    public SynonymResult withTrait(String trait) {
        this.trait = trait;
        return this;
    }

    /**
     * Gets the headword.
     *
     * @return     The headword
     */
    public String getHeadword() {
        return headword;
    }

    /**
     * Sets the headword.
     *
     * @param headword     The headword
     */
    public void setHeadword(String headword) {
        this.headword = headword;
    }

    /**
     * With headword.
     *
     * @param headword the headword
     * @return the synonym result
     */
    public SynonymResult withHeadword(String headword) {
        this.headword = headword;
        return this;
    }

    /**
     * Gets the synonyms.
     *
     * @return     The synonyms
     */
    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    /**
     * Sets the synonyms.
     *
     * @param synonyms     The synonyms
     */
    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    /**
     * With synonyms.
     *
     * @param synonyms the synonyms
     * @return the synonym result
     */
    public SynonymResult withSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
        return this;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
}

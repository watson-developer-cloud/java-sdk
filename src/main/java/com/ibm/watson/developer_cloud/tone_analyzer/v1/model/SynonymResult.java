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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The SynonymResult.
 */
public class SynonymResult extends GenericModel {

	/** The headword. */
	private String headword;

	/** The synonyms. */
	private List<Synonym> synonyms;

	/** The trait. */
	private String trait;

	/**
	 * Gets the headword.
	 * 
	 * @return The headword
	 */
	public String getHeadword() {
		return headword;
	}

	/**
	 * Gets the synonyms.
	 * 
	 * @return The synonyms
	 */
	public List<Synonym> getSynonyms() {
		return synonyms;
	}

	/**
	 * Gets the trait.
	 * 
	 * @return The trait
	 */
	public String getTrait() {
		return trait;
	}

	/**
	 * Sets the headword.
	 * 
	 * @param headword
	 *            The headword
	 */
	public void setHeadword(String headword) {
		this.headword = headword;
	}

	/**
	 * Sets the synonyms.
	 * 
	 * @param synonyms
	 *            The synonyms
	 */
	public void setSynonyms(List<Synonym> synonyms) {
		this.synonyms = synonyms;
	}

	/**
	 * Sets the trait.
	 * 
	 * @param trait
	 *            The trait
	 */
	public void setTrait(String trait) {
		this.trait = trait;
	}
}

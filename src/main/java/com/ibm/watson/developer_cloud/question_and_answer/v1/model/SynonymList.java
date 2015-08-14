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

package com.ibm.watson.developer_cloud.question_and_answer.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class SynonymList.
 */
public class SynonymList {

	/** The lemma. */
	private String lemma;
	
	/** The part of speech. */
	private String partOfSpeech;
	
	/** The syn set. */
	private List<SynSet> synSet = new ArrayList<SynSet>();
	
	/** The value. */
	private String value;

	/**
	 * Gets the lemma.
	 * 
	 * 
	 * @return The lemma
	 */
	public String getLemma() {
		return lemma;
	}

	/**
	 * Gets the part of speech.
	 * 
	 * 
	 * @return The partOfSpeech
	 */
	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	/**
	 * Gets the syn set.
	 * 
	 * 
	 * @return The synSet
	 */
	public List<SynSet> getSynSet() {
		return synSet;
	}

	/**
	 * Gets the value.
	 * 
	 * 
	 * @return The value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the lemma.
	 * 
	 * @param lemma
	 *            The lemma
	 */
	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	/**
	 * Sets the part of speech.
	 * 
	 * @param partOfSpeech
	 *            The partOfSpeech
	 */
	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}

	/**
	 * Sets the syn set.
	 * 
	 * @param synSet
	 *            The synSet
	 */
	public void setSynSet(List<SynSet> synSet) {
		this.synSet = synSet;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            The value
	 */
	public void setValue(String value) {
		this.value = value;
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

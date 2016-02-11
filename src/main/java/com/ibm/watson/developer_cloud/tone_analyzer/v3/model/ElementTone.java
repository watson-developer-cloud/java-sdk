/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * This object represents the results of Tone analysis on an element; which may be a document or a sentence.
 * Its structure is a 2-level tree, with tone categories in the top level and the individual tones (and their
 * scores) in leaves.
 *
 */
public class ElementTone extends GenericModel {

    @SerializedName("tone_categories")
	private List<ToneCategory> tones;

	/**
	 * Gets the tones.
	 *
	 * @return the tones
	 */
	public List<ToneCategory> getTones() {
		return tones;
	}

	/**
	 * Sets the tones.
	 *
	 * @param tones the new tones
	 */
	public void setTones(List<ToneCategory> tones) {
		this.tones = tones;
	}
	
	/**
	 * Adds the tone.
	 *
	 * @param tone the tone
	 */
	public void addTone(ToneCategory tone) {
		this.tones.add(tone);
	}
	
}

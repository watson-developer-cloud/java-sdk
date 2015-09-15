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
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Tone.
 */
public class Tone extends GenericModel {

	/** The Each of the Tones computed: Social Tone, Emotion Tone and Writing Tone.. */
	@Expose
	private List<ToneDimension> children = new ArrayList<ToneDimension>();

	/** Name of the scorecard used to compute this tone.. */
	@Expose
	private String scorecard;

	/**
	 * Gets the children.
	 * 
	 * @return The children
	 */
	public List<ToneDimension> getChildren() {
		return children;
	}

	/**
	 * Gets the scorecard.
	 * 
	 * @return The scorecard
	 */
	public String getScorecard() {
		return scorecard;
	}

	/**
	 * Sets the children.
	 * 
	 * @param children
	 *            The children
	 */
	public void setChildren(final List<ToneDimension> children) {
		this.children = children;
	}

	/**
	 * Sets the scorecard.
	 * 
	 * @param scorecard
	 *            The scorecard
	 */
	public void setScorecard(final String scorecard) {
		this.scorecard = scorecard;
	}
}

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

package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class SpeechResults.
 */
public class SpeechResults extends GenericModel {

	/** The results. */
	private List<Transcript> results;
	
	/** The result index. */
	@SerializedName("result_index")
	private int resultIndex;

	/**
	 * Gets the results.
	 * 
	 * @return The results
	 */
	public List<Transcript> getResults() {
		return results;
	}

	/**
	 * Sets the results.
	 * 
	 * @param results
	 *            The results
	 */
	public void setResults(final List<Transcript> results) {
		this.results = results;
	}

	/**
	 * Gets the result index.
	 * 
	 * @return The resultIndex
	 */
	public int getResultIndex() {
		return resultIndex;
	}

	/**
	 * Sets the result index.
	 * 
	 * @param resultIndex
	 *            The result_index
	 */
	public void setResultIndex(final int resultIndex) {
		this.resultIndex = resultIndex;
	}

}

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
 * The Class Transcript.
 */
public class Transcript extends GenericModel {

	/** The _final. */
	@SerializedName("final")
	private boolean _final;
	
	/** The alternatives. */
	private List<SpeechAlternative> alternatives;

	/**
	 * Gets the alternatives.
	 * 
	 * @return The alternatives
	 */
	public List<SpeechAlternative> getAlternatives() {
		return alternatives;
	}

	/**
	 * Checks if is final.
	 * 
	 * @return The _final
	 */
	public boolean isFinal() {
		return _final;
	}

	/**
	 * Sets the alternatives.
	 * 
	 * @param alternatives
	 *            The alternatives
	 */
	public void setAlternatives(final List<SpeechAlternative> alternatives) {
		this.alternatives = alternatives;
	}

	/**
	 * Sets the final.
	 * 
	 * @param _final
	 *            The final
	 */
	public void setFinal(final boolean _final) {
		this._final = _final;
	}

	/**
	 * With alternatives.
	 * 
	 * @param alternatives
	 *            the alternatives
	 * @return the speech
	 */
	public Transcript withAlternatives(
			final List<SpeechAlternative> alternatives) {
		this.alternatives = alternatives;
		return this;
	}
}

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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;

/**
 * The Class VoiceSet.
 */
public class VoiceSet {

	/**
	 * The voices.
	 */
	private List<Voice> voices = new ArrayList<Voice>();

	/**
	 * Gets the voices.
	 * 
	 * @return the voices
	 */
	public List<Voice> getVoices() {
		return voices;
	}

	/**
	 * Sets the voices.
	 * 
	 * @param voices
	 *            the new voices
	 */
	public void setVoices(List<Voice> voices) {
		this.voices = voices;
	}

	/**
	 * With value.
	 * 
	 * @param voice
	 *            the voices
	 * @return the option
	 */
	public VoiceSet withVoice(Voice voice) {
		if (voices == null) {
			voices = new ArrayList<Voice>();
		}
		voices.add(voice);
		return this;
	}

	/**
	 * With value.
	 * 
	 * @param voices
	 *            the voices
	 * @return the option
	 */
	public VoiceSet withVoices(List<Voice> voices) {
		this.voices = voices;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
}

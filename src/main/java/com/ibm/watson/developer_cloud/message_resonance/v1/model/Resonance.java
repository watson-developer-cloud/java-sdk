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

package com.ibm.watson.developer_cloud.message_resonance.v1.model;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class Resonance.
 */
public class Resonance {

	/** The word. */
	private String word;
	
	/** The overall. */
	private int overall;
	
	/** The prevalence. */
	private int prevalence;
	
	/** The volume. */
	private int volume;
	
	/** The duration. */
	private int duration;
	
	/** The word offset. */
	private int wordOffset;

	/**
	 * Gets the duration.
	 * 
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Gets the overall.
	 * 
	 * @return The overall
	 */
	public int getOverall() {
		return overall;
	}

	/**
	 * Gets the prevalence.
	 * 
	 * @return The prevalence
	 * 
	 */
	public int getPrevalence() {
		return prevalence;
	}

	/**
	 * Gets the volume.
	 * 
	 * @return The volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * Gets the word.
	 * 
	 * 
	 * @return The word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Gets the word offset.
	 * 
	 * @return The wordOffset
	 */
	public int getWordOffset() {
		return wordOffset;
	}

	/**
	 * Sets the duration.
	 * 
	 * @param duration
	 *            The duration
	 */
	public void setDuration(final int duration) {
		this.duration = duration;
	}

	/**
	 * Sets the overall.
	 * 
	 * @param overall
	 *            The overall
	 */
	public void setOverall(final int overall) {
		this.overall = overall;
	}

	/**
	 * Sets the prevalence.
	 * 
	 * @param prevalence
	 *            The prevalence
	 */
	public void setPrevalence(final int prevalence) {
		this.prevalence = prevalence;
	}

	/**
	 * Sets the volume.
	 * 
	 * @param volume
	 *            The volume
	 */
	public void setVolume(final int volume) {
		this.volume = volume;
	}

	/**
	 * Sets the word.
	 * 
	 * @param word
	 *            The word
	 */
	public void setWord(final String word) {
		this.word = word;
	}

	/**
	 * Sets the word offset.
	 * 
	 * @param wordOffset
	 *            The word_offset
	 */
	public void setWordOffset(final int wordOffset) {
		this.wordOffset = wordOffset;
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

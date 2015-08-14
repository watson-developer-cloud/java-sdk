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

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.message_resonance.v1.MessageResonance;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Message returned by the Message Resonance service.
 *
 * @see MessageResonance
 */
public class Message {

	/** The text. */
	private String text;
	
	/** The dataset. */
	private MessageResonanceDataset dataset;
	
	/** The resonances. */
	private List<Resonance> resonances = new ArrayList<Resonance>();

	/**
	 * Gets the dataset.
	 * 
	 * 
	 * @return The dataset
	 */
	public MessageResonanceDataset getDataset() {
		return dataset;
	}

	/**
	 * Gets the resonances.
	 * 
	 * 
	 * @return The resonances
	 */
	public List<Resonance> getResonances() {
		return resonances;
	}

	/**
	 * Gets the text.
	 * 
	 * 
	 * @return The text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the dataset.
	 * 
	 * @param dataset
	 *            The dataset
	 */
	public void setDataset(final MessageResonanceDataset dataset) {
		this.dataset = dataset;
	}

	/**
	 * Sets the resonances.
	 * 
	 * @param resonances
	 *            The resonances
	 */
	public void setResonances(final List<Resonance> resonances) {
		this.resonances = resonances;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            The text
	 */
	public void setText(final String text) {
		this.text = text;
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

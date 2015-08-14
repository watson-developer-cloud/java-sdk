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
package com.ibm.watson.developer_cloud.message_resonance.v1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.ibm.watson.developer_cloud.message_resonance.v1.model.Message;
import com.ibm.watson.developer_cloud.message_resonance.v1.model.MessageResonanceDataset;
import com.ibm.watson.developer_cloud.message_resonance.v1.model.Resonance;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Message Resonance analyzes draft content and scores how well it is likely
 * to be received by a specific target audience.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/message-resonance.html">
 *      Message Resonance</a>
 */
public class MessageResonance extends WatsonService {

	/** The url. */
	private static final String URL = "https://gateway.watsonplatform.net/message-resonance-beta/api";
	
	/** The dataset. */
	private MessageResonanceDataset dataset;

	/**
	 * Instantiates a new message resonance.
	 * 
	 */
	public MessageResonance() {
		setEndPoint(URL);
	}

	/**
	 * Format message.
	 * 
	 * @param text
	 *            the text
	 * @param resonances
	 *            the resonances
	 * 
	 * @return the message
	 */
	private Message formatResponseMessage(final String text,final List<Resonance> resonances) {
		Message message = new Message();
		message.setText(text);
		message.setDataset(dataset);
		message.setResonances(resonances);

		int index = 0;
		for (Resonance resonance : resonances) {
			resonance.setWordOffset(text.indexOf(resonance.getWord(), index));
			index += resonance.getWord().length();
		}
		return message;
	}

	/**
	 * Gets the dataset.
	 * 
	 * 
	 * @return the dataset
	 */
	public MessageResonanceDataset getDataset() {
		return dataset;
	}

	/**
	 * Returns the resonance for the given text.
	 * 
	 * @param text
	 *            the text
	 * 
	 * @return A list of JSON objects, each element corresponds to a word
	 */
	public Message getResonance(final String text) {
		if (dataset == null)
			throw new IllegalArgumentException("dataset can not be null");

		if (text == null)
			throw new IllegalArgumentException("text can not be null");

		// Split the text to analyze word by word
		String[] words = text.split("\\s");

		List<Resonance> resonances = new ArrayList<Resonance>();
		for (String word : words) {
			Resonance resonance = getResonanceForWord(word);
			resonances.add(resonance);
		}

		return formatResponseMessage(text, resonances);
	}

	/**
	 * Gets the resonance for a given word and dataset.
	 * 
	 * @param word
	 *            the word
	 * 
	 * @return the resonance
	 */
	private Resonance getResonanceForWord(final String word) {
		HttpRequestBase request = Request.Get("/v1/ringscore")
				.withQuery("text", word, "dataset", dataset).build();

		try {
			HttpResponse response = execute(request);
			String resonanceJson = ResponseUtil.getString(response);
			return GsonSingleton.getGson().fromJson(resonanceJson, Resonance.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sets the dataset.
	 * 
	 * @param dataset
	 *            the new dataset
	 */
	public void setDataset(final MessageResonanceDataset dataset) {
		this.dataset = dataset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageResonance [dataset=");
		builder.append(dataset);
		builder.append(", getEndPoint()=");
		builder.append(getEndPoint());
		builder.append("]");
		return builder.toString();
	}
}

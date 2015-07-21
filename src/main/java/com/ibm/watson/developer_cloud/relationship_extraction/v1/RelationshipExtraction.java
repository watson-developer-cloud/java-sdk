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
package com.ibm.watson.developer_cloud.relationship_extraction.v1;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.ibm.watson.developer_cloud.relationship_extraction.v1.model.RelationshipExtractionDataset;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * Relationship Extraction intelligently finds relationships between sentence
 * components (nouns, verbs, subjects, objects, etc.)
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/relationship-extraction.html">
 *      Relationship Extraction</a>
 */
public class RelationshipExtraction extends WatsonService {

	/** The url. */
	private static final String URL = "https://gateway.watsonplatform.net/relationship-extraction-beta/api";
	
	/** The dataset. */
	private RelationshipExtractionDataset dataset;

	/**
	 * Instantiates a new relationship extraction service.
	 */
	public RelationshipExtraction() {
		setEndPoint(URL);
	}

	/**
	 * Extract.
	 * 
	 * @param text
	 *            the text
	 * 
	 * 
	 * @return the string
	 */
	public String extract(final String text) {
		if (dataset == null)
			throw new IllegalArgumentException("dataset can not be null");
		if (text == null)
			throw new IllegalArgumentException("text can not be null");

		HttpRequestBase request = Request.Post("/v1/sire/0")
				.withForm("sid", dataset.getId(), "rt", "xml", "txt", text).build();
		String relations = null;
		try {
			HttpResponse response = execute(request);
			relations = ResponseUtil.getString(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return relations;
	}

	/**
	 * Gets the dataset.
	 * 
	 * 
	 * @return the dataset
	 */
	public RelationshipExtractionDataset getDataset() {
		return dataset;
	}

	/**
	 * Sets the dataset.
	 * 
	 * @param dataset
	 *            the new dataset
	 */
	public void setDataset(final RelationshipExtractionDataset dataset) {
		this.dataset = dataset;
	}

}

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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Classified class used by the {@link NaturalLanguageClassifier} service.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class ClassifiedClass extends GenericModel {

	/** The name. */
	@SerializedName("class_name")
	private String name;
	
	/** The confidence. */
	private Double confidence;

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the confidence that Watson has in this class.
	 * Higher values represent higher confidences.
	 * 
	 * @return the confidence
	 */
	public Double getConfidence() {
		return confidence;
	}

	/**
	 * Sets the confidence that Watson has in this class.
	 * Higher values represent higher confidences.
	 * @param confidence
	 *            the new confidence
	 */
	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}
}

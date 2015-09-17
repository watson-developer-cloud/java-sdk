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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The set of questions and their "keys" used to
 * adapt a system to a domain (the ground truth).
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @see NaturalLanguageClassifier
 */
public class TrainingData  extends GenericModel {

	/** The text. */
	private String text;
	
	/** The classes. */
	private List<String> classes;

	/**
	 * Gets the representative phrase.
	 * For example, questions that users might ask
	 * 
	 * @return the phrase
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the representative phrase.
	 * For example, questions that users might ask
	 * 
	 * @param text
	 *            the new phrase
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the classes.
	 * 
	 * @return the classes
	 */
	public List<String> getClasses() {
		return classes;
	}

	/**
	 * Sets the classes.
	 * 
	 * @param classes
	 *            the new classes
	 */
	public void setClasses(List<String> classes) {
		this.classes = classes;
	}

	/**
	 * With text.
	 *
	 * @param text the text
	 * @return the training data
	 */
	public TrainingData withText(String text) {
		this.text = text;
		return this;
	}

	/**
	 * With classes.
	 *
	 * @param classes the classes
	 * @return the training data
	 */
	public TrainingData withClasses(String... classes) {
		setClasses(Arrays.asList(classes));
		return this;
	}
	
	/**
	 * Adds a class to the training data.
	 *
	 * @param className the class name to add
	 */
	public void addClass(String className) {
		if (this.classes == null)
			this.classes = new ArrayList<String>();
		
		if (!this.classes.contains(className))
			this.classes.add(className);
	}
	
}

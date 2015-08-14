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

package com.ibm.watson.developer_cloud.question_and_answer.v1.model;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class Question.
 */
public class Question {

	/** The question text. */
	private String questionText;
	
	/** The items. */
	private Integer items;
	
	/** The evidence request. */
	private EvidenceRequest evidenceRequest;
	
	/** The answer assertion. */
	private String answerAssertion;
	
	/** The category. */
	private String category;
	
	/** The context. */
	private String context;
	
	/** The formatted answer. */
	private boolean formattedAnswer;
	
	/** The passthru. */
	private String passthru;
	
	/** The synonyms. */
	private String synonyms;
	
	/** The lat. */
	private String lat;
	
	/** The filters. */
	private Filters filters;

	/**
	 * Gets the answer assertion.
	 * 
	 * 
	 * @return The answerAssertion
	 */
	public String getAnswerAssertion() {
		return answerAssertion;
	}

	/**
	 * Gets the category.
	 * 
	 * 
	 * @return The category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Gets the context.
	 * 
	 * 
	 * @return The context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * Gets the evidence request.
	 * 
	 * 
	 * @return The evidenceRequest
	 */
	public EvidenceRequest getEvidenceRequest() {
		return evidenceRequest;
	}

	/**
	 * Gets the filters.
	 * 
	 * 
	 * @return The filters
	 */
	public Filters getFilters() {
		return filters;
	}

	/**
	 * Gets the items.
	 * 
	 * 
	 * @return The items
	 */
	public int getItems() {
		return items;
	}

	/**
	 * Gets the lat.
	 * 
	 * 
	 * @return The lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * Gets the passthru.
	 * 
	 * 
	 * @return The passthru
	 */
	public String getPassthru() {
		return passthru;
	}

	/**
	 * Gets the question text.
	 * 
	 * 
	 * @return The questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * Gets the synonyms.
	 * 
	 * 
	 * @return The synonyms
	 */
	public String getSynonyms() {
		return synonyms;
	}

	/**
	 * Checks if is formatted answer.
	 * 
	 * 
	 * @return The formattedAnswer
	 */
	public boolean isFormattedAnswer() {
		return formattedAnswer;
	}

	/**
	 * Sets the answer assertion.
	 * 
	 * @param answerAssertion
	 *            The answerAssertion
	 */
	public void setAnswerAssertion(String answerAssertion) {
		this.answerAssertion = answerAssertion;
	}

	/**
	 * Sets the category.
	 * 
	 * @param category
	 *            The category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Sets the context.
	 * 
	 * @param context
	 *            The context
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * Sets the evidence request.
	 * 
	 * @param evidenceRequest
	 *            The evidenceRequest
	 */
	public void setEvidenceRequest(EvidenceRequest evidenceRequest) {
		this.evidenceRequest = evidenceRequest;
	}

	/**
	 * Sets the filters.
	 * 
	 * @param filters
	 *            The filters
	 */
	public void setFilters(Filters filters) {
		this.filters = filters;
	}

	/**
	 * Sets the formatted answer.
	 * 
	 * @param formattedAnswer
	 *            The formattedAnswer
	 */
	public void setFormattedAnswer(boolean formattedAnswer) {
		this.formattedAnswer = formattedAnswer;
	}

	/**
	 * Sets the items.
	 * 
	 * @param items
	 *            The items
	 */
	public void setItems(int items) {
		this.items = items;
	}

	/**
	 * Sets the lat.
	 * 
	 * @param lat
	 *            The lat
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * Sets the passthru.
	 * 
	 * @param passthru
	 *            The passthru
	 */
	public void setPassthru(String passthru) {
		this.passthru = passthru;
	}

	/**
	 * Sets the question text.
	 * 
	 * @param questionText
	 *            The questionText
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * Sets the synonyms.
	 * 
	 * @param synonyms
	 *            The synonyms
	 */
	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
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

	/**
	 * With answer assertion.
	 * 
	 * @param answerAssertion
	 *            the answer assertion
	 * 
	 * @return the question information
	 */
	public Question withAnswerAssertion(String answerAssertion) {
		this.answerAssertion = answerAssertion;
		return this;
	}

	/**
	 * With category.
	 * 
	 * @param category
	 *            the category
	 * 
	 * @return the question information
	 */
	public Question withCategory(String category) {
		this.category = category;
		return this;
	}

	/**
	 * With context.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the question information
	 */
	public Question withContext(String context) {
		this.context = context;
		return this;
	}

	/**
	 * With evidence request.
	 * 
	 * @param evidenceRequest
	 *            the evidence request
	 * 
	 * @return the question information
	 */
	public Question withEvidenceRequest(
			EvidenceRequest evidenceRequest) {
		this.evidenceRequest = evidenceRequest;
		return this;
	}

	/**
	 * With filters.
	 * 
	 * @param filters
	 *            the filters
	 * 
	 * @return the question information
	 */
	public Question withFilters(Filters filters) {
		this.filters = filters;
		return this;
	}

	/**
	 * With formatted answer.
	 * 
	 * @param formattedAnswer
	 *            the formatted answer
	 * 
	 * @return the question information
	 */
	public Question withFormattedAnswer(boolean formattedAnswer) {
		this.formattedAnswer = formattedAnswer;
		return this;
	}

	/**
	 * With items.
	 * 
	 * @param items
	 *            the items
	 * 
	 * @return the question information
	 */
	public Question withItems(int items) {
		this.items = items;
		return this;
	}

	/**
	 * With lat.
	 * 
	 * @param lat
	 *            the lat
	 * 
	 * @return the question information
	 */
	public Question withLat(String lat) {
		this.lat = lat;
		return this;
	}

	/**
	 * With passthru.
	 * 
	 * @param passthru
	 *            the passthru
	 * 
	 * @return the question information
	 */
	public Question withPassthru(String passthru) {
		this.passthru = passthru;
		return this;
	}

	/**
	 * With question text.
	 * 
	 * @param questionText
	 *            the question text
	 * 
	 * @return the question information
	 */
	public Question withQuestionText(String questionText) {
		this.questionText = questionText;
		return this;
	}

	/**
	 * With synonyms.
	 * 
	 * @param synonyms
	 *            the synonyms
	 * 
	 * @return the question information
	 */
	public Question withSynonyms(String synonyms) {
		this.synonyms = synonyms;
		return this;
	}

}

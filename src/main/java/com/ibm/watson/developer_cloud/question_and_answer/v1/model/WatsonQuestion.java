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
 * The Class WatsonQuestion.
 */
public class WatsonQuestion {

	/** The question. */
	private Question question;

	/**
	 * Instantiates a new watson question.
	 * 
	 * @param question
	 *            the question
	 */
	public WatsonQuestion(Question question) {
		this.question = question;
	}

	/**
	 * With question.
	 * 
	 * @param question
	 *            the question
	 * @return the watson question
	 */
	public WatsonQuestion withQuestion(Question question) {
		this.question = question;
		return this;
	}

	/**
	 * Gets the question.
	 * 
	 * 
	 * @return The question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 * 
	 * @param question
	 *            The question
	 */
	public void setQuestion(Question question) {
		this.question = question;
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

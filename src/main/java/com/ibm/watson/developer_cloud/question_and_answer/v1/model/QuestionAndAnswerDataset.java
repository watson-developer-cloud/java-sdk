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
 * The Class QuestionAndAnswerDataset.
 */
public class QuestionAndAnswerDataset {

	/** The Constant TRAVEL. */
	public static final QuestionAndAnswerDataset TRAVEL = new QuestionAndAnswerDataset("travel");
	
	/** The Constant HEALTHCARE. */
	public static final QuestionAndAnswerDataset HEALTHCARE = new QuestionAndAnswerDataset("healthcare");


	/** The id. */
	private final String id;

	/**
	 * Instantiates a new dataset.
	 * 
	 * @param id
	 *            the id
	 */
	public QuestionAndAnswerDataset(String id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 * 
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
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
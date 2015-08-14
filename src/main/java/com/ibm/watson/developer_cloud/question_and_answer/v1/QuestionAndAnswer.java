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
package com.ibm.watson.developer_cloud.question_and_answer.v1;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.ibm.watson.developer_cloud.question_and_answer.v1.model.Pipeline;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.Question;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.QuestionAndAnswerDataset;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.WatsonAnswer;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.WatsonQuestion;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Question and Answer interprets and answers user questions directly based
 * on primary data sources (brochures, web pages, manuals, records, etc.) that
 * have been selected and gathered into a body of data or 'corpus'
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/question-answer.html">
 *      Question and Answer</a>
 */
public class QuestionAndAnswer extends WatsonService {

	/** The url. */
	private static final String URL = "https://gateway.watsonplatform.net/question-and-answer-beta/api";

	/** The dataset. */
	private QuestionAndAnswerDataset dataset;

	/**
	 * Instantiates a new question and answer.
	 */
	public QuestionAndAnswer() {
		setEndPoint(URL);
	}

	/**
	 * Interprets and answers user questions.
	 * 
	 * @param question
	 *            the string question
	 * @return the answers
	 */
	public WatsonAnswer ask(final String question) {
		if (question == null || question.trim().isEmpty())
			throw new IllegalArgumentException("question can not be null or empty");

		Question q = new Question().withQuestionText(question);
		return ask(q);
	}


	/**
	 * Interprets and answers user questions.
	 * 
	 * @param question
	 *            the question
	 * @return the JSON array
	 */
	public WatsonAnswer ask(final Question question) {
		if (dataset == null)
			throw new IllegalArgumentException("dataset can not be null");

		if (question == null)
			throw new IllegalArgumentException("question can not be null");

		HttpRequestBase request = Request.Post("/v1/question/%s", dataset.getId())
				.withHeader("X-synctimeout", "30")
				.withContent(GsonSingleton.getGson().toJson(new WatsonQuestion(question)), MediaType.APPLICATION_JSON).build();

		try {
			HttpResponse response = execute(request);
			String answersString = ResponseUtil.getString(response);
			Pipeline[] pipelines = GsonSingleton.getGson().fromJson(answersString,
					Pipeline[].class);
			// Return the results from the first pipeline
			return pipelines[0].getWatsonAnswer();
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
	public void setDataset(final QuestionAndAnswerDataset dataset) {
		this.dataset = dataset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuestionAndAnswer [dataset=" + dataset + ", getEndPoint()=" + getEndPoint() + "]";
	}

}

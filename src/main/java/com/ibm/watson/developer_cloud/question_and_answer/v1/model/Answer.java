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
 * The Class Answer.
 */
public class Answer {

	/** The confidence. */
	private double confidence;
	
	/** The id. */
	private int id;
	
	/** The pipeline. */
	private String pipeline;
	
	/** The text. */
	private String text;

	/**
	 * Gets a decimal percentage that represents the confidence that Watson has
	 * in this answer.
	 * 
	 * @return The confidence
	 */
	public double getConfidence() {
		return confidence;
	}

	/**
	 * Gets  an integer that uniquely identifies an answer
	 * in the context of the question.,
	 * 
	 * 
	 * @return The id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the pipeline.
	 * 
	 * 
	 * @return The pipeline
	 */
	public String getPipeline() {
		return pipeline;
	}

	/**
	 * Gets a string that contains an answer to the question in the form of
	 * text.
	 * 
	 * @return The text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets a decimal percentage that represents the confidence that Watson has in this answer.
	 * 
	 * @param confidence
	 *            The confidence
	 */
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	/**
	 * Sets an integer that uniquely identifies an answer in the context of the
	 * question.
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the pipeline.
	 * 
	 * @param pipeline
	 *            The pipeline
	 */
	public void setPipeline(String pipeline) {
		this.pipeline = pipeline;
	}

	/**
	 * Sets a string that contains an answer to the question in the form of
	 * text.
	 * 
	 * @param text
	 *            The text
	 */
	public void setText(String text) {
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

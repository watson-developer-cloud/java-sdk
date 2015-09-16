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

package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column;

/**
 * The Class Problem.
 */
public class Problem extends GenericModel {

	/** The columns. */
	private List<Column> columns;

	/** The options. */
	private List<Option> options;

	/** The subject. */
	private String subject;

	/**
	 * Instantiates a new problem.
	 */
	public Problem() {
		super();
	}

	/**
	 * Instantiates a new problem.
	 * 
	 * @param subject
	 *            the subject
	 */
	public Problem(String subject) {
		super();
		this.subject = subject;
	}

	/**
	 * Gets the columns.
	 * 
	 * @return The columns
	 */
	public List<Column> getColumns() {
		return columns;
	}

	/**
	 * Gets the options.
	 * 
	 * @return The options
	 */
	public List<Option> getOptions() {
		return options;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return The subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the columns.
	 * 
	 * @param columns
	 *            The columns
	 */
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	/**
	 * Sets the options.
	 * 
	 * @param options
	 *            The options
	 */
	public void setOptions(List<Option> options) {
		this.options = options;
	}

	/**
	 * Sets the subject.
	 * 
	 * @param subject
	 *            The subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * With columns.
	 * 
	 * @param columns
	 *            the columns
	 * @return the problem
	 */
	public Problem withColumns(List<Column> columns) {
		this.columns = columns;
		return this;
	}

	/**
	 * With options.
	 * 
	 * @param options
	 *            the options
	 * @return the problem
	 */
	public Problem withOptions(List<Option> options) {
		this.options = options;
		return this;
	}

	/**
	 * With subject.
	 * 
	 * @param subject
	 *            the subject
	 * @return the problem
	 */
	public Problem withSubject(String subject) {
		this.subject = subject;
		return this;
	}

}

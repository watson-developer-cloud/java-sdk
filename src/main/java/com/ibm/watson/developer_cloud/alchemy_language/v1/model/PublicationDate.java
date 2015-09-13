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
package com.ibm.watson.developer_cloud.alchemy_language.v1.model;

import com.ibm.watson.developer_cloud.alchemy_language.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * PublicationDate returned by the {@link AlchemyLanguage} service.
 * 
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class PublicationDate extends GenericModel {

	/** The confident. */
	private String confident;

	/** The date. */
	private String date;

	/**
	 * Gets the confident.
	 *
	 * @return The confident
	 */
	public String getConfident() {
		return confident;
	}

	/**
	 * Sets the confident.
	 *
	 * @param confident            The confident
	 */
	public void setConfident(String confident) {
		this.confident = confident;
	}

	/**
	 * With confident.
	 *
	 * @param confident the confident
	 * @return the publication date
	 */
	public PublicationDate withConfident(String confident) {
		this.confident = confident;
		return this;
	}

	/**
	 * Gets the date.
	 *
	 * @return The date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date            The date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * With date.
	 *
	 * @param date the date
	 * @return the publication date
	 */
	public PublicationDate withDate(String date) {
		this.date = date;
		return this;
	}
}

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
package com.ibm.watson.developer_cloud.visual_insights.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class Summary.
 */
public class Summary extends GenericModel {

	/** The summary. */
	private List<SummaryItem> summary;

	/**
	 * Gets the summary.
	 * 
	 * @return the summary
	 */
	public List<SummaryItem> getSummary() {
		return summary;
	}

	/**
	 * Sets the summary.
	 * 
	 * @param summary
	 *            the new summary
	 */
	public void setSummary(List<SummaryItem> summary) {
		this.summary = summary;
	}

	/**
	 * The object that holds the name and score.
	 */
	public static class SummaryItem extends GenericModel {

		/** The name. */
		private String name;

		/** The score. */
		private Double score;

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
		 * Gets the score.
		 * 
		 * @return the score
		 */
		public Double getScore() {
			return score;
		}

		/**
		 * Sets the score.
		 * 
		 * @param score
		 *            the new score
		 */
		public void setScore(Double score) {
			this.score = score;
		}

	}
}

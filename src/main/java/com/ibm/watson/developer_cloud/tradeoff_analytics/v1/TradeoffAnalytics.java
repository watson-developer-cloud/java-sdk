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
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1;

import java.io.IOException;

import org.apache.http.HttpResponse;

import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Class TradeoffAnalytics.
 */
public class TradeoffAnalytics extends WatsonService {

	/** The Constant GENERATE_VISUALIZATION. */
	private static final String GENERATE_VISUALIZATION = "GENERATE_VISUALIZATION";
	
	/** The url. */
	private final static String URL = "https://gateway.watsonplatform.net/tradeoff-analytics/api";

	/**
	 * Instantiates a new tradeoff analytics.
	 */
	public TradeoffAnalytics() {
		setEndPoint(URL);
	}

	/**
	 * Dilemmas.
	 * 
	 * @param problem
	 *            the problem
	 * @return the dilemma
	 */
	public Dilemma dilemmas(final Problem problem) {
		return dilemmas(problem, null);
	}
	/**
	 * Dilemmas.
	 *
	 * @param problem the problem
	 * @param generateVisualization the generate visualization
	 * @return the dilemma
	 */
	public Dilemma dilemmas(final Problem problem,final Boolean generateVisualization) {
		if (problem == null)
			throw new IllegalArgumentException("problem was not specified");
	
		String contentJson = GsonSingleton.getGson().toJson(problem);
		
		Request request = Request.Post("/v1/dilemmas")
				.withContent(contentJson, MediaType.APPLICATION_JSON);
	
		if (generateVisualization != null)
			request.withQuery(GENERATE_VISUALIZATION,generateVisualization);
		
		try {
			HttpResponse response = execute(request.build());
			String dilemmaJson = ResponseUtil.getString(response);

			Dilemma dilemma = GsonSingleton.getGson().fromJson(dilemmaJson, Dilemma.class);
			return dilemma;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

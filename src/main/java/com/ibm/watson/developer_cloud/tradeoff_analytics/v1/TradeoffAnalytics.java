/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class TradeoffAnalytics.
 */
public class TradeoffAnalytics extends WatsonService {

  private static final String GENERATE_VISUALIZATION = "GENERATE_VISUALIZATION";
  private static final String PATH_DILEMMAS = "/v1/dilemmas";
  private final static String URL = "https://gateway.watsonplatform.net/tradeoff-analytics/api";

  /**
   * Instantiates a new tradeoff analytics.
   */
  public TradeoffAnalytics() {
    super("tradeoff_analytics");
    setEndPoint(URL);
  }

  /**
   * Dilemmas.
   * 
   * @param problem the problem
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
   * @return the decision problem
   */
  public Dilemma dilemmas(final Problem problem, final Boolean generateVisualization) {
    if (problem == null)
      throw new IllegalArgumentException("problem was not specified");

    final String contentJson = GsonSingleton.getGson().toJson(problem);

    final RequestBuilder requestBuilder =
        RequestBuilder.post(PATH_DILEMMAS).withBodyContent(contentJson,
            HttpMediaType.APPLICATION_JSON);

    if (generateVisualization != null)
      requestBuilder.withQuery(GENERATE_VISUALIZATION, generateVisualization);

    return executeRequest(requestBuilder.build(), Dilemma.class);
  }
}

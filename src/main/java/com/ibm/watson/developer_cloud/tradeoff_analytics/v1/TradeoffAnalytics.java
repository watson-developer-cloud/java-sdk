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

import org.apache.commons.lang3.Validate;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Resolution;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class TradeoffAnalytics.
 */
public class TradeoffAnalytics extends WatsonService {

  private static final String GENERATE_VISUALIZATION = "generate_visualization";
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
   * Returns a dilemma that contains the {@link Problem} and a {@link Resolution}. The
   * {@link Problem} contains a set of options and objectives. The {@link Resolution} contains a set
   * of optimal options, their analytical characteristics, and by default their representation on a
   * 2D space. <br>
   * <br>
   * Here is an example of how to call the Tradeoff Analytics service with a Problem:
   * 
   * <pre>
   * TradeoffAnalytics service = new TradeoffAnalytics();
   * service.setUsernameAndPassword(&quot;USERNAME&quot;, &quot;PASSWORD&quot;);
   * Problem problem = new Problem(); // create the options and objectives here
   * Dilemma dilemma = service.dilemmas(problem, false);
   * </pre>
   * 
   * @param problem the decision problem
   * @return the dilemma
   */
  public Dilemma dilemmas(final Problem problem) {
    return dilemmas(problem, null);
  }

  /**
   * Returns a dilemma that contains the {@link Problem} and a {@link Resolution}. The
   * {@link Problem} contains a set of options and objectives. The {@link Resolution} contains a set
   * of optimal options, their analytical characteristics, and by default their representation on a
   * 2D space. <br>
   * <br>
   * Here is an example of how to call the Tradeoff Analytics service with a Problem:
   * 
   * <pre>
   * TradeoffAnalytics service = new TradeoffAnalytics();
   * service.setUsernameAndPassword(&quot;USERNAME&quot;, &quot;PASSWORD&quot;);
   * Problem problem = new Problem(); // create the options and objectives here
   * Dilemma dilemma = service.dilemmas(problem, false);
   * </pre>
   * 
   * @param problem the decision problem
   * @param generateVisualization if true the Dilemma contains information to generate visualization
   * @return the decision problem
   */
  public Dilemma dilemmas(final Problem problem, final Boolean generateVisualization) {
    Validate.notNull(problem, "problem was not specified");

    final String contentJson = GsonSingleton.getGsonWithoutPrettyPrinting().toJson(problem);

    final RequestBuilder requestBuilder =
        RequestBuilder.post(PATH_DILEMMAS).withBodyContent(contentJson,
            HttpMediaType.APPLICATION_JSON);

    if (generateVisualization != null)
      requestBuilder.withQuery(GENERATE_VISUALIZATION, generateVisualization);

    return executeRequest(requestBuilder.build(), Dilemma.class);
  }
}

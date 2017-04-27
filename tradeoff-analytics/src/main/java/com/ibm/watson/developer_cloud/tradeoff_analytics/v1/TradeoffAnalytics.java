/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Resolution;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The IBM Watson Tradeoff Analytics service applies decision analytics technology, enabling users to avoid choice
 * overload when making complex decisions involving multiple, conflicting goals.
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/tradeoff-analytics.html"> Tradeoff Analytics</a>
 */
public class TradeoffAnalytics extends WatsonService {

  private static final String GENERATE_VISUALIZATION = "generate_visualization";
  private static final String FIND_PREFERABLE_OPTIONS = "find_preferable_options";
  private static final String PATH_DILEMMAS = "/v1/dilemmas";
  private static final String SERVICE_NAME = "tradeoff_analytics";
  private static final String URL = "https://gateway.watsonplatform.net/tradeoff-analytics/api";

  /**
   * Instantiates a new tradeoff analytics.
   */
  public TradeoffAnalytics() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new tradeoff analytics service by username and password.
   *
   * @param username the username
   * @param password the password
   */
  public TradeoffAnalytics(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Returns a dilemma that contains the {@link Problem} and a {@link Resolution}. The {@link Problem} contains a set of
   * options and objectives. The {@link Resolution} contains a set of optimal options, their analytical characteristics,
   * and by default their representation on a 2D space. <br>
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
  public ServiceCall<Dilemma> dilemmas(final Problem problem) {
  return dilemmas(problem, null, null);
  }

  /**
   * Returns a dilemma that contains the {@link Problem} and a {@link Resolution}. The {@link Problem} contains a set of
   * options and objectives. The {@link Resolution} contains a set of optimal options, their analytical characteristics,
   * and by default their representation on a 2D space. <br>
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
  public ServiceCall<Dilemma> dilemmas(final Problem problem, final Boolean generateVisualization) {

  return dilemmas(problem, generateVisualization, null);
  }

  /**
   * Returns a dilemma that contains the {@link Problem} and a {@link Resolution}. The {@link Problem} contains a set of
   * options and objectives. The {@link Resolution} contains a set of optimal options, their analytical characteristics,
   * and by default their representation on a 2D space. <br>
   * <br>
   * Here is an example of how to call the Tradeoff Analytics service with a Problem:
   *
   * <pre>
   * TradeoffAnalytics service = new TradeoffAnalytics();
   * service.setUsernameAndPassword(&quot;USERNAME&quot;, &quot;PASSWORD&quot;);
   * Problem problem = new Problem(); // create the options and objectives here
   * Dilemma dilemma = service.dilemmas(problem, false, true);
   * </pre>
   *
   * @param problem the decision problem
   * @param generateVisualization if true the Dilemma contains information to generate visualization
   * @param findPreferableOptions if true the Dilemma includes a refined subset of best candidate options
   * that will most likely satisfy the greatest number of users.
   * @return the decision problem
   */

  public ServiceCall<Dilemma> dilemmas(
    final Problem problem,
    final Boolean generateVisualization,
    final Boolean findPreferableOptions) {
    Validator.notNull(problem, "problem was not specified");

    final String contentJson = GsonSingleton.getGsonWithoutPrettyPrinting().toJson(problem);

    final RequestBuilder requestBuilder =
        RequestBuilder.post(PATH_DILEMMAS).bodyContent(contentJson, HttpMediaType.APPLICATION_JSON);

    List<String> queryParams = new ArrayList<String>();
    if (generateVisualization != null) {
      queryParams.add(GENERATE_VISUALIZATION);
      queryParams.add(generateVisualization.toString());
    }
    if (findPreferableOptions != null) {
      queryParams.add(FIND_PREFERABLE_OPTIONS);
      queryParams.add(findPreferableOptions.toString());
    }

    requestBuilder.query(queryParams.toArray());

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Dilemma.class));
  }
}

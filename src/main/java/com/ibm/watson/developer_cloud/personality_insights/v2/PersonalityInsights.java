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
package com.ibm.watson.developer_cloud.personality_insights.v2;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RequestUtil;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;
import com.squareup.okhttp.Response;

/**
 * The Watson Personality Insights service uses linguistic analytics to extract a spectrum of
 * cognitive and social characteristics from the text data that a person generates through blogs,
 * tweets, forum posts, and more.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v2
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/personality-insights.html">
 *      Personality Insights</a>
 */
public class PersonalityInsights extends WatsonService {

  private static final String PATH_PROFILE = "/v2/profile";

  /** The Constant ACCEPT_LANGUAGE (value is "accept_language"). */
  public static final String ACCEPT_LANGUAGE = "accept_language";

  /** The Constant CONTENT (value is "content"). */
  public static final String CONTENT = "content";

  /** The Constant CSV (value is "csv"). */
  public static final String CSV = "csv";

  /** The Constant HEADERS (value is "headers"). */
  public static final String HEADERS = "headers";

  /** The Constant HTML (value is "html"). */
  public static final String HTML = "html";

  /** The Constant INCLUDE_RAW (value is "include_raw"). */
  public static final String INCLUDE_RAW = "include_raw";

  /** The Constant LANGUAGE (value is "language"). */
  public static final String LANGUAGE = "language";

  /** The Constant TEXT (value is "text"). */
  public static final String TEXT = "text";

  private static final String URL = "https://gateway.watsonplatform.net/personality-insights/api";

  /**
   * Instantiates a new Personality Insights service.
   */
  public PersonalityInsights() {
    super("personality_insights");
    setEndPoint(URL);
  }

  /**
   * Accepts text, html or {@link Content} and responds with a {@link Profile} with a tree of
   * characteristics that include personality, needs, and values.
   * 
   * @param parameters The parameters to be used in the service call text, html or content is
   *        required.
   *        <ul>
   *        <li>Content content - Content to analyze. See {@link ContentItem}.<br>
   *        <li>String text - The text to analyze.<br>
   *        <li>String html - The html to analyze.<br>
   *        <li>Boolean csv - If present the response will be CSV<br>
   *        <li>String headers - If true, column labels are returned with a CSV response.
   *        <li>Boolean include_raw - If true, a raw score for each characteristic is returned in
   *        addition to a normalized score.<br>
   *        <li>String accept_language - The desired language of the response.<br>
   *        <li>String language - The content language of the request. Both English ("en") and
   *        Spanish ("es") input content are supported.<br>
   *        </ul>
   * @return the {@link Profile}
   */
  public Profile getProfile(final Map<String, Object> parameters) {
    final String profile = getProfileAsString(RequestUtil.omit(parameters, CSV));
    return GsonSingleton.getGson().fromJson(profile, Profile.class);
  }

  /**
   * Accepts text and responds with a {@link Profile} with a tree of characteristics that include
   * personality, needs, and values.
   * 
   * @param text Text to analyze
   * 
   * @return The personality {@link Profile}
   */
  public Profile getProfile(final String text) {
    Validate.notEmpty(text, "text cannot be null or empty");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(TEXT, text);
    return getProfile(params);
  }

  /**
   * Accepts text, html or {@link Content} and responds with a CSV row with the personality profile.
   * 
   * @param parameters The parameters to be used in the service call text,html or content is
   *        required.
   *        <ul>
   *        <li>Content content - Content to analyze. See {@link ContentItem}.<br>
   *        <li>String text - The text to analyze.<br>
   *        <li>String html - The html to analyze.<br>
   *        <li>String headers - If true, column labels are returned with a CSV response.
   *        <li>Boolean include_raw - If true, a raw score for each characteristic is returned in
   *        addition to a normalized score.<br>
   *        <li>String accept_language - The desired language of the response.<br>
   *        <li>String language - The content language of the request. Both English ("en") and
   *        Spanish ("es") input content are supported.<br>
   *        </ul>
   * @return the profile as String
   */
  public String getProfileAsCSV(final Map<String, Object> parameters) {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.putAll(parameters);
    params.put(CSV, true);

    return getProfileAsString(params);
  }

  /**
   * Accepts text, html or {@link Content} and responds with a {@link Profile} as String. The
   * profile contains a tree of characteristics that include personality, needs, and values.
   * 
   * @param parameters The parameters to be used in the service call text,html or content is
   *        required.
   *        <ul>
   *        <li>Content content - Content to analyze. See {@link ContentItem}.<br>
   *        <li>String text - The text to analyze.<br>
   *        <li>String html - The html to analyze.<br>
   *        <li>Boolean csv - If present the response will be CSV<br>
   *        <li>String headers - If true, column labels are returned with a CSV response.
   *        <li>Boolean include_raw - If true, a raw score for each characteristic is returned in
   *        addition to a normalized score.<br>
   *        <li>String accept_language - The desired language of the response.<br>
   *        <li>String language - The content language of the request. Both English ("en") and
   *        Spanish ("es") input content are supported.<br>
   *        </ul>
   * @return the profile as String
   */
  public String getProfileAsString(final Map<String, Object> parameters) {
    if (!parameters.containsKey(TEXT) && !parameters.containsKey(HTML)
        && !parameters.containsKey(CONTENT))
      throw new IllegalArgumentException("text, html or content need to be specified");

    final RequestBuilder request = RequestBuilder.post(PATH_PROFILE);

    if (parameters.containsKey(TEXT)) {
      request.withBodyContent(parameters.get(TEXT).toString(), HttpMediaType.TEXT_PLAIN);
    } else if (parameters.containsKey(HTML)) {
      request.withBodyContent(parameters.get(HTML).toString(), HttpMediaType.TEXT_HTML);
    } else {
      final String contentJson = GsonSingleton.getGson().toJson(parameters.get(CONTENT));
      request.withBodyContent(contentJson, HttpMediaType.APPLICATION_JSON);
    }

    if (parameters.containsKey(CSV)) {
      request.withHeader(HttpHeaders.ACCEPT, HttpMediaType.TEXT_CSV);

      if (parameters.containsKey(HEADERS))
        request.withQuery(HEADERS, parameters.get(HEADERS));
    }

    if (parameters.containsKey(INCLUDE_RAW))
      request.withQuery(INCLUDE_RAW, parameters.get(INCLUDE_RAW));

    if (parameters.containsKey(LANGUAGE))
      request.withHeader(HttpHeaders.CONTENT_LANGUAGE, parameters.get(LANGUAGE));

    if (parameters.containsKey(ACCEPT_LANGUAGE))
      request.withHeader(HttpHeaders.ACCEPT_LANGUAGE, parameters.get(ACCEPT_LANGUAGE));

    final Response response = execute(request.build());
    return ResponseUtil.getString(response);
  }

}

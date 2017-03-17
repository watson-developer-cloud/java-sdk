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
package com.ibm.watson.developer_cloud.personality_insights.v3;

import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The Watson Personality Insights service uses linguistic analytics to extract a spectrum of cognitive and social
 * characteristics from the text data that a person generates through blogs, tweets, forum posts, and more.
 *
 * @version v3
 * @see <a href= "http://www.ibm.com/watson/developercloud/personality-insights.html"> Personality Insights</a>
 */
public class PersonalityInsights extends WatsonService {
  private static final String SERVICE_NAME = "personality_insights";
  private static final String PATH_PROFILE = "/v3/profile";
  private static final String RAW_SCORES = "raw_scores";
  private static final String URL = "https://gateway.watsonplatform.net/personality-insights/api";
  private static final String HEADERS = "headers";
  private static final String CONSUMPTION_PREFERENCES = "consumption_preferences";
  private String versionDate;

  /** The Constant VERSION_DATE_2016_10_19. */
  public static final String VERSION_DATE_2016_10_19 = "2016-10-19";

  /**
   * Instantiates a new Personality Insights service.
   *
   * @param versionDate the version date
   */
  public PersonalityInsights(final String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2016_10_19);
    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new personality insights service by username and password.
   *
   * @param versionDate the version date
   * @param username the username
   * @param password the password
   */
  public PersonalityInsights(final String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  private RequestBuilder buildProfileRequest(ProfileOptions options) {
    Validator.notNull(options, "options cannot be null");
    Validator.isTrue((options.text() != null) || (options.contentItems() != null),
        "text, html or content items need to be specified");

    final String contentType = options.contentType();

    final RequestBuilder request = RequestBuilder.post(PATH_PROFILE);

    request.query(VERSION, versionDate);

    if (options.text() != null) {
      request.header(HttpHeaders.CONTENT_TYPE, contentType);
      request.bodyContent(options.text(), contentType);
    } else {
      final Content content = new Content();
      content.setContentItems(options.contentItems());
      String body = GsonSingleton.getGson().toJson(content);
      request.bodyContent(body, contentType);
    }

    if (options.rawScores() != null) {
      request.query(RAW_SCORES, options.rawScores());
    }

    if (options.consumptionPreferences() != null) {
      request.query(CONSUMPTION_PREFERENCES, options.consumptionPreferences());
    }

    if (options.language() != null) {
      request.header(HttpHeaders.CONTENT_LANGUAGE, options.language());
    }

    if (options.acceptLanguage() != null) {
      request.header(HttpHeaders.ACCEPT_LANGUAGE, options.acceptLanguage());
    }

    return request;
  }

  /**
   * Accepts text and responds with a {@link Profile} with a tree of characteristics that include personality, needs,
   * and values. <br>
   * <br>
   *
   * @param text Text to analyze
   *
   * @return The personality {@link Profile}
   */
  public ServiceCall<Profile> getProfile(final String text) {
    Validator.notEmpty(text, "text cannot be null or empty");

    final ProfileOptions options = new ProfileOptions.Builder().text(text).build();
    final RequestBuilder requestBuilder = buildProfileRequest(options);
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Profile.class));
  }

  /**
   * Returns a {@link Profile} with a tree of characteristics that include personality, needs, and values. <br>
   * <br>
   * Here is an example of how to get the personality profile given some {@link ProfileOptions}:
   *
   * @param options the {@link ProfileOptions}
   * @return The personality {@link Profile}
   */
  public ServiceCall<Profile> getProfile(final ProfileOptions options) {
    final RequestBuilder requestBuilder = buildProfileRequest(options);
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Profile.class));
  }

  /**
   * Returns a CSV profile.
   *
   * @param options the {@link ProfileOptions}
   * @param includeHeaders if true returns the CSV headers
   * @return the CSV profile
   */
  public ServiceCall<String> getProfileAsCSV(final ProfileOptions options, final boolean includeHeaders) {
    final RequestBuilder requestBuilder = buildProfileRequest(options);

    requestBuilder.header(HttpHeaders.ACCEPT, HttpMediaType.TEXT_CSV);
    requestBuilder.query(HEADERS, includeHeaders);
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getString());
  }

}

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

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.TimestampTypeAdapter;
import com.ibm.watson.developer_cloud.util.Validate;
import com.squareup.okhttp.Response;

/**
 * The Watson Personality Insights service uses linguistic analytics to extract a spectrum of
 * cognitive and social characteristics from the text data that a person generates through blogs,
 * tweets, forum posts, and more.
 * 
 * @version v2
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/personality-insights.html">
 *      Personality Insights</a>
 */
public class PersonalityInsights extends WatsonService {

  private static final String PATH_PROFILE = "/v2/profile";

  /** The Constant INCLUDE_RAW (value is "include_raw"). */
  private static final String INCLUDE_RAW = "include_raw";

  private static final String URL = "https://gateway.watsonplatform.net/personality-insights/api";

  private static final Gson gson =
      new GsonBuilder().registerTypeAdapter(Date.class, new TimestampTypeAdapter()).create();

  /** The Constant HEADERS (value is "headers"). */
  private static final String HEADERS = "headers";

  /**
   * Instantiates a new Personality Insights service.
   */
  public PersonalityInsights() {
    super("personality_insights");
    setEndPoint(URL);
  }

  private RequestBuilder buildProfileRequest(ProfileOptions options) {
    Validate.notNull(options, "options cannot be null");
    Validate.isTrue(options.getText() != null || options.getContentItems() != null,
        "text, html or content items need to be specified");

    final String contentType = options.getContentType();

    final RequestBuilder request = RequestBuilder.post(PATH_PROFILE);

    if (options.getText() != null) {
      request.withBodyContent(options.getText(), contentType);
    } else {
      final Content content = new Content();
      content.setContentItems(options.getContentItems());
      String body = gson.toJson(content);
      request.withBodyContent(body, contentType);
    }

    if (options.getIncludeRaw() != null)
      request.withQuery(INCLUDE_RAW, options.getIncludeRaw());

    if (options.getLanguage() != null)
      request.withHeader(HttpHeaders.CONTENT_LANGUAGE, options.getLanguage());

    if (options.getAcceptLanguage() != null)
      request.withHeader(HttpHeaders.ACCEPT_LANGUAGE, options.getAcceptLanguage());

    return request;
  }

  /**
   * Accepts text and responds with a {@link Profile} with a tree of characteristics that include
   * personality, needs, and values. <br>
   * <br>
   * Here is an example of how to get the personality profile given some text:
   * 
   * <pre>
   *     PersonalityInsights service = new PersonalityInsights();
   *     service.setUsernameAndPassword("username", "password");
   * 
   *     String text = "write the text with at least 100 unique words here..."
   *     Profile profile = service.getProfile(text);
   *     System.out.println(profile);
   * </pre>
   * 
   * @param text Text to analyze
   * 
   * @return The personality {@link Profile}
   */
  public Profile getProfile(final String text) {
    Validate.notEmpty(text, "text cannot be null or empty");

    final ProfileOptions options = new ProfileOptions().text(text);
    final RequestBuilder requestBuilder = buildProfileRequest(options);
    return executeRequest(requestBuilder.build(), Profile.class);
  }

  /**
   * Returns a {@link Profile} with a tree of characteristics that include personality, needs, and
   * values. <br>
   * <br>
   * Here is an example of how to get the personality profile given some {@link ProfileOptions}:
   * 
   * <pre>
   *     PersonalityInsights service = new PersonalityInsights();
   *     service.setUsernameAndPassword("username", "password");
   * 
   *     String text = "write the text with at least 100 unique words here..."
   *     ContentItem cItem = new ContentItem().content(text).created(new Date());
   *     ProfileOptions options = new ProfileOptions().contentItems(Arrays.asList(cItem));
   * 
   *     Profile profile = service.getProfile(options);
   * 
   *     System.out.println(profile);
   * </pre>
   * 
   * @param options the {@link ProfileOptions}
   * @return The personality {@link Profile}
   */
  public Profile getProfile(final ProfileOptions options) {
    final RequestBuilder requestBuilder = buildProfileRequest(options);
    return executeRequest(requestBuilder.build(), Profile.class);
  }

  /**
   * Returns a CSV profile.
   * 
   * @param options the {@link ProfileOptions}
   * @param includeHeaders if true returns the CSV headers
   * @return the CSV profile
   */
  public String getProfileAsCSV(final ProfileOptions options, final boolean includeHeaders) {
    final RequestBuilder requestBuilder = buildProfileRequest(options);

    requestBuilder.withHeader(HttpHeaders.ACCEPT, HttpMediaType.TEXT_CSV);
    requestBuilder.withQuery(HEADERS, includeHeaders);
    final Response response = execute(requestBuilder.build());
    return ResponseUtil.getString(response);
  }

}

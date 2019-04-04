/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import java.io.InputStream;

/**
 * The IBM Watson&trade; Personality Insights service enables applications to derive insights from social media,
 * enterprise data, or other digital communications. The service uses linguistic analytics to infer individuals'
 * intrinsic personality characteristics, including Big Five, Needs, and Values, from digital communications such as
 * email, text messages, tweets, and forum posts.
 *
 * The service can automatically infer, from potentially noisy social media, portraits of individuals that reflect their
 * personality characteristics. The service can infer consumption preferences based on the results of its analysis and,
 * for JSON content that is timestamped, can report temporal behavior.
 * * For information about the meaning of the models that the service uses to describe personality characteristics, see
 * [Personality models](https://cloud.ibm.com/docs/services/personality-insights/models.html).
 * * For information about the meaning of the consumption preferences, see [Consumption
 * preferences](https://cloud.ibm.com/docs/services/personality-insights/preferences.html).
 *
 * **Note:** Request logging is disabled for the Personality Insights service. Regardless of whether you set the
 * `X-Watson-Learning-Opt-Out` request header, the service does not log or retain data from requests and responses.
 *
 * @version v3
 * @see <a href="http://www.ibm.com/watson/developercloud/personality-insights.html">Personality Insights</a>
 * @deprecated For v7.x.x and beyond, the Java SDK will be available at com.ibm.watson:ibm-watson. To get updates,
 * please use this new location. See the SDK GitHub repository for more information:
 * https://github.com/watson-developer-cloud/java-sdk
 */
@Deprecated
public class PersonalityInsights extends WatsonService {

  private static final String SERVICE_NAME = "personality_insights";
  private static final String URL = "https://gateway.watsonplatform.net/personality-insights/api";

  private String versionDate;

  /**
   * Instantiates a new `PersonalityInsights`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public PersonalityInsights(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `PersonalityInsights` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public PersonalityInsights(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Instantiates a new `PersonalityInsights` with IAM. Note that if the access token is specified in the
   * iamOptions, you accept responsibility for managing the access token yourself. You must set a new access token
   * before this
   * one expires or after receiving a 401 error from the service. Failing to do so will result in authentication errors
   * after this token expires.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param iamOptions the options for authenticating through IAM
   */
  public PersonalityInsights(String versionDate, IamOptions iamOptions) {
    this(versionDate);
    setIamCredentials(iamOptions);
  }

  /**
   * Get profile.
   *
   * Generates a personality profile for the author of the input text. The service accepts a maximum of 20 MB of input
   * content, but it requires much less text to produce an accurate profile. The service can analyze text in Arabic,
   * English, Japanese, Korean, or Spanish. It can return its results in a variety of languages.
   *
   * **See also:**
   * * [Requesting a profile](https://cloud.ibm.com/docs/services/personality-insights/input.html)
   * * [Providing sufficient input](https://cloud.ibm.com/docs/services/personality-insights/input.html#sufficient)
   *
   * ### Content types
   *
   * You can provide input content as plain text (`text/plain`), HTML (`text/html`), or JSON (`application/json`) by
   * specifying the **Content-Type** parameter. The default is `text/plain`.
   * * Per the JSON specification, the default character encoding for JSON content is effectively always UTF-8.
   * * Per the HTTP specification, the default encoding for plain text and HTML is ISO-8859-1 (effectively, the ASCII
   * character set).
   *
   * When specifying a content type of plain text or HTML, include the `charset` parameter to indicate the character
   * encoding of the input text; for example, `Content-Type: text/plain;charset=utf-8`.
   *
   * **See also:** [Specifying request and response
   * formats](https://cloud.ibm.com/docs/services/personality-insights/input.html#formats)
   *
   * ### Accept types
   *
   * You must request a response as JSON (`application/json`) or comma-separated values (`text/csv`) by specifying the
   * **Accept** parameter. CSV output includes a fixed number of columns. Set the **csv_headers** parameter to `true` to
   * request optional column headers for CSV output.
   *
   * **See also:**
   * * [Understanding a JSON profile](https://cloud.ibm.com/docs/services/personality-insights/output.html)
   * * [Understanding a CSV profile](https://cloud.ibm.com/docs/services/personality-insights/output-csv.html).
   *
   * @param profileOptions the {@link ProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Profile}
   */
  public ServiceCall<Profile> profile(ProfileOptions profileOptions) {
    Validator.notNull(profileOptions, "profileOptions cannot be null");
    String[] pathSegments = { "v3/profile" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=personality_insights;service_version=v3;operation_id=profile");
    if (profileOptions.contentType() != null) {
      builder.header("Content-Type", profileOptions.contentType());
    }
    if (profileOptions.contentLanguage() != null) {
      builder.header("Content-Language", profileOptions.contentLanguage());
    }
    if (profileOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", profileOptions.acceptLanguage());
    }
    if (profileOptions.rawScores() != null) {
      builder.query("raw_scores", String.valueOf(profileOptions.rawScores()));
    }
    if (profileOptions.consumptionPreferences() != null) {
      builder.query("consumption_preferences", String.valueOf(profileOptions.consumptionPreferences()));
    }
    builder.bodyContent(profileOptions.contentType(), profileOptions.content(), null, profileOptions.body());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Profile.class));
  }

  /**
   * Get profile as csv.
   *
   * Generates a personality profile for the author of the input text. The service accepts a maximum of 20 MB of input
   * content, but it requires much less text to produce an accurate profile. The service can analyze text in Arabic,
   * English, Japanese, Korean, or Spanish. It can return its results in a variety of languages.
   *
   * **See also:**
   * * [Requesting a profile](https://cloud.ibm.com/docs/services/personality-insights/input.html)
   * * [Providing sufficient input](https://cloud.ibm.com/docs/services/personality-insights/input.html#sufficient)
   *
   * ### Content types
   *
   * You can provide input content as plain text (`text/plain`), HTML (`text/html`), or JSON (`application/json`) by
   * specifying the **Content-Type** parameter. The default is `text/plain`.
   * * Per the JSON specification, the default character encoding for JSON content is effectively always UTF-8.
   * * Per the HTTP specification, the default encoding for plain text and HTML is ISO-8859-1 (effectively, the ASCII
   * character set).
   *
   * When specifying a content type of plain text or HTML, include the `charset` parameter to indicate the character
   * encoding of the input text; for example, `Content-Type: text/plain;charset=utf-8`.
   *
   * **See also:** [Specifying request and response
   * formats](https://cloud.ibm.com/docs/services/personality-insights/input.html#formats)
   *
   * ### Accept types
   *
   * You must request a response as JSON (`application/json`) or comma-separated values (`text/csv`) by specifying the
   * **Accept** parameter. CSV output includes a fixed number of columns. Set the **csv_headers** parameter to `true` to
   * request optional column headers for CSV output.
   *
   * **See also:**
   * * [Understanding a JSON profile](https://cloud.ibm.com/docs/services/personality-insights/output.html)
   * * [Understanding a CSV profile](https://cloud.ibm.com/docs/services/personality-insights/output-csv.html).
   *
   * @param profileOptions the {@link ProfileOptions} containing the options for the call
   * @param includeHeaders the boolean saying whether or not to include headers in the response
   * @return a {@link ServiceCall} with a response type of {@link InputStream}
   */
  public ServiceCall<InputStream> profileAsCsv(ProfileOptions profileOptions, boolean includeHeaders) {
    Validator.notNull(profileOptions, "profileOptions cannot be null");
    String[] pathSegments = { "v3/profile" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=personality_insights;service_version=v3;operation_id=profileAsCsv");
    if (profileOptions.contentType() != null) {
      builder.header("Content-Type", profileOptions.contentType());
    }
    if (profileOptions.contentLanguage() != null) {
      builder.header("Content-Language", profileOptions.contentLanguage());
    }
    if (profileOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", profileOptions.acceptLanguage());
    }
    if (profileOptions.rawScores() != null) {
      builder.query("raw_scores", String.valueOf(profileOptions.rawScores()));
    }
    if (profileOptions.consumptionPreferences() != null) {
      builder.query("consumption_preferences", String.valueOf(profileOptions.consumptionPreferences()));
    }

    builder.header(HttpHeaders.ACCEPT, HttpMediaType.TEXT_CSV);
    builder.query("csv_headers", includeHeaders);

    builder.bodyContent(profileOptions.contentType(), profileOptions.content(), null, profileOptions.body());
    return createServiceCall(builder.build(), ResponseConverterUtils.getInputStream());
  }

}

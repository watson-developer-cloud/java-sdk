/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.personality_insights.v3;

import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.personality_insights.v3.model.Profile;
import com.ibm.watson.personality_insights.v3.model.ProfileOptions;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

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
 * [Personality
 * models](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-models#models).
 * * For information about the meaning of the consumption preferences, see [Consumption
 * preferences]
 * (https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-preferences#preferences).
 *
 *
 * **Note:** Request logging is disabled for the Personality Insights service. Regardless of whether you set the
 * `X-Watson-Learning-Opt-Out` request header, the service does not log or retain data from requests and responses.
 *
 * @version v3
 * @see <a href="https://cloud.ibm.com/docs/services/personality-insights/">Personality Insights</a>
 */
public class PersonalityInsights extends BaseService {

  private static final String SERVICE_NAME = "personality_insights";
  private static final String SERVICE_URL = "https://gateway.watsonplatform.net/personality-insights/api";

  private String versionDate;

  /**
   * Constructs a new `PersonalityInsights` client.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public PersonalityInsights(String versionDate) {
    this(versionDate, ConfigBasedAuthenticatorFactory.getAuthenticator(SERVICE_NAME));
  }

  /**
   * Constructs a new `PersonalityInsights` client with the specified Authenticator.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public PersonalityInsights(String versionDate, Authenticator authenticator) {
    super(SERVICE_NAME, authenticator);
    if ((getServiceUrl() == null) || getServiceUrl().isEmpty()) {
      setServiceUrl(SERVICE_URL);
    }
    com.ibm.cloud.sdk.core.util.Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "version cannot be null.");
    this.versionDate = versionDate;
  }

  /**
   * Get profile.
   *
   * Generates a personality profile for the author of the input text. The service accepts a maximum of 20 MB of input
   * content, but it requires much less text to produce an accurate profile. The service can analyze text in Arabic,
   * English, Japanese, Korean, or Spanish. It can return its results in a variety of languages.
   *
   * **See also:**
   * * [Requesting a
   * profile](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-input#input)
   * * [Providing sufficient
   * input](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-input#sufficient)
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
   * formats](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-input#formats)
   *
   * ### Accept types
   *
   * You must request a response as JSON (`application/json`) or comma-separated values (`text/csv`) by specifying the
   * **Accept** parameter. CSV output includes a fixed number of columns. Set the **csv_headers** parameter to `true` to
   * request optional column headers for CSV output.
   *
   * **See also:**
   * * [Understanding a JSON
   * profile](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-output#output)
   * * [Understanding a CSV
   * profile](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-outputCSV#outputCSV).
   *
   * @param profileOptions the {@link ProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Profile}
   */
  public ServiceCall<Profile> profile(ProfileOptions profileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(profileOptions,
        "profileOptions cannot be null");
    String[] pathSegments = { "v3/profile" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("personality_insights", "v3", "profile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
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
    if (profileOptions.csvHeaders() != null) {
      builder.query("csv_headers", String.valueOf(profileOptions.csvHeaders()));
    }
    if (profileOptions.consumptionPreferences() != null) {
      builder.query("consumption_preferences", String.valueOf(profileOptions.consumptionPreferences()));
    }
    builder.bodyContent(profileOptions.contentType(), profileOptions.content(),
        null, profileOptions.body());
    ResponseConverter<Profile> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Profile>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get profile as csv.
   *
   * Generates a personality profile for the author of the input text. The service accepts a maximum of 20 MB of input
   * content, but it requires much less text to produce an accurate profile. The service can analyze text in Arabic,
   * English, Japanese, Korean, or Spanish. It can return its results in a variety of languages.
   *
   * **See also:**
   * * [Requesting a
   * profile](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-input#input)
   * * [Providing sufficient
   * input](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-input#sufficient)
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
   * formats](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-input#formats)
   *
   * ### Accept types
   *
   * You must request a response as JSON (`application/json`) or comma-separated values (`text/csv`) by specifying the
   * **Accept** parameter. CSV output includes a fixed number of columns. Set the **csv_headers** parameter to `true` to
   * request optional column headers for CSV output.
   *
   * **See also:**
   * * [Understanding a JSON
   * profile](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-output#output)
   * * [Understanding a CSV
   * profile](https://cloud.ibm.com/docs/services/personality-insights?topic=personality-insights-outputCSV#outputCSV).
   *
   * @param profileOptions the {@link ProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link String}
   */
  public ServiceCall<InputStream> profileAsCsv(ProfileOptions profileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(profileOptions,
        "profileOptions cannot be null");
    String[] pathSegments = { "v3/profile" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("personality_insights", "v3", "profileAsCsv");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "text/csv");
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
    if (profileOptions.csvHeaders() != null) {
      builder.query("csv_headers", String.valueOf(profileOptions.csvHeaders()));
    }
    if (profileOptions.consumptionPreferences() != null) {
      builder.query("consumption_preferences", String.valueOf(profileOptions.consumptionPreferences()));
    }
    builder.bodyContent(profileOptions.contentType(), profileOptions.content(),
        null, profileOptions.body());
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

}

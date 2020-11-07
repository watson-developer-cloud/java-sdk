/*
 * (C) Copyright IBM Corp. 2020.
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

/*
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-7cc05500-20201106-154555
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
 * The IBM Watson&amp;trade; Personality Insights service enables applications to derive insights
 * from social media, enterprise data, or other digital communications. The service uses linguistic
 * analytics to infer individuals' intrinsic personality characteristics, including Big Five, Needs,
 * and Values, from digital communications such as email, text messages, tweets, and forum posts.
 *
 * <p>The service can automatically infer, from potentially noisy social media, portraits of
 * individuals that reflect their personality characteristics. The service can infer consumption
 * preferences based on the results of its analysis and, for JSON content that is timestamped, can
 * report temporal behavior. * For information about the meaning of the models that the service uses
 * to describe personality characteristics, see [Personality
 * models](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-models#models).
 * * For information about the meaning of the consumption preferences, see [Consumption
 * preferences](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-preferences#preferences).
 *
 * <p>**Note:** Request logging is disabled for the Personality Insights service. Regardless of
 * whether you set the `X-Watson-Learning-Opt-Out` request header, the service does not log or
 * retain data from requests and responses.
 *
 * @version v3
 * @see <a href="https://cloud.ibm.com/docs/personality-insights">Personality Insights</a>
 */
public class PersonalityInsights extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "personality_insights";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.personality-insights.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `PersonalityInsights` client. The default service name is used to
   * configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2017-10-13`.
   */
  public PersonalityInsights(String version) {
    this(
        version,
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `PersonalityInsights` client. The default service name and
   * specified authenticator are used to configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2017-10-13`.
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public PersonalityInsights(String version, Authenticator authenticator) {
    this(version, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `PersonalityInsights` client. The specified service name is used
   * to configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2017-10-13`.
   * @param serviceName the service name to be used when configuring the client instance
   */
  public PersonalityInsights(String version, String serviceName) {
    this(version, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `PersonalityInsights` client. The specified service name and
   * authenticator are used to configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2017-10-13`.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public PersonalityInsights(String version, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setVersion(version);
    this.configureService(serviceName);

    System.err.println(
        "On 1 December 2021, Personality Insights will no longer be available."
            + " Consider migrating to Watson Natural Language Understanding."
            + "\nFor more information, see Personality Insights Deprecation "
            + "(https://github.com/watson-developer-cloud/java-sdk/tree/master#personality-insights-deprecation).");
  }

  /**
   * Gets the version.
   *
   * <p>Release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * The current version is `2017-10-13`.
   *
   * @return the version
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(final String version) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(version, "version cannot be empty.");
    this.version = version;
  }

  /**
   * Get profile.
   *
   * <p>Generates a personality profile for the author of the input text. The service accepts a
   * maximum of 20 MB of input content, but it requires much less text to produce an accurate
   * profile. The service can analyze text in Arabic, English, Japanese, Korean, or Spanish. It can
   * return its results in a variety of languages.
   *
   * <p>**See also:** * [Requesting a
   * profile](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-input#input)
   * * [Providing sufficient
   * input](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-input#sufficient)
   *
   * <p>### Content types
   *
   * <p>You can provide input content as plain text (`text/plain`), HTML (`text/html`), or JSON
   * (`application/json`) by specifying the **Content-Type** parameter. The default is `text/plain`.
   * * Per the JSON specification, the default character encoding for JSON content is effectively
   * always UTF-8. * Per the HTTP specification, the default encoding for plain text and HTML is
   * ISO-8859-1 (effectively, the ASCII character set).
   *
   * <p>When specifying a content type of plain text or HTML, include the `charset` parameter to
   * indicate the character encoding of the input text; for example, `Content-Type:
   * text/plain;charset=utf-8`.
   *
   * <p>**See also:** [Specifying request and response
   * formats](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-input#formats)
   *
   * <p>### Accept types
   *
   * <p>You must request a response as JSON (`application/json`) or comma-separated values
   * (`text/csv`) by specifying the **Accept** parameter. CSV output includes a fixed number of
   * columns. Set the **csv_headers** parameter to `true` to request optional column headers for CSV
   * output.
   *
   * <p>**See also:** * [Understanding a JSON
   * profile](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-output#output)
   * * [Understanding a CSV
   * profile](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-outputCSV#outputCSV).
   *
   * @param profileOptions the {@link ProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> profile(ProfileOptions profileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(profileOptions, "profileOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/profile"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("personality_insights", "v3", "profile");
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
    builder.query("version", String.valueOf(this.version));
    if (profileOptions.rawScores() != null) {
      builder.query("raw_scores", String.valueOf(profileOptions.rawScores()));
    }
    if (profileOptions.csvHeaders() != null) {
      builder.query("csv_headers", String.valueOf(profileOptions.csvHeaders()));
    }
    if (profileOptions.consumptionPreferences() != null) {
      builder.query(
          "consumption_preferences", String.valueOf(profileOptions.consumptionPreferences()));
    }
    builder.bodyContent(
        profileOptions.contentType(), profileOptions.content(), null, profileOptions.body());
    ResponseConverter<Profile> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Profile>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get profile as csv.
   *
   * <p>Generates a personality profile for the author of the input text. The service accepts a
   * maximum of 20 MB of input content, but it requires much less text to produce an accurate
   * profile. The service can analyze text in Arabic, English, Japanese, Korean, or Spanish. It can
   * return its results in a variety of languages.
   *
   * <p>**See also:** * [Requesting a
   * profile](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-input#input)
   * * [Providing sufficient
   * input](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-input#sufficient)
   *
   * <p>### Content types
   *
   * <p>You can provide input content as plain text (`text/plain`), HTML (`text/html`), or JSON
   * (`application/json`) by specifying the **Content-Type** parameter. The default is `text/plain`.
   * * Per the JSON specification, the default character encoding for JSON content is effectively
   * always UTF-8. * Per the HTTP specification, the default encoding for plain text and HTML is
   * ISO-8859-1 (effectively, the ASCII character set).
   *
   * <p>When specifying a content type of plain text or HTML, include the `charset` parameter to
   * indicate the character encoding of the input text; for example, `Content-Type:
   * text/plain;charset=utf-8`.
   *
   * <p>**See also:** [Specifying request and response
   * formats](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-input#formats)
   *
   * <p>### Accept types
   *
   * <p>You must request a response as JSON (`application/json`) or comma-separated values
   * (`text/csv`) by specifying the **Accept** parameter. CSV output includes a fixed number of
   * columns. Set the **csv_headers** parameter to `true` to request optional column headers for CSV
   * output.
   *
   * <p>**See also:** * [Understanding a JSON
   * profile](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-output#output)
   * * [Understanding a CSV
   * profile](https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-outputCSV#outputCSV).
   *
   * @param profileOptions the {@link ProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link String}
   */
  public ServiceCall<InputStream> profileAsCsv(ProfileOptions profileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(profileOptions, "profileOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/profile"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("personality_insights", "v3", "profileAsCsv");
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
    builder.query("version", String.valueOf(this.version));
    if (profileOptions.rawScores() != null) {
      builder.query("raw_scores", String.valueOf(profileOptions.rawScores()));
    }
    if (profileOptions.csvHeaders() != null) {
      builder.query("csv_headers", String.valueOf(profileOptions.csvHeaders()));
    }
    if (profileOptions.consumptionPreferences() != null) {
      builder.query(
          "consumption_preferences", String.valueOf(profileOptions.consumptionPreferences()));
    }
    builder.bodyContent(
        profileOptions.contentType(), profileOptions.content(), null, profileOptions.body());
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }
}

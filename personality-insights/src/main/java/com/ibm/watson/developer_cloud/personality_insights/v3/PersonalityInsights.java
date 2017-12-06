/*
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

import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * ### Service Overview
 * The IBM Watson Personality Insights service provides a Representational State Transfer (REST) Application Programming
 * Interface (API) that enables applications to derive insights from social media, enterprise data, or other digital
 * communications. The service uses linguistic analytics to infer individuals' intrinsic personality characteristics,
 * including Big Five, Needs, and Values, from digital communications such as email, text messages, tweets, and forum
 * posts. The service can automatically infer, from potentially noisy social media, portraits of individuals that
 * reflect their personality characteristics. The service can report consumption preferences based on the results of its
 * analysis, and for JSON content that is timestamped, it can report temporal behavior.
 * ### API Usage
 * The following information provides details about using the service to obtain a personality profile:
 * * **The profile method:** The service offers a single `/v3/profile` method that accepts up to 20 MB of input data and
 * produces results in JSON or CSV format. The service accepts input in Arabic, English, Japanese, Korean, or Spanish
 * and can produce output in a variety of languages.
 * * **Authentication:** You authenticate to the service by using your service credentials. You can use your credentials
 * to authenticate via a proxy server that resides in IBM Cloud, or you can use your credentials to obtain a token and
 * contact the service directly. See [Service credentials for Watson
 * services](https://console.bluemix.net/docs/services/watson/getting-started-credentials.html) and [Tokens for
 * authentication](https://console.bluemix.net/docs/services/watson/getting-started-tokens.html).
 * * **Request Logging:** By default, all Watson services log requests and their results. Data is collected only to
 * improve the Watson services. If you do not want to share your data, set the header parameter
 * `X-Watson-Learning-Opt-Out` to `true` for each request. Data is collected for any request that omits this header. See
 * [Controlling request logging for Watson
 * services](https://console.bluemix.net/docs/services/watson/getting-started-logging.html).
 *
 * For more information about the service, see [About Personality
 * Insights](https://console.bluemix.net/docs/services/personality-insights/index.html). For information about calling
 * the service and the responses it can generate, see [Requesting a
 * profile](https://console.bluemix.net/docs/services/personality-insights/input.html), [Understanding a JSON
 * profile](https://console.bluemix.net/docs/services/personality-insights/output.html), and [Understanding a CSV
 * profile](https://console.bluemix.net/docs/services/personality-insights/output-csv.html).
 *
 * @version v3
 * @see <a href="http://www.ibm.com/watson/developercloud/personality-insights.html">Personality Insights</a>
 */
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

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null.");

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
   * Generates a personality profile based on input text.
   *
   * Derives personality insights for up to 20 MB of input content written by an author, though the service requires
   * much less text to produce an accurate profile; for more information, see [Providing sufficient
   * input](https://console.bluemix.net/docs/services/personality-insights/input.html#sufficient). Accepts input in
   * Arabic, English, Japanese, Korean, or Spanish and produces output in one of eleven languages. Provide plain text,
   * HTML, or JSON content, and receive results in JSON or CSV format.
   *
   * @param profileOptions the {@link ProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Profile}
   */
  public ServiceCall<Profile> profile(ProfileOptions profileOptions) {
    Validator.notNull(profileOptions, "profileOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v3/profile");
    builder.query(VERSION, versionDate);
    builder.header("Content-Type", profileOptions.contentType());
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
    if (profileOptions.contentType().equalsIgnoreCase(ProfileOptions.ContentType.APPLICATION_JSON)) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(profileOptions.content()).getAsJsonObject());
    } else {
      builder.bodyContent(profileOptions.body(), profileOptions.contentType());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Profile.class));
  }

}

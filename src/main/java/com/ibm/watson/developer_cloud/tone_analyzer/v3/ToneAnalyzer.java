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
package com.ibm.watson.developer_cloud.tone_analyzer.v3;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tone_analyzer.v3_beta.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.Request;

/**
 * The IBM Watson Tone Analyzer service uses linguistic analysis to detect emotional tones, social
 * propensities, and writing styles in written communication. Then it offers suggestions to help the
 * writer improve their intended language tones.
 * 
 * @version v3
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/tone-analyzer.html"> Tone
 *      Analyzer</a>
 */
public class ToneAnalyzer extends WatsonService {

  private static final String PATH_TONE = "/v3/tone";
  private static final String SERVICE_NAME = "tone_analyzer";
  private static final String TEXT = "text";
  private static final String URL = "https://gateway.watsonplatform.net/tone-analyzer/api";
  private static final String VERSION_DATE = "version";
  /** Version date. */
  public static final String VERSION_DATE_2016_05_19 = "2016-05-19";

  private String versionDate;


  /**
   * Instantiates a new tone analyzer.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
   *        will keep your API calls from failing when the service introduces breaking changes.
   */
  public ToneAnalyzer(String versionDate) {
    super(SERVICE_NAME);
    setEndPoint(URL);
    this.versionDate = versionDate;
  }



  /**
   * Analyzes the "tone" of a piece of text. The message is analyzed from several tones (social
   * tone, emotional tone, writing tone), and for each of them various traits are derived (such as
   * conscientiousness, agreeableness, openness).
   * 
   * @param text The text to analyze
   * @param sentences
   * @return the {@link ToneAnalysis} with the response
   * 
   */
  public ServiceCall<ToneAnalysis> getTone(final String text, boolean sentences) {
    Validator.isTrue(text != null && !text.isEmpty(), "text cannot be null or empty");

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty(TEXT, text);

    final Request request =
        RequestBuilder.post(PATH_TONE).query(VERSION_DATE, versionDate).bodyJson(contentJson).build();

    return createServiceCall(request, ResponseConverterUtils.getObject(ToneAnalysis.class));
  }

}

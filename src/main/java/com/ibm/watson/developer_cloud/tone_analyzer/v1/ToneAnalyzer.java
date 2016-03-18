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
package com.ibm.watson.developer_cloud.tone_analyzer.v1;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Scorecard;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.SynonymOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.SynonymResult;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Tone;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * The IBM Watson The Tone Analyzer service uses linguistic analysis to detect emotional tones,
 * social propensities, and writing styles in written communication. Then it offers suggestions to
 * help the writer improve their intended language tones.
 * 
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/tone-analyzer.html">
 *      Tone Analyzer</a>
 */
public class ToneAnalyzer extends WatsonService {

  private static final String PATH_SYNONYM = "/v1/synonym";
  private static final String PATH_TONE = "/v1/tone";
  private static final String SCORECARD = "scorecard";
  private static final Type synonymListType = new TypeToken<List<SynonymResult>>() {}.getType();
  private static final String TEXT = "text";
  private static final String URL =
      "https://gateway.watsonplatform.net/tone-analyzer-experimental/api";
  private static final String PATH_SCORECARD = "/v2/scorecards";
  private static final String SCORECARDS = "scorecards";

  /** The scorecard list type. */
  private final Type scorecardListType = new TypeToken<List<Scorecard>>() {}.getType();

  /**
   * Instantiates a new Tone Analyzer service.
   */
  public ToneAnalyzer() {
    super("tone_analyzer");
    setEndPoint(URL);
  }

  /**
   * Starts or continue conversations.
   * 
   * @param options the request options
   * @return {@link SynonymResult}
   */
  public List<SynonymResult> getSynonyms(SynonymOptions options) {
    if (options == null)
      throw new IllegalArgumentException("options cannot be null");

    if (options.getWords() == null || options.getWords().isEmpty())
      throw new IllegalArgumentException("options.words cannot be null or empty");

    final Request request =
        RequestBuilder
            .post(PATH_SYNONYM)
            .withBodyContent(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(options),
                HttpMediaType.APPLICATION_JSON).build();

    final Response response = execute(request);
    final String synonymResultJson = ResponseUtil.getString(response);
    final List<SynonymResult> synonyms =
        GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(synonymResultJson, synonymListType);
    return synonyms;
  }

  /**
   * Analyzes the "tone" of a piece of text using the default scorecard. The message is analyzed
   * from several tones (social tone, emotional tone, writing tone), and for each of them various
   * traits are derived (such as conscientiousness, agreeableness, openness).
   * 
   * 
   * @param text The text to analyze
   * @return the {@link Tone} with the response
   * 
   */
  public Tone getTone(final String text) {
    return getTone(text, null);
  }

  /**
   * Analyzes the "tone" of a piece of text. The message is analyzed from several tones (social
   * tone, emotional tone, writing tone), and for each of them various traits are derived (such as
   * conscientiousness, agreeableness, openness).
   * 
   * @param text The text to analyze
   * @param scorecard Name of the scorecard used to compute the tone. (business messages by default)
   * @return the {@link Tone} with the response
   * 
   */
  public Tone getTone(final String text, final Scorecard scorecard) {

    if (text == null || text.isEmpty())
      throw new IllegalArgumentException("text cannot be null or empty");

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty(TEXT, text);

    if (scorecard != null)
      contentJson.addProperty(SCORECARD, scorecard.getId());

    final Request request = RequestBuilder.post(PATH_TONE).withBodyJson(contentJson).build();
    return executeRequest(request, Tone.class);
  }

  /**
   * Returns the {@link Scorecard}s.
   * 
   * @return the list of scorecard
   */
  public List<Scorecard> getScorecards() {
    final Response response = execute(RequestBuilder.get(PATH_SCORECARD).build());
    final JsonObject jsonObject = ResponseUtil.getJsonObject(response);
    final List<Scorecard> scorecards =
        GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(jsonObject.get(SCORECARDS), scorecardListType);

    return scorecards;
  }
}

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
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Scorecard;
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
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/tone-analyzer.html">
 *      Tone Analyzer</a>
 */
public class ToneAnalyzer extends WatsonService {

  /** The Constant CONTEXT (value is "context"). */
  public static final String CONTEXT = "context";

  /** The Constant HOPS (value is "hops"). */
  // parameters
  public static final String HOPS = "hops";

  /** The Constant LIMIT (value is "limit"). */
  public static final String LIMIT = "limit";

  private static final String PATH_SYNONYM = "/v1/synonym";
  private static final String PATH_TONE = "/v1/tone";

  /** The Constant SCORECARD (value is "scorecard"). */
  public static final String SCORECARD = "scorecard";

  private static final Type synonymListType = new TypeToken<List<SynonymResult>>() {}.getType();

  /** The Constant TEXT (value is "text"). */
  public static final String TEXT = "text";

  /** The Constant TRAITS (value is "traits"). */
  public static final String TRAITS = "traits";

  private static final String URL =
      "https://gateway.watsonplatform.net/tone-analyzer-experimental/api";

  /** The Constant WORDS (value is "words"). */
  public static final String WORDS = "words";

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
   * @param params The map with the parameters described above
   * @return {@link SynonymResult}
   */
  public List<SynonymResult> getSynonyms(Map<String, Object> params) {
    final String[] words = (String[]) params.get(WORDS);
    final String[] traits = (String[]) params.get(TRAITS);
    final String[] contexts = (String[]) params.get(CONTEXT);

    if (words == null || words.length == 0)
      throw new IllegalArgumentException("words cannot be null or empty");

    final JsonObject contentJson = new JsonObject();

    // words
    final JsonArray wordsJson = new JsonArray();
    for (final String word : words) {
      wordsJson.add(new JsonPrimitive(word));
    }
    contentJson.add(WORDS, wordsJson);

    // traits
    if (traits != null && traits.length > 0) {
      final JsonArray traisJson = new JsonArray();
      for (final String trait : traits) {
        traisJson.add(new JsonPrimitive(trait));
      }
      contentJson.add(TRAITS, traisJson);
    }

    // context
    if (contexts != null && contexts.length > 0) {
      final JsonArray contextsJson = new JsonArray();
      for (final String context : contexts) {
        contextsJson.add(new JsonPrimitive(context));
      }
      contentJson.add(CONTEXT, contextsJson);
    }

    if (params.containsKey(LIMIT))
      contentJson.addProperty(LIMIT, (Integer) params.get(LIMIT));

    if (params.containsKey(HOPS))
      contentJson.addProperty(HOPS, (Integer) params.get(HOPS));

    final Request request = RequestBuilder.post(PATH_SYNONYM).withBodyJson(contentJson).build();

    final Response response = execute(request);
    final String synonymResultJson = ResponseUtil.getString(response);
    final List<SynonymResult> synonyms =
        GsonSingleton.getGson().fromJson(synonymResultJson, synonymListType);
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
}

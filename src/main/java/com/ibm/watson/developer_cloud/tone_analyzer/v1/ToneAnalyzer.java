/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.tone_analyzer.v1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Scorecard;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.SynonymResult;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Tone;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The IBM Watson The Tone Analyzer service uses linguistic analysis to detect
 * emotional tones, social propensities, and writing styles in written
 * communication. Then it offers suggestions to help the writer improve their
 * intended language tones.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/tone-analyzer.html">
 *      Tone Analyzer</a>
 */
public class ToneAnalyzer extends WatsonService {

	// parameters
	public static final String TEXT = null;
	public static final String SCORECARD = null;

	private static final Logger log = Logger.getLogger(ToneAnalyzer.class
			.getName());
	private static final String URL = "https://gateway.watsonplatform.net/tone-analyzer-experimental/api";

	private static final Type listScorecardsType = new TypeToken<List<Scorecard>>() {
	}.getType();

	/**
	 * Instantiates a new Tone Analyzer service with the default url
	 */
	public ToneAnalyzer() {
		setEndPoint(URL);
	}

	/**
	 * Analyzes the "tone" of a piece of text using the default scorecard.
	 * The message is analyzed from several tones (social tone, emotional tone,
	 * writing tone), and for each of them various traits are derived
	 * (such as conscientiousness, agreeableness, openness).
	 * 
	 * 
	 * @param text
	 *            The text to analyze
	 * @return the {@link Tone} with the response
	 * 
	 */
	public Tone getTone(final String text) {
		return getTone(text,null);
	}

	/**
	 * Analyzes the "tone" of a piece of text. The message is analyzed from
	 * several tones (social tone, emotional tone, writing tone), and for each
	 * of them various traits are derived (such as conscientiousness,
	 * agreeableness, openness).
	 * 
	 * @param text
	 *            The text to analyze
	 * @param scorecard
	 *            Name of the scorecard used to compute the tone. (business
	 *            messages by default)
	 * @return the {@link Tone} with the response
	 * 
	 */
	public Tone getTone(final String text, final String scorecard) {

		if (text == null || text.isEmpty())
			throw new IllegalArgumentException("text can not be null or empty");

		JsonObject contentJson = new JsonObject();
		contentJson.addProperty(TEXT, text);

		if (scorecard != null)
			contentJson.addProperty(SCORECARD, text);

		HttpRequestBase request = Request.Post("/v1/tone")
				.withContent(contentJson).build();

		try {
			HttpResponse response = execute(request);
			String toneAsJson = ResponseUtil.getString(response);
			Tone tone = getGson().fromJson(toneAsJson, Tone.class);
			return tone;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Starts or continue conversations.
	 * 
	 * @param words
	 *            (string[]),
	 * @param traits
	 *            (string[], optional),
	 * @param limit
	 *            (long, optional) Limits the number of words to return on each
	 *            trait. The most heavily correlated (positive and negative) to
	 *            each trait are returned; approximately limit/2 each of
	 *            positively correlated words negatively correlated words if
	 *            there are enough available.
	 * @param hops
	 *            (long, optional): The number of 'hops' to explore for synonyms
	 *            or related words: 0 indicates words directly related to the
	 *            input; 1 gives words related to them, and so on. The greater
	 *            this number, the richer the word set returned (but at the same
	 *            time, less tightly related to the input).
	 * @param context
	 *            (string[], optional)
	 * @param index
	 *            (long, optional): The position (0-based) in `context`
	 *            parameter where the requested word appears. This parameter can
	 *            only be passed when `context` is also present and there is
	 *            only one word requested (length(`words`)=0), and it makes
	 *            sense only if `context[index]` is equal to `words[0]`.
	 * 
	 * @param params
	 *            The map with the parameters described above
	 * 
	 * @return {@link SynonymResult}
	 */
	public SynonymResult getSynonyms(Map<String, Object> params) {
		String[] words = (String[]) params.get("words");
		String[] traits = (String[]) params.get("traits");
		String[] context = (String[]) params.get("context");

		if (words == null || words.length == 0)
			throw new IllegalArgumentException("words can not be null or empty");

		JsonObject jsonObject = new JsonObject();
		// TODO: add all the properties to the json object
		HttpRequestBase request = Request.Post("/v1/synonym")
				.withContent(jsonObject).build();

		HttpResponse response = execute(request);
		try {
			String synonymResultJson = ResponseUtil.getString(response);
			SynonymResult synonymResult = getGson().fromJson(synonymResultJson,
					SynonymResult.class);
			return synonymResult;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns a list of available scorecards. Scorecards are implementations of 
	 * Tone evaluations for different domains.
	 *
	 * @return A list of {@link Scorecard }
	 */
	public List<Scorecard> getScorecards() {
		HttpRequestBase request = Request.Get("/v1/scorecards").build();
		HttpResponse response = execute(request);
		
		try {
			JsonObject jsonObject = ResponseUtil.getJsonObject(response);
			List<Scorecard> scorecards = new Gson().fromJson(
					jsonObject.get("scorecards"), listScorecardsType);
			return scorecards;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}

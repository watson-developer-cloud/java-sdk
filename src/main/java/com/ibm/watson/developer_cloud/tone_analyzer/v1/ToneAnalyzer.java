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

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Scorecard;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.SynonymResult;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Tone;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The IBM Watson The Tone Analyzer service uses linguistic analysis to detect emotional
 * tones, social propensities, and writing styles in written communication. Then it offers
 * suggestions to help the writer improve their intended language tones.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/tone-analyzer.html">
 *      Tone Analyzer</a>
 */
public class ToneAnalyzer extends WatsonService {

	/** The Constant HOPS. */
	// parameters
	public static final String HOPS = "hops";

	/** The Constant LIMIT. */
	public static final String LIMIT = "limit";

	/** The Constant CONTEXT. */
	public static final String CONTEXT = "context";

	/** The Constant TRAITS. */
	public static final String TRAITS = "traits";

	/** The Constant WORDS. */
	public static final String WORDS = "words";

	/** The Constant TEXT. */
	public static final String TEXT = "text";

	/** The Constant SCORECARD. */
	public static final String SCORECARD = "scorecard";

	/** The Constant URL. */
	private static final String URL = "https://gateway.watsonplatform.net/tone-analyzer-experimental/api";

	/** The synonym list. */
	private static final Type synonymListType = new TypeToken<List<SynonymResult>>() {}.getType();

	/**
	 * Instantiates a new Tone Analyzer service with the default url.
	 */
	public ToneAnalyzer() {
		setEndPoint(URL);
	}

	/**
	 * Analyzes the "tone" of a piece of text using the default scorecard. The message is
	 * analyzed from several tones (social tone, emotional tone, writing tone), and for
	 * each of them various traits are derived (such as conscientiousness, agreeableness,
	 * openness).
	 * 
	 * 
	 * @param text
	 *            The text to analyze
	 * @return the {@link Tone} with the response
	 * 
	 */
	public Tone getTone(final String text) {
		return getTone(text, null);
	}

	/**
	 * Analyzes the "tone" of a piece of text. The message is analyzed from several tones
	 * (social tone, emotional tone, writing tone), and for each of them various traits
	 * are derived (such as conscientiousness, agreeableness, openness).
	 * 
	 * @param text
	 *            The text to analyze
	 * @param scorecard
	 *            Name of the scorecard used to compute the tone. (business messages by
	 *            default)
	 * @return the {@link Tone} with the response
	 * 
	 */
	public Tone getTone(final String text, final Scorecard scorecard) {

		if (text == null || text.isEmpty())
			throw new IllegalArgumentException("text can not be null or empty");

		JsonObject contentJson = new JsonObject();
		contentJson.addProperty(TEXT, text);

		if (scorecard != null)
			contentJson.addProperty(SCORECARD, scorecard.getId());

		HttpRequestBase request = Request.Post("/v1/tone").withContent(contentJson).build();

		try {
			HttpResponse response = execute(request);
			String toneAsJson = ResponseUtil.getString(response);
			Tone tone = GsonSingleton.getGson().fromJson(toneAsJson, Tone.class);
			return tone;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Starts or continue conversations.
	 * 
	 * @param params
	 *            The map with the parameters described above
	 * @return {@link SynonymResult}
	 */
	public List<SynonymResult> getSynonyms(Map<String, Object> params) {
		String[] words = (String[]) params.get(WORDS);
		String[] traits = (String[]) params.get(TRAITS);
		String[] contexts = (String[]) params.get(CONTEXT);

		if (words == null || words.length == 0)
			throw new IllegalArgumentException("words can not be null or empty");

		JsonObject contentJson = new JsonObject();

		// words
		JsonArray wordsJson = new JsonArray();
		for (String word : words) {
			wordsJson.add(new JsonPrimitive(word));
		}
		contentJson.add(WORDS, wordsJson);

		// traits
		if (traits != null && traits.length > 0) {
			JsonArray traisJson = new JsonArray();
			for (String trait : traits) {
				traisJson.add(new JsonPrimitive(trait));
			}
			contentJson.add(TRAITS, traisJson);
		}

		// context
		if (contexts != null && contexts.length > 0) {
			JsonArray contextsJson = new JsonArray();
			for (String context : contexts) {
				contextsJson.add(new JsonPrimitive(context));
			}
			contentJson.add(CONTEXT, contextsJson);
		}

		if (params.containsKey(LIMIT))
			contentJson.addProperty(LIMIT, (Integer) params.get(LIMIT));

		if (params.containsKey(HOPS))
			contentJson.addProperty(HOPS, (Integer) params.get(HOPS));

		HttpRequestBase request = Request.Post("/v1/synonym").withContent(contentJson).build();

		HttpResponse response = execute(request);
		try {
			String synonymResultJson = ResponseUtil.getString(response);
			List<SynonymResult> synonyms = GsonSingleton.getGson().fromJson(synonymResultJson, synonymListType);
			return synonyms;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

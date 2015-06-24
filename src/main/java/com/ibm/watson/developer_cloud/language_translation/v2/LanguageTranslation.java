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
package com.ibm.watson.developer_cloud.language_translation.v2;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.LanguageModel;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The IBM Watson Language Translation service translate text from one language
 * to another and identifies the language in which text is written.
 * 
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/language-translation.html">
 *      Language Translation</a>
 * 
 * @version v2
 * 
 * @author German Attanasio Ruiz <germanatt@us.ibm.com>
 */
public class LanguageTranslation extends WatsonService {

	private static String URL = "https://gateway.watsonplatform.net/language-translation/api";

	private Type modelListType = new TypeToken<List<LanguageModel>>() {
	}.getType();

	private Type languageModelListType = new TypeToken<List<IdentifiedLanguage>>() {
	}.getType();

	/**
	 * Instantiates a new Language Translation service.
	 */
	public LanguageTranslation() {
		setEndPoint(URL);
	}

	/**
	 * Translate text using a model.
	 * 
	 * @param paragraphs
	 *            The submitted paragraphs to translate
	 * @param modelId
	 *            the model id
	 * @return the translation of text from source to target
	 */
	public TranslationResult translate(final String[] paragraphs, final String modelId) {
		return translate(paragraphs, null, null, modelId);
	}
	
	/**
	 * Translate text using a model.
	 * 
	 * @param text
	 *            The submitted text to translate
	 * @param modelId
	 *            the model id
	 * @return the translation of text from source to target
	 */
	public TranslationResult translate(final String text, final String modelId) {
		return translate(new String[] {text}, null, null, modelId);
	}
	
	/**
	 * Translate text using a source and target and target needs to be specified
	 * Returns an error if source or target are 2letter language code and no
	 * suitable default can be found (such as "zh")
	 * 
	 * @param paragraphs
	 *            The submitted paragraphs to translate
	 * @param source
	 *            Source language in 2 or 5 letter language code. Should use
	 *            2-letter codes except for when needed to disambiguate between
	 *            multiple supported languages.
	 * @param target
	 *            the target language
	 * 
	 * @return the translation of text from source to target
	 */
	public TranslationResult translate(final String[] paragraphs, final String source, final String target) {
		return translate(paragraphs, source, target, null);
	}
	
	/**
	 * Translate text using a source and target and target needs to be specified
	 * Returns an error if source or target are 2letter language code and no
	 * suitable default can be found (such as "zh")
	 * 
	 * @param text
	 *            The submitted text to translate
	 * @param source
	 *            Source language in 2 or 5 letter language code. Should use
	 *            2-letter codes except for when needed to disambiguate between
	 *            multiple supported languages.
	 * @param target
	 *            the target language
	 * 
	 * @return the translation of text from source to target
	 */
	public TranslationResult translate(final String text, final String source,
			final String target) {
		return translate(new String[] { text }, source, target, null);
	}

	/**
	 * Translate paragraphs of text using a model and or source and target
	 * modeId or source and target needs to be specified
	 * 
	 * @param text
	 *            The submitted paragraphs to translate
	 * @param source
	 *            the source language
	 * @param target
	 *            the target language
	 * @param modelId
	 *            the model id
	 * @return the classification of a phrase with a given classifier
	 */
	private TranslationResult translate(final String[] text,
			final String source, final String target, final String modelId) {
		if ((modelId == null || modelId.isEmpty())
				&& (source == null || source.isEmpty() || target == null || target
						.isEmpty()))
			throw new IllegalArgumentException(
					"model_id or source and target should be specified");

		if (text == null || text.length == 0)
			throw new IllegalArgumentException("text can not be null or empty");

		JsonObject contentJson = new JsonObject();

		// convert the text into a json array
		JsonArray paragraphs = new JsonArray();
		for (String paragraph : text) {
			paragraphs.add(new JsonPrimitive(paragraph));
		}
		contentJson.add("text", paragraphs);

		if (source != null && !source.isEmpty())
			contentJson.addProperty("source", source);

		if (target != null && !target.isEmpty())
			contentJson.addProperty("target", target);

		if (modelId != null && !modelId.isEmpty())
			contentJson.addProperty("model_id", modelId);

		HttpRequestBase request = Request.Post("/v2/translate")
				.withContent(contentJson).build();

		try {
			HttpResponse response = execute(request);
			String translationResult = ResponseUtil.getString(response);
			TranslationResult translation = getGson().fromJson(
					translationResult, TranslationResult.class);
			return translation;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Identify language in which text is written.
	 * 
	 * @param text
	 *            the text to identify
	 * @return the identified language
	 */
	public List<IdentifiedLanguage> identify(final String text) {
		HttpRequestBase request = Request.Post("/v2/identify")
				.withContent(text, "text/plain")
				.withHeader("accept", MediaType.APPLICATION_JSON).build();

		try {
			HttpResponse response = execute(request);
			JsonObject jsonObject = ResponseUtil.getJsonObject(response);
			List<IdentifiedLanguage> identifiedLanguages = getGson().fromJson(
					jsonObject.get("languages"), languageModelListType);
			return identifiedLanguages;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retrieves the list of models.
	 * 
	 * @param showDefault
	 *            show default models
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 * @return the translation models
	 * @see LanguageModel
	 */
	public List<LanguageModel> getModels(final Boolean showDefault,
			final String source, final String target) {
		Request request = Request.Get("/v2/models");

		if (source != null && !source.isEmpty())
			request.withQuery("source", source);

		if (target != null && !target.isEmpty())
			request.withQuery("target", source);

		if (showDefault != null)
			request.withQuery("default", showDefault.booleanValue());

		HttpRequestBase requestBase = request.build();
		try {
			HttpResponse response = execute(requestBase);
			JsonObject jsonObject = ResponseUtil.getJsonObject(response);
			List<LanguageModel> models = getGson().fromJson(
					jsonObject.get("models"), modelListType);
			return models;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retrieves the list of models.
	 * 
	 * @return the translation models
	 * @see LanguageModel
	 */
	public List<LanguageModel> getModels() {
		return getModels(null,null,null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LanguageTranslation [getEndPoint()=");
		builder.append(getEndPoint());
		builder.append("]");
		return builder.toString();
	}
}

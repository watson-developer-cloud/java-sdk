/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.watson.developer_cloud.alchemy_language.v1;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Author;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Combined;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Feeds;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Keywords;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Language;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Microformats;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Relations;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Taxonomy;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Text;
import com.ibm.watson.developer_cloud.alchemy_language.v1.model.Title;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.util.AlchemyEndPoints.AlchemyAPI;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Alchemy Language service uses offers 12 text analysis services, each of which uses
 * sophisticated natural language processing techniques to analyze your content and add
 * high-level semantic information.
 * 
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v1
 * @see <a href="http://www.alchemyapi.com/products/alchemylanguage"> Alchemy Language</a>
 */
public class AlchemyLanguage extends AlchemyService {

	// Input formats
	public static final String URL = "url";
	public static final String HTML = "html";
	public static final String TEXT = "text";

	// Request parameters to help when creating a requests
	// TODO: verify that all the possible parameters are in the list below
	public static final String BASE_URL = "baseUrl";
	public static final String COREFERENCE = "coreference";
	public static final String CQUERY = "cquery";
	public static final String DISAMBIGUTE = "disambiguate";
	public static final String ENTITIES = "entities";
	public static final String EXTRACT = "extract";
	public static final String EXTRACT_LINK = "extractLinks";
	public static final String FORCED_GLOSSARY = "forced_glossary";
	public static final String KEYWORD_EXTRACT_MODE = "keywordExtractMode";
	public static final String KEYWORDS = "keywords";
	public static final String KNOWLEDGE_GRAPH = "knowledgeGraph";
	public static final String LINKED_DATA = "linkedData";
	public static final String MAX_RETRIEVE = "maxRetrieve";
	public static final String QUOTATIONS = "quotations";
	public static final String REQUIRED_ENTITIES = "requireEntities";
	public static final String SENTIMENT = "sentiment";
	public static final String SENTIMENT_EXCLUDE_ENTITIES = "sentimentExcludeEntities";
	public static final String SHOW_SOURCE_TEXT = "showSourceText";
	public static final String SOURCE_TEXT = "sourceText";
	public static final String STRUCTURED_ENTITIES = "structuredEntities";
	public static final String TARGET = "target";
	public static final String USE_METADATA = "useMetadata";
	public static final String XPATH = "xpath";
	public static final String RAW = "raw";

	/**
	 * Extracts a grouped, ranked list of named entities (people, companies,
	 * organizations, etc.) from text, a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, text, html or url should
	 *            be specified.
	 * 
	 * @return {@link Entities}
	 */
	public Entities getEntities(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.entities, Entities.class, "text", "html", "url");
	}

	/**
	 * Extracts the keywords from text, a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, text, html or url should
	 *            be specified.
	 * @return {@link Keywords}
	 */
	public Keywords getKeywords(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.keywords, Keywords.class, "text", "html", "url");
	}

	/**
	 * Categorized through the taxonomy call for text, HTML, or a URLL.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, text, html or url should
	 *            be specified.
	 * @return {@link Taxonomy}
	 */
	public Taxonomy geTaxonomy(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.taxonomy, Taxonomy.class, "text", "html", "url");
	}

	/**
	 * Calculates the sentiment for text, a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, text, html or url should
	 *            be specified.
	 * @return {@link DocumentSentiment}
	 */
	public DocumentSentiment getSentiment(Map<String, Object> params) {
		AlchemyAPI operation = AlchemyAPI.sentiment;
		if (params.get(TARGET) != null)
			operation = AlchemyAPI.sentiment_targeted;

			return executeRequest(params, operation, DocumentSentiment.class, "text", "html", "url");
	}

	/**
	 * Extracts the relations for text, a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, text, html or url should
	 *            be specified.
	 * @return {@link Relations}
	 */
	public Relations getRelations(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.relations, Relations.class, "text", "html", "url");
	}

	/**
	 * Detects the language for text, a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, text, html or url should
	 *            be specified.
	 * @return {@link Language}
	 */
	public Language getLanguage(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.language, Language.class, "text", "html", "url");
	}

	/**
	 * Extracts the title for a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, html or url should be
	 *            specified.
	 * @return {@link Title}
	 */
	public Title getTitle(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.title, Title.class, "html", "url");
	}

	/**
	 * Extracts the authors from a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, html or url should be
	 *            specified.
	 * @return {@link Author}
	 */
	public Author getAuthors(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.authors, Author.class, "html", "url");
	}

	/**
	 * Extracts the cleaned text (removes ads, navigation, etc.) for a URL or HTML. if raw
	 * is true, extracts the cleaned text (removes ads, navigation, etc.).
	 * 
	 * @param params
	 *            The parameters to be used in the service call, html or url should be
	 *            specified.
	 * @return {@link Text}
	 */
	public Text getText(Map<String, Object> params) {
		AlchemyAPI operation = AlchemyAPI.text;
		if (params.get(RAW) != null )
			operation = AlchemyAPI.text_raw;

		return executeRequest(params, operation, Text.class, "html", "url");
	}

	/**
	 * Detects the RSS/ATOM feeds for a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, html or url should be
	 *            specified.
	 * @return {@link Feeds}
	 */
	public Feeds getFeeds(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.feeds, Feeds.class, "html", "url");
	}

	/**
	 * Parses the {@link Microformats} for a URL or HTML.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, html or url should be
	 *            specified
	 * @return {@link Microformats}
	 */
	public Microformats getMicroformats(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.microformats, Microformats.class, "html", "url");
	}

	/**
	 * Automatically perform analysis using multiple features on any web page or posted
	 * (uploaded) HTML/text file.
	 * 
	 * @param params
	 *            The parameters to be used in the service call, text, html or url should
	 *            be specified.
	 * @return {@link Microformats}
	 */
	public Combined getCombined(Map<String, Object> params) {
		return executeRequest(params, AlchemyAPI.combined, Combined.class, "text", "html", "url");
	}

	/**
	 * Execute the request and return the POJO that represent the response.
	 * 
	 * @param <T>
	 *            The POJO that represents the response object
	 * @param params
	 *            the request parameters
	 * @param operation
	 *            the alchemy operation
	 * @param returnType
	 *            the POJO class to be parsed from the response
	 * @param acceptedFormats
	 *            the accepted input formats e.g. "html", "text"...
	 * @return the POJO object that represent the response
	 */
	private <T> T executeRequest(Map<String, Object> params, AlchemyAPI operation, Class<T> returnType,
			String... acceptedFormats) {
		// Get the input format and check for missing parameters
		String format = getInputFormat(params, acceptedFormats);
		// Get the path that represent this operation based on the operation and format
		String path = AlchemyEndPoints.getPath(operation, format);

		// Return json
		params.put(OUTPUT_MODE, "json");

		// Prevent jsonp to be returned
		params.remove(JSONP);

		Request request = Request.Post(path);
		for (String param : params.keySet()) {
			request.withForm(param, params.get(param));
		}
		HttpRequestBase requestBase = request.build();
		try {
			HttpResponse response = execute(requestBase);
			return ResponseUtil.getObject(response, returnType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

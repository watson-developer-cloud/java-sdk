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


import com.ibm.watson.developer_cloud.alchemy_language.v1.model.*;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.Map;
import java.util.MissingFormatArgumentException;

/**
 * The Alchemy Language service uses IBM's ....
 *
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/alchemy-language.html">
 *      Speech to Text</a>
 */
public class AlchemyLanguage extends AlchemyService {

    /** The Constant OUT_PUT_MODE. desired API output format */
    public static final String OUT_PUT_MODE = "outputMode";

    /**
     * The Constant FORCED_GLOSSARY.
     */
    public static final String FORCED_GLOSSARY = "forced_glossary";

    /**
     * The Constant JSONP.
     */
    public static final String JSONP = "jsonp";

    /**
     * The Constant DISAMBIGUTE.
     */
    public static final String DISAMBIGUTE = "disambiguate";

    /**
     * The Constant LINKED_DATA.
     */
    public static final String LINKED_DATA = "linkedData";

    /**
     * The Constant COREFERENCE.
     */
    public static final String COREFERENCE = "coreference";

    /** The Constant QUOTATIONS. */
    public static final String QUOTATIONS = "quotations";

    /** The Constant SENTIMENT. */
    public static final String SENTIMENT = "sentiment";

    /** The Constant SHOW_SOURCE_TEXT. */
    private static final String SHOW_SOURCE_TEXT = "showSourceText";

    /** The Constant SOURCE_TEXT. */
    private static final String SOURCE_TEXT = "sourceText";

    /** The Constant CQUERY. */
    private static final String CQUERY = "cquery";

    /** The Constant XPATH. */
    private static final String XPATH = "xpath";

    /** The Constant MAX_RETRIEVE. */
    private static final String MAX_RETRIEVE = "maxRetrieve";

    /** The Constant BASE_URL. */
    private static final String BASE_URL = "baseUrl";

    /** The Constant KNOWLEDGE_GRAPH. */
    private static final String KNOWLEDGE_GRAPH = "knowledgeGraph";

    /** The Constant STRUCTURED_ENTITIES. */
    private static final String STRUCTURED_ENTITIES = "structuredEntities";

    /** The Constant URL. */
    public static final String URL_PRAM = "url";

    /** The Constant HTML. */
    public static final String HTML = "html";

    /** The Constant TEXT. */
    public static final String TEXT = "text";

    /** The Constant KEYWORD_EXTRACT_MODE. */
    private static final String KEYWORD_EXTRACT_MODE = "keywordExtractMode";

    /** The Constant TARGET. */
    private static final String TARGET = "target";

    /** The Constant KEYWORDS. */
    private static final String KEYWORDS = "keywords";

    /** The Constant ENTITIES. */
    private static final String ENTITIES = "entities";

    /** The Constant REQUIRED_ENTITIES. */
    private static final String REQUIRED_ENTITIES = "requireEntities";

    /** The Constant SENTIMENT_EXCLUDE_ENTITIES. */
    private static final String SENTIMENT_EXCLUDE_ENTITIES = "sentimentExcludeEntities";

    /** The Constant USE_METADATA. */
    private static final String USE_METADATA = "useMetadata";

    /** The Constant EXTRACT_LINK. */
    private static final String EXTRACT_LINK = "extractLinks";

    /** The Constant EXTRACT. */
    private static final String EXTRACT = "extractÍ";

    /**
     * Instantiates a new alchemy language.
     */
    public AlchemyLanguage() {
        setEndPoint(URL);
    }

    /**
     * Extracts a grouped, ranked list of named entities (people, companies,
     * organizations, etc.) from text, a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     *               disambiguate Boolean whether to disambiguate detected entities. Possible values: 1 - enabled (default) 0 - disabled,
     *               linkedData Boolean whether to include Linked Data content links with disambiguated entities. Possible values: 1 - enabled (default) 0 - disabled,
     *               coreference Boolean whether to resolve he/she/etc coreferences into detected entities. Possible values: 1 - enabled (default) 0 - disabled,
     *               quotations Boolean whether to enable quotations extraction.Possible values: 1 - enabled, 0 - disabled  (default),
     *               sentiment Boolean whether to enable entity-level sentiment analysis. Possible values: 1 - enabled, 0 - disabled  (default),
     *               sourceText String where to obtain the text that will be processed by this API call.
     *               showSourceText Boolean whether to include the original 'source text' the entities were extracted from within the API response. Possible values: 1 - enabled, 0 - disabled  (default),
     *               cquery String a visual constraints query to apply to the web page.
     *               xpath String an XPath query to apply to the web page.
     *               maxRetrieve Integer  maximum number of named entities to extract (default: 50),
     *               baseUrl String rel-tag output base http url
     *               knowledgeGraph Boolean Include knowledge graph information in the the results. Possible values: 1 , 0 (default),
     *               structuredEntities Boolean Extract Structured entities (Quantity, EmailAddress, TwitterHandle, Hashtag, IPAddress). Possible values: 1 , 0 (default).
     * @return {@link Entities}
     */
    public Entities getEntities(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                //TODO validate url exists
                OUT_PUT_MODE, JSONP, DISAMBIGUTE,
                LINKED_DATA, COREFERENCE, QUOTATIONS, SENTIMENT,
                SHOW_SOURCE_TEXT, SOURCE_TEXT, CQUERY, XPATH, MAX_RETRIEVE, BASE_URL,
                KNOWLEDGE_GRAPH, STRUCTURED_ENTITIES, URL_PRAM, TEXT, HTML};
        String jsonString = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.entities.name(), "url or html or text should be specified");
        Entities entities = GsonSingleton.getGson().fromJson(jsonString, Entities.class);
        return entities;
    }

    /**
     * Extracts the keywords from text, a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     *               keywordExtractMode String keyword extraction mode (normal or strict),
     *               sentiment Boolean whether to enable entity-level sentiment analysis. Possible values: 1 - enabled, 0 - disabled  (default),
     *               sourceText String where to obtain the text that will be processed by this API call.
     *               showSourceText Boolean whether to include the original 'source text' the entities were extracted from within the API response. Possible values: 1 - enabled, 0 - disabled  (default),
     *               cquery String a visual constraints query to apply to the web page.
     *               xpath String an XPath query to apply to the web page.
     *               maxRetrieve Integer  maximum number of named entities to extract (default: 50),
     *               baseUrl String rel-tag output base http url
     *               knowledgeGraph Boolean Include knowledge graph information in the the results. Possible values: 1 , 0 (default),     *
     * @return {@link Keywords}
     */
    public Keywords getWords(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                MAX_RETRIEVE, OUT_PUT_MODE, KEYWORD_EXTRACT_MODE, SENTIMENT,
                SHOW_SOURCE_TEXT, SOURCE_TEXT, CQUERY, XPATH,
                BASE_URL, KNOWLEDGE_GRAPH, URL_PRAM, TEXT, HTML};
        String jsonString = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.keywords.name(), "url or html or text should be specified");
        Keywords keywords = GsonSingleton.getGson().fromJson(jsonString, Keywords.class);
        return keywords;
    }

    /**
     * Categorized through the taxonomy call for text, HTML, or a URLL.
     *
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     *               sourceText String whether to include the original 'source text' the taxonomy categories were extracted from within the API response.
     *               cquery String a visual constraints query to apply to the web page.
     *               xpath String an XPath query to apply to the web page.
     *               baseUrl String rel-tag output base http url.
     * @return {@link Taxonomy}
     */
    public Taxonomy geTaxonomy(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, SOURCE_TEXT, CQUERY, XPATH,
                BASE_URL, URL_PRAM, TEXT, HTML};
        String jsonString = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.taxonomy.name(), "url or html or text should be specified");
        Taxonomy taxonomy = GsonSingleton.getGson().fromJson(
                jsonString, Taxonomy.class);
        return taxonomy;
    }

    /**
     * Categorized through the taxonomy call for text, HTML, or a URLL.
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     *               sourceText String where to obtain the text that will be processed by this API call.
     *               showSourceText Boolean whether to include the original 'source text' the sentiment was extracted from within the API response. Possible values: 1 - enabled, 0 - disabled  (default),
     *               xpath String an XPath query to apply to the web page.
     * @return {@link DocumentSentiment}
     */
    public DocumentSentiment getTextSentiment(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, SHOW_SOURCE_TEXT, JSONP, URL_PRAM, TEXT, HTML};
        String jsonString = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.sentiment.name(), "url or html or text should be specified");
        DocumentSentiment documentSentiment = GsonSingleton.getGson().fromJson(
                jsonString, DocumentSentiment.class);
        return documentSentiment;
    }

    /**
     * Calculates the sentiment for text, a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               target String phrase (must be uri-argument encoded) - sentiment targeted towards this phrase will be extracted from the text,
     *               sourceText String where to obtain the text that will be processed by this API call.
     *               showSourceText Boolean wwhether to include the original 'source text' the sentiment was extracted from within the API response. Possible values: 1 - enabled, 0 - disabled  (default),
     *               xpath String an XPath query to apply to the web page.
     *               cquery String a visual constraints query to apply to the web page.
     * @param params
     * @return {@link DocumentSentiment}
     */
    public DocumentSentiment getTargetedSentiment(Map<String, Object> params) {
        Validate.notNull(params.get(TARGET),"target can't be null");
        String[] queryParameters = new String[]{TARGET,
                OUT_PUT_MODE, SHOW_SOURCE_TEXT, JSONP, URL_PRAM, TEXT, HTML};
        String jsonString = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.sentiment_targeted.name(), "url or html or text should be specified");
        DocumentSentiment documentSentiment = GsonSingleton.getGson().fromJson(
                jsonString, DocumentSentiment.class);
        return documentSentiment;
    }

    /**
     * Extracts the relations for text, a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     *               disambiguate Boolean whether to disambiguate detected relation subject/object named entities. Possible values: 1 - enabled (default) 0 - disabled,
     *               linkedData Boolean whether to include Linked Data content links with identified relation subject/object named entities.. Possible values: 1 - enabled (default) 0 - disabled,
     *               coreference Boolean whether to resolve he/she/etc coreferences in detected relation subject/object named entities. Possible values: 1 - enabled (default) 0 - disabled,
     *               quotations Boolean whether to enable quotations extraction.Possible values: 1 - enabled, 0 - disabled  (default),
     *               sentiment Boolean whether to enable directional sentiment analysis. Possible values: 1 - enabled, 0 - disabled  (default),
     *               entities Boolean whether to enable relation subject/object entity extraction. Possible values: 1 - enabled, 0 - disabled  (default),
     *               requireEntities Boolean whether to only show extracted relations that contain at least one named entity, ignoring relations containing no entities. Possible values: 1 - enabled, 0 - disabled  (default),
     *               sourceText String where to obtain the text that will be processed by this API call.
     *               sentimentExcludeEntities Boolean whether to exclude relation subject/object named entity text from sentiment processing. (For example, not analyzing "New" in "New York"). Possible values: 1 - enabled (default), 0 - disabled,
     *               disambiguate Boolean whether to disambiguate detected relation subject/object named entities. Possible values: 1 - enabled (default), 0 - disabled,
     *               showSourceText Boolean whether to include the original 'source text' the relations were extracted from within the API response.. Possible values: 1 - enabled, 0 - disabled  (default),
     *               cquery String a visual constraints query to apply to the web page.
     *               xpath String an XPath query to apply to the web page.
     *               keywords Boolean whether to enable relation subject/object keyword extraction. Possible values: 1 - enabled, 0 - disabled (default).
     *               baseUrl String rel-tag output base http url
     *               maxRetrieve Integer  maximum number of named entities to extract (default: 50, maximum: 100),
     * @return {@link Relations}
     */
    public Relations getRelations(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, MAX_RETRIEVE, JSONP, SENTIMENT, KEYWORDS,
                ENTITIES, REQUIRED_ENTITIES, SENTIMENT_EXCLUDE_ENTITIES, DISAMBIGUTE,
                LINKED_DATA, COREFERENCE, SOURCE_TEXT, CQUERY, XPATH, BASE_URL, URL_PRAM, TEXT, HTML};
        String jsonstring = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.relations.name(), "url or html or text should be specified");
        Relations relations = GsonSingleton.getGson().fromJson(
                jsonstring, Relations.class);
        return relations;
    }

    /**
     * Detects the language for text, a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     *               sourceText String where to obtain the text that will be processed by this API call.
     *               cquery String a visual constraints query to apply to the web page.
     *               xpath String an XPath query to apply to the web page.
     * @return {@link Language}
     */
    public Language getLanguage(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, JSONP, SOURCE_TEXT, CQUERY, XPATH, URL_PRAM, TEXT, HTML};
        String jsonstring = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.language.name(), "url or html or text should be specified");
        Language language = GsonSingleton.getGson().fromJson(
                jsonstring, Language.class);
        return language;
    }

    /**
     * Extracts the title for a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               useMetadata Boolean whether to use description information embedded in web page meta-data. Possible values: 1 - enabled (default), 0 - disabled,
     * @param params
     * @return {@link Title}
     */
    public Title getTitle(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, USE_METADATA, URL_PRAM, TEXT, HTML};
        String jsonstring = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.title.name(), "url or html or text should be specified");
        Title title = GsonSingleton.getGson().fromJson(
                jsonstring, Title.class);
        return title;
    }

    /**
     * Extracts the authors from a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     * @return {@link Author}
     */
    public Author getAuthor(Map<String, Object> params) {
        // TODO author or authors
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, JSONP, URL_PRAM, HTML};
        String jsonstring = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.author.name(), "url or html should be specified");
        Author author = GsonSingleton.getGson().fromJson(
                jsonstring, Author.class);
        return author;
    }

    /**
     * Extracts the cleaned text (removes ads, navigation, etc.) for a URL or HTML.
     * if raw = true, extracts the cleaned text (removes ads, navigation, etc.).
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     *               extractLinks Boolean whether to include hyperlinks in the extracted web page text. Possible values: 1 - enabled, 0 - disabled (default),
     *               useMetadata Boolean whether to use description information embedded in web page meta-data. Possible values: 1 - enabled (default), 0 - disabled,
     *               sourceText String where to obtain the text that will be processed by this API call.
     * @return {@link Text}
     */
    public Text getText(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, USE_METADATA, EXTRACT_LINK, JSONP, SOURCE_TEXT, URL_PRAM, HTML};
        String jsonstring = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.text.name(), "url or html should be specified");
        Text text = GsonSingleton.getGson().fromJson(
                jsonstring, Text.class);
        return text;
    }

    /**
     * Detects the RSS/ATOM feeds for a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     * @param params
     * @return {@link Feeds}
     */
    public Feeds getFeeds(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, JSONP, URL_PRAM, TEXT, HTML};
        String jsonstring = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.feeds.name(), "url or html should be specified");
        Feeds feeds = GsonSingleton.getGson().fromJson(
                jsonstring, Feeds.class);
        return feeds;
    }

    /**
     * Parses the microformats for a URL or HTML.
     *
     * @param params
     * @return {@link Microformats}
     */
    public Microformats getMicroformats(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, JSONP, URL_PRAM, TEXT, HTML};
        String jsonstring = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.microformats.name(), "url or html should be specified");
        Microformats microformats = GsonSingleton.getGson().fromJson(
                jsonstring, Microformats.class);
        return microformats;
    }
    /**
     * Parses the microformats for a URL or HTML.
     * @param params url String http url (must be uri-argument encoded),
     *               jsonp String desired JSONP callback,
     *               extract String Comma separated list of requested features,
     *               showSourceText Boolean whether to include the original 'source text' the entities were extracted from within the API response. Possible values: 1 - enabled, 0 disabled (default).
     * @param params
     * @return {@link Microformats}
     */
    public Combined getCombined(Map<String, Object> params) {
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, JSONP,SHOW_SOURCE_TEXT,EXTRACT, URL_PRAM, TEXT, HTML};
        String jsonstring = executeRequest(params, queryParameters, AlchemyEndPoints.AlchemyObjects.combined.name(), "url, html or text should be specified");
        Combined combined = GsonSingleton.getGson().fromJson(
                jsonstring, Combined.class);
        return combined;
    }

    private String executeRequest(Map<String, Object> params, String[] queryParameters, String endPointName, String errorMsg) {
        String apiCall = null;
        if (!StringUtils.isEmpty((String) params.get(AlchemyEndPoints.AlchemyAPI.url.name()))) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(endPointName, AlchemyEndPoints.AlchemyAPI.url.name());
        } else if (!StringUtils.isEmpty((String) params.get(AlchemyEndPoints.AlchemyAPI.html.name()))) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(endPointName, AlchemyEndPoints.AlchemyAPI.html.name());
        } else if (!StringUtils.isEmpty((String) params.get(AlchemyEndPoints.AlchemyAPI.text.name()))) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(endPointName, AlchemyEndPoints.AlchemyAPI.text.name());
        } else
            throw new MissingFormatArgumentException(errorMsg);

        params.put(OUT_PUT_MODE, "json");
        // Build the url
        StringBuilder urlBuider = new StringBuilder();
        urlBuider.append(URL).append(apiCall);
        Request request = Request.Post(urlBuider.toString());
        for (String param : queryParameters) {
            if (params.containsKey(param))
                request.withForm(param, params.get(param));
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonstring = ResponseUtil.getString(response);
            return jsonstring;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

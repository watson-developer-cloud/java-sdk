/**
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

package com.ibm.watson.developer_cloud.alchemy.v1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.model.AlchemyGenericModel;
import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentPublicationDate;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentTitle;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Feeds;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Language;
import com.ibm.watson.developer_cloud.alchemy.v1.model.LanguageSelection;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Microformats;
import com.ibm.watson.developer_cloud.alchemy.v1.model.SAORelations;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints.AlchemyAPI;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;

/**
 * The Alchemy Language service uses offers 12 text analysis services, each of which uses sophisticated natural language
 * processing techniques to analyze your content and add high-level semantic information.
 *
 * @version v1
 * @see <a href="http://www.alchemyapi.com/products/alchemylanguage"> Alchemy Language</a>
 */
public class AlchemyLanguage extends AlchemyService {

  /** The Constant BASE_URL. */
  public static final String BASE_URL = "baseUrl";

  /** The Constant COREFERENCE. */
  public static final String COREFERENCE = "coreference";

  /** The Constant CQUERY. */
  public static final String CQUERY = "cquery";

  /** The Constant DISAMBIGUATE. */
  public static final String DISAMBIGUATE = "disambiguate";

  /** The Constant ENTITIES. */
  public static final String ENTITIES = "entities";

  /** The Constant EXTRACT. */
  public static final String EXTRACT = "extract";

  /** The Constant EXTRACT_LINK. */
  public static final String EXTRACT_LINK = "extractLinks";

  /** The Constant FORCED_GLOSSARY. */
  public static final String FORCED_GLOSSARY = "forced_glossary";

  /** The Constant HTML. */
  public static final String HTML = "html";

  /** The Constant KEYWORD_EXTRACT_MODE. */
  public static final String KEYWORD_EXTRACT_MODE = "keywordExtractMode";

  /** The Constant KEYWORDS. */
  public static final String KEYWORDS = "keywords";

  /** The Constant KNOWLEDGE_GRAPH. */
  public static final String KNOWLEDGE_GRAPH = "knowledgeGraph";

  /** The Constant LINKED_DATA. */
  public static final String LINKED_DATA = "linkedData";

  /** The Constant MAX_RETRIEVE. */
  public static final String MAX_RETRIEVE = "maxRetrieve";

  /** The Constant QUOTATIONS. */
  public static final String QUOTATIONS = "quotations";

  /** The Constant RAW. */
  public static final String RAW = "raw";

  /** The Constant REQUIRED_ENTITIES. */
  public static final String REQUIRED_ENTITIES = "requireEntities";

  /** The Constant SENTIMENT. */
  public static final String SENTIMENT = "sentiment";

  /** The Constant SENTIMENT_EXCLUDE_ENTITIES. */
  public static final String SENTIMENT_EXCLUDE_ENTITIES = "sentimentExcludeEntities";

  /** The Constant SHOW_SOURCE_TEXT. */
  public static final String SHOW_SOURCE_TEXT = "showSourceText";

  /** The Constant SOURCE_TEXT. */
  public static final String SOURCE_TEXT = "sourceText";

  /** The Constant STRUCTURED_ENTITIES. */
  public static final String STRUCTURED_ENTITIES = "structuredEntities";

  /** The Constant TARGET. */
  public static final String TARGET = "target";

  /** The Constant TEXT. */
  public static final String TEXT = "text";

  /** The Constant URL. */
  public static final String URL = "url";

  /** The Constant USE_METADATA. */
  public static final String USE_METADATA = "useMetadata";

  /** The Constant XPATH. */
  public static final String XPATH = "xpath";

  /** The Constant TARGETS. */
  public static final String TARGETS = "targets";

  /** The Constant ANCHOR_DATE. */
  public static final String ANCHOR_DATE = "anchorDate";

  /** The Constant MODEL_ID. */
  public static final String MODEL_ID = "model_id";

  private LanguageSelection language = LanguageSelection.DETECT;

  private static final SimpleDateFormat anchorDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private static final String LANGUAGE = "language";

  /**
   * Instantiates a new alchemy data news service.
   */
  public AlchemyLanguage() {
    super();
  }

  /**
   * Instantiates a new alchemy language service by apiKey.
   *
   * @param apiKey the api key
   */
  public AlchemyLanguage(String apiKey) {
    super(apiKey);
  }

  /**
   * Execute the request and return the POJO that represent the response.
   *
   * @param <T> The POJO that represents the response object
   * @param params the request parameters
   * @param operation the alchemy operation
   * @param returnType the POJO class to be parsed from the response
   * @param acceptedFormats the accepted input formats e.g. "html", "text"...
   * @return the POJO object that represent the response
   */
  private <T extends AlchemyGenericModel> ServiceCall<T> createServiceCall(final Map<String, Object> params,
      AlchemyAPI operation, Class<T> returnType, String... acceptedFormats) {

    // clone params, to prevent errors if the user continues to use the provided Map, or it is
    // immutable
    final Map<String, Object> paramsCopy = new HashMap<String, Object>(params);

    // Get the input format and check for missing parameters
    final String format = getInputFormat(paramsCopy, acceptedFormats);

    // Get the path that represent this operation based on the operation and format
    final String path = AlchemyEndPoints.getPath(operation, format);

    // Return json
    paramsCopy.put(OUTPUT_MODE, "json");

    if (!paramsCopy.containsKey(LANGUAGE) && (language != LanguageSelection.DETECT)) {
      paramsCopy.put(LANGUAGE, language.toString().toLowerCase());
    }

    // Prevent jsonp to be returned
    paramsCopy.remove(JSONP);

    final RequestBuilder requestBuilder = RequestBuilder.post(path);
    for (final String param : paramsCopy.keySet()) {
      requestBuilder.form(param, paramsCopy.get(param));
    }

    if ((operation == AlchemyAPI.TYPED) && params.containsKey(MODEL_ID)) {
      requestBuilder.query(MODEL_ID, params.get(MODEL_ID));
    }

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(returnType));
  }


  /**
   * Allows users to set language of input text.
   *
   * @param language The language to use
   */
  public void setLanguage(LanguageSelection language) {
    this.language = language;
  }


  /**
   * Extracts the authors from a URL or HTML.
   *
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link DocumentAuthors}
   */
  public ServiceCall<DocumentAuthors> getAuthors(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.AUTHORS, DocumentAuthors.class, HTML, URL);
  }


  /**
   * Extracts concepts tags for text, HTML, or a URLL.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link Concepts}
   */
  public ServiceCall<Concepts> getConcepts(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.CONCEPTS, Concepts.class, TEXT, HTML, URL);
  }

  /**
   * Extracts publication date information when it is specified in web pages.
   *
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link DocumentPublicationDate}
   */
  public ServiceCall<DocumentPublicationDate> getPublicationDate(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.PUBLICATION_DATE, DocumentPublicationDate.class, HTML, URL);
  }

  /**
   * Categorized through the taxonomy call for text, HTML, or a URL.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link Taxonomies}
   */
  public ServiceCall<Taxonomies> getTaxonomy(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.TAXONOMY, Taxonomies.class, TEXT, HTML, URL);
  }

  /**
   * Automatically perform analysis using multiple features on any web page or posted (uploaded) HTML/text file.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link Microformats}
   */
  public ServiceCall<CombinedResults> getCombinedResults(Map<String, Object> params) {
    Map<String, Object> paramsCopy = new HashMap<String, Object>(params);

    if (params.containsKey(ANCHOR_DATE) && (params.get(ANCHOR_DATE) instanceof Date)) {
      String anchorDate = formatDate((Date) params.get(ANCHOR_DATE));
      paramsCopy.put(ANCHOR_DATE, anchorDate);
    }

    return createServiceCall(paramsCopy, AlchemyAPI.COMBINED, CombinedResults.class, TEXT, HTML, URL);
  }

  /**
   * Extracts a grouped, ranked list of named entities (people, companies, organizations, etc.) from text, a URL or
   * HTML.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link Entities}
   */
  public ServiceCall<Entities> getEntities(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.ENTITIES, Entities.class, TEXT, HTML, URL);
  }

  /**
   * Detects the RSS/ATOM feeds for a URL or HTML.
   *
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link Feeds}
   */
  public ServiceCall<Feeds> getFeeds(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.FEEDS, Feeds.class, HTML, URL);
  }

  /**
   * Extracts the keywords from text, a URL or HTML.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link Keywords}
   */
  public ServiceCall<Keywords> getKeywords(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.KEYWORDS, Keywords.class, TEXT, HTML, URL);
  }

  /**
   * Detects the language for text, a URL or HTML.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link Language}
   */
  public ServiceCall<Language> getLanguage(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.LANGUAGE, Language.class, TEXT, HTML, URL);
  }

  /**
   * Parses the {@link Microformats} for a URL or HTML.
   *
   * @param params The parameters to be used in the service call, html or url should be specified
   * @return {@link Microformats}
   */
  public ServiceCall<Microformats> getMicroformats(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.MICROFORMATS, Microformats.class, HTML, URL);
  }

  /**
   * Extracts Subject-Action-Object(SAO) relations from text, a URL or HTML.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link SAORelations}
   */
  public ServiceCall<SAORelations> getRelations(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.RELATIONS, SAORelations.class, TEXT, HTML, URL);
  }

  /**
   * Calculates the sentiment for text, a URL or HTML.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link DocumentSentiment}
   */
  public ServiceCall<DocumentSentiment> getSentiment(Map<String, Object> params) {
    AlchemyAPI operation = AlchemyAPI.SENTIMENT;
    if ((params.get(TARGET) != null) || (params.get(TARGETS) != null)) {
      operation = AlchemyAPI.SENTIMENT_TARGETED;
    }

    return createServiceCall(params, operation, DocumentSentiment.class, TEXT, HTML, URL);
  }

  /**
   * Extracts the cleaned text (removes ads, navigation, etc.) for a URL or HTML. if raw is true, extracts the cleaned
   * text (removes ads, navigation, etc.).
   *
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link DocumentText}
   */
  public ServiceCall<DocumentText> getText(Map<String, Object> params) {
    AlchemyAPI operation = AlchemyAPI.TEXT;
    if (params.get(RAW) != null) {
      operation = AlchemyAPI.TEXT_RAW;
    }

    return createServiceCall(params, operation, DocumentText.class, HTML, URL);
  }

  /**
   * Extracts the title for a URL or HTML.
   *
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link DocumentTitle}
   */
  public ServiceCall<DocumentTitle> getTitle(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.TITLE, DocumentTitle.class, HTML, URL);
  }

  /**
   * Detects emotions in a text, URL or HTML.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified
   * @return {@link DocumentEmotion}
   */
  public ServiceCall<DocumentEmotion> getEmotion(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.EMOTION, DocumentEmotion.class, TEXT, HTML, URL);
  }

  /**
   * Finds entities and their relationships from a text, URL or HTML.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified
   * @return {@link DocumentEmotion}
   */
  public ServiceCall<TypedRelations> getTypedRelations(Map<String, Object> params) {
    return createServiceCall(params, AlchemyAPI.TYPED, TypedRelations.class, TEXT, HTML, URL);
  }

  /**
   * Extracts dates for text, a URL or HTML.
   *
   * @param params The parameters to be used in the service call, text, html or url should be specified.
   * @return {@link Dates}
   */
  public ServiceCall<Dates> getDates(final Map<String, Object> params) {
    Map<String, Object> paramsCopy = new HashMap<String, Object>(params);

    if (params.containsKey(ANCHOR_DATE) && (params.get(ANCHOR_DATE) instanceof Date)) {
      String anchorDate = formatDate((Date) params.get(ANCHOR_DATE));
      paramsCopy.put(ANCHOR_DATE, anchorDate);
    }

    return createServiceCall(paramsCopy, AlchemyAPI.DATES, Dates.class, TEXT, HTML, URL);
  }

  /**
   * Format date.
   *
   * @param anchorDate the anchor date
   * @return the formatted date as string
   */
  private synchronized String formatDate(final Date anchorDate) {
    return anchorDateFormat.format(anchorDate);
  }
}

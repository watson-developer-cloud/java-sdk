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

package com.ibm.watson.developer_cloud.alchemy.v1;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints.AlchemyAPI;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.AlchemyService;

/**
 * The Alchemy Language service uses offers 12 text analysis services, each of which uses
 * sophisticated natural language processing techniques to analyze your content and add high-level
 * semantic information.
 * 
 * @version v1
 * @see <a href="http://www.alchemyapi.com/products/alchemylanguage"> Alchemy Language</a>
 */
public class AlchemyLanguage extends AlchemyService {

  public static final String BASE_URL = "baseUrl";
  public static final String COREFERENCE = "coreference";
  public static final String CQUERY = "cquery";
  public static final String DISAMBIGUATE = "disambiguate";
  public static final String ENTITIES = "entities";
  public static final String EXTRACT = "extract";
  public static final String EXTRACT_LINK = "extractLinks";
  public static final String FORCED_GLOSSARY = "forced_glossary";
  public static final String HTML = "html";
  public static final String KEYWORD_EXTRACT_MODE = "keywordExtractMode";
  public static final String KEYWORDS = "keywords";
  public static final String KNOWLEDGE_GRAPH = "knowledgeGraph";
  public static final String LINKED_DATA = "linkedData";
  public static final String MAX_RETRIEVE = "maxRetrieve";
  public static final String QUOTATIONS = "quotations";
  public static final String RAW = "raw";
  public static final String REQUIRED_ENTITIES = "requireEntities";
  public static final String SENTIMENT = "sentiment";
  public static final String SENTIMENT_EXCLUDE_ENTITIES = "sentimentExcludeEntities";
  public static final String SHOW_SOURCE_TEXT = "showSourceText";
  public static final String SOURCE_TEXT = "sourceText";
  public static final String STRUCTURED_ENTITIES = "structuredEntities";
  public static final String TARGET = "target";
  public static final String TEXT = "text";
  public static final String URL = "url";
  public static final String USE_METADATA = "useMetadata";
  public static final String XPATH = "xpath";
  public static final String TARGETS = "targets";
  public static final String ANCHOR_DATE = "anchorDate";

  // language to be used with request
  private LanguageSelection language = LanguageSelection.DETECT;

  private static final SimpleDateFormat anchorDateFormat =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
  private <T extends AlchemyGenericModel> T executeRequest(Map<String, Object> params,
      AlchemyAPI operation, Class<T> returnType, String... acceptedFormats) {

    // Get the input format and check for missing parameters
    final String format = getInputFormat(params, acceptedFormats);

    // Get the path that represent this operation based on the operation and format
    final String path = AlchemyEndPoints.getPath(operation, format);

    // Return json
    params.put(OUTPUT_MODE, "json");

    if (language != LanguageSelection.DETECT) {
      params.put("language", language.toString().toLowerCase());
    }

    // Prevent jsonp to be returned
    params.remove(JSONP);

    final RequestBuilder requestBuilder = RequestBuilder.post(path);
    for (final String param : params.keySet()) {
      requestBuilder.withForm(param, params.get(param));
    }
    return executeRequest(requestBuilder.build(), returnType);
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
  public DocumentAuthors getAuthors(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.authors, DocumentAuthors.class, HTML, URL);
  }


  /**
   * Extracts concepts tags for text, HTML, or a URLL.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link Concepts}
   */
  public Concepts getConcepts(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.concepts, Concepts.class, TEXT, HTML, URL);
  }

  /**
   * Extracts publication date information when it is specified in web pages
   * 
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link DocumentPublicationDate}
   */
  public DocumentPublicationDate getPublicationDate(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.publication_date, DocumentPublicationDate.class, HTML,
        URL);
  }

  /**
   * Categorized through the taxonomy call for text, HTML, or a URL.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link Taxonomies}
   */
  public Taxonomies getTaxonomy(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.taxonomy, Taxonomies.class, TEXT, HTML, URL);
  }

  /**
   * Automatically perform analysis using multiple features on any web page or posted (uploaded)
   * HTML/text file.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link Microformats}
   */
  public CombinedResults getCombinedResults(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.combined, CombinedResults.class, TEXT, HTML, URL);
  }

  /**
   * Extracts a grouped, ranked list of named entities (people, companies, organizations, etc.) from
   * text, a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link Entities}
   */
  public Entities getEntities(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.entities, Entities.class, TEXT, HTML, URL);
  }

  /**
   * Detects the RSS/ATOM feeds for a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link Feeds}
   */
  public Feeds getFeeds(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.feeds, Feeds.class, HTML, URL);
  }

  /**
   * Extracts the keywords from text, a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link Keywords}
   */
  public Keywords getKeywords(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.keywords, Keywords.class, TEXT, HTML, URL);
  }

  /**
   * Detects the language for text, a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link Language}
   */
  public Language getLanguage(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.language, Language.class, TEXT, HTML, URL);
  }

  /**
   * Parses the {@link Microformats} for a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, html or url should be specified
   * @return {@link Microformats}
   */
  public Microformats getMicroformats(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.microformats, Microformats.class, HTML, URL);
  }

  /**
   * Extracts Subject-Action-Object(SAO) relations from text, a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link SAORelations}
   */
  public SAORelations getRelations(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.relations, SAORelations.class, TEXT, HTML, URL);
  }

  /**
   * Calculates the sentiment for text, a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link DocumentSentiment}
   */
  public DocumentSentiment getSentiment(Map<String, Object> params) {
    AlchemyAPI operation = AlchemyAPI.sentiment;
    if (params.get(TARGET) != null || params.get(TARGETS) != null)
      operation = AlchemyAPI.sentiment_targeted;

    return executeRequest(params, operation, DocumentSentiment.class, TEXT, HTML, URL);
  }

  /**
   * Extracts the cleaned text (removes ads, navigation, etc.) for a URL or HTML. if raw is true,
   * extracts the cleaned text (removes ads, navigation, etc.).
   * 
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link DocumentText}
   */
  public DocumentText getText(Map<String, Object> params) {
    AlchemyAPI operation = AlchemyAPI.text;
    if (params.get(RAW) != null)
      operation = AlchemyAPI.text_raw;

    return executeRequest(params, operation, DocumentText.class, HTML, URL);
  }

  /**
   * Extracts the title for a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link DocumentTitle}
   */
  public DocumentTitle getTitle(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.title, DocumentTitle.class, HTML, URL);
  }

  /**
   * Detects emotions in a text, URL or HTML.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified
   * @return {@link DocumentEmotion}
   */
  public DocumentEmotion getEmotion(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.emotion, DocumentEmotion.class, TEXT, HTML, URL);
  }

  /**
   * Extracts dates for text, a URL or HTML.
   * 
   * @param params The parameters to be used in the service call, text, html or url should be
   *        specified.
   * @return {@link Dates}
   */
  public Dates getDates(Map<String, Object> params) {

    if (params != null && params.containsKey(ANCHOR_DATE)) {
      if (params.get(ANCHOR_DATE) != null && params.get(ANCHOR_DATE) instanceof Date) {
        String anchorDate = anchorDateFormat.format(params.get(ANCHOR_DATE));
        params.put(ANCHOR_DATE, anchorDate);
      }
    }

    return executeRequest(params, AlchemyAPI.dates, Dates.class, TEXT, HTML, URL);
  }
}

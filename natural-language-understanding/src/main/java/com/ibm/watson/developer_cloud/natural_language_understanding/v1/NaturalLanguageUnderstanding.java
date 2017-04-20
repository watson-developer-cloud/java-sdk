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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ListModelsResults;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Analyze various features of text content at scale. Provide text, raw HTML, or a public URL, and IBM Watson Natural
 * Language Understanding will give you results for the features you request. The service cleans HTML content before
 * analysis by default, so the results can ignore most advertisements and other unwanted content.
 *
 * ### Concepts
 * Identify general concepts that are referenced or alluded to in your content. Concepts that are detected typically
 * have an associated link to a DBpedia resource.
 *
 * ### Entities
 * Detect important people, places, geopolitical entities and other types of entities in your content. Entity detection
 * recognizes consecutive coreferences of each entity. For example, analysis of the following text would count "Barack
 * Obama" and "He" as the same entity:
 *
 * "Barack Obama was the 44th President of the United States. He took office in January 2009."
 *
 * ### Keywords
 * Determine the most important keywords in your content. Keyword phrases are organized by relevance in the results.
 *
 * ### Categories
 * Categorize your content into a hierarchical 5-level taxonomy. For example, "Leonardo DiCaprio won an Oscar" returns
 * "/art and entertainment/movies and tv/movies" as the most confident classification.
 *
 * ### Sentiment
 * Determine whether your content conveys postive or negative sentiment. Sentiment information can be returned for
 * detected entities, keywords, or user-specified target phrases found in the text.
 *
 * ### Emotion
 * Detect anger, disgust, fear, joy, or sadness that is conveyed by your content. Emotion information can be returned
 * for detected entities, keywords, or user-specified target phrases found in the text.
 *
 * ### Relations
 * Recognize when two entities are related, and identify the type of relation.  For example, you can identify an
 * "awardedTo" relation between an award and its recipient.
 *
 * ### Semantic Roles
 * Parse sentences into subject-action-object form, and identify entities and keywords that are subjects or objects of
 * an action.
 *
 * ### Metadata
 * Get author information, publication date, and the title of your text/HTML content.
 *
 * @version v1
 * @see <a
 * href="http://www.ibm.com/watson/developercloud/natural-language-understanding.html">
 * Natural Language Understanding</a>
*/
public class NaturalLanguageUnderstanding extends WatsonService {

  private static final String SERVICE_NAME = "natural_language_understanding";
  private static final String URL = "https://gateway.watsonplatform.net/natural-language-understanding/api";

  private String versionDate;

  /** The Constant VERSION_DATE_2017_02_27. */
  public static final String VERSION_DATE_2017_02_27 = "2017-02-27";

  /**
   * Instantiates a new `NaturalLanguageUnderstanding`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *        calls from failing when the service introduces breaking changes.
   */
  public NaturalLanguageUnderstanding(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2017_02_27);

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `NaturalLanguageUnderstanding` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *        calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public NaturalLanguageUnderstanding(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Analyzes text, HTML, or a public webpage with one or more text analysis features.
   *
   * @param parameters An object containing request parameters. The `features` object and one of the `text`, `html`, or
   *        `url` attributes are required.
   * @return the {@link AnalysisResults} with the response
   */
  public ServiceCall<AnalysisResults> analyze(AnalyzeOptions parameters) {
    RequestBuilder builder = RequestBuilder.post("/v1/analyze");
    builder.query(VERSION, versionDate);

    if (parameters != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(parameters).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AnalysisResults.class));
  }

  /**
   * Delete model.
   *
   * Deletes a custom model.
   *
   * @param modelId the model id
   * @return the service call
   */
  public ServiceCall<Void> deleteModel(String modelId) {
    Validator.notNull(modelId, "modelID cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/models/%s", modelId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * List models.
   *
   * Lists available models for Relations and Entities features, including Watson Knowledge Studio custom models that
   * you have created and linked to your Natural Language Understanding service.
   *
   * @return the {@link ListModelsResults} with the response
   */
  public ServiceCall<ListModelsResults> getModels() {
    RequestBuilder builder = RequestBuilder.get("/v1/models");
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListModelsResults.class));
  }

}

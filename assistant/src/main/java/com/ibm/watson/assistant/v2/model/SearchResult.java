/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** SearchResult. */
public class SearchResult extends GenericModel {

  protected String id;

  @SerializedName("result_metadata")
  protected SearchResultMetadata resultMetadata;

  protected String body;
  protected String title;
  protected String url;
  protected SearchResultHighlight highlight;
  protected List<SearchResultAnswer> answers;

  protected SearchResult() {}

  /**
   * Gets the id.
   *
   * <p>The unique identifier of the document in the Discovery service collection.
   *
   * <p>This property is included in responses from search skills, which are available only to Plus
   * or Enterprise plan users.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the resultMetadata.
   *
   * <p>An object containing search result metadata from the Discovery service.
   *
   * @return the resultMetadata
   */
  public SearchResultMetadata getResultMetadata() {
    return resultMetadata;
  }

  /**
   * Gets the body.
   *
   * <p>A description of the search result. This is taken from an abstract, summary, or highlight
   * field in the Discovery service response, as specified in the search skill configuration.
   *
   * @return the body
   */
  public String getBody() {
    return body;
  }

  /**
   * Gets the title.
   *
   * <p>The title of the search result. This is taken from a title or name field in the Discovery
   * service response, as specified in the search skill configuration.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the url.
   *
   * <p>The URL of the original data object in its native data source.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the highlight.
   *
   * <p>An object containing segments of text from search results with query-matching text
   * highlighted using HTML `&lt;em&gt;` tags.
   *
   * @return the highlight
   */
  public SearchResultHighlight getHighlight() {
    return highlight;
  }

  /**
   * Gets the answers.
   *
   * <p>An array specifying segments of text within the result that were identified as direct
   * answers to the search query. Currently, only the single answer with the highest confidence (if
   * any) is returned.
   *
   * <p>**Notes:** - Answer finding is available only if the search skill is connected to a
   * Discovery v2 service instance. - Answer finding is not supported on IBM Cloud Pak for Data.
   *
   * @return the answers
   */
  public List<SearchResultAnswer> getAnswers() {
    return answers;
  }
}

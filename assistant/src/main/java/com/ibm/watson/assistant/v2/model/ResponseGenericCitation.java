/*
 * (C) Copyright IBM Corp. 2025.
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

/** ResponseGenericCitation. */
public class ResponseGenericCitation extends GenericModel {

  protected String title;
  protected String text;
  protected String body;

  @SerializedName("search_result_index")
  protected Long searchResultIndex;

  protected List<ResponseGenericCitationRangesItem> ranges;

  protected ResponseGenericCitation() {}

  /**
   * Gets the title.
   *
   * <p>The title of the citation text.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the text.
   *
   * <p>The text of the citation.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the body.
   *
   * <p>The body content of the citation.
   *
   * @return the body
   */
  public String getBody() {
    return body;
  }

  /**
   * Gets the searchResultIndex.
   *
   * <p>The index of the search_result where the citation is generated.
   *
   * @return the searchResultIndex
   */
  public Long getSearchResultIndex() {
    return searchResultIndex;
  }

  /**
   * Gets the ranges.
   *
   * <p>The offsets of the start and end of the citation in the generated response. For example,
   * `ranges:[ { start:0, end:5 }, ...]`.
   *
   * @return the ranges
   */
  public List<ResponseGenericCitationRangesItem> getRanges() {
    return ranges;
  }
}

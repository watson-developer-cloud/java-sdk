/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.List;

/**
 * An object containing segments of text from search results with query-matching text highlighted
 * using HTML `<em>` tags.
 */
public class SearchResultHighlight extends DynamicModel<List<String>> {

  @SerializedName("body")
  protected List<String> body;

  @SerializedName("title")
  protected List<String> title;

  @SerializedName("url")
  protected List<String> url;

  public SearchResultHighlight() {
    super(new TypeToken<List<String>>() {});
  }

  /**
   * Gets the body.
   *
   * <p>An array of strings containing segments taken from body text in the search results, with
   * query-matching substrings highlighted.
   *
   * @return the body
   */
  public List<String> getBody() {
    return this.body;
  }

  /**
   * Gets the title.
   *
   * <p>An array of strings containing segments taken from title text in the search results, with
   * query-matching substrings highlighted.
   *
   * @return the title
   */
  public List<String> getTitle() {
    return this.title;
  }

  /**
   * Gets the url.
   *
   * <p>An array of strings containing segments taken from URLs in the search results, with
   * query-matching substrings highlighted.
   *
   * @return the url
   */
  public List<String> getUrl() {
    return this.url;
  }
}

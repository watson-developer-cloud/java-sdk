/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.compare_comply.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The HTML converted from an input document.
 */
public class HTMLReturn extends GenericModel {

  @SerializedName("num_pages")
  private String numPages;
  private String author;
  @SerializedName("publication_date")
  private String publicationDate;
  private String title;
  private String html;

  /**
   * Gets the numPages.
   *
   * The number of pages in the input document.
   *
   * @return the numPages
   */
  public String getNumPages() {
    return numPages;
  }

  /**
   * Gets the author.
   *
   * The author of the input document, if identified.
   *
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Gets the publicationDate.
   *
   * The publication date of the input document, if identified.
   *
   * @return the publicationDate
   */
  public String getPublicationDate() {
    return publicationDate;
  }

  /**
   * Gets the title.
   *
   * The title of the input document, if identified.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the html.
   *
   * The HTML version of the input document.
   *
   * @return the html
   */
  public String getHtml() {
    return html;
  }
}

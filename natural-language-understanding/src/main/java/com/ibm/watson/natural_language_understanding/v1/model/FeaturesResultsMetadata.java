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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Webpage metadata, such as the author and the title of the page. */
public class FeaturesResultsMetadata extends GenericModel {

  protected List<Author> authors;

  @SerializedName("publication_date")
  protected String publicationDate;

  protected String title;
  protected String image;
  protected List<Feed> feeds;

  /**
   * Gets the authors.
   *
   * <p>The authors of the document.
   *
   * @return the authors
   */
  public List<Author> getAuthors() {
    return authors;
  }

  /**
   * Gets the publicationDate.
   *
   * <p>The publication date in the format ISO 8601.
   *
   * @return the publicationDate
   */
  public String getPublicationDate() {
    return publicationDate;
  }

  /**
   * Gets the title.
   *
   * <p>The title of the document.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the image.
   *
   * <p>URL of a prominent image on the webpage.
   *
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * Gets the feeds.
   *
   * <p>RSS/ATOM feeds found on the webpage.
   *
   * @return the feeds
   */
  public List<Feed> getFeeds() {
    return feeds;
  }
}

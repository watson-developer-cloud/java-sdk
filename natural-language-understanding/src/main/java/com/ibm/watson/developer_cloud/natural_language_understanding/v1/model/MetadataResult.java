/*
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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Authors, Publication Date, and Title of the document. Supports URL and HTML input types.
 */
public class MetadataResult extends GenericModel {

  private List<Author> authors;
  @SerializedName("publication_date")
  private String publicationDate;
  private String title;
  private String image;
  private List<Feed> feeds;

  /**
   * Gets the authors.
   *
   * The authors of the document
   *
   * @return the authors
   */
  public List<Author> getAuthors() {
    return authors;
  }

  /**
   * Gets the publicationDate.
   *
   * The publication date in the format ISO 8601
   *
   * @return the publicationDate
   */
  public String getPublicationDate() {
    return publicationDate;
  }

  /**
   * Gets the title.
   *
   * The title of the document
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the image.
   *
   * URL of a prominent image on the webpage
   *
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * Gets the feeds.
   *
   * RSS/ATOM feeds found on the webpage
   *
   * @return the feeds
   */
  public List<Feed> getFeeds() {
    return feeds;
  }

  /**
   * Sets the authors.
   *
   * @param authors the new authors
   */
  public void setAuthors(final List<Author> authors) {
    this.authors = authors;
  }

  /**
   * Sets the publicationDate.
   *
   * @param publicationDate the new publicationDate
   */
  public void setPublicationDate(final String publicationDate) {
    this.publicationDate = publicationDate;
  }

  /**
   * Sets the title.
   *
   * @param title the new title
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Sets the image.
   *
   * @param image the new image
   */
  public void setImage(final String image) {
    this.image = image;
  }

  /**
   * Sets the feeds.
   *
   * @param feeds the new feeds
   */
  public void setFeeds(final List<Feed> feeds) {
    this.feeds = feeds;
  }
}

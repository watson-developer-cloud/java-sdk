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

  /** The authors of the document. */
  private List<Author> authors;
  /** The publication date in the format ISO 8601. */
  @SerializedName("publication_date")
  private String publicationDate;
  /** The title of the document. */
  private String title;

  /**
   * Adds the authors.
   *
   * @param authors the new authors
   */
  public void addauthors(Author authors) {
    this.authors.add(authors);
  }

  /**
   * Gets the authors.
   *
   * @return the authors
   */
  public List<Author> getAuthors() {
    return authors;
  }

  /**
   * Gets the publicationDate.
   *
   * @return the publicationDate
   */
  public String getPublicationDate() {
    return publicationDate;
  }

  /**
   * Gets the title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
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

}

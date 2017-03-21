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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Documents by the {@link AlchemyDataNews} service.
 *
 */
public class Documents extends GenericModel {

  /** The documents. */
  @SerializedName("docs")
  private List<Document> documents;

  /** The next. */
  private String next;

  /**
   * Gets the documents.
   *
   * @return the documents
   */
  public List<Document> getDocuments() {
    return documents;
  }

  /**
   * Gets the next.
   *
   * @return The next
   */
  public String getNext() {
    return next;
  }

  /**
   * Sets the docs.
   *
   * @param docs The docs
   */
  public void setDocs(List<Document> docs) {
    documents = docs;
  }

  /**
   * Sets the documents.
   *
   * @param documents the documents to set
   */
  public void setDocuments(List<Document> documents) {
    this.documents = documents;
  }

  /**
   * Sets the next.
   *
   * @param next The next
   */
  public void setNext(String next) {
    this.next = next;
  }

}

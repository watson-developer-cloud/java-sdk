/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.natural_language_classifier.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response from the classifier for multiple phrases.
 */
public class ClassificationCollection extends GenericModel {

  @SerializedName("classifier_id")
  protected String classifierId;
  protected String url;
  protected List<CollectionItem> collection;

  /**
   * Gets the classifierId.
   *
   * Unique identifier for this classifier.
   *
   * @return the classifierId
   */
  public String getClassifierId() {
    return classifierId;
  }

  /**
   * Gets the url.
   *
   * Link to the classifier.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the collection.
   *
   * An array of classifier responses for each submitted phrase.
   *
   * @return the collection
   */
  public List<CollectionItem> getCollection() {
    return collection;
  }
}

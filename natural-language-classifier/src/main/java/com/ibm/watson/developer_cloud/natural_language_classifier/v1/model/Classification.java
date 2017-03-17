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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Classification class used by the {@link NaturalLanguageClassifier} service.
 *
 */
public class Classification extends GenericModel {

  private List<ClassifiedClass> classes;
  @SerializedName("classifier_id")
  private String id;
  private String text;
  @SerializedName("top_class")
  private String topClass;
  private String url;

  /**
   * Gets the classes.
   *
   * @return the classes
   */
  public List<ClassifiedClass> getClasses() {
    return classes;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the top lass.
   *
   * @return the top class
   */
  public String getTopClass() {
    return topClass;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the classes.
   *
   * @param classes the new classes
   */
  public void setClasses(List<ClassifiedClass> classes) {
    this.classes = classes;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Sets the top class.
   *
   * @param topClass class the new top class
   */
  public void setTopClass(String topClass) {
    this.topClass = topClass;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(String url) {
    this.url = url;
  }
}

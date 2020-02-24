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
 * Response from the classifier for a phrase in a collection.
 */
public class CollectionItem extends GenericModel {

  protected String text;
  @SerializedName("top_class")
  protected String topClass;
  protected List<ClassifiedClass> classes;

  /**
   * Gets the text.
   *
   * The submitted phrase. The maximum length is 2048 characters.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the topClass.
   *
   * The class with the highest confidence.
   *
   * @return the topClass
   */
  public String getTopClass() {
    return topClass;
  }

  /**
   * Gets the classes.
   *
   * An array of up to ten class-confidence pairs sorted in descending order of confidence.
   *
   * @return the classes
   */
  public List<ClassifiedClass> getClasses() {
    return classes;
  }
}

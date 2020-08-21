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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** A categorization of the analyzed text. */
public class CategoriesResult extends GenericModel {

  protected String label;
  protected Double score;
  protected CategoriesResultExplanation explanation;

  /**
   * Gets the label.
   *
   * <p>The path to the category through the 5-level taxonomy hierarchy. For more information about
   * the categories, see [Categories
   * hierarchy](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-categories#categories-hierarchy).
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Gets the score.
   *
   * <p>Confidence score for the category classification. Higher values indicate greater confidence.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Gets the explanation.
   *
   * <p>Information that helps to explain what contributed to the categories result.
   *
   * @return the explanation
   */
  public CategoriesResultExplanation getExplanation() {
    return explanation;
  }
}

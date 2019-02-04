/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A categorization of the analyzed text.
 */
public class CategoriesResult extends GenericModel {

  private String label;
  private Double score;

  /**
   * Gets the label.
   *
   * The path to the category through the 5-level taxonomy hierarchy. For the complete list of categories, see the
   * [Categories
   * hierarchy](https://cloud.ibm.com/docs/services/natural-language-understanding/categories.html#categories-hierarchy)
   * documentation.
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Gets the score.
   *
   * Confidence score for the category classification. Higher values indicate greater confidence.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }
}

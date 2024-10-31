/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A micro-average aggregates the contributions of all classes to compute the average metric.
 * Classes refers to the classification labels that are specified in the **answer_field**.
 */
public class ModelEvaluationMicroAverage extends GenericModel {

  protected Double precision;
  protected Double recall;
  protected Double f1;

  protected ModelEvaluationMicroAverage() {}

  /**
   * Gets the precision.
   *
   * <p>A metric that measures how many of the overall documents are classified correctly.
   *
   * @return the precision
   */
  public Double getPrecision() {
    return precision;
  }

  /**
   * Gets the recall.
   *
   * <p>A metric that measures how often documents that should be classified into certain classes
   * are classified into those classes.
   *
   * @return the recall
   */
  public Double getRecall() {
    return recall;
  }

  /**
   * Gets the f1.
   *
   * <p>A metric that measures whether the optimal balance between precision and recall is reached.
   * The F1 score can be interpreted as a weighted average of the precision and recall values. An F1
   * score reaches its best value at 1 and worst value at 0.
   *
   * @return the f1
   */
  public Double getF1() {
    return f1;
  }
}

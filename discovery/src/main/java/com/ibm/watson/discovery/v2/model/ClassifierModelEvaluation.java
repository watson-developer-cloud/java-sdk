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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** An object that contains information about a trained document classifier model. */
public class ClassifierModelEvaluation extends GenericModel {

  @SerializedName("micro_average")
  protected ModelEvaluationMicroAverage microAverage;

  @SerializedName("macro_average")
  protected ModelEvaluationMacroAverage macroAverage;

  @SerializedName("per_class")
  protected List<PerClassModelEvaluation> perClass;

  protected ClassifierModelEvaluation() {}

  /**
   * Gets the microAverage.
   *
   * <p>A micro-average aggregates the contributions of all classes to compute the average metric.
   * Classes refers to the classification labels that are specified in the **answer_field**.
   *
   * @return the microAverage
   */
  public ModelEvaluationMicroAverage getMicroAverage() {
    return microAverage;
  }

  /**
   * Gets the macroAverage.
   *
   * <p>A macro-average computes metric independently for each class and then takes the average.
   * Class refers to the classification label that is specified in the **answer_field**.
   *
   * @return the macroAverage
   */
  public ModelEvaluationMacroAverage getMacroAverage() {
    return macroAverage;
  }

  /**
   * Gets the perClass.
   *
   * <p>An array of evaluation metrics, one set of metrics for each class, where class refers to the
   * classification label that is specified in the **answer_field**.
   *
   * @return the perClass
   */
  public List<PerClassModelEvaluation> getPerClass() {
    return perClass;
  }
}

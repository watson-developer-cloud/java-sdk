/*
 * (C) Copyright IBM Corp. 2019.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Class and confidence.
 */
public class ClassifiedClass extends GenericModel {

  private Double confidence;
  @SerializedName("class_name")
  private String className;

  /**
   * Gets the confidence.
   *
   * A decimal percentage that represents the confidence that Watson has in this class. Higher values represent higher
   * confidences.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the className.
   *
   * Class label.
   *
   * @return the className
   */
  public String getClassName() {
    return className;
  }
}

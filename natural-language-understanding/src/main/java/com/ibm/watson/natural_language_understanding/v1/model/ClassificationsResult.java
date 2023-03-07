/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** A classification of the analyzed text. */
public class ClassificationsResult extends GenericModel {

  @SerializedName("class_name")
  protected String className;

  protected Double confidence;

  protected ClassificationsResult() {}

  /**
   * Gets the className.
   *
   * <p>Classification assigned to the text.
   *
   * @return the className
   */
  public String getClassName() {
    return className;
  }

  /**
   * Gets the confidence.
   *
   * <p>Confidence score for the classification. Higher values indicate greater confidence.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }
}

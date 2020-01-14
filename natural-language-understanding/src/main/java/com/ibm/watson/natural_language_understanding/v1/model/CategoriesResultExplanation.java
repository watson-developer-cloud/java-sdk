/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information that helps to explain what contributed to the categories result.
 */
public class CategoriesResultExplanation extends GenericModel {

  @SerializedName("relevant_text")
  protected List<CategoriesRelevantText> relevantText;

  /**
   * Gets the relevantText.
   *
   * An array of relevant text from the source that contributed to the categorization. The sorted array begins with the
   * phrase that contributed most significantly to the result, followed by phrases that were less and less impactful.
   *
   * @return the relevantText
   */
  public List<CategoriesRelevantText> getRelevantText() {
    return relevantText;
  }
}

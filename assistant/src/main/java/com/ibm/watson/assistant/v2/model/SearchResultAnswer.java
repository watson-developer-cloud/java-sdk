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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object specifing a segment of text that was identified as a direct answer to the search query.
 */
public class SearchResultAnswer extends GenericModel {

  protected String text;
  protected Double confidence;

  protected SearchResultAnswer() {}

  /**
   * Gets the text.
   *
   * <p>The text of the answer.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the confidence.
   *
   * <p>The confidence score for the answer, as returned by the Discovery service.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }
}

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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A passage query result.
 */
public class QueryResultPassage extends GenericModel {

  @SerializedName("passage_text")
  protected String passageText;
  @SerializedName("start_offset")
  protected Long startOffset;
  @SerializedName("end_offset")
  protected Long endOffset;
  protected String field;

  /**
   * Gets the passageText.
   *
   * The content of the extracted passage.
   *
   * @return the passageText
   */
  public String getPassageText() {
    return passageText;
  }

  /**
   * Gets the startOffset.
   *
   * The position of the first character of the extracted passage in the originating field.
   *
   * @return the startOffset
   */
  public Long getStartOffset() {
    return startOffset;
  }

  /**
   * Gets the endOffset.
   *
   * The position of the last character of the extracted passage in the originating field.
   *
   * @return the endOffset
   */
  public Long getEndOffset() {
    return endOffset;
  }

  /**
   * Gets the field.
   *
   * The label of the field from which the passage has been extracted.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }
}


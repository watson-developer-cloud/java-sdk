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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Entity description and location within evidence field.
 */
public class QueryEvidenceEntity extends GenericModel {

  private String type;
  private String text;
  @SerializedName("start_offset")
  private Long startOffset;
  @SerializedName("end_offset")
  private Long endOffset;

  /**
   * Gets the type.
   *
   * The entity type for this entity. Possible types vary based on model used.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the text.
   *
   * The original text of this entity as found in the evidence field.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the startOffset.
   *
   * The start location of the entity text in the identified field. This value is inclusive.
   *
   * @return the startOffset
   */
  public Long getStartOffset() {
    return startOffset;
  }

  /**
   * Gets the endOffset.
   *
   * The end location of the entity text in the identified field. This value is exclusive.
   *
   * @return the endOffset
   */
  public Long getEndOffset() {
    return endOffset;
  }
}

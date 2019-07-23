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
package com.ibm.watson.natural_language_understanding.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * EntityMention.
 */
public class EntityMention extends GenericModel {

  private String text;
  private List<Long> location;
  private Double confidence;

  /**
   * Gets the text.
   *
   * Entity mention text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the location.
   *
   * Character offsets indicating the beginning and end of the mention in the analyzed text.
   *
   * @return the location
   */
  public List<Long> getLocation() {
    return location;
  }

  /**
   * Gets the confidence.
   *
   * Confidence in the entity identification from 0 to 1. Higher values indicate higher confidence. In standard entities
   * requests, confidence is returned only for English text. All entities requests that use custom models return the
   * confidence score.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }
}

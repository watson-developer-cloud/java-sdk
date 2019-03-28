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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing Entity query response information.
 */
public class QueryEntitiesResponseItem extends GenericModel {

  private String text;
  private String type;
  private List<QueryEvidence> evidence;

  /**
   * Gets the text.
   *
   * Entity text content.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the type.
   *
   * The type of the result entity.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the evidence.
   *
   * List of different evidentiary items to support the result.
   *
   * @return the evidence
   */
  public List<QueryEvidence> getEvidence() {
    return evidence;
  }
}

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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SemanticRolesAction.
 */
public class SemanticRolesAction extends GenericModel {

  private String text;
  private String normalized;
  private SemanticRolesVerb verb;

  /**
   * Gets the text.
   *
   * Analyzed text that corresponds to the action.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the normalized.
   *
   * normalized version of the action.
   *
   * @return the normalized
   */
  public String getNormalized() {
    return normalized;
  }

  /**
   * Gets the verb.
   *
   * @return the verb
   */
  public SemanticRolesVerb getVerb() {
    return verb;
  }
}

/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

/**
 * Concepts returned by {@link AlchemyLanguage#getConcepts(java.util.Map)}.
 *
 */
public class Concepts extends AlchemyLanguageGenericModel {

  /** The concepts. */
  private List<Concept> concepts;

  /**
   * Gets the concepts.
   *
   * @return the concepts
   */
  public List<Concept> getConcepts() {
    return concepts;
  }

  /**
   * Sets the concepts.
   *
   * @param concepts the concepts to set
   */
  public void setConcepts(List<Concept> concepts) {
    this.concepts = concepts;
  }

}

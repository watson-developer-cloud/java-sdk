/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
 * The relations between entities found in the content.
 */
public class RelationsResult extends GenericModel {

  protected Double score;
  protected String sentence;
  protected String type;
  protected List<RelationArgument> arguments;

  /**
   * Gets the score.
   *
   * Confidence score for the relation. Higher values indicate greater confidence.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Gets the sentence.
   *
   * The sentence that contains the relation.
   *
   * @return the sentence
   */
  public String getSentence() {
    return sentence;
  }

  /**
   * Gets the type.
   *
   * The type of the relation.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the arguments.
   *
   * Entity mentions that are involved in the relation.
   *
   * @return the arguments
   */
  public List<RelationArgument> getArguments() {
    return arguments;
  }
}

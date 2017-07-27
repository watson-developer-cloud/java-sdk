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
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Typed relation between {@link TypedArguments}.
 *
 * @see AlchemyLanguage#getTypedRelations(java.util.Map)
 */
public class TypedRelation extends GenericModel {

  private String sentence;
  private String type;
  private Double score;

  private List<TypedArguments> arguments;

  /**
   * Gets the type.
   *
   * @return The type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type The type
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Gets the score.
   *
   * @return The score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Sets the score.
   *
   * @param score The score
   */
  public void setScore(Double score) {
    this.score = score;
  }

  /**
   * Gets the sentence.
   *
   * @return the sentence
   */
  public String getSentence() {
    return sentence;
  }

  /**
   * Sets the sentence.
   *
   * @param sentence the new sentence
   */
  public void setSentence(String sentence) {
    this.sentence = sentence;
  }

  /**
   * Gets the arguments.
   *
   * @return the arguments
   */
  public List<TypedArguments> getArguments() {
    return arguments;
  }

  /**
   * Sets the arguments.
   *
   * @param arguments the new arguments
   */
  public void setArguments(List<TypedArguments> arguments) {
    this.arguments = arguments;
  }

}

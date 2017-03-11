/*
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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The relations between entities found in the content.
 */
public class RelationsResult extends GenericModel {

  /** Confidence score for the relation. Higher values indicate greater confidence. */
  private Double score;
  /** The sentence that contains the relation. */
  private String sentence;
  /** The type of the relation. */
  private String type;
  /** The extracted relation objects from the text. */
  private List<RelationArgument> arguments;

  /**
   * Adds the arguments.
   *
   * @param arguments the new arguments
   */
  public void addarguments(RelationArgument arguments) {
    this.arguments.add(arguments);
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
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
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the arguments.
   *
   * @return the arguments
   */
  public List<RelationArgument> getArguments() {
    return arguments;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(final Double score) {
    this.score = score;
  }

  /**
   * Sets the sentence.
   *
   * @param sentence the new sentence
   */
  public void setSentence(final String sentence) {
    this.sentence = sentence;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }

  /**
   * Sets the arguments.
   *
   * @param arguments the new arguments
   */
  public void setArguments(final List<RelationArgument> arguments) {
    this.arguments = arguments;
  }

}

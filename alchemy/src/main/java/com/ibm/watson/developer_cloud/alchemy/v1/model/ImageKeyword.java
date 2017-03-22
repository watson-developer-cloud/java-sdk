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

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ImageKeyword by the {@link AlchemyVision} service.
 *
 */
public class ImageKeyword extends GenericModel {

  /** The {@link KnowledgeGraph}. */
  private KnowledgeGraph knowledgeGraph;

  /** The score. */
  private Double score;

  /** The text. */
  private String text;

  /**
   * Gets the hierarchy. A value is only present if the request that produced this instance was made with
   * {@code knowledgeGraph = true}.
   *
   * @return The hierarchy, if it exists.
   */
  public String getHierarchy() {
    return (knowledgeGraph == null) ? null : knowledgeGraph.getTypeHierarchy();
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
   * Gets the text.
   *
   * @return The text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the hierarchy.
   *
   * @param hierarchy The hierarchy.
   */
  public void setHierarchy(String hierarchy) {
    if (knowledgeGraph == null) {
      knowledgeGraph = new KnowledgeGraph();
    }

    knowledgeGraph.setTypeHierarchy(hierarchy);
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
   * Sets the text.
   *
   * @param text The text
   */
  public void setText(String text) {
    this.text = text;
  }
}

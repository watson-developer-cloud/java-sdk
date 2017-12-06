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
 * The detected anger, disgust, fear, joy, or sadness that is conveyed by the content. Emotion information can be
 * returned for detected entities, keywords, or user-specified target phrases found in the text.
 */
public class EmotionResult extends GenericModel {

  private DocumentEmotionResults document;
  private List<TargetedEmotionResults> targets;

  /**
   * Gets the document.
   *
   * The returned emotion results across the document
   *
   * @return the document
   */
  public DocumentEmotionResults getDocument() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * The returned emotion results per specified target
   *
   * @return the targets
   */
  public List<TargetedEmotionResults> getTargets() {
    return targets;
  }

  /**
   * Sets the document.
   *
   * @param document the new document
   */
  public void setDocument(final DocumentEmotionResults document) {
    this.document = document;
  }

  /**
   * Sets the targets.
   *
   * @param targets the new targets
   */
  public void setTargets(final List<TargetedEmotionResults> targets) {
    this.targets = targets;
  }
}

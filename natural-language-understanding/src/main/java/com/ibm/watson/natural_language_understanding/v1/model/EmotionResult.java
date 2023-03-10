/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/**
 * The detected anger, disgust, fear, joy, or sadness that is conveyed by the content. Emotion
 * information can be returned for detected entities, keywords, or user-specified target phrases
 * found in the text.
 */
public class EmotionResult extends GenericModel {

  protected DocumentEmotionResults document;
  protected List<TargetedEmotionResults> targets;

  protected EmotionResult() {}

  /**
   * Gets the document.
   *
   * <p>Emotion results for the document as a whole.
   *
   * @return the document
   */
  public DocumentEmotionResults getDocument() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * <p>Emotion results for specified targets.
   *
   * @return the targets
   */
  public List<TargetedEmotionResults> getTargets() {
    return targets;
  }
}

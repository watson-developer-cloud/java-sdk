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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Tokenization options.
 */
public class SyntaxOptionsTokens extends GenericModel {

  private Boolean lemma;
  @SerializedName("part_of_speech")
  private Boolean partOfSpeech;

  /**
   * Gets the lemma.
   *
   * Set this to `true` to return the lemma for each token.
   *
   * @return the lemma
   */
  public Boolean isLemma() {
    return lemma;
  }

  /**
   * Gets the partOfSpeech.
   *
   * Set this to `true` to return the part of speech for each token.
   *
   * @return the partOfSpeech
   */
  public Boolean isPartOfSpeech() {
    return partOfSpeech;
  }
}

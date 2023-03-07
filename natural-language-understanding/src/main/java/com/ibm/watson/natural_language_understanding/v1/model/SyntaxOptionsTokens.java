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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Tokenization options. */
public class SyntaxOptionsTokens extends GenericModel {

  protected Boolean lemma;

  @SerializedName("part_of_speech")
  protected Boolean partOfSpeech;

  /** Builder. */
  public static class Builder {
    private Boolean lemma;
    private Boolean partOfSpeech;

    /**
     * Instantiates a new Builder from an existing SyntaxOptionsTokens instance.
     *
     * @param syntaxOptionsTokens the instance to initialize the Builder with
     */
    private Builder(SyntaxOptionsTokens syntaxOptionsTokens) {
      this.lemma = syntaxOptionsTokens.lemma;
      this.partOfSpeech = syntaxOptionsTokens.partOfSpeech;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SyntaxOptionsTokens.
     *
     * @return the new SyntaxOptionsTokens instance
     */
    public SyntaxOptionsTokens build() {
      return new SyntaxOptionsTokens(this);
    }

    /**
     * Set the lemma.
     *
     * @param lemma the lemma
     * @return the SyntaxOptionsTokens builder
     */
    public Builder lemma(Boolean lemma) {
      this.lemma = lemma;
      return this;
    }

    /**
     * Set the partOfSpeech.
     *
     * @param partOfSpeech the partOfSpeech
     * @return the SyntaxOptionsTokens builder
     */
    public Builder partOfSpeech(Boolean partOfSpeech) {
      this.partOfSpeech = partOfSpeech;
      return this;
    }
  }

  protected SyntaxOptionsTokens() {}

  protected SyntaxOptionsTokens(Builder builder) {
    lemma = builder.lemma;
    partOfSpeech = builder.partOfSpeech;
  }

  /**
   * New builder.
   *
   * @return a SyntaxOptionsTokens builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the lemma.
   *
   * <p>Set this to `true` to return the lemma for each token.
   *
   * @return the lemma
   */
  public Boolean lemma() {
    return lemma;
  }

  /**
   * Gets the partOfSpeech.
   *
   * <p>Set this to `true` to return the part of speech for each token.
   *
   * @return the partOfSpeech
   */
  public Boolean partOfSpeech() {
    return partOfSpeech;
  }
}

/*
 * (C) Copyright IBM Corp. 2019, 2023.
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

/** Returns tokens and sentences from the input text. */
public class SyntaxOptions extends GenericModel {

  protected SyntaxOptionsTokens tokens;
  protected Boolean sentences;

  /** Builder. */
  public static class Builder {
    private SyntaxOptionsTokens tokens;
    private Boolean sentences;

    /**
     * Instantiates a new Builder from an existing SyntaxOptions instance.
     *
     * @param syntaxOptions the instance to initialize the Builder with
     */
    private Builder(SyntaxOptions syntaxOptions) {
      this.tokens = syntaxOptions.tokens;
      this.sentences = syntaxOptions.sentences;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SyntaxOptions.
     *
     * @return the new SyntaxOptions instance
     */
    public SyntaxOptions build() {
      return new SyntaxOptions(this);
    }

    /**
     * Set the tokens.
     *
     * @param tokens the tokens
     * @return the SyntaxOptions builder
     */
    public Builder tokens(SyntaxOptionsTokens tokens) {
      this.tokens = tokens;
      return this;
    }

    /**
     * Set the sentences.
     *
     * @param sentences the sentences
     * @return the SyntaxOptions builder
     */
    public Builder sentences(Boolean sentences) {
      this.sentences = sentences;
      return this;
    }
  }

  protected SyntaxOptions() {}

  protected SyntaxOptions(Builder builder) {
    tokens = builder.tokens;
    sentences = builder.sentences;
  }

  /**
   * New builder.
   *
   * @return a SyntaxOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tokens.
   *
   * <p>Tokenization options.
   *
   * @return the tokens
   */
  public SyntaxOptionsTokens tokens() {
    return tokens;
  }

  /**
   * Gets the sentences.
   *
   * <p>Set this to `true` to return sentence information.
   *
   * @return the sentences
   */
  public Boolean sentences() {
    return sentences;
  }
}

/*
 * (C) Copyright IBM Corp. 2018, 2023.
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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** An object defining a single tokenizaion rule. */
public class TokenDictRule extends GenericModel {

  protected String text;
  protected List<String> tokens;
  protected List<String> readings;

  @SerializedName("part_of_speech")
  protected String partOfSpeech;

  /** Builder. */
  public static class Builder {
    private String text;
    private List<String> tokens;
    private List<String> readings;
    private String partOfSpeech;

    /**
     * Instantiates a new Builder from an existing TokenDictRule instance.
     *
     * @param tokenDictRule the instance to initialize the Builder with
     */
    private Builder(TokenDictRule tokenDictRule) {
      this.text = tokenDictRule.text;
      this.tokens = tokenDictRule.tokens;
      this.readings = tokenDictRule.readings;
      this.partOfSpeech = tokenDictRule.partOfSpeech;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     * @param tokens the tokens
     * @param partOfSpeech the partOfSpeech
     */
    public Builder(String text, List<String> tokens, String partOfSpeech) {
      this.text = text;
      this.tokens = tokens;
      this.partOfSpeech = partOfSpeech;
    }

    /**
     * Builds a TokenDictRule.
     *
     * @return the new TokenDictRule instance
     */
    public TokenDictRule build() {
      return new TokenDictRule(this);
    }

    /**
     * Adds an tokens to tokens.
     *
     * @param tokens the new tokens
     * @return the TokenDictRule builder
     */
    public Builder addTokens(String tokens) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tokens, "tokens cannot be null");
      if (this.tokens == null) {
        this.tokens = new ArrayList<String>();
      }
      this.tokens.add(tokens);
      return this;
    }

    /**
     * Adds an readings to readings.
     *
     * @param readings the new readings
     * @return the TokenDictRule builder
     */
    public Builder addReadings(String readings) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(readings, "readings cannot be null");
      if (this.readings == null) {
        this.readings = new ArrayList<String>();
      }
      this.readings.add(readings);
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the TokenDictRule builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the tokens. Existing tokens will be replaced.
     *
     * @param tokens the tokens
     * @return the TokenDictRule builder
     */
    public Builder tokens(List<String> tokens) {
      this.tokens = tokens;
      return this;
    }

    /**
     * Set the readings. Existing readings will be replaced.
     *
     * @param readings the readings
     * @return the TokenDictRule builder
     */
    public Builder readings(List<String> readings) {
      this.readings = readings;
      return this;
    }

    /**
     * Set the partOfSpeech.
     *
     * @param partOfSpeech the partOfSpeech
     * @return the TokenDictRule builder
     */
    public Builder partOfSpeech(String partOfSpeech) {
      this.partOfSpeech = partOfSpeech;
      return this;
    }
  }

  protected TokenDictRule() {}

  protected TokenDictRule(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tokens, "tokens cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.partOfSpeech, "partOfSpeech cannot be null");
    text = builder.text;
    tokens = builder.tokens;
    readings = builder.readings;
    partOfSpeech = builder.partOfSpeech;
  }

  /**
   * New builder.
   *
   * @return a TokenDictRule builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * <p>The string to tokenize.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the tokens.
   *
   * <p>Array of tokens that the `text` field is split into when found.
   *
   * @return the tokens
   */
  public List<String> tokens() {
    return tokens;
  }

  /**
   * Gets the readings.
   *
   * <p>Array of tokens that represent the content of the `text` field in an alternate character
   * set.
   *
   * @return the readings
   */
  public List<String> readings() {
    return readings;
  }

  /**
   * Gets the partOfSpeech.
   *
   * <p>The part of speech that the `text` string belongs to. For example `noun`. Custom parts of
   * speech can be specified.
   *
   * @return the partOfSpeech
   */
  public String partOfSpeech() {
    return partOfSpeech;
  }
}

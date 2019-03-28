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
package com.ibm.watson.tone_analyzer.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * Utterance.
 */
public class Utterance extends GenericModel {

  private String text;
  private String user;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;
    private String user;

    private Builder(Utterance utterance) {
      this.text = utterance.text;
      this.user = utterance.user;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     */
    public Builder(String text) {
      this.text = text;
    }

    /**
     * Builds a Utterance.
     *
     * @return the utterance
     */
    public Utterance build() {
      return new Utterance(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the Utterance builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the user.
     *
     * @param user the user
     * @return the Utterance builder
     */
    public Builder user(String user) {
      this.user = user;
      return this;
    }
  }

  private Utterance(Builder builder) {
    Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
    user = builder.user;
  }

  /**
   * New builder.
   *
   * @return a Utterance builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * An utterance contributed by a user in the conversation that is to be analyzed. The utterance can contain multiple
   * sentences.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the user.
   *
   * A string that identifies the user who contributed the utterance specified by the `text` parameter.
   *
   * @return the user
   */
  public String user() {
    return user;
  }
}

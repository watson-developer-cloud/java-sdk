/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;

/**
 * This object represents an utterance of a conversation. It has the text and the user who said this utterance. The user
 * field is optional
 */
public class Utterance {

  /** The text. */
  @SerializedName("text")
  String text;

  /** The user. */
  @SerializedName("user")
  String user;

  private Utterance(Builder builder) {
    this.text = builder.text;
    this.user = builder.user;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the user.
   *
   * @return the user
   */
  public String user() {
    return user;
  }

  /**
   * Utterance Builder.
   */
  public static class Builder {

    /** The text. */
    String text;

    /** The user. */
    String user;

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Instantiates a new builder.
     *
     * @param options the options
     */
    public Builder(Utterance options) {
      this.user = options.user;
      this.text = options.text;
    }

    /**
     * Sets the text.
     *
     * @param text the text
     * @return the builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Sets the user.
     *
     * @param user the user
     * @return the builder
     */
    public Builder user(String user) {
      this.user = user;
      return this;
    }

    /**
     * Builds the.
     *
     * @return the utterance
     */
    public Utterance build() {
      return new Utterance(this);
    }
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

}

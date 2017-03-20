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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * This class contains the parameters when using
 * {@link SpeechToText#createRecognitionJob(java.io.File, RecognizeOptions, RecognitionJobOptions)}.
 *
 * @see SpeechToText
 */
public class RecognitionJobOptions {

  private String callbackUrl;
  private String userToken;
  private Integer resultsTtl;
  private String []events;

  /**
   * Builder.
   */
  public static class Builder {
    private String callbackUrl;
    private String userToken;
    private Integer resultsTtl;
    private String []events;


    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Instantiates a new builder.
     *
     * @param options the options
     */
    public Builder(RecognitionJobOptions options) {
      callbackUrl = options.callbackUrl;
      events = options.events;
      resultsTtl = options.resultsTtl;
      userToken = options.userToken;
    }

    /**
     * Sets the callback url.
     *
     * @param callbackUrl the callback url
     * @return the builder
     */
    public Builder callbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
      return this;
    }

    /**
     * Sets the events.
     *
     * @param events the events
     * @return the builder
     */
    public Builder events(String... events) {
      this.events = events;
      return this;
    }

    /**
     * Sets the time to live in minutes for the results.
     *
     * @param resultsTtl the results ttl
     * @return the builder
     */
    public Builder resultsTtl(Integer resultsTtl) {
      this.resultsTtl = resultsTtl;
      return this;
    }


    /**
     * Sets the user token.
     *
     * @param userToken the user token
     * @return the builder
     */
    public Builder userToken(String userToken) {
      this.userToken = userToken;
      return this;
    }

    /**
     * Builds the {@link RecognitionJobOptions} object.
     *
     * @return the gets the tone options
     */
    public RecognitionJobOptions build() {
      return new RecognitionJobOptions(this);
    }
  }

  private RecognitionJobOptions(Builder builder) {
    callbackUrl = builder.callbackUrl;
    events = builder.events;
    resultsTtl = builder.resultsTtl;
    userToken = builder.userToken;
  }

  /**
   * Gets the events.
   *
   * @return the events
   */
  public String[] events() {
    return events;
  }

  /**
   * Gets the callback url.
   *
   * @return the the callback url.
   */
  public String callbackUrl() {
    return callbackUrl;
  }

  /**
   * Gets the user token.
   *
   * @return the text
   */
  public String userToken() {
    return userToken;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the results time to live in minutes.
   *
   * @return the results time to live in minutes.
   */
  public Integer resultsTtl() {
    return resultsTtl;
  }

}

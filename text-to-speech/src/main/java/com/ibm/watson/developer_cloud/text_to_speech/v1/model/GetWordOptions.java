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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getWord options.
 */
public class GetWordOptions extends GenericModel {

  private String customizationId;
  private String word;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String word;

    private Builder(GetWordOptions getWordOptions) {
      customizationId = getWordOptions.customizationId;
      word = getWordOptions.word;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param word the word
     */
    public Builder(String customizationId, String word) {
      this.customizationId = customizationId;
      this.word = word;
    }

    /**
     * Builds a GetWordOptions.
     *
     * @return the getWordOptions
     */
    public GetWordOptions build() {
      return new GetWordOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the GetWordOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the word.
     *
     * @param word the word
     * @return the GetWordOptions builder
     */
    public Builder word(String word) {
      this.word = word;
      return this;
    }
  }

  private GetWordOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    Validator.notEmpty(builder.word, "word cannot be empty");
    customizationId = builder.customizationId;
    word = builder.word;
  }

  /**
   * New builder.
   *
   * @return a GetWordOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom voice model. You must make the request with service credentials created
   * for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the word.
   *
   * The word that is to be queried from the custom voice model.
   *
   * @return the word
   */
  public String word() {
    return word;
  }
}

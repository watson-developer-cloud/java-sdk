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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The getWord options.
 */
public class GetWordOptions extends GenericModel {

  private String customizationId;
  private String wordName;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String wordName;

    private Builder(GetWordOptions getWordOptions) {
      customizationId = getWordOptions.customizationId;
      wordName = getWordOptions.wordName;
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
     * @param wordName the wordName
     */
    public Builder(String customizationId, String wordName) {
      this.customizationId = customizationId;
      this.wordName = wordName;
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
     * Set the wordName.
     *
     * @param wordName the wordName
     * @return the GetWordOptions builder
     */
    public Builder wordName(String wordName) {
      this.wordName = wordName;
      return this;
    }
  }

  private GetWordOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    Validator.notEmpty(builder.wordName, "wordName cannot be empty");
    customizationId = builder.customizationId;
    wordName = builder.wordName;
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
   * The customization ID (GUID) of the custom language model that is to be used for the request. You must make the
   * request with service credentials created for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the wordName.
   *
   * The custom word that is to be read from the custom language model. URL-encode the word if it includes non-ASCII
   * characters. For more information, see [Character
   * encoding](/docs/services/speech-to-text/language-resource.html#charEncoding).
   *
   * @return the wordName
   */
  public String wordName() {
    return wordName;
  }
}

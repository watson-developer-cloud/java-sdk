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
 * The addWord options.
 */
public class AddWordOptions extends GenericModel {

  /**
   * The type of the input.
   */
  public interface ContentType {
    /** application/json. */
    String APPLICATION_JSON = "application/json";
  }

  private String customizationId;
  private String wordName;
  private String contentType;
  private CustomWord customWord;
  private String body;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String wordName;
    private String contentType;
    private CustomWord customWord;
    private String body;

    private Builder(AddWordOptions addWordOptions) {
      customizationId = addWordOptions.customizationId;
      wordName = addWordOptions.wordName;
      contentType = addWordOptions.contentType;
      customWord = addWordOptions.customWord;
      body = addWordOptions.body;
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
     * Builds a AddWordOptions.
     *
     * @return the addWordOptions
     */
    public AddWordOptions build() {
      return new AddWordOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the AddWordOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the wordName.
     *
     * @param wordName the wordName
     * @return the AddWordOptions builder
     */
    public Builder wordName(String wordName) {
      this.wordName = wordName;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the AddWordOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the customWord.
     *
     * @param customWord the customWord
     * @return the AddWordOptions builder
     */
    public Builder customWord(CustomWord customWord) {
      this.customWord = customWord;
      this.contentType = AddWordOptions.ContentType.APPLICATION_JSON;
      return this;
    }
  }

  private AddWordOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    Validator.notEmpty(builder.wordName, "wordName cannot be empty");
    Validator.isTrue(builder.contentType != null, "contentType cannot be null");
    customizationId = builder.customizationId;
    wordName = builder.wordName;
    contentType = builder.contentType;
    customWord = builder.customWord;
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a AddWordOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The GUID of the custom language model to which a word is to be added. You must make the request with service
   * credentials created for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the wordName.
   *
   * The custom word that is to be added to or updated in the custom model. Do not include spaces in the word. Use a -
   * (dash) or _ (underscore) to connect the tokens of compound words.
   *
   * @return the wordName
   */
  public String wordName() {
    return wordName;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the customWord.
   *
   * A `CustomWord` object that provides information about the specified custom word. Specify an empty JSON object to
   * add a word with no sounds-like or display-as information.
   *
   * @return the customWord
   */
  public CustomWord customWord() {
    return customWord;
  }

  /**
   * Gets the body.
   *
   * A `CustomWord` object that provides information about the specified custom word. Specify an empty JSON object to
   * add a word with no sounds-like or display-as information.
   *
   * @return the body
   */
  public String body() {
    return body;
  }
}

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
 * The addWords options.
 */
public class AddWordsOptions extends GenericModel {

  /**
   * The type of the input.
   */
  public interface ContentType {
    /** application/json. */
    String APPLICATION_JSON = "application/json";
  }

  private String customizationId;
  private String contentType;
  private CustomWords customWords;
  private String body;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String contentType;
    private CustomWords customWords;
    private String body;

    private Builder(AddWordsOptions addWordsOptions) {
      customizationId = addWordsOptions.customizationId;
      contentType = addWordsOptions.contentType;
      customWords = addWordsOptions.customWords;
      body = addWordsOptions.body;
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
     */
    public Builder(String customizationId) {
      this.customizationId = customizationId;
    }

    /**
     * Builds a AddWordsOptions.
     *
     * @return the addWordsOptions
     */
    public AddWordsOptions build() {
      return new AddWordsOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the AddWordsOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the AddWordsOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the customWords.
     *
     * @param customWords the customWords
     * @return the AddWordsOptions builder
     */
    public Builder customWords(CustomWords customWords) {
      this.customWords = customWords;
      this.contentType = AddWordsOptions.ContentType.APPLICATION_JSON;
      return this;
    }
  }

  private AddWordsOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    Validator.isTrue(builder.contentType != null, "contentType cannot be null");
    customizationId = builder.customizationId;
    contentType = builder.contentType;
    customWords = builder.customWords;
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a AddWordsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The GUID of the custom language model to which words are to be added. You must make the request with service
   * credentials created for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
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
   * Gets the customWords.
   *
   * A `CustomWords` object that provides information about one or more custom words that are to be added to or updated
   * in the custom language model.
   *
   * @return the customWords
   */
  public CustomWords customWords() {
    return customWords;
  }

  /**
   * Gets the body.
   *
   * A `CustomWords` object that provides information about one or more custom words that are to be added to or updated
   * in the custom language model.
   *
   * @return the body
   */
  public String body() {
    return body;
  }
}

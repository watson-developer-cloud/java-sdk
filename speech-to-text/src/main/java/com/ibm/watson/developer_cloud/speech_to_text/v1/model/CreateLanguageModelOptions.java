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
 * The createLanguageModel options.
 */
public class CreateLanguageModelOptions extends GenericModel {

  /**
   * The type of the input.
   */
  public interface ContentType {
    /** application/json. */
    String APPLICATION_JSON = "application/json";
  }

  private String contentType;
  private CreateLanguageModel createLanguageModel;
  private String body;

  /**
   * Builder.
   */
  public static class Builder {
    private String contentType;
    private CreateLanguageModel createLanguageModel;
    private String body;

    private Builder(CreateLanguageModelOptions createLanguageModelOptions) {
      contentType = createLanguageModelOptions.contentType;
      createLanguageModel = createLanguageModelOptions.createLanguageModel;
      body = createLanguageModelOptions.body;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateLanguageModelOptions.
     *
     * @return the createLanguageModelOptions
     */
    public CreateLanguageModelOptions build() {
      return new CreateLanguageModelOptions(this);
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the CreateLanguageModelOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the createLanguageModel.
     *
     * @param createLanguageModel the createLanguageModel
     * @return the CreateLanguageModelOptions builder
     */
    public Builder createLanguageModel(CreateLanguageModel createLanguageModel) {
      this.createLanguageModel = createLanguageModel;
      this.contentType = CreateLanguageModelOptions.ContentType.APPLICATION_JSON;
      return this;
    }
  }

  private CreateLanguageModelOptions(Builder builder) {
    Validator.isTrue(builder.contentType != null, "contentType cannot be null");
    contentType = builder.contentType;
    createLanguageModel = builder.createLanguageModel;
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a CreateLanguageModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the createLanguageModel.
   *
   * A `CreateLanguageModel` object that provides basic information about the new custom language model.
   *
   * @return the createLanguageModel
   */
  public CreateLanguageModel createLanguageModel() {
    return createLanguageModel;
  }

  /**
   * Gets the body.
   *
   * A `CreateLanguageModel` object that provides basic information about the new custom language model.
   *
   * @return the body
   */
  public String body() {
    return body;
  }
}

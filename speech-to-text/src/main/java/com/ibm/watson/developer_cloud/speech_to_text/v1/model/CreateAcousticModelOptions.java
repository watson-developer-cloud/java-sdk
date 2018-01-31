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
 * The createAcousticModel options.
 */
public class CreateAcousticModelOptions extends GenericModel {

  /**
   * The type of the input.
   */
  public interface ContentType {
    /** application/json. */
    String APPLICATION_JSON = "application/json";
  }

  private String contentType;
  private CreateAcousticModel createAcousticModel;
  private String body;

  /**
   * Builder.
   */
  public static class Builder {
    private String contentType;
    private CreateAcousticModel createAcousticModel;
    private String body;

    private Builder(CreateAcousticModelOptions createAcousticModelOptions) {
      contentType = createAcousticModelOptions.contentType;
      createAcousticModel = createAcousticModelOptions.createAcousticModel;
      body = createAcousticModelOptions.body;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateAcousticModelOptions.
     *
     * @return the createAcousticModelOptions
     */
    public CreateAcousticModelOptions build() {
      return new CreateAcousticModelOptions(this);
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the CreateAcousticModelOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the createAcousticModel.
     *
     * @param createAcousticModel the createAcousticModel
     * @return the CreateAcousticModelOptions builder
     */
    public Builder createAcousticModel(CreateAcousticModel createAcousticModel) {
      this.createAcousticModel = createAcousticModel;
      this.contentType = CreateAcousticModelOptions.ContentType.APPLICATION_JSON;
      return this;
    }
  }

  private CreateAcousticModelOptions(Builder builder) {
    Validator.isTrue(builder.contentType != null, "contentType cannot be null");
    contentType = builder.contentType;
    createAcousticModel = builder.createAcousticModel;
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a CreateAcousticModelOptions builder
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
   * Gets the createAcousticModel.
   *
   * A `CreateAcousticModel` object that provides basic information about the new custom acoustic model.
   *
   * @return the createAcousticModel
   */
  public CreateAcousticModel createAcousticModel() {
    return createAcousticModel;
  }

  /**
   * Gets the body.
   *
   * A `CreateAcousticModel` object that provides basic information about the new custom acoustic model.
   *
   * @return the body
   */
  public String body() {
    return body;
  }
}

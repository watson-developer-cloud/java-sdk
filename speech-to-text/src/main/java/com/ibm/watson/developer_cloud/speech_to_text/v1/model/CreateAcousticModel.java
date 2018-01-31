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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * CreateAcousticModel.
 */
public class CreateAcousticModel extends GenericModel {

  private String name;
  @SerializedName("base_model_name")
  private String baseModelName;
  private String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String baseModelName;
    private String description;

    private Builder(CreateAcousticModel createAcousticModel) {
      name = createAcousticModel.name;
      baseModelName = createAcousticModel.baseModelName;
      description = createAcousticModel.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param baseModelName the baseModelName
     */
    public Builder(String name, String baseModelName) {
      this.name = name;
      this.baseModelName = baseModelName;
    }

    /**
     * Builds a CreateAcousticModel.
     *
     * @return the createAcousticModel
     */
    public CreateAcousticModel build() {
      return new CreateAcousticModel(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateAcousticModel builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the baseModelName.
     *
     * @param baseModelName the baseModelName
     * @return the CreateAcousticModel builder
     */
    public Builder baseModelName(String baseModelName) {
      this.baseModelName = baseModelName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateAcousticModel builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  private CreateAcousticModel(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    Validator.notNull(builder.baseModelName, "baseModelName cannot be null");
    name = builder.name;
    baseModelName = builder.baseModelName;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateAcousticModel builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * A user-defined name for the new custom acoustic model. Use a name that is unique among all custom acoustic models
   * that you own. Use a localized name that matches the language of the custom model. Use a name that describes the
   * acoustic environment of the custom model, such as `Mobile custom model` or `Noisy car custom model`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the baseModelName.
   *
   * The name of the base language model that is to be customized by the new custom acoustic model. The new custom model
   * can be used only with the base model that it customizes. To determine whether a base model supports acoustic model
   * customization, refer to [Language support for
   * customization](https://console.bluemix.net/docs/services/speech-to-text/custom.html#languageSupport).
   *
   * @return the baseModelName
   */
  public String baseModelName() {
    return baseModelName;
  }

  /**
   * Gets the description.
   *
   * A description of the new custom acoustic model. Use a localized description that matches the language of the custom
   * model.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

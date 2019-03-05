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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listAcousticModels options.
 */
public class ListAcousticModelsOptions extends GenericModel {

  private String language;

  /**
   * Builder.
   */
  public static class Builder {
    private String language;

    private Builder(ListAcousticModelsOptions listAcousticModelsOptions) {
      language = listAcousticModelsOptions.language;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListAcousticModelsOptions.
     *
     * @return the listAcousticModelsOptions
     */
    public ListAcousticModelsOptions build() {
      return new ListAcousticModelsOptions(this);
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the ListAcousticModelsOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }
  }

  private ListAcousticModelsOptions(Builder builder) {
    language = builder.language;
  }

  /**
   * New builder.
   *
   * @return a ListAcousticModelsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the language.
   *
   * The identifier of the language for which custom language or custom acoustic models are to be returned (for example,
   * `en-US`). Omit the parameter to see all custom language or custom acoustic models that are owned by the requesting
   * credentials.
   *
   * @return the language
   */
  public String language() {
    return language;
  }
}

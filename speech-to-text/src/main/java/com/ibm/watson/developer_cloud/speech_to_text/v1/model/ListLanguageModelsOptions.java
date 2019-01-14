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

/**
 * The listLanguageModels options.
 */
public class ListLanguageModelsOptions extends GenericModel {

  private String language;

  /**
   * Builder.
   */
  public static class Builder {
    private String language;

    private Builder(ListLanguageModelsOptions listLanguageModelsOptions) {
      language = listLanguageModelsOptions.language;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListLanguageModelsOptions.
     *
     * @return the listLanguageModelsOptions
     */
    public ListLanguageModelsOptions build() {
      return new ListLanguageModelsOptions(this);
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the ListLanguageModelsOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }
  }

  private ListLanguageModelsOptions(Builder builder) {
    language = builder.language;
  }

  /**
   * New builder.
   *
   * @return a ListLanguageModelsOptions builder
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

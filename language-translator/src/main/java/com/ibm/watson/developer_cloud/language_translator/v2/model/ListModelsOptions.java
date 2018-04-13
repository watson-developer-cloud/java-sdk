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
package com.ibm.watson.developer_cloud.language_translator.v2.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The listModels options.
 */
public class ListModelsOptions extends GenericModel {

  private String source;
  private String target;
  private Boolean defaultModels;

  /**
   * Builder.
   */
  public static class Builder {
    private String source;
    private String target;
    private Boolean defaultModels;

    private Builder(ListModelsOptions listModelsOptions) {
      source = listModelsOptions.source;
      target = listModelsOptions.target;
      defaultModels = listModelsOptions.defaultModels;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListModelsOptions.
     *
     * @return the listModelsOptions
     */
    public ListModelsOptions build() {
      return new ListModelsOptions(this);
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the ListModelsOptions builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the ListModelsOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the defaultModels.
     *
     * @param defaultModels the defaultModels
     * @return the ListModelsOptions builder
     */
    public Builder defaultModels(Boolean defaultModels) {
      this.defaultModels = defaultModels;
      return this;
    }
  }

  private ListModelsOptions(Builder builder) {
    source = builder.source;
    target = builder.target;
    defaultModels = builder.defaultModels;
  }

  /**
   * New builder.
   *
   * @return a ListModelsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the source.
   *
   * Specify a language code to filter results by source language.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the target.
   *
   * Specify a language code to filter results by target language.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the defaultModels.
   *
   * If the default parameter isn't specified, the service will return all models (default and non-default) for each
   * language pair. To return only default models, set this to `true`. To return only non-default models, set this to
   * `false`.
   *
   * @return the defaultModels
   */
  public Boolean defaultModels() {
    return defaultModels;
  }
}

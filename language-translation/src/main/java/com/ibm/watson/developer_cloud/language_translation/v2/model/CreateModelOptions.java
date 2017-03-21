/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

package com.ibm.watson.developer_cloud.language_translation.v2.model;

import java.io.File;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;

/**
 * Model Options when using the {@link LanguageTranslation#createModel(CreateModelOptions)} method.
 *
 */
public class CreateModelOptions {

  /**
   * Builder.
   */
  public static class Builder {
    private String baseModelId;
    private File forcedGlossary;
    private File monolingualCorpus;
    private String name;
    private File parallelCorpus;

    private Builder(CreateModelOptions options) {
      name = options.name;
      baseModelId = options.baseModelId;
      parallelCorpus = options.parallelCorpus;
      monolingualCorpus = options.monolingualCorpus;
      forcedGlossary = options.forcedGlossary;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Base model id.
     *
     * @param baseModelId the base model id
     * @return the creates the model options
     */
    public Builder baseModelId(String baseModelId) {
      this.baseModelId = baseModelId;
      return this;
    }

    /**
     * Builds the model creation options.
     *
     * @return the model creation options
     */
    public CreateModelOptions build() {
      return new CreateModelOptions(this);
    }

    /**
     * With forced glossary.
     *
     * @param forcedGlossary the forced glossary
     * @return the creates the model options
     */
    public Builder forcedGlossary(File forcedGlossary) {
      this.forcedGlossary = forcedGlossary;
      return this;
    }

    /**
     * Sets the monolingual corpus.
     *
     * @param monolingualCorpus the monolingual corpus
     * @return the creates the model options
     */
    public Builder monolingualCorpus(File monolingualCorpus) {
      this.monolingualCorpus = monolingualCorpus;
      return this;
    }

    /**
     * Sets the name.
     *
     * @param name the name
     * @return the profile options
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Sets the parallel corpus.
     *
     * @param parallelCorpus the parallel corpus
     * @return the creates the model options
     */
    public Builder parallelCorpus(File parallelCorpus) {
      this.parallelCorpus = parallelCorpus;
      return this;
    }
  }

  private String baseModelId;
  private File forcedGlossary;
  private File monolingualCorpus;
  private String name;
  private File parallelCorpus;

  private CreateModelOptions(Builder builder) {
    baseModelId = builder.baseModelId;
    forcedGlossary = builder.forcedGlossary;
    parallelCorpus = builder.parallelCorpus;
    name = builder.name;
    monolingualCorpus = builder.monolingualCorpus;
  }

  /**
   * Gets the base model id.
   *
   * @return the baseModelId
   */
  public String baseModelId() {
    return baseModelId;
  }

  /**
   * Gets the forced glossary.
   *
   * @return the forcedGlossary
   */
  public File forcedGlossary() {
    return forcedGlossary;
  }

  /**
   * Gets the monolingual corpus.
   *
   * @return the monolingualCorpus
   */
  public File monolingualCorpus() {
    return monolingualCorpus;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the parallel corpus.
   *
   * @return the parallelCorpus
   */
  public File parallelCorpus() {
    return parallelCorpus;
  }

}


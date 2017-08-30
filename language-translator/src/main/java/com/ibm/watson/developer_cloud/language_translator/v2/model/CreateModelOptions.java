/*
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
package com.ibm.watson.developer_cloud.language_translator.v2.model;

import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createModel options.
 */
public class CreateModelOptions extends GenericModel {

  private String baseModelId;
  private String name;
  private InputStream forcedGlossary;
  private InputStream parallelCorpus;
  private InputStream monolingualCorpus;

  /**
   * Builder.
   */
  public static class Builder {
    private String baseModelId;
    private String name;
    private InputStream forcedGlossary;
    private InputStream parallelCorpus;
    private InputStream monolingualCorpus;

    private Builder(CreateModelOptions createModelOptions) {
      baseModelId = createModelOptions.baseModelId;
      name = createModelOptions.name;
      forcedGlossary = createModelOptions.forcedGlossary;
      parallelCorpus = createModelOptions.parallelCorpus;
      monolingualCorpus = createModelOptions.monolingualCorpus;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param baseModelId the baseModelId
     */
    public Builder(String baseModelId) {
      this.baseModelId = baseModelId;
    }

    /**
     * Builds a CreateModelOptions.
     *
     * @return the createModelOptions
     */
    public CreateModelOptions build() {
      return new CreateModelOptions(this);
    }

    /**
     * Set the baseModelId.
     *
     * @param baseModelId the baseModelId
     * @return the CreateModelOptions builder
     */
    public Builder baseModelId(String baseModelId) {
      this.baseModelId = baseModelId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the forcedGlossary.
     *
     * @param forcedGlossary the forcedGlossary
     * @return the CreateModelOptions builder
     */
    public Builder forcedGlossary(InputStream forcedGlossary) {
      this.forcedGlossary = forcedGlossary;
      return this;
    }

    /**
     * Set the parallelCorpus.
     *
     * @param parallelCorpus the parallelCorpus
     * @return the CreateModelOptions builder
     */
    public Builder parallelCorpus(InputStream parallelCorpus) {
      this.parallelCorpus = parallelCorpus;
      return this;
    }

    /**
     * Set the monolingualCorpus.
     *
     * @param monolingualCorpus the monolingualCorpus
     * @return the CreateModelOptions builder
     */
    public Builder monolingualCorpus(InputStream monolingualCorpus) {
      this.monolingualCorpus = monolingualCorpus;
      return this;
    }
  }

  private CreateModelOptions(Builder builder) {
    Validator.notNull(builder.baseModelId, "baseModelId cannot be null");
    baseModelId = builder.baseModelId;
    name = builder.name;
    forcedGlossary = builder.forcedGlossary;
    parallelCorpus = builder.parallelCorpus;
    monolingualCorpus = builder.monolingualCorpus;
  }

  /**
   * New builder.
   *
   * @return a CreateModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the baseModelId.
   *
   * Specifies the domain model that is used as the base for the training. To see current supported domain models, use
   * the GET /v2/models parameter.
   *
   * @return the baseModelId
   */
  public String baseModelId() {
    return baseModelId;
  }

  /**
   * Gets the name.
   *
   * The model name. Valid characters are letters, numbers, -, and _. No spaces.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the forcedGlossary.
   *
   * A TMX file with your customizations. The customizations in the file completely overwrite the domain data
   * translation, including high frequency or high confidence phrase translations. You can upload only one glossary with
   * a file size less than 10 MB per call.
   *
   * @return the forcedGlossary
   */
  public InputStream forcedGlossary() {
    return forcedGlossary;
  }

  /**
   * Gets the parallelCorpus.
   *
   * A TMX file that contains entries that are treated as a parallel corpus instead of a glossary.
   *
   * @return the parallelCorpus
   */
  public InputStream parallelCorpus() {
    return parallelCorpus;
  }

  /**
   * Gets the monolingualCorpus.
   *
   * A UTF-8 encoded plain text file that is used to customize the target language model.
   *
   * @return the monolingualCorpus
   */
  public InputStream monolingualCorpus() {
    return monolingualCorpus;
  }
}

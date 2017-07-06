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
 * the createModel options.
 */
public class CreateModelOptions extends GenericModel {

  private String baseModelId;
  private String name;
  private InputStream forcedGlossary;
  private String forcedGlossaryMediaType;
  private InputStream parallelCorpus;
  private String parallelCorpusMediaType;
  private InputStream monolingualCorpus;
  private String monolingualCorpusMediaType;

  /**
   * Builder.
   */
  public static class Builder {
    private String baseModelId;
    private String name;
    private InputStream forcedGlossary;
    private String forcedGlossaryMediaType;
    private InputStream parallelCorpus;
    private String parallelCorpusMediaType;
    private InputStream monolingualCorpus;
    private String monolingualCorpusMediaType;

    private Builder(CreateModelOptions createModelOptions) {
      baseModelId = createModelOptions.baseModelId;
      name = createModelOptions.name;
      forcedGlossary = createModelOptions.forcedGlossary;
      forcedGlossaryMediaType = createModelOptions.forcedGlossaryMediaType;
      parallelCorpus = createModelOptions.parallelCorpus;
      parallelCorpusMediaType = createModelOptions.parallelCorpusMediaType;
      monolingualCorpus = createModelOptions.monolingualCorpus;
      monolingualCorpusMediaType = createModelOptions.monolingualCorpusMediaType;
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
     * Set the forcedGlossaryMediaType.
     *
     * @param forcedGlossaryMediaType the forcedGlossaryMediaType
     * @return the CreateModelOptions builder
     */
    public Builder forcedGlossaryMediaType(String forcedGlossaryMediaType) {
      this.forcedGlossaryMediaType = forcedGlossaryMediaType;
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
     * Set the parallelCorpusMediaType.
     *
     * @param parallelCorpusMediaType the parallelCorpusMediaType
     * @return the CreateModelOptions builder
     */
    public Builder parallelCorpusMediaType(String parallelCorpusMediaType) {
      this.parallelCorpusMediaType = parallelCorpusMediaType;
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

    /**
     * Set the monolingualCorpusMediaType.
     *
     * @param monolingualCorpusMediaType the monolingualCorpusMediaType
     * @return the CreateModelOptions builder
     */
    public Builder monolingualCorpusMediaType(String monolingualCorpusMediaType) {
      this.monolingualCorpusMediaType = monolingualCorpusMediaType;
      return this;
    }
  }

  private CreateModelOptions(Builder builder) {
    Validator.notNull(builder.baseModelId, "baseModelId cannot be null");
    baseModelId = builder.baseModelId;
    name = builder.name;
    forcedGlossary = builder.forcedGlossary;
    forcedGlossaryMediaType = builder.forcedGlossaryMediaType;
    parallelCorpus = builder.parallelCorpus;
    parallelCorpusMediaType = builder.parallelCorpusMediaType;
    monolingualCorpus = builder.monolingualCorpus;
    monolingualCorpusMediaType = builder.monolingualCorpusMediaType;
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
   * Gets the forcedGlossaryMediaType.
   *
   * the media type of forcedGlossary.
   *
   * @return the forcedGlossaryMediaType
   */
  public String forcedGlossaryMediaType() {
    return forcedGlossaryMediaType;
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
   * Gets the parallelCorpusMediaType.
   *
   * the media type of parallelCorpus.
   *
   * @return the parallelCorpusMediaType
   */
  public String parallelCorpusMediaType() {
    return parallelCorpusMediaType;
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

  /**
   * Gets the monolingualCorpusMediaType.
   *
   * the media type of monolingualCorpus.
   *
   * @return the monolingualCorpusMediaType
   */
  public String monolingualCorpusMediaType() {
    return monolingualCorpusMediaType;
  }
}

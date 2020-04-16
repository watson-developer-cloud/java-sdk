/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The createModel options. */
public class CreateModelOptions extends GenericModel {

  protected String baseModelId;
  protected InputStream forcedGlossary;
  protected InputStream parallelCorpus;
  protected String name;

  /** Builder. */
  public static class Builder {
    private String baseModelId;
    private InputStream forcedGlossary;
    private InputStream parallelCorpus;
    private String name;

    private Builder(CreateModelOptions createModelOptions) {
      this.baseModelId = createModelOptions.baseModelId;
      this.forcedGlossary = createModelOptions.forcedGlossary;
      this.parallelCorpus = createModelOptions.parallelCorpus;
      this.name = createModelOptions.name;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder forcedGlossary(File forcedGlossary) throws FileNotFoundException {
      this.forcedGlossary = new FileInputStream(forcedGlossary);
      return this;
    }

    /**
     * Set the parallelCorpus.
     *
     * @param parallelCorpus the parallelCorpus
     * @return the CreateModelOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder parallelCorpus(File parallelCorpus) throws FileNotFoundException {
      this.parallelCorpus = new FileInputStream(parallelCorpus);
      return this;
    }
  }

  protected CreateModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.baseModelId, "baseModelId cannot be null");
    baseModelId = builder.baseModelId;
    forcedGlossary = builder.forcedGlossary;
    parallelCorpus = builder.parallelCorpus;
    name = builder.name;
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
   * <p>The model ID of the model to use as the base for customization. To see available models, use
   * the `List models` method. Usually all IBM provided models are customizable. In addition, all
   * your models that have been created via parallel corpus customization, can be further customized
   * with a forced glossary.
   *
   * @return the baseModelId
   */
  public String baseModelId() {
    return baseModelId;
  }

  /**
   * Gets the forcedGlossary.
   *
   * <p>A TMX file with your customizations. The customizations in the file completely overwrite the
   * domain translaton data, including high frequency or high confidence phrase translations. You
   * can upload only one glossary with a file size less than 10 MB per call. A forced glossary
   * should contain single words or short phrases.
   *
   * @return the forcedGlossary
   */
  public InputStream forcedGlossary() {
    return forcedGlossary;
  }

  /**
   * Gets the parallelCorpus.
   *
   * <p>A TMX file with parallel sentences for source and target language. You can upload multiple
   * parallel_corpus files in one request. All uploaded parallel_corpus files combined, your
   * parallel corpus must contain at least 5,000 parallel sentences to train successfully.
   *
   * @return the parallelCorpus
   */
  public InputStream parallelCorpus() {
    return parallelCorpus;
  }

  /**
   * Gets the name.
   *
   * <p>An optional model name that you can use to identify the model. Valid characters are letters,
   * numbers, dashes, underscores, spaces and apostrophes. The maximum length is 32 characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

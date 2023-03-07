/*
 * (C) Copyright IBM Corp. 2023.
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
  protected String forcedGlossaryContentType;
  protected InputStream parallelCorpus;
  protected String parallelCorpusContentType;
  protected String name;

  /** Builder. */
  public static class Builder {
    private String baseModelId;
    private InputStream forcedGlossary;
    private String forcedGlossaryContentType;
    private InputStream parallelCorpus;
    private String parallelCorpusContentType;
    private String name;

    /**
     * Instantiates a new Builder from an existing CreateModelOptions instance.
     *
     * @param createModelOptions the instance to initialize the Builder with
     */
    private Builder(CreateModelOptions createModelOptions) {
      this.baseModelId = createModelOptions.baseModelId;
      this.forcedGlossary = createModelOptions.forcedGlossary;
      this.forcedGlossaryContentType = createModelOptions.forcedGlossaryContentType;
      this.parallelCorpus = createModelOptions.parallelCorpus;
      this.parallelCorpusContentType = createModelOptions.parallelCorpusContentType;
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
     * @return the new CreateModelOptions instance
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
     * Set the forcedGlossaryContentType.
     *
     * @param forcedGlossaryContentType the forcedGlossaryContentType
     * @return the CreateModelOptions builder
     */
    public Builder forcedGlossaryContentType(String forcedGlossaryContentType) {
      this.forcedGlossaryContentType = forcedGlossaryContentType;
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
     * Set the parallelCorpusContentType.
     *
     * @param parallelCorpusContentType the parallelCorpusContentType
     * @return the CreateModelOptions builder
     */
    public Builder parallelCorpusContentType(String parallelCorpusContentType) {
      this.parallelCorpusContentType = parallelCorpusContentType;
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

  protected CreateModelOptions() {}

  protected CreateModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.baseModelId, "baseModelId cannot be null");
    baseModelId = builder.baseModelId;
    forcedGlossary = builder.forcedGlossary;
    forcedGlossaryContentType = builder.forcedGlossaryContentType;
    parallelCorpus = builder.parallelCorpus;
    parallelCorpusContentType = builder.parallelCorpusContentType;
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
   * <p>The ID of the translation model to use as the base for customization. To see available
   * models and IDs, use the `List models` method. Most models that are provided with the service
   * are customizable. In addition, all models that you create with parallel corpora customization
   * can be further customized with a forced glossary.
   *
   * @return the baseModelId
   */
  public String baseModelId() {
    return baseModelId;
  }

  /**
   * Gets the forcedGlossary.
   *
   * <p>A file with forced glossary terms for the source and target languages. The customizations in
   * the file completely overwrite the domain translation data, including high frequency or high
   * confidence phrase translations.
   *
   * <p>You can upload only one glossary file for a custom model, and the glossary can have a
   * maximum size of 10 MB. A forced glossary must contain single words or short phrases. For more
   * information, see **Supported file formats** in the method description.
   *
   * <p>*With `curl`, use `--form forced_glossary=@{filename}`.*.
   *
   * @return the forcedGlossary
   */
  public InputStream forcedGlossary() {
    return forcedGlossary;
  }

  /**
   * Gets the forcedGlossaryContentType.
   *
   * <p>The content type of forcedGlossary. Values for this parameter can be obtained from the
   * HttpMediaType class.
   *
   * @return the forcedGlossaryContentType
   */
  public String forcedGlossaryContentType() {
    return forcedGlossaryContentType;
  }

  /**
   * Gets the parallelCorpus.
   *
   * <p>A file with parallel sentences for the source and target languages. You can upload multiple
   * parallel corpus files in one request by repeating the parameter. All uploaded parallel corpus
   * files combined must contain at least 5000 parallel sentences to train successfully. You can
   * provide a maximum of 500,000 parallel sentences across all corpora.
   *
   * <p>A single entry in a corpus file can contain a maximum of 80 words. All corpora files for a
   * custom model can have a cumulative maximum size of 250 MB. For more information, see
   * **Supported file formats** in the method description.
   *
   * <p>*With `curl`, use `--form parallel_corpus=@{filename}`.*.
   *
   * @return the parallelCorpus
   */
  public InputStream parallelCorpus() {
    return parallelCorpus;
  }

  /**
   * Gets the parallelCorpusContentType.
   *
   * <p>The content type of parallelCorpus. Values for this parameter can be obtained from the
   * HttpMediaType class.
   *
   * @return the parallelCorpusContentType
   */
  public String parallelCorpusContentType() {
    return parallelCorpusContentType;
  }

  /**
   * Gets the name.
   *
   * <p>An optional model name that you can use to identify the model. Valid characters are letters,
   * numbers, dashes, underscores, spaces, and apostrophes. The maximum length of the name is 32
   * characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

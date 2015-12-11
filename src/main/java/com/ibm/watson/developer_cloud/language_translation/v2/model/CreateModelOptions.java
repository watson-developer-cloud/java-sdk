/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.language_translation.v2.model;

import java.io.File;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Model Options when using the {@link LanguageTranslation#createModel(CreateModelOptions)} method.
 * 
 */
public class CreateModelOptions extends GenericModel {

  private String baseModelId;

  private File forcedGlossary;

  private File monolingualCorpus;

  private String name;

  private File parallelCorpus;

  /**
   * Instantiates a new creates the model options.
   */
  public CreateModelOptions() {}


  /**
   * Instantiates a new creates the model options.
   * 
   * @param name the name
   * @param baseModelId the base model id
   */
  public CreateModelOptions(String name, String baseModelId) {
    super();
    this.name = name;
    this.baseModelId = baseModelId;
  }


  /**
   * Base model id.
   * 
   * @param baseModelId the base model id
   * @return the creates the model options
   */
  public CreateModelOptions baseModelId(String baseModelId) {
    this.baseModelId = baseModelId;
    return this;
  }

  /**
   * With forced glossary.
   * 
   * @param forcedGlossary the forced glossary
   * @return the creates the model options
   */
  public CreateModelOptions forcedGlossary(File forcedGlossary) {
    this.forcedGlossary = forcedGlossary;
    return this;
  }

  /**
   * Gets the base model id.
   * 
   * @return the baseModelId
   */
  public String getBaseModelId() {
    return baseModelId;
  }

  /**
   * Gets the forced glossary.
   * 
   * @return the forcedGlossary
   */
  public File getForcedGlossary() {
    return forcedGlossary;
  }

  /**
   * Gets the monolingual corpus.
   * 
   * @return the monolingualCorpus
   */
  public File getMonolingualCorpus() {
    return monolingualCorpus;
  }

  /**
   * Gets the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the parallel corpus.
   * 
   * @return the parallelCorpus
   */
  public File getParallelCorpus() {
    return parallelCorpus;
  }

  /**
   * With monolingual corpus.
   * 
   * @param monolingualCorpus the monolingual corpus
   * @return the creates the model options
   */
  public CreateModelOptions monolingualCorpus(File monolingualCorpus) {
    this.monolingualCorpus = monolingualCorpus;
    return this;
  }

  /**
   * Name.
   * 
   * @param name the name
   * @return the profile options
   */
  public CreateModelOptions name(String name) {
    this.name = name;
    return this;
  }

  /**
   * With parallel corpus.
   * 
   * @param parallelCorpus the parallel corpus
   * @return the creates the model options
   */
  public CreateModelOptions parallelCorpus(File parallelCorpus) {
    this.parallelCorpus = parallelCorpus;
    return this;
  }

  /**
   * Sets the base model id.
   * 
   * @param baseModelId the baseModelId to set
   */
  public void setBaseModelId(String baseModelId) {
    this.baseModelId = baseModelId;
  }

  /**
   * Sets the forced glossary.
   * 
   * @param forcedGlossary the forcedGlossary to set
   */
  public void setForcedGlossary(File forcedGlossary) {
    this.forcedGlossary = forcedGlossary;
  }

  /**
   * Sets the monolingual corpus.
   * 
   * @param monolingualCorpus the monolingualCorpus to set
   */
  public void setMonolingualCorpus(File monolingualCorpus) {
    this.monolingualCorpus = monolingualCorpus;
  }

  /**
   * Sets the name.
   * 
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the parallel corpus.
   * 
   * @param parallelCorpus the parallelCorpus to set
   */
  public void setParallelCorpus(File parallelCorpus) {
    this.parallelCorpus = parallelCorpus;
  }

}
